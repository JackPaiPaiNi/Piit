package com.ey.piit.webservice.email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.service.MimeMailService;

@Service("sapEmailService")
public class EmailService {

	@Autowired
	private MimeMailService mimeMailService;// 邮件服务类

	/**
	 * 
	 * @param xmlStr
	 *            XML字符串
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String sendSapEmail(String xmlStr) {
		// 收件人 标题 邮件内容
		// sendEmail(List<String> recipients, String subject, Object content)
		StringBuffer strs = new StringBuffer("<MAIL>");
		try {
			Map<Object, Object> map = analysisXml(xmlStr);
			List<String> recipients = (List<String>) map.get("recipients");
			String subject = (String) map.get("subject");
			String content = (String) map.get("content");
			mimeMailService.sendEmail(recipients, subject, content);
			strs.append("<RESULT>1</RESULT>").append("<MSG>发送成功</MSG>");
		} catch (Exception e) {
			e.printStackTrace();
			strs.append("<RESULT>0</RESULT>").append("<MSG>发送失败！").append(e.getMessage()).append("</MSG>");
		} finally {
			strs.append("</MAIL>");
		}
		return strs.toString();
	}

	@SuppressWarnings("unchecked")
	private Map<Object, Object> analysisXml(String xmlStr) throws Exception {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Document doc = null;
		System.err.println("XMLStr："+xmlStr);
		try {
			doc = DocumentHelper.parseText(xmlStr.substring(xmlStr.indexOf("<")));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("XML字符串解析错误！检查格式 XMLString：" + xmlStr);
		}
		Element rootElt = doc.getRootElement(); // 获取根节点
		StringBuffer subject=new StringBuffer();
		Element headElt = rootElt.element("HEAD");
		subject.append("装柜清单 | ").append(headElt.elementTextTrim("CHDNO")).append(" | ").append(headElt.elementTextTrim("KHNAME"));
		Element detailMalElt = rootElt.element("BODY").element("DETAIL1");
		
		List<String> recipients = new ArrayList<String>();
		List<Element> emailRows = detailMalElt.elements("ROW");
		
		for (Element element : emailRows) {
			recipients.add(element.elementTextTrim("MAIL_AD"));
		}
		StringBuffer content = new StringBuffer();
		content.append("订单号：");
		Element detailDdhElt = rootElt.element("BODY").element("DETAIL2");
		List<Element> ddhRows=detailDdhElt.elements("ROW");
		for (Element element : ddhRows) {
			content.append(element.elementTextTrim("DDH")).append(" | ");
		}
		if(content.toString().endsWith(" | ")){
			content.delete(content.length()-3,content.length());
		}
		content.append("<br/>");
		content.append("业务单据：装柜清单").append("<br/>");
		content.append("提交人：").append(headElt.elementTextTrim("TJNAME")).append("<br/>");
		map.put("subject", subject.toString());
		map.put("content", content.toString());
		map.put("recipients", recipients);
		return map;

	}
}
