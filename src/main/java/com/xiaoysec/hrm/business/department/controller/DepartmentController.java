package com.xiaoysec.hrm.business.department.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoysec.hrm.business.department.entity.Department;
import com.xiaoysec.hrm.business.department.service.DepartmentService;
import com.xiaoysec.hrm.common.base.DataGridResultEntity;
import com.xiaoysec.hrm.common.base.Page;

@Controller
@RequestMapping(value = "${adminPath}/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/list")
	public String list(Model model) {
		return "/business/departmentList";
	}

	@RequestMapping(value = "query")
	@ResponseBody
	public DataGridResultEntity query(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		model.addAttribute("name", name);
		Page<Department> page = new Page<Department>(request);
		page = departmentService.findList(page, model.asMap());
		return new DataGridResultEntity(page.getCount(), page.getList());
	}

	@RequestMapping(value = "/form")
	public String form() {
		return "/business/departmentForm";
	}

}
