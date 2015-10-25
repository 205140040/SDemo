package com.demo.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QLender implements MessageListener {
	private QueueConnection qConnet;
	private QueueSession qSession;
	private Queue requestQ;

	public QLender(String queuecf, String requestQueue) {
		super();
		
		try {
			Context ctx = new InitialContext();
			QueueConnectionFactory qFactory = (QueueConnectionFactory) ctx.lookup(queuecf);
			qConnet = qFactory.createQueueConnection();
			qSession = qConnet.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			requestQ = (Queue) ctx.lookup(requestQueue);
			qConnet.start();
			// 创建消息侦听器
			QueueReceiver qReceiver = qSession.createReceiver(requestQ);
			qReceiver.setMessageListener(this);
			System.out.println("等待请求.....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMessage(Message message) {
		try {
			boolean accept = false;
			MapMessage msg = (MapMessage) message;
			double salary = msg.getDouble("Salary");
			double loanAmt = msg.getDouble("loanAmt");
			System.out.println("salary:"+salary+"\tloanAmt:"+loanAmt);
			// 将结果发送回借方
			TextMessage tmsg = qSession.createTextMessage();
			tmsg.setText("yes");
			tmsg.setJMSCorrelationID(message.getJMSMessageID());
			QueueSender qSender = qSession.createSender((Queue) message.getJMSReplyTo());
			qSender.send(tmsg);
			System.out.println("等待借款请求.....");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exit() {
		try {
			qConnet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public static void main(String[] args) {
		QLender lender = new QLender("QueueCF", "LoanRequestQ");
		try {
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("press enter exit：");

			stdin.readLine();
			lender.exit();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
