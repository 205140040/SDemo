package com.demo.c19.enumdemo;

import java.math.BigDecimal;

public enum Fruit {
	APPLE("100.00"),ORANGE("200.00"),BANANER("300.00"),
	MYNAME{
		public String getMyName(){
			return "ZHANGSAN";
		}
	};
	
	
	private BigDecimal description;

	private Fruit(String description) {
		this.description = new BigDecimal(description);
	}
	
	

	private Fruit() {
	}



	public BigDecimal getDescription() {
		return description;
	}

	
}
