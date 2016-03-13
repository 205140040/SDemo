package com.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.bean.User;
import com.demo.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:WebContent/WEB-INF/applicationContext.xml")
public class JunitTest {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void testUser(){
		User user=userMapper.selectByUserName("admin");
		System.out.println(user.getUserName());
	}
}
