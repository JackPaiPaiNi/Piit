package com.ey.piit.sdo.pso.entity;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 预走货PI
 * 
 * @author 魏诚
 */
public class PsoPi extends BaseEntity {

	private String yzhdh; // 预走货单号 父类
	private Integer bbh; // 版本号
	private String ddid; // 订单号
	private String ddlx; // 订单类型
	private String ddlxmc; // 订单类型名称
	private String piid; // PI号
	private String pilx; // PI类型
	private String pilxmc; // PI类型名称
	private BigDecimal je; // 金额
	private String bz;
	
	public PsoPi() {
		super();
	}

	public PsoPi(String id) {
		super(id);
	}

	/**
	 * 预走货单号
	 */
	@Length(min = 1, max = 20, message = "预走货单号长度必须介于 1 和 20 之间")
	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}

	/**
	 * 版本号
	 */
	@NotNull(message = "版本号不能为空")
	public Integer getBbh() {
		return bbh;
	}

	/**
	 * 版本号
	 */
	public void setBbh(Integer bbh) {
		this.bbh = bbh;
	}

	/**
	 * 订单号
	 */
	@Length(min = 0, max = 20, message = "订单号长度必须介于 0 和 20 之间")
	public String getDdid() {
		return ddid;
	}

	/**
	 * 订单号
	 */
	public void setDdid(String ddid) {
		this.ddid = ddid == null ? null : ddid.trim();
	}

	/**
	 * 币种
	 */
	@Length(min = 0, max = 20, message = "币种长度必须介于 0 和 20 之间")
	public String getBz() {
		return bz;
	}

	/**
	 * 币种
	 */
	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public String getDdlx() {
		return ddlx;
	}

	public void setDdlx(String ddlx) {
		this.ddlx = ddlx;
	}

	public String getDdlxmc() {
		return ddlxmc;
	}

	public String getPiid() {
		return piid;
	}

	public String getPilx() {
		return pilx;
	}

	public String getPilxmc() {
		return pilxmc;
	}

	public void setDdlxmc(String ddlxmc) {
		this.ddlxmc = ddlxmc;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}

	public void setPilx(String pilx) {
		this.pilx = pilx;
	}

	public void setPilxmc(String pilxmc) {
		this.pilxmc = pilxmc;
	}

}