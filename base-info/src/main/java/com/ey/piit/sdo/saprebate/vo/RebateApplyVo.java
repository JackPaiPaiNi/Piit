package com.ey.piit.sdo.saprebate.vo;

import com.ey.piit.sdo.saprebate.entity.RebateApply;

/**
 * sap返利申请Entity
 * @author 赵桃军
 */
public class RebateApplyVo extends RebateApply {
	private Integer sFgx ; //是否勾选
	
	private String ztmc;  //状态名称
	 
	
	
	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public Integer getsFgx() {
		return sFgx;
	}

	public void setsFgx(Integer sFgx) {
		this.sFgx = sFgx;
	}

	public RebateApplyVo() {
		super();
	}

	public RebateApplyVo(String id){
		super(id);
	}

}