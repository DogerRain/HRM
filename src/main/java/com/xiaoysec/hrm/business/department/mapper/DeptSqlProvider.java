package com.xiaoysec.hrm.business.department.mapper;

import static com.xiaoysec.hrm.common.global.Constants.DEPARTMENTTABLE;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.xiaoysec.hrm.business.department.entity.Department;

public class DeptSqlProvider {
	
	//分页查询
	public String selectWithParm(final Map<String,Object> parm){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(DEPARTMENTTABLE);
				if(parm.get("name")!=null){
					String name = (String) parm.get("name");
					if(!StringUtils.isBlank(name)){
						WHERE(" name like "+"CONCAT('%',#{name},'%')" );
					}
				}
			}
		}.toString();
		if(parm.get("size") != null && parm.get("start") != null){
			int size = (Integer) parm.get("size");
			int start = (Integer) parm.get("start");
			sql += " limit #{start},#{size}";
		}
		return sql;
	} 
	
	public String getDeptCount(final Map<String,Object> parm){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(DEPARTMENTTABLE);
				String mode = null;
				if(parm.get("mode")!=null)
					mode = (String) parm.get("mode");
				if(parm.get("name") != null){
					String name = (String) parm.get("name");
					if(!StringUtils.isBlank(name)){
						if("like".equals(mode))
							WHERE(" name like "+"CONCAT('%',#{name},'%')" );
						if("equals".equals(mode))
							WHERE(" name=#{name} ");
					}
				}
			}
		}.toString();
	}
	
	//动态插入
	public String insertDept(final Department department){
		return new SQL(){
			{
				INSERT_INTO(DEPARTMENTTABLE);
				if(!StringUtils.isBlank(department.getName())){
					VALUES("name", "#{name}");
				}
				if(!StringUtils.isBlank(department.getRemark())){
					VALUES("remark","#{remark}");
				}
				if(department.getCreateBy() != null){
					VALUES("create_by","#{createBy.id}");
				}
				if(department.getCreateDate() != null){
					VALUES("create_date","#{createDate}");
				}
			}
		}.toString();
	}
	
	//动态修改
	public String updateDept(final Department department){
		return new SQL(){
			{
				UPDATE(DEPARTMENTTABLE);
				if(!StringUtils.isBlank(department.getName())){
					SET(" name = #{name}");
				}
				if(!StringUtils.isBlank(department.getRemark())){
					SET(" remark = #{remark}");
				}
				if(department.getUpdateBy() != null){
					SET(" update_by = #{updateBy.id}");
				}
				if(department.getUpdateDate() != null){
					SET(" update_date = #{updateDate}");
				}
				WHERE(" id = #{id}");			
			}
		}.toString();
	}
	
}
