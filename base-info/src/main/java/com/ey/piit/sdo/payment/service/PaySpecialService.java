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
import com.ey.piit.sdo.payment.repository.PaySpecialDao;
import com.ey.piit.sdo.payment.vo.PaySpecialItemVo;
import com.ey.piit.sdo.payment.vo.PaySpecialVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 特批维护Service
 * @author 田荣
 */
@Service
public class PaySpecialService {
	@Autowired
	private PaySpecialDao dao;
	
	@Autowired
	private ExportUtil exportUtil;
	
	/**
	 * 特批查询（分页）
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(PaySpecialVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<PaySpecialVo> list = (List<PaySpecialVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 特批查询（不分页）
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQuery(PaySpecialVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<PaySpecialVo> list = (List<PaySpecialVo>) param.get("list");
		return list;
	}
	
	/**
	 * 根据特批id查询
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryById(String id){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<PaySpecialVo> list = (List<PaySpecialVo>) param.get("list");
		List<PaySpecialItemVo> mxList = (List<PaySpecialItemVo>) param.get("mxList");
		PaySpecialVo vo = list.get(0);
		vo.setItemList(mxList);
		return vo;
	}
	
	/**
	 * 特批保存
	 * @param vo
	 */
	@Transactional
	public void edit(PaySpecialVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callInsert(param);
		this.callAfter(param);
	}
	
	/**
	 * 特批消除
	 * @param vo
	 * @return
	 */
	@Transactional
	public Object xc(PaySpecialVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callXc(param);
		this.callAfter(param);
		return param;
		
	}
	
	/**
	 * 特批删除
	 * @param vo
	 */
	@Transactional
	public void delete(PaySpecialVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callDelete(param);
		this.callAfter(param);
	}
	
	/**
	 * 特批导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, PaySpecialVo vo){
		try {
			List<PaySpecialVo> list = (List<PaySpecialVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
	/**
	 * 订单选择查询（分页）
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object orderQueryByPage(PaySpecialVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectOrder(param);
		List<PaySpecialVo> list = (List<PaySpecialVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 待特批的预走货查询（应收超期）
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object yzhQueryByPage(PaySpecialVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectYzh(param);
		List<PaySpecialVo> list = (List<PaySpecialVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	
	/**
	 * 检查是否存在应收超期特批
	 * 
	 */
	public Object queryYscqtp(String yzhdh){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("yzhdh", yzhdh);
		dao.callQueryYscqtp(param);
		return param;
	}
	
	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(PaySpecialVo vo) {
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
	
	//批量保存特批
	@Transactional
	public void pledit(PaySpecialVo vo,List<PaySpecialVo> list){
		for(PaySpecialVo paySpecialVo:list){
			paySpecialVo.setOper(vo.getOper());
			paySpecialVo.setTpjd(vo.getTpjd());
			this.callBefore(paySpecialVo);
			Map<String, Object> param = new HashMap<String, Object>();
			if("".equals(paySpecialVo.getTpsj())){
				paySpecialVo.setTpsj(new Date());
			}
			param.put("vo", paySpecialVo);
			dao.callInsert(param);
			this.callAfter(param);
		}
	}
}