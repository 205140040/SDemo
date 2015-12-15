package com.demo.c21.threaddemo;

public class SelfManagerRunnable implements Runnable {
	private Thread t = new Thread(this);
	private int countDown = 5;

	public SelfManagerRunnable() {
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

	@Override
	public String toString() {
		return Thread.currentThread() + "\t " + countDown;
	}

	public static void main(String[] args) {
		/**
		 * 自管理多线程
		 * 通过构造方法启动线程
		 */
		for (int i = 0; i < 5; i++) {
			new SelfManagerRunnable();
		}
	}
}
