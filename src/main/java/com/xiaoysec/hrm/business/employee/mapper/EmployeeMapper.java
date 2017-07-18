package com.xiaoysec.hrm.business.employee.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xiaoysec.hrm.business.employee.entity.Employee;

public interface EmployeeMapper {

	// 动态查询总数
	public Integer getEmployeeCount(Map<String, Object> param);

	// 分页查询
	public List<Employee> findEmployee(Map<String, Object> param);

	// id查询
	public Employee getEmployeeById(Integer id);

	// id删除
	public void deleteEmpolyeeById(Integer id);

	// 查重
	public boolean isExist(Employee employee);

	public Set<Employee> findEmployeeByDeptId(Integer id);

	// 添加员工
	public void addEmployee(Employee employee);

	// 更新员工信息
	public void updateEmployee(Employee employee);
}