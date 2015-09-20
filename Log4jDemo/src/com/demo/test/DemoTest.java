package com.demo.test;

import org.apache.log4j.Logger;

public class DemoTest {

	private static Logger logger=Logger.getLogger(DemoTest.class);
	
	public static void main(String[] args) {
		//记录debug 级别的信息
		logger.debug("this is debug log info");
		//记录info级别的信息
		logger.info("this is info log info");
		//记录error级别的信息
		logger.error("this is error log info");
	}

}
