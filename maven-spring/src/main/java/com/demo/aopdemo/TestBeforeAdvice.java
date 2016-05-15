package com.demo.aopdemo;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
/**
 * 单独定义一个实现了接口的单独一个增强
 * @author admin
 * 2016年5月15日
 * @description 
 * @ClassName TestBeforeAdvice
 */
public class TestBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arg1, Object target) throws Throwable {
		System.out.println("方法调用前advice..............");
	}
}
