package com.ey.piit.sdo.order.service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.basebpm.entity.ProcessBean;
import com.ey.piit.basebpm.service.ProcessInstanceService;
import com.ey.piit.basebpm.service.ProcessTaskService;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.service.MimeMailService;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.interfaces.order.dao.IOrderDao;
import com.ey.piit.interfaces.order.dto.OrderBodyDto;
import com.ey.piit.interfaces.order.dto.OrderHeaderDto;
import com.ey.piit.interfaces.order.dto.OrderMsgResponse;
import com.ey.piit.interfaces.order.dto.OrderZZHeaderDto;
import com.ey.piit.interfaces.order.service.OrderInterfaceService;
import com.ey.piit.sdo.order.repository.OrderFyDao;
import com.ey.piit.sdo.order.repository.OrderFyItemDao;
import com.ey.piit.sdo.order.vo.OrderFyItemVo;
import com.ey.piit.sdo.order.vo.OrderFyVo;
import com.ey.piit.sdo.order.vo.OrderLogVo;
import com.ey.piit.sdo.payment.service.PayValidateService;
import com.ey.piit.sdo.payment.vo.PayValidateVo;
import com.ey.piit.sdo.track.repository.TrackInfoDao;

/**
 * 副营订单管理Service
 * 
 * @author tianrong
 */
@Service
public class OrderFyService {

	@Autowired
	private OrderFyItemDao orderFyItemDao;
	@Autowired
	private OrderFyDao orderFyDao;
	@Autowired
	private ExportUtil exportUtil;
	@Autowired
	private ProcessInstanceService processInstanceService;
	@Autowired
	private ProcessTaskService processTaskService;
	@Autowired
	private PayValidateService payValidateService;
	@Autowired
	private IOrderDao iDao;
	@Autowired
	private OrderInterfaceService iOrderService;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
	@Autowired
	private TrackInfoDao trackInfoDao;
	@Autowired
	private MimeMailService mimeMailService;//邮件服务类
    @Value("${email.url}")
    private String url;//项目访问路径
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(OrderFyVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		orderFyDao.callSelect(param);
		List<OrderFyVo> list = (List<OrderFyVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		orderFyDao.callSelectById(param);
		List<OrderFyVo> list = (List<OrderFyVo>) param.get("list");
		List<OrderFyItemVo> cpList = (List<OrderFyItemVo>) param.get("cpList");
		List<OrderLogVo> logList = (List<OrderLogVo>) param.get("logList");
		OrderFyVo vo = new OrderFyVo() ;
		if(list.size()>0){
		    vo = list.get(0);
			vo.setOrderFyItemList(cpList);
			vo.setLogList(logList);
		}
		return vo;
	}

	@SuppressWarnings("unchecked")
	public Object callQueryByDh(String ddid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ddid", ddid);
		orderFyDao.callSelectByDh(param);
		List<OrderFyVo> list = (List<OrderFyVo>) param.get("list");
		List<OrderFyItemVo> cpList = (List<OrderFyItemVo>) param.get("cpList");
		OrderFyVo vo = list.get(0);
		vo.setOrderFyItemList(cpList);
		return vo;
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(OrderFyVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		orderFyDao.callSelect(param);
		List<OrderFyVo> list = (List<OrderFyVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, OrderFyVo vo) {
		try {
			List<OrderFyVo> list = (List<OrderFyVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}

	}

	@Transactional
	public Object edit(OrderFyVo vo) {
		this.callBefore(vo);
		this.save(vo);
		return vo;
	}

	@Transactional
	public void submit(OrderFyVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		orderFyDao.callSubmit(param);
		this.callAfter(param);
		
		Map<String, Object> variables = new HashMap<String, Object>();
		// 开启审批流程
		variables.put("groupCode", vo.getYwz());// 指定销售组长的业务组
		variables.put("deptCode", vo.getXszz());//销售组织
		variables.put("xszz", vo.getXszz());//销售组织
		variables.put("out", "commit");
		variables.put("xsyid", vo.getXsyid());// 指定销售员进行审批
		variables.put("id", vo.getId());// 订单ID
		variables.put("ddlx", vo.getDdlx());// 订单类型
		variables.put("jclx", "order");// 检查类型为订单
		variables.put("sfBg", vo.getSfBg()==null?"0":vo.getSfBg());
		variables.put("tssapzt", vo.getTssapzt()==null?"0":vo.getTssapzt());
		variables.put("sfCh", vo.getSfCh()==null?"0":vo.getSfCh());//是否撤回
		variables.put("gsbm", vo.getGsbm());//公司编码；
		
		// 判断是否驳回
		if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())) {
			// 驳回提交
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getDdid());// 订单号
			if ("7".equals(vo.getDdlb())) {
				processBean.setProcessKey("orderFyWcCreate");// 流程ID
				processBean.setType("副营订单(外采)");// 流程类型
			}else if ("8".equals(vo.getDdlb())) {
				processBean.setProcessKey("orderFyGzCreate");// 流程ID
				processBean.setType("副营订单(工装)");// 流程类型
			}else if ("9".equals(vo.getDdlb())) {
				processBean.setProcessKey("orderFyXtCreate");// 流程ID
				processBean.setType("副营订单(线体)");// 流程类型
			}else if ("10".equals(vo.getDdlb())) {
				processBean.setProcessKey("orderFyMjCreate");// 流程ID
				processBean.setType("副营订单(模具)");// 流程类型
			}
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
			processInstanceService.startProcessInstance(processBean);
		}
	}

	/**
	 * 进行审核 流程中岗位为供应链管理部审核（外采）设置的id为gylglbzy,岗位为计划组设置的id为dhgylzczy
	 * 
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public OrderFyVo approve(OrderFyVo vo) {
		String tssapMsg = "";
		this.callBefore(vo);
		// 设置流程参数
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("sfmf", vo.getSfMf());
		variables.put("sfCh", vo.getSfCh()==null?"0":vo.getSfCh());//是否撤回
		// 获取自定义任务节点ID值，必须放在提交节点之前
		String taskKey = processTaskService.findTaskById(vo.getTaskId()).getTaskKey();
		int approveType = vo.getApproveType();
		int sfSMOgsbm = 0;//公司是否是SMO/SOS/MCO
		if("SMO".equals(vo.getGsbm()) || "SOS".equals(vo.getGsbm()) || "MCO".equals(vo.getGsbm())){
			sfSMOgsbm = 1;
		}
		// 完成当前节点审批
		if(approveType == 1){
			variables.put("out", "agree");
			//外采：若为财务审核则不调用审批过程（供应链支持同意后，直接在付款保障监听里进行终审）
			//工装、线体、模具：若为财务审核则不调用审批过程（供应链支持同意后，直接在付款保障监听里进行终审）
			if("7".equals(vo.getDdlb())){
				//供应链管理部 & 公司=SMO/SOS/MCO
				//非SMO/SOS/MCO /财务审核岗 4个审核岗
				//免费订单在付款保障中检查，检查后会调用审核过程
				if(!("gylglbzy".equals(taskKey) && sfSMOgsbm == 0) && !"ysfxzy".equals(taskKey) && !"smocwsh".equals(taskKey) && !"soscwsh".equals(taskKey) && !"mcocwsh".equals(taskKey)){
					this.doApprove(vo);
				}
			}else{
				if(!"dhgylzczy".equals(taskKey)){
					this.doApprove(vo);
				}
			}
			try {
				processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
			} catch (Exception e) {
				tssapMsg = e.getMessage();
				vo.setMsg(tssapMsg);
			}
		}else if(approveType == 2){
			variables.put("out", "reject");
			this.doApprove(vo);
			try {
				processTaskService.rejectTaskRestart(vo.getProcessId());
			} catch (Exception e) {
				tssapMsg = e.getMessage();
				vo.setMsg(tssapMsg);
			}
		}
		
		//返回付款保障日志到前台
		if (("dhgylzczy".equals(taskKey) || "ysfxzy".equals(taskKey)) && approveType != 2) {
			List<PayValidateVo> payLogList = (List<PayValidateVo>) payValidateService.payCheckSelectLog(vo.getId());
			if(payLogList.size() > 0){
				if("付款保障检查通过！".equals(payLogList.get(0).getZy().toString())){
					vo.setResult("1");
				}else{
					vo.setResult("0");
				}
				vo.setMsg(payLogList.get(0).getZy()+" "+ tssapMsg);
			}else {
				vo.setMsg(tssapMsg);
			}
		}
		return vo;
	}
	
	public Map<String, Object> save(OrderFyVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		// 数据保存前
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
		this.callBefore(vo);
		param.put("vo", vo);
		orderFyDao.callInsert(param);
		this.callAfter(param);
		// 循环插入产品信息
		for (OrderFyItemVo orderFyItem : vo.getOrderFyItemList()) {
			orderFyItem.setDdid(vo.getDdid());
			orderFyItem.setBbh(vo.getBbh());
			orderFyItem.preInsert();
			Map<String, Object> cpDtlParam = new HashMap<String, Object>();
			cpDtlParam.put("vo", orderFyItem);
			orderFyItemDao.callInsert(cpDtlParam);
			// 明细数据保存后
			this.callAfter(cpDtlParam);
		}
		return param;
	}

	@Transactional
	public void delete(String id, String sjc, int zt, String processId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		orderFyDao.callDelete(param);
		this.callAfter(param);
		if (zt == 3 && !"".equals(processId)) {
			processInstanceService.deleteProcessInstance(processId);
		}
	}
	
	@Transactional
	public void cancel(OrderFyVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		orderFyDao.callCancel(param);
		this.callAfter(param);
		//取消需要走审批流1取消 2撤回
		if(vo.getType() == 1){
			// 审批流处理
			vo = (OrderFyVo) this.callQueryById(vo.getId());
			Map<String, Object> variables = new HashMap<String, Object>();
			// 开启审批流程
			variables.put("out", "commit");
			variables.put("groupCode", vo.getYwz());// 指定销售组长的业务组
			variables.put("deptCode", vo.getXszz());//销售组织
			variables.put("xszz", vo.getXszz());//销售组织
			variables.put("xsyid", vo.getXsyid());// 指定销售员进行审批
			variables.put("gsbm", vo.getGsbm());//公司编码；
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getDdid());
			if ("7".equals(vo.getDdlb())) {
				processBean.setProcessKey("orderFyWcCancel");// 流程ID
				processBean.setType("副营订单(外采)-取消");// 流程类型
			}else if ("8".equals(vo.getDdlb())) {
				processBean.setProcessKey("orderFyGzCancel");// 流程ID
				processBean.setType("副营订单(工装)-取消");// 流程类型
			}else if ("9".equals(vo.getDdlb())) {
				processBean.setProcessKey("orderFyXtCancel");// 流程ID
				processBean.setType("副营订单(线体)-取消");// 流程类型
			}else if ("10".equals(vo.getDdlb())) {
				processBean.setProcessKey("orderFyMjCancel");// 流程ID
				processBean.setType("副营订单(模具)-取消");// 流程类型
			}
			processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			// 开启审批流程
			processInstanceService.startProcessInstance(processBean);
		}
	}
	
	@Transactional
	public void cancelApprove(OrderFyVo vo){
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		// 完成当前节点审批
		Map<String, Object> variables = new HashMap<String, Object>();
		if(vo.getApproveType() == 1){
			variables.put("out", "agree");
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		}
		
		// 判断是不是终审
		boolean isEnd = processInstanceService.isProcessEnd(vo.getProcessId());
		if(isEnd && vo.getApproveType()==1){
			vo.setApproveType(3);
		}
		
		// 调用审批存储过程
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		orderFyDao.callCancelApprove(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void change(OrderFyVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		orderFyDao.callChange(param);
		this.callAfter(param);
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(OrderFyVo vo) {
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
	 * 
	 * @param param
	 */
	public void callAfter(Map<String, Object> param) {
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}

	// 更新订单跟踪生产订单下达状态
	public void updateDDgz(OrderFyVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ddid", vo.getDdid());
		param.put("jdmc", "生产订单下达");
		param.put("jdzt", "已完成");
		param.put("wcsj", new Date());
		trackInfoDao.updateDdgzzt(param);
		callAfter(param);
	}

	

	// 推送SAP并且记录返信息货日志
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public OrderFyVo tsSapAndWriteLog(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		OrderFyVo vo = new OrderFyVo();
		param.put("id", id);
		orderFyDao.callSelectById(param);
		List<OrderFyVo> list = (List<OrderFyVo>) param.get("list");
		if(list.size() > 0){
			vo = list.get(0);
		}else {
			throw new ServiceException("系统推送SAP时未找到订单信息！");
		}
		//是否变更
		Integer sfBg = vo.getSfBg()==null?0:vo.getSfBg();
		//是否撤回
		Integer sfCh = vo.getSfCh()==null?0:vo.getSfCh();
		//撤回和变更的单据，不推送SAP,直接生效
		if(sfBg != 1 && sfCh != 1){
			// 执行推送
			Map resp = pushSAP(vo);
			// 更改单据推送状态
			this.complete(vo);
			// 保存推送返回信息日志
			SapInterfaceLogVo logVo = saveTsSapLog(vo, resp);
			vo.setMsg(logVo.getFhxx());
		}else {
			this.active(vo.getId());
		}
		return vo;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	private Map<String, Object> pushSAP(OrderFyVo vo) {
		Map<String, Object> paramHw = new HashMap<String, Object>();
		Map<String, Object> paramZz = new HashMap<String, Object>();
		paramHw.put("id", vo.getId());
		paramZz.put("id", vo.getId());
		iDao.callSelectFyByIdHw(paramHw);
		iDao.callSelectFyByIdZz(paramZz);
		List<OrderHeaderDto> headerRequestListHw = (List<OrderHeaderDto>) paramHw.get("list");
		List<OrderBodyDto> bodyRequestListHw = (List<OrderBodyDto>) paramHw.get("itemList");
		List<OrderZZHeaderDto> headerRequestListZz = (List<OrderZZHeaderDto>) paramZz.get("list");
		List<OrderBodyDto> bodyRequestListZz = (List<OrderBodyDto>) paramZz.get("itemList");
		OrderMsgResponse hwRespMsg = null;
		OrderMsgResponse zzRespMsg = null;
		// 调用sap接口
		try {
			//0代表海外推送失败; -1 ：没推送过 
			if(vo.getTssapzt()==null || vo.getTssapzt()==0){
				hwRespMsg = iOrderService.orderSdoToHwSap(headerRequestListHw.get(0), bodyRequestListHw);
			}else{
				//海外sap已经推送成功的
				hwRespMsg=new OrderMsgResponse();
				hwRespMsg.setResult("X");
				hwRespMsg.setDh(vo.getDdid());
				hwRespMsg.setMsg("已经推送海外sap成功,不再重复推送！");
				hwRespMsg.setOutXml("已经推送海外sap成功,不再重复推送！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("调用海外SAP副营订单接口失败！");
		}
		if(StringUtils.isEmpty(vo.getYddid())){
			 if (hwRespMsg != null && "X".equals(hwRespMsg.getResult())) {
				 this.updateDDgz(vo);
				// 海外sap接口调用成功 且业务处理成功后推送制造sap
				if ("7".equals(headerRequestListZz.get(0).getPdddlb()) || "9".equals(headerRequestListZz.get(0).getPdddlb()) || "10".equals(headerRequestListZz.get(0).getPdddlb())) {
					zzRespMsg = new OrderMsgResponse();
					zzRespMsg.setMsg("外采/线体/模具订单,不推送制造");
					zzRespMsg.setResult("X");
				} else {
					try {
						zzRespMsg = iOrderService.orderSdoToZzSap(headerRequestListZz.get(0), bodyRequestListZz);
					} catch (Exception e) {
						throw new ServiceException("调用制造SAP副营订单接口失败！");
					}
				}
				if (zzRespMsg != null && "X".equals(zzRespMsg.getResult())) {
					vo.setTssapzt(1);// 海外sap成功 制造sap成功
				} else {
					vo.setTssapzt(2);// 海外sap成功 制造sap失败
				}
			} else {
				vo.setTssapzt(0);// 海外sap失败 制造sap未推送
			}
		 }else{
		  	//海外SAP成功,制造SAP不需要推
	       	if("X".equals(hwRespMsg.getResult())){
	       		vo.setTssapzt(3);// 海外sap成功 制造sap不需推
	       	}else{
	       		vo.setTssapzt(0);// 海外sap失败 制造sap未推送
	       	}
		 }
		Map map = new HashMap();
		map.put("hwRespMsg", hwRespMsg);
		map.put("zzRespMsg", zzRespMsg);
		return map;
	}

	// 保存推送制造SAP和海外SAP反馈细信息日志
	@SuppressWarnings("rawtypes")
	private SapInterfaceLogVo saveTsSapLog(OrderFyVo vo, Map respMsg) {
		if (respMsg == null) {
			throw new ServiceException("推送sap返回信息为空");
		}
		OrderMsgResponse hwRespMsg = (OrderMsgResponse) respMsg.get("hwRespMsg");
		OrderMsgResponse zzRespMsg = (OrderMsgResponse) respMsg.get("zzRespMsg");
		if(zzRespMsg!=null){
			hwRespMsg.setMsg("海外："+hwRespMsg.getMsg()+",制造:"+zzRespMsg.getMsg());
		}else{
			hwRespMsg.setMsg("海外："+hwRespMsg.getMsg()+",制造:未推送！");
		}	
		if (vo == null) {
			throw new ServiceException("推送sap的vo为空");
		}
		// 保存推送日志
		SapInterfaceLogVo logvo = new SapInterfaceLogVo();
		logvo.setId(vo.getId());
		logvo.setDh(vo.getDdid());
		logvo.setMk("副营订单");
		logvo.setSj(new Date());
		logvo.setFhzt(vo.getTssapzt());
		logvo.setFhxx(hwRespMsg.getMsg());
		if(zzRespMsg!=null){
			logvo.setBw("推送海外SAP报文：【"+hwRespMsg.getInXml()+"】推送制造SAP报文：【"+zzRespMsg.getInXml()+"】");
		}else{
			logvo.setBw("推送海外SAP报文：【"+hwRespMsg.getInXml()+"】推送制造SAP报文：【】");
		}
		try {
			sapInterfaceLogService.save(logvo);
		} catch (Exception e) {
			new ServiceException("保存SAP返回信息日志出错");
		}
		
		return logvo ;

	}
    
	@Transactional
	private void complete(OrderFyVo vo) {
		callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		orderFyDao.callComplete(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void active(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		orderFyDao.callActive(param);
		this.callAfter(param);
	}
	/*//发送邮件
	@SuppressWarnings("unchecked")
	public void sendEmail(String id){
		OrderEmailVo  deliverEmailVo = (OrderEmailVo) this.callQueryEmailById(id);
		Map<String,Object> map = this.emailHelper(deliverEmailVo);	
		try {
			mimeMailService.sendEmail((List<String>)map.get("recevier"), map.get("subject").toString(), map.get("content").toString());
		} catch (Exception e) {
			throw new ServiceException("订单邮件发送失败！",e);
		}
	}
	
	//取订单邮件内容
	@SuppressWarnings("unchecked")
	public Object callQueryEmailById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("lx", 5);
		orderFyDao.callSelectEmail(param);
		List<OrderReceiver> recevierList=new ArrayList<OrderReceiver>();
		recevierList = (List<OrderReceiver>) param.get("recevierList");
		List<OrderEmailVo> list = (List<OrderEmailVo>) param.get("list");
		OrderEmailVo orderEmailVo=new OrderEmailVo();
		if(list.size()>0){
			orderEmailVo=list.get(0);
			orderEmailVo.setReceiverList(recevierList);
		}	
		return orderEmailVo;
	}
	//组装发送邮件的正文
	private Map<String,Object> emailHelper(OrderEmailVo orderEmailVo){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> drlist=new ArrayList<String>();//收件人列表
		//邮件标题：[提交人姓名]|出货通知书|出货通知书编码|起运港|订单号|客户名称
		StringBuffer subject = new StringBuffer();//邮件主题
		StringBuffer content = new StringBuffer();//邮件正文
		String url_tmp=url+"/base-web/order/orderFy/viewPage?id="+orderEmailVo.getId();
		//组装收件人列表
		List<OrderReceiver> orderList=orderEmailVo.getReceiverList();
		for(OrderReceiver or:orderList){
			drlist.add(or.getSjr());
		}
		//组装邮件主题
		subject.append("[");
		subject.append(orderEmailVo.getZdrmc());
		subject.append("]|");
		subject.append(orderEmailVo.getDjlx());
		subject.append("|");
		subject.append(orderEmailVo.getDdid());
		subject.append("|");
		subject.append(orderEmailVo.getKhmc());
		//组装邮件正文
		邮件正文：
		此邮件由系统自动发出，请勿回复。
		业务基本信息
		业务单据：副营订单
		单据编码：SA1607XXX
		提交人：XXX
		提交时间：2016-06-27 0:00:00
		点击查看详细信息：[单据类型]|[单据号]|[提交人姓名]|客户名称|型号|牌子|订单数量|修改时间
		附件：提取的相关文件[ 按照相应规则提取]
		content.append("<p>");
		content.append("此邮件由系统自动发出，请勿回复。");
		content.append("</p>");
		content.append("业务基本信息<br/>");
		content.append("单据类型："+orderEmailVo.getDjlx()+"<br/>");
		content.append("单据编号："+orderEmailVo.getDdid()+"<br/>");
		content.append("申请人："+orderEmailVo.getZdrmc()+"<br/>");
		content.append("客户名称："+orderEmailVo.getKhmc()+"<br/>");
		content.append("型号："+orderEmailVo.getWsxh()+"<br/>");
		content.append("牌子："+orderEmailVo.getPp()+"<br/>");
		content.append("订单数量："+orderEmailVo.getSl()+"<br/>");
		content.append("修改时间："+orderEmailVo.getZdsj()+"<br/>");
		content.append("点击查看详细信息：<a href='"+url_tmp+"'>"+subject.toString()+"</a><br/>");
		map.put("recevier", drlist);
		map.put("subject", subject.toString());
		map.put("content", content.toString());
		return map;
	}*/
	
	public void getback(OrderFyVo vo){
		DeleteProcess(vo);
		back(vo);
	}
	public void DeleteProcess(OrderFyVo vo) {
		// 1.删除流程实例
		try {
			processInstanceService.deleteProcessInstance(vo.getProcessId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional
	public void back(OrderFyVo vo) {
		//2.根据付款保障状态判断是否需要取消付款保障
		//3.将状态置为1
		//4.写进订单的审批日志，说明取回人
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		orderFyDao.callGetback(param);
		this.callAfter(param);
	}
	
	/**
	 * 调用订单审核过程
	 * @param vo
	 */
	@Transactional
	public void doApprove(OrderFyVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		orderFyDao.callApprove(param);
		this.callAfter(param);
	}
	
	/**
	 * 为防止终审时，监听调用approve方法，产生事务嵌套
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public OrderFyVo listenerApprove(OrderFyVo vo) throws Exception{
		OrderFyVo votemp = (OrderFyVo) this.callQueryById(vo.getId());
		vo.setSjc(votemp.getSjc());
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		User user = UserUtils.getUser();
		votemp.setZdrid(user.getLoginAcct());
		votemp.setZdrmc(user.getUserName());
		if (vo.getApproveType() == 3) {
			votemp.setApproveType(3);
		}else{
			votemp.setApproveType(1);
		}
		param.put("vo", votemp);
		orderFyDao.callApprove(param);
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new Exception(param.get("resultMsg").toString());
		}
		return vo;
	}
}