package com.ey.piit.sdo.report.repository;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 月度报表
 * @author 江果林
 */
@BatisRepository
public interface ShipmentPlanReportDao {
	
	void callSelectMonthlyCount(Map<String, Object> param);

	void callSelectMonthSum(Map<String, Object> param);
	
	void callSelectShipplanCount(Map<String, Object> param);

}
