package com.demo.testjson;

import java.util.Date;

public class Student {
	private String name;
	private String sex;
	private Integer age;
	private Date birthday;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String sex, Integer age, Date birthday) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "name:"+name+"\tsex:"+sex+"\tage:"+age+"\tbirthday:"+birthday.toLocaleString();
	}
}
