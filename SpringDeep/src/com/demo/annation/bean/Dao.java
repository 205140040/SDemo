package com.demo.annation.bean;

import org.springframework.stereotype.Repository;

@Repository("dao1")
public class Dao {
	private String daoName;

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}
	
}
