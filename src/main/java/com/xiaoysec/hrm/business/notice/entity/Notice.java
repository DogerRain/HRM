package com.xiaoysec.hrm.business.notice.entity;

import java.io.Serializable;
import java.util.Date;

import com.xiaoysec.hrm.business.user.entity.User;

public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String content;
	private Date createTime;
	private User user;

	public Notice() {

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
