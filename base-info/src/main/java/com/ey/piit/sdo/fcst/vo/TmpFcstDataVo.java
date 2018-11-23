package com.ey.piit.sdo.fcst.vo;

import com.ey.piit.sdo.fcst.entity.TmpFcstData;

/**
 * 采购FCST临时填报Entity
 * @author 邓海
 */
public class TmpFcstDataVo extends TmpFcstData {
	private String pxh;
	private String iszjh;//是否为组件号
	public TmpFcstDataVo() {
		super();
	}

	public TmpFcstDataVo(String id){
		super(id);
	}

	public String getPxh() {
		return pxh;
	}

	public void setPxh(String pxh) {
		this.pxh = pxh;
	}
	public String getIszjh() {
		return iszjh;
	}

	public void setIszjh(String iszjh) {
		this.iszjh = iszjh;
	}

}