package com.ey.piit.webservice.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
/**
 *  提供给SAP发送邮件的接口
 * @author Jun
 *	axis2接口
 */
public class EamilServiceImpl {
	@Autowired
	private EmailService emailService;

	public EamilServiceImpl() {
		// TODO Auto-generated constructor stub
		if (emailService == null) {
			this.emailService = ContextLoader.getCurrentWebApplicationContext().getBean(EmailService.class);
		}
	}

	public String sendEmail(String xmlStr) {
		if (this.emailService == null) {
			// sapEmailService
			this.emailService = ContextLoader.getCurrentWebApplicationContext().getBean(EmailService.class);
		}
		// TODO Auto-generated method stub
		return emailService.sendSapEmail(xmlStr);
	}

}
