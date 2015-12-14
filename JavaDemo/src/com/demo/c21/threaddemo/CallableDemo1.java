package com.demo.c21.threaddemo;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableDemo1 implements Callable<String> {
	private Integer id;

	public CallableDemo1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CallableDemo1(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String call() throws Exception {
//		StringBuilder res=new StringBuilder();
//		Random random=new Random();
//		for (int i = 0; i < 20; i++) {
//			res.append(random.nextInt(20));
//			Thread.sleep(50);
//		}
		return "res=:" + id;
	}

}
