package com.ey.piit.interfaces.charges.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ey.piit.interfaces.charges.dto.ChargesMsgRequest;
import com.ey.piit.interfaces.charges.dto.ChargesMsgResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ChargesUtil {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ChargesUtil.class);

	/**
	 * 根据报文实体对象 产生工装海运费报文XML字符串
	 * 
	 * @param PidInfoMsgRequest
	 * @return
	 */
	public static String produceChargesMsgXml(List<ChargesMsgResponse> list) {
		String xmlParameter = "";
		try {
			ChargesMsgRequest chargesMsgRequest=new ChargesMsgRequest();
			chargesMsgRequest.setData(list);
			XStream xStream = new XStream(new DomDriver());
			xStream.autodetectAnnotations(true);
			xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss",
					null, TimeZone.getTimeZone("GMT+8")));
			xStream.setMode(XStream.NO_REFERENCES);
			xStream.aliasSystemAttribute(null, "class");
			xStream.processAnnotations(ChargesMsgRequest.class);
		    xStream.processAnnotations(ChargesMsgResponse.class);
			xmlParameter = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
					+ xStream.toXML(chargesMsgRequest);
			System.out.println(xmlParameter);
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
	public static List<ChargesMsgResponse> transfer(String outXml,String inXml)
			throws Exception {
		List<ChargesMsgResponse> outList = new ArrayList<ChargesMsgResponse>();
		try {
			if(!"".equals(outXml)){
				if(!outXml.startsWith("<",0)){
					outXml=outXml.substring(1);
				}
				Document doc = DocumentHelper.parseText(outXml);
				Element rootElt = doc.getRootElement();// 获取根节点CHARGES
				Element bodyElt = rootElt.element("BODY");
				Iterator itersElIterator = bodyElt.elementIterator("ROW"); // /获取根节点下的子节点ROW
				// 遍历ROW节点
				while (itersElIterator.hasNext()) {
					ChargesMsgResponse chargeMsgResponse = new ChargesMsgResponse();
					Element itemEle = (Element) itersElIterator.next();
					chargeMsgResponse.setId(itemEle.elementTextTrim("ID"));
					chargeMsgResponse.setGsbm(itemEle.elementTextTrim("GSBM"));
					chargeMsgResponse.setKhbm(itemEle.elementTextTrim("KHBM"));
					chargeMsgResponse.setFprq(itemEle.elementTextTrim("FPRQ"));
					chargeMsgResponse.setJe(itemEle.elementTextTrim("JE"));
					chargeMsgResponse.setLx(itemEle.elementTextTrim("LX"));
					chargeMsgResponse.setMsg(itemEle.elementTextTrim("MSG"));
					chargeMsgResponse.setBz(itemEle.elementTextTrim("BZ"));
					chargeMsgResponse.setPzh(itemEle.elementTextTrim("PZH"));
					chargeMsgResponse.setInXml(inXml);
					outList.add(chargeMsgResponse);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outList;
	}

	public static void main(String[] args) {
		
	}

}
