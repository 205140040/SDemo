package com.demo;

import java.util.Date;
/**
 * 使用快捷键对成员变量排序:alt+shift+s sort members
 * 代码清理：clean up==ctrl+shift+o
 * 产生接口的代理方法 
 * 产生tostring方法
 * 把字符串提取成属性文件
 * 
 * @author Administrator
 * 2016年4月16日
 * @description
 * 
 */
public class Student{
	private Integer age;
	private Date bir;
	private String name;
	private String sex;
	
	private MyInter myInter;
	
	/**
	 * 自动生成的代理方法
	 * @author Administrator
	 * 2016年4月16日
	 * @description
	 */
	public void sayHello() {
		myInter.sayHello();
	}
	
	
	public Integer getAge() {
		return age;
	}
	public Date getBir() {
		return bir;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setBir(Date bir) {
		this.bir = bir;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 使用eclipse自动生成的tostring方法
	 */
	@Override
	public String toString() {
		return "Student [age=" + age + ", bir=" + bir + ", name=" + name + ", sex=" + sex + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}
	
	public static void main(String[] args) {
		Student student=new Student();
		student.setAge(18);
		student.setName(Messages.getString("Student.0")); //$NON-NLS-1$
		student.setSex("哈哈哈"); //$NON-NLS-1$
		student.setBir(new Date());
		System.out.println(student);
	}
}
