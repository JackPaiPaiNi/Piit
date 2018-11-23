package com.ey.piit.sdo.mdm.repository;

import java.util.Map;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.mdm.vo.CompanyInfoVo;

/**
 * 公司信息维护DAO接口
 * @author z赵桃军
 */
@BatisRepository
public interface CompanyInfoDao extends IBaseDao<CompanyInfoVo> {
	
	int deleteBankAccount(CompanyInfoVo companyInfoVo);

	void callSelectSyr(Map<String, Object> param);
}