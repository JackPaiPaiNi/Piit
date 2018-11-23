package com.ey.piit.sdo.payment.vo;

import java.math.BigDecimal;

import com.ey.piit.sdo.payment.entity.PayPiBindBlend;


/**
 * PI付款保障勾兑Entity
 * @author 田荣
 */
public class PayPiBindBlendVo extends PayPiBindBlend {

	private String piid;
	private String fklx;
	private Integer sfWcgd;
	private String bz;
	private BigDecimal ygdje;//已勾兑金额
	private String zdrid;
	private String zdrmc;

	
	public PayPiBindBlendVo() {
		super();
	}

	public PayPiBindBlendVo(String id){
		super(id);
	}

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public String getFklx() {
		return fklx;
	}

	public void setFklx(String fklx) {
		this.fklx = fklx;
	}

	public Integer getSfWcgd() {
		return sfWcgd;
	}

	public void setSfWcgd(Integer sfWcgd) {
		this.sfWcgd = sfWcgd;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public BigDecimal getYgdje() {
		return ygdje;
	}

	public void setYgdje(BigDecimal ygdje) {
		this.ygdje = ygdje;
	}

	public String getZdrid() {
		return zdrid;
	}

	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}

	public String getZdrmc() {
		return zdrmc;
	}

	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
	}

	
	
	
}