package com.ey.piit.sdo.sapspecial.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.basebpm.entity.ProcessBean;
import com.ey.piit.basebpm.service.ProcessInstanceService;
import com.ey.piit.basebpm.service.ProcessTaskService;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.approve.dao.IApproveDao;
import com.ey.piit.interfaces.approve.dto.ApproveBodyDto;
import com.ey.piit.interfaces.approve.dto.ApproveMsgResponse;
import com.ey.piit.interfaces.approve.service.ApproveInterfaceService;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.sdo.sapspecial.repository.SapSpecialOrderDao;
import com.ey.piit.sdo.sapspecial.vo.SapApproveLogVo;
import com.ey.piit.sdo.sapspecial.vo.SapSpecialItemVo;
import com.ey.piit.sdo.sapspecial.vo.SapSpecialOrderVo;


/**
 * sap特价审批管理Service
 * 
 * @author 赵桃军
 */
@Service
@Transactional(readOnly = true)
public class SapSpecialOrderService {

	@Autowired
	private SapSpecialOrderDao dao;
	@Autowired
	private ProcessTaskService processTaskService;
	@Autowired
	private ProcessInstanceService processInstanceService;
	@Autowired
	private IApproveDao iDao;
	@Autowired
	private ApproveInterfaceService iApproveService;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;

	@SuppressWarnings("unchecked")
	public PageList<Object> callQueryByPage(SapSpecialOrderVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<SapSpecialOrderVo> list = (List<SapSpecialOrderVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		SapSpecialOrderVo vo = new SapSpecialOrderVo();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<SapSpecialOrderVo> list = (List<SapSpecialOrderVo>) param.get("list");
		List<SapSpecialItemVo> itemlist = (List<SapSpecialItemVo>) param.get("itemList");
		List<SapApproveLogVo> logList = (List<SapApproveLogVo>) param.get("logList");
		if (list.size() > 0) {
			vo = list.get(0);
			vo.setLogList(logList);
			vo.setItemList(itemlist);
		}

		return vo;
	}

	// 提交
	public void callSubmit(SapSpecialOrderVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		callBefore(vo);
		param.put("vo", vo);
		dao.callSubmit(param);
		callAfter(param);
		// 开启审批流
		openProcess(vo);
	}

	// 提交全部
	@Transactional
	public void callSubmitList(List<SapSpecialOrderVo> list) {
		for (SapSpecialOrderVo sapSpecialOrderVo : list) {
			callSubmit(sapSpecialOrderVo);
		}
	}

	// 开启审批流
	public void openProcess(SapSpecialOrderVo vo) {
		// 审批流处理开始
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		variables.put("deptCode",vo.getDept());//sdo销售组织 
		variables.put("spcl", vo.getSpcl());     //审批策略
		// 如果是已经提交的单据处理
		if (!StringUtils.isEmpty(vo.getTaskId()) &&  !"null".equals(vo.getTaskId()) && !"".equals(vo.getTaskId())) {
			throw  new ServiceException("已经提交过的单据不能重复提交");
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getXsdd());
			processBean.setProcessKey("sap_flow_special_order");
			processBean.setType("SAP特价申请单");// 流程类型
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processInstanceService.startProcessInstance(processBean);
		}
	}

	// 审批
	public Object approve(SapSpecialOrderVo vo) {
		//1审批单据
		approveDj(vo);
		//2推送SAP
		if(vo.getApproveType() == 4){
			tsSapAndWriteLog(vo);
		}
		return vo;
	}

	//审批
	@Transactional
	public Object approveDj(SapSpecialOrderVo vo){
		this.callBefore(vo);
		// 完成当前节点审批
		Map<String, Object> variables = new HashMap<String, Object>();
		if (vo.getApproveType() == 1) {
			variables.put("out", "agree");
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else if (vo.getApproveType() == 2) {
			processTaskService.jumpTask(vo.getTaskId(),"end");
		}
		// 判断是不是终审
		boolean isEnd = processInstanceService.isProcessEnd(vo.getProcessId());
		if (isEnd && vo.getApproveType() == 1) {
			vo.setApproveType(3);
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callApprove(param);
		this.callAfter(param);
		return vo;
	}
	// 推送SAP并且记录返信息货日志
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public void tsSapAndWriteLog(SapSpecialOrderVo vo) {
		// 执行推送
		List respList = pushSAP(vo);
		// 更改主表推送状态
		complete(vo);
		// 保存推送返回信息日志
		saveTsSapLog(vo, respList);
	}
		
	@Transactional
	public List<ApproveMsgResponse> pushSAP(SapSpecialOrderVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		param.put("djlx", 4);
		iDao.callSelectById(param);
		@SuppressWarnings("unchecked")
		List<ApproveBodyDto> requestList = (List<ApproveBodyDto>) param.get("list");
		List<ApproveMsgResponse> responseList = null;
		// 调用sap接口
		try {
			responseList = iApproveService.approveSdoToSap(requestList);
		} catch (Exception e) {
			throw new ServiceException("调用SAP审批流(特价订单)接口失败！");
		}
		boolean flag = true;
		// 回写特价订单推送SAP状态
		for (ApproveMsgResponse apmr : responseList) {
			if("X".equals(apmr.getResult())) {
				flag = false;
				break;
			}
		}
		if(flag){ 
			vo.setTssapzt(1);
		} else {
			vo.setTssapzt(0);
		}
		return responseList;
	}
	
	private void complete(SapSpecialOrderVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callComplete(param);
		this.callAfter(param);
	}
	
	// 保存推送SAP日志
	public void saveTsSapLog(SapSpecialOrderVo vo, List<ApproveMsgResponse> list) {
		if (vo == null) {
			throw new ServiceException("推送sap的vo为空");
		}
		if (list == null || list.size() == 0 ) {
			throw new ServiceException("推送sap返回信息为空");
		}
		// 保存推送日志
		SapInterfaceLogVo logvo = new SapInterfaceLogVo();
		logvo.setId(vo.getId());
		logvo.setDh(vo.getXsdd());
		logvo.setMk("SAP审批流(特价订单)");
		logvo.setSj(new Date());
		logvo.setFhzt(vo.getTssapzt());
		logvo.setFhxx(list.get(0).getMsg());
		//logvo.setBw(list.get(0).getInXml());
		try {
			sapInterfaceLogService.save(logvo);
		} catch (Exception e) {
			new ServiceException("保存SAP返回信息日志出错");
		}
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(SapSpecialOrderVo vo) {
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
	}

	/**
	 * 调用存储过程后判断操作是否成功
	 * 
	 * @param param
	 */
	public void callAfter(Map<String, Object> param) {
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}
}