package com.demo.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.service.IStudentService;
import com.demo.util.MyBatisUtils;
import com.demo.vo.StuInfo;

@Controller
@RequestMapping("/TestSqlController")
public class TestSqlController {
	public static Logger logger=Logger.getLogger(TestSqlController.class);
	@Autowired
	private IStudentService studentService;
	@RequestMapping("/selectStudent")
	@ResponseBody
	public List<StuInfo> selectStudent(){
		System.out.println("------------------------------------------");
		System.out.println(studentService);
		Map<Object, Object> map=studentService.selectUserMap(1);
		System.out.println("name:"+map.get("name"));
		StuInfo search=new StuInfo();
		Integer[] ids={1,2,3};
		search.setIdlist(Arrays.asList(ids));//��������in ����
		List<StuInfo> stuInfos=studentService.selectOne(search);
		System.out.println(JSON.toJSONString(stuInfos));
		return stuInfos;
	}

	/**
	 * ����sqlBuilder����̬����sql
	 * @return
	 * @date 2015��11��1��
	 * @author hyc
	 * @description
	 */
	@RequestMapping(value="/selectGenSql",method=RequestMethod.GET)
	@ResponseBody
	public List<StuInfo> selectGenSql(){
		StuInfo info=new StuInfo();
		List<StuInfo> result=null;
		StuInfo stuInfo=new StuInfo();
		stuInfo.setName("����");
		stuInfo.setSex("Ů");
		stuInfo.setBirDay(new Date());
		String insertSql=MyBatisUtils.insertSql(stuInfo);
		info.setSql(insertSql);
		studentService.selectGenSql(info);
		logger.info("insertSql:"+insertSql);
		String sql=MyBatisUtils.selectGenSql("��");
		logger.info("infoSql:"+sql);
		
		info.setSql(sql);
		result=studentService.selectGenSql(info);
		return result;
	}
}
