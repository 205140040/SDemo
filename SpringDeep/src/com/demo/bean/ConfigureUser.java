package com.demo.bean;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * 注解代替xml配置bean
 * 
 * @author 20514 2016年3月13日
 * @description
 */
@Configurable
public class ConfigureUser {

	private String userName;
	private int age;

	@Bean(name = "configureUser")
	public ConfigureUser buildUser() {
		ConfigureUser user = new ConfigureUser();
		user.setUserName("酱紫");
		return user;
	}

	public ConfigureUser() {
		super();
	}

	public ConfigureUser(String userName, int age) {
		super();
		this.userName = userName;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
