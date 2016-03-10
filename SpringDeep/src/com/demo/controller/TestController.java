package com.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/sayHello")
	public void sayHello(HttpServletResponse response) throws Exception{
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		out.println("hello spring");
		System.out.println("hello spring");
		out.close();
	}
}
