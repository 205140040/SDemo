package com.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Rmi")
public class TestRmi {

	@Autowired
	@Qualifier("hessianService")	
	private ISpringRmiService service;
	
	@Autowired
	@Qualifier("alertService")
	private AlertService alertService;
	

	
	@RequestMapping("/sayRmi")
	public void sayRmi(){
		System.out.println(service);
		service.sayHello();
		System.out.println("rmi");
	}
	
	@RequestMapping("/sayJms")
	public void sayJms(){
		System.out.println(alertService);
		
		alertService.sendAlert(new User());
		System.out.println("jms");
	}

}
