package com.demo.xml;

import java.io.Serializable;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("user") // xsream别名注解
public class XmlUser implements Serializable {
	/**
	 * @author admin 2016年5月21日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private int age;

	private String sex;

	@XStreamAlias("bir")
	@XStreamConverter(DateConverter.class)
	private Date birthday;

	public XmlUser() {
		super();
	}

	public XmlUser(String name, int age, String sex, Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "XmlUser [name=" + name + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
