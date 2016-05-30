package com.demo.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/email")
public class EmailController {
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("/send")
	@ResponseBody
	public String send() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		String text = "<h1 style='color:red;'>工作流</h1>你好啊，<span style='color:blue;'>spring-mail.</span>";
		mimeMessage.setContent(text, "text/html;charset=UTF-8");// 设置发送类容
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setFrom("18272071121@163.com");// 发送人
		helper.setSubject("新消息"); // 标题
		helper.setTo("447531773@qq.com"); // 发送到
		// FileSystemResource resource = new FileSystemResource(
		// "D://JAVASoft//GitProject//GitRep//maven-spring//src//main//java//com//demo//email//txSmm.png");
		// System.out.println(resource.getFilename());
		// helper.addAttachment(resource.getFilename(),
		// resource.getFile());//添加附件
		mailSender.send(mimeMessage);
		return "success";
	}
}
