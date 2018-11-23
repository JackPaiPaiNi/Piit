package com.ey.piit.sdo.mdm.service;

import org.springframework.stereotype.Service;

import com.ey.piit.sdo.mdm.repository.ProductBomDao;
import com.ey.piit.sdo.mdm.vo.ProductBomVo;
import com.ey.piit.core.service.BaseService;

/**
 * 产品研发BOM查看Service
 * @author 赵桃军
 */
@Service
public class ProductBomService extends BaseService<ProductBomDao, ProductBomVo> {
	public int deleteByPid(Object vo) {
		return dao.deleteByPid(vo);
	}
}