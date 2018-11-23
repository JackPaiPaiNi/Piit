package com.ey.piit.sdo.invoice.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.Emp;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.invoice.repository.ShippingInstructionDao;
import com.ey.piit.sdo.invoice.repository.ShippingInstructionItemDao;
import com.ey.piit.sdo.invoice.vo.ShippingInstructionItemVo;
import com.ey.piit.sdo.invoice.vo.ShippingInstructionVo;
import com.ey.piit.sdo.invoice.vo.ShippingReferDeliverVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 补料单信息维护Service
 * @author 高文浩
 */
@Service
@Transactional(readOnly = true)
public class ShippingInstructionService {

	@Autowired
	private ShippingInstructionItemDao shippingInstructionItemDao;
	@Autowired
	private ShippingInstructionDao shippingInstructionDao;
	@Autowired
	private ExportUtil exportUtil;

	@SuppressWarnings("unchecked")
	public Object callQueryByPage(ShippingInstructionVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		shippingInstructionDao.callSelect(param);
		List<ShippingInstructionVo> list = (List<ShippingInstructionVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(ShippingInstructionVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		shippingInstructionDao.callSelect(param);
		List<ShippingInstructionVo> list = (List<ShippingInstructionVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		shippingInstructionDao.callSelectById(param);
		List<ShippingInstructionVo> list = (List<ShippingInstructionVo>) param.get("list");
		List<ShippingInstructionItemVo> jzxList = (List<ShippingInstructionItemVo>) param.get("jzxList");
		ShippingInstructionVo vo = list.get(0);
		vo.setShippingInstructionItemList(jzxList);
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryChxxByPage(ShippingReferDeliverVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		shippingInstructionDao.callSelectChxx(param);
		List<ShippingReferDeliverVo> list = (List<ShippingReferDeliverVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryBlxx(String chxx) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("chxx", chxx);
		shippingInstructionDao.callSelectBlxx(param);
		List<ShippingInstructionVo> list = (List<ShippingInstructionVo>) param.get("list");
		List<ShippingInstructionItemVo> mxList = (List<ShippingInstructionItemVo>) param.get("mxList");
		ShippingInstructionVo vo = list.get(0);
		vo.setShippingInstructionItemList(mxList);
		User user = UserUtils.getUser();
		Emp emp = UserUtils.getEmp();
		vo.setCwzy(user.getUserName());
		vo.setDh(emp.getPhone());
		vo.setCz(emp.getFax());
		vo.setYx(user.getEmail());
		vo.setZdsj(new Date());
		return vo;
	}
	
	@Transactional
	public Object edit(ShippingInstructionVo vo) {
		// 数据保存前
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		// 数据保存后
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public void delete(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		shippingInstructionDao.callDelete(param);
		this.callAfter(param);
	}
	
	private Map<String, Object> save(ShippingInstructionVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		shippingInstructionDao.callInsert(param);
		// 循环插入发票信息
		for (ShippingInstructionItemVo shippingInstructionItem : vo.getShippingInstructionItemList()){
			shippingInstructionItem.setBldh(vo.getBldh());
			shippingInstructionItem.setId(Identities.uuid());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", shippingInstructionItem);
			shippingInstructionItemDao.callInsertItem(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		return param;
	}
	/**
	 * 根据出货信息查询出库明细
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryCkmx(ShippingInstructionItemVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("chxx", vo.getChxx());
		shippingInstructionItemDao.callSelectCkmxByChxx(param);
		List<ShippingInstructionItemVo> list = (List<ShippingInstructionItemVo>) param.get("ckmxList");
		return list;
	}
	
	/**
	 * 导出出库明细
	 * @param response
	 * @param params
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public void exportCkmx(HttpServletResponse response, Map<String, Object> params, ShippingInstructionItemVo vo) {
		try {
			List<ShippingInstructionItemVo> list = (List<ShippingInstructionItemVo>) this.callQueryCkmx(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, ShippingInstructionVo vo) {
		// TODO 自动生成的方法存根
		try {
			List<ShippingInstructionVo> list = (List<ShippingInstructionVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(ShippingInstructionVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
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