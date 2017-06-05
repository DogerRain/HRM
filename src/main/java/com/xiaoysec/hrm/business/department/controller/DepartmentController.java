package com.xiaoysec.hrm.business.department.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoysec.hrm.business.department.entity.Department;
import com.xiaoysec.hrm.business.department.service.DepartmentService;

@Controller
@RequestMapping(value = "${adminPath}/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<Department> departmentList = departmentService.findList();
		model.addAttribute("departmentList", departmentList);
		return "departmentList";
	}

}
