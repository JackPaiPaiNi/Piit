package com.ey.piit.sdo.payment.vo;

import java.math.BigDecimal;

import com.ey.piit.sdo.payment.entity.PayPiBindItem;

/**
 * PI付款保障已使用Entity
 * @author 田荣
 */
public class PayPiBindItemVo extends PayPiBindItem {
	
	private String dh;//收款单号/LC编号
	private BigDecimal bdje;//绑定金额
	private BigDecimal gdje;//勾兑金额
	private String skdh;//收款单号
	private BigDecimal ye;//余额（绑定金额-勾兑金额）
	private String bzxx;//备注信息
	private Integer sfWcgd;//是否完成勾兑
	private String fph;//发票号
	private String skbzxx;//收款备注
	public PayPiBindItemVo() {
		super();
	}

	public PayPiBindItemVo(String id){
		super(id);
	}

	public String getDh() {
		return dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	public BigDecimal getBdje() {
		return bdje;
	}

	public void setBdje(BigDecimal bdje) {
		this.bdje = bdje;
	}

	public BigDecimal getGdje() {
		return gdje;
	}

	public void setGdje(BigDecimal gdje) {
		this.gdje = gdje;
	}

	public String getSkdh() {
		return skdh;
	}

	public void setSkdh(String skdh) {
		this.skdh = skdh;
	}

	public BigDecimal getYe() {
		return ye;
	}

	public void setYe(BigDecimal ye) {
		this.ye = ye;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}

	public Integer getSfWcgd() {
		return sfWcgd;
	}

	public void setSfWcgd(Integer sfWcgd) {
		this.sfWcgd = sfWcgd;
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}
	public String getSkbzxx() {
		return skbzxx;
	}

	public void setSkbzxx(String skbzxx) {
		this.skbzxx = skbzxx;
	}

}