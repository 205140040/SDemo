package com.demo.c21.threaddemo;

import java.util.concurrent.TimeUnit;

public class Sleeper extends Thread{
@Override
public void run() {
	try {
		System.out.println("该线程加入");
		TimeUnit.MILLISECONDS.sleep(2000);
		System.out.println(Thread.currentThread().getName()+"sleeper");
		System.out.println("休眠2000毫秒结束");
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}
