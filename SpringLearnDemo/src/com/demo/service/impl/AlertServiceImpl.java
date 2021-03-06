package com.demo.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.service.AlertService;
/**
 * 发送JMS消息实现类
 * @author Administrator
 *
 */
@Service("alertService")
public class AlertServiceImpl implements AlertService {
	/*@Autowired
	private JmsTemplate jmsTemplate;//注入jms模板
*/
	@Override
	public void sendAlert(final User user) {
		System.out.println("jms sender");
		/*// TODO Auto-generated method stub
		jmsTemplate.send(//发送消息
			"SpringLeranDemo.alert.queue", new MessageCreator() {//指定目的地
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createObjectMessage(user);//创建消息
			}
		});*/
	}

}
