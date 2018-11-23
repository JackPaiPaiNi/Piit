package com.ey.piit.sdo.pso.entity;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 预走货Entity
 * @author 邓海
 */
public class PsoExhibition extends BaseEntity {
	
	private String yzhdh;		// 预走货单号 父类
	private Integer bbh;		// 版本号
	private String spmc;		// 商品名称
	private String yjly;		// 样机来源
	private String jixing;		// 机型
	private Integer sl;		// 数量
	private String bz;		// 币种
	private BigDecimal je;		// 金额
	private BigDecimal dj;		// 单价
	private String bzxx;		//备注信息
	
	public PsoExhibition() {
		super();
	}

	public PsoExhibition(String id){
		super(id);
	}


	/**
     * 预走货单号
     */
	@Length(min=1, max=20, message="预走货单号长度必须介于 1 和 20 之间")
	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}
	
	/**
     * 版本号
     */
	@NotNull(message="版本号不能为空")
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
     * 币种
     */
	@Length(min=0, max=20, message="币种长度必须介于 0 和 20 之间")
	public String getBz() {
		return bz;
	}

	/**
     * 币种
     */
	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public String getYjly() {
		return yjly;
	}

	public void setYjly(String yjly) {
		this.yjly = yjly;
	}

	public String getJixing() {
		return jixing;
	}

	public void setJixing(String jixing) {
		this.jixing = jixing;
	}

	public Integer getSl() {
		return sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	
	
	
}