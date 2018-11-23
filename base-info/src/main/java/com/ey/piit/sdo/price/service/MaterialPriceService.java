package com.ey.piit.sdo.price.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.sdo.price.repository.MaterialPriceDao;
import com.ey.piit.sdo.price.vo.MaterialPriceVo;
import com.ey.piit.core.service.BaseService;

/**
 * 物料价格Service
 * @author 魏诚
 */
@Service
public class MaterialPriceService extends BaseService<MaterialPriceDao, MaterialPriceVo> {
	
	@Autowired
	private MaterialPriceDao dao;
	
	@Transactional
	public void tbwljg() {
		dao.callTbwljg();
	}
	
}