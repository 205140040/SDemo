package com.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.aop.CheckToken;
import com.demo.bean.User;
import com.demo.dao.UserMapper;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/sayHello")
	public void sayHello(HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		out.println("hello spring");
		System.out.println("hello spring");
		User user = userMapper.selectByUserName("admin");
		System.out.println(user.getPassword());
		System.out.println("------------");
		String res = this.testToken();
		System.out.println(res);
		out.close();
	}

	@CheckToken(value=true)
	@RequestMapping("/testToken")
	@ResponseBody
	public String testToken() {
		System.out.println("哈哈哈哈哈哈");
		return "通过了----------";
	}
}
