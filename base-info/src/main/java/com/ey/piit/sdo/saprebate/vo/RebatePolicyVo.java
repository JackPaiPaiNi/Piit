package com.ey.piit.sdo.saprebate.vo;

import com.ey.piit.sdo.saprebate.entity.RebatePolicy;

/**
 * SAP返利政策Entity
 * @author 赵桃军
 */
public class RebatePolicyVo extends RebatePolicy {
    
    private String  type;  // 审批类型
	
	private Integer sFgx ; // 是否勾选
	
	private String ztmc;   // 状态名称
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getsFgx() {
		return sFgx;
	}

	public void setsFgx(Integer sFgx) {
		this.sFgx = sFgx;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public RebatePolicyVo() {
		super();
	}

	public RebatePolicyVo(String id){
		super(id);
	}

}