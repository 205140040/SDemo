package com.demo.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class BeanFactoryDemo {

	public static void main(String[] args) {
		Resource resource = new FileSystemResource(
				"D://JAVASoft//GitProject//GitRep//maven-spring//src//main//java//com//demo//beanfactory//beans.xml");
		System.out.println(resource.getFilename());
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		Person person = (Person) beanFactory.getBean("person1");
		System.out.println(person);
	}

}
