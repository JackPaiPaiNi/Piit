package com.ey.piit.sdo.order.service;

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
import com.ey.piit.sdo.order.entity.OrderReceiver;
import com.ey.piit.sdo.order.repository.OrderReferPiDao;
import com.ey.piit.sdo.order.repository.OrderSampleDao;
import com.ey.piit.sdo.order.vo.OrderBgmxVo;
import com.ey.piit.sdo.order.vo.OrderEmailVo;
import com.ey.piit.sdo.order.vo.OrderLogVo;
import com.ey.piit.sdo.order.vo.OrderReferPiVo;
import com.ey.piit.sdo.order.vo.OrderSampleVo;
import com.ey.piit.sdo.payment.service.PayValidateService;
import com.ey.piit.sdo.payment.vo.PayValidateVo;
import com.ey.piit.sdo.track.repository.TrackInfoDao;

/**
 * 样机订单管理Service
 * 
 * @author 高文浩
 */
@Service
public class OrderSampleService {

	@Autowired
	private OrderSampleDao dao;
	@Autowired
	private OrderReferPiDao orderReferPiDao;
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
	public Object callQueryByPage(OrderSampleVo vo, PageBounds page) {
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
		List<OrderSampleVo> list = (List<OrderSampleVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(OrderSampleVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelect(param);
		List<OrderSampleVo> list = (List<OrderSampleVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<OrderSampleVo> list = (List<OrderSampleVo>) param.get("list");
		List<OrderReferPiVo> piList = (List<OrderReferPiVo>) param.get("piList");
		List<OrderLogVo> logList = (List<OrderLogVo>) param.get("logList");
		List<OrderBgmxVo> bgmxList = (List<OrderBgmxVo>) param.get("bgmxList");
		OrderSampleVo vo = new  OrderSampleVo() ;
		if(list.size() >0){
			vo = list.get(0);
			vo.setOrderReferPiList(piList);
			vo.setLogList(logList);
			vo.setBgmxList(bgmxList);
		}
		return vo;
	}

	@SuppressWarnings("unchecked")
	public Object callQueryByDh(String ddid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ddid", ddid);
		dao.callSelectByDh(param);
		List<OrderSampleVo> list = (List<OrderSampleVo>) param.get("list");
		List<OrderReferPiVo> piList = (List<OrderReferPiVo>) param.get("piList");
		OrderSampleVo vo = list.get(0);
		vo.setOrderReferPiList(piList);
		return vo;
	}

	@Transactional
	public Object edit(OrderSampleVo vo) {
		this.callBefore(vo);
		this.save(vo);
		return vo;
	}

	@Transactional
	public void submit(OrderSampleVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		dao.callSubmit(param);
		this.callAfter(param);
		// 审批流处理开始
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		// variables.put("gsbm", vo.getGsbm());
		variables.put("groupCode", vo.getYwz());// 指定销售组长的业务组
		variables.put("deptCode", vo.getXszz());//销售组织
		variables.put("xsyid", vo.getXsyid());// 指定销售员进行审批
		variables.put("xszz", vo.getXszz());
		variables.put("sfmf", vo.getSfMf());
		variables.put("id", vo.getId());// 订单ID
		variables.put("ddlx", vo.getDdlx());// 订单类型
		variables.put("jclx", "order");// 检查类型为订单
		variables.put("sfwx", vo.getSfWx());//是否外协
		variables.put("sfBg", vo.getSfBg()==null?"0":vo.getSfBg());
		variables.put("tssapzt", vo.getTssapzt()==null?"0":vo.getTssapzt());
		variables.put("slje", vo.getSlje());//变更时修改数量还是金额
		variables.put("sfCh", vo.getSfCh()==null?"0":vo.getSfCh());//是否撤回
		variables.put("yjlx", vo.getYjlx().toString());//样机类型
		//认证、展会订单，直接是海外产品经理，客户、验货订单 根据是否外协判断
		/*if("3".equals(vo.getYjlx()) || "4".equals(vo.getYjlx())){
			variables.put("hwcpjl", vo.getLccpjl());
		}else{
			if(vo.getSfWx() == 0){
				variables.put("hwcpjl", vo.getLccpjl());
			}else if(vo.getSfWx() == 1){
				variables.put("cpjl", vo.getLccpjl());
			}
		}*/
		//认证、展会样机，直接是海外产品经理，客户样机根据是否外协判断
		if("1".equals(vo.getYjlx()) || "6".equals(vo.getYjlx()) || "8".equals(vo.getYjlx())){//分公司客户样机或者老产品样机
			variables.put("khyjlx", "0");
			if(vo.getSfWx() == 0){
				variables.put("hwcpjl", vo.getLccpjl());
			}else if(vo.getSfWx() == 1){
				variables.put("cpjl", vo.getLccpjl());
			}
		}else if("3".equals(vo.getYjlx())){//OEM客户样机
			variables.put("khyjlx", "1");
			if(vo.getSfWx() == 0){
				variables.put("hwcpjl", vo.getLccpjl());
			}else if(vo.getSfWx() == 1){
				variables.put("cpjl", vo.getLccpjl());
			}
		}else if("5".equals(vo.getYjlx())){//常规认证样机
			variables.put("rzlx", "0");
			variables.put("hwcpjl", vo.getLccpjl());
		}else if("2".equals(vo.getYjlx()) || "7".equals(vo.getYjlx())){//专利认证样机或工程样机
			variables.put("rzlx", "1");
			variables.put("hwcpjl", vo.getLccpjl());
		}else if("4".equals(vo.getYjlx())){ //展会样机
			variables.put("hwcpjl", vo.getLccpjl());
		}
		//若为海外产品部必须选海外产品经理
		if("020202".equals(vo.getYwz())){ 
			variables.put("hwcpjl", vo.getLccpjl());
		}
		
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
				processBean.setProcessKey("orderSampleModify_jexx");
				processBean.setType("样机订单变更（数量金额）");
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
				if (("1".equals(vo.getYjlx()) || "3".equals(vo.getYjlx()) || "6".equals(vo.getYjlx()) || "8".equals(vo.getYjlx())) 
						&& !"020202".equals(vo.getYwz())) {//分公司客户样机、OEM客户样机、老产品样机，且业务组不为海外产品组
					processBean.setProcessKey("orderSampleCust");// 流程ID
					processBean.setType("样机（客户）订单");// 流程类型
				} else if (("2".equals(vo.getYjlx()) || "5".equals(vo.getYjlx()) || "7".equals(vo.getYjlx()))
						&& !"020202".equals(vo.getYwz())) {//专利认证样机、常规认证样机，且业务组不为海外产品组
					processBean.setProcessKey("orderSampleAuth-01");// 流程ID
					processBean.setType("样机（认证）订单");// 流程类型
				} else if ("4".equals(vo.getYjlx()) && !"020202".equals(vo.getYwz())) {//展会样机，且业务组不为海外产品组
					processBean.setProcessKey("orderSampleExhibition-01");// 流程ID
					processBean.setType("样机（展会）订单");// 流程类型
				} else if("020202".equals(vo.getYwz())){//业务组为海外产品组
					processBean.setProcessKey("orderSampleHwcpb");// 流程ID
					processBean.setType("样机（海外产品部）订单");// 流程类型
				}
				processBean.setUserId(vo.getZdrid());
				processBean.setVariables(variables);
				processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
				processInstanceService.startProcessInstance(processBean);
			}
		}
	}

	/**
	 * 进行审核 流程中岗位为供应链支持专员设置的id为gylzczy,岗位为应收风险专员设置的id为ysfxzy
	 * 
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public OrderSampleVo approve(OrderSampleVo vo) {
		this.callBefore(vo);
		// 设置流程参数
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("xszz", vo.getXszz());
		variables.put("sfmf", vo.getSfMf());
		variables.put("sfwx", vo.getSfWx());
		variables.put("sfCh", vo.getSfCh()==null?"0":vo.getSfCh());//是否撤回
		// 获取自定义任务节点ID值，必须放在提交节点之前
		String taskKey = processTaskService.findTaskById(vo.getTaskId()).getTaskKey();
		int approveType = vo.getApproveType();
		// 若为供应链支持专员或海外产品经理则默认为最后一岗审
		//if (("gylzczy".equals(taskKey) && approveType == 1) || ("hwcpjl".equals(taskKey) && approveType == 1 && vo.getSfWx() == 2)) {
		if (("gylzczy".equals(taskKey) && approveType == 1)) {
			vo.setApproveType(3);
		}
		// 若不为风险应收专员则调用审核存储过程
		if (!"ysfxzy".equals(taskKey)) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", vo);
			dao.callApprove(param);
			this.callAfter(param);
		}
		// 完成当前审批节点
		if (approveType == 1) {
			variables.put("out", "agree");
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else if (approveType == 2) {
			variables.put("out", "reject");
			// 若为风险应收专员岗则驳回时结束该流程
			if ("ysfxzy".equals(taskKey)) {
				processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
			} else {
				//processTaskService.rejectTaskRestart(vo.getProcessId());
				processTaskService.rejectTask(vo.getTaskId());
			}
		}
		
		//返回付款保障日志到前台
		if("ysfxzy".equals(taskKey) || "gylzczy".equals(taskKey) || "hwcpjl".equals(taskKey)){
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
		if (zt == 3 && !"".equals(processId)) {
			processInstanceService.deleteProcessInstance(processId);
		}
	}

	private Map<String, Object> save(OrderSampleVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		this.callAfter(param);
		// 循环插入订单关联PI
		for (OrderReferPiVo orderReferPi : vo.getOrderReferPiList()) {
			orderReferPi.setDdid(vo.getDdid());
			orderReferPi.setBbh(vo.getBbh());
			// orderReferPi.setDdlx(vo.getDdlx());
			// orderReferPi.preInsert();
			orderReferPi.setId(Identities.uuid());
			// 支持拆单（将样机数量覆盖掉PI数量，默认相等，可人为拆单     魏诚   2018-6-12 修改）
			orderReferPi.setSl(vo.getSl());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", orderReferPi);
			orderReferPiDao.callInsert(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		return param;
	}
	
	@Transactional
	public void cancel(OrderSampleVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callCancel(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void change(OrderSampleVo vo){
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
	private void callBefore(OrderSampleVo vo) {
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
	public void export(HttpServletResponse response, Map<String, Object> params, OrderSampleVo vo) {
		try {
			List<OrderSampleVo> list = (List<OrderSampleVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}

	}

	// 更新订单跟踪生产订单下达状态
	public void updateDDgz(OrderSampleVo vo) {
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
	public OrderSampleVo tsSapAndWriteLog(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		OrderSampleVo vo = new OrderSampleVo();
		param.put("id", id);
		dao.callSelectById(param);
		List<OrderSampleVo> list = (List<OrderSampleVo>) param.get("list");
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
		}else{
			this.active(vo.getId());
		}
		//sendEmail(id);
		return vo ;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	private Map<String, Object> pushSAP(OrderSampleVo vo) {
		Map<String, Object> paramHw = new HashMap<String, Object>();
		Map<String, Object> paramZz = new HashMap<String, Object>();
		paramHw.put("id", vo.getId());
		paramZz.put("id", vo.getId());
		iDao.callSelectSimpleByIdHw(paramHw);
		iDao.callSelectSimpleByIdZz(paramZz);
		List<OrderHeaderDto> headerRequestListHw = (List<OrderHeaderDto>) paramHw.get("list");
		List<OrderBodyDto> bodyRequestListHw = (List<OrderBodyDto>) paramHw.get("itemList");
		List<OrderZZHeaderDto> headerRequestListZz = (List<OrderZZHeaderDto>) paramZz.get("list");
		List<OrderBodyDto> bodyRequestListZz = (List<OrderBodyDto>) paramZz.get("itemList");
		OrderMsgResponse hwRespMsg = null;
		OrderMsgResponse zzRespMsg = null;
		// 调用sap接口
		try {
			// 0代表海外推送失败; null ：没推送过 
			if (vo.getTssapzt()==null || vo.getTssapzt()==0) {
				hwRespMsg = iOrderService.orderSdoToHwSap(headerRequestListHw.get(0), bodyRequestListHw);
			} else {
				// 海外sap已经推送成功的
				hwRespMsg = new OrderMsgResponse();
				hwRespMsg.setResult("X");
				hwRespMsg.setDh(vo.getDdid());
				hwRespMsg.setMsg("已经推送海外sap成功,不再重复推送！");
				hwRespMsg.setOutXml("已经推送海外sap成功,不再重复推送！");
			}
		} catch (Exception e) {
			throw new ServiceException("调用SAP样机订单接口失败！");
		}
		
		 if(StringUtils.isEmpty(vo.getYddid())){
			 if (hwRespMsg != null && "X".equals(hwRespMsg.getResult())) {
				 this.updateDDgz(vo);
				// 海外sap接口调用成功 且业务处理成功后推送制造sap
				// 如果是否外协的值为直接提取(2)时，不传制造
				if ("2".equals(headerRequestListZz.get(0).getSfwx())) {
					zzRespMsg = new OrderMsgResponse();
					zzRespMsg.setMsg("是否外协为直接提取时,不推送制造");
					zzRespMsg.setResult("X");
				} else {
					try {
						zzRespMsg = iOrderService.orderSdoToZzSap(headerRequestListZz.get(0), bodyRequestListZz);
					} catch (Exception e) {
						throw new ServiceException("调用制造SAP样机订单接口失败！");
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
	public SapInterfaceLogVo saveTsSapLog(OrderSampleVo vo, Map respMsg) {

		if (respMsg == null) {
			throw new ServiceException("推送sap返回信息为空");
		}
		OrderMsgResponse hwRespMsg = (OrderMsgResponse) respMsg.get("hwRespMsg");
		OrderMsgResponse zzRespMsg = (OrderMsgResponse) respMsg.get("zzRespMsg");
		if (zzRespMsg != null) {
			hwRespMsg.setMsg("海外：" + hwRespMsg.getMsg() + ",制造:" + zzRespMsg.getMsg());
		} else {
			hwRespMsg.setMsg("海外：" + hwRespMsg.getMsg() + ",制造:未推送！");
		}
		if (vo == null) {
			throw new ServiceException("推送sap的vo为空");
		}
		// 保存推送日志
		SapInterfaceLogVo logvo = new SapInterfaceLogVo();
		logvo.setId(vo.getId());
		logvo.setDh(vo.getDdid());
		logvo.setMk("样机订单");
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
		return  logvo ;
	}
	
	@Transactional
	private void complete(OrderSampleVo vo) {
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
	}
	//发送邮件
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
		param.put("lx", 2);
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
	private Map<String,Object> emailHelper(OrderEmailVo orderEmailVo){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> drlist=new ArrayList<String>();//收件人列表
		//邮件标题：[提交人姓名]|出货通知书|出货通知书编码|起运港|订单号|客户名称
		StringBuffer subject = new StringBuffer();//邮件主题
		StringBuffer content = new StringBuffer();//邮件正文
		String url_tmp=url+"/base-web/order/orderSample/viewPage?id="+orderEmailVo.getId();
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
		/*邮件正文：
		此邮件由系统自动发出，请勿回复。
		业务基本信息
		业务单据：样机订单
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
	
	public void getback(OrderSampleVo vo){
		DeleteProcess(vo);
		back(vo);
	}
	public void DeleteProcess(OrderSampleVo vo) {
		// 1.删除流程实例
		try {
			processInstanceService.deleteProcessInstance(vo.getProcessId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional
	public void back(OrderSampleVo vo) {
		//2.根据付款保障状态判断是否需要取消付款保障
		//3.将状态置为1
		//4.写进订单的审批日志，说明取回人
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callGetback(param);
		this.callAfter(param);
	}
}