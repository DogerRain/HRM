package com.xiaoysec.hrm.business.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoysec.hrm.business.employee.service.EmployeeService;

@Controller
@RequestMapping(value="${adminPath}/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
}
