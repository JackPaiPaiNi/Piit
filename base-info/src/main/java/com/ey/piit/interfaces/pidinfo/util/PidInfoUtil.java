package com.ey.piit.interfaces.pidinfo.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ey.piit.interfaces.pidinfo.dto.PidInfoMsgRequest;
import com.ey.piit.interfaces.pidinfo.dto.PidInfoMsgResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PidInfoUtil {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(PidInfoUtil.class);

	/**
	 * 根据报文实体对象 产生PID申请报文XML字符串
	 * 
	 * @param PidInfoMsgRequest
	 * @return
	 */
	public static String producePidInfoMsgXml(List<PidInfoMsgResponse> list) {
		String xmlParameter = "";
		try {
			PidInfoMsgRequest pidInfoMsgRequest=new PidInfoMsgRequest();
			pidInfoMsgRequest.setData(list);
			XStream xStream = new XStream(new DomDriver());
			xStream.autodetectAnnotations(true);
			xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss",
					null, TimeZone.getTimeZone("GMT+8")));
			xStream.setMode(XStream.NO_REFERENCES);
			xStream.aliasSystemAttribute(null, "class");
			xStream.processAnnotations(PidInfoMsgRequest.class);
		    xStream.processAnnotations(PidInfoMsgResponse.class);
			xmlParameter = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
					+ xStream.toXML(pidInfoMsgRequest);
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
	public static List<PidInfoMsgResponse> transfer(String outXml,String inXml)
			throws Exception {
		List<PidInfoMsgResponse> outList = new ArrayList<PidInfoMsgResponse>();
		try {
			if(!"".equals(outXml)){
				if(!outXml.startsWith("<",0)){
					outXml=outXml.substring(1);
				}
				Document doc = DocumentHelper.parseText(outXml);
				Element rootElt = doc.getRootElement();// 获取根节点PIDINFO
				Element bodyElt = rootElt.element("ROWS");
				Iterator itersElIterator = bodyElt.elementIterator("ROW"); // /获取根节点下的子节点ROW
				// 遍历ROW节点
				while (itersElIterator.hasNext()) {				
					PidInfoMsgResponse pidInfoMsgResponse = new PidInfoMsgResponse();
					Element itemEle = (Element) itersElIterator.next();
					pidInfoMsgResponse.setId(itemEle.elementTextTrim("ID"));
					pidInfoMsgResponse.setCc(itemEle.elementTextTrim("ZZSIZE"));
					pidInfoMsgResponse.setCpfl(itemEle.elementTextTrim("ZZCATEG"));
					pidInfoMsgResponse.setCpxl(itemEle.elementTextTrim("ZZSERIES"));
					pidInfoMsgResponse.setFbl(itemEle.elementTextTrim("ZZRESOL"));
					pidInfoMsgResponse.setJixin(itemEle.elementTextTrim("ZZCLOCKM"));
					pidInfoMsgResponse.setJixing(itemEle.elementTextTrim("ZZMODEL"));
					pidInfoMsgResponse.setPid(itemEle.elementTextTrim("MATNR"));
					pidInfoMsgResponse.setPp(itemEle.elementTextTrim("ZZBRAND"));
					pidInfoMsgResponse.setZhfs(itemEle.elementTextTrim("ZZSHIPW"));
					pidInfoMsgResponse.setMsg(itemEle.elementTextTrim("MSG"));	
					pidInfoMsgResponse.setInXml(inXml);
					outList.add(pidInfoMsgResponse);
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
