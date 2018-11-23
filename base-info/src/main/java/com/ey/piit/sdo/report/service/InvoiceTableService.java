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
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.report.repository.ReportDao;
import com.ey.piit.sdo.report.vo.InvoiceTableVo;
/**
 * 报表Service
 * @author 魏诚
 */	
@Service
public class InvoiceTableService {
	@Autowired
	private ReportDao dao;

	@Autowired
	private ExportUtil exportUtil;

	/**
	 * 发票查询
	 * */
	@SuppressWarnings("unchecked")
	public Object callSelectInvoiceTableByPage(InvoiceTableVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		// 可控部门
		//param.put("bmIds", UserUtils.getOrgCodes());
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectInvoiceTable(param);
		List<InvoiceTableVo> list = (List<InvoiceTableVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	/**
	 * 发票查询
	 * */
	@SuppressWarnings("unchecked")
	public Object callQuery(InvoiceTableVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		param.put("vo", vo);
		dao.callSelectInvoiceTable(param);
		List<InvoiceTableVo> list = (List<InvoiceTableVo>) param.get("list");
    	return list;
	}	
	/**
	 * 发票信息导出
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, InvoiceTableVo vo) {
		try {
			List<InvoiceTableVo> list = (List<InvoiceTableVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
}