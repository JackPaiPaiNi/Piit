package com.ey.piit.interfaces.order.util;

import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ey.piit.interfaces.order.dto.OrderBodyDto;
import com.ey.piit.interfaces.order.dto.OrderHeaderDto;
import com.ey.piit.interfaces.order.dto.OrderMsgRequest;
import com.ey.piit.interfaces.order.dto.OrderMsgResponse;
import com.ey.piit.interfaces.order.dto.OrderZZHeaderDto;
import com.ey.piit.interfaces.order.dto.OrderZZMsgRequest;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class OrderUtil {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(OrderUtil.class);

	/**
	 * 根据报文实体对象
	 * 产生订单通知书报文XML字符串
	 * @param orderHeaderDto
	 * @param list
	 * @return
	 */
	public static String produceOrderMsgXml(OrderHeaderDto orderHeaderDto,List<OrderBodyDto> list){
		String xmlParameter="";
		try {
			OrderMsgRequest orderMsgRequest = new OrderMsgRequest();
			orderMsgRequest.setMsgHeader(orderHeaderDto);
			orderMsgRequest.setData(list);	
			XStream xStream = new XStream(new DomDriver());
			xStream.autodetectAnnotations(true);
			xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));
			xStream.setMode(XStream.NO_REFERENCES);
			xStream.aliasSystemAttribute(null, "class");
			xStream.processAnnotations(OrderMsgRequest.class);
			xStream.processAnnotations(OrderBodyDto.class);
			xmlParameter ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+ xStream.toXML(orderMsgRequest);
			//System.out.println(xmlParameter);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return xmlParameter;

	}
	
	/**
	 * 根据报文实体对象
	 * 产生订单通知书报文XML字符串
	 * @param orderHeaderDto
	 * @param list
	 * @return
	 */
	public static String produceOrderMsgXml(OrderZZHeaderDto orderZZHeaderDto,List<OrderBodyDto> list){
		String xmlParameter="";
		try {
			OrderZZMsgRequest orderZZMsgRequest = new OrderZZMsgRequest();
			orderZZMsgRequest.setMsgZZHeader(orderZZHeaderDto);
			orderZZMsgRequest.setData(list);	
			XStream xStream = new XStream(new DomDriver());
			xStream.autodetectAnnotations(true);
			xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));
			xStream.setMode(XStream.NO_REFERENCES);
			xStream.aliasSystemAttribute(null, "class");
			xStream.processAnnotations(OrderZZMsgRequest.class);
			xStream.processAnnotations(OrderBodyDto.class);
			xmlParameter ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+ xStream.toXML(orderZZMsgRequest);
			//System.out.println(xmlParameter);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return xmlParameter;

	}
	
	/**
	 * 订单Vo对象转换成 DTO对象 按照订单接口传输规则
	 * @param args
	 */
	/**
	 * 返回报文xml 转换成DTO对象
	 * 
	 * @param outXml
	 * @return
	 */
	public static OrderMsgResponse transfer(String outXml)
			throws Exception {
		OrderMsgResponse orderMsgResponse=new OrderMsgResponse();
		try {
            if(!"".equals(outXml)){
            	if(!outXml.startsWith("<",0)){
					outXml=outXml.substring(1);
				}
				Document doc = DocumentHelper.parseText(outXml);
				Element rootElt = doc.getRootElement();// 获取根节点CHARGES
				orderMsgResponse.setDh(rootElt.element("DH").getText());
				orderMsgResponse.setResult(rootElt.element("RESULT").getText());
				orderMsgResponse.setMsg(rootElt.element("MSG").getText());
				orderMsgResponse.setOutXml(outXml);
            }
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return orderMsgResponse;
	}
	
	
	
	public static void main(String[] args){
	
	}

}
