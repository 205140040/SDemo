package com.demo.springlistener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailSender implements ApplicationContextAware {

	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

	public void sendEmail(String to) {
		System.out.println("mailSender:模拟发送邮件....");
		MailSendEvent event = new MailSendEvent(ctx, to);
		// 所有监听器发送事件
		ctx.publishEvent(event);
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/demo/beanfactory/beans.xml");
		MailSender mailSender = (MailSender) context.getBean("mailSender");
		mailSender.sendEmail("啦啦啦啦啦");

	}
}
