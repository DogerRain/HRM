package com.xiaoysec.hrm.business.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 * 
 * @author xiaoysec
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String loginname;
	private String password;
	private Integer status;
	private Date createDate;

	// 子类构造方法默认会调用父类的午餐构造方法，父类中带参构造方法会覆盖无参构造方法
	public User() {

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

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
