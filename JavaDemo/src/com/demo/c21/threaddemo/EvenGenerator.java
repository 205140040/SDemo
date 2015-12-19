package com.demo.c21.threaddemo;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenGenerator extends IntGenerator{
	private int currentValue=0;
	
	/**
	 * lock所对象
	 */
	private Lock lock=new ReentrantLock();
//	@Override
/*	public  int next() {
		++currentValue;
//		Random random=new Random();
//		try {
//			TimeUnit.MILLISECONDS.sleep(random.nextInt(10)*100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		Thread.yield();
		return currentValue;
	}
	*/
	
//	@Override
//	public synchronized int next() {
//		++currentValue;
//		Thread.yield();
//		return currentValue;
//	}

	@Override
	public synchronized int next() {
		try {
			lock.lock();
			++currentValue;
			Thread.yield();
			return currentValue;
		} finally {
			lock.unlock();
		}
		
	}
}
