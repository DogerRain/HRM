package com.xiaoysec.hrm.business.department.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoysec.hrm.business.department.entity.Department;
import com.xiaoysec.hrm.business.department.service.DepartmentService;
import com.xiaoysec.hrm.common.base.DataGridResultEntity;

@Controller
@RequestMapping(value = "${adminPath}/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<Department> departmentList = departmentService.findList();
		model.addAttribute("departmentList", departmentList);
		return "/business/departmentList";
	}
	
	
	@RequestMapping(value = "query")
	@ResponseBody
	public DataGridResultEntity query(){
		return new DataGridResultEntity();
	}
	
	@RequestMapping(value = "/form")
	public String form(){
		return "/business/departmentForm";
	}

}
