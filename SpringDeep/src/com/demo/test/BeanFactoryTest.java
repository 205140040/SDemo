package com.demo.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.demo.bean.User;

public class BeanFactoryTest {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("com/demo/test/spring-baen.xml");
		// beanFactory
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		User user = (User) beanFactory.getBean("user");
		System.out.println(user);
		System.out.println(user.getUserName());
	}
}
