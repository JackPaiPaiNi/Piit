package com.ey.piit.sdo.payment.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.payment.repository.PayCreditDao;
import com.ey.piit.sdo.payment.vo.PayCreditVo;
import com.ey.piit.core.utils.ExportUtil;

import net.sf.json.JSONArray;

/**
 * 信用额度管理Service
 * @author 田荣
 */
@Service
public class PayCreditService {

	@Autowired
	private PayCreditDao dao;
	
	@Autowired
	private ExportUtil exportUtil;
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(PayCreditVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<PayCreditVo> list = (List<PayCreditVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(PayCreditVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<PayCreditVo> list = (List<PayCreditVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryById(String id){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<PayCreditVo> list = (List<PayCreditVo>) param.get("list");
		PayCreditVo vo = list.get(0);
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callChangeById(String id, String sjc){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		dao.callChangeById(param);
		this.callAfter(param);
		List<PayCreditVo> list = (List<PayCreditVo>) param.get("list");
		PayCreditVo vo = list.get(0);
		return vo;
	}
	
	/*@Transactional
	public Object edit(PayCreditVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		return vo;
	}*/
	
	@Transactional
	public void submit(PayCreditVo vo){
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		dao.callSubmit(param);
		this.callAfter(param);
	}
	
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public void approve(PayCreditVo vo){
		JSONArray array = JSONArray.fromObject(vo.getRows());
		List<PayCreditVo> list = (List<PayCreditVo>) JSONArray.toCollection(array, PayCreditVo.class);
		User user = UserUtils.getUser();
		for(int i=0;i<list.size();i++){
			PayCreditVo _vo=list.get(i);	
			_vo.setSprid(user.getLoginAcct());
			_vo.setSprmc(user.getUserName());
			_vo.setApproveType(vo.getApproveType());
			_vo.setSpyj(vo.getSpyj());
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", _vo);
			dao.callApprove(param);
			this.callAfter(param);
		}
	}
	
	@Transactional
	public void delete(String id, String sjc){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		dao.callDelete(param);
		this.callAfter(param);
	}
	
	private Map<String, Object> save(PayCreditVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callInsert(param);
		this.callAfter(param);
		return param;
	}
	
	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(PayCreditVo vo) {
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
	public void export(HttpServletResponse response, Map<String, Object> params, PayCreditVo vo){
		try {
			List<PayCreditVo> list = (List<PayCreditVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
    //冻结，解冻
	@Transactional
	public void frozen(PayCreditVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callFrozen(param);
		this.callAfter(param);
	}
	//调整额度
	@Transactional
	public void adjust(PayCreditVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callAdjust(param);
		this.callAfter(param);
	}
}