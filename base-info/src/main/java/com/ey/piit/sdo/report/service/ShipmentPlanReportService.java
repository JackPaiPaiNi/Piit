package com.ey.piit.sdo.report.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.report.repository.ShipmentPlanReportDao;
import com.ey.piit.sdo.report.vo.MonthSumTableVo;
import com.ey.piit.sdo.report.vo.MonthlyCountTableVo;
import com.ey.piit.sdo.report.vo.ShipplanCountTableVo;

/**
 * 出货计划报表Service
 * @author 魏诚
 */
@Service
public class ShipmentPlanReportService {
	@Autowired
	private ShipmentPlanReportDao dao;

	@Autowired
	private ExportUtil exportUtil;
	
	/**
	 * 月度统计表（分页）
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryMonthlyCountByPage(MonthlyCountTableVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectMonthlyCount(param);
		List<MonthlyCountTableVo> list = (List<MonthlyCountTableVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 月度统计表
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Object callQueryMonthlyCount(MonthlyCountTableVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectMonthlyCount(param);
		List<MonthlyCountTableVo> list = (List<MonthlyCountTableVo>) param.get("list");
    	return list;
	}	
	
	/**
	 * 月度统计表导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public void exportMonthlyCount(HttpServletResponse response, Map<String, Object> params, MonthlyCountTableVo vo) {
		try {
			List<MonthlyCountTableVo> list = (List<MonthlyCountTableVo>) this.callQueryMonthlyCount(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	/**
	 * 月度汇总 表（分页）
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryMonthSumByPage(MonthSumTableVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectMonthSum(param);
		List<MonthSumTableVo> list = (List<MonthSumTableVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 月度汇总表
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Object callQueryMonthSum(MonthSumTableVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectMonthSum(param);
		List<MonthSumTableVo> list = (List<MonthSumTableVo>) param.get("list");
    	return list;
	}	
	
	/**
	 * 月度汇总表导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public void exportMonthSum(HttpServletResponse response, Map<String, Object> params, MonthSumTableVo vo) {
		try {
			List<MonthSumTableVo> list = (List<MonthSumTableVo>) this.callQueryMonthSum(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	/**
	 * 出货计划统计表（分页）
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryShipplanCountByPage(ShipplanCountTableVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectShipplanCount(param);
		List<ShipplanCountTableVo> list = (List<ShipplanCountTableVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 出货计划统计表
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Object callQueryShipplanCount(ShipplanCountTableVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectShipplanCount(param);
		List<ShipplanCountTableVo> list = (List<ShipplanCountTableVo>) param.get("list");
    	return list;
	}
	
	/**
	 * 出货计划统计表导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public void exportShipplanCount(HttpServletResponse response, Map<String, Object> params, ShipplanCountTableVo vo) {
		try {
			List<ShipplanCountTableVo> list = (List<ShipplanCountTableVo>) this.callQueryShipplanCount(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
}
