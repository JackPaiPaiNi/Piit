package com.ey.piit.interfaces.invoice.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 推送SAP接口 传入参数实体对象
 * @author tianrong
 *
 */
@XStreamAlias("INVOICE")
public class InvoiceMsgRequest {
	
	@XStreamAlias("HEAD")
	private InvoiceHeaderDto msgHeader;
	@XStreamAlias("BODY")
	private List<?> data;

	public Object getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public InvoiceHeaderDto getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(InvoiceHeaderDto msgHeader) {
		this.msgHeader = msgHeader;
	}
}
