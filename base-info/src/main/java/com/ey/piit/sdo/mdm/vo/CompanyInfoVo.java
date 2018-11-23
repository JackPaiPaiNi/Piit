package com.ey.piit.sdo.mdm.vo;

import com.ey.piit.sdo.mdm.entity.CompanyInfo;
import java.util.List;
import com.google.common.collect.Lists;

/**
 * 公司信息维护Entity
 * @author z赵桃军
 */
public class CompanyInfoVo extends CompanyInfo {
	
	private String syrmc;  //受益人名称
	private String syrdz;  //受益人地址

	private List<CompanyBankAccountVo> companyBankAccountList = Lists.newArrayList();		// 子表列表

	public CompanyInfoVo() {
		super();
	}

	public CompanyInfoVo(String id){
		super(id);
	}
	public List<CompanyBankAccountVo> getCompanyBankAccountList() {
		return companyBankAccountList;
	}

	public void setCompanyBankAccountList(List<CompanyBankAccountVo> companyBankAccountList) {
		this.companyBankAccountList = companyBankAccountList;
	}

	public String getSyrmc() {
		return syrmc;
	}

	public void setSyrmc(String syrmc) {
		this.syrmc = syrmc;
	}

	public String getSyrdz() {
		return syrdz;
	}

	public void setSyrdz(String syrdz) {
		this.syrdz = syrdz;
	}

}