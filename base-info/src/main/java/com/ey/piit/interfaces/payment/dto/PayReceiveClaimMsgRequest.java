package com.ey.piit.interfaces.payment.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 推送SAP接口 传入参数实体对象
 * @author tianrong
 *
 */
@XStreamAlias("PAYRECEIVECLAIM")
public class PayReceiveClaimMsgRequest {
	
	@XStreamAlias("BODY")
	private List<?> data;

	public Object getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
	
}
