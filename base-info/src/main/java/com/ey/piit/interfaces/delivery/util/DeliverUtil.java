package com.ey.piit.interfaces.delivery.util;

import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ey.piit.interfaces.delivery.dto.DeliverBodyDto;
import com.ey.piit.interfaces.delivery.dto.DeliverHeaderDto;
import com.ey.piit.interfaces.delivery.dto.DeliverMsgRequest;
import com.ey.piit.interfaces.delivery.dto.DeliverMsgResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class DeliverUtil {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(DeliverUtil.class);

	/**
	 * 根据报文实体对象
	 * 产生出货通知书报文XML字符串
	 * @param DelayHeaderDto
	 * @param list
	 * @return
	 */
	public static String produceDeliverMsgXml(DeliverHeaderDto deliverHeaderDto,List<DeliverBodyDto> list){
		String xmlParameter="";
		try {
			DeliverMsgRequest deliverMsgRequest = new DeliverMsgRequest();
			deliverMsgRequest.setMsgHeader(deliverHeaderDto);
			deliverMsgRequest.setData(list);	
			XStream xStream = new XStream(new DomDriver());
			xStream.autodetectAnnotations(true);
			xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));
			xStream.setMode(XStream.NO_REFERENCES);
			xStream.aliasSystemAttribute(null, "class");
			xStream.processAnnotations(DeliverMsgRequest.class);
			xStream.processAnnotations(DeliverBodyDto.class);
			xmlParameter ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+ xStream.toXML(deliverMsgRequest);
			System.out.println(xmlParameter);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return xmlParameter;

	}
	
	/**
	 * 返回报文xml 转换成DTO对象
	 * 
	 * @param outXml
	 * @return
	 */
	public static DeliverMsgResponse transfer(String outXml)
			throws Exception {
		DeliverMsgResponse deliverMsgResponse=new DeliverMsgResponse();
		try {
            if(!"".equals(outXml)){
            	if(!outXml.startsWith("<",0)){
					outXml=outXml.substring(1);
				}
				Document doc = DocumentHelper.parseText(outXml);
				Element rootElt = doc.getRootElement();// 获取根节点CHARGES
				deliverMsgResponse.setDh(rootElt.element("CHDH").getText());
				deliverMsgResponse.setDjlx("出货通知书");
				deliverMsgResponse.setResult(rootElt.element("RESULT").getText());
				deliverMsgResponse.setMsg(rootElt.element("MSG").getText());
				deliverMsgResponse.setOutXml(outXml);
            }
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return deliverMsgResponse;
	}


	
	public static void main(String[] args){
	
	}

}
