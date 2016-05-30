package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/toLogin")
	public ModelAndView toLogin() {
		ModelAndView mv = new ModelAndView("/jsp/login");
		return mv;
	}

}
