package com.ey.piit.interfaces.invoice.dto;

import java.math.BigDecimal;

import com.ey.piit.interfaces.base.entity.BaseResponse;

public class InvoiceMsgResponse extends BaseResponse {
	private String fph;//发票号
	private String chdh;//出货单号
	private String ddid;//订单id
	private String jhdh;//交货单号
	private String sapfph;//sap发票号
	private BigDecimal sapfpje;//sap发票金额
	private Integer sapfplx;//sap发票类型
	
	public String getFph() {
		return fph;
	}
	public void setFph(String fph) {
		this.fph = fph;
	}
	public String getChdh() {
		return chdh;
	}
	public void setChdh(String chdh) {
		this.chdh = chdh;
	}
	public String getDdid() {
		return ddid;
	}
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	public String getJhdh() {
		return jhdh;
	}
	public void setJhdh(String jhdh) {
		this.jhdh = jhdh;
	}
	public String getSapfph() {
		return sapfph;
	}
	public void setSapfph(String sapfph) {
		this.sapfph = sapfph;
	}
	public BigDecimal getSapfpje() {
		return sapfpje;
	}
	public void setSapfpje(BigDecimal sapfpje) {
		this.sapfpje = sapfpje;
	}
	public Integer getSapfplx() {
		return sapfplx;
	}
	public void setSapfplx(Integer sapfplx) {
		this.sapfplx = sapfplx;
	}
	
	
}
