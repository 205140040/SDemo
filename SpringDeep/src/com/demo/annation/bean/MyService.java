package com.demo.annation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ser1")
public class MyService {
	
	//autowired自动装配
	@Autowired
	private Dao dao;
	
	//通过限定名称装配
	@Qualifier(value="aUser")
	private AnnationUser aUser;
	
	private String sname;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}
