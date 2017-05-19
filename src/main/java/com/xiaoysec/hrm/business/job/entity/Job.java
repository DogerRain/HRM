package com.xiaoysec.hrm.business.job.entity;

import java.io.Serializable;

public class Job implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String remarks;

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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}