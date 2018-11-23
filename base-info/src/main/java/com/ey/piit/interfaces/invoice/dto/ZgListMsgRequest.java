package com.ey.piit.interfaces.invoice.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 获取装柜清单请求的出货单号
 * @author tianrong
 *
 */
@XStreamAlias("ZGQD")
public class ZgListMsgRequest {
	
	@XStreamAlias("BODY")
	private List<?> data;

	public Object getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
	
}
