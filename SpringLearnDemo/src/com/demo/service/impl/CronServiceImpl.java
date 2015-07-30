package com.demo.service.impl;

import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
@Service("cronService")
public class CronServiceImpl {
	/**
	 * spring 任务调度
	 */
	@Scheduled(cron="0/5 * *  * * ?")
	public void outDateCron(){
		System.out.println("当前时间："+new Date().toLocaleString());
	}
	
	/**
	 * 异步方法
	 */
	@Async
	public AsyncResult<Object> sayAsyn(){
		String value="asyncHello";
		return new AsyncResult<Object>(value);
	}
}
