package com.ey.piit.interfaces.invoice.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ey.piit.interfaces.approve.dto.ApproveMsgResponse;
import com.ey.piit.interfaces.invoice.dto.InvoiceBodyDto;
import com.ey.piit.interfaces.invoice.dto.InvoiceHeaderDto;
import com.ey.piit.interfaces.invoice.dto.InvoiceMsgRequest;
import com.ey.piit.interfaces.invoice.dto.InvoiceMsgResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class InvoiceUtil {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(InvoiceUtil.class);

	/**
	 * 根据报文实体对象
	 * 产生商业发票明细报文XML字符串
	 * @param invoiceHeaderDto
	 * @param list
	 * @return
	 */
	public static String InvoiceMsgXml(InvoiceHeaderDto invoiceHeaderDto,List<InvoiceBodyDto> list){
		String xmlParameter="";
		try {
			InvoiceMsgRequest invoiceMsgRequest = new InvoiceMsgRequest();
			invoiceMsgRequest.setMsgHeader(invoiceHeaderDto);
			invoiceMsgRequest.setData(list);	
			XStream xStream = new XStream(new DomDriver());
			xStream.autodetectAnnotations(true);
			xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));
			xStream.setMode(XStream.NO_REFERENCES);
			xStream.aliasSystemAttribute(null, "class");
			xStream.processAnnotations(InvoiceMsgRequest.class);
			xStream.processAnnotations(InvoiceBodyDto.class);
			xmlParameter ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+ xStream.toXML(invoiceMsgRequest);
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
	public static InvoiceMsgResponse transfer(String outXml)
			throws Exception {
		InvoiceMsgResponse invoiceMsgResponse=new InvoiceMsgResponse();
		try {
            if(!"".equals(outXml)){
            	if(!outXml.startsWith("<",0)){
					outXml=outXml.substring(1);
				}
            	Document doc = DocumentHelper.parseText(outXml);
				Element rootElt = doc.getRootElement();// 获取根节点CHARGES
				invoiceMsgResponse.setDh(rootElt.element("FPH").getText());
				invoiceMsgResponse.setResult(rootElt.element("RESULT").getText());
				invoiceMsgResponse.setMsg(rootElt.element("MSG").getText());
				invoiceMsgResponse.setDjlx("商业发票");
				invoiceMsgResponse.setOutXml(outXml);
            }
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return invoiceMsgResponse;
	}

	@SuppressWarnings("rawtypes")
	public static List<InvoiceMsgResponse> transfernew(String inXml,String outXml)
			throws Exception {
		List<InvoiceMsgResponse> ilist=new ArrayList<InvoiceMsgResponse>();
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
					InvoiceMsgResponse invoiceMsgResponse=new InvoiceMsgResponse();
					Element itemEle = (Element) itersElIterator.next();
					invoiceMsgResponse.setFph(itemEle.element("FPH").getText());
					invoiceMsgResponse.setChdh(itemEle.element("CHDH").getText());
					invoiceMsgResponse.setDdid(itemEle.element("DDH").getText());
					invoiceMsgResponse.setJhdh(itemEle.element("JHDH").getText());
					invoiceMsgResponse.setSapfph(itemEle.element("SAPFP").getText());
					invoiceMsgResponse.setSapfpje(new BigDecimal(itemEle.element("FPJE").getText()));
					invoiceMsgResponse.setSapfplx(Integer.parseInt(itemEle.element("FPLX").getText()));
					invoiceMsgResponse.setResult(itemEle.element("RESULT").getText());
					invoiceMsgResponse.setMsg(itemEle.element("MSG").getText());
					invoiceMsgResponse.setOutXml(outXml);
					invoiceMsgResponse.setInXml(inXml);
					ilist.add(invoiceMsgResponse);
				}
				
				/*Element rootElt = doc.getRootElement();// 获取根节点CHARGES
				Iterator itersElIterator = rootElt.elementIterator("ROW"); // /获取根节点下的子节点ROW
				Element itemEle = (Element) itersElIterator.next();
				invoiceMsgResponse.setDh(itemEle.element("FPH").getText());
				invoiceMsgResponse.setResult(itemEle.element("RESULT").getText());
				invoiceMsgResponse.setMsg(itemEle.element("MSG").getText());
				invoiceMsgResponse.setDjlx("商业发票");
				invoiceMsgResponse.setOutXml(outXml);*/
            }
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return ilist;
	}
	
	public static void main(String[] args){
		try {
			InvoiceMsgResponse imr=InvoiceUtil.transfer("<?xml version=\"1.0\" encoding=\"UTF-8\"?><INVOICE><HEAD><FPH>E</FPH></HEAD><BODY><RESULT>E</RESULT><MSG>该行不存在</MSG></BODY></INVOICE>");
		    System.out.println(imr);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
