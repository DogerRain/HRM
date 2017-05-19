package com.xiaoysec.hrm.business.department.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.xiaoysec.hrm.business.department.entity.Department;

public interface DepartmentMapper {
	
	@Select(" select * from dept_info ")
	public List<Department> findList();
	
	
}
