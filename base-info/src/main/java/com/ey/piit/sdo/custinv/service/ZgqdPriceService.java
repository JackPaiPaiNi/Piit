package com.ey.piit.sdo.custinv.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.sdo.custinv.dao.ZgqdPriceDao;
import com.ey.piit.sdo.custinv.vo.ZgqdPriceVo;

/**
 * 以装柜清单为基础-调价表Service
 * 
 * @author 魏诚
 */
@Service
public class ZgqdPriceService {

	@Autowired
	private ZgqdPriceDao dao;
    
	public Object callQueryByPage(ZgqdPriceVo vo, PageBounds page) {
		if(StringUtils.isBlank(vo.getChdh())){
			Paginator paginator = new Paginator(page.getPage(), page.getLimit(), 0);
			return new PageList<Object>(new ArrayList<ZgqdPriceVo>(), paginator);
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectZgqd(param);
		@SuppressWarnings("unchecked")
		List<ZgqdPriceVo> list = (List<ZgqdPriceVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@Transactional
	public Object zgqdAdjust1(ZgqdPriceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callZgqdAdjust1(param);
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		} else {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("resultCode", "000000");
			result.put("resultMsg", "装柜清单自动核算价格完成");
			return result;
		}
	}
	
	@Transactional
	public Object zgqdAdjust2(ZgqdPriceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callZgqdAdjust2(param);
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		} else {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("resultCode", "000000");
			result.put("resultMsg", "装柜清单自动核算价格完成");
			return result;
		}
	}
	
	@Transactional
	public Object jhdAdjust(ZgqdPriceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callJhdAdjust(param);
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		} else {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("resultCode", "000000");
			result.put("resultMsg", "SAP交货单自动核算价格完成");
			return result;
		}
	}
    
}