package com.demo.service;

import com.demo.entity.User;

public interface AlertService {
	/**
	 * 发送消息
	 * @author Administrator
	 * @param user
	 */
	void sendAlert(User user);
}
