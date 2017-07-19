package com.xiaoysec.hrm.business.document.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.common.base.BaseEntity;

public class Document extends BaseEntity<Document> {

	private Integer id;
	private String title;
	private String fileName;
	private MultipartFile file;
	private String remark;

	public Document() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


}
