package com.ey.piit.sdo.order.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.order.repository.OrderReferPiDao;
import com.ey.piit.sdo.order.vo.OrderReferPiVo;
import com.ey.piit.sdo.order.vo.OrderSpoVo;

/**
 * PI选择Service
 * @author 赵明
 */
@Service
public class OrderReferPiService {
	
	@Autowired
	private OrderReferPiDao orderReferPiDao;
	
	@SuppressWarnings("unchecked")
	public Object callQuerySpoByPage(OrderReferPiVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		orderReferPiDao.callSelectSPO(param);
		List<OrderReferPiVo> list = (List<OrderReferPiVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 根据PIID调用pi service服务获取pi明细
	 * @param piid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryByPIId(String piid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("piid", piid);
		orderReferPiDao.callSelectByPIId(param);
		List<OrderReferPiVo> wlList = (List<OrderReferPiVo>) param.get("wlList");
		OrderSpoVo vo = new OrderSpoVo();
		vo.setOrderReferPiVo(wlList);
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryOrderByPage(OrderReferPiVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		orderReferPiDao.callSelectOrder(param);
		List<OrderReferPiVo> list = (List<OrderReferPiVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuerySampleByPage(OrderReferPiVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		orderReferPiDao.callSelectSample(param);
		List<OrderReferPiVo> list = (List<OrderReferPiVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryDiversityByPage(OrderReferPiVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		orderReferPiDao.callSelectDiversity(param);
		List<OrderReferPiVo> list = (List<OrderReferPiVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	@SuppressWarnings("unchecked")
	public Object callQueryFyByPage(OrderReferPiVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		orderReferPiDao.callSelectFy(param);
		List<OrderReferPiVo> list = (List<OrderReferPiVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
}