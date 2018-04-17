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
 * �ʼ�������
 * @author Mrruan
 *
 */
public class MailAssistantImpl implements MailAssistant {

	private MailSender mailSender;
	
	private SimpleMailMessage templateMailMessage;//���õ�ģ��,�ô�ģ��newһ����Ҫʹ�õľ���message����,���͸��û�����
	
	@Override
	public void passwordToMail(String usermail,String newPsd,String neckname,String oldPsd) {
		//Ϊ���̰߳�ȫ����,��ģ����copyһ��SimpleMailMessage ����
		SimpleMailMessage msg 
			= new SimpleMailMessage(this.templateMailMessage);
		msg.setTo(usermail);
		msg.setText("<h1>�װ���<big style=\"color: red;\">"+ neckname  +"</big>!��������Ѿ����óɹ�!</h1>\r\n" + 
				"		<hr/>\r\n" + 
				"		<h2>�µ�����:<i style=\"color: red;\">"+ newPsd +"</i></h2>\r\n" + 
				"		<p>������Ϊ:<b>"+ oldPsd +"</b>,����֮������������վ�ϵ�¼�����˺�,�����������Ϣ!</p>");
		//�����ʼ�
		try {
			this.mailSender.send(msg);
		} catch (MailException e) {
			System.out.println("[EXCEPTION]:�����ʼ�ʧ��,���͵�" + usermail);
			e.printStackTrace();
		}
	}
	
	@Override
	public void passwordToMailWithInlineResource(String usermail, String newPsd, String neckname, String oldPsd) {
		//�����ʼ�������
		JavaMailSenderImpl sender = (JavaMailSenderImpl) mailSender;
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper  helper;
		try {
			
			helper = new MimeMessageHelper(message, true);
			//��������
			helper.setSubject("�������óɹ�");
			helper.setTo(usermail);
			helper.setFrom("1537854187@qq.com");
			
			helper.setText("<html>\r\n" + 
					"	<body>\r\n" + 
					"		<div style=\"width: 300px; margin: auto;\">\r\n" + 
					"			<h1>�װ���<big style=\"color: red;\">" + neckname +"</big>!��������Ѿ����óɹ�!</h1>\r\n" + 
					"			<hr/>\r\n" + 
					"			<div style=\"width: 171px; height: 167px; margin: auto;\">\r\n" + 
					"				<img src='cid:victory' style=\"width: 171px; margin: auto;\"/>\r\n" + 
					"			</div>\r\n" + 
					"			<h2>�µ�����:<i style=\"color: red;\">" + newPsd + "</i></h2>\r\n" + 
					"			<p>������Ϊ:<b>" + oldPsd + "</b>,����֮������������վ�ϵ�¼�����˺�,�����������Ϣ!</p>\r\n" +
					"           <p>������������У԰������Դ����ƽ̨,�����!<a href=\"#\">У԰������Դ����ƽ̨</a></p>   " +
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>", true);
			//����ͼƬ��Դ
			ClassPathResource res = new ClassPathResource("victory.jpg");
			helper.addInline("victory", res);
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	//getters and setters, spring����bean������ע��
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
		msg.setText("�װ���" + neckname + ",�����������Դ�ѱ�����Ա�ܾ��������Գ����������룡");
		//�����ʼ�
		try {
			this.mailSender.send(msg);
		} catch (MailException e) {
			System.out.println("[EXCEPTION]:�����ʼ�ʧ��,���͵�" + usermail);
			e.printStackTrace();
		}
	}

	@Override
	public void agreeApply(String usermail, String neckname) {
		SimpleMailMessage msg 
		= new SimpleMailMessage(this.templateMailMessage);
		msg.setTo(usermail);
		msg.setText("�װ���" + neckname + ",�����������Դ��ͬ�⣬��׼��������ϵ�ָ���ص������Э����");
		//�����ʼ�
		try {
			this.mailSender.send(msg);
		} catch (MailException e) {
			System.out.println("[EXCEPTION]:�����ʼ�ʧ��,���͵�" + usermail);
			e.printStackTrace();
		}
	}

	@Override
	public void urgeApply(String usermail, String neckname) {
		SimpleMailMessage msg 
		= new SimpleMailMessage(this.templateMailMessage);
		msg.setTo(usermail);
		msg.setText("�װ���" + neckname + ",����Ա�ߴ�������黹��Դ��������ɸ����������⣡");
		//�����ʼ�
		try {
			this.mailSender.send(msg);
		} catch (MailException e) {
			System.out.println("[EXCEPTION]:�����ʼ�ʧ��,���͵�" + usermail);
			e.printStackTrace();
		}
	}

	@Override
	public void agreeReturn(String usermail, String neckname) {
		SimpleMailMessage msg 
		= new SimpleMailMessage(this.templateMailMessage);
		msg.setTo(usermail);
		msg.setText("�װ���" + neckname + ",��ϲ���黹��Դ�ɹ��������ٴ�ʹ�����������룡");
		//�����ʼ�
		try {
			this.mailSender.send(msg);
		} catch (MailException e) {
			System.out.println("[EXCEPTION]:�����ʼ�ʧ��,���͵�" + usermail);
			e.printStackTrace();
		}
	}

}
