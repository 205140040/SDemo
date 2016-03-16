package com.demo.annation.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="aUser")
@Scope(value="singleton")
public class AnnationUser {
	private String userName;
	private String sex;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	//注解初始化方法
	@PostConstruct
	public void init1(){
		this.userName="买买买";
	}
	
	//注解销毁方法
	@PreDestroy
	public void destory1(){
		System.out.println("销毁该bean");
	}
	
}
