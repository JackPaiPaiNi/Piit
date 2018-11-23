package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 走货日期定义Entity
 * @author 魏诚
 */
public class ShippmentDays extends BaseEntity {
	
	private String gj;		// 国家
	private String gjmc;		// 国家名称
	private String zhfs;		// 走货方式
	private String zhfsmc;		// 走货方式名称
	private Integer bgts;		// 报关天数
	private Integer hsts;		// 海上天数
	private Integer qgts;		// 清关天数
	private Integer wxgcts;		// 外协工厂天数
	
	public ShippmentDays() {
		super();
	}

	public ShippmentDays(String id){
		super(id);
	}

	/**
     * 国家
     */
	@Length(min=1, max=20, message="国家长度必须介于 1 和 20 之间")
	public String getGj() {
		return gj;
	}

	/**
     * 国家
     */
	public void setGj(String gj) {
		this.gj = gj == null ? null : gj.trim();
	}
	
	/**
     * 国家名称
     */
	@Length(min=0, max=50, message="国家名称长度必须介于 0 和 50 之间")
	public String getGjmc() {
		return gjmc;
	}

	/**
     * 国家名称
     */
	public void setGjmc(String gjmc) {
		this.gjmc = gjmc == null ? null : gjmc.trim();
	}
	
	/**
     * 走货方式
     */
	@Length(min=1, max=50, message="走货方式长度必须介于 1 和 50 之间")
	public String getZhfs() {
		return zhfs;
	}

	/**
     * 走货方式
     */
	public void setZhfs(String zhfs) {
		this.zhfs = zhfs == null ? null : zhfs.trim();
	}
	
	/**
     * 走货方式名称
     */
	@Length(min=0, max=50, message="走货方式名称长度必须介于 0 和 50 之间")
	public String getZhfsmc() {
		return zhfsmc;
	}

	/**
     * 走货方式名称
     */
	public void setZhfsmc(String zhfsmc) {
		this.zhfsmc = zhfsmc == null ? null : zhfsmc.trim();
	}
	
	/**
     * 报关天数
     */
	public Integer getBgts() {
		return bgts;
	}

	/**
     * 报关天数
     */
	public void setBgts(Integer bgts) {
		this.bgts = bgts;
	}
	
	/**
     * 海上天数
     */
	public Integer getHsts() {
		return hsts;
	}

	/**
     * 海上天数
     */
	public void setHsts(Integer hsts) {
		this.hsts = hsts;
	}
	
	/**
     * 清关天数
     */
	public Integer getQgts() {
		return qgts;
	}

	/**
     * 清关天数
     */
	public void setQgts(Integer qgts) {
		this.qgts = qgts;
	}
	
	/**
     * 外协工厂天数
     */
	public Integer getWxgcts() {
		return wxgcts;
	}

	/**
     * 外协工厂天数
     */
	public void setWxgcts(Integer wxgcts) {
		this.wxgcts = wxgcts;
	}
	
}