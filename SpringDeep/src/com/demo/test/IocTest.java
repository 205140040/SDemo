package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.annation.bean.AnnationUser;

public class IocTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/demo/test/spring-baen.xml");
		// SuperMarket sm = (SuperMarket) context.getBean("sm1");
		// System.out.println(sm.getUser().getUserName());
		// List<String> list = sm.getNameList();
		// for (String string : list) {
		// System.out.println("l[i]:" + string);
		// }
		// Properties properties = sm.getPros();
		// System.out.println(properties.get("uname"));
		// Student s1 = (Student) context.getBean("stu1");
		// System.out.println(s1.getUser());
		// System.out.println(s1.getUser());
		// System.out.println(s1.getUser());
//		User cu1 = (User) context.getBean("cu1");
//		System.out.println("cu1:" + cu1.getUserName());
//		User cu2 = (User) context.getBean("cu2");
//		System.out.println("cu2:" + cu2.getUserName());
//		User cu3 = (User) context.getBean("cu3");
//		System.out.println("cu3:" + cu2.getUserName());
		AnnationUser au=(AnnationUser)context.getBean("aUser");
		System.out.println(au);
		System.out.println("name:"+au.getUserName());
		//关闭容器
		((ClassPathXmlApplicationContext)context).destroy();
	}
}
