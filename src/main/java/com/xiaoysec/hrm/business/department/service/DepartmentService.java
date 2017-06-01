package com.xiaoysec.hrm.business.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoysec.hrm.business.department.entity.Department;
import com.xiaoysec.hrm.business.department.mapper.DepartmentMapper;

@Transactional
@Service
public class DepartmentService {

	public DepartmentService(){
		System.out.println("DepartmentService");
	}
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<Department> findList(){
		return departmentMapper.findList();
	}
	
}
