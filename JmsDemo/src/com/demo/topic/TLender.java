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
			// ��������
			topic = (Topic) ctx.lookup(topicName);
			// ��������
			tConnection.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��������
	public void publishRate(double newRate) {
		try {
			TextMessage msg = tSession.createTextMessage();
			msg.setText("�������ʣ�" + newRate + "%");
			TopicPublisher topicPublisher = tSession.createPublisher(topic);
			topicPublisher.publish(msg);
			System.out.println("�������ʳɹ�:"+newRate+"%");
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
			System.out.println("���������ʣ�");
			double rate=sc.nextDouble();
			tLender.publishRate(rate);
			while(rate!=0.00){
				System.out.println("���������ʣ�");
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
