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
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.payment.repository.PayPiBindDao;
import com.ey.piit.sdo.payment.vo.PayPiBindDetailVo;
import com.ey.piit.sdo.payment.vo.PayPiBindVo;
import com.ey.piit.sdo.pi.vo.PiItemVo;
import com.ey.piit.sdo.pi.vo.PiVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * PI付款保障关联Service
 * @author 田荣
 */
@Service
public class PayPiBindService {
	
	@Autowired
	private PayPiBindDao dao;
	
	@Autowired
	private ExportUtil exportUtil;
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(PiVo vo, PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<PiItemVo> list = (List<PiItemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(PiVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<PiItemVo> list = (List<PiItemVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryById(String piid){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("piid", piid);
		dao.callSelectById(param);
		List<PayPiBindVo> list = (List<PayPiBindVo>) param.get("list");
		List<PayPiBindDetailVo> ttxxList = (List<PayPiBindDetailVo>) param.get("ttxxlist");
		List<PayPiBindDetailVo> lcxxList = (List<PayPiBindDetailVo>) param.get("lcxxlist");
		PayPiBindVo vo = list.get(0);
		vo.setTt_xxlist(ttxxList);
		vo.setLc_xxlist(lcxxList);
		return vo;
	}
	
	@Transactional
	public void submit(PayPiBindVo vo) {
		// 数据保存前
		this.callBefore(vo);
		// 删除pi下所有的绑定
		this.delete(vo);
		this.saveItem(vo);
		this.save(vo);
	}
	
	private void saveItem(PayPiBindVo vo){
		User user = UserUtils.getUser();
		// 循环插入tt和lc（tt与lc都合并到ttlist中）
		for (PayPiBindDetailVo pbItem : vo.getTt_xxlist()){
			pbItem.setId(Identities.uuid());
			pbItem.setPiid(vo.getPiid());
			pbItem.setZdrid(user.getLoginAcct());
			pbItem.setZdrmc(user.getUserName());
			pbItem.setZdsj(new Date());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", pbItem);
			dao.callInsertItem(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
	}
	
	public void delete(PayPiBindVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callDelete(param);
		this.callAfter(param);
	}
	
	public void save(PayPiBindVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callInsert(param);
		this.callAfter(param);
	}
	
	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(PayPiBindVo vo) {
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
	
	@SuppressWarnings("unchecked")
	public Object callQueryItem(PiVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectItem(param);
		List<PayPiBindDetailVo> list = (List<PayPiBindDetailVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public void exportmx(HttpServletResponse response, Map<String, Object> params, PiVo vo){
		try {
			List<PayPiBindVo> list = (List<PayPiBindVo>)this.callQueryItem(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, PiVo vo){
		try {
			List<PiVo> list = (List<PiVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
	
}