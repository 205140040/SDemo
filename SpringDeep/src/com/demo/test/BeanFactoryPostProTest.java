package com.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.User;

/**
 * 工厂后处理器
 * 
 * @author 20514 2016年3月14日
 * @description
 */
public class BeanFactoryPostProTest implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory bd) throws BeansException {
		BeanDefinition beanDefinition = bd.getBeanDefinition("user");
		beanDefinition.getPropertyValues().addPropertyValue("userName", "露露啦");
		System.out.println("工厂后处理器");
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/demo/test/spring-baen.xml");
		User user = (User) applicationContext.getBean("user");
		System.out.println(user.getUserName());
		User u2 = (User) applicationContext.getBean("user2");
		System.out.println(u2.getUserName() + "pass:" + u2.getPassword());
		User u3 = (User) applicationContext.getBean("userFac");
		System.out.println(u3.getUserName() + "pass:" + u3.getPassword());
	}

}
