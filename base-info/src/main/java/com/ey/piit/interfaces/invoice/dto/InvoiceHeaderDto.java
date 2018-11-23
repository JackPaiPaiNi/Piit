package com.ey.piit.interfaces.invoice.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 商业发票明细 接口传输实体
 * @author tianrong
 *
 */
@XStreamAlias("HEAD")
public class InvoiceHeaderDto {
	@XStreamAlias("GSBM")
	private String gsbm="";//公司编码
	@XStreamAlias("KHBM")
	private String khbm="";//客户编码
	@XStreamAlias("ZXBDM")
	private String zxbdm="";//中信保代码
	@XStreamAlias("FPH")
	private String fph="";//发票号
	@XStreamAlias("JE")
	private String je="";//发票金额
	@XStreamAlias("SJKPZJE")
	private String sjkpzje="";//发票金额
	@XStreamAlias("KPRQ")
	private String kprq="";//开票日期
	@XStreamAlias("QYRQ")
	private String qyrq="";//起运日期
	@XStreamAlias("YJDDQ")
	private String yjddq="";//预计抵达日期
	@XStreamAlias("CYLX")
	private String cylx="";//装运方式 出运类型
	@XStreamAlias("FKTJ")
	private String fktj="";//付款条件
	@XStreamAlias("GJMYTJ")
	private String gjmytj="";//贸易条款
	@XStreamAlias("GJMYTJBZ")
	private String gjmytjbz="";//贸易条款备注
	@XStreamAlias("BZ")
	private String bz="";//币种
	@XStreamAlias("TDH")
	private String tdh="";//提单号
	@XStreamAlias("LCBH")
	private String lcbh="";//LC编号
	@XStreamAlias("HGBM")
	private String hgbm="";//海关编码
	@XStreamAlias("KZHDM")
	private String kzhdm="";//开证行代码SWIFT
	@XStreamAlias("KPFS")
	private String kpfs="";//开票方式
	@XStreamAlias("FPLX")
	private String fplx="";//发票类型

	
	public String getSjkpzje() {
		return sjkpzje;
	}
	public void setSjkpzje(String sjkpzje) {
		this.sjkpzje = sjkpzje;
	}
	public String getGsbm() {
		return gsbm;
	}
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}
	public String getKhbm() {
		return khbm;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public String getZxbdm() {
		return zxbdm;
	}
	public void setZxbdm(String zxbdm) {
		this.zxbdm = zxbdm;
	}
	public String getFph() {
		return fph;
	}
	public void setFph(String fph) {
		this.fph = fph;
	}
	public String getJe() {
		return je;
	}
	public void setJe(String je) {
		this.je = je;
	}
	public String getKprq() {
		return kprq;
	}
	public void setKprq(String kprq) {
		this.kprq = kprq;
	}
	public String getQyrq() {
		return qyrq;
	}
	public void setQyrq(String qyrq) {
		this.qyrq = qyrq;
	}
	public String getYjddq() {
		return yjddq;
	}
	public void setYjddq(String yjddq) {
		this.yjddq = yjddq;
	}
	public String getCylx() {
		return cylx;
	}
	public void setCylx(String cylx) {
		this.cylx = cylx;
	}
	public String getFktj() {
		return fktj;
	}
	public void setFktj(String fktj) {
		this.fktj = fktj;
	}
	public String getGjmytj() {
		return gjmytj;
	}
	public void setGjmytj(String gjmytj) {
		this.gjmytj = gjmytj;
	}
	public String getGjmytjbz() {
		return gjmytjbz;
	}
	public void setGjmytjbz(String gjmytjbz) {
		this.gjmytjbz = gjmytjbz;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getTdh() {
		return tdh;
	}
	public void setTdh(String tdh) {
		this.tdh = tdh;
	}
	public String getLcbh() {
		return lcbh;
	}
	public void setLcbh(String lcbh) {
		this.lcbh = lcbh;
	}
	
	public String getHgbm() {
		return hgbm;
	}
	public void setHgbm(String hgbm) {
		this.hgbm = hgbm;
	}
	public String getKzhdm() {
		return kzhdm;
	}
	public void setKzhdm(String kzhdm) {
		this.kzhdm = kzhdm;
	}
	public String getKpfs() {
		return kpfs;
	}
	public void setKpfs(String kpfs) {
		this.kpfs = kpfs;
	}
	public String getFplx() {
		return fplx;
	}
	public void setFplx(String fplx) {
		this.fplx = fplx;
	}

}
