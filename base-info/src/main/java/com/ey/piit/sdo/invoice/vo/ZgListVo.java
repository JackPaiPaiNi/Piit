package com.ey.piit.sdo.invoice.vo;

import com.ey.piit.sdo.invoice.entity.ZgList;

/**
 * 装柜清单Vo
 * @author tianrong
 */
public class ZgListVo extends ZgList {

	private String   beginZdsj;
	private String   endZdsj ;

	public ZgListVo() {
		super();
	}

	public ZgListVo(String id){
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