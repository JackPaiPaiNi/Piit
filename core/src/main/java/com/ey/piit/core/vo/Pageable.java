package com.ey.piit.core.vo;

import java.io.Serializable;

public class Pageable implements Serializable{
	private static final long serialVersionUID = 2181421281305534794L;
	
	private int page = 1;
	private int limit = 10;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
