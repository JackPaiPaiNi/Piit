package com.ey.piit.interfaces.order.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

/**
 * 订单推送SAP接口
 * @author 邓海
 */
@BatisRepository
public interface IOrderDao {
	void callSelectProductByIdHw(Map<String, Object> param);
	void callSelectSpoByIdHw(Map<String, Object> param);
	void callSelectSimpleByIdHw(Map<String, Object> param);
	void callSelectDiversityByIdHw(Map<String, Object> param);
	void callSelectFyByIdHw(Map<String, Object> param);
	
	void callSelectProductByIdZz(Map<String, Object> param);
	void callSelectSpoByIdZz(Map<String, Object> param);
	void callSelectSimpleByIdZz(Map<String, Object> param);
	void callSelectDiversityByIdZz(Map<String, Object> param);
	void callSelectFyByIdZz(Map<String, Object> param);
	/************************变更推送SAP取数开始**********************/
	void callSelectProductBgHw(Map<String, Object> param);
	void callSelectSpoBgHw(Map<String, Object> param);
	void callSelectSimpleBgHw(Map<String, Object> param);
	void callSelectDiversityBgHw(Map<String, Object> param);
	void callSelectFyBgHw(Map<String, Object> param);
	
	void callSelectProductBgZz(Map<String, Object> param);
	void callSelectSpoBgZz(Map<String, Object> param);
	void callSelectSimpleBgZz(Map<String, Object> param);
	void callSelectDiversityBgZz(Map<String, Object> param);
	void callSelectFyBgZz(Map<String, Object> param);
	/************************变更推送SAP取数结束**********************/
}