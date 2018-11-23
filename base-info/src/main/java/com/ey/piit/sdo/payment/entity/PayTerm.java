package com.ey.piit.sdo.payment.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 付款条件设置（付款方式）Entity
 * @author 田荣
 */
public class PayTerm extends BaseEntity {
	
	private String fktjdm;		// 付款条件代码
	private String fktjms;		// 付款条件描述
	private Double xdTt;		// 下单时TT
	private Double ckTt;		// 出库时TT
	private Double xdLc;		// 下单时LC
	private Double xdOa;		// 下单时OA
	private Double xdDp;		// 下单时DP
	private Double zq;		    // 账期
	private Integer zt;			// 状态 1有效 0无效
	
	public PayTerm() {
		super();
	}

	public PayTerm(String id){
		super(id);
	}

	/**
     * 付款条件代码
     */
	@Length(min=1, max=20, message="付款条件代码长度必须介于 1 和 20 之间")
	public String getFktjdm() {
		return fktjdm;
	}

	/**
     * 付款条件代码
     */
	public void setFktjdm(String fktjdm) {
		this.fktjdm = fktjdm == null ? null : fktjdm.trim();
	}
	
	/**
     * 付款条件描述
     */
	@Length(min=0, max=100, message="付款条件描述长度必须介于 0 和 100 之间")
	public String getFktjms() {
		return fktjms;
	}

	/**
     * 付款条件描述
     */
	public void setFktjms(String fktjms) {
		this.fktjms = fktjms == null ? null : fktjms.trim();
	}
	
	/**
     * 下单时TT
     */
	public Double getXdTt() {
		return xdTt;
	}

	/**
     * 下单时TT
     */
	public void setXdTt(Double xdTt) {
		this.xdTt = xdTt;
	}
	
	/**
     * 出库时TT
     */
	public Double getCkTt() {
		return ckTt;
	}

	/**
     * 出库时TT
     */
	public void setCkTt(Double ckTt) {
		this.ckTt = ckTt;
	}
	
	/**
     * 下单时LC
     */
	public Double getXdLc() {
		return xdLc;
	}

	/**
     * 下单时LC
     */
	public void setXdLc(Double xdLc) {
		this.xdLc = xdLc;
	}
	
	/**
     * 下单时OA
     */
	public Double getXdOa() {
		return xdOa;
	}

	/**
     * 下单时OA
     */
	public void setXdOa(Double xdOa) {
		this.xdOa = xdOa;
	}
	
	/**
     * 下单时DP
     */
	public Double getXdDp() {
		return xdDp;
	}

	/**
     * 下单时DP
     */
	public void setXdDp(Double xdDp) {
		this.xdDp = xdDp;
	}

	public Double getZq() {
		return zq;
	}

	public void setZq(Double zq) {
		this.zq = zq;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}
	
}