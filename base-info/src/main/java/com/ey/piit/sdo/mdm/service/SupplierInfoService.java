package com.ey.piit.sdo.mdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.sdo.mdm.repository.SupplierInfoDao;
import com.ey.piit.sdo.mdm.vo.SupplierInfoVo;
import com.ey.piit.core.service.BaseService;

/**
 * 供应商信息维护Service
 * @author 高文浩
 */
@Service
public class SupplierInfoService extends BaseService<SupplierInfoDao, SupplierInfoVo> {
	
	@Autowired
	private SupplierInfoDao dao;
	
	/**
	 * 同步供应商信息
	 */
	@Transactional
	public void tbgys() {
		dao.callTbgys();
	}
	
}