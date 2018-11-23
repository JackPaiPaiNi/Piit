package com.ey.piit.sdo.agent.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.agent.repository.AgentDao;
import com.ey.piit.sdo.agent.vo.AgentVo;

/**
 * 委托Service
 * 
 * @author 高文浩
 */
@Service
public class AgentService {

	@Autowired
	private AgentDao agentDao;
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(AgentVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		param.put("page", page);
		agentDao.callSelect(param);
		List<AgentVo> list = (List<AgentVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		agentDao.callSelectById(param);
		List<AgentVo> list = (List<AgentVo>) param.get("list");
		AgentVo vo=new AgentVo();
		if(list.size()>0){
			vo = list.get(0);
		}
		return vo;
	}
	
	@Transactional
	public Map<String, Object> submit(AgentVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		agentDao.callInsert(param);
		this.callAfter(param);
		return param;
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(AgentVo vo) {
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
	 * 
	 * @param param
	 */
	private void callAfter(Map<String, Object> param) {
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}
	
	/**
	 * 委托取消
	 * @param vo
	 */
	@Transactional
	public void cancel(AgentVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		agentDao.callCancel(param);
		this.callAfter(param);
	}

}