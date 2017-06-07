package com.xiaoysec.hrm.business.department.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.xiaoysec.hrm.business.department.entity.Department;
import com.xiaoysec.hrm.common.base.Page;
import com.xiaoysec.hrm.common.utils.StringUtil;

import static com.xiaoysec.hrm.common.global.Constants.DEPARTMENTTABLE;

public class DeptSqlProvider {
	
	//分页查询
	public String selectWithParm(final Map<String,Object> parm){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(DEPARTMENTTABLE);
				if(parm.get("dept")!=null){
					Department department = (Department) parm.get("dept");
					if(!StringUtil.isEmpty(department.getName())){
						WHERE(" name like "+ " %"+"#{department.name}"+" %");
					}
				}
			}
		}.toString();
		if(parm.get("page") != null){
			Page page = (Page) parm.get("page");
			sql += " limit #{page.start},#{page.size}";
		}
		return sql;
	} 
	
	public String getDeptCount(final Map<String,Object> parm){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(DEPARTMENTTABLE);
				if(parm.get("dept") != null){
					Department department = (Department) parm.get("dept");
					if(!StringUtil.isEmpty(department.getName())){
						WHERE(" name like "+" %"+"#{department.name}"+"% ");
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
				if(!StringUtil.isEmpty(department.getName())){
					VALUES("name", department.getName());
				}
				if(!StringUtil.isEmpty(department.getRemark())){
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
				if(StringUtil.isEmpty(department.getName())){
					SET(" name = #{name}");
				}
				if(StringUtil.isEmpty(department.getRemark())){
					SET(" remark = #{remark}");
				}
				WHERE(" id = #{id}");			}
		}.toString();
	}

}
