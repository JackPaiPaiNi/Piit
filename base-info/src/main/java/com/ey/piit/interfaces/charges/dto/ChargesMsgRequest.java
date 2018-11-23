package com.ey.piit.interfaces.charges.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 推送SAP接口 传入参数实体对象 工装海运费推送接口
 * @author denghai
 *
 */
@XStreamAlias("CHARGES")
public class ChargesMsgRequest {
	
	@XStreamAlias("BODY")
	private List<?> data;

	public Object getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}


	
}
