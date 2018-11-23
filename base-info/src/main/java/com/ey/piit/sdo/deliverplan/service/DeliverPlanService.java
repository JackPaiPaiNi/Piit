package com.ey.piit.sdo.deliverplan.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.deliverplan.repository.DeliverPlanDao;
import com.ey.piit.sdo.deliverplan.repository.DeliverPlanItemDao;
import com.ey.piit.sdo.deliverplan.vo.DeliverPlanItemVo;
import com.ey.piit.sdo.deliverplan.vo.DeliverPlanVo;
import com.ey.piit.core.utils.ExportUtil;
/**
 * 走货计划单Service
 * 
 * @author 邓海
 */
@Service
public class DeliverPlanService {

	@Autowired
	private DeliverPlanDao dao;

	@Autowired
	private DeliverPlanItemDao deliverPlanItemDao;
	@Autowired
	private ExportUtil exportUtil;
    
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(DeliverPlanVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<DeliverPlanVo> list = (List<DeliverPlanVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryZhjhByPage(DeliverPlanVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectZhjh(param);
		List<DeliverPlanVo> list = (List<DeliverPlanVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryWhbByPage(DeliverPlanVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectWhb(param);
		List<DeliverPlanVo> list = (List<DeliverPlanVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(DeliverPlanVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelect(param);
		List<DeliverPlanVo> list = (List<DeliverPlanVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryWhb(DeliverPlanVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelectWhb(param);
		List<DeliverPlanVo> list = (List<DeliverPlanVo>) param.get("list");
		return list;
	}

	
	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<DeliverPlanVo> list = (List<DeliverPlanVo>) param.get("list");
		List<DeliverPlanItemVo> mxList = (List<DeliverPlanItemVo>) param.get("mxList");
		DeliverPlanVo vo = new DeliverPlanVo();
	    if(list.size()>0){
	        vo = list.get(0);
	    	vo.setDeliverPlanItemList(mxList);
	    }
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object qryZhmx(DeliverPlanVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("khbm", vo.getKhbm());
		param.put("zgkssj", vo.getZgkssj());
		param.put("zgjssj", vo.getZgjssj());
		param.put("yzhdh", vo.getYzhdh());
		dao.callQryZhmx(param);
		List<DeliverPlanItemVo> mxList = (List<DeliverPlanItemVo>) param.get("mxList");
		 if(mxList.size()>0){
		    	vo.setDeliverPlanItemList(mxList);
		    }else{
		    	if(param.get("msg")!=null && !"".equals(param.get("msg").toString())){
		    		vo.setMsg(param.get("msg").toString());
		    	}	
		    }
		return vo;
	}

	@Transactional
	public Object edit(DeliverPlanVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		vo.setSjc(param.get("sjc").toString());
		vo.setId(param.get("id").toString());
		this.callAfter(param);
		return vo;
	}

	@Transactional
	public void submit(DeliverPlanVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		dao.callSubmit(param);
		this.callAfter(param);
	}

	@Transactional
	public void delete(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		dao.callDelete(param);
		this.callAfter(param);
	}

	private Map<String, Object> save(DeliverPlanVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		vo.setLx("1");
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		param.put("sjc", vo.getSjc());
		param.put("id", vo.getId());
		// 循环插入保存调价单明细
		for (DeliverPlanItemVo deliverPlanItemVo : vo.getDeliverPlanItemList()) {
			deliverPlanItemVo.setId(Identities.uuid());
			deliverPlanItemVo.setZhjhdh(vo.getZhjhdh());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", deliverPlanItemVo);
			deliverPlanItemDao.callInsert(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		return param;
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(DeliverPlanVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			if (StringUtils.isEmpty(vo.getZhjhdh())) {
				vo.setId(Identities.uuid());
			}
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
	
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, DeliverPlanVo vo) {
		try {
			List<DeliverPlanVo> list = (List<DeliverPlanVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}

	}
	
	@SuppressWarnings("unchecked")
	public void combineExport(HttpServletResponse response, Map<String, Object> params, DeliverPlanVo vo) {
		try {
			List<DeliverPlanVo> list = (List<DeliverPlanVo>) this.callQueryWhb(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}

	}
	/**
	 * 合并收货计划
	 * @param vo
	 * @return
	 */
	@Transactional
	public Object combine(DeliverPlanVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callCombine(param);
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public void cancel(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		dao.callCancel(param);
		this.callAfter(param);
	}

}