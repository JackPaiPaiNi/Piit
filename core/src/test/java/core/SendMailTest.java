package core;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SendMailTest {
	
	public static void sendMessage() throws Exception {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("172.20.1.55");
		mailSender.setPort(25);
		mailSender.setUsername("OverseasSDO@skyworth.com");
		mailSender.setPassword("0lkS0823)(7^%9lnu)81");
		
		// 收件人列表
		InternetAddress[] addresses = new InternetAddress[4];
		addresses[0] = new InternetAddress("weicheng@skyworth.com");
		addresses[1] = new InternetAddress("tianrong@skyworth.com");
		addresses[2] = new InternetAddress("gaowenhao@skyworth.com");
		addresses[3] = new InternetAddress("gaowenhao111@skyworth.com");
		
		MimeMessage message = mailSender.createMimeMessage();
		// 设置发件人
		message.setFrom(new InternetAddress("OverseasSDO@skyworth.com"));
		// 设置收件人
		message.setRecipients(RecipientType.TO, addresses);
		// 设置主题
		message.setSubject("测试邮件");
		// 设置邮件内容
		message.setContent("此邮件用于可达测试，收到请忽略！", "text/html;charset=utf-8");
		
		mailSender.send(message);
		
	}
	
	public static void main(String[] args) {
		JavaMailSenderImpl mailSender = null;
		MimeMessage message = null;
		try {
			mailSender = new JavaMailSenderImpl();
			mailSender.setHost("172.20.1.55");
			mailSender.setPort(25);
			mailSender.setUsername("OverseasSDO@skyworth.com");
			mailSender.setPassword("0lkS0823)(7^%9lnu)81");
			
			// 收件人列表
			InternetAddress[] addresses = new InternetAddress[3];
			addresses[0] = new InternetAddress("weicheng@skyworth.com");
			addresses[1] = new InternetAddress("gaowenhao@skyworth.com");
			addresses[2] = new InternetAddress("gaowenhao111@skyworth.com");
			
			message = mailSender.createMimeMessage();
			// 设置发件人
			message.setFrom(new InternetAddress("OverseasSDO@skyworth.com"));
			// 设置收件人
			message.setRecipients(RecipientType.TO, addresses);
			// 设置主题
			message.setSubject("测试邮件");
			// 设置邮件内容
			message.setContent("此邮件用于可达测试，收到请忽略！", "text/html;charset=utf-8");
			
			mailSender.send(message);
		} catch (MailSendException e) {
			Exception[] messageExceptions = e.getMessageExceptions();
			for(Exception ex : messageExceptions){
				if(ex.getClass().getName().indexOf("SendFailedException") != -1){
					SendFailedException exSend = (SendFailedException) ex;
					Address[] validUnsentAddresses = exSend.getValidUnsentAddresses();
					
					try {
						message.setRecipients(RecipientType.TO, validUnsentAddresses);
						mailSender.send(message);
					} catch (MessagingException e1) {
						e1.printStackTrace();
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
