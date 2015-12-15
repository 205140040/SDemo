package com.demo.c21.threaddemo;

import java.util.concurrent.ThreadFactory;

public class DemoThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread t=new Thread(r);
		//设置为后台线程
		t.setDaemon(true);
		return t;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread t=new Thread(new SimpleDaemons());
			t.setDaemon(true);// 设置后台线程
			t.start();
			if(t.isDaemon()){
				System.out.println(t.getName()+":is daemon");
			}
		}
	}

}
