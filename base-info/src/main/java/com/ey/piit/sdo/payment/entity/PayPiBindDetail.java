package com.ey.piit.sdo.payment.entity;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import com.ey.piit.core.entity.BaseEntity;

/**
 * PI付款保障关联Entity
 * 
 * @author 田荣
 */
public class PayPiBindDetail extends BaseEntity {

	private String piid; // PI号
	private String rldh; // 认领单号
	private String bdlx; // 绑定类型
	private String bdlxmc; // 绑定类型名称
	private String bz; // 币种
	private String lcbh; // LC编号
	private String kzh; // 开证行
	private String kzhdm; // 开证行SWIFT
	private BigDecimal je; // 本次使用额度
	private BigDecimal syed; // 剩余额度	
	private String zdrid; // 制单人
	private String zdrmc; // 制单人名称
	private Date zdsj; // 制单时间
	private String edbz;		// 额度币种
	private BigDecimal edje;		// 额度金额
	private BigDecimal ydEdHl;		// 原单到额度汇率

	public PayPiBindDetail() {
		super();
	}

	public PayPiBindDetail(String id) {
		super(id);
	}

	/**
	 * PI号
	 */
	@Length(min = 1, max = 20, message = "PI号长度必须介于 1 和 20 之间")
	public String getPiid() {
		return piid;
	}

	/**
	 * PI号
	 */
	public void setPiid(String piid) {
		this.piid = piid == null ? null : piid.trim();
	}

	/**
	 * 认领单号
	 */
	@Length(min = 1, max = 20, message = "认领单号长度必须介于 1 和 20 之间")
	public String getRldh() {
		return rldh;
	}

	/**
	 * 认领单号
	 */
	public void setRldh(String rldh) {
		this.rldh = rldh == null ? null : rldh.trim();
	}

	/**
	 * 绑定类型
	 */
	@Length(min = 1, max = 50, message = "绑定类型长度必须介于 1 和 50 之间")
	public String getBdlx() {
		return bdlx;
	}

	/**
	 * 绑定类型
	 */
	public void setBdlx(String bdlx) {
		this.bdlx = bdlx == null ? null : bdlx.trim();
	}

	/**
	 * 绑定类型名称
	 */
	@Length(min = 0, max = 50, message = "绑定类型名称长度必须介于 0 和 50 之间")
	public String getBdlxmc() {
		return bdlxmc;
	}

	/**
	 * 绑定类型名称
	 */
	public void setBdlxmc(String bdlxmc) {
		this.bdlxmc = bdlxmc == null ? null : bdlxmc.trim();
	}

	/**
	 * 币种
	 */
	@Length(min = 0, max = 50, message = "币种长度必须介于 0 和 50 之间")
	public String getBz() {
		return bz;
	}

	/**
	 * 币种
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}

	/**
	 * LC编号
	 */
	@Length(min = 1, max = 20, message = "LC编号长度必须介于 1 和 20 之间")
	public String getLcbh() {
		return lcbh;
	}

	/**
	 * LC编号
	 */
	public void setLcbh(String lcbh) {
		this.lcbh = lcbh == null ? null : lcbh.trim();
	}

	/**
	 * 开证行
	 */
	@Length(min = 0, max = 50, message = "开证行长度必须介于 0 和 50 之间")
	public String getKzh() {
		return kzh;
	}

	/**
	 * 开证行
	 */
	public void setKzh(String kzh) {
		this.kzh = kzh == null ? null : kzh.trim();
	}

	/**
	 * 开证行SWIFT
	 */
	@Length(min = 0, max = 20, message = "开证行SWIFT长度必须介于 0 和 20 之间")
	public String getKzhdm() {
		return kzhdm;
	}

	/**
	 * 开证行SWIFT
	 */
	public void setKzhdm(String kzhdm) {
		this.kzhdm = kzhdm == null ? null : kzhdm.trim();
	}

	/**
	 * 本次使用额度
	 */
	public BigDecimal getJe() {
		return je;
	}

	/**
	 * 本次使用额度
	 */
	public void setJe(BigDecimal je) {
		this.je = je;
	}

	/**
	 * 制单人
	 */
	@Length(min = 1, max = 20, message = "制单人长度必须介于 1 和 20 之间")
	public String getZdrid() {
		return zdrid;
	}

	/**
	 * 制单人
	 */
	public void setZdrid(String zdrid) {
		this.zdrid = zdrid == null ? null : zdrid.trim();
	}

	/**
	 * 制单人名称
	 */
	@Length(min = 1, max = 50, message = "制单人名称长度必须介于 1 和 50 之间")
	public String getZdrmc() {
		return zdrmc;
	}

	/**
	 * 制单人名称
	 */
	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc == null ? null : zdrmc.trim();
	}

	/**
	 * 制单时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "制单时间不能为空")
	public Date getZdsj() {
		return zdsj;
	}

	/**
	 * 制单时间
	 */
	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public BigDecimal getSyed() {
		return syed;
	}

	public void setSyed(BigDecimal syed) {
		this.syed = syed;
	}

	public String getEdbz() {
		return edbz;
	}

	public BigDecimal getEdje() {
		return edje;
	}

	public BigDecimal getYdEdHl() {
		return ydEdHl;
	}

	public void setEdbz(String edbz) {
		this.edbz = edbz;
	}

	public void setEdje(BigDecimal edje) {
		this.edje = edje;
	}

	public void setYdEdHl(BigDecimal ydEdHl) {
		this.ydEdHl = ydEdHl;
	}

}