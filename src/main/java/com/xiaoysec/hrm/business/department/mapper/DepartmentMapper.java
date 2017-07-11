package com.xiaoysec.hrm.business.department.mapper;

import java.util.List;
import java.util.Map;

import com.xiaoysec.hrm.business.department.entity.Department;

public interface DepartmentMapper {
	
	//查询所有
	public List<Department> findAll();
	
	//删除
	public void deleteDeptById(Integer id);
	
	//id查询
	public Department getDepartmentById(Integer id);
	
	//动态分页
	public List<Department> findDept(Map<String,Object> parm);
	
	//动态查询数量
	public Integer getDeptCount(Map<String,Object> parm);
	
	//动态修改
	public void updateDept(Department department);
	
	//动态插入
	public void addDepartment(Department department);

}
