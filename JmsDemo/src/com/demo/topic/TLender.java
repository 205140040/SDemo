package com.demo.topic;

import java.util.Scanner;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TLender {
	private TopicConnection tConnection;
	private TopicSession tSession;
	private Topic topic;

	public TLender(String topicCF, String topicName) {
		try {
			Context ctx = new InitialContext();
			TopicConnectionFactory cFactory = (TopicConnectionFactory) ctx.lookup(topicCF);
			tConnection = cFactory.createTopicConnection();
			tSession = tConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			// 查找主题
			topic = (Topic) ctx.lookup(topicName);
			// 启动链接
			tConnection.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 发布主题
	public void publishRate(double newRate) {
		try {
			TextMessage msg = tSession.createTextMessage();
			msg.setText("最新利率：" + newRate + "%");
			TopicPublisher topicPublisher = tSession.createPublisher(topic);
			topicPublisher.publish(msg);
			System.out.println("发送利率成功:"+newRate+"%");
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

	public static void main(String[] args) {
		try {
			TLender tLender=new TLender("TopicCF", "RateTopic");
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入利率：");
			double rate=sc.nextDouble();
			tLender.publishRate(rate);
			while(rate!=0.00){
				System.out.println("请输入利率：");
				rate=sc.nextDouble();
				tLender.publishRate(rate);
			}
			if(rate==0.00){
				tLender.exit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
