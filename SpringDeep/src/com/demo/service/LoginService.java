package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.User;
import com.demo.dao.UserMapper;
@Service
public class LoginService {
	@Autowired
	UserMapper userMapper;

	public boolean isValid(User user) {
		User olduser = userMapper.selectByUserName("admin");
		System.out.println(olduser.getUserName());
		if (null != olduser) {
			return true;
		}
		return false;
	}
}
