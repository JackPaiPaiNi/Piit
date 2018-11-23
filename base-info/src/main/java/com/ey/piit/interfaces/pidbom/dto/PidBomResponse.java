package com.ey.piit.interfaces.pidbom.dto;
/**
 * 获取PID BOM数据集的返回实体
 * @author denghai
 *
 */
public class PidBomResponse {
	private String pid;//pid
	/**
	 * MATNR 物料编号  长度18
	 */
	private String wlbh;
	/**
	 * MAKTX 物料描述（短文本） 长度40
	 */
	private String wlms;
	/**
	 * MEINS 基本计量单位 长度 3
	 */
	private String dw;
	/**
	 * MENGE 数量 长度13
	 */
	private Double sl;
	/**
	 * MESSAGE 信息描述 长度100
	 */
	private String msg;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getWlbh() {
		return wlbh;
	}
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}
	public String getWlms() {
		return wlms;
	}
	public void setWlms(String wlms) {
		this.wlms = wlms;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public Double getSl() {
		return sl;
	}
	public void setSl(Double sl) {
		this.sl = sl;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
