package com.demo.jetty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartJetty {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/demo/jetty/spring-jetty.xml");
//		Server server = new Server(8080);  
//		  
//        WebAppContext context = new WebAppContext();  
//        context.setContextPath("/");  
//        context.setDescriptor("D:/JAVASoft/GitProject/GitRep/SpringDeep/WEB-INF/web.xml");  
//        context.setResourceBase("D:/JAVASoft/GitProject/GitRep/SpringDeep");  
//        context.setParentLoaderPriority(true);  
//        server.setHandler(context);  
//  
//        server.start();  
//        server.join();  
	}

}
