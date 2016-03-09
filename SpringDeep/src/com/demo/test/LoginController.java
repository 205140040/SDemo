package com.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.bean.User;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping("/login")
	public void login() {
		User user = new User();
		user.setUserName("admin");
		loginService.isValid(user);
	}
}
