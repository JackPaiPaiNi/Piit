package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.sdo.mdm.vo.ShippmentDaysVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 走货日期定义DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface ShippmentDaysDao extends IBaseDao<ShippmentDaysVo> {
	
}