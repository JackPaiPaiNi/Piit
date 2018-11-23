package com.ey.piit.sdo.booking.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 订舱通知书Entity
 * @author 赵明
 */
public class BookingItem extends BaseEntity {
	
	private String dcdh;		// 订舱单号 父类
	private String yzhlx;		// 预走货类型
	private String yzhlxmc;		// 预走货类型名称
	private String yzhdh;		// 预走货单号
	
	public BookingItem() {
		super();
	}

	public BookingItem(String id){
		super(id);
	}

	/**
     * 订舱单号
     */
	@Length(min=1, max=20, message="订舱单号长度必须介于 1 和 20 之间")
	public String getDcdh() {
		return dcdh;
	}

	public void setDcdh(String dcdh) {
		this.dcdh = dcdh;
	}
	
	/**
     * 预走货类型
     */
	@Length(min=0, max=50, message="预走货类型长度必须介于 0 和 50 之间")
	public String getYzhlx() {
		return yzhlx;
	}

	/**
     * 预走货类型
     */
	public void setYzhlx(String yzhlx) {
		this.yzhlx = yzhlx == null ? null : yzhlx.trim();
	}
	
	/**
     * 预走货类型名称
     */
	@Length(min=0, max=50, message="预走货类型名称长度必须介于 0 和 50 之间")
	public String getYzhlxmc() {
		return yzhlxmc;
	}

	/**
     * 预走货类型名称
     */
	public void setYzhlxmc(String yzhlxmc) {
		this.yzhlxmc = yzhlxmc == null ? null : yzhlxmc.trim();
	}
	
	/**
     * 预走货单号
     */
	@Length(min=1, max=20, message="预走货单号长度必须介于 1 和 20 之间")
	public String getYzhdh() {
		return yzhdh;
	}

	/**
     * 预走货单号
     */
	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh == null ? null : yzhdh.trim();
	}
}