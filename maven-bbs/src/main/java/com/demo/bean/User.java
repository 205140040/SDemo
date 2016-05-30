package com.demo.bean;

import java.util.Date;
import java.util.List;

public class User extends BaseBean {

	/**
	 * @author admin 2016年5月30日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String userName;

	private String password;

	private String userType;

	private Integer locked;

	private Integer credit;

	private Date lastVisit;

	private List<Object> rules;
	
	

	public User() {
		super();
	}

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public List<Object> getRules() {
		return rules;
	}

	public void setRules(List<Object> rules) {
		this.rules = rules;
	}

	public static void main(String[] args) {
		User user=new User();
		user.setUserName("啦啦啦");
		System.out.println(user);
	}
}
