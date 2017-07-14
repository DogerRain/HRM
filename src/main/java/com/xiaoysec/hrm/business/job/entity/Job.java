package com.xiaoysec.hrm.business.job.entity;

import com.xiaoysec.hrm.common.base.BaseEntity;

public class Job extends BaseEntity<Job> {

	private Integer id;
	private String name;
	private String remark;

	public Job() {

	}

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
