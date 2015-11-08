package com.demo.c20.myannotation;
@DBTable(name="Student")
public class Student {
	@SqlInteger(name="sid",constraints=@Constraints(primaryKey=true,unique=true))
	private Integer sid;
	@SqlString(value=50)
	private String name;
	@SqlString(value=50)
	private String sex;
	@SqlInteger(name="age")
	private Integer age;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
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
	
	
}
