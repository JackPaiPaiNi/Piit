package com.ey.piit.sdo.pub.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.baseinfo.dict.vo.DictVo;
import com.ey.piit.sdo.mdm.vo.PidInfoVo;
import com.ey.piit.sdo.pub.entity.CompanyCode;
import com.ey.piit.sdo.pub.repository.Select2Dao;

/**
 * PUB管理Service
 * @author 魏诚
 */
@Service
public class Select2Service{

	@Autowired
	private Select2Dao select2Dao;
	
	public Object callQueryCountry(){
    	return select2Dao.selectAllCountry();
	}
	
	/**
	 * 查询PID申请的工程师
	 * @param roleCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQuerySjsByRole(String roleCode) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("code", roleCode);
		select2Dao.callSelectSjsByRole(param);
		List<PidInfoVo> list = (List<PidInfoVo>) param.get("list");
		return list;
	}
	
	/**
	 * 查询加工方式
	 * @param roleCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryJgfs(String zhfs) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("zhfs", zhfs);
		select2Dao.callSelectJgfs(param);
		List<DictVo> list = (List<DictVo>) param.get("list");
		return list;
	}
	
	/**
	 * 查询收货方代码
	 * @param roleCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryShfdm(String xwgj) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("xwgj", xwgj);
		select2Dao.callSelectShfdm(param);
		List<CompanyCode> list = (List<CompanyCode>) param.get("list");
		return list;
	}
}