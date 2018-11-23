package com.ey.piit.sdo.mdm.service;

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
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.mdm.repository.CustomerApplyDao;
import com.ey.piit.sdo.mdm.vo.CustomerApplyLogVo;
import com.ey.piit.sdo.mdm.vo.CustomerApplyVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 客户信息申请Service
 * @author 高文浩
 */
@Service
public class CustomerApplyService{
	
	@Autowired
	private CustomerApplyDao dao;
	
	@Autowired
	private ExportUtil exportUtil;
	
	@Autowired
	private ProcessInstanceService processInstanceService;
	
	@Autowired
	private ProcessTaskService processTaskService;

	@SuppressWarnings("unchecked")
	public Object callQueryByPage(CustomerApplyVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<CustomerApplyVo> list = (List<CustomerApplyVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<CustomerApplyVo> list = (List<CustomerApplyVo>) param.get("list");
		List<CustomerApplyLogVo> logList = (List<CustomerApplyLogVo>) param.get("logList");
		CustomerApplyVo vo = new CustomerApplyVo() ;
		if(list.size()>0){
			vo = list.get(0);
			vo.setLogList(logList);
		}
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(CustomerApplyVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<CustomerApplyVo> list = (List<CustomerApplyVo>) param.get("list");
		return list;
	}
	
	@Transactional
	public Object edit(CustomerApplyVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
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
		if(zt == 3 && !"".equals(processId)){
			processInstanceService.deleteProcessInstance(processId);
		}
		
	}
	@Transactional
	public void submit(CustomerApplyVo vo){
		// 调用提交存储过程
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		dao.callSubmit(param);
		this.callAfter(param);
		
		// 审批流处理
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		variables.put("deptCode", vo.getXszz());//销售组织
		variables.put("groupCode", vo.getYwz());//业务组
		
		if(!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())){
			// 驳回提交
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getSqdh());
			processBean.setComment("客户申请");
			processBean.setProcessKey("customerApply");
			processBean.setProcessType("add");//新增流程
			processBean.setType("客户申请");//流程类型
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processInstanceService.startProcessInstance(processBean);
		}
	}
	
	@Transactional
	public void approve(CustomerApplyVo vo) {
		this.callBefore(vo);
		User user = UserUtils.getUser();
		// 完成当前节点审批
		Map<String, Object> variables = new HashMap<String, Object>();
		if(vo.getApproveType() == 1){
			variables.put("out", "agree");
			processTaskService.completeTask(vo.getTaskId(), user.getLoginAcct(), variables);
		} else if(vo.getApproveType() == 2){
			variables.put("out", "reject");
			processTaskService.rejectTaskRestart(vo.getProcessId());
		}
		
		// 判断是不是终审
		boolean isEnd = processInstanceService.isProcessEnd(vo.getProcessId());
		if(isEnd && vo.getApproveType()==1){
			vo.setApproveType(3);
		}
				
		// 调用审批存储过程
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callApprove(param);
		this.callAfter(param);
	}
	
	private Map<String, Object> save(CustomerApplyVo vo){
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
	private void callBefore(CustomerApplyVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setCjsj(new Date());
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
	public void export(HttpServletResponse response, Map<String, Object> params, CustomerApplyVo vo){
		try {
			List<CustomerApplyVo> list = (List<CustomerApplyVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}

}