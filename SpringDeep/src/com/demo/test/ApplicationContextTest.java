package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.User;

public class ApplicationContextTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/demo/test/spring-baen.xml");
		User user = (User) applicationContext.getBean("user");
		System.out.println(user.getUserName());

//		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
//		System.out.println(((ConfigureUser) context.getBean("configureUser",ConfigureUser.class)).getUserName());
	}
}
