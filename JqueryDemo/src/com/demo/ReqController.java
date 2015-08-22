package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ReqController")
public class ReqController {
	
	@RequestMapping("/addUser.sw")
	public @ResponseBody User addUser(User u){
		User user=new User();
		System.out.println("hello");
		System.out.println("uname:"+u.getUname());
		user=u;
		return user;
	}
}
