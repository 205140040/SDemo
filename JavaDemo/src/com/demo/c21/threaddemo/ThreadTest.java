package com.demo.c21.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
public static void main(String[] args) {
	try {
		/**
		 * 线程优先级
		 */
		ExecutorService executorService=Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new PriorityDemo(Thread.MIN_PRIORITY));
		}
		executorService.execute(new PriorityDemo(Thread.MAX_PRIORITY));
		executorService.shutdown();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
