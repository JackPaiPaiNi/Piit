package com.ey.piit.sdo.sapspecial.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * sap特价审批管理Entity
 * @author 赵桃军
 */
public class SapSpecialItem extends BaseEntity {
	
	private Integer xmh;		// 项目号
	private String xl;			// 系列
	private String xh;			// 型号2
	private Double sl;			// 数量
	private BigDecimal xsdj;		// 销售单价
	private BigDecimal xsze;		// 销售总额
	private BigDecimal zkje;		// 折扣金额
	private String hb;			// 货币
	private BigDecimal xsmll;		// 销售毛利率
	private String  xsdd;		// 销售订单 父类
	
	public SapSpecialItem() {
		super();
	}

	public SapSpecialItem(String id){
		super(id);
	}


	/**
     * 项目号
     */
	public Integer getXmh() {
		return xmh;
	}

	/**
     * 项目号
     */
	public void setXmh(Integer xmh) {
		this.xmh = xmh;
	}
	
	/**
     * 系列
     */
	@Length(min=0, max=20, message="系列长度必须介于 0 和 20 之间")
	public String getXl() {
		return xl;
	}

	/**
     * 系列
     */
	public void setXl(String xl) {
		this.xl = xl == null ? null : xl.trim();
	}
	
	/**
     * 型号2
     */
	@Length(min=0, max=18, message="型号2长度必须介于 0 和 18 之间")
	public String getXh() {
		return xh;
	}

	/**
     * 型号2
     */
	public void setXh(String xh) {
		this.xh = xh == null ? null : xh.trim();
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
     * 货币
     */
	@Length(min=0, max=20, message="货币长度必须介于 0 和 20 之间")
	public String getHb() {
		return hb;
	}

	/**
     * 货币
     */
	public void setHb(String hb) {
		this.hb = hb == null ? null : hb.trim();
	}


	public String getXsdd() {
		return xsdd;
	}

	public void setXsdd(String xsdd) {
		this.xsdd = xsdd;
	}

	public BigDecimal getXsdj() {
		return xsdj;
	}

	public void setXsdj(BigDecimal xsdj) {
		this.xsdj = xsdj;
	}

	public BigDecimal getXsze() {
		return xsze;
	}

	public void setXsze(BigDecimal xsze) {
		this.xsze = xsze;
	}

	public BigDecimal getZkje() {
		return zkje;
	}

	public void setZkje(BigDecimal zkje) {
		this.zkje = zkje;
	}

	public BigDecimal getXsmll() {
		return xsmll;
	}

	public void setXsmll(BigDecimal xsmll) {
		this.xsmll = xsmll;
	}
	
	/**
     * 销售订单
     */
	
	
}