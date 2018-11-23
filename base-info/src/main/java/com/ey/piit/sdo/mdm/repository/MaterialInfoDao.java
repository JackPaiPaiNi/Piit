package com.ey.piit.sdo.mdm.repository;

import com.ey.piit.sdo.mdm.vo.MaterialInfoVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 物料管理DAO接口
 * @author 田荣
 */
@BatisRepository
public interface MaterialInfoDao extends IBaseDao<MaterialInfoVo> {
	//同步物料信息
	void callTbwlxx();
	
}