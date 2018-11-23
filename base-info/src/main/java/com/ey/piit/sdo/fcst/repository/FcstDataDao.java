package com.ey.piit.sdo.fcst.repository;

import java.util.Map;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.fcst.vo.FcstDataVo;

/**
 * 采购FCST填报DAO接口
 * @author 邓海
 */
@BatisRepository
public interface FcstDataDao extends IBaseDao<FcstDataVo>{
	
	void callSelectPid(Map<String, Object> param);
	
	void callSelect(Map<String, Object> param);
	
	void callSelectFcst(Map<String, Object> param);	
	
	void callSelectApprove(Map<String, Object> param);

	void callSelectApproveFcst(Map<String, Object> param);
	
	void callQuery(Map<String, Object> param);
	
	void callSelectTitles(Map<String, Object> param);

	void callSelectOrderFcstTitles(Map<String, Object> param);
	
	void callSelectFcstTitles(Map<String, Object> param);	
	
	void callSelectApproveTitles(Map<String, Object> param);	
	
	void callInsert(Map<String, Object> param);
	
	void callInsertApprove(Map<String, Object> param);
	
	void callSave(Map<String, Object> param);
	
	void callSaveDzzg(Map<String, Object> param);
	
	void callSaveApprove(Map<String, Object> param);

	void callSubmit(Map<String, Object> param);
	
	void callDelete(Map<String, Object> param);
	
	void callRemove(Map<String, Object> param);
	
	void callCancel(Map<String, Object> param);

	void callQueryDqznr(Map<String, Object> param);
	
	void callSelectOrderFcst(Map<String, Object> param);
	
	void saveOrUpdate(Map<String, Object> param);	
}