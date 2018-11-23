package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.sdo.mdm.vo.SupplierInfoVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 供应商信息维护DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface SupplierInfoDao extends IBaseDao<SupplierInfoVo> {

	void callTbgys();
	
}