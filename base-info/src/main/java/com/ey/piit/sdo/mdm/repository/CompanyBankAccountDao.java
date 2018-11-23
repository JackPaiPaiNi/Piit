package com.ey.piit.sdo.mdm.repository;

import java.util.List;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.mdm.vo.CompanyBankAccountVo;

/**
 * 公司信息维护DAO接口
 * 
 * @author z赵桃军
 */
@BatisRepository
public interface CompanyBankAccountDao extends IBaseDao<CompanyBankAccountVo> {
  List<CompanyBankAccountVo> queryCompanyBank(CompanyBankAccountVo vo) ;
}