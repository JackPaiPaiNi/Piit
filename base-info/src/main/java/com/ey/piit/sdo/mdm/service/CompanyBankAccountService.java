package com.ey.piit.sdo.mdm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.service.BaseService;
import com.ey.piit.sdo.mdm.repository.CompanyBankAccountDao;
import com.ey.piit.sdo.mdm.vo.CompanyBankAccountVo;

/**
 * 公司银行账号维护Service
 * @author z赵桃军
 */
@Service
@Transactional(readOnly = true)
public class CompanyBankAccountService extends BaseService<CompanyBankAccountDao, CompanyBankAccountVo> {

	public List<CompanyBankAccountVo>queryCompanyBacnk(CompanyBankAccountVo vo){
	   return  dao.queryCompanyBank(vo);
	}
}