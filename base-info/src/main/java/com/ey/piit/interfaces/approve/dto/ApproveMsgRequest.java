package com.ey.piit.interfaces.approve.dto;


import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 *  推送SAP接口 传入参数实体对象  SAP审批流单据审批处理接口
 * @author denghai
 *
 */
@XStreamAlias("APPROVE")
public class ApproveMsgRequest {
	@XStreamImplicit
	private List<?> data;

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
	
	
}
