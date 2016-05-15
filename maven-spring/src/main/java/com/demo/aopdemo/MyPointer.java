package com.demo.aopdemo;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 命名切点，达到可以多处引用该切点
 * @author admin
 * 2016年5月15日
 * @description 
 * @ClassName MyPointer
 */
public class MyPointer {
	@Pointcut(value="within(com.demo.aopdemo.*)")
	public void inDemoService(){
		
	}
}
