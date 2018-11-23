package com.ey.piit.interfaces.payment.util;


import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ey.piit.interfaces.payment.dto.PayReceiveBodyDto;
import com.ey.piit.interfaces.payment.dto.PayReceiveMsgRequest;
import com.ey.piit.interfaces.payment.dto.PayReceiveMsgResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PayReceiveUtil {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(PayReceiveUtil.class);

	/**
	 * 根据报文实体对象
	 * 产生收款登記报文XML字符串
	 * @param list
	 * @return
	 */
	public static String payreceiveMsgXml(List<PayReceiveBodyDto> list){
		PayReceiveMsgRequest orderMsgRequest = new PayReceiveMsgRequest();
		orderMsgRequest.setData(list);
		
		XStream xStream = new XStream(new DomDriver());
		xStream.autodetectAnnotations(true);
		xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));
		xStream.setMode(XStream.NO_REFERENCES);
		xStream.aliasSystemAttribute(null, "class");
		xStream.processAnnotations(PayReceiveMsgRequest.class);
		xStream.processAnnotations(PayReceiveBodyDto.class);
		
		String xmlParameter ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+ xStream.toXML(orderMsgRequest);
		return xmlParameter;

	}

	/**
	 * 解析返回报文
	 * @param prcxml
	 */
	@SuppressWarnings({ "unused", "rawtypes" })
	public static PayReceiveMsgResponse ReadPayreceiveXml(String outXml,String inXml){	
		PayReceiveMsgResponse payReceiveMsgResponse = new PayReceiveMsgResponse();
		Document doc=null;
		try{
            // 下面的是通过解析xml字符串的
			if(!outXml.startsWith("<",0)){
				outXml=outXml.substring(1);
			}
			doc = DocumentHelper.parseText(outXml);
			Element rootElt = doc.getRootElement();// 获取根节点CHARGES
			Iterator itersElIterator = rootElt.elementIterator("ROW"); // /获取根节点下的子节点ROW
			Element itemEle = (Element) itersElIterator.next();
			payReceiveMsgResponse.setDh(itemEle.elementTextTrim("SKDH"));
			payReceiveMsgResponse.setResult(itemEle.elementTextTrim("RESULT"));
			payReceiveMsgResponse.setMsg(itemEle.elementTextTrim("MSG"));
			payReceiveMsgResponse.setDjlx("收款登記");
			payReceiveMsgResponse.setOutXml(outXml);
		} catch (Exception e) {
            e.printStackTrace();  
        } 	
		return payReceiveMsgResponse;
	}
	
	public static void main(String[] args){
	
	}

}
