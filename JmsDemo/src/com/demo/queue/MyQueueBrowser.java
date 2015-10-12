package com.demo.queue;

import java.util.Enumeration;

import javax.jms.ConnectionFactory;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MyQueueBrowser {
public static void main(String[] args) {
	try {
		Context ctx=new InitialContext();
		QueueConnectionFactory cFactory=(QueueConnectionFactory)ctx.lookup("QueueCF");
		QueueConnection qConnection=cFactory.createQueueConnection();
		qConnection.start();
		//建立会话
		Queue queue=(Queue)ctx.lookup("LoanRequestQ");
		QueueSession qSession=qConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		QueueBrowser browser=qSession.createBrowser(queue);
		Enumeration e=browser.getEnumeration();
		while(e.hasMoreElements()){
			MapMessage tmsg=(MapMessage)e.nextElement();
			System.out.println("browsing "+tmsg.getJMSMessageID());
		}
		browser.close();
		qConnection.close();
		System.exit(0);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
