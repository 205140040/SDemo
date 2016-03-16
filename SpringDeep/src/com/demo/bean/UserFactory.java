package com.demo.bean;

public class UserFactory {
	public static User getUserInstance() {
		User user = new User();
		user.setUserName("factory");
		return user;
	}
}
