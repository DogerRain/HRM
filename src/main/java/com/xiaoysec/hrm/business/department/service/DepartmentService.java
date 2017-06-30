package com.xiaoysec.hrm.business.department.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoysec.hrm.business.department.entity.Department;
import com.xiaoysec.hrm.business.department.mapper.DepartmentMapper;
import com.xiaoysec.hrm.common.base.Page;

@Transactional
@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	//分页查询
	public Page<Department> findList(Page<Department> page,Map<String,Object> map){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String name = (String) map.get("name");
		int start = page.getStart();
		int size = page.getSize();
		paramMap.put("start",start);
		paramMap.put("size",size);
		if(!StringUtils.isBlank(name)){
			paramMap.put("name", name);
		}
		List<Department> departmentList = departmentMapper.findDept(paramMap);
		page.setList(departmentList);
		page.setCount(departmentMapper.getDeptCount(paramMap));
		return page;
	}
	
}
