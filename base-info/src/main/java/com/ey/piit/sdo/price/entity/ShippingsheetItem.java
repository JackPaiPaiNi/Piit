package com.ey.piit.sdo.price.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 出货资料表明细管理Entity
 * @author 魏诚
 */
public class ShippingsheetItem extends BaseEntity {
	
	private String drdh;		// 导入单号
	private String ddid;		// 订单号 父类
	private String wlbh;		// 物料编码
	private String dw;		    // 单位（研发bom单位）
	private BigDecimal dj;		// 单价
	private String bz;		    // 币种
	private String flag;		// 操作类型
	
	public ShippingsheetItem() {
		super();
	}

	public ShippingsheetItem(String id){
		super(id);
	}

	/**
     * 订单号
     */
	@Length(min=1, max=20, message="订单号长度必须介于 1 和 20 之间")
	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDrdh() {
		return drdh;
	}

	public void setDrdh(String drdh) {
		this.drdh = drdh;
	}

	public String getWlbh() {
		return wlbh;
	}

	public void setWlbh(String wlbh) {
		this.wlbh = wlbh;
	}
	
}