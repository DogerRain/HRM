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
					//Department department = (Department) parm.get("dept");
					String name = (String) parm.get("name");
					if(!StringUtils.isBlank(name)){
						WHERE(" name like "+"CONCAT('%',#{name},'%')" );
					}
				}
			}
		}.toString();
		if(parm.get("size") != null && parm.get("start") != null){
			//Page page = (Page) parm.get("page");
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
				if(parm.get("name") != null){
					//Department department = (Department) parm.get("dept");
					String name = (String) parm.get("name");
					if(!StringUtils.isBlank(name)){
						WHERE(" name like "+"CONCAT('%',#{name},'%')" );
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
					VALUES("name", department.getName());
				}
				if(!StringUtils.isBlank(department.getRemark())){
					VALUES("remark", department.getRemark());
				}
			}
		}.toString();
	}
	
	//动态修改
	public String updateDept(final Department department){
		return new SQL(){
			{
				UPDATE(DEPARTMENTTABLE);
				if(StringUtils.isBlank(department.getName())){
					SET(" name = #{name}");
				}
				if(StringUtils.isBlank(department.getRemark())){
					SET(" remark = #{remark}");
				}
				WHERE(" id = #{id}");			}
		}.toString();
	}

}
