package com.xiaoysec.hrm.business.employee.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiaoysec.hrm.business.department.entity.Department;
import com.xiaoysec.hrm.business.job.entity.Job;
import com.xiaoysec.hrm.common.base.BaseEntity;

public class Employee extends BaseEntity<Employee> {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Department department;
	private Job job;
	private String name;
	private String cardId;
	private String address;
	private String phone;
	private String email;
	private Integer sex;
	private String party;
	// 接收表单参数的时候需要声明格式
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String race;
	private String edcation;
	private String remark;

	public Employee() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getEdcation() {
		return edcation;
	}

	public void setEdcation(String edcation) {
		this.edcation = edcation;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
