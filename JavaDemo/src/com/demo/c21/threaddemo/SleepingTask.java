package com.demo.c21.threaddemo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SleepingTask implements Runnable{
	private Integer count=10;
	@Override
	public void run() {
		Random random=new Random();
		while(count-->0){
			System.out.println("count:"+count);
			try {
//				TimeUnit.MILLISECONDS.sleep(500);
				//随机时间休眠
				TimeUnit.MILLISECONDS.sleep(random.nextInt(10)*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
