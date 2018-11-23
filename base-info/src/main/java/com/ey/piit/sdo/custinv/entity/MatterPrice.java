package com.ey.piit.sdo.custinv.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 客户物料价格库Entity
 * @author 魏诚
 */
public class MatterPrice extends BaseEntity {
	
	private String khbm;		// 客户编码
	private String wlbh;		// 物料编码
	private String bz;		    // 币种
	private BigDecimal dj;		// 单价
	private String dw;		    // 单位
	private String wlms;		// 物料描述（货描）
	private Date zdsj; 			// 维护时间
	
	public MatterPrice() {
		super();
	}

	public MatterPrice(String id){
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getZdsj() {
		return zdsj;
	}

	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}
}