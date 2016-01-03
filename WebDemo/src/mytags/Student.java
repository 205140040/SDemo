package mytags;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * @author 20514 2016年1月3日
	 * @description
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer age;
	private String sex;

	public Student() {
		super();
	}

	public Student(String name, Integer age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
