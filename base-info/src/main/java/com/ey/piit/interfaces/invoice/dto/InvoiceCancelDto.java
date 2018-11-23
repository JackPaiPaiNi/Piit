package com.ey.piit.interfaces.invoice.dto;

public class InvoiceCancelDto {
	private String fph;//发票号
	private String sapfph;//SAP销售发票号、公司间发票号
	private String fplx;//发票类型 1销售发票 2公司间发票
	private String cxrq;//冲销日期
	private String result;//冲销结果标记
	private String msg;//消息
	public String getFph() {
		return fph;
	}
	public void setFph(String fph) {
		this.fph = fph;
	}
	public String getSapfph() {
		return sapfph;
	}
	public void setSapfph(String sapfph) {
		this.sapfph = sapfph;
	}
	public String getCxrq() {
		return cxrq;
	}
	public void setCxrq(String cxrq) {
		this.cxrq = cxrq;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getFplx() {
		return fplx;
	}
	public void setFplx(String fplx) {
		this.fplx = fplx;
	}
	
	

}
