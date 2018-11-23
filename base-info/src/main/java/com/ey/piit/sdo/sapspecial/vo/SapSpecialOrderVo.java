package com.ey.piit.sdo.sapspecial.vo;

import java.util.List;

import com.ey.piit.sdo.sapspecial.entity.SapSpecialOrder;
import com.google.common.collect.Lists;

/**
 * sap特价审批管理Entity
 * 
 * @author 赵桃军
 */
public class SapSpecialOrderVo extends SapSpecialOrder {

	
	private String  zdrid; //制单人id
    
	private String  zdrmc; //制单人名称
	
	private String  zdsj ; //制单人名称
	
	private String  beginZdsj ; //开始提交时间
	
	private String  endZdsj ; //开始提交时间
	

	private List<SapSpecialItemVo> itemList = Lists.newArrayList(); // 子表列表

	private List<SapApproveLogVo> logList = Lists.newArrayList(); // 子表列表

	public List<SapApproveLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<SapApproveLogVo> logList) {
		this.logList = logList;
	}

	public SapSpecialOrderVo() {
		super();
	}

	public SapSpecialOrderVo(String id) {
		super(id);
	}

	public List<SapSpecialItemVo> getItemList() {
		return itemList;
	}

	public void setItemList(List<SapSpecialItemVo> itemList) {
		this.itemList = itemList;
	}


	public String getZdrid() {
		return zdrid;
	}

	public void setZdrid(String zdrid) {
		this.zdrid = zdrid;
	}

	public String getZdrmc() {
		return zdrmc;
	}

	public void setZdrmc(String zdrmc) {
		this.zdrmc = zdrmc;
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

	public String getZdsj() {
		return zdsj;
	}

	public void setZdsj(String zdsj) {
		this.zdsj = zdsj;
	}
	
	
	

}