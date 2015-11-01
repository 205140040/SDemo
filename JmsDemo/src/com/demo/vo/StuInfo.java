package com.demo.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class StuInfo implements Serializable{
    private Integer id;

    private String name;

    private String sex;

    private Date birDay;
    
    private UserInfo user;
    
    private List<UserInfo> userList;
    
    //foreach²éÑ¯²ÎÊý
    private List<Integer> idlist;
    
    
    
    

    public List<Integer> getIdlist() {
		return idlist;
	}

	public void setIdlist(List<Integer> idlist) {
		this.idlist = idlist;
	}

	public List<UserInfo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
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
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirDay() {
        return birDay;
    }

    public void setBirDay(Date birDay) {
        this.birDay = birDay;
    }
}