package com.ey.piit.sdo.payment.vo;


/**
 * 认领选择发票vo
 * @author 魏诚
 *
 */
public class InvoiceVo {
	
	private String id;
	private String khbm;
	private String fph;
	private String ddid;
	private String tdh;
	private String bz;
	private Double fpje;
	private Double yshje;
	private Double wshje;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKhbm() {
		return khbm;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public String getFph() {
		return fph;
	}
	public String getDdid() {
		return ddid;
	}
	public String getTdh() {
		return tdh;
	}
	public String getBz() {
		return bz;
	}
	public Double getFpje() {
		return fpje;
	}
	public Double getYshje() {
		return yshje;
	}
	public Double getWshje() {
		return wshje;
	}
	public void setFph(String fph) {
		this.fph = fph;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public void setTdh(String tdh) {
		this.tdh = tdh;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public void setFpje(Double fpje) {
		this.fpje = fpje;
	}
	public void setYshje(Double yshje) {
		this.yshje = yshje;
	}
	public void setWshje(Double wshje) {
		this.wshje = wshje;
	}
	
}
