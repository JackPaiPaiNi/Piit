package com.ey.piit.sdo.pub.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * PUB管理DAO接口
 * @author 魏诚
 */
@BatisRepository
public interface WidgetDao {
	// 弹出框选客户
	void callSelectCust(Map<String, Object> param);
	// 弹出框选客户根据销售员
	void callSelectCustByXsy(Map<String, Object> param);	
	// 弹出框选银行
	void callSelectBank(Map<String, Object> param);
	// 弹出框选公司银行
	void callSelectCompanyBank(Map<String, Object> param);
	// 弹出框选PID
	void callSelectPid(Map<String, Object> param);
	// 弹出框选物料
	void callSelectMaterial(Map<String, Object> param);
	// 弹出框选LC
	void callSelectLc(Map<String, Object> param);
	// 弹出框选销售组织、业务组
	void callSelectOrg(Map<String, Object> param);
	// 弹出框选委托人信息
	void callSelectBwtrxx(Map<String, Object> param);
	// 弹出框选美工任务单
	void callSelectMgrwd(Map<String, Object> param);
}