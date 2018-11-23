package com.ey.piit.interfaces.order.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 推送SAP接口 传入参数实体对象
 * @author denghai
 *
 */
@XStreamAlias("ORDER")
public class OrderMsgRequest {
	
	@XStreamAlias("HEAD")
	private OrderHeaderDto msgHeader;
	@XStreamAlias("BODY")
	private List<?> data;

	public Object getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public OrderHeaderDto getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(OrderHeaderDto msgHeader) {
		this.msgHeader = msgHeader;
	}

	
}
