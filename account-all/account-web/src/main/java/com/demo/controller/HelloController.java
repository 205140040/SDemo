package com.demo.controller;

import com.demo.service.IHelloService;

public class HelloController {
	private IHelloService helloService;

	public void testHello() {
		helloService.sayHello();
	}
}
