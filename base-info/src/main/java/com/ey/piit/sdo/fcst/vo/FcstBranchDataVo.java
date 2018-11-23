package com.ey.piit.sdo.fcst.vo;

import com.ey.piit.sdo.fcst.entity.FcstBranchData;

/**
 * 分公司销售数据填报Entity
 * @author 赵桃军
 */
public class FcstBranchDataVo extends FcstBranchData {

	private String zbxh;		// 总部型号
	private String fgsxh;		// 分公司型号
	public FcstBranchDataVo() {
		super();
	}

	public FcstBranchDataVo(String id){
		super(id);
	}

	public String getZbxh() {
		return zbxh;
	}

	public void setZbxh(String zbxh) {
		this.zbxh = zbxh;
	}

	public String getFgsxh() {
		return fgsxh;
	}

	public void setFgsxh(String fgsxh) {
		this.fgsxh = fgsxh;
	}
	
}