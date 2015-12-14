package com.demo.c21.threaddemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest1 {
public static void main(String[] args) {
	try {
		/**
		 * callable接口返回多线程运行的值
		 */
		ExecutorService eService=Executors.newCachedThreadPool();
		List<Future<String>> result=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			result.add(eService.submit(new CallableDemo1(i)));
		}
		for (Future<String> future : result) {
			if(future.isDone()){
				//如果该线程运行玩了，则打印结果
				System.out.println(future.get());
			}
		}
		System.out.println("-------------------------");
		//sleep任务
		for (int i = 0; i < 5; i++) {
			eService.execute(new SleepingTask());
		}
		eService.shutdown();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
