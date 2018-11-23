package com.ey.piit.sdo.payment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.User;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.payment.repository.PayPiBindBlendDao;
import com.ey.piit.sdo.payment.vo.PayPiBindBlendVo;
import com.ey.piit.sdo.payment.vo.PayPiBindDetailVo;
import com.ey.piit.sdo.payment.vo.PayPiBindItemVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * PI付款保障已使用Service
 * @author 田荣
 */
@Service
public class PayPiBindBlendService {
	
	@Autowired
	private PayPiBindBlendDao dao;
	
	@Autowired
	private ExportUtil exportUtil;
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(PayPiBindItemVo vo, PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<PayPiBindItemVo> list = (List<PayPiBindItemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(PayPiBindItemVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<PayPiBindItemVo> list = (List<PayPiBindItemVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, PayPiBindItemVo vo){
		try {
			List<PayPiBindItemVo> list = (List<PayPiBindItemVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryDbByPage(PayPiBindItemVo vo, PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectDb(param);
		List<PayPiBindItemVo> list = (List<PayPiBindItemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryDb(PayPiBindItemVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectDb(param);
		List<PayPiBindItemVo> list = (List<PayPiBindItemVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public void exportDb(HttpServletResponse response, Map<String, Object> params, PayPiBindItemVo vo){
		try {
			List<PayPiBindItemVo> list = (List<PayPiBindItemVo>)this.callQueryDb(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPiid(String piid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("piid", piid);
		dao.callSelectByPiid(param);
		List<PayPiBindBlendVo> list = (List<PayPiBindBlendVo>) param.get("list");
		return list;
	}
	
	@Transactional
	public void saveBlend(PayPiBindItemVo vo, List<PayPiBindBlendVo> list) {
		//先删除，再保存
		this.deleteBlend(vo.getGddh());
		Map<String, Object> param = new HashMap<String, Object>();
		for (PayPiBindBlendVo voitem : list) {
			voitem.setId("");
			voitem.setOper(vo.getOper());
			voitem.setGddh(vo.getGddh());
			this.callBefore(voitem);
			param.put("vo", voitem);
			dao.callSaveBlend(param);
			callAfter(param);
		}
		
	}
	
	@Transactional
	public void blendAuto(String piids) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("piids", piids);
		dao.callBlendAuto(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void deleteBlend(String gddh) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("gddh", gddh);
		dao.calldeleteBlend(param);
		this.callAfter(param);
	}
	
	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(PayPiBindBlendVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
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
}