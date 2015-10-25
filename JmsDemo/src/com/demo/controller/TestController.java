package com.demo.controller;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/TestController")
public class TestController {
	@Qualifier(value="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		JmsTemplate template=(JmsTemplate)ctx.getBean("jmsTemplate");
//		System.out.println("template:"+template);
//		MessageCreator mc=new MessageCreator() {
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				TextMessage textMessage=session.createTextMessage();
//				textMessage.setJMSPriority(9);
//				textMessage.setText("this is jms message");
//				return textMessage;
//			}
//		};
//		//发送消息
//		template.send(mc);
		//使用convertAndSend
		MessagePostProcessor messagePostProcessor=new MessagePostProcessor() {
			
			@Override
			public Message postProcessMessage(Message message) throws JMSException {
				message.setJMSPriority(9);
				return message;
			}
		};
		template.convertAndSend((Object)"this is jms message2");
		//使用非默认jms目的地
		System.out.println("发送完毕");
	}
	
	
	
	@RequestMapping(value="/sayHello")
	public void sayHello(){
		System.out.println("hello");
	}
	@RequestMapping("/sendMessage")
	public void sendMessage(){
		System.out.println(jmsTemplate);
		MessageCreator mc=new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage=session.createTextMessage();
				textMessage.setJMSPriority(9);
				textMessage.setText("this is jms message");
				return textMessage;
			}
		};
		//发送消息
		jmsTemplate.send(mc);
	}
}
