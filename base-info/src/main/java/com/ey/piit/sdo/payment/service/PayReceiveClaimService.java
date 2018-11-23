package com.ey.piit.sdo.payment.service;

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
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.interfaces.payment.dao.IPayReceiveClaimDao;
import com.ey.piit.interfaces.payment.dto.PayReceiveClaimBodyDto;
import com.ey.piit.interfaces.payment.dto.PayReceiveClaimMsgResponse;
import com.ey.piit.interfaces.payment.service.PayReceiveClaimInterfaceService;
import com.ey.piit.sdo.payment.repository.PayReceiveClaimDao;
import com.ey.piit.sdo.payment.vo.InvoiceVo;
import com.ey.piit.sdo.payment.vo.PayReceiveClaimVo;
import com.ey.piit.core.utils.ExportUtil;

import net.sf.json.JSONArray;

/**
 * 收款认领Service
 * 
 * @author 邓海
 */
@Service
public class PayReceiveClaimService {
	@Autowired
	private PayReceiveClaimDao dao;

	@Autowired
	private ExportUtil exportUtil;

	@Autowired
	private IPayReceiveClaimDao iDao;

	@Autowired
	private PayReceiveClaimInterfaceService iPayReceiveClaimService;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;

	@SuppressWarnings("unchecked")
	public Object callQueryByPage(PayReceiveClaimVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<PayReceiveClaimVo> list = (List<PayReceiveClaimVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQueryDbd(PayReceiveClaimVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectDbd(param);
		List<PayReceiveClaimVo> list = (List<PayReceiveClaimVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(PayReceiveClaimVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<PayReceiveClaimVo> list = (List<PayReceiveClaimVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<PayReceiveClaimVo> list = (List<PayReceiveClaimVo>) param.get("list");
		PayReceiveClaimVo vo = list.get(0);
		return vo;
	}

	@SuppressWarnings("unchecked")
	public Object callChangeById(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		dao.callChangeById(param);
		this.callAfter(param);
		List<PayReceiveClaimVo> list = (List<PayReceiveClaimVo>) param.get("list");
		PayReceiveClaimVo vo = list.get(0);
		return vo;
	}

	@Transactional
	public Object edit(PayReceiveClaimVo vo) {
		for (PayReceiveClaimVo item : vo.getList()) {
			item.setSkdh(vo.getSkdh());
			item.setSjsxf(vo.getSjsxf());
			item.setFj(vo.getFj());
			item.setBz(vo.getBz());
			item.setKhbm(vo.getKhbm());
			item.setKhmc(vo.getKhmc());

			this.callBefore(item);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", item);
			dao.callInsert(param);
			this.callAfter(param);
		}
		return vo;
	}

	@Transactional
	public void submit(PayReceiveClaimVo vo) {
		for (PayReceiveClaimVo item : vo.getList()) {
			item.setSkdh(vo.getSkdh());
			//item.setSjsxf(vo.getSjsxf());
			item.setFj(vo.getFj());
			item.setBz(vo.getBz());
			item.setKhbm(vo.getKhbm());
			item.setKhmc(vo.getKhmc());

			this.callBefore(item);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", item);
			dao.callInsert(param);
			this.callAfter(param);
			dao.callSubmit(param);
			this.callAfter(param);
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	public void approve(PayReceiveClaimVo vo) {
		JSONArray array = JSONArray.fromObject(vo.getRows());
		List<PayReceiveClaimVo> list = (List<PayReceiveClaimVo>) JSONArray.toCollection(array, PayReceiveClaimVo.class);
		User user = UserUtils.getUser();
		for (int i = 0; i < list.size(); i++) {
			PayReceiveClaimVo _vo = list.get(i);
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
	public Map<String, Object> delete(PayReceiveClaimVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callDelete(param);
		this.callAfter(param);
		return param;
	}

	@Transactional
	public Map<String, Object> cancel(PayReceiveClaimVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callCancel(param);
		this.callAfter(param);
		return param;
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(PayReceiveClaimVo vo) {
		if (StringUtils.isEmpty(vo.getRldh())) {
			vo.setId(Identities.uuid());
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
	public void export(HttpServletResponse response, Map<String, Object> params, PayReceiveClaimVo vo) {
		try {
			List<PayReceiveClaimVo> list = (List<PayReceiveClaimVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}

	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<PayReceiveClaimMsgResponse> pushSAP(PayReceiveClaimVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		iDao.callSelectById(param);
		List<PayReceiveClaimBodyDto> requestList = (List<PayReceiveClaimBodyDto>) param.get("list");
		List<PayReceiveClaimMsgResponse> responseList = null;
		// 调用sap接口
		try {
			responseList = iPayReceiveClaimService.PayReceiveClaimSdoToSap(requestList);
		} catch (Exception e) {
			throw new ServiceException("调用SAP收款认领接口失败！");
		}
		boolean flag = true;
		// 回写收款认领推送SAP状态
		for (PayReceiveClaimMsgResponse pcmr : responseList) {
			if (!"X".equals(pcmr.getResult())) {
				flag = false;
				break;
			}
		}
		if (flag) {
			vo.setTssapzt(1);
		} else {
			vo.setTssapzt(0);
		}
		return responseList;
	}
	
	// 推送SAP并且记录返信息货日志
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void tsSapAndWriteLog(PayReceiveClaimVo vo) {
		// 执行推送
		List respList = pushSAP(vo);
		// 更改单据推送状态
		complete(vo);
		// 保存推送返回信息日志
		saveTsSapLog(vo, respList);
	}

	// 保存推送制造SAP和海外SAP反馈细信息日志
	@Transactional
	public void saveTsSapLog(PayReceiveClaimVo vo, List<PayReceiveClaimMsgResponse> list) {
		if (vo == null) {
			throw new ServiceException("推送sap的vo为空");
		}
		for (PayReceiveClaimMsgResponse payReceiveClaimMsgResponse : list) {
			if (payReceiveClaimMsgResponse == null) {
				throw new ServiceException("推送sap返回信息为空");
			}
			// 保存推送日志
			SapInterfaceLogVo logvo = new SapInterfaceLogVo();
			logvo.setId(vo.getId());
			logvo.setDh(vo.getRldh());
			logvo.setMk("收款认领");
			logvo.setSj(new Date());
			logvo.setFhzt(vo.getTssapzt());
			logvo.setFhxx(payReceiveClaimMsgResponse.getMsg());
			logvo.setBw(payReceiveClaimMsgResponse.getInXml());
			
			try {
				sapInterfaceLogService.save(logvo);
			} catch (Exception e) {
				new ServiceException("保存SAP返回信息日志出错");
			}
		}
	}
	
	// 预收款转回款
	@Transactional
	public void yskToHk(PayReceiveClaimVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callYskToHk(param);
		this.callAfter(param);
	}
	
	// 预收款冻结&解冻
		@Transactional
	public void yskDjAndJd(PayReceiveClaimVo vo) {
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callYskDjAndJd(param);
		this.callAfter(param);
	}



	private void complete(PayReceiveClaimVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callComplete(param);
		this.callAfter(param);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryInvoice(InvoiceVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectInvoice(param);
		List<InvoiceVo> list = (List<InvoiceVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

}