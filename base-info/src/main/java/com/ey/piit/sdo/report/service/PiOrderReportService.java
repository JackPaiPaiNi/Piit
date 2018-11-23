package com.ey.piit.sdo.report.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.report.repository.ReportDao;
import com.ey.piit.sdo.report.vo.PiOrderDataVo;
/**
 * 报表Service
 * @author 赵明
 */	
@Service
public class PiOrderReportService {
	@Autowired
	private ReportDao dao;

	@Autowired
	private ExportUtil exportUtil;

	/**
	 * PI订单查询
	 * */
	@SuppressWarnings("unchecked")
	public Object callSelectPiOrderByPage(PiOrderDataVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectPiOrder(param);
		List<PiOrderDataVo> list = (List<PiOrderDataVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}	
}