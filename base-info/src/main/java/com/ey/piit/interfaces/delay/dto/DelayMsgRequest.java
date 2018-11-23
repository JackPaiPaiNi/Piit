package com.ey.piit.interfaces.delay.dto;


/**
 * 推送SAP接口 传入参数实体对象 客户应收超期接口
 * @author denghai
 *
 */

public class DelayMsgRequest {
	
	private String khbm = "";//客户编码
	//private String gsbm = "";//公司编码

	public String getKhbm() {
		return khbm;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	
}
