package com.ey.piit.core.paginator.domain;

import com.ey.piit.core.utils.StringUtils;

public class PageJqGrid extends PageBounds{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2648492955440942207L;
	
	public String nd;
//	public int page;//当前页号
	public int rows;//每页行数
	public String sidx;//排序字段名
	public String sord;//排序方式 asc desc
	public boolean search;
	
	public PageJqGrid() {
		super();
		super.containsTotalCount=true;
	}
	
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
		super.limit = rows;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
		if (StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(sord)) {
			super.orders.add(Order.create(sidx, sord));
		}
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
		if (StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(sord)) {
			super.orders.add(Order.create(sidx, sord));
		}
	}
	public boolean isSearch() {
		return search;
	}
	public void setSearch(boolean search) {
		this.search = search;
	}
	
}
