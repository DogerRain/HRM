package com.xiaoysec.hrm.business.employee.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.format.annotation.DateTimeFormat;

import com.xiaoysec.hrm.business.department.entity.Department;
import com.xiaoysec.hrm.business.employee.entity.Employee;
import com.xiaoysec.hrm.business.job.entity.Job;

public interface EmployeeMapper {
	
	//动态查询总数
	@SelectProvider(type=EmployeeSqlProvider.class,method="getEmployeeCount")
	public Integer getEmployeeCount(Map<String,Object> parm);
	
	//动态查询
	@SelectProvider(type=EmployeeSqlProvider.class,method="selectWithParm")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="card_id",property="cardId"),
		@Result(column="post_code",property="postCode"),
		@Result(column="qq_num",property="qqNum"),
		@Result(column="create_date",property="createDate"),
		@Result(column="dept_id",property="department",
		 one=@One(select="com.xiaoysec.hrm.business.department.mapper.DepartmentMapper.selectDepartmentById",
		 fetchType=FetchType.EAGER)
		),
		@Result(column="job_id",property="job",
		  one=@One(select="com.xiaoysec.hrm.business.job.mapper.JobMapper.selectJobById",fetchType=FetchType.EAGER)
		),
	})
	public List<Employee> findEmployee(Map<String,Object> parm);
	
	//指定id删除
	@Delete(" delete from employee_info where id=#{id}")
	public void deleteEmployeeById(Integer id);

	//根据id查询
	@Select("select * from employee_info where id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="card_id",property="cardId"),
		@Result(column="post_code",property="postCode"),
		@Result(column="qq_num",property="qqNum"),
		@Result(column="create_date",property="createDate"),
		@Result(column="dept_id",property="department",
		 one=@One(select="com.xiaoysec.hrm.business.department.mapper.DepartmentMapper.selectDepartmentById",
		 fetchType=FetchType.EAGER)
		),
		@Result(column="job_id",property="job",
		  one=@One(select="com.xiaoysec.hrm.business.job.mapper.JobMapper.selectJobById",fetchType=FetchType.EAGER)
		),
	})
	public Employee selectEmployeeById(Integer id);
	
	//动态修改
	@UpdateProvider(type=EmployeeSqlProvider.class,method="updateEmployee")
	public void updateEmployee(Employee employee);
	
	//动态插入
	@InsertProvider(type=EmployeeSqlProvider.class,method="insertEmployee")
	public void addEmployee(Employee employee);
}
