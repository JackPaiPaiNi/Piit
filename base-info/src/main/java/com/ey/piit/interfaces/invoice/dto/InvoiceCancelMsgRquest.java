package com.ey.piit.interfaces.invoice.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 商业发票冲销SAP接口使用实体
 * @author denghai
 *
 */
public class InvoiceCancelMsgRquest {
	//冲销实体list
   private List<InvoiceCancelDto> invoiceCancelList = new ArrayList<InvoiceCancelDto>();

public List<InvoiceCancelDto> getInvoiceCancelList() {
	return invoiceCancelList;
}

public void setInvoiceCancelList(List<InvoiceCancelDto> invoiceCancelList) {
	this.invoiceCancelList = invoiceCancelList;
}
   
}
