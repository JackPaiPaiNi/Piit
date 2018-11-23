package com.ey.piit.sdo.fcst.vo;

import com.ey.piit.sdo.fcst.entity.FcstData;

/**
 * 采购FCST填报Entity
 * @author 邓海
 */
public class FcstDataVo extends FcstData {

	private String itemListStr;//明细list字符串
	private String zc;//当前周次
	
	public FcstDataVo() {
		super();
	}

	public FcstDataVo(String id){
		super(id);
	}

	public String getItemListStr() {
		return itemListStr;
	}

	public void setItemListStr(String itemListStr) {
		this.itemListStr = itemListStr;
	}

	public String getZc() {
		return zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}

	
}