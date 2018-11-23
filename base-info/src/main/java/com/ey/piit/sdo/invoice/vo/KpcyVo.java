package com.ey.piit.sdo.invoice.vo;

public class KpcyVo {
	
	private String ddid;//  订单id

	private double jhdje;// 交货单金额

	private double chdhje;// 出货单号金额

	private double cyje;// 差异金额

	private String chdhs;// 订逗号分隔出货单号
	private String ddids;// 订单ids

	public String getChdhs() {
		return chdhs;
	}

	public void setChdhs(String chdhs) {
		this.chdhs = chdhs;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public double getJhdje() {
		return jhdje;
	}

	public void setJhdje(double jhdje) {
		this.jhdje = jhdje;
	}

	public double getChdhje() {
		return chdhje;
	}

	public void setChdhje(double chdhje) {
		this.chdhje = chdhje;
	}

	public double getCyje() {
		return cyje;
	}

	public void setCyje(double cyje) {
		this.cyje = cyje;
	}

	public String getDdids() {
		return ddids;
	}

	public void setDdids(String ddids) {
		this.ddids = ddids;
	}

}
