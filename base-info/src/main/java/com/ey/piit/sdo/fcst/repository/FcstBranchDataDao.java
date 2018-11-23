package com.ey.piit.sdo.fcst.repository;
import java.util.Map;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 分公司销售数据填报DAO接口
 * 
 * @author 赵桃军
 */
@BatisRepository
public interface FcstBranchDataDao  {

	void callSelect(Map<String, Object> param);
	
	void callSelectJoin(Map<String, Object> param);

	void callInsert(Map<String, Object> param);
	
	void callSave(Map<String, Object> param);

	void callDelete(Map<String, Object> param);
	
	void callSelectTitles(Map<String, Object> param);
	
	void callSelectHtyTitles(Map<String, Object> param);

	void callSelectHistory(Map<String, Object> param);
	
	void callSelectStatisticTitles(Map<String, Object> param);
	
	void callSelectStatistic(Map<String, Object> param);
	
	void callSelectBranchModel(Map<String , Object> param);
	
	void insertModelChart(Map<String, Object> param);
	
	void updateModelChart(Map<String, Object> param);
	
	void deleteModelChart(Map<String , Object> param);	
}