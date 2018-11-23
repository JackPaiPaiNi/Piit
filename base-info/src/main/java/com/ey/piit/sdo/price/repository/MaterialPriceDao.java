package com.ey.piit.sdo.price.repository;

import com.ey.piit.sdo.price.vo.MaterialPriceVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 物料价格DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface MaterialPriceDao extends IBaseDao<MaterialPriceVo> {

	void callTbwljg();
	
}