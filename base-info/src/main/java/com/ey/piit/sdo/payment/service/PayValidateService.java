package com.ey.piit.sdo.payment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.sdo.payment.repository.PayValidateDao;
import com.ey.piit.sdo.payment.vo.PayValidateVo;

/**
 * 付款保障检查Service
 * @author 魏诚
 */
@Service
public class PayValidateService {
	
	@Autowired
	private PayValidateDao dao;
	
	/**
	 * 查询付款保障日志
	 * @param yzhdh
	 * @param ddid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object payCheckSelectLog(String id){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectLog(param);
		List<PayValidateVo> list = (List<PayValidateVo>) param.get("list");
		return list;
	}
	
	/**
	 * 订单付款保障检查 外部调用(监听用)
	 * @param ddid
	 * @param ddlx
	 */
	public Object payCheckOrder(String id, String ddlx){
		Map<String, Object> param=new HashMap<String,Object>();
		try {
			//param= (Map<String, Object>) this.checkOrder(id, ddlx);
			param.put("id", id);
			param.put("ddlx", ddlx);
			dao.callCheckOrder(param);
			this.callAfter(param);
		} catch (Exception e) {
			param.put("resultCode", "0");
		}
		return param;	
	}
	
	/**
	 * 订单付款保障检查
	 * @param ddid
	 * @param ddlx
	 */
	@Transactional
	private Object checkOrder(String id, String ddlx){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("ddlx", ddlx);
		dao.callCheckOrder(param);
		this.callAfter(param);
		return param;
	}
	
	/**
	 * 预走货付款保障检查 供外部调用
	 * @param id
	 * @return
	 */
	@Transactional
	public Object payCheckPso(String id){
		Map<String, Object> param=new HashMap<String,Object>();
		try {
			param.put("id", id);
			dao.callCheckPso(param);
			this.callAfter(param);
		} catch (Exception e) {
			param.put("resultCode", "0");
		}
		return param;	
	}
	
	/**
	 * 记录付款保障检查日志 过程中已做事务提交或回滚 
	 * @param 
	 */
	public Object paySaveLog(PayValidateVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSaveLog(param);
		return param;
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