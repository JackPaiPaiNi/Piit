package com.ey.piit.sdo.report.vo;

import com.ey.piit.sdo.report.entity.InvoiceTable;

/**
 * InvoiceTableVo
 * @author 魏诚
 */
public class InvoiceTableVo extends InvoiceTable {
	
	private  String     beginZdsj;//开始制单时间
	private  String     endZdsj;  // 结束制单时间
	
	public InvoiceTableVo() {
		super();
	}

	public InvoiceTableVo(String id){
		super(id);
	}

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
	
	
}