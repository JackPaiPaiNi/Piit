package com.ey.piit.sdo.sapspecial.repository;

import com.ey.piit.sdo.sapspecial.vo.SapSpecialItemVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * sap特价审批管理DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface SapSpecialItemDao extends IBaseDao<SapSpecialItemVo> {
	
}