package com.demo.c21.threaddemo;

/**
 * 线程优先级
 * 
 * @author 20514
 *
 */
public class PriorityDemo implements Runnable {
	private int countDown = 5;
	private volatile double d;
	private int priority;

	public PriorityDemo(int priority) {
		super();
		this.priority = priority;
	}

	@Override
	public String toString() {
		return Thread.currentThread() + ":" + countDown;
	}

	@Override
	public void run() {
		// 设置优先级
		Thread.currentThread().setPriority(priority);
		for (int i = 0; i < 100000; i++) {
			d += (Math.PI + Math.E) / (double) i;
			if (i % 1000 == 0) {
				//让步
				Thread.yield();
			}
			System.out.println(this);
			if(--countDown==0) return;
		}
	}

}
