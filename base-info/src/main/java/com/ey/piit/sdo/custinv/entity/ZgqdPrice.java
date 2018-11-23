package com.ey.piit.sdo.custinv.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 以装柜清单为基础-调价表Entity
 * @author 魏诚
 */
public class ZgqdPrice extends BaseEntity {
	
	private String chdh;		// 出货单号
	private String ddid;		// 订单号
	private String khbm;		// 客户编码
	private String wlbh;		// 物料编码
	private String wlms;		// 物料描述（货描）
	private Integer sl;			// 数量
	private String bz;		    // 币种
	private String dw;		    // 单位
	private BigDecimal dj;		// 单价
	private BigDecimal ddje; 	// 订单金额
	
	public ZgqdPrice() {
		super();
	}

	public ZgqdPrice(String id){
		super(id);
	}

	/**
     * 单位（研发bom单位）
     */
	@Length(min=0, max=20, message="单位（研发bom单位）长度必须介于 0 和 20 之间")
	public String getDw() {
		return dw;
	}

	/**
     * 单位（研发bom单位）
     */
	public void setDw(String dw) {
		this.dw = dw == null ? null : dw.trim();
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

	public String getWlbh() {
		return wlbh;
	}

	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}

	public String getKhbm() {
		return khbm;
	}

	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}

	public String getWlms() {
		return wlms;
	}

	public void setWlms(String wlms) {
		this.wlms = wlms;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}

	public Integer getSl() {
		return sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public BigDecimal getDdje() {
		return ddje;
	}

	public void setDdje(BigDecimal ddje) {
		this.ddje = ddje;
	}

}