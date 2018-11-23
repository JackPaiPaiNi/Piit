package com.ey.piit.sdo.payment.entity;

import java.math.BigDecimal;

import com.ey.piit.core.entity.BaseEntity;

/**
 * PI付款保障勾兑Entity
 * 
 * @author 田荣
 */
public class PayPiBindBlend extends BaseEntity {

	private String dh;//收款单号/LC编号
	private String gddh;//勾兑单号
	private BigDecimal bdje;//绑定金额
	private BigDecimal gdje;//勾兑金额
	private String skdh;//收款单号
	private BigDecimal ye;//余额（绑定金额-勾兑金额）
	private String bzxx;//备注信息
	

	public PayPiBindBlend() {
		super();
	}

	public PayPiBindBlend(String id) {
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

	public String getGddh() {
		return gddh;
	}

	public void setGddh(String gddh) {
		this.gddh = gddh;
	}


}
