package com.demo.aopdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAdvice {
	/**
	 * 使用xml配置aop
	 * @author admin
	 * @throws Throwable 
	 * @date 2016年5月15日
	 * @description 
	 * void
	 */
	public void xmlArround(ProceedingJoinPoint joinpoint,String name,String sex) throws Throwable{
		System.out.println("-------------------------");
		System.out.println("around开始---------------");
		System.out.println("参数:[0]"+joinpoint.getArgs()[0]);
		System.out.println("通过aop：args获取参数:姓名:"+name+"\t性别:"+sex);
		if(!"admin".equals(name)){
			return;
		}
		joinpoint.proceed();
		System.out.println("around结束---------------");
		System.out.println("-------------------------");

	}
	
	/**
	 * 7.8.2各种切面类型总结图
	 * @author admin
	 * @date 2016年5月15日
	 * @description 
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/demo/aopdemo/spring-aop.xml");
		IWaiterService waiterService=(IWaiterService)ctx.getBean("waitService");
		waiterService.joinPointArround("露露", "啦啦啦啦");
	}
}
