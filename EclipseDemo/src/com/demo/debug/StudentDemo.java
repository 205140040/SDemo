package com.demo.debug;

public class StudentDemo {
	private String sname;
	private String ssex;
	
	
	public StudentDemo() {
		super();
	}
	
	
	public StudentDemo(String sname, String ssex) {
		super();
		this.sname = sname;
		this.ssex = ssex;
	}


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


	@Override
	public String toString() {
		return "StudentDemo [sname=" + sname + ", ssex=" + ssex + "]";
	}
	
	
}
