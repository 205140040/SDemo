package com.demo.test;

import org.apache.log4j.Logger;

public class DemoTest {

	private static Logger logger=Logger.getLogger(DemoTest.class);
	
	public static void main(String[] args) {
		//��¼debug �������Ϣ
		logger.debug("this is debug log info");
		//��¼info�������Ϣ
		logger.info("this is info log info");
		//��¼error�������Ϣ
		logger.error("this is error log info");
	}

}
