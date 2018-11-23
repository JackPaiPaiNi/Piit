package com.ey.piit.interfaces.pidinfo.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 推送SAP接口 传入参数实体对象 PID申请推送接口
 * @author denghai
 *
 */


@XStreamAlias("PIDINFO")
public class PidInfoMsgRequest {
	
	@XStreamAlias("ROWS")
	private List<?> data;

	public Object getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}


	
}
