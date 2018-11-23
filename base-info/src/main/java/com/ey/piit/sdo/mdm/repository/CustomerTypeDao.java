package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.sdo.mdm.vo.CustomerTypeVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 客户分类管理DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface CustomerTypeDao extends IBaseDao<CustomerTypeVo> {
	
}