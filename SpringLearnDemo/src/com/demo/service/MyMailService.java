package com.demo.service;

import javax.mail.MessagingException;

import com.demo.entity.User;

public interface MyMailService {

	/**
	 * 发送邮件
	 * @param to
	 * @param user
	 * @throws MessagingException 
	 */
	void sendEmail(String to, User user) throws MessagingException;

}