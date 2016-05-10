package com.demo.test;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringResourceDemo {

	public static void main(String[] args) {
		Resource resource=new ClassPathResource("src/main/java/com/demo/controller/HelloController.java");
		System.out.println(resource.getFilename());
	}

}
