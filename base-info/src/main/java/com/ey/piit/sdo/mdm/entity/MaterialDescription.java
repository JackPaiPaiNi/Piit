package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 物料其他语言描述Entity
 * @author 高文浩
 */
public class MaterialDescription extends BaseEntity {
	
	private String wlbh;		// 物料编号
	private String yy;		// 语言
	private String ms;		// 描述
	
	public MaterialDescription() {
		super();
	}

	public MaterialDescription(String id){
		super(id);
	}

	/**
     * 物料编号
     */
	@Length(min=1, max=50, message="物料编号长度必须介于 1 和 50 之间")
	public String getWlbh() {
		return wlbh;
	}

	/**
     * 物料编号
     */
	public void setWlbh(String wlbh) {
		this.wlbh = wlbh == null ? null : wlbh.trim();
	}
	
	/**
     * 语言
     */
	@Length(min=1, max=20, message="语言长度必须介于 1 和 20 之间")
	public String getYy() {
		return yy;
	}

	/**
     * 语言
     */
	public void setYy(String yy) {
		this.yy = yy == null ? null : yy.trim();
	}
	
	/**
     * 描述
     */
	@Length(min=1, max=100, message="描述长度必须介于 1 和 100 之间")
	public String getMs() {
		return ms;
	}

	/**
     * 描述
     */
	public void setMs(String ms) {
		this.ms = ms == null ? null : ms.trim();
	}
	
}