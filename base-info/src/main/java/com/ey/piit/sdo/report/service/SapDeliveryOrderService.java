package com.ey.piit.sdo.report.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.report.repository.ReportDao;
import com.ey.piit.sdo.report.vo.SapDeliveryOrderVo;

/**
 * SAP交货单明细Service
 * @author 高文浩
 */
@Service
public class SapDeliveryOrderService{
	
	@Autowired
	private ReportDao dao;

	@Autowired
	private ExportUtil exportUtil;
	
	/**
	 * 回款发票报表查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectSapDeliveryByPage(SapDeliveryOrderVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectSapDelivery(param);
		List<SapDeliveryOrderVo> list = (List<SapDeliveryOrderVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 回款发票报表查询
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQuery(SapDeliveryOrderVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectSapDelivery(param);
		List<SapDeliveryOrderVo> list = (List<SapDeliveryOrderVo>) param.get("list");
    	return list;
	}	
	
	/**
	 * 回款发票信息导出
	 * @param response
	 * @param params	
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, SapDeliveryOrderVo vo) {
		try {
			List<SapDeliveryOrderVo> list = (List<SapDeliveryOrderVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
}