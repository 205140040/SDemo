package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.bean.Student;
import com.demo.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@RequestMapping("/add")
	@ResponseBody
	public String add() {
		Student student = new Student();
		student.setName("啦啦啦");
		student.setSex("哈哈");
		studentService.addAndUpdate(student);
		studentService.addStudent(student);
		return "success";
	}
}
