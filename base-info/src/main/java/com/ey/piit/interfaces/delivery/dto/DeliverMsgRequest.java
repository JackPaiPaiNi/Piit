package com.ey.piit.interfaces.delivery.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 推送SAP接口 传入参数实体对象 出货通知书接口
 * @author denghai
 *
 */
@XStreamAlias("DELIVER")
public class DeliverMsgRequest {
	
	@XStreamAlias("HEAD")
	private DeliverHeaderDto msgHeader;
	@XStreamAlias("BODY")
	private List<?> data;

	public Object getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public DeliverHeaderDto getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(DeliverHeaderDto msgHeader) {
		this.msgHeader = msgHeader;
	}

	
}
