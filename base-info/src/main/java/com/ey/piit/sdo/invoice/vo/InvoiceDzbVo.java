package com.ey.piit.sdo.invoice.vo;

import com.ey.piit.sdo.invoice.entity.InvoiceDzb;

/**
 * 发票对照表ntity
 * @author tianrong
 */
public class InvoiceDzbVo extends InvoiceDzb {
	
	private Integer type;//1为保存对照表。2为更新冲销状态
	public InvoiceDzbVo() {
		super();
	}

	public InvoiceDzbVo(String id){
		super(id);
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}