package com.ey.piit.interfaces.art.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 推送SAP接口 传入参数实体对象 美工任务单接口
 * @author 魏诚
 *
 */
@XStreamAlias("BODY")
public class ArtMsgRequest {
	
	@XStreamAlias("ROWS")
	private List<?> data;

	public Object getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
	
}
