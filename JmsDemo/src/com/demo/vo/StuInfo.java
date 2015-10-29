package com.demo.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StuInfo {
    private Integer id;

    private String name;

    private String sex;

    private Date birDay;
    
    private UserInfo user;
    
    private List<UserInfo> userList=new ArrayList<>();
    
    

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