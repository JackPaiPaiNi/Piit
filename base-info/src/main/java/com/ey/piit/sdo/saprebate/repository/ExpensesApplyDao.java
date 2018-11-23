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
public interface ExpensesApplyDao extends IBaseDao<TitleVo> {
	
	Map<String, Object> callSelectExpApplyById(Map<String, Object> param);
	Map<String, Object> callApproveItem(Map<String, Object> param);

	

}