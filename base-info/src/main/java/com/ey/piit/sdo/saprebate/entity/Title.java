package com.ey.piit.sdo.saprebate.entity;

import java.util.Date;

import com.ey.piit.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * sap费用审批Entity
 * 
 * @author 赵桃军
 */
public class Title extends BaseEntity {
	private String splsh; // 审批流水号
	private String bukrs; // 公司代码
	private String gsmc;  // 公司名称
	private String zdjlx; // 单据类型
	private Date   cpudt; // 提交时间
	private String userid;// 申请人
	private Integer tssapzt;    //推送SAP状态
	private Integer  sfFgs ;  //是否为分公司单据 
	private String   deptCode; //总部销售员/业务员在SDO部门编码
	
	
	
	
	

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public Integer getSfFgs() {
		return sfFgs;
	}

	public void setSfFgs(Integer sfFgs) {
		this.sfFgs = sfFgs;
	}

	public Integer getTssapzt() {
		return tssapzt;
	}

	public void setTssapzt(Integer tssapzt) {
		this.tssapzt = tssapzt;
	}

	public String getSplsh() {
		return splsh;
	}

	public void setSplsh(String splsh) {
		this.splsh = splsh;
	}

	public String getBukrs() {
		return bukrs;
	}

	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}

	public String getGsmc() {
		return gsmc;
	}

	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}

	public String getZdjlx() {
		return zdjlx;
	}

	public void setZdjlx(String zdjlx) {
		this.zdjlx = zdjlx;
	}
	/**
     * 申请日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCpudt() {
		return cpudt;
	}

	public void setCpudt(Date cpudt) {
		this.cpudt = cpudt;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Title() {
		super();
	}

	public Title(String id) {
		super(id);
	}

}