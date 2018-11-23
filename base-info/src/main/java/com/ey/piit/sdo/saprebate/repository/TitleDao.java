package com.ey.piit.sdo.saprebate.repository;

import java.util.Map;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.saprebate.vo.TitleVo;

/**
 * sap费用审批DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface TitleDao extends IBaseDao<TitleVo> {
	Map<String, Object> callSelect(Map<String, Object> param);
	Map<String, Object> callSubmit(Map<String, Object> param);
	Map<String, Object> callApprove(Map<String, Object> param);
	Map<String, Object> callComplete(Map<String, Object> param);
}