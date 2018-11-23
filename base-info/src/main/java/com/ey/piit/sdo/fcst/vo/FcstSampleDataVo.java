package com.ey.piit.sdo.fcst.vo;

import com.ey.piit.sdo.fcst.entity.FcstSampleData;

/**
 * 采购FCST样机填报Entity
 * @author 高文浩
 */
public class FcstSampleDataVo extends FcstSampleData {
	
	private String itemListStr;//明细list字符串
	private String zcrq;	// 周次带日期
	public FcstSampleDataVo() {
		super();
	}

	public FcstSampleDataVo(String id){
		super(id);
	}

	public String getItemListStr() {
		return itemListStr;
	}

	public void setItemListStr(String itemListStr) {
		this.itemListStr = itemListStr;
	}

	public String getZcrq() {
		return zcrq;
	}

	public void setZcrq(String zcrq) {
		this.zcrq = zcrq;
	}
	
}