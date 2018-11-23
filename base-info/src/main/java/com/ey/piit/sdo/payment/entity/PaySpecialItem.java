package com.ey.piit.sdo.payment.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 特批明细Entity
 * @author 田荣
 */
public class PaySpecialItem extends BaseEntity {
	
	private String tpdh;		// 特批单号
	private String tplx;		// 特批类型
	private String tplxmc;		// 特批类型名称
	private String ddid;		// 订单ID
	private String piid;		// PI号
	private String lcKzh;		// 开证行SwiftCode
	private String bz;			// 币种
	private BigDecimal tpje;		// 特批金额
	private String bzxx;		// 备注信息
	private String edbz;		// 额度币种
	private BigDecimal edje;		// 额度金额
	private BigDecimal ydEdHl;		// 原单到额度汇率
	
	public PaySpecialItem() {
		super();
	}

	public PaySpecialItem(String id){
		super(id);
	}

	/**
     * 特批单号
     */
	@Length(min=1, max=20, message="特批单号长度必须介于 1 和 20 之间")
	public String getTpdh() {
		return tpdh;
	}

	/**
     * 特批单号
     */
	public void setTpdh(String tpdh) {
		this.tpdh = tpdh == null ? null : tpdh.trim();
	}
	
	/**
     * 特批类型
     */
	@Length(min=1, max=50, message="特批类型长度必须介于 1 和 50 之间")
	public String getTplx() {
		return tplx;
	}

	/**
     * 特批类型
     */
	public void setTplx(String tplx) {
		this.tplx = tplx == null ? null : tplx.trim();
	}
	
	/**
     * 特批类型名称
     */
	@Length(min=0, max=50, message="特批类型名称长度必须介于 0 和 50 之间")
	public String getTplxmc() {
		return tplxmc;
	}

	/**
     * 特批类型名称
     */
	public void setTplxmc(String tplxmc) {
		this.tplxmc = tplxmc == null ? null : tplxmc.trim();
	}
	
	
	/**
     * 备注信息
     */
	@Length(min=0, max=100, message="备注信息长度必须介于 0 和 100 之间")
	public String getBzxx() {
		return bzxx;
	}

	/**
     * 备注信息
     */
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx == null ? null : bzxx.trim();
	}

	public String getLcKzh() {
		return lcKzh;
	}

	public void setLcKzh(String lcKzh) {
		this.lcKzh = lcKzh;
	}

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public String getDdid() {
		return ddid;
	}

	public String getBz() {
		return bz;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getEdbz() {
		return edbz;
	}

	public void setEdbz(String edbz) {
		this.edbz = edbz;
	}

	public BigDecimal getTpje() {
		return tpje;
	}

	public void setTpje(BigDecimal tpje) {
		this.tpje = tpje;
	}

	public BigDecimal getEdje() {
		return edje;
	}

	public void setEdje(BigDecimal edje) {
		this.edje = edje;
	}

	public BigDecimal getYdEdHl() {
		return ydEdHl;
	}

	public void setYdEdHl(BigDecimal ydEdHl) {
		this.ydEdHl = ydEdHl;
	}
	
}