package com.demo.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService(serviceName="JaxWsService")
public class JaxWsService {
	@Autowired
	ISpringRmiService service;
	
	@WebMethod
	public void sayHello(){
		service.sayHello();
	}

}
