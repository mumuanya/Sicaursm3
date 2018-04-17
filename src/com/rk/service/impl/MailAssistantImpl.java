package com.rk.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.rk.service.MailAssistant;

/**
 * 邮件发送类
 * @author Mrruan
 *
 */
public class MailAssistantImpl implements MailAssistant {

	private MailSender mailSender;
	
	private SimpleMailMessage templateMailMessage;//配置的模板,用此模板new一个需要使用的具体message对象,发送给用户邮箱
	
	@Override
	public void passwordToMail(String usermail,String newPsd,String neckname,String oldPsd) {
		//为了线程安全着想,从模板中copy一个SimpleMailMessage 对象
		SimpleMailMessage msg 
			= new SimpleMailMessage(this.templateMailMessage);
		msg.setTo(usermail);
		msg.setText("<h1>亲爱的<big style=\"color: red;\">"+ neckname  +"</big>!你的密码已经重置成功!</h1>\r\n" + 
				"		<hr/>\r\n" + 
				"		<h2>新的密码:<i style=\"color: red;\">"+ newPsd +"</i></h2>\r\n" + 
				"		<p>旧密码为:<b>"+ oldPsd +"</b>,除此之外您可以在网站上登录您的账号,并重置相关信息!</p>");
		//发送邮件
		try {
			this.mailSender.send(msg);
		} catch (MailException e) {
			System.out.println("[EXCEPTION]:发送邮件失败,发送到" + usermail);
			e.printStackTrace();
		}
	}
	
	@Override
	public void passwordToMailWithInlineResource(String usermail, String newPsd, String neckname, String oldPsd) {
		//定义邮件发送器
		JavaMailSenderImpl sender = (JavaMailSenderImpl) mailSender;
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper  helper;
		try {
			
			helper = new MimeMessageHelper(message, true);
			//设置内容
			helper.setSubject("密码重置成功");
			helper.setTo(usermail);
			helper.setFrom("1537854187@qq.com");
			
			helper.setText("<html>\r\n" + 
					"	<body>\r\n" + 
					"		<div style=\"width: 300px; margin: auto;\">\r\n" + 
					"			<h1>亲爱的<big style=\"color: red;\">" + neckname +"</big>!你的密码已经重置成功!</h1>\r\n" + 
					"			<hr/>\r\n" + 
					"			<div style=\"width: 171px; height: 167px; margin: auto;\">\r\n" + 
					"				<img src='cid:victory' style=\"width: 171px; margin: auto;\"/>\r\n" + 
					"			</div>\r\n" + 
					"			<h2>新的密码:<i style=\"color: red;\">" + newPsd + "</i></h2>\r\n" + 
					"			<p>旧密码为:<b>" + oldPsd + "</b>,除此之外您可以在网站上登录您的账号,并重置相关信息!</p>\r\n" +
					"           <p>以上内容来自校园公共资源借用平台,请勿答复!<a href=\"#\">校园公共资源借用平台</a></p>   " +
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>", true);
			//加载图片资源
			ClassPathResource res = new ClassPathResource("victory.jpg");
			helper.addInline("victory", res);
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	//getters and setters, spring进行bean的依赖注入
	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public SimpleMailMessage getTemplateMailMessage() {
		return templateMailMessage;
	}

	public void setSimpleMailMessage(SimpleMailMessage templateMailMessage) {
		this.templateMailMessage = templateMailMessage;
	}

	@Override
	public void refuseApply(String usermail, String neckname) {
		SimpleMailMessage msg 
		= new SimpleMailMessage(this.templateMailMessage);
		msg.setTo(usermail);
		msg.setText("亲爱的" + neckname + ",您所申请的资源已被管理员拒绝，您可以尝试重新申请！");
		//发送邮件
		try {
			this.mailSender.send(msg);
		} catch (MailException e) {
			System.out.println("[EXCEPTION]:发送邮件失败,发送到" + usermail);
			e.printStackTrace();
		}
	}

	@Override
	public void agreeApply(String usermail, String neckname) {
		SimpleMailMessage msg 
		= new SimpleMailMessage(this.templateMailMessage);
		msg.setTo(usermail);
		msg.setText("亲爱的" + neckname + ",您所申请的资源已同意，请准备相关资料到指定地点做相关协调！");
		//发送邮件
		try {
			this.mailSender.send(msg);
		} catch (MailException e) {
			System.out.println("[EXCEPTION]:发送邮件失败,发送到" + usermail);
			e.printStackTrace();
		}
	}

	@Override
	public void urgeApply(String usermail, String neckname) {
		SimpleMailMessage msg 
		= new SimpleMailMessage(this.templateMailMessage);
		msg.setTo(usermail);
		msg.setText("亲爱的" + neckname + ",管理员催促您尽快归还资源，以免造成个人信誉问题！");
		//发送邮件
		try {
			this.mailSender.send(msg);
		} catch (MailException e) {
			System.out.println("[EXCEPTION]:发送邮件失败,发送到" + usermail);
			e.printStackTrace();
		}
	}

	@Override
	public void agreeReturn(String usermail, String neckname) {
		SimpleMailMessage msg 
		= new SimpleMailMessage(this.templateMailMessage);
		msg.setTo(usermail);
		msg.setText("亲爱的" + neckname + ",恭喜您归还资源成功！如需再次使用请重新申请！");
		//发送邮件
		try {
			this.mailSender.send(msg);
		} catch (MailException e) {
			System.out.println("[EXCEPTION]:发送邮件失败,发送到" + usermail);
			e.printStackTrace();
		}
	}

}
