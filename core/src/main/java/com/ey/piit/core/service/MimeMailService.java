package com.ey.piit.core.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.activation.URLDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.ey.piit.core.exception.ServiceException;
import com.google.common.collect.Lists;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * MIME邮件服务类.
 * 
 * 由Freemarker引擎生成html格式邮件, 并带有附件.
 * 
 */
public class MimeMailService {

	private static final String DEFAULT_ENCODING = "utf-8";

	private JavaMailSender mailSender;

	private String from;
	
	private Configuration freemarkerConfiguration;
	
	/**
	 * 发邮件
	 * @param recipient 收件人
	 * @param subject 标题
	 * @param content 邮件内容
	 * @throws MessagingException 
	 */
	public void sendEmail(String recipient, String subject, Object content) throws Exception {
		sendEmail(Lists.newArrayList(recipient), subject, content);
	}
	
	/**
	 * 发邮件
	 * @param recipients 收件人
	 * @param subject 标题
	 * @param content 邮件内容
	 * @throws MessagingException 
	 */
	public void sendEmail(List<String> recipients, String subject, Object content) throws Exception {
		// 创建mime类型邮件
		MimeMessage message = mailSender.createMimeMessage();
		try {
			// 设置收件人们
			final int num = recipients.size();
			InternetAddress[] addresses = new InternetAddress[num];
			for (int i = 0; i < num; i++) {
				addresses[i] = new InternetAddress(recipients.get(i));
			}
			message.setRecipients(RecipientType.TO, addresses);
			// 设置发件人
			message.setFrom(new InternetAddress(from));
			// 设置主题
			message.setSubject(subject);
			// 设置邮件内容
			message.setContent(content.toString(), "text/html;charset=utf-8");
			// 发送
			mailSender.send(message);
			//this.saveMailToLocal(message);
		} catch (MailSendException e) {
			Exception[] messageExceptions = e.getMessageExceptions();
			int count = 0;
			for(Exception ex : messageExceptions){
				if(ex.getClass().getName().indexOf("SendFailedException") != -1){
					SendFailedException exSend = (SendFailedException) ex;
					Address[] validUnsentAddresses = exSend.getValidUnsentAddresses();
					// 重新设置收件人
					message.setRecipients(RecipientType.TO, validUnsentAddresses);
					// 发送
					mailSender.send(message);
					count ++;
					break;
				}
			}
			if(count == 0){
				throw e;
			}
		}
	}
	
	/**
	 * 发邮件，带附件
	 * 注意：邮件内容必须是html格式，否则会出现缺字现象
	 * @param recipient 收件人
	 * @param subject 标题
	 * @param content 邮件内容
	 * @param attachment 附件路径
	 * @throws Exception 
	 */
	public void sendEmail(String recipient, String subject, Object content, Collection<String> attachment) throws Exception {
		sendEmail(Lists.newArrayList(recipient), subject, content, attachment);
	}
	
	/**
	 * 发邮件，带附件
	 * 注意：邮件内容必须是html格式，否则会出现缺字现象
	 * @param recipients 收件人
	 * @param subject 标题
	 * @param content 邮件内容
	 * @param attachment 附件路径
	 * @throws Exception 
	 */
	public void sendEmail(List<String> recipients, String subject, Object content, Collection<String> attachment) throws Exception {
		// 创建mime类型邮件
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(message, true, DEFAULT_ENCODING);
			// 设置收件人们
			final int num = recipients.size();
			InternetAddress[] addresses = new InternetAddress[num];
			for (int i = 0; i < num; i++) {
				addresses[i] = new InternetAddress(recipients.get(i));
			}
			helper.setTo(addresses);
			helper.setFrom(new InternetAddress(from));
			helper.setSubject(subject);
			helper.setText(content.toString(), true);
			/**
			 * 考虑附件内容可能较大，发送邮件可能一直处于等待状态。 如果网盘站点挂了其中一个可能出现延时问题
			 */
			if (attachment != null) {
				Iterator<String> iterator = attachment.iterator();
				while (iterator.hasNext()) {
					String fileName = iterator.next();
					String[] _str = fileName.split("\">");
					if(_str.length == 2){
						// 获取链接地址
						URL url = new URL(_str[0]);  
						URLDataSource fds = new URLDataSource(url); //得到数据源
						// 获取文件名称
						helper.addAttachment(_str[1], fds);
					}
				}
			}
			// 发送
			mailSender.send(message);
			//this.saveMailToLocal(message);
		} catch (MailSendException e) {
			Exception[] messageExceptions = e.getMessageExceptions();
			int count = 0;
			for(Exception ex : messageExceptions){
				if(ex.getClass().getName().indexOf("SendFailedException") != -1){
					SendFailedException exSend = (SendFailedException) ex;
					Address[] validUnsentAddresses = exSend.getValidUnsentAddresses();
					
					InternetAddress[] newAddresses = new InternetAddress[validUnsentAddresses.length];
					for (int i = 0; i < validUnsentAddresses.length; i++) {
						newAddresses[i] = new InternetAddress(validUnsentAddresses[i].toString());
					}
					// 重新设置收件人
					helper.setTo(newAddresses);
					// 发送
					mailSender.send(message);
					count ++;
					break;
				}
			}
			if(count == 0){
				throw e;
			}
		}
	}
	
	/**
	 * 根据模板生成内容
	 * @param templateName 模板名
	 * @param model 模板内的站位字符及值
	 * @return 生成的内容
	 */
	public String findContentByTemplate(String templateName, Object model) {
		try {
			Template template = freemarkerConfiguration.getTemplate(templateName, DEFAULT_ENCODING);
			String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
			return content;
		} catch (IOException e) {
			throw new ServiceException("邮件模板不存在"+templateName,e);
		} catch (TemplateException e) {
			throw new ServiceException("生成邮件内容失败"+templateName,e);
		}
	}
	
	/**
	 * 将邮件保存到本地
	 * @param message
	 */
	public void saveMailToLocal(Message message){
		try {
			// 邮件对象  
			File file = new File("D:\\textmail.eml");  
			// 获得输出流  
			OutputStream ips = new FileOutputStream(file);  
			// 把邮件内容写入到文件  
			message.writeTo(ips);  
			// 关闭流  
			ips.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Spring的MailSender.
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setFreemarkerConfiguration(Configuration freemarkerConfiguration) throws IOException {
		this.freemarkerConfiguration = freemarkerConfiguration;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
}
