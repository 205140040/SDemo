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
	 * 初始化聊天
	 */
	public  JmsChat(String topicFactory,String topicName,String username) throws Exception{
		//属性配置文件
//		Properties p=new Properties();
//		p.put(Context.SECURITY_PRINCIPAL, "system");
//		p.put(Context.SECURITY_CREDENTIALS, "manager");
//		p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
//		p.put(Context.PROVIDER_URL, "tcp://localhost:61616");
		
		
		//使用jndi属性文件获得jndi链接
		InitialContext ctx=new InitialContext();
		//查找一个jms连接工厂，并创建一个连接
		TopicConnectionFactory topicConnectionFactory=(TopicConnectionFactory)ctx.lookup(topicFactory);
		//连接
		TopicConnection connection=topicConnectionFactory.createTopicConnection();
		//创建两个jms会话
		TopicSession session=connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		TopicSession session2=connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		//查找一个jms主题
		Topic topic=(Topic)ctx.lookup(topicName);
		//创建一个jms发布者和订阅者
		TopicPublisher topicPublisher=session.createPublisher(topic);
		TopicSubscriber topicSubscriber=session2.createSubscriber(topic, null, true);//不被自己订阅
		//设置一个jms消息监听器
		topicSubscriber.setMessageListener(this);
		//初始化chat应用程序
		this.connection=connection;
		this.topicSession=session;
		this.publisher=topicPublisher;
		this.username=username;
		//启动jms连接，允许传递消息
		connection.start();
	}
	
	
	/**
	 * 接受来自publiser的消息
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
	 * 使用发布者创建消息
	 */
	public void createMessage(String text) throws Exception{
		TextMessage textMessage=topicSession.createTextMessage();
		textMessage.setText(text);
		publisher.publish(textMessage);
	}
	
	/**
	 * 关闭jms连接
	 */
	public void close() throws Exception{
		connection.close();
	}
	
	/**
	 * 运行
	 * @param args
	 * @date 2015年9月29日
	 * @author hyc
	 * @description
	 */
	public static void main(String[] args) throws Exception{
//		if(args.length!=3){
//			System.out.println("Factory,Topic,or username is missing");
//		}
		
		JmsChat chat=new JmsChat("TopicCF","topic1","system");
		System.out.println("请输入要发送的消息:");
		//从命令行读取
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
