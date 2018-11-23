package com.ey.piit.interfaces.approve.dto;

import com.ey.piit.interfaces.base.entity.BaseResponse;

/**
 * SAP单据审批流  返回报文 实体
 * @author denghai
 *
 */
public class ApproveMsgResponse  extends BaseResponse{

	private String gsbm;//公司编码
	private String dhhxm;//行项目号
	
	
	public String getGsbm() {
		return gsbm;
	}
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}
	public String getDhhxm() {
		return dhhxm;
	}
	public void setDhhxm(String dhhxm) {
		this.dhhxm = dhhxm;
	}
	
	
}
