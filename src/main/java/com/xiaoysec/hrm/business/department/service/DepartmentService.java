package com.xiaoysec.hrm.business.department.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoysec.hrm.business.department.entity.Department;
import com.xiaoysec.hrm.business.department.mapper.DepartmentMapper;
import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.common.base.Page;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	// 分页查询
	public Page<Department> findList(Page<Department> page, Map<String, Object> map) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String name = (String) map.get("name");
		String mode = (String) map.get("mode");
		int start = page.getStart();
		int size = page.getSize();
		paramMap.put("start", start);
		paramMap.put("size", size);
		if (StringUtils.isNotBlank(name)) {
			paramMap.put("name", name);
			paramMap.put("mode", mode);
		}
		List<Department> departmentList = departmentMapper.findDept(paramMap);
		page.setList(departmentList);
		page.setCount(departmentMapper.getDeptCount(paramMap));
		return page;
	}

	@Transactional(readOnly = false)
	public void delete(Integer id) {
		departmentMapper.deleteDeptById(id);
	}

	public List<Department> findAll() {
		List<Department> result = departmentMapper.findAll();
		return result;
	}

	@Transactional(readOnly = false)
	public Map save(Department department, HttpSession session, String hideName) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (StringUtils.isBlank(department.getName())) {
				result.put("success", false);
				result.put("message", "部门名称不能为空");
				return result;
			}
			// 查重,与hideName对比
			if (!hideName.equals(department.getName())) {
				boolean isExist = isExist(department);
				if (isExist) {
					result.put("success", false);
					result.put("message", "部门【" + department.getName() + "】已经存在");
					return result;
				}
			}
			if (department.getId() == null) {
				// 新增
				// 创建时间和创建人
				User user = (User) session.getAttribute("sessionUser");
				department.setCreateBy(user);
				department.setCreateDate(new Date());
				departmentMapper.addDepartment(department);

			} else {
				// 修改
				// 修改人和修改时间
				User user = (User) session.getAttribute("sessionUser");
				department.setUpdateBy(user);
				department.setUpdateDate(new Date());
				departmentMapper.updateDept(department);
			}
			result.put("success", true);
			result.put("message", "部门【" + department.getName() + "】保存成功");
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return result;
	}

	// 根据id查询
	public Department getDepartmentById(Integer id) {
		return departmentMapper.getDepartmentById(id);
	}

	// 查重
	public boolean isExist(Department department) {
		HashMap<String, Object> parm = new HashMap<String, Object>();
		parm.put("name", department.getName());
		parm.put("mode", "equals");
		Integer deptCount = departmentMapper.getDeptCount(parm);
		return deptCount > 0 ? true : false;
	}

}
