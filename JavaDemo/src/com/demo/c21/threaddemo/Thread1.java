package com.demo.c21.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread1 implements Runnable{
	/**
	 * 定义任务
	 */
	@Override
	public void run() {
		
		for (int j = 0; j < 50; j++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("j=:"+j);
		}
		
	}

	public static void main(String[] args) {
		Thread1 r1=new Thread1();
		Thread2 r2=new Thread2();
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);

//		t1.start();
//		t2.start();
		//executor
//		ExecutorService eService=Executors.newCachedThreadPool();
//		System.out.println("-----------------------------");
//		for (int i = 0; i < 5; i++) {
//			eService.execute(new Thread1());
//		}
//		eService.shutdown();
		//有限的线程executor
		ExecutorService eService2=Executors.newFixedThreadPool(4);
		System.out.println("-----------------------------");
		for (int i = 0; i < 4; i++) {
			eService2.execute(new Thread1());
		}
		eService2.shutdown();
		//单个线程任务
		ExecutorService eService3=Executors.newSingleThreadExecutor();
		System.out.println("-----------------------------");
		for (int i = 0; i < 4; i++) {
			eService3.execute(new Thread1());
		}
		eService3.shutdown();
	}
}
