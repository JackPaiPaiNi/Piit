package com.ey.piit.interfaces.base.entity;

public class BaseResponse {
	private String outXml;//返回报文
	private String dh;//单号
	private String djlx;//单据类型
	private String result;//接口执行结果 成功 "X"
	private String msg;//接口执行返回信息
	private String inXml;//输入报文
	public String getOutXml() {
		return outXml;
	}
	public void setOutXml(String outXml) {
		this.outXml = outXml;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getDjlx() {
		return djlx;
	}
	public void setDjlx(String djlx) {
		this.djlx = djlx;
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
	public String getInXml() {
		return inXml;
	}
	public void setInXml(String inXml) {
		this.inXml = inXml;
	}
}
