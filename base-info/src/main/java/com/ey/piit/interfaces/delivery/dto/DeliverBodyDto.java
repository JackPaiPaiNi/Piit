package com.ey.piit.interfaces.delivery.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 出货通知书 订单明细接口实体
 * @author denghai
 *
 */
@XStreamAlias("ROW")
public class DeliverBodyDto {
	@XStreamAlias("UPDATE")
	private String update = "";//操作类型
	@XStreamAlias("ROWID")
	private String rowid = "";//序号
	@XStreamAlias("DDH")
	private String ddh = "";//订单号
	@XStreamAlias("SPMC")
	private String spmc = "";//商品名称
	@XStreamAlias("JIXING")
	private String jixing = "";//机型
	@XStreamAlias("KHXH")
	private String khxh = "";//客户型号
	@XStreamAlias("PP")
	private String pp = "";//品牌
	@XStreamAlias("SL")
	private String sl =  "";//数量
	@XStreamAlias("YZHDH")
	private String yzhdh = "";//预走货单号
	@XStreamAlias("BZ")
	private String bz = "";//币种
	@XStreamAlias("JE")
	private String je = "";//金额
	@XStreamAlias("MFJSL")
	private String mfjsl = "";//免费机数量
	@XStreamAlias("DJ")
	private String dj = "";//单价
	@XStreamAlias("FFBSJE")
	private String ffbsje = "";//付费备损金额
	
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
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
	}
	public String getSpmc() {
		return spmc;
	}
	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}
	public String getJixing() {
		return jixing;
	}
	public void setJixing(String jixing) {
		this.jixing = jixing;
	}
	public String getKhxh() {
		return khxh;
	}
	public void setKhxh(String khxh) {
		this.khxh = khxh;
	}
	public String getPp() {
		return pp;
	}
	public void setPp(String pp) {
		this.pp = pp;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getYzhdh() {
		return yzhdh;
	}
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
	
	public String getMfjsl() {
		return mfjsl;
	}
	public void setMfjsl(String mfjsl) {
		this.mfjsl = mfjsl;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getJe() {
		return je;
	}
	public void setJe(String je) {
		this.je = je;
	}
	public String getDj() {
		return dj;
	}
	public void setDj(String dj) {
		this.dj = dj;
	}
	public String getFfbsje() {
		return ffbsje;
	}
	public void setFfbsje(String ffbsje) {
		this.ffbsje = ffbsje;
	}
	

}
