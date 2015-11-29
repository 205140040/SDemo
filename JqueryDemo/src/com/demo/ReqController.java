package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ReqController")
public class ReqController {
	
	@RequestMapping("/addUser.spring")
	public @ResponseBody User addUser(User u){
		User user=new User();
		System.out.println("hello");
		System.out.println("uname:"+u.getUname());
		user=u;
		return user;
	}
	
	@RequestMapping("/upload")
	public void upload(MultipartFile file) {
		
		System.out.println("upload");
	}
}
