package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.sdo.mdm.vo.BankVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 银行信息维护DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface BankDao extends IBaseDao<BankVo> {
	
}