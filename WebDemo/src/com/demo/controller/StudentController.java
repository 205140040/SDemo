package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.bean.StudentInfo;
import com.demo.dao.StudentMapper;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentMapper studentMapper;

	@RequestMapping("/toStudentPage")
	public String toStudentPage(Model model) {
		StudentInfo student = studentMapper.selectById(1,"露露");
		model.addAttribute("student", student);
		return "web-page/student/student";
	}
}
