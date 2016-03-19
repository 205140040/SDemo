package com.demo.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.bean.User;
import com.demo.login.annation.NeedLogin;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping("toLoginPage")
	@NeedLogin(false) // 拦截器不拦截
	public String toLoginPage() {
		return "login";
	}

	@NeedLogin(false) // 拦截器不拦截
	@RequestMapping("/doLogin")
	public void doLogin(HttpServletRequest request, HttpServletResponse response, User user) {
		HttpSession httpSession = request.getSession();
		String userName = user.getUserName();
		String pwd = user.getPassword();
		if (userName.equals("admin") || "jiangzi".equals(userName)) {
			if (pwd.equals("123123")) {
				httpSession.setAttribute("userName", userName);
				try {
					response.sendRedirect("/SpringDeep/test/sayHello");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					response.sendRedirect("/SpringDeep/login/toLoginPage");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				response.sendRedirect("/SpringDeep/login/toLoginPage");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
