package com.ey.piit.interfaces.order.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 订单通知书 物料明细接口实体
 * @author denghai
 *
 */
@XStreamAlias("ROW")
public class OrderBodyDto {
	@XStreamAlias("UPDATE")
	private String update = "";//操作类型
	@XStreamAlias("ROWID")
	private String rowid = "";//序号
	@XStreamAlias("WLBM")
	private String wlbm = "";//物料编码
	@XStreamAlias("XSDW")
	private String xsdw = "";//单位
	@XStreamAlias("SL")
	private String sl = "";//数量
	@XStreamAlias("XMLB")
	private String xmlb = "";//项目类别
	@XStreamAlias("GC")
	private String gc = "";//工厂
	@XStreamAlias("DJ")
	private String dj = "";//单价
	@XStreamAlias("BZ")
	private String bz = "";//币种
	@XStreamAlias("JJYY")
	private String jjyy = "";//拒绝原因
	@XStreamAlias("JGTJ")
	private String jgtj = "";//价格条件  不含税 ZP01 含税 ZP02
	@XStreamAlias("JGDW")
	private String jgdw = "";//价格单位
	
	
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getRowid() {
		return rowid;
	}
	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	public String getWlbm() {
		return wlbm;
	}
	public void setWlbm(String wlbm) {
		this.wlbm = wlbm;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getXmlb() {
		return xmlb;
	}
	public void setXmlb(String xmlb) {
		this.xmlb = xmlb;
	}
	public String getGc() {
		return gc;
	}
	public void setGc(String gc) {
		this.gc = gc;
	}
	public String getDj() {
		return dj;
	}
	public void setDj(String dj) {
		this.dj = dj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getJjyy() {
		return jjyy;
	}
	public void setJjyy(String jjyy) {
		this.jjyy = jjyy;
	}
	public String getJgtj() {
		return jgtj;
	}
	public void setJgtj(String jgtj) {
		this.jgtj = jgtj;
	}
	public String getJgdw() {
		return jgdw;
	}
	public void setJgdw(String jgdw) {
		this.jgdw = jgdw;
	}
	public String getXsdw() {
		return xsdw;
	}
	public void setXsdw(String xsdw) {
		this.xsdw = xsdw;
	}
	

}
