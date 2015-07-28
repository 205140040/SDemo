package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import com.demo.entity.User;
import com.demo.service.MyMailService;


/**
 * @description 邮件服务类
 * @author Administrator
 *
 */
@Service(value="myMailService")
public class MyMailServiceImpl implements MyMailService {

	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * 发送邮件
	 * @param to
	 * @param user
	 * @throws MessagingException 
	 */
	@Override
	public void sendEmail(String to,User user) throws MessagingException{
		//使用JavaMail的MimeMessage，支付更加复杂的邮件格式和内容
		MimeMessage message=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);//使用MimeMessageHelper，设置参数
		
		helper.setFrom("18272071121@163.com");//发送邮箱
		helper.setTo(to);//发送目的地
		message.setSubject("New Mail from "+user.getName());//设置主题
		message.setText("你好这是一封来自:"+user.getName()+"的邮件：hello !");//设置邮件内容
		mailSender.send(message);//发送邮件
	}
	
}
