package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.annotation.NotNeedLogin;
import com.demo.bean.BaseResult;
import com.demo.bean.User;
import com.demo.bean.staticbean.UserStatic;

@Controller
@RequestMapping("/login")
public class LoginController {

	@NotNeedLogin
	@RequestMapping("/toLogin")
	public ModelAndView toLogin() {
		ModelAndView mv = new ModelAndView("/jsp/login");
		return mv;
	}

	@RequestMapping("/toUser")
	public String toUser() {
		return "/jsp/user";
	}

	@NotNeedLogin
	@RequestMapping("/login")
	@ResponseBody
	public BaseResult login(User loginUser, HttpServletRequest request) {
		if (loginUser.getUserName().equals("admin")) {
			if (loginUser.getPassword().equals("admin123")) {
				// 登录成功
				HttpSession session = request.getSession();
				session.setAttribute(UserStatic.USER_CONTEXT, loginUser);
				return BaseResult.resultTrueAndMsg("登录成功");
			} else {
				return BaseResult.resultFalseAndMsg("用户名或密码错误");
			}
		} else {
			return BaseResult.resultFalseAndMsg("该用户不存在");
		}
	}
	
	@NotNeedLogin
	@RequestMapping("/logout")
	@ResponseBody
	public void logout(User loginUser, HttpServletRequest request) {
		request.getSession().removeAttribute(UserStatic.USER_CONTEXT);
	}

}
