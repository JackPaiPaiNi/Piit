package com.ey.piit.sdo.mdm.vo;

import com.ey.piit.sdo.mdm.entity.Employee;

/**
 * 员工维护Entity
 * @author 高文浩
 */
public class EmployeeVo extends Employee {
	
	private String xszz; //销售组织
	private String xszzmc; //销售组织名称
	private String ywz; //业务组
	private String ywzmc; //业务组名称
	private String sfsap; //是否SAP销售员
	public EmployeeVo() {
		super();
	}

	public EmployeeVo(String id){
		super(id);
	}
	
	
	public String getXszz() {
		return xszz;
	}

	public void setXszz(String xszz) {
		this.xszz = xszz;
	}

	public String getXszzmc() {
		return xszzmc;
	}

	public void setXszzmc(String xszzmc) {
		this.xszzmc = xszzmc;
	}

	public String getYwz() {
		return ywz;
	}

	public void setYwz(String ywz) {
		this.ywz = ywz;
	}

	public String getYwzmc() {
		return ywzmc;
	}

	public void setYwzmc(String ywzmc) {
		this.ywzmc = ywzmc;
	}

	public String getSfsap() {
		return sfsap;
	}

	public void setSfsap(String sfsap) {
		this.sfsap = sfsap;
	}


}