package com.demo.controller;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;

public class SimpleReciver implements MessageListener{
public static void main(String[] args) throws JMSException {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	JmsTemplate jmsTemplate=(JmsTemplate)ctx.getBean("jmsTemplate");
	SimpleReciver sr=new SimpleReciver();
	sr.onMessage(jmsTemplate.receive());
	//接受消息
//	Message message=jmsTemplate.receive();
//	if(message instanceof TextMessage){
//		System.out.println(((TextMessage)message).getText());
//	}else{
//		System.out.println("no text message");
//	}
//	Object message=jmsTemplate.receiveAndConvert();
//	if(message instanceof String){
//		System.out.println(message);
//	}else{
//		System.out.println("no text message");
//	}
}

/**
 * 消息驱动bean
 */
@Override
public void onMessage(Message message) {
	try {
		System.out.println(((TextMessage)message).getText());
	} catch (JMSException e) {
		e.printStackTrace();
	}

}



}
