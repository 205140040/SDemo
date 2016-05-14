package com.demo.i18n;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageResourceDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * spring国际化
		 */
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/demo/beanfactory/beans.xml");
		// MessageSource messageSource = (MessageSource)
		// applicationContext.getBean("resourceBundleMessageSource");
		String[] params = { "酱紫", new Date().toLocaleString() };
		// String cnString = messageSource.getMessage("hello", params,
		// Locale.CHINA);
		// System.out.println("spring国际化读取:" + cnString);
		/**
		 * 可以定时刷新属性文件的国际化类
		 */
		// System.out.println("可以定时刷新属性文件的国际化类");
		// MessageSource reloadMessageSource = (MessageSource)
		// applicationContext
		// .getBean("reloadableResourceBundleMessageSource");
		// for (int i = 0; i < 3; i++) {
		// String recnString = reloadMessageSource.getMessage("hello", params,
		// Locale.CHINA);
		// System.out.println("spring国际化读取:" + recnString);
		// Thread.currentThread().sleep(30000);
		// }
		/* 访问全局国际化信息 */
		String ctxcnString = applicationContext.getMessage("hello", params, Locale.CHINA);
		System.out.println("spring国际化读取:" + ctxcnString);
	}

}
