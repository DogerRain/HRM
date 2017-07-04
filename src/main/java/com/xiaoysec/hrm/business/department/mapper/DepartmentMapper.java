package com.xiaoysec.hrm.business.department.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.xiaoysec.hrm.business.department.entity.Department;

public interface DepartmentMapper {
	
	@Select(" select * from dept_info ")
	public List<Department> findList();
	
	@Delete(" delete from dept_info where id=#{id} ")
	public void deleteDeptById(Integer id);
	
	@Select(" select * from dept_info where id=#{id}")
	public Department getDepartmentById(Integer id);
	
	//动态分页
	@SelectProvider(type=DeptSqlProvider.class,method="selectWithParm")
	@Results({
		@Result(column="create_date",javaType=java.util.Date.class,property="createDate",jdbcType=JdbcType.TIMESTAMP),
		@Result(column="update_date",javaType=java.util.Date.class,property="updateDate",jdbcType=JdbcType.TIMESTAMP)
	})
	public List<Department> findDept(Map<String,Object> parm);
	
	@SelectProvider(type=DeptSqlProvider.class,method="getDeptCount")
	public Integer getDeptCount(Map<String,Object> parm);
	
	//动态修改
	@UpdateProvider(type=DeptSqlProvider.class,method="updateDept")
	public void updateDept(Department department);
	
	//动态插入
	@InsertProvider(type=DeptSqlProvider.class,method="insertDept")
	public void addDepartment(Department department);

}
