package com.ey.piit.sdo.mdm.repository;

import java.util.Map;

import com.ey.piit.sdo.mdm.vo.CustomerInfoVo;
import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 客户信息维护DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface CustomerInfoDao extends IBaseDao<CustomerInfoVo> {
	void callSelect(Map<String, Object> param);
	void callUpdate(Map<String, Object> param);
	/**
	 * 同步客户主数据
	 */
	void callTbkhxx();
}