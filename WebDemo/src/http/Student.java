package http;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * @author 20514
	 * 2016年2月27日
	 * @description 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public Student() {
		super();
	}
	
	

	public Student(String sname, String ssex, Integer sage) {
		super();
		this.sname = sname;
		this.ssex = ssex;
		this.sage = sage;
	}



	private String sname;
	
	private String ssex;
	
	private Integer sage;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}
	
	

}
