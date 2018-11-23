package com.ey.piit.sdo.invoice.vo;

import com.ey.piit.sdo.invoice.entity.Invoice;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 发票信息维护Entity
 * @author 高文浩
 */
public class InvoiceVo extends Invoice {

	private List<InvoiceItemVo> invoiceItemList = Lists.newArrayList();		// 发票子表列表
	private List<InvoiceItemVo> invoicePackingList = Lists.newArrayList();	// 箱单子列表
	private List<InvoiceOtherVo> invoiceOtherList = Lists.newArrayList();	// 发票其他费用子列表
	private List<InvoiceDetailVo> invoiceDetailList = Lists.newArrayList();		// 发票明细表列表
	private String fplx;//发票类型 1商业发票 2公司间发票
	private Double xdLc;//下单时LC
	private String   beginZdsj;
	private String   endZdsj ;
	private String   yzhdh;
	private String   ddid ;
	private String chdh;//出货通知书单号

	public InvoiceVo() {
		super();
	}

	public InvoiceVo(String id){
		super(id);
	}
	public List<InvoiceItemVo> getInvoiceItemList() {
		return invoiceItemList;
	}

	public void setInvoiceItemList(List<InvoiceItemVo> invoiceItemList) {
		this.invoiceItemList = invoiceItemList;
	}

	public List<InvoiceItemVo> getInvoicePackingList() {
		return invoicePackingList;
	}

	public void setInvoicePackingList(List<InvoiceItemVo> invoicePackingList) {
		this.invoicePackingList = invoicePackingList;
	}

	public List<InvoiceOtherVo> getInvoiceOtherList() {
		return invoiceOtherList;
	}

	public void setInvoiceOtherList(List<InvoiceOtherVo> invoiceOtherList) {
		this.invoiceOtherList = invoiceOtherList;
	}

	public String getFplx() {
		return fplx;
	}

	public void setFplx(String fplx) {
		this.fplx = fplx;
	}

	public Double getXdLc() {
		return xdLc;
	}

	public void setXdLc(Double xdLc) {
		this.xdLc = xdLc;
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

	public List<InvoiceDetailVo> getInvoiceDetailList() {
		return invoiceDetailList;
	}

	public void setInvoiceDetailList(List<InvoiceDetailVo> invoiceDetailList) {
		this.invoiceDetailList = invoiceDetailList;
	}

	public String getYzhdh() {
		return yzhdh;
	}

	public void setYzhdh(String yzhdh) {
		this.yzhdh = yzhdh;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getChdh() {
		return chdh;
	}

	public void setChdh(String chdh) {
		this.chdh = chdh;
	}
	
	
}