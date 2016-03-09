package com.demo.bean;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {

	/**
	 * @author 20514 2016年3月9日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;
	private String userName;
	private String password;

	private Date createTime;

	private Date updateTime;

	private String lastIp;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

}
