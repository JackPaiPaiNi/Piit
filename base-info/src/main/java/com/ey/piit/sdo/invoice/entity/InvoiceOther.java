package com.ey.piit.sdo.invoice.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 发票其他费用明细Entity
 * @author 高文浩
 */
public class InvoiceOther extends BaseEntity {
	
	private String fph;		// 发票号 父类
	private String qtxm;		// 其他项目
	private String qtxmmc;		// 其他项目名称
	private String ms;		// 描述
	private Double sl;		// 数量
	private BigDecimal dj;		// 单价
	private BigDecimal je;		// 金额
	
	public InvoiceOther() {
		super();
	}

	public InvoiceOther(String id){
		super(id);
	}

	/**
     * 发票号
     */
	@Length(min=1, max=10, message="发票号长度必须介于 1 和 10 之间")
	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}
	
	/**
     * 其他项目
     */
	@Length(min=1, max=20, message="其他项目长度必须介于 1 和 20 之间")
	public String getQtxm() {
		return qtxm;
	}

	/**
     * 其他项目
     */
	public void setQtxm(String qtxm) {
		this.qtxm = qtxm == null ? null : qtxm.trim();
	}
	
	/**
     * 其他项目名称
     */
	@Length(min=0, max=50, message="其他项目名称长度必须介于 0 和 50 之间")
	public String getQtxmmc() {
		return qtxmmc;
	}

	/**
     * 其他项目名称
     */
	public void setQtxmmc(String qtxmmc) {
		this.qtxmmc = qtxmmc == null ? null : qtxmmc.trim();
	}
	
	/**
     * 描述
     */
	@Length(min=0, max=100, message="描述长度必须介于 0 和 100 之间")
	public String getMs() {
		return ms;
	}

	/**
     * 描述
     */
	public void setMs(String ms) {
		this.ms = ms == null ? null : ms.trim();
	}
	
	/**
     * 数量
     */
	public Double getSl() {
		return sl;
	}

	/**
     * 数量
     */
	public void setSl(Double sl) {
		this.sl = sl;
	}
	
	/**
     * 单价
     */
	public BigDecimal getDj() {
		return dj;
	}

	/**
     * 单价
     */
	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	
	/**
     * 金额
     */
	public BigDecimal getJe() {
		return je;
	}

	/**
     * 金额
     */
	public void setJe(BigDecimal je) {
		this.je = je;
	}
	
}