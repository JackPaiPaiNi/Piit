package com.ey.piit.sdo.order.service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.service.MimeMailService;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.interfaces.order.dao.IOrderDao;
import com.ey.piit.interfaces.order.dto.OrderBodyDto;
import com.ey.piit.interfaces.order.dto.OrderHeaderDto;
import com.ey.piit.interfaces.order.dto.OrderMsgResponse;
import com.ey.piit.interfaces.order.dto.OrderZZHeaderDto;
import com.ey.piit.interfaces.order.service.OrderInterfaceService;
import com.ey.piit.sdo.mdm.service.MaterialInfoService;
import com.ey.piit.sdo.order.entity.OrderReceiver;
import com.ey.piit.sdo.order.repository.OrderSpoDao;
import com.ey.piit.sdo.order.repository.OrderSpoItemDao;
import com.ey.piit.sdo.order.vo.OrderEmailVo;
import com.ey.piit.sdo.order.vo.OrderLogVo;
import com.ey.piit.sdo.order.vo.OrderSpoItemVo;
import com.ey.piit.sdo.order.vo.OrderSpoVo;
import com.ey.piit.sdo.payment.service.PayValidateService;
import com.ey.piit.sdo.payment.vo.PayValidateVo;
import com.ey.piit.sdo.pub.repository.EmailDao;
import com.ey.piit.sdo.pub.vo.EmailVo;
import com.ey.piit.sdo.track.repository.TrackInfoDao;

/**
 * 备损订单管理Service
 * 
 * @author 魏诚
 */
@Service
public class OrderSpoService {

	@Autowired
	private OrderSpoDao dao;
	@Autowired
	private OrderSpoItemDao orderSpoItemDao;
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
	private EmailDao emailDao;
	@Autowired
	private OrderInterfaceService iOrderService;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
	@Autowired
	private TrackInfoDao trackInfoDao;
	@Autowired
	private MaterialInfoService materialInfoService;
	@Autowired
	private MimeMailService mimeMailService;//邮件服务类
    @Value("${email.url}")
    private String url;//项目访问路径

	@SuppressWarnings("unchecked")
	public Object callQueryByPage(OrderSpoVo vo, PageBounds page) {
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
		List<OrderSpoVo> list = (List<OrderSpoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(OrderSpoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelect(param);
		List<OrderSpoVo> list = (List<OrderSpoVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public OrderSpoVo callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<OrderSpoVo> list = (List<OrderSpoVo>) param.get("list");
		List<OrderSpoItemVo> wlList = (List<OrderSpoItemVo>) param.get("wlList");
		List<OrderLogVo> logList = (List<OrderLogVo>) param.get("logList");
		OrderSpoVo vo = new OrderSpoVo() ;
		if(list.size() > 0){
			 vo = list.get(0);
			 vo.setOrderSpoItemList(wlList);
			 vo.setLogList(logList);
		}
		return vo;
	}
	
	public Object queryWlmx(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		return param.get("wlList");
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Object callQueryByDh(String ddid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ddid", ddid);
		dao.callSelectByDh(param);
		List<OrderSpoVo> list = (List<OrderSpoVo>) param.get("list");
		List<OrderSpoItemVo> wlList = (List<OrderSpoItemVo>) param.get("wlList");
		OrderSpoVo vo = list.get(0);
		vo.setOrderSpoItemList(wlList);
		return vo;
	}

	@Transactional
	public Object edit(OrderSpoVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		List<OrderSpoItemVo> list = vo.getOrderSpoItemList();
		for (int i = 0; i < list.size(); i++) {
			OrderSpoItemVo result = list.get(i);
			BigDecimal dj = result.getDj();
			BigDecimal sl = result.getSl();
			BigDecimal je = dj.multiply(sl);
			result.setJe(je);
		}
		vo.setFiles(null);
		return vo;
	}

	@Transactional
	public void submit(OrderSpoVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		dao.callSubmit(param);
		this.callAfter(param);
		/*
		 * 开启审批流程 共三条流程分不同情况走不通审批 1.收费备损 2.免费备损-业务建单 3.免费备损-客服建单
		 */
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		variables.put("xszz", vo.getXszz());
		variables.put("groupCode", vo.getYwz());// 指定销售组长的业务组
		variables.put("deptCode", vo.getXszz());//销售组织
		variables.put("xsyid", vo.getXsyid());// 指定销售员进行审批
		variables.put("id", vo.getId());// 订单ID
		variables.put("ddlx", vo.getDdlx());// 订单类型
		variables.put("jclx", "order");// 检查类型为订单
		variables.put("scjd", vo.getScjd());//流程判断条件：生产基地
		variables.put("sfBg", vo.getSfBg()==null?"0":vo.getSfBg());
		variables.put("tssapzt", vo.getTssapzt()==null?"0":vo.getTssapzt());
		variables.put("ddlb", vo.getDdlb().toString());//订单类别
		variables.put("wlje", vo.getWlje());//变更时修改物料还是金额
		variables.put("sfCh", vo.getSfCh()==null?"0":vo.getSfCh());//是否撤回
		variables.put("gsbm", vo.getGsbm());//公司编码
		if(vo.getSfBg() != null && vo.getSfBg() == 1){
			// 判断是否驳回
			if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())) {
				// 驳回提交
				processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
			} else {
				// 开启审批流程
				ProcessBean processBean = new ProcessBean();
				processBean.setBusinessId(vo.getId());
				processBean.setCode(vo.getDdid());
				processBean.setProcessKey("orderSpoModify");
				processBean.setType("备损订单变更（数量金额）");
				processBean.setUserId(vo.getZdrid());
				processBean.setVariables(variables);
				processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
				processInstanceService.startProcessInstance(processBean);
			}
		} else {
			// 判断是否驳回
			if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())) {
				// 驳回提交
				processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
			} else {
				// 开启审批流程
				ProcessBean processBean = new ProcessBean();
				processBean.setBusinessId(vo.getId());
				processBean.setCode(vo.getDdid());// 订单号
				if (vo.getSfMf() == 0) {
					if("13".equals(vo.getDdlb().toString()) ){//订单类别为备损组大客户备损
						processBean.setProcessKey("orderSpoBigCust-01");// 流程ID
						processBean.setType("收费备损订单(大客户备损)");// 业务类型
					}else{
						processBean.setProcessKey("orderSpoCharge-01");// 流程ID
						processBean.setType("收费备损订单");// 业务类型
					}
				} else if (vo.getSfMf() == 1 && "0109".equals(UserUtils.getUser().getDeptCode())) {//免费且制单人销售组织为技术服务部
					processBean.setProcessKey("orderSpoFreeCustService-01");// 流程ID
					processBean.setType("免费备损（客服）订单");// 业务类型
				} else if (vo.getSfMf() == 1 && !"0109".equals(UserUtils.getUser().getDeptCode())) {//免费且制单人销售组织不为技术服务部
					processBean.setProcessKey("orderSpoFreeBusiness-01");// 流程ID
					processBean.setType("免费备损（业务）订单");// 业务类型
				}
				processBean.setUserId(vo.getZdrid());
				processBean.setVariables(variables);
				processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
				processInstanceService.startProcessInstance(processBean);
			}
		}
	}
	
	/**
	 * 进行审核
	 * 当流程为收费备损时，岗位为备损组主管设置的id为bszzg,岗位为应收风险专员设置的id为ysfxzy
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public OrderSpoVo approve(OrderSpoVo vo) {
		this.callBefore(vo);
		// 设置流程参数
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("xszz", vo.getXszz());
		variables.put("zje", vo.getZje());
		variables.put("sfCh", vo.getSfCh()==null?"0":vo.getSfCh());//是否撤回
		variables.put("gsbm", vo.getGsbm());//公司编码
		// 获取自定义任务节点ID值，必须放在提交节点之前
		String taskKey = processTaskService.findTaskById(vo.getTaskId()).getTaskKey();
		int approveType = vo.getApproveType();
		// 若为备损组主管、SMO财务、SOS财务、MCO财务、业务副总监、技术服务副总监、工程科专员、工程技术专员则默认为最后一岗审
		//备损订单修改，根据环节判断
		if(vo.getSfBg() != null && vo.getSfBg() == 1){
			//备损专员 & 品牌业务部 & 修改金额
			//销售组织 * 修改金额
			//工程科备损专员
			if((("bszzg".equals(taskKey) && "0105".equals(vo.getXszz()) && vo.getWlje() != 1) 
			  || ("xszz".equals(taskKey) && vo.getWlje() != 1)
			  || "gckbszy".equals(taskKey)) && approveType == 1 ){
				vo.setApproveType(3);
			}
		}else{
			if (("bszzg".equals(taskKey) || "smocwsh".equals(taskKey)||"soscwsh".equals(taskKey)||"mcocwsh".equals(taskKey) || "ywfzj".equals(taskKey) || "ysfxcwzy".equals(taskKey) ||
					"jsfwfzj".equals(taskKey) || "gckzy".equals(taskKey) || "gcjszy".equals(taskKey)) && approveType == 1) {
				vo.setApproveType(3);
			}
		}
		// 若不为风险应收专员岗则调用审核存储过程
		if(!"ysfxzy".equals(taskKey)){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", vo);
			dao.callApprove(param);
			this.callAfter(param);
		}
		//完成当前审批节点
		if (approveType == 1) {
			variables.put("out", "agree");
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else if (approveType == 2) {
			variables.put("out", "reject");
			//若为风险应收专员岗则驳回时结束该流程
			if("ysfxzy".equals(taskKey)){
				processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
			}else{
				processTaskService.rejectTaskRestart(vo.getProcessId());
			}
			//processTaskService.rejectTaskRestart(vo.getProcessId());
		}
		//返回付款保障日志到前台
		if("bszzg".equals(taskKey) || "ysfxzy".equals(taskKey) || "ywfzj".equals(taskKey) || 
				"jsfwfzj".equals(taskKey) || "gckzy".equals(taskKey) || "gcjszy".equals(taskKey) || "smocwsh".equals(taskKey)||"soscwsh".equals(taskKey)||"mcocwsh".equals(taskKey)){
			List<PayValidateVo> payLogList = (List<PayValidateVo>) payValidateService.payCheckSelectLog(vo.getId());
			if(payLogList.size() > 0){
				if("付款保障检查通过！".equals(payLogList.get(0).getZy().toString())){
					vo.setResult("1");
				}else{
					vo.setResult("0");
				}
				vo.setMsg(payLogList.get(0).getZy());
			}
		}
		return vo;
	}

	@Transactional
	public void delete(String id, String sjc, int zt, String processId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		dao.callDelete(param);
		this.callAfter(param);
		if(zt == 3 && !"".equals(processId)){
			processInstanceService.deleteProcessInstance(processId);
		}
	}

	private Map<String, Object> save(OrderSpoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		this.callAfter(param);
		// 循环插入物料信息
		for (OrderSpoItemVo spoItem : vo.getOrderSpoItemList()) {
			spoItem.setDdid(vo.getDdid());
			spoItem.setBbh(vo.getBbh());
			// orderReferPi.preInsert();
			spoItem.setId(Identities.uuid());
			spoItem.setBz(vo.getBz());
			Map<String, Object> wlDtlParam = new HashMap<String, Object>();
			wlDtlParam.put("vo", spoItem);
			orderSpoItemDao.callInsert(wlDtlParam);
			// 明细数据保存后
			this.callAfter(wlDtlParam);
		}
		return param;
	}
	
	@Transactional
	public void cancel(OrderSpoVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callCancel(param);
		this.callAfter(param);
		cancelSendEmail(vo.getId());
	}
	
	@Transactional
	public void change(OrderSpoVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callChange(param);
		this.callAfter(param);
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(OrderSpoVo vo) {
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

	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, OrderSpoVo vo) {
		try {
			List<OrderSpoVo> list = (List<OrderSpoVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}

	
	// 更新订单跟踪生产订单下达状态
	public void updateDDgz(OrderSpoVo vo) {
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
	public OrderSpoVo tsSapAndWriteLog(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		OrderSpoVo vo = new OrderSpoVo();
		param.put("id", id);
		dao.callSelectById(param);
		List<OrderSpoVo> list = (List<OrderSpoVo>) param.get("list");
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
			if(logVo.getFhzt()==1||logVo.getFhzt()==3){
				// 正常推送
				sendEmail(id,1);
			}
		}else {
			this.active(vo.getId());
		}
		return vo ;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public Map<String, Object> pushSAP(OrderSpoVo vo) {
		Map<String, Object> paramHw = new HashMap<String, Object>();
		Map<String, Object> paramZz = new HashMap<String, Object>();
		paramHw.put("id", vo.getId());
		paramZz.put("id", vo.getId());
		iDao.callSelectSpoByIdHw(paramHw);
		iDao.callSelectSpoByIdZz(paramZz);
		List<OrderHeaderDto> headerRequestListHw = (List<OrderHeaderDto>) paramHw.get("list");
		List<OrderBodyDto> bodyRequestListHw = (List<OrderBodyDto>) paramHw.get("itemList");
		List<OrderZZHeaderDto> headerRequestListZz = (List<OrderZZHeaderDto>) paramZz.get("list");
		List<OrderBodyDto> bodyRequestListZz = (List<OrderBodyDto>) paramZz.get("itemList");
		OrderMsgResponse hwRespMsg = null;
		OrderMsgResponse zzRespMsg = null;
		// 调用sap接口
		try {
			//hwRespMsg = iOrderService.orderSdoToHwSap(headerRequestListHw.get(0), bodyRequestListHw);
			//0代表海外推送失败; null ：没推送过 
			if(vo.getTssapzt()==null || vo.getTssapzt()==0){
				hwRespMsg = iOrderService.orderSdoToHwSap(
						headerRequestListHw.get(0), bodyRequestListHw);
			}else{
				//海外sap已经推送成功的
				hwRespMsg=new OrderMsgResponse();
				hwRespMsg.setResult("X");
				hwRespMsg.setDh(vo.getDdid());
				hwRespMsg.setMsg("已经推送海外sap成功,不再重复推送！");
				hwRespMsg.setOutXml("已经推送海外sap成功,不再重复推送！");
			}
		} catch (Exception e) {
			throw new ServiceException("调用SAP备损订单接口失败！");
		}
		// 设置推送SAP状态
	    if(StringUtils.isEmpty(vo.getYddid())){
	    	if (hwRespMsg != null && "X".equals(hwRespMsg.getResult())) {
				updateDDgz(vo);
				// 海外sap接口调用成功 且业务处理成功后推送制造sap
				// 如果订单类别免费市场物料、收费市场物料、工装物料，不推送制造
				//是否传制造为否，则不传制造
				if ("6".equals(headerRequestListZz.get(0).getPdddlb()) || "7".equals(headerRequestListZz.get(0).getPdddlb()) 
						|| "14".equals(headerRequestListZz.get(0).getPdddlb()) || "11".equals(headerRequestListZz.get(0).getPdddlb())
						|| headerRequestListZz.get(0).getSfCzz() == 0) {
					zzRespMsg = new OrderMsgResponse();
					zzRespMsg.setMsg("订单类别为免费市场物料/收费市场物料/工装物料/供应商免费提供备损,不推送制造");
					zzRespMsg.setResult("X");
				} else{
					try {
						zzRespMsg = iOrderService.orderSdoToZzSap(headerRequestListZz.get(0), bodyRequestListZz);
					} catch (Exception e) {
						throw new ServiceException("调用制造SAP备损订单接口失败！");
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
	public SapInterfaceLogVo saveTsSapLog(OrderSpoVo vo, Map respMsg) {

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
		logvo.setMk("备损订单");
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
	private void complete(OrderSpoVo vo) {
		callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callComplete(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void active(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callActive(param);
		this.callAfter(param);
		sendEmail(id,2);
	}

	/*// 验证物料是否存在
	public void checkwl(List<OrderSpoItemVo> list) {
		String wllist = "";
		Map<String, Object> param = new HashMap<String, Object>();
		// 循环查询物料信息
		for (OrderSpoItemVo spoItem : list) {
			MaterialInfoVo vo = new MaterialInfoVo();
			vo.setWlbh(spoItem.getWlbh());
			List<MaterialInfoVo> mlist = materialInfoService.queryByParam(vo);
			if (mlist.size() <= 0) {
				wllist = wllist + ",'" + spoItem.getWlbh()+"'";
			}
		}
		if (wllist != "") {
			param.put("resultMsg", wllist + ",物料不存在！");
			param.put("resultCode", "0");
		}else{
			param.put("resultMsg",  ",导入成功!");
			param.put("resultCode", "SDO-000000");
		}
		this.callAfter(param);
	}*/
	//发送邮件
	public void sendEmail(String id,int zt){
		OrderEmailVo  orderEmailVo = (OrderEmailVo) this.callQueryEmailById(id,zt);
		Map<String,Object> map = this.emailHelper(orderEmailVo,zt);	
		List<OrderReceiver> orderList=orderEmailVo.getReceiverList();
		for(OrderReceiver or:orderList){
			try {
				mimeMailService.sendEmail(or.getSjr(), map.get("subject").toString(), map.get("content").toString());
			} catch (Exception e) {
				EmailVo emailVo = new EmailVo();
				emailVo.setYwid(id);
				emailVo.setYwdh(orderEmailVo.getDdid());
				emailVo.setYxdz(or.getSjr());
				if(zt == 1){
					emailVo.setName("备损订单");
				}else{
					emailVo.setName("备损订单变更");
				}
				emailVo.setText(e.getMessage());
				emailDao.insert(emailVo);
			}
		}
	}
	
	//取订单邮件内容
	@SuppressWarnings("unchecked")
	public Object callQueryEmailById(String id,int zt) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("lx", 3);
		param.put("zt", zt);
		dao.callSelectEmail(param);
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
	private Map<String,Object> emailHelper(OrderEmailVo orderEmailVo,int zt){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> drlist=new ArrayList<String>();//收件人列表
		//邮件标题：[提交人姓名]|出货通知书|出货通知书编码|起运港|订单号|客户名称
		StringBuffer subject = new StringBuffer();//邮件主题
		StringBuffer content = new StringBuffer();//邮件正文
		String url_tmp=url+"/base-web/order/orderSpo/viewPage?id="+orderEmailVo.getId();
		//组装收件人列表
		List<OrderReceiver> orderList=orderEmailVo.getReceiverList();
		for(OrderReceiver or:orderList){
			drlist.add(or.getSjr());
		}
		//组装邮件主题
		if(zt ==1){
			subject.append("[工作流][新任务]");
		}else{
			subject.append("[工作流][变更新任务]");	
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
		/*邮件正文：
		此邮件由系统自动发出，请勿回复。
		业务基本信息
		业务单据：备损订单
		单据编码：SA1607XXX
		提交人：XXX
		提交时间：2016-06-27 0:00:00
		点击查看详细信息：[单据类型]|[单据号]|[提交人姓名]|客户名称|型号|牌子|订单数量|修改时间
		附件：提取的相关文件[ 按照相应规则提取]*/
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
	}
	
	//取消订单发送邮件
	public void cancelSendEmail(String id){
		OrderEmailVo  orderEmailVo = (OrderEmailVo) this.callQuerySpoEmailById(id);
		Map<String,Object> map = this.spoEmailHelper(orderEmailVo);	
		List<OrderReceiver> orderList=orderEmailVo.getReceiverList();
		for(OrderReceiver or:orderList){
			try {
				mimeMailService.sendEmail(or.getSjr(), map.get("subject").toString(), map.get("content").toString());
			} catch (Exception e) {
				EmailVo emailVo = new EmailVo();
				emailVo.setYwid(id);
				emailVo.setYwdh(orderEmailVo.getDdid());
				emailVo.setYxdz(or.getSjr());
				emailVo.setName("备损订单取消");
				emailVo.setText(e.getMessage());
				emailDao.insert(emailVo);
			}
		}
	}
	
	//取订单邮件内容
	@SuppressWarnings("unchecked")
	public Object callQuerySpoEmailById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("lx", 2);
		dao.callSelectSpoEmail(param);
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
	
	//组装取消订单发送邮件的正文
	private Map<String,Object> spoEmailHelper(OrderEmailVo orderEmailVo){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> drlist=new ArrayList<String>();//收件人列表
		//邮件标题：[提交人姓名]|出货通知书|出货通知书编码|起运港|订单号|客户名称
		StringBuffer subject = new StringBuffer();//邮件主题
		StringBuffer content = new StringBuffer();//邮件正文
		String url_tmp=url+"/base-web/order/orderSpo/viewPage?id="+orderEmailVo.getId();
		//组装收件人列表
		List<OrderReceiver> orderList=orderEmailVo.getReceiverList();
		for(OrderReceiver or:orderList){
			drlist.add(or.getSjr());
		}
		//组装邮件主题
		subject.append("[备损订单取消]");
		subject.append("[");
		subject.append(orderEmailVo.getZdrmc());
		subject.append("]|");
		subject.append(orderEmailVo.getDjlx());
		subject.append("|");
		subject.append(orderEmailVo.getDdid());
		subject.append("|");
		subject.append(orderEmailVo.getKhmc());
		//组装邮件正文
		content.append("<p>");
		content.append("此邮件由系统自动发出，请勿回复。");
		content.append("</p>");
		content.append("业务基本信息<br/>");
		content.append("单据类型："+orderEmailVo.getDjlx()+"<br/>");
		content.append("单据编号："+orderEmailVo.getDdid()+"<br/>");
		content.append("申请人："+orderEmailVo.getZdrmc()+"<br/>");
		content.append("客户名称："+orderEmailVo.getKhmc()+"<br/>");
		content.append("点击查看详细信息：<a href='"+url_tmp+"'>"+subject.toString()+"</a><br/>");
		map.put("recevier", drlist);
		map.put("subject", subject.toString());
		map.put("content", content.toString());
		return map;
	}
	
	public void getback(OrderSpoVo vo){
		DeleteProcess(vo);
		back(vo);
	}
	public void DeleteProcess(OrderSpoVo vo) {
		// 1.删除流程实例
		try {
			processInstanceService.deleteProcessInstance(vo.getProcessId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional
	public void back(OrderSpoVo vo) {
		//2.根据付款保障状态判断是否需要取消付款保障
		//3.将状态置为1
		//4.写进订单的审批日志，说明取回人
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callGetback(param);
		this.callAfter(param);
	}
	
	@SuppressWarnings("unchecked")
	public void exportWlxx(HttpServletResponse response, Map<String, Object> params, OrderSpoItemVo vo) {
		try {
			List<OrderSpoItemVo> list = (List<OrderSpoItemVo>) this.queryWlmx(vo.getId());
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	@SuppressWarnings("unchecked")
	public OrderLogVo callQueryDqclrById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectDqclrById(param);
		List<OrderLogVo> logList = (List<OrderLogVo>) param.get("logList");
		OrderLogVo vo = new OrderLogVo() ;
		if(logList.size() > 0){
			 vo = logList.get(0);
		}
		return vo;
	}
}