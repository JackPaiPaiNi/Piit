package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.sdo.mdm.vo.ProductBomVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 产品研发BOM查看DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface ProductBomDao extends IBaseDao<ProductBomVo> {
	int deleteByPid(Object entity);
}