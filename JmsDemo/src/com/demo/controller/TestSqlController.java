package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.service.IStudentService;
import com.demo.vo.StuInfo;

@Controller
@RequestMapping("/TestSqlController")
public class TestSqlController {
	@Autowired
	private IStudentService studentService;
	@RequestMapping("/selectStudent")
	public void selectStudent(){
		System.out.println("------------------------------------------");
		System.out.println(studentService);
		StuInfo stuInfo=studentService.selectByPrimaryKey(1);
		System.out.println("name:"+stuInfo.getName());
	}

}
