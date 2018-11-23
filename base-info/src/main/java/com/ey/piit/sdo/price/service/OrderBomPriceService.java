package com.ey.piit.sdo.price.service;

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
import com.ey.piit.sdo.price.repository.OrderBomPriceDao;
import com.ey.piit.sdo.price.vo.JhdPriceVo;
import com.ey.piit.sdo.price.vo.OrderBomPriceVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 销单BOM价格Service
 * @author 邓海
 */
@Service
public class OrderBomPriceService  {
	@Autowired
	private OrderBomPriceDao dao;

	@Autowired
	private ExportUtil exportUtil;
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(OrderBomPriceVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelect(param);
		List<OrderBomPriceVo> list = (List<OrderBomPriceVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryJhdByPage(JhdPriceVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectJhdByPage(param);
		List<JhdPriceVo> list = (List<JhdPriceVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryOrderByPage(JhdPriceVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectOrderByPage(param);
		List<JhdPriceVo> list = (List<JhdPriceVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public OrderBomPriceVo callQueryById(String id){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<OrderBomPriceVo> list = (List<OrderBomPriceVo>) param.get("list");
		OrderBomPriceVo vo = list.get(0);
		return vo;
	}

	
	@SuppressWarnings("unchecked")
	public Object callQuery(OrderBomPriceVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelect(param);
		List<OrderBomPriceVo> list = (List<OrderBomPriceVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuerySKD(OrderBomPriceVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelectSKD(param);
		List<OrderBomPriceVo> list = (List<OrderBomPriceVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryJhd(JhdPriceVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectJhd(param);
		List<JhdPriceVo> list = (List<JhdPriceVo>) param.get("list");
		return list;
	}
	
	
	private Map<String, Object> save(OrderBomPriceVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		return param;
	}
	
	private Map<String, Object> saveJhdSingle(JhdPriceVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsertJhd(param);
		return param;
	}
	
	@Transactional
	public Object edit(OrderBomPriceVo vo) {	
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		return vo;
	}
	/**
	 * 批量保存ckd或skd的单价 
	 * @param list
	 * @param drlx
	 * @return
	 */
	public Object saveCkdSkd(List<OrderBomPriceVo> list,String drlx){
		this.savePl(list, drlx);
		OrderBomPriceVo vo=new OrderBomPriceVo();
		if(list.size()>0){
			vo=list.get(0);
			vo.setDrlx(drlx);
			this.checkZje(vo);
		}
		return vo;
	}
	
	@Transactional
	public void savePl(List<OrderBomPriceVo> list,String drlx) {	
		//循环保存bom价格
		for (OrderBomPriceVo orderBomPriceVo : list) {
			try {
				orderBomPriceVo.setDrlx(drlx);
				this.callBefore(orderBomPriceVo);
				Map<String, Object> param = this.save(orderBomPriceVo);
				this.callAfter(param);
			} catch (Exception e) {
				throw e;
			}

		}	
	}
	
	/**
	 * 批量保存ckd或skd的单价 
	 * @param list
	 * @param drlx
	 * @return
	 */
	public void saveJhd(List<JhdPriceVo> list){
		this.savePlJhd(list);
	}
	
	@Transactional
	public void savePlJhd(List<JhdPriceVo> list) {	
		//循环保存bom价格
		for (JhdPriceVo jhdPriceVo : list) {
			try {
				this.callBeforeJhd(jhdPriceVo);
				Map<String, Object> param = this.saveJhdSingle(jhdPriceVo);
				this.callAfter(param);
			} catch (Exception e) {
				throw e;
			}

		}	
	}
	
	//CKD的验证bom总金额需要>=订单总金额；(提示用户bom总金额和订单总金额)
	private Map<String, Object> checkZje(OrderBomPriceVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callValidateZje(param);
		vo.setMsg(param.get("resultMsg").toString());
		return param;
	}
	
	

	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(OrderBomPriceVo vo) {
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
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBeforeJhd(JhdPriceVo vo) {
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
	public void export(HttpServletResponse response, Map<String, Object> params, OrderBomPriceVo vo){
		try {
			List<OrderBomPriceVo> list = (List<OrderBomPriceVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void exportSKD(HttpServletResponse response, Map<String, Object> params, OrderBomPriceVo vo){
		try {
			List<OrderBomPriceVo> list = (List<OrderBomPriceVo>)this.callQuerySKD(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void exportJhd(HttpServletResponse response, Map<String, Object> params, JhdPriceVo vo){
		try {
			List<JhdPriceVo> list = (List<JhdPriceVo>)this.callQueryJhd(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
	
	
}