package com.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	private static Logger logger=Logger.getLogger(HelloController.class);

	@RequestMapping("/sayHello")
	public void sayHello(HttpServletResponse response) throws Exception {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		logger.error("进入了sayHello-----------");
		out.println("sayHello");
		out.close();
	}
}
