package com.ey.piit.sdo.mdm.vo;

import java.util.List;

import com.ey.piit.sdo.mdm.entity.CustomerApply;
import com.google.common.collect.Lists;

/**
 * 客户信息申请Entity
 * @author 高文浩
 */
public class CustomerApplyVo extends CustomerApply {

	private String xszz;//销售组织
	private String ywz;	//业务组
	
	private List<CustomerApplyLogVo> logList = Lists.newArrayList();		            //客户申请日志
	
	public CustomerApplyVo() {
		super();
	}

	public CustomerApplyVo(String id){		
		super(id);
	}

	public String getXszz() {
		return xszz;
	}

	public void setXszz(String xszz) {
		this.xszz = xszz;
	}

	public String getYwz() {
		return ywz;
	}

	public void setYwz(String ywz) {
		this.ywz = ywz;
	}

	public List<CustomerApplyLogVo> getLogList() {
		return logList;
	}

	public void setLogList(List<CustomerApplyLogVo> logList) {
		this.logList = logList;
	}
	
}