package com.ey.piit.sdo.invoice.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 补料单信息维护Entity
 * @author 高文浩
 */
public class ShippingInstructionItem extends BaseEntity {
	
	private String bldh;		// 补料单号 父类
	private String ddid;		// 订单号
	private String gh;		// 柜号
	private String fth;		// 封条号
	private Double kbtj;		// 卡板体积
	private Double xs;		// 箱数
	private Double zsl;		// 总数量
	private Double pz;		// 皮重KG
	private Double gmz;		// 柜毛重KG
	private String gx;		// 柜型
	private Double zmz;		// 毛重（总）KG
	private String dch;		// 订舱号
	
	public ShippingInstructionItem() {
		super();
	}

	public ShippingInstructionItem(String id){
		super(id);
	}


	/**
     * 补料单号
     */
	@Length(min=1, max=20, message="补料单号长度必须介于 1 和 20 之间")
	public String getBldh() {
		return bldh;
	}

	public void setBldh(String bldh) {
		this.bldh = bldh;
	}
	
	/**
     * 订单号
     */
	@Length(min=0, max=20, message="订单号长度必须介于 0 和 20 之间")
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
     * 柜号
     */
	@Length(min=0, max=50, message="柜号长度必须介于 0 和 50 之间")
	public String getGh() {
		return gh;
	}

	/**
     * 柜号
     */
	public void setGh(String gh) {
		this.gh = gh == null ? null : gh.trim();
	}
	
	/**
     * 封条号
     */
	@Length(min=0, max=50, message="封条号长度必须介于 0 和 50 之间")
	public String getFth() {
		return fth;
	}

	/**
     * 封条号
     */
	public void setFth(String fth) {
		this.fth = fth == null ? null : fth.trim();
	}
	
	/**
     * 卡板体积
     */
	public Double getKbtj() {
		return kbtj;
	}

	/**
     * 卡板体积
     */
	public void setKbtj(Double kbtj) {
		this.kbtj = kbtj;
	}
	
	/**
     * 箱数
     */
	public Double getXs() {
		return xs;
	}

	/**
     * 箱数
     */
	public void setXs(Double xs) {
		this.xs = xs;
	}
	
	/**
     * 总数量
     */
	public Double getZsl() {
		return zsl;
	}

	/**
     * 总数量
     */
	public void setZsl(Double zsl) {
		this.zsl = zsl;
	}
	
	/**
     * 皮重KG
     */
	public Double getPz() {
		return pz;
	}

	/**
     * 皮重KG
     */
	public void setPz(Double pz) {
		this.pz = pz;
	}
	
	/**
     * 柜毛重KG
     */
	public Double getGmz() {
		return gmz;
	}

	/**
     * 柜毛重KG
     */
	public void setGmz(Double gmz) {
		this.gmz = gmz;
	}
	
	/**
     * 柜型
     */
	@Length(min=0, max=50, message="柜型长度必须介于 0 和 50 之间")
	public String getGx() {
		return gx;
	}

	/**
     * 柜型
     */
	public void setGx(String gx) {
		this.gx = gx == null ? null : gx.trim();
	}
	
	/**
     * 毛重（总）KG
     */
	public Double getZmz() {
		return zmz;
	}

	/**
     * 毛重（总）KG
     */
	public void setZmz(Double zmz) {
		this.zmz = zmz;
	}
	
	/**
     * 订舱号
     */
	@Length(min=0, max=10, message="订舱号长度必须介于 0 和 10 之间")
	public String getDch() {
		return dch;
	}

	/**
     * 订舱号
     */
	public void setDch(String dch) {
		this.dch = dch == null ? null : dch.trim();
	}
	
}