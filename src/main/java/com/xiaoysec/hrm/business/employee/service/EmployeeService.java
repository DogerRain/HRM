package com.xiaoysec.hrm.business.employee.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoysec.hrm.business.employee.entity.Employee;
import com.xiaoysec.hrm.business.employee.mapper.EmployeeMapper;
import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.common.base.Page;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	// 分页查询
	public Page<Employee> findList(Page<Employee> page, Map<String, Object> map) {
		Map<String, Object> param = new HashMap<String, Object>();
		String name = (String) map.get("name");
		if (StringUtils.isNotBlank(name)) {
			param.put("name", name);
			param.put("mode", "like");
		}
		List<Employee> employeeList = employeeMapper.findEmployee(param);
		page.setList(employeeList);
		Integer count = employeeMapper.getEmployeeCount(param);
		page.setCount(count);
		return page;
	}

	// id查询
	public Employee getEmployeeById(Integer id) {
		return employeeMapper.getEmployeeById(id);
	}

	// id删除
	@Transactional(readOnly = false)
	public void deleteEmployeeById(Integer id) {
		employeeMapper.deleteEmpolyeeById(id);
	}

	// 保存
	@Transactional(readOnly = false)
	public Map save(Employee employee, HttpSession session, String hideCardId) {
		User user = (User) session.getAttribute("sessionUser");
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			if (StringUtils.isBlank(employee.getName())) {
				result.put("success", false);
				result.put("message", "员工名称不能为空");
				return result;
			}
			if (employee.getSex() == null) {
				result.put("success", false);
				result.put("message", "员工性别不能为空");
				return result;
			}
			if (StringUtils.isBlank(employee.getCardId())) {
				result.put("success", false);
				result.put("message", "员工身份证号不能为空");
				return result;
			}
			if (!employee.getCardId().equals(hideCardId)) {
				// 查重
				boolean isExist = isExist(employee);
				if (isExist) {
					result.put("success", false);
					result.put("message", "员工【" + employee.getName() + "】已经存在");
					return result;
				}
			}
			if (employee.getId() == null) {
				// 保存
				employee.setCreateBy(user);
				employee.setCreateDate(new Date());
				employeeMapper.addEmployee(employee);
			} else {
				// 更新
				employee.setUpdateBy(user);
				employee.setUpdateDate(new Date());
				employeeMapper.updateEmployee(employee);
			}
			result.put("success", true);
			result.put("message", "员工【" + employee.getName() + "】保存成功");
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", "员工【" + employee.getName() + "】保存失败");
		}
		return result;
	}

	// 查重
	private boolean isExist(Employee employee) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(employee.getCardId())) {
			param.put("cardID", employee.getCardId());
			param.put("mode", "equals");
		}
		Integer employeeCount = employeeMapper.getEmployeeCount(param);
		return employeeCount > 0;
	}
}
