package com.xiaoysec.hrm.business.employee.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaoysec.hrm.business.employee.entity.Employee;
import com.xiaoysec.hrm.business.employee.service.EmployeeService;
import com.xiaoysec.hrm.common.base.DataGridResultEntity;
import com.xiaoysec.hrm.common.base.Page;
import com.xiaoysec.hrm.common.utils.RaceMapper;

@Controller
@RequestMapping(value = "${adminPath}/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "list")
	public String list() {
		return "/business/employeeList";
	}

	@RequestMapping(value = "query")
	@ResponseBody
	public DataGridResultEntity query(HttpServletRequest request, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		Page<Employee> page = new Page<Employee>(request);
		page = employeeService.findList(page, map);
		return new DataGridResultEntity(page.getCount(), page.getList());
	}

	@RequestMapping(value = "form")
	public String form(Employee employee,Model model) {
		if (employee.getId() != null) {
			employee = employeeService.getEmployeeById(employee.getId());
		}
		model.addAttribute("raceMapper",RaceMapper.enumToJsonString());
		model.addAttribute("employee", employee);
		return "/business/employeeForm";
	}

	@RequestMapping(value = "delete")
	public String deleteEmployeeById(Integer id) {
		employeeService.deleteEmployeeById(id);
		return "/business/employeeList";
	}

	@RequestMapping(value = "save")
	@ResponseBody
	public Map save(Employee employee,HttpSession session,String hideCardId) {
		return employeeService.save(employee,session,hideCardId);
	}

}
