package com.ey.piit.sdo.report.vo;

import com.ey.piit.sdo.report.entity.SapDeliveryOrder;

/**
 * SAP交货单明细Entity
 * @author 高文浩
 */
public class SapDeliveryOrderVo extends SapDeliveryOrder {

	private String beginSjfhrq;		// 开始 实际发货日期
	private String endSjfhrq;		// 结束 实际发货日期
	private Integer zt;//状态
	private String cwzymc;//船务专员名称
	
	public SapDeliveryOrderVo() {
		super();
	}

	public SapDeliveryOrderVo(String id){
		super(id);
	}

	public String getBeginSjfhrq() {
		return beginSjfhrq;
	}

	public void setBeginSjfhrq(String beginSjfhrq) {
		this.beginSjfhrq = beginSjfhrq;
	}

	public String getEndSjfhrq() {
		return endSjfhrq;
	}

	public void setEndSjfhrq(String endSjfhrq) {
		this.endSjfhrq = endSjfhrq;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getCwzymc() {
		return cwzymc;
	}

	public void setCwzymc(String cwzymc) {
		this.cwzymc = cwzymc;
	}
	
	
}