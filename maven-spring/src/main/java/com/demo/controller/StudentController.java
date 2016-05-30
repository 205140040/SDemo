package com.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.bean.Student;
import com.demo.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	/**
	 * srpingMvc 注解使用:
	 * 
	 * 1.@cookieValue绑定cookie信息 2.使用@requestHeader绑定请求头参数
	 * 3.@requestBody,和@responseBody会调用spring 转换器，把类容转换成相应的数据
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String add(@CookieValue(value = "JSESSIONID", required = false) String sessionId,
			@RequestHeader(value = "Accept", required = false) String Accept, Student student) {
		// Student student = new Student();
		// student.setName("啦啦啦");
		// student.setSex("哈哈");
		// studentService.addAndUpdate(student);
		studentService.addStudent(student);
		return "sessionId:" + sessionId + "Accept:" + Accept;
	}

	/**
	 * 测试定义的fastjson消息转换器 3.将数据绑定到模型中: modelAndView 把数据添加到model中 model
	 * 把数据添加到model中
	 * 
	 * @ModelAttribute 注解将入参绑定到model中
	 * @SessionAttribute 注解将参数绑定到model中
	 */
	@RequestMapping("/tjson")
	@ResponseBody
	public Student tjson() {
		Student s = new Student();
		s.setName("啦啦啦");
		s.setSex("哈哈");
		s.setBir(new Date());
		return s;
	}

	/*
	 * 3.将数据绑定到模型中: modelAndView 把数据添加到model中 model 把数据添加到model中
	 * 
	 * @ModelAttribute 注解将入参绑定到model中
	 * 
	 * @SessionAttribute 注解将参数绑定到model中
	 */
	@RequestMapping("toList")
	public String toList(@ModelAttribute(value = "name") String name) {
		/**
		 * ModelAndView 对象既包含模型信息又包含视图信息
		 */
		return "jsp/stuList";
	}
}
