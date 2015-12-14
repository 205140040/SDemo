package com.demo.c21.threaddemo;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + ":" + this);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		/**
		 * 后台线程
		 */
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new SimpleDaemons());
			t.setDaemon(true);// 设置后台线程
			t.start();
		}
		TimeUnit.MILLISECONDS.sleep(175);
	}
}
