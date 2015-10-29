package com.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.service.IStudentService;
import com.demo.vo.StuInfo;

@Controller
@RequestMapping("/TestSqlController")
public class TestSqlController {
	@Autowired
	private IStudentService studentService;
	@RequestMapping("/selectStudent")
	@ResponseBody
	public List<StuInfo> selectStudent(){
		System.out.println("------------------------------------------");
		System.out.println(studentService);
		Map<Object, Object> map=studentService.selectUserMap(1);
		System.out.println("name:"+map.get("name"));
		List<StuInfo> stuInfos=studentService.selectOne();
		System.out.println(JSON.toJSONString(stuInfos));
		return stuInfos;
	}

}
