package com.ey.piit.sdo.order.vo;

import java.io.Serializable;

import com.ey.piit.sdo.order.entity.OrderToSap;

/**
 * 订单推送SAP管理Entity
 * @author 赵明
 */
public class OrderToSapVo extends OrderToSap implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6264083094062050200L;
	
	// ckd物料清单查询使用
	private Integer sfYc;
	private String wlbm;
	private String ms;
	private String ztmc;
	private String   beginZdsj;
	private String   endZdsj ;
	
	public String getBeginZdsj() {
		return beginZdsj;
	}

	public void setBeginZdsj(String beginZdsj) {
		this.beginZdsj = beginZdsj;
	}

	public String getEndZdsj() {
		return endZdsj;
	}

	public void setEndZdsj(String endZdsj) {
		this.endZdsj = endZdsj;
	}

	public String getWlbm() {
		return wlbm;
	}

	public void setWlbm(String wlbm) {
		this.wlbm = wlbm;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public Integer getSfYc() {
		return sfYc;
	}

	public void setSfYc(Integer sfYc) {
		this.sfYc = sfYc;
	}

	public OrderToSapVo() {
		super();
	}
	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}
}