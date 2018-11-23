package com.ey.piit.sdo.custinv.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.custinv.dao.SiDao;
import com.ey.piit.sdo.custinv.vo.ShippingNoticeVo;
import com.ey.piit.sdo.custinv.vo.SiItemVo;
import com.ey.piit.sdo.custinv.vo.SiShippingNoticeVo;
import com.ey.piit.sdo.custinv.vo.SiVo;

/**
 * @author: junc
 * @date: 2018-2018年6月29日-上午8:53:10
 * @Description: SI业务功能类
 */
@Service
public class SiService {
	@Autowired
	private SiDao siDao;

	/**
	 * @return: Object
	 * @Description: 根据条件查询SI集合
	 */
	@SuppressWarnings("unchecked")
	public Object findSiList(SiVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		siDao.callSelects(param);
		List<SiVo> list = (List<SiVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	/**
	 * @return Object => 查询出货通知单结果集
	 * @Description: SI拉取 出货通知单信息查询结果集
	 */
	@SuppressWarnings("unchecked")
	public Object searhList(ShippingNoticeVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		siDao.callSelectList(param);
		List<SiShippingNoticeVo> list = (List<SiShippingNoticeVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	/**
	 * @return =>Si单 主详信息
	 * @Description: 根据选择的出货单号，查询SI单所需要的主详信息
	 */

	@SuppressWarnings("unchecked")
	public Object searhShippingInfo(String chdNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("chdNo", chdNo);
		siDao.callShippingInfo(param);
		List<SiVo> vos = (List<SiVo>) param.get("list");
		if (vos == null || vos.size() < 1) {
			throw new RuntimeException("数据错误！查询抓取数据结果为空");
		}
		SiVo siVo = vos.get(0);
		List<SiItemVo> mxList = (List<SiItemVo>) param.get("mxList");
		siVo.setSiItemList(mxList);
		return siVo;
	}

	/**
	 * @return Object
	 * @Description: 根据SI编号查询SI明细信息
	 */

	@SuppressWarnings("unchecked")
	public Object searchSiItem(String siNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("siNo", siNo);
		siDao.callSelectItems(param);
		List<SiItemVo> list = (List<SiItemVo>) param.get("list");
		return list;
	}

	/**
	 * @return
	 * @Description: 根据ID查询一个SI主信息
	 */
	@SuppressWarnings("unchecked")
	public Object findById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		siDao.callSelectById(param);
		List<SiVo> list = (List<SiVo>) param.get("list");
		if (list == null || list.size() < 1) {
			throw new RuntimeException("数据查询错误！未找到 \"" + id + "\"信息");
		}
		SiVo vo = list.get(0);
		List<SiItemVo> items = (List<SiItemVo>) param.get("mxList");
		vo.setSiItemList(items);
		return vo;
	}

	/**
	 * @param id
	 *            => si ID
	 * @param sjc
	 *            => si 时间戳
	 * @return Object 执行删除结果
	 * @Description: 删除SI信息
	 */
	@Transactional
	public Object delete(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		siDao.callDelete(param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", param.get("resultCode"));
		result.put("resultMsg", param.get("resultMsg"));
		return result;
	}

	/**
	 * @param id
	 *            => SI ID
	 * @param sjc
	 *            => SI 时间戳
	 * @return Object 执行提价结果
	 * @Description: 提交SI单据
	 */
	@Transactional
	public Object submit(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		User user = UserUtils.getUser();
		param.put("id", id);
		param.put("sjc", sjc);
		param.put("czr", user.getId());
		param.put("czrmc", user.getUserName());
		param.put("sjc", sjc);
		siDao.callSubmit(param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", param.get("resultCode"));
		result.put("resultMsg", param.get("resultMsg"));
		return result;
	}

	/**
	 * 
	 * @param id => si单ID
	 * @param sjc =>SI单时间戳
	 * @return Object 执行取消装填
	 * @Description:
	 * 		取消已生效的单据
	 */
	@Transactional
	public Object cencel(String id, String sjc){
		Map<String, Object> param = new HashMap<String, Object>();
		User user = UserUtils.getUser();
		param.put("id", id);
		param.put("sjc", sjc);
		param.put("czr", user.getId());
		param.put("czrmc", user.getUserName());
		param.put("sjc", sjc);
		siDao.callCancel(param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", param.get("resultCode"));
		result.put("resultMsg", param.get("resultMsg"));
		return result;
	}
	/**
	 * 
	 * @param vo
	 *            => 保存对象
	 * @return Object => 保存信息
	 * @Description: 保存SI订单信息
	 */
	@Transactional
	public Object save(SiVo vo) {
		// 数据保存前
		this.callBefore(vo);
		Map<String, Object> param = this.saveSi(vo);
		// 数据保存后
		this.callAfter(param);
		return vo;
	}

	private Map<String, Object> saveSi(SiVo vo) {
		/*
		 * if ("null".equals(vo.getId()) || vo.getId() == null) {
		 * vo.setId(Identities.uuid()); }
		 */
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		siDao.callSave(param);
		// 循环插入发票其他费用明细信息
		for (SiItemVo invoiceOther : (List<SiItemVo>) vo.getSiItemList()) {
			invoiceOther.setSino(vo.getSino());
			invoiceOther.setId(Identities.uuid());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", invoiceOther);
			siDao.callSaveITEM(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		return param;
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
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(SiVo vo) {
		/*
		 * if (Oper.add.equals(vo.getOper())) { vo.preInsert(); } else if
		 * (Oper.edit.equals(vo.getOper())) { vo.preUpdate(); }
		 */
		if (StringUtils.isBlank(vo.getId()) || "_empty".equals(vo.getId())) {
			vo.setId(Identities.uuid());
		}
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}
}
