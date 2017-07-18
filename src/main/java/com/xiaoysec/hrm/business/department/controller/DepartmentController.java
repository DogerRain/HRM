package com.xiaoysec.hrm.business.department.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoysec.hrm.business.department.entity.Department;
import com.xiaoysec.hrm.business.department.service.DepartmentService;
import com.xiaoysec.hrm.business.employee.entity.Employee;
import com.xiaoysec.hrm.common.base.DataGridResultEntity;
import com.xiaoysec.hrm.common.base.Page;

@Controller
@RequestMapping(value = "${adminPath}/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("findall")
	@ResponseBody
	public List<Department> findAll() {
		return departmentService.findAll();
	}

	@RequestMapping(value = { "list", "" })
	public String list(Model model) {
		return "/business/departmentList";
	}

	@RequestMapping(value = "query")
	@ResponseBody
	public DataGridResultEntity query(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		model.addAttribute("name", name);
		model.addAttribute("mode", "like");
		Page<Department> page = new Page<Department>(request);
		page = departmentService.findList(page, model.asMap());
		return new DataGridResultEntity(page.getCount(), page.getList());
	}

	@RequestMapping(value = "form")
	public String form(Model model, Department department) {
		if (department.getId() != null) {
			department = departmentService.getDepartmentById(department.getId());
		}
		model.addAttribute("department", department);
		return "/business/departmentForm";
	}

	// TODO 创建者和修改者当前只能通过Session获取,整合shrio后再改动
	@RequestMapping(value = "save")
	@ResponseBody
	public Map save(Department department, HttpServletRequest request, String hideName) {
		HttpSession session = request.getSession();
		return departmentService.save(department, session, hideName);
	}

	@RequestMapping(value = "delete")
	public String delete(Integer id) {
		departmentService.delete(id);
		return "/business/departmentList";
	}

	//TODO
	@RequestMapping(value = "findAllEmployee")
	@ResponseBody
	public Department findAllEmployee(Integer id) {
		return departmentService.findAllEmployee(id);
	}
	
	@RequestMapping(value = "lookup")
	public String lookup(Integer selId,Model model){
		model.addAttribute("selId", selId);
		return "/business/departmentLookup";
	}
	
	@RequestMapping(value = "lookupTable")
	@ResponseBody
	public DataGridResultEntity lookupTable(HttpServletRequest request){
		Page<Department> page = new Page<Department>(request);
		page = departmentService.findList(page, new HashMap<String, Object>());
		return new DataGridResultEntity(page.getCount(),page.getList());
	}
	
	

}
