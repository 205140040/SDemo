package com.demo.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.MapMessage;
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

public class QBorrow {
	private QueueConnection qConnet;
	private QueueSession qSession;
	private Queue responseQ;
	private Queue requestQ;

	public QBorrow(String queuecf, String requestQueue, String responseQueue) {
		super();
		try {
			Context ctx = new InitialContext();
			QueueConnectionFactory qFactory = (QueueConnectionFactory) ctx.lookup(queuecf);
			qConnet = qFactory.createQueueConnection();
			qSession = qConnet.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			requestQ = (Queue) ctx.lookup(requestQueue);
			responseQ = (Queue) ctx.lookup(responseQueue);
			qConnet.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendLoanRequest(double salary, double loanAmt) {
		try {
			MapMessage msg = qSession.createMapMessage();
			msg.setDouble("Salary", salary);
			msg.setDouble("LoanAmt", loanAmt);
			msg.setJMSReplyTo(responseQ);
			// 创建发送者，并发送消息
			QueueSender qSender = qSession.createSender(requestQ);
			qSender.send(msg);
			// 等待查看贷款响应
			UUID uuid=UUID.randomUUID();
			System.out.println("uuid:"+uuid.toString());
			String filter = "JMSCorrelationID='" + msg.getJMSMessageID() + "'";
			QueueReceiver qReceiver = qSession.createReceiver(responseQ, filter);
			TextMessage tmsg = (TextMessage) qReceiver.receive(50000);
			if (tmsg == null) {
				System.out.println("no response");
			} else {
				System.out.println("response:" + tmsg.getText());
			}
		} catch (JMSException e) {
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
		QBorrow borrow = new QBorrow("QueueCF", "LoanRequestQ", "LoanResponseQ");
		try {
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("请输入借款信息：");
			while (true) {
				String loanRequest = stdin.readLine();
				if (loanRequest == null || loanRequest.trim().length() <= 0) {
					borrow.exit();
				}
				StringTokenizer st = new StringTokenizer(loanRequest, ",");
				double salary = Double.valueOf(st.nextToken().trim()).doubleValue();
				double loanAmt = Double.valueOf(st.nextToken().trim()).doubleValue();
				borrow.sendLoanRequest(salary, loanAmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
