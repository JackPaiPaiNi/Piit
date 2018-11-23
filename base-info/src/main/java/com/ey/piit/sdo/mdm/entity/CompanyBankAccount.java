package com.ey.piit.sdo.mdm.entity;

import org.hibernate.validator.constraints.Length;

import com.ey.piit.core.entity.BaseEntity;

/**
 * 公司信息维护Entity
 * @author z赵桃军
 */
public class CompanyBankAccount extends BaseEntity {
	
	private String gsbm;		// 公司编码 父类
	private String yhzh; // 银行账号
	private String swiftdm; // 银行swif帐号
	private String bz; // 币种
	private Integer sfLc; // 是否LC
	private String bzxx; // 备注信息
	
	public CompanyBankAccount() {
		super();
	}

	public CompanyBankAccount(String id){
		super(id);
	}

	/**
     * 公司编码
     */
	@Length(min=1, max=20, message="公司编码长度必须介于 1 和 20 之间")
	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}
	
	/**
     * 银行帐号
     */
	@Length(min=1, max=20, message="银行帐号长度必须介于 1 和 20 之间")
	public String getYhzh() {
		return yhzh;
	}

	/**
     * 银行帐号
     */
	public void setYhzh(String yhzh) {
		this.yhzh = yhzh == null ? null : yhzh.trim();
	}

	public String getSwiftdm() {
		return swiftdm;
	}

	public void setSwiftdm(String swiftdm) {
		this.swiftdm = swiftdm;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Integer getSfLc() {
		return sfLc;
	}

	public void setSfLc(Integer sfLc) {
		this.sfLc = sfLc;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}
	
	
	
	
	
	
}