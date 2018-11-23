package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.sdo.mdm.vo.ContractVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 合同信息维护DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface ContractDao extends IBaseDao<ContractVo> {
	
}