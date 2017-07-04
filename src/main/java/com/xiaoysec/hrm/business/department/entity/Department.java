package com.xiaoysec.hrm.business.department.entity;

import com.xiaoysec.hrm.common.base.BaseEntity;

public class Department extends BaseEntity<Department>{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
