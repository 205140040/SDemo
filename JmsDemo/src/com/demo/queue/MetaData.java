package com.demo.queue;

import java.util.Enumeration;

import javax.jms.ConnectionMetaData;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MetaData {
public static void main(String[] args) {
	try {
		Context ctx = new InitialContext();
		QueueConnectionFactory qFactory=(QueueConnectionFactory)ctx.lookup("QueueCF");
		QueueConnection qConnection=qFactory.createQueueConnection();
		ConnectionMetaData metaData=qConnection.getMetaData();
		System.out.println("jms version:"+metaData.getJMSMajorVersion()+"."+metaData.getJMSMinorVersion());
		System.out.println("jms provider:"+metaData.getJMSProviderName());
		System.out.println("jms properties:");
		Enumeration e=metaData.getJMSXPropertyNames();
		while(e.hasMoreElements()){
			System.out.println(" "+e.nextElement());
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

}
}
