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
import com.ey.piit.sdo.report.repository.ReportDao;
import com.ey.piit.sdo.report.vo.OrderStatusVo;

@Service
public class OrderStatusService  {
	@Autowired
	private ExportUtil exportUtil;
	@Autowired
	private ReportDao dao;
	/**
	 * 订单装填信息导出
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, OrderStatusVo vo) {
		try {
			List<OrderStatusVo> list = (List<OrderStatusVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public Object callQuery(OrderStatusVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectOrderStatus(param); 
		List<OrderStatusVo> list = (List<OrderStatusVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(OrderStatusVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectOrderStatus(param);
		List<OrderStatusVo> list = (List<OrderStatusVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
}
