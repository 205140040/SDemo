package com.demo.aopdemo;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectDemoTest {

	public static void main(String[] args) {
		AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
		IWaiterService waiterService = new WaiterServiceImpl();
		proxyFactory.setTarget(waiterService);// 设置代理对象
		proxyFactory.addAspect(AspectjDemo.class);// 添加切面
		IWaiterService proxy = (IWaiterService) proxyFactory.getProxy();// 得到注入切面的代理对象
		proxy.sayHello("小明");
		proxy.annationTest();
		
		proxy.joinPointArround("哈哈哈", "啦啦啦");
	}

}
