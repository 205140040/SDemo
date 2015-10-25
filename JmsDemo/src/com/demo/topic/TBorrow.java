package com.demo.topic;

import java.util.Scanner;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TBorrow implements MessageListener{
	private TopicConnection tConnection;
	private TopicSession tSession;
	private Topic topic;
	private double crate;
	
	
	public TBorrow(String factory,String topicName,String rate) {
		try {
			crate=Double.valueOf(rate);
			Context ctx=new InitialContext();
			
			TopicConnectionFactory tFactory=(TopicConnectionFactory)ctx.lookup(factory);
			tConnection=tFactory.createTopicConnection();
			tSession=tConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			//查找主题
			topic=(Topic)ctx.lookup(topicName);
			TopicSubscriber subscriber=tSession.createSubscriber(topic);
			subscriber.setMessageListener(this);
			tConnection.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void exit() {
		try {
			tConnection.close();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage msg=(TextMessage)message;
			String text=msg.getText();
			System.out.println("topic："+text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			TBorrow tBorrow=new TBorrow("TopicCF", "RateTopic","5.22");
			Scanner sc=new Scanner(System.in);
			System.out.println("输入exit退出：");
			String opt=sc.next();
		
			if("exit".equalsIgnoreCase(opt)){
				tBorrow.exit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
