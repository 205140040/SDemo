package com.demo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poi")
public class PoiController {
	@RequestMapping("/testWrite")
	public void testWrite(HttpServletResponse response) throws UnsupportedEncodingException {
		response.setCharacterEncoding("UTF-8");
		// 生成提示信息，
		response.setContentType("application/vnd.ms-excel");
		// 进行转码，使其支持中文文件名
		String codedFileName = URLEncoder.encode("学生报表", "UTF-8");
		response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
		List<TitleObject> titleMap = new ArrayList<>();
		TitleObject t1 = new TitleObject("name", "姓名");
		titleMap.add(t1);
		TitleObject t2 = new TitleObject("sex", "性别");
		titleMap.add(t2);
		TitleObject t3 = new TitleObject("age", "年龄");
		titleMap.add(t3);
		TitleObject t4 = new TitleObject("bir", "生日");
		titleMap.add(t4);
		TitleObject t5 = new TitleObject("money", "金钱");
		titleMap.add(t5);
		TitleObject t6 = new TitleObject("email", "邮箱");
		titleMap.add(t6);
		ArrayList<People> content = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			People p = new People();
			p.setName("仙灵女巫");
			p.setSex("约德尔人");
			p.setAge(18);
			p.setBir(new java.util.Date());
			p.setMoney(new BigDecimal("66.89"));
			content.add(p);
		}
		try {
			PoiUtil.wireExcel(null, titleMap, content, People.class, response.getOutputStream());
			System.out.println("写excel成功---------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
