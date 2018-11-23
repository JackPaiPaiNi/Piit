package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.sdo.mdm.vo.ExchangeRateVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 汇率DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface ExchangeRateDao extends IBaseDao<ExchangeRateVo> {
	
}