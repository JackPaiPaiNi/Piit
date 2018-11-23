package com.ey.piit.sdo.payment.repository;

import com.ey.piit.sdo.payment.vo.PayCreditDetialVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 信用额度使用明细查询DAO接口
 * @author zhaotaojun
 */
@BatisRepository
public interface PayCreditDetialDao extends IBaseDao<PayCreditDetialVo> {
	
}