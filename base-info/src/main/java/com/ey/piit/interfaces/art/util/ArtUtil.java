package com.ey.piit.interfaces.art.util;

import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ey.piit.interfaces.art.dto.ArtBodyDto;
import com.ey.piit.interfaces.art.dto.ArtMsgRequest;
import com.ey.piit.interfaces.art.dto.ArtMsgResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ArtUtil {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ArtUtil.class);

	/**
	 * 根据报文实体对象
	 * 产生美工任务单报文XML字符串
	 * @param list
	 * @return
	 */
	public static String produceArtMsgXml(List<ArtBodyDto> list){
		String xmlParameter = "";
		try {
			ArtMsgRequest artMsgRequest = new ArtMsgRequest();
			artMsgRequest.setData(list);	
			XStream xStream = new XStream(new DomDriver());
			xStream.autodetectAnnotations(true);
			xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));
			xStream.setMode(XStream.NO_REFERENCES);
			xStream.aliasSystemAttribute(null, "class");
			xStream.processAnnotations(ArtMsgRequest.class);
			xStream.processAnnotations(ArtBodyDto.class);
			xmlParameter ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+ xStream.toXML(artMsgRequest);
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
	public static ArtMsgResponse transfer(String outXml) throws Exception {
		ArtMsgResponse artMsgResponse = new ArtMsgResponse();
		try {
            if(!"".equals(outXml)){
            	if(!outXml.startsWith("<",0)){
					outXml = outXml.substring(1);
				}
				Document doc = DocumentHelper.parseText(outXml);
				Element rootElt = doc.getRootElement();// 获取根节点CHARGES
				artMsgResponse.setResult(rootElt.element("RESULT").getText());
				artMsgResponse.setMsg(rootElt.element("MSG").getText());
				artMsgResponse.setOutXml(outXml);
            }
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return artMsgResponse;
	}

}
