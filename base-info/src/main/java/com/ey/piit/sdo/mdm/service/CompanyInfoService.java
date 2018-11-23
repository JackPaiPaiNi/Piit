package com.ey.piit.sdo.mdm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.service.BaseService;
import com.ey.piit.sdo.mdm.repository.CompanyBankAccountDao;
import com.ey.piit.sdo.mdm.repository.CompanyInfoDao;
import com.ey.piit.sdo.mdm.vo.CompanyBankAccountVo;
import com.ey.piit.sdo.mdm.vo.CompanyInfoVo;

/**
 * 公司信息维护Service
 * @author z赵桃军
 */
@Service
@Transactional(readOnly = true)
public class CompanyInfoService extends BaseService<CompanyInfoDao, CompanyInfoVo> {

	@Autowired
	private CompanyInfoDao companyInfoDao;
	
	@Autowired
	private CompanyBankAccountDao companyBankAccountDao;
	
	
	public CompanyInfoVo findById(String id) {
		CompanyInfoVo companyInfoVo = super.findById(id);
		if (companyInfoVo != null) {
			CompanyBankAccountVo cbaVo = new CompanyBankAccountVo();
			cbaVo.setGsbm(companyInfoVo.getGsbm());
			List<CompanyBankAccountVo> companyBankAccountList = companyBankAccountDao.select(cbaVo);
			companyInfoVo.setCompanyBankAccountList(companyBankAccountList);
		}
		return companyInfoVo;
	}

	@Transactional
	protected int save(CompanyInfoVo companyInfoVo) {
		int result = super.save(companyInfoVo);
		result = companyInfoDao.deleteBankAccount(companyInfoVo);
		for (CompanyBankAccountVo companyBankAccount : companyInfoVo.getCompanyBankAccountList()){
			companyBankAccount.setGsbm(companyInfoVo.getGsbm());
			companyBankAccount.preInsert();
			companyBankAccountDao.insert(companyBankAccount);
		}
		return result;
	}
	
	@Transactional
	protected int update(CompanyInfoVo companyInfoVo) {
		int result = super.update(companyInfoVo);
		result = companyInfoDao.deleteBankAccount(companyInfoVo);
		for (CompanyBankAccountVo companyBankAccount : companyInfoVo.getCompanyBankAccountList()){
			companyBankAccount.setGsbm(companyInfoVo.getGsbm());
			companyBankAccount.preInsert();
			companyBankAccountDao.insert(companyBankAccount);
		}
		return result;
	}
	
	@Transactional
	public int delete(CompanyInfoVo companyInfoVo) {
		int result = companyInfoDao.deleteBankAccount(companyInfoVo);
		result = super.delete(companyInfoVo);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuerySyr(int type) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", type);
		companyInfoDao.callSelectSyr(param);
		List<CompanyInfoVo> list = (List<CompanyInfoVo>) param.get("list");
		return list;
		
	}
}