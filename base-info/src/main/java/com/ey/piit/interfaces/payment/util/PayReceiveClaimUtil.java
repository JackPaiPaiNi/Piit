package com.ey.piit.interfaces.payment.util;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ey.piit.interfaces.payment.dto.PayReceiveClaimBodyDto;
import com.ey.piit.interfaces.payment.dto.PayReceiveClaimMsgRequest;
import com.ey.piit.interfaces.payment.dto.PayReceiveClaimMsgResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PayReceiveClaimUtil {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(PayReceiveClaimUtil.class);

	/**
	 * 根据报文实体对象
	 * 产生收款认领报文XML字符串
	 * @param list
	 * @return
	 */
	public static String payreceiveclaimMsgXml(List<PayReceiveClaimBodyDto> list){
		PayReceiveClaimMsgRequest orderMsgRequest = new PayReceiveClaimMsgRequest();
		orderMsgRequest.setData(list);
		
		XStream xStream = new XStream(new DomDriver());
		xStream.autodetectAnnotations(true);
		xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));
		xStream.setMode(XStream.NO_REFERENCES);
		xStream.aliasSystemAttribute(null, "class");
		xStream.processAnnotations(PayReceiveClaimMsgRequest.class);
		xStream.processAnnotations(PayReceiveClaimBodyDto.class);
		
		String xmlParameter ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+ xStream.toXML(orderMsgRequest);
		return xmlParameter;

	}

	/**
	 * 解析返回报文
	 * @param prcxml
	 */
	@SuppressWarnings("rawtypes")
	public static List<PayReceiveClaimMsgResponse> ReadPayreceiveclaimXml(String outXml,String inXml){	
		List<PayReceiveClaimMsgResponse> list = new ArrayList<PayReceiveClaimMsgResponse>();	
		Document doc=null;
		try{
            // 下面的是通过解析xml字符串的
			if(!outXml.startsWith("<",0)){
				outXml=outXml.substring(1);
			}
			doc=DocumentHelper.parseText(outXml);
			Element rootElt = doc.getRootElement();// 获取根节点BODY
			Iterator itersElIterator = rootElt.elementIterator("ROW"); // /获取根节点下的子节点ROW
			// 遍历ROW节点
			while (itersElIterator.hasNext()) {
				PayReceiveClaimMsgResponse prc = new PayReceiveClaimMsgResponse();
				Element itemEle = (Element) itersElIterator.next();
				String rldh = itemEle.elementTextTrim("RLDH"); // 拿到BODY下的子节点ROW下的子节点RLDH的值
				String skdh = itemEle.elementTextTrim("SKDH");
				String result = itemEle.elementTextTrim("RESULT");
				String msg = itemEle.elementTextTrim("MSG");
				prc.setDh(rldh);
				prc.setSkdh(skdh);
				prc.setResult(result);
				prc.setMsg(msg);
				prc.setInXml(inXml);
				list.add(prc);
			}
		} catch (Exception e) {
            e.printStackTrace();  
        } 	
		return list;
	}
	
	public static void main(String[] args){
	
	}

}
