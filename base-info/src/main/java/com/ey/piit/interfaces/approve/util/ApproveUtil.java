package com.ey.piit.interfaces.approve.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ey.piit.interfaces.approve.dto.ApproveMsgRequest;
import com.ey.piit.interfaces.approve.dto.ApproveMsgResponse;
import com.ey.piit.interfaces.approve.dto.ApproveBodyDto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ApproveUtil {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ApproveUtil.class);

	/**
	 * 根据报文实体对象 产生 SAP单据审批结果 报文XML字符串
	 * 
	 * @param ApproveMsgRequest
	 * @return
	 */
	public static String produceApproveMsgXml(List<ApproveBodyDto> list) {
		String xmlParameter = "";
		try {
			ApproveMsgRequest approveMsgRequest = new ApproveMsgRequest();
			approveMsgRequest.setData(list);
			XStream xStream = new XStream(new DomDriver());
			xStream.autodetectAnnotations(true);
			xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss",null, TimeZone.getTimeZone("GMT+8")));
			xStream.setMode(XStream.NO_REFERENCES);
			xStream.aliasSystemAttribute(null, "class");
			xStream.processAnnotations(ApproveBodyDto.class);
			xStream.processAnnotations(ApproveMsgRequest.class);
			xmlParameter = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xStream.toXML(approveMsgRequest);
			System.out.println("approvexmlin=>"+xmlParameter);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return xmlParameter;

	}

	/**
	 * 返回报文xml 转换成
	 * 
	 * @param outXml
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List<ApproveMsgResponse> transfer(String outXml,String inXml)
			throws Exception {
		List<ApproveMsgResponse> outlist = new ArrayList<ApproveMsgResponse>();
		try {
			if(!"".equals(outXml)){
				if(!outXml.startsWith("<",0)){
					outXml=outXml.substring(1);
				}
				Document doc = DocumentHelper.parseText(outXml);
				Element rootElt = doc.getRootElement();// 获取根节点APPROVE
				Iterator itersElIterator = rootElt.elementIterator("ROW"); // /获取根节点下的子节点ROW
				// 遍历ROW节点
				while (itersElIterator.hasNext()) {
					ApproveMsgResponse approveMsgResponse = new ApproveMsgResponse();
					Element itemEle = (Element) itersElIterator.next();
					approveMsgResponse.setGsbm(itemEle.element("GSBM").getText());
					approveMsgResponse.setDjlx(itemEle.element("DJLX").getText());
					approveMsgResponse.setDhhxm(itemEle.element("DHHXM").getText());
					approveMsgResponse.setDh(itemEle.element("DH").getText());
					approveMsgResponse.setResult(itemEle.element("RESULT").getText());
					approveMsgResponse.setMsg(itemEle.element("MSG").getText());
					approveMsgResponse.setInXml(inXml);
					outlist.add(approveMsgResponse);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outlist;
	}

	public static void main(String[] args) {
		
	}

}
