package com.ey.piit.sdo.price.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.sdo.price.repository.SkdPriceDao;
import com.ey.piit.sdo.price.vo.SkdPriceVo;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;

/**
 * skd价格Service
 * @author 邓海
 */
@Service
public class SkdPriceService  {
	@Autowired
	private SkdPriceDao dao;

	@Autowired
	private ExportUtil exportUtil;
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(SkdPriceVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<SkdPriceVo> list = (List<SkdPriceVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	@SuppressWarnings("unchecked")
	public SkdPriceVo callQueryById(String id){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<SkdPriceVo> list = (List<SkdPriceVo>) param.get("list");
		SkdPriceVo vo = list.get(0);
		return vo;
	}

	
	@SuppressWarnings("unchecked")
	public Object callQuery(SkdPriceVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<SkdPriceVo> list = (List<SkdPriceVo>) param.get("list");
		return list;
	}
	
	
	private Map<String, Object> save(SkdPriceVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		return param;
	}
	
	@Transactional
	public Object edit(SkdPriceVo vo) {	
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public void submit(SkdPriceVo vo){
		this.callBefore(vo);
		vo.setType(1);//1表示修改数据
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
	}
	

	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(SkdPriceVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}
	

	/**
	 * 调用存储过程后判断操作是否成功
	 * @param param
	 */
	private void callAfter(Map<String, Object> param){
		if(!"SDO-000000".equals(param.get("resultCode").toString())){
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, SkdPriceVo vo){
		try {
			List<SkdPriceVo> list = (List<SkdPriceVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
}