package com.ey.piit.sdo.mdm.repository;

import java.util.Map;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.mdm.vo.EmployeeVo;

/**
 * 员工维护DAO接口
 * @author 高文浩
 */
@BatisRepository
public interface EmployeeDao extends IBaseDao<EmployeeVo> {

	EmployeeVo selectByXsyid(String loginAcct);
	
	EmployeeVo selectAdInfoById(String loginAcct);
	
	void selectAdInfo(Map<String, Object> param);
	
	void updateAdInfo(Map<String, Object> param);
	
}