package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 公司信息维护Entity
 * @author z赵桃军
 */
public class CompanyInfo extends BaseEntity {
	
	private String gsbm;		// 公司编码
	private String gszwmc;		// 公司中文名称
	private String gsywmc;		// 公司英文名称
	private String gszwdz;		// 公司中文地址
	private String gsywdz;		// 公司英文地址
	private String bz;		// 备注
	private String sapgsdm;		// SAP公司代码
	
	public CompanyInfo() {
		super();
	}

	public CompanyInfo(String id){
		super(id);
	}

	/**
     * 公司编码
     */
	@Length(min=1, max=20, message="公司编码长度必须介于 1 和 20 之间")
	public String getGsbm() {
		return gsbm;
	}

	/**
     * 公司编码
     */
	public void setGsbm(String gsbm) {
		this.gsbm = gsbm == null ? null : gsbm.trim();
	}
	
	/**
     * 公司中文名称
     */
	@Length(min=0, max=100, message="公司中文名称长度必须介于 0 和 100 之间")
	public String getGszwmc() {
		return gszwmc;
	}

	/**
     * 公司中文名称
     */
	public void setGszwmc(String gszwmc) {
		this.gszwmc = gszwmc == null ? null : gszwmc.trim();
	}
	
	/**
     * 公司英文名称
     */
	@Length(min=0, max=100, message="公司英文名称长度必须介于 0 和 100 之间")
	public String getGsywmc() {
		return gsywmc;
	}

	/**
     * 公司英文名称
     */
	public void setGsywmc(String gsywmc) {
		this.gsywmc = gsywmc == null ? null : gsywmc.trim();
	}
	
	/**
     * 公司中文地址
     */
	@Length(min=0, max=100, message="公司中文地址长度必须介于 0 和 100 之间")
	public String getGszwdz() {
		return gszwdz;
	}

	/**
     * 公司中文地址
     */
	public void setGszwdz(String gszwdz) {
		this.gszwdz = gszwdz == null ? null : gszwdz.trim();
	}
	
	/**
     * 公司英文地址
     */
	@Length(min=0, max=100, message="公司英文地址长度必须介于 0 和 100 之间")
	public String getGsywdz() {
		return gsywdz;
	}

	/**
     * 公司英文地址
     */
	public void setGsywdz(String gsywdz) {
		this.gsywdz = gsywdz == null ? null : gsywdz.trim();
	}
	
	/**
     * 备注
     */
	@Length(min=0, max=50, message="备注长度必须介于 0 和 50 之间")
	public String getBz() {
		return bz;
	}

	/**
     * 备注
     */
	public void setBz(String bz) {
		this.bz = bz == null ? null : bz.trim();
	}

	public String getSapgsdm() {
		return sapgsdm;
	}

	public void setSapgsdm(String sapgsdm) {
		this.sapgsdm = sapgsdm;
	}
	
}