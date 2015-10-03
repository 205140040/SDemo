package com.demo.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JmsChat implements MessageListener{
	private TopicSession topicSession;
	
	private TopicPublisher publisher;
	
	private TopicConnection connection;
	
	private String username;
	/**
	 * ��ʼ������
	 */
	public  JmsChat(String topicFactory,String topicName,String username) throws Exception{
		//���������ļ�
//		Properties p=new Properties();
//		p.put(Context.SECURITY_PRINCIPAL, "system");
//		p.put(Context.SECURITY_CREDENTIALS, "manager");
//		p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
//		p.put(Context.PROVIDER_URL, "tcp://localhost:61616");
		
		
		//ʹ��jndi�����ļ����jndi����
		InitialContext ctx=new InitialContext();
		//����һ��jms���ӹ�����������һ������
		TopicConnectionFactory topicConnectionFactory=(TopicConnectionFactory)ctx.lookup(topicFactory);
		//����
		TopicConnection connection=topicConnectionFactory.createTopicConnection();
		//��������jms�Ự
		TopicSession session=connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		TopicSession session2=connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		//����һ��jms����
		Topic topic=(Topic)ctx.lookup(topicName);
		//����һ��jms�����ߺͶ�����
		TopicPublisher topicPublisher=session.createPublisher(topic);
		TopicSubscriber topicSubscriber=session2.createSubscriber(topic, null, true);//�����Լ�����
		//����һ��jms��Ϣ������
		topicSubscriber.setMessageListener(this);
		//��ʼ��chatӦ�ó���
		this.connection=connection;
		this.topicSession=session;
		this.publisher=topicPublisher;
		this.username=username;
		//����jms���ӣ���������Ϣ
		connection.start();
	}
	
	
	/**
	 * ��������publiser����Ϣ
	 */
	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage=(TextMessage)message;
			System.out.println(textMessage.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ʹ�÷����ߴ�����Ϣ
	 */
	public void createMessage(String text) throws Exception{
		TextMessage textMessage=topicSession.createTextMessage();
		textMessage.setText(text);
		publisher.publish(textMessage);
	}
	
	/**
	 * �ر�jms����
	 */
	public void close() throws Exception{
		connection.close();
	}
	
	/**
	 * ����
	 * @param args
	 * @date 2015��9��29��
	 * @author hyc
	 * @description
	 */
	public static void main(String[] args) throws Exception{
//		if(args.length!=3){
//			System.out.println("Factory,Topic,or username is missing");
//		}
		
		JmsChat chat=new JmsChat("TopicCF","topic1","system");
		System.out.println("������Ҫ���͵���Ϣ:");
		//�������ж�ȡ
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s=br.readLine();
			if(s.equalsIgnoreCase("exit")){
				chat.close();
				System.exit(0);
			}else{
				chat.createMessage(s);
			}
		}
	}

}
