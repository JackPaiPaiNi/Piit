package com.ey.piit.sdo.mdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.sdo.mdm.repository.MaterialInfoDao;
import com.ey.piit.sdo.mdm.vo.MaterialInfoVo;
import com.ey.piit.core.service.BaseService;

/**
 * 物料管理Service
 * @author 田荣
 */
@Service
public class MaterialInfoService extends BaseService<MaterialInfoDao, MaterialInfoVo> {
	
	@Autowired
	private MaterialInfoDao dao;
	
	/**
	 * 同步物料信息
	 */
	@Transactional
	public void tbwlxx() {
		dao.callTbwlxx();
	}
	
}