package com.ey.piit.sdo.order.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.order.repository.OrderReferPiDao;
import com.ey.piit.sdo.order.repository.OrderSampleFzbgDao;
import com.ey.piit.sdo.order.vo.OrderBgmxVo;
import com.ey.piit.sdo.order.vo.OrderReferPiVo;
import com.ey.piit.sdo.order.vo.OrderLogVo;
import com.ey.piit.sdo.order.vo.OrderSampleVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 样机订单辅助变更管理Service
 * 
 * @author tianrong
 */
@Service
public class OrderSampleFzbgService {

	@Autowired
	private OrderSampleFzbgDao dao;
	@Autowired
	private OrderReferPiDao orderReferPiDao;
	@Autowired
	private ExportUtil exportUtil;
	@Autowired
	private ProcessInstanceService processInstanceService;
	@Autowired
	private ProcessTaskService processTaskService;
	
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
		OrderSampleVo vo = list.get(0);
		vo.setOrderReferPiList(piList);
		vo.setLogList(logList);
		vo.setBgmxList(bgmxList);
		return vo;
	}

	@Transactional
	public Object edit(OrderSampleVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
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
		variables.put("groupCode", vo.getYwz());// 指定销售组长的业务组
		variables.put("deptCode", vo.getXszz());//销售组织
		variables.put("xsyid", vo.getXsyid());// 指定销售员进行审批
		variables.put("xszz", vo.getXszz());
		variables.put("sfwx", vo.getSfWx());//是否外协
		variables.put("hwcpjl", vo.getLccpjl());
		variables.put("yjlx", vo.getYjlx().toString());//样机类型
		// 判断是否驳回
		if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())) {
			// 驳回提交
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getDdid()+"("+vo.getBbh()+")");// 订单号
			processBean.setProcessKey("orderSampleModify_fzxx");// 流程ID
			processBean.setType("样机订单-变更(辅助信息)");// 流程类型
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
			processInstanceService.startProcessInstance(processBean);
		}
	}

	/**
	 * 进行审核 
	 * 
	 * @param vo
	 */
	@Transactional
	public OrderSampleVo approve(OrderSampleVo vo) {
		this.callBefore(vo);
		// 设置流程参数
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("xszz", vo.getXszz());
		/*//工程师参数设置
		if(!StringUtils.isEmpty(vo.getDzgcs())){
			variables.put("sfxzdy", "1");//电子工程师
			variables.put("dzgcsid", vo.getDzgcs());//电子工程师
		} else {
			variables.put("sfxzdy", "0");//电子工程师
			variables.put("dzgcsid", "");//电子工程师
		}
		if(!StringUtils.isEmpty(vo.getDygcs())){
			variables.put("sfxzdz", "1");//电源工程师
			variables.put("dygcsid", vo.getDygcs());//电源工程师
		} else {
			variables.put("sfxzdz", "0");//电源工程师
			variables.put("dygcsid", "");//电源工程师
		}
		if(!StringUtils.isEmpty(vo.getJggcs())){
			variables.put("sfxzjg", "1");//结构工程师
			variables.put("jggcsid", vo.getJggcs());//结构工程师
		} else {
			variables.put("sfxzjg", "0");//结构工程师
			variables.put("jggcsid", "");//结构工程师
		}*/
		int approveType = vo.getApproveType();
		// 完成当前审批节点
		if (approveType == 1) {
			variables.put("out", "agree");
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(),variables);
		} else if (approveType == 2) {
			variables.put("out", "reject");
			processTaskService.rejectTaskRestart(vo.getProcessId());
		}
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
		return param;
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
		//3.将状态置为1
		//4.写进订单的审批日志，说明取回人
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callGetback(param);
		this.callAfter(param);
	}
}