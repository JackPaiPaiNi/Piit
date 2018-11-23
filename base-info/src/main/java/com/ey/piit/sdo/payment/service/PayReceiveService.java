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
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.interfaces.payment.dao.IPayReceiveDao;
import com.ey.piit.interfaces.payment.dto.PayReceiveBodyDto;
import com.ey.piit.interfaces.payment.dto.PayReceiveMsgResponse;
import com.ey.piit.interfaces.payment.service.PayReceiveInterfaceService;
import com.ey.piit.sdo.payment.repository.PayReceiveDao;
import com.ey.piit.sdo.payment.vo.PayReceiveClaimVo;
import com.ey.piit.sdo.payment.vo.PayReceiveVo;
import com.ey.piit.core.utils.ExportUtil;

import net.sf.json.JSONArray;

/**
 * 收款信息登记Service
 * @author 邓海
 */
@Service
public class PayReceiveService {
	
	@Autowired
	private PayReceiveDao dao;

	@Autowired
	private ExportUtil exportUtil;
	
	@Autowired
	private PayReceiveInterfaceService iPayReceiveService;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
	@Autowired
	private IPayReceiveDao iDao;

	@SuppressWarnings("unchecked")
	public Object callQueryDrl(PayReceiveVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectDrl(param);
		List<PayReceiveVo> list = (List<PayReceiveVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(PayReceiveVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<PayReceiveVo> list = (List<PayReceiveVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(PayReceiveVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<PayReceiveVo> list = (List<PayReceiveVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryById(String id){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<PayReceiveVo> list = (List<PayReceiveVo>) param.get("list");
		PayReceiveVo vo = list.get(0);
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryByDh(String skdh){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("skdh", skdh);
		dao.callSelectByDh(param);
		List<PayReceiveVo> list = (List<PayReceiveVo>) param.get("list");
		List<PayReceiveClaimVo> listYrl = (List<PayReceiveClaimVo>)param.get("listYrl");
		PayReceiveVo vo = list.get(0);
		vo.setPayReceiveClaimList(listYrl);
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callChangeById(String id, String sjc){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		dao.callChangeById(param);
		this.callAfter(param);
		List<PayReceiveVo> list = (List<PayReceiveVo>) param.get("list");
		PayReceiveVo vo = list.get(0);
		return vo;
	}
	
	@Transactional
	public Object edit(PayReceiveVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public void submit(PayReceiveVo vo){
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		dao.callSubmit(param);
		//收款类别为CN时不推送SAP
		if(!"3".equals(vo.getSklb())){
			tsSapAndWriteLog(vo,1);
		}
		this.callAfter(param);
	}
	
	@Transactional
	public void approve(PayReceiveVo vo){
		JSONArray array = JSONArray.fromObject(vo.getRows());
		@SuppressWarnings("unchecked")
		List<PayReceiveVo> list = (List<PayReceiveVo>) JSONArray.toCollection(array, PayReceiveVo.class);
		User user = UserUtils.getUser();
		for(int i=0;i<list.size();i++){
			PayReceiveVo _vo=list.get(i);	
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
	public Object delete(PayReceiveVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callDelete(param);
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public Object cancel(PayReceiveVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callCancel(param);
		//收款类别为CN时不推送SAP
		if(!"3".equals(vo.getSklb())){
			tsSapAndWriteLog(vo,2);
		}
		this.callAfter(param);
		return vo;
	}
	
	private Map<String, Object> save(PayReceiveVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		return param;
	}
	
	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(PayReceiveVo vo) {
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
	public void export(HttpServletResponse response, Map<String, Object> params, PayReceiveVo vo){
		try {
			List<PayReceiveVo> list = (List<PayReceiveVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	//批量导入收款登记信息
	@Transactional
	public Object saveList(PayReceiveVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		for(PayReceiveVo payReceiveVo:vo.getItemList()){
			callBefore(payReceiveVo);
			param.clear();
			param.put("vo", payReceiveVo);
			// 主表保存
			dao.callInsert(param);
			callAfter(param);
		}
		return vo;
	}
	
	//批量导入收款登记信息
	@Transactional
	public void submitList(PayReceiveVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		for(PayReceiveVo payReceiveVo:vo.getItemList()){
			callBefore(payReceiveVo);
			param.clear();
			param.put("vo", payReceiveVo);
			// 主表保存
			dao.callInsert(param);
			callAfter(param);
			dao.callSubmit(param);
			callAfter(param);
			try {
				////收款类别为CN时不推送SAP
				if(!"3".equals(vo.getSklb())){
					tsSapAndWriteLog(payReceiveVo, 1);
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	//tianrong 2016-12-19 推送SAP功能待1月1号开放
	public PayReceiveVo tsSapAndWriteLog(PayReceiveVo vo, Integer flag){
		if(vo == null){
			throw new ServiceException("系统推送SAP时未找到收款登记信息！");
		}
		// 执行推送
		PayReceiveMsgResponse resultMap = null;;
		try {
			resultMap = this.pushSAP(vo,flag);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			throw e;
		}
		//保存推送SAP状态
		saveTssapzt(vo);
		// 保存推送返回信息日志
		SapInterfaceLogVo logvo = saveTsSapLog(vo, resultMap);
		vo.setMsg(logvo.getFhxx());
		return vo;
	}
	
	/**
	 * 保存推送SAP状态
	 * @param vo
	 * @return
	 */
	private Object saveTssapzt(PayReceiveVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSaveTssapzt(param);
		this.callAfter(param);
		return param;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	private PayReceiveMsgResponse pushSAP(PayReceiveVo vo, Integer flag) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		param.put("flag", flag);
		iDao.callSelectById(param);
		List<PayReceiveBodyDto> requestList = (List<PayReceiveBodyDto>) param.get("list");
		PayReceiveMsgResponse prresponse = null;
		// 调用sap接口
		try {
			prresponse = iPayReceiveService.PayReceiveSdoToSap(requestList);
		} catch (Exception e) {
			throw new ServiceException("调用SAP收款接口失败！");
		}
		if("X".equals(prresponse.getResult())){
			vo.setTssapzt(1);
		}else{
			vo.setTssapzt(0);
		}
		return prresponse;
	}
	
	// 保存推送SAP反馈细信息日志
	@Transactional
	private SapInterfaceLogVo saveTsSapLog(PayReceiveVo vo, PayReceiveMsgResponse prMsgResponse) {
		if (vo == null) {
			throw new ServiceException("推送sap的vo为空");
		}
		if (prMsgResponse == null) {
			throw new ServiceException("推送sap返回信息为空");
		}
		// 保存推送日志
		SapInterfaceLogVo logvo = new SapInterfaceLogVo();
		logvo.setId(vo.getId());
		logvo.setDh(vo.getSkdh());
		logvo.setMk("收款登记");
		logvo.setSj(new Date());
		if("X".equals(prMsgResponse.getResult())){
			logvo.setFhzt(1);
		}else{
			logvo.setFhzt(0);
		}
		logvo.setFhxx(prMsgResponse.getMsg());
		logvo.setBw(prMsgResponse.getInXml());
		
		try {
			sapInterfaceLogService.save(logvo);
		} catch (Exception e) {
			new ServiceException("保存SAP返回信息日志出错");
		}
		return logvo;
	}
	
	//冻结，解冻
	@Transactional
	public void frozen(PayReceiveVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callFrozen(param);
		this.callAfter(param);
	}
	
	//调整备注信息
	@Transactional
	public void modifyBzxx(PayReceiveVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callModifyBzxx(param);
		this.callAfter(param);
	}
	
	
}