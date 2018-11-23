package com.ey.piit.sdo.shipmentplan.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.shipmentplan.repository.ShipmentPlanDao;
import com.ey.piit.sdo.shipmentplan.vo.ShipmentPlanVo;

/**
 * 走货计划Service
 * 
 * @author tianrong
 */
@Service
@Transactional(readOnly = true)
public class ShipmentPlanService {
	@Autowired
	private ShipmentPlanDao shipmentPlanDao;

	@Autowired
	private ExportUtil exportUtil;

	@SuppressWarnings("unchecked")
	public Object callQueryByPage(ShipmentPlanVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());

		shipmentPlanDao.callSelect(param);
		List<ShipmentPlanVo> list = (List<ShipmentPlanVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(ShipmentPlanVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		shipmentPlanDao.callSelect(param);
		List<ShipmentPlanVo> list = (List<ShipmentPlanVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public ShipmentPlanVo callQueryByYzhdh(String yzhdh) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("yzhdh", yzhdh);
		shipmentPlanDao.callSelectByYzhdh(param);
		List<ShipmentPlanVo> list = (List<ShipmentPlanVo>) param.get("list");
		ShipmentPlanVo vo  = new ShipmentPlanVo();
		if(list.size()>0){
			vo= list.get(0);
		}
		return vo;
	}

	@Transactional
	public Object edit(ShipmentPlanVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		this.callBefore(vo);
		shipmentPlanDao.callInsert(param);
		this.callAfter(param);
		return vo;
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(ShipmentPlanVo vo) {
		if (StringUtils.isEmpty(vo.getId())) {
			vo.preInsert();
		} else {
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
	public void export(HttpServletResponse response, Map<String, Object> params, ShipmentPlanVo vo) {
		try {
			List<ShipmentPlanVo> list = (List<ShipmentPlanVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
}