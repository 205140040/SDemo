package com.demo.springlistener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * 自定义邮件监听器事件
 * 
 * @author admin 2016年5月14日
 * @description
 * @ClassName MailSendEvent
 */
public class MailSendEvent extends ApplicationContextEvent {

	private String to;

	public MailSendEvent(ApplicationContext source, String to) {
		super(source);
		this.to = to;
	}

	/**
	 * @author admin 2016年5月14日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	public String getTo() {
		return to;
	}

}
