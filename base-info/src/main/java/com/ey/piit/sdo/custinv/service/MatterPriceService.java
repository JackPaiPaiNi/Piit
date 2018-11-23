package com.ey.piit.sdo.custinv.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.custinv.dao.MatterPriceDao;
import com.ey.piit.sdo.custinv.vo.MatterPriceVo;

/**
 * 客户物料价格库Service
 * 
 * @author 魏诚
 */
@Service
public class MatterPriceService {

	@Autowired
	private MatterPriceDao dao;

	@Autowired
	private ExportUtil exportUtil;
    
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(MatterPriceVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<MatterPriceVo> list = (List<MatterPriceVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(MatterPriceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<MatterPriceVo> list = (List<MatterPriceVo>) param.get("list");
		return list;
	}
	
	@Transactional
	public Object save(List<MatterPriceVo> list) {
		// 循环保存明细
		for(MatterPriceVo vo : list){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", vo);
			dao.callSave(param);
			this.callAfter(param);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", "000000");
		result.put("resultMsg", "导入成功");
		return result;
	}

	public void export(HttpServletResponse response, Map<String, Object> params, MatterPriceVo vo) {
		try {
			@SuppressWarnings("unchecked")
			List<MatterPriceVo> list = (List<MatterPriceVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}

	/**
	 * 调用存储过程后判断操作是否成功
	 * 
	 * @param param
	 */
	public void callAfter(Map<String, Object> param) {
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}
    
}