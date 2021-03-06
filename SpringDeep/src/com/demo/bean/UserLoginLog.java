package com.demo.bean;

import java.io.Serializable;
import java.sql.Date;

public class UserLoginLog implements Serializable {
	/**
	 * @author 20514 2016年3月9日
	 * @description
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private Date loginDate;
	private String loginIp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
}
