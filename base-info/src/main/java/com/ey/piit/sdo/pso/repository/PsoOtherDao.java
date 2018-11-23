package com.ey.piit.sdo.pso.repository;
import java.util.Map;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 预走货DAO接口
 * @author 赵桃军
 */
@BatisRepository
public interface PsoOtherDao  {
	void callInsert(Map<String, Object> param);
	//自动生成保费
	void callInsertBf(Map<String, Object> param);
	//更新费用明细
	void callUpdateOther(Map<String, Object> param);
	//清除费用明细
	void callDeleteOther(Map<String, Object> param);
	
	
	
}