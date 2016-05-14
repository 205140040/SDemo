package com.demo.springlistener;

import org.springframework.context.ApplicationListener;

public class MailSendListener implements ApplicationListener<MailSendEvent>{

	@Override
	public void onApplicationEvent(MailSendEvent event) {
		MailSendEvent mse=event;
		System.out.println("MailSendListener向:"+mse.getTo()+"发了邮件");
	}

}
