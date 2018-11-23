package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.sdo.mdm.vo.ShippingCompanyVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 船代公司信息维护DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface ShippingCompanyDao extends IBaseDao<ShippingCompanyVo> {
	
}