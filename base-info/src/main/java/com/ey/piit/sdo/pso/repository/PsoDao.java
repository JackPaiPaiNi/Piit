package com.ey.piit.sdo.pso.repository;
import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 预走货DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface PsoDao {
    void callSelect(Map<String, Object> param);
	
	void callSelectById(Map<String, Object> param);
	
	void callInsert(Map<String, Object> param);
	
	void callSubmit(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
	
	void callApprove(Map<String, Object> param);
	
	void callCancel(Map<String, Object> param);
	
	void callChange(Map<String, Object> param);
	
	//储运补录信息查询
	void callCyblSelect(Map<String, Object> param);
	//储运补录信息保存
	void callCyblSave(Map<String, Object> param);
	//船务分派查询
	void callSelectCwfp(Map<String, Object> param);
	//船务分派保存
	void callSaveCwfp(Map<String, Object> param);
	//船务预处理保存
    void callCwyclSave(Map<String, Object> param);
	//预走货选择订单查询
	void callQueryDdxxByPage(Map<String, Object> param);
	//预走货所选订单的PI信息查询
	void callQuerySpoReferPixx(Map<String, Object> param);
	//预走货应收超期检查
	void callPsoYscqSave(Map<String, Object> param);
	//SMO审核处理
	void callSmoApprove(Map<String, Object> param);  
	//预走货取回
	void callGetback(Map<String, Object> param);
	//船务处理发邮件
	void callSelectEmail(Map<String, Object> param);
	//查询预走货订单信息
	void callSelectYzhxx(Map<String, Object> param);
	//查询预走货中是否含有收费订单
	void callQueryPsoFree(Map<String, Object> param);
}