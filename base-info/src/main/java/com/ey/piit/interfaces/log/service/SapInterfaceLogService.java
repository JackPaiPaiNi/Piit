package com.ey.piit.interfaces.log.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.interfaces.log.repository.SapInterfaceLogDao;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;

/**
 * SAP接口日志Service
 * @author 魏诚
 */
@Service
public class SapInterfaceLogService {
	
	@Autowired
	private SapInterfaceLogDao dao;
	
	@SuppressWarnings("unchecked")
	public Object callQueryLog(String id,String fplx) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("fplx", fplx);
		dao.callSelectLog(param);
		List<SapInterfaceLogVo> list = (List<SapInterfaceLogVo>) param.get("list");
		return list;
	}
	
	@Transactional
	public void save(SapInterfaceLogVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSaveLog(param);
		this.callAfter(param);
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