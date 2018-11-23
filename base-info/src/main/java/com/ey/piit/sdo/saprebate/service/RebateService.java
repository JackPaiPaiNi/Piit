package com.ey.piit.sdo.saprebate.service;

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
import com.ey.piit.core.vo.RoleVo;
import com.ey.piit.interfaces.approve.dao.IApproveDao;
import com.ey.piit.interfaces.approve.dto.ApproveBodyDto;
import com.ey.piit.interfaces.approve.dto.ApproveMsgResponse;
import com.ey.piit.interfaces.approve.service.ApproveInterfaceService;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.sdo.saprebate.repository.ExpensesApplyDao;
import com.ey.piit.sdo.saprebate.repository.RebateApplyDao;
import com.ey.piit.sdo.saprebate.repository.RebatePolicyDao;
import com.ey.piit.sdo.saprebate.repository.TitleDao;
import com.ey.piit.sdo.saprebate.vo.ExpensesApplyVo;
import com.ey.piit.sdo.saprebate.vo.RebateApplyVo;
import com.ey.piit.sdo.saprebate.vo.RebatePolicyVo;
import com.ey.piit.sdo.saprebate.vo.TitleVo;
import com.ey.piit.sdo.sapspecial.vo.SapApproveLogVo;

/**
 * sap费用审批Service
 * 
 * @author 赵桃军
 */
@Service
public class RebateService {

	@Autowired
	private TitleDao dao;
	@Autowired
	ExpensesApplyDao expensesApplyDao;
	@Autowired
	RebateApplyDao rebateApplyDao;
	@Autowired
	RebatePolicyDao rebatePolicyDao;
	@Autowired
	private IApproveDao iDao;
	@Autowired
	private ApproveInterfaceService iApproveService;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
	@Autowired
	private ProcessTaskService processTaskService;
	@Autowired
	private ProcessInstanceService processInstanceService;

	// 返利代办查询
	@SuppressWarnings("unchecked")
	public PageList<Object> callQueryByPage(TitleVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<TitleVo> list = (List<TitleVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	// 提交，开启审批流
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public void callSubmitList(List<TitleVo> list) {
		Map<String, Object> param = new HashMap();
		for (TitleVo titleVo : list) {
			param.clear();
			callBefore(titleVo);
			param.put("vo", titleVo);
			dao.callSubmit(param);
			callAfter(param);
			// 返利政策
			if (titleVo.getZdjlx().equals("1")) {
				openRbpProcess(titleVo);
			}
			// 费用申报
			if (titleVo.getZdjlx().equals("2")) {
				openReabteExpProcess(titleVo);
			}
			// 返利申报
			if (titleVo.getZdjlx().equals("3")) {
				openRbaProcess(titleVo);
			}
		}
	}

	/****************************************** 以下为 返利政策 处理方法***************************************/

	// 根据id查询返利政策明细
	@SuppressWarnings("unchecked")
	public TitleVo callQueryRebatePolicyById(String id) {
		TitleVo vo = new TitleVo();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		// 判断前用户角色
		rebatePolicyDao.callSelectRebatePolicyById(param);
		List<TitleVo> list = (List<TitleVo>) param.get("list");
		List<RebatePolicyVo> itemlist = (List<RebatePolicyVo>) param.get("itemList");
		List<SapApproveLogVo> logList = (List<SapApproveLogVo>) param.get("logList");
		if (list.size() > 0) {
			vo = list.get(0);
			vo.setRbpPolicyList(itemlist);
			vo.setLogList(logList);
		}
		return vo;
	}

	// 根据id查询返利政策明细
	@SuppressWarnings("unchecked")
	public TitleVo viewRebatePolicyById(String id) {
		TitleVo vo = new TitleVo();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		rebatePolicyDao.callViewRebatePolicyById(param);
		List<TitleVo> list = (List<TitleVo>) param.get("list");
		List<RebatePolicyVo> itemlist = (List<RebatePolicyVo>) param.get("itemList");
		List<SapApproveLogVo> logList = (List<SapApproveLogVo>) param.get("logList");
		if (list.size() > 0) {
			vo = list.get(0);
			vo.setRbpPolicyList(itemlist);
			vo.setLogList(logList);
		}
		return vo;
	}

	// 开启返利政策审批流
	public void openRbpProcess(TitleVo vo) {
		// 审批流处理开始
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		variables.put("deptCode", vo.getBukrs());
		variables.put("sffgs", vo.getSfFgs()); // 是否分公司
		variables.put("sfrgk",1); //是否弱管控，期初统一设置成1
		// 如果是已经提交的单据处理
		if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId()) && !"".equals(vo.getTaskId())) {
			throw new ServiceException("已经提交过的单据不能重复提交");
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getSplsh());
			processBean.setProcessKey("sap_flow_rebate_policy");
			processBean.setType("SAP返利申请单");// 流程类型
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processInstanceService.startProcessInstance(processBean);
		}
	}

	// 返利政策审批（主方法）
	//@Transactional
	public void callApproveRebatePolicy(TitleVo vo) {
		int flag = 1;
		for (RebatePolicyVo rbp : vo.getRbpPolicyList()) {
			// 如果有勾选的明细，则不再循环
			if (rbp.getsFgx() == 1) {
				flag = 0;
				break;
			}
		}
		// 如果没有勾选任何明细，那么审批状态置为驳回
		if (flag == 1) {
			vo.setApproveType(2);
		}
		// 1完成返利政策审批流程操作
		vo = approve(vo);
		// 2 完成审批过后数据库操作
		ApproveRebatePolicy(vo);
		// 如果是终审或者是驳回，则推送SAP
		if(vo.getApproveType()==2 || vo.getApproveType()==3){
	       tsSapAndWriteLogRebatePolicy(vo);
        }
		 
	}

	// 1返利政策 审批数据库操作
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public Object ApproveRebatePolicy(TitleVo vo) {
		Map<String, Object> param = new HashMap();
		callBefore(vo);
		param.put("vo", vo);
		// 主表审批
		dao.callApprove(param);
		callAfter(param);
		// 判断当前审批角色是否为分总,分总审批通过的明细<0.05的明细 后续节点不需看见，状态直接为审批通过
		List<RoleVo> roles = UserUtils.getRole();
		int flag = 0;
		for (RoleVo roleVo : roles) {
			if ("6-fgs-fz".equals(roleVo.getCode())) {
				flag = 1;
				break;
			}
		}
		// 明细表审批保存
		for (RebatePolicyVo rbtVo : vo.getRbpPolicyList()) {
			param.clear();
			rbtVo.setApproveType(vo.getApproveType());
			param.put("sffz", flag);// 是否分总审批
			param.put("vo", rbtVo);
			rebatePolicyDao.callRebatePolicyItemApprove(param);
			callAfter(param);
		}
		return vo;
	}

	//推送SAP并且记录返信息日志
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public void tsSapAndWriteLogRebatePolicy(TitleVo vo) {
		// 执行推送
		List respList = pushSAP(vo);
		// 主表更改推送SAP状态
		Complete(vo);
		// 明细表更改推送SAP状态
		CompletePolicyItem(vo, respList);
		// 保存推送返回信息日志
		saveTsSapLog(vo, respList);
	}

	// 返利政策 明细更改推送SAP状态
	@Transactional
	private void CompletePolicyItem(TitleVo vo, List<ApproveMsgResponse> list) {
		this.callBefore(vo);
		for (ApproveMsgResponse approveMsgResponse : list) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", vo);
			if ("X".equals(approveMsgResponse.getResult())) {
				param.put("tssapzt", 1);
			} else {
				param.put("tssapzt", 0);
			}
			param.put("nr", approveMsgResponse.getMsg());
			rebatePolicyDao.callRebatePolicyItemComplete(param);
			this.callAfter(param);
		}
	}

	/****************************************** 返利政策 结束 ***********************************************/

	/****************************************** 以下为 返利申报 处理方法***************************************/

	// 根据id查询返利申请明细
	@SuppressWarnings("unchecked")
	public TitleVo callQueryRebateApplyById(String id) {
		TitleVo vo = new TitleVo();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		rebateApplyDao.callSelectRebateApplyById(param);
		List<TitleVo> list = (List<TitleVo>) param.get("list");
		List<RebateApplyVo> itemlist = (List<RebateApplyVo>) param.get("itemList");
		List<SapApproveLogVo> logList = (List<SapApproveLogVo>) param.get("logList");
		if (list.size() > 0) {
			vo = list.get(0);
			vo.setLogList(logList);
			vo.setRbtApplyList(itemlist);
		}
		return vo;
	}
	//供查询方法调用
	@SuppressWarnings("unchecked")
	public TitleVo viewRebateApplyById(String id) {
		TitleVo vo = new TitleVo();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		rebateApplyDao.callViewRebateApplyById(param);
		List<TitleVo> list = (List<TitleVo>) param.get("list");
		List<RebateApplyVo> itemlist = (List<RebateApplyVo>) param.get("itemList");
		List<SapApproveLogVo> logList = (List<SapApproveLogVo>) param.get("logList");
		if (list.size() > 0) {
			vo = list.get(0);
			vo.setLogList(logList);
			vo.setRbtApplyList(itemlist);
		}
		return vo;
	}

	// 开启返利申报审批流
	public void openRbaProcess(TitleVo vo) {
		// 审批流处理开始
		Map<String, Object> variables = new HashMap<String, Object>();
		vo = this.callQueryRebateApplyById(vo.getId());
		variables.put("out", "commit");
		variables.put("groupCode", vo.getDeptCode()); // 指总部销售员或业务员所在部门编码
		variables.put("orgCode", vo.getDeptCode());
		variables.put("deptCode", vo.getBukrs()); // 指定单据公司代码
		variables.put("sffgs", vo.getSfFgs()); // 是否分公司
		variables.put("sfrgk",1); //是否弱管控，期初统一设置成1
		// 如果是已经提交的单据处理
		if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId()) && !"".equals(vo.getTaskId())) {
			throw new ServiceException("已经提交过的单据不能重复提交");
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getSplsh());
			processBean.setProcessKey("sap_flow_rebate_apply");
			processBean.setType("SAP返利申请单");// 流程类型
			processBean.setUserId(vo.getUserid());
			processBean.setVariables(variables);
			processInstanceService.startProcessInstance(processBean);
		}
	}

	// 返利申报审批（主方法）
	public void approveRebateApply(TitleVo vo) {
		int flag = 1;
		for (RebateApplyVo rba : vo.getRbtApplyList()) {
			// 如果有勾选的明细，则不再循环
			if (rba.getsFgx() == 1) {
				flag = 0;
				break;
			}
		}
		// 如果没有勾选任何明细，那么审批状态置为驳回
		if (flag == 1) {
			vo.setApproveType(2);
		}
		// 1完成流程批流程操作
		vo = approve(vo);
		// 2数据库操作
		ApproveRebateApply(vo);
		// 终审或驳回，推送SAP并保存明细
		if(vo.getApproveType() == 3 || vo.getApproveType()==2){
			tsSapAndWriteLogRebateApply(vo);
		}
	}

	// 1返利申报审批数据库处理
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public Object ApproveRebateApply(TitleVo vo) {
		Map<String, Object> param = new HashMap();
		callBefore(vo);
		param.put("vo", vo);
		param.put("sjc", vo.getSjc());
		dao.callApprove(param);
		callAfter(param);
//		vo.setSjc(param.get("sjc").toString());
		for (RebateApplyVo rbtVo : vo.getRbtApplyList()) {
			param.clear();
			rbtVo.setApproveType(vo.getApproveType());
			param.put("vo", rbtVo);
			rebateApplyDao.callRebateApplyItemApprove(param);
			callAfter(param);
		}
		return vo;
	}

	// 推送SAP并且记录返信息货日志
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public void tsSapAndWriteLogRebateApply(TitleVo vo) {
		// 执行推送
		List respList = pushSAP(vo);
		// 主表更改推送SAP状态
		Complete(vo);
		// 明细表更改推送SAP状态
		CompleteApplyItem(vo, respList);
		// 保存推送返回信息日志
		saveTsSapLog(vo, respList);
	}

	// 返利申报 明细更改推送SAP状态
	@Transactional
	private void CompleteApplyItem(TitleVo vo, List<ApproveMsgResponse> list) {
		this.callBefore(vo);
		for (ApproveMsgResponse approveMsgResponse : list) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", vo);
			param.put("hhao", approveMsgResponse.getDhhxm());
			if ("X".equals(approveMsgResponse.getResult())) {
				param.put("tssapzt", 1);
			} else {
				param.put("tssapzt", 0);
			}
			param.put("nr", approveMsgResponse.getMsg());
			rebateApplyDao.callRebateApplyItemComplete(param);
			this.callAfter(param);
		}
	}

	/****************************************** 返利申报 结束***********************************************/

	/****************************************** 以下为费用申请 处理方法***************************************/
	// 根据id查询费用申请明细
	@SuppressWarnings("unchecked")
	public TitleVo callQueryExpApplyById(String id) {
		TitleVo vo = new TitleVo();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		expensesApplyDao.callSelectExpApplyById(param);
		List<TitleVo> list = (List<TitleVo>) param.get("list");
		List<ExpensesApplyVo> itemlist = (List<ExpensesApplyVo>) param.get("itemList");
		List<SapApproveLogVo> logList = (List<SapApproveLogVo>) param.get("logList");
		if (list.size() > 0 && itemlist.size() > 0) {
			vo = list.get(0);
			vo.setLogList(logList);
			vo.setExpApply(itemlist.get(0));
		}
		return vo;
	}

	// 费用申请（主方法）
	@Transactional
	public void approveRebateExpApply(TitleVo vo) {
		// 1完成流程批流程操作
		vo = approve(vo);
		// 2数据库操作
		ApproveExpApply(vo);
		//如果是终审或驳回，则立刻推送SAP
		if(2==vo.getApproveType() || 3==vo.getApproveType()){
			vo.setZdrid("系统自动");
			vo.setZdrmc("系统自动");
			tsSapAndWriteLogExpApply(vo);
			// 更改主表推送状态
			Complete(vo);
		}
	}

	// 开启费用申请审批流
	public void openReabteExpProcess(TitleVo vo) {
		Integer sffgs = vo.getSfFgs();
		vo = this.callQueryExpApplyById(vo.getId());
		vo.setSfFgs(sffgs);
		this.callBefore(vo);
		// 审批流处理开始
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		variables.put("sffgs", vo.getSfFgs());// 是否分公司
		if ("5050".equals(vo.getBukrs())) {
			variables.put("sfflb", 1); // 是否菲律宾
		} else {
			variables.put("sfflb", 0);
		}
		variables.put("djlx", vo.getExpApply().getZspcd());// 费用申请类型
		variables.put("je", vo.getExpApply().getRmbje());// 费用人民币金额
		variables.put("orgCode", vo.getDeptCode()); // 费用申请务员所在(渠道/区域)
		variables.put("groupCode", vo.getDeptCode()); // 费用申请务员所在(渠道/区域)
		variables.put("deptCode", vo.getBukrs()); // 费用申请业务员所在分公司
		variables.put("sffgs", vo.getSfFgs()); // 是否分公司标志
		variables.put("tssapzt",0); // 推送SAP状态，会在费用预提推送SAP监听里设值，开始默认为0
		variables.put("sfrgk",1); //是否弱管控，期初统一设置成1
		// 如果是已经提交的单据处理
		if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId()) && !"".equals(vo.getTaskId())) {
			throw new ServiceException("已经提交过的单据不能重复提交");
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getSplsh());
			processBean.setProcessKey("sap_flow_expenses_apply");
			processBean.setType("SAP费用申请单");// 流程类型
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processInstanceService.startProcessInstance(processBean);
		}
	}

	// 1费用审批
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object ApproveExpApply(TitleVo vo) {
		Map<String, Object> param = new HashMap();
		callBefore(vo);
		//审批主表
		param.put("vo", vo);
		dao.callApprove(param);
		callAfter(param);
		//审批明细
		expensesApplyDao.callApproveItem(param);
		callAfter(param);
		return vo;
	}

	// 推送SAP并且记录返信息日志
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public void tsSapAndWriteLogExpApply(TitleVo vo) {
		// 执行推送
		List respList = pushSAP(vo);
		// 保存推送返回信息日志
		saveTsSapLog(vo, respList);
	}
	
	// 费用预提推送SAP（适用返利费用的监听调用）
	@Transactional
	public List<ApproveMsgResponse> listenerPushSAP(TitleVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		iDao.callSelectYtById(param);
		@SuppressWarnings("unchecked")
		List<ApproveBodyDto> requestList = (List<ApproveBodyDto>) param.get("list");
		List<ApproveMsgResponse> responseList = null;
		// 调用sap接口
		try {
			responseList = iApproveService.approveSdoToSap(requestList);
		} catch (Exception e) {
			throw new ServiceException("调用SAP审批流(返利)接口失败！");
		}
		int i =responseList.size();
		int j =0;
		// 回写返利审批推送SAP状态
		for (ApproveMsgResponse approveMsgResponse : responseList) {
			if (!"X".equals(approveMsgResponse.getResult())) {
				j++;
			}
		}
		if (j==0) {
			vo.setTssapzt(1);
		} else if (j < i) {// 明细中部分成功，部分失败
			vo.setTssapzt(2);
		} else if (j == i){
			vo.setTssapzt(0);
		}
		return responseList;
	}

	/***************************************** * 费用申请 结束 ***************************************/

	/************************************ 以下为上面三种通用方法 ******************************************/

	// 审批流程操作(三种公用)
	public TitleVo approve(TitleVo vo) {
		this.callBefore(vo);
		// 完成当前节点审批
		Map<String, Object> variables = new HashMap<String, Object>();
		// 如果是返利政策审批，审批通过的明细中只要有返点大于0.05的明细行，那么就需要总部领导审批
		if (vo.getZdjlx().equals("1")) {
			int flag = 0;
			for (RebatePolicyVo rpv : vo.getRbpPolicyList()) {
				// 返点大于0.05
				if (Float.parseFloat(rpv.getZrbat()) >= 0.05) {
					flag = 1;
					break;
				}
			}
			// 设置是否需要总部领导审批标志位
			variables.put("flag", flag);
		}
		// 通用处理
		if (vo.getApproveType() == 1) {
			variables.put("out", "agree");
			processTaskService.completeTask(vo.getTaskId(), vo.getUserid(), variables);
		} else if (vo.getApproveType() == 2) {
			// 如果是驳回，流程直接调到结束节点
			processTaskService.jumpTask(vo.getTaskId(), "end");
		}
		// 判断是不是终审
		boolean isEnd = processInstanceService.isProcessEnd(vo.getProcessId());
		if (isEnd && vo.getApproveType() == 1) {
			vo.setApproveType(3);
		}
		return vo;
	}
	// 终审推送SAP（适用返利政策、费用申请、返利申报）
	public List<ApproveMsgResponse> pushSAP(TitleVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		param.put("djlx", vo.getZdjlx());
		iDao.callSelectById(param);
		@SuppressWarnings("unchecked")
		List<ApproveBodyDto> requestList = (List<ApproveBodyDto>) param.get("list");
		List<ApproveMsgResponse> responseList = null;
		// 调用sap接口
		try {
			responseList = iApproveService.approveSdoToSap(requestList);
		} catch (Exception e) {
			throw new ServiceException("调用SAP审批流(返利)接口失败！");
		}
		int i =responseList.size();
		int j =0;
		// 回写返利审批推送SAP状态
		for (ApproveMsgResponse approveMsgResponse : responseList) {
			if (!"X".equals(approveMsgResponse.getResult())) {
				j++;
				vo.setMsg(approveMsgResponse.getMsg());
			}
		}
		if (j==0) {
			vo.setTssapzt(1);
			vo.setNr("推送SAP成功！");
		} else if (j < i) {// 明细中部分成功，部分失败
			vo.setTssapzt(2);
			vo.setNr("推送SAP部分成功！");
		} else if (j == i){
			vo.setTssapzt(0);
			vo.setResult("0");
			vo.setNr("推送SAP失败！");
		}
		return responseList;
	}
	// 更改主表推送SAP状态（适用返利政策、费用申请、返利申报）
	private void Complete(TitleVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("sjc",vo.getSjc());
		dao.callComplete(param);
		this.callAfter(param);
		vo.setSjc(param.get("sjc").toString());
	}

	// 保存推送SAP日志（适用返利政策、费用申请、返利申报）
	public void saveTsSapLog(TitleVo vo, List<ApproveMsgResponse> list) {
		if (vo == null) {
			throw new ServiceException("推送sap的vo为空");
		}
		for (ApproveMsgResponse approveMsgResponse : list) {
			if (approveMsgResponse == null) {
				throw new ServiceException("推送sap返回信息为空");
			}
			// 保存推送日志
			SapInterfaceLogVo logvo = new SapInterfaceLogVo();
			logvo.setId(vo.getId());
			logvo.setDh(vo.getSplsh());

			if ("1".equals(vo.getZdjlx())) {
				logvo.setMk("SAP审批流(返利政策)");
			} else if ("2".equals(vo.getZdjlx())) {
				logvo.setMk("SAP审批流(费用申请)");
			} else if ("3".equals(vo.getZdjlx())) {
				logvo.setMk("SAP审批流(返利申报)");
			}
			logvo.setSj(new Date());
			logvo.setFhzt(vo.getTssapzt());
			logvo.setFhxx(approveMsgResponse.getMsg());
			logvo.setBw(approveMsgResponse.getInXml());
			try {
				sapInterfaceLogService.save(logvo);
			} catch (Exception e) {
				new ServiceException("保存SAP返回信息日志出错");
			}
		}
	}
	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(TitleVo vo) {
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
	/************************************** 通用方法 结束******************************************/

}