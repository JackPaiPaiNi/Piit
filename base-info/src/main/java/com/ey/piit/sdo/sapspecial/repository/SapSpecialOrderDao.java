package com.ey.piit.sdo.sapspecial.repository;

import com.ey.piit.sdo.sapspecial.vo.SapSpecialOrderVo;

import java.util.Map;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * sap特价审批管理DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface SapSpecialOrderDao extends IBaseDao<SapSpecialOrderVo> {
	Map<String, Object> callSelect(Map<String, Object> param);
	Map<String, Object> callSubmit(Map<String, Object> param);
	Map<String, Object> callApprove(Map<String, Object> param);
	Map<String, Object> callSelectById(Map<String, Object> param);
	Map<String, Object> callQueryLog(Map<String, Object> param);
	Map<String, Object> callComplete(Map<String, Object> param);
}