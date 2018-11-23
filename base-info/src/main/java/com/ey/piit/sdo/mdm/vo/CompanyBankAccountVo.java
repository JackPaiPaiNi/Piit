package com.ey.piit.sdo.mdm.vo;

import com.ey.piit.sdo.mdm.entity.CompanyBankAccount;

/**
 * 公司信息维护Entity
 * @author z赵桃军
 */
public class CompanyBankAccountVo extends CompanyBankAccount {
    
	private  String  gsbm ;//公司编码
    private  String  zwmc ;//银行中文名称    
    private  String  zwdz ;//银行中文地址
    private  String  ywmc ;//银行英文名称    
    private  String  ywdz ;//银行英文地址
    
	public CompanyBankAccountVo() {
		super();
	}

	public CompanyBankAccountVo(String id){
		super(id);
	}

	public String getZwmc() {
		return zwmc;
	}

	public void setZwmc(String zwmc) {
		this.zwmc = zwmc;
	}

	public String getZwdz() {
		return zwdz;
	}

	public void setZwdz(String zwdz) {
		this.zwdz = zwdz;
	}

	public String getYwmc() {
		return ywmc;
	}

	public void setYwmc(String ywmc) {
		this.ywmc = ywmc;
	}

	public String getYwdz() {
		return ywdz;
	}

	public void setYwdz(String ywdz) {
		this.ywdz = ywdz;
	}

	public String getGsbm() {
		return gsbm;
	}

	public void setGsbm(String gsbm) {
		this.gsbm = gsbm;
	}

}