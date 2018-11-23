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
import com.ey.piit.sdo.report.vo.EuropeSKDorderStatusVo;
/**
 * 欧洲供应链SKD订单状态表Service
 * @author 魏诚
 */	
@Service
public class EuropeSKDorderStatusService {
	@Autowired
	private ReportDao dao;

	@Autowired
	private ExportUtil exportUtil;

	/**
	 * 欧洲供应链SKD订单状态查询
	 */
	@SuppressWarnings("unchecked")
	public Object callSelectEuropeSKDorderStatusByPage(EuropeSKDorderStatusVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		// 可控部门
		//param.put("bmIds", UserUtils.getOrgCodes());
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectEuropeSKDorderStatus(param);
		List<EuropeSKDorderStatusVo> list = (List<EuropeSKDorderStatusVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	/**
	 * 欧洲供应链SKD订单状态查询
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public Object callQuery(EuropeSKDorderStatusVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		// 可控部门
		//param.put("bmIds", UserUtils.getOrgCodes());
		param.put("vo", vo);
		dao.callSelectEuropeSKDorderStatus(param);
		List<EuropeSKDorderStatusVo> list = (List<EuropeSKDorderStatusVo>) param.get("list");
    	return list;
	}	
	/**
	 * 欧洲供应链SKD订单状态信息导出
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, EuropeSKDorderStatusVo vo) {
		try {
			List<EuropeSKDorderStatusVo> list = (List<EuropeSKDorderStatusVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
}