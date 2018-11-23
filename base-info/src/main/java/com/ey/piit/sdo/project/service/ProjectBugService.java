package com.ey.piit.sdo.project.service;

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
import com.ey.piit.sdo.order.vo.OrderProductVo;
import com.ey.piit.sdo.project.repository.ProjectBugDao;
import com.ey.piit.sdo.project.vo.ProjectBugLogVo;
import com.ey.piit.sdo.project.vo.ProjectBugVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 系统问题管理Service
 * 
 * @author 赵桃军
 */
@Service
public class ProjectBugService {
	@Autowired
	private ExportUtil exportUtil;

	@Autowired
	private ProjectBugDao dao;

	@Autowired
	private ProcessTaskService processTaskService;
	@Autowired
	private ProcessInstanceService processInstanceService;

	@SuppressWarnings("unchecked")
	public Object callQueryByPage(ProjectBugVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<ProjectBugVo> list = (List<ProjectBugVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<ProjectBugVo> list = (List<ProjectBugVo>) param.get("list");
		List<ProjectBugLogVo> logList = (List<ProjectBugLogVo>) param.get("logList");
		ProjectBugVo vo = new ProjectBugVo();
		if (list.size() > 0) {
			vo = list.get(0);
			vo.setLogList(logList);
		}
		return vo;
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(ProjectBugVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callSelect(param);
		List<ProjectBugVo> list = (List<ProjectBugVo>) param.get("list");
		return list;
	}


	public Map<String, Object> save(ProjectBugVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callInsert(param);
		return param;
	}

	@Transactional
	public Object edit(ProjectBugVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		return vo;
	}

	@Transactional
	public ProjectBugVo submit(ProjectBugVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		dao.callSubmit(param);
		this.callAfter(param);
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		variables.put("fqr", vo.getTcr());
		// 判断是否驳回
		if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())) {
			// 驳回提交
			processTaskService.completeTask(vo.getTaskId(), vo.getTcr(), variables);
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getWtdh());
			processBean.setProcessKey("p-project-bug");
			processBean.setType("系统优化");// 流程类型
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processInstanceService.startProcessInstance(processBean);
		}
		return vo ;
	}

	// 审批
	@Transactional
	public ProjectBugVo approve(ProjectBugVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> param1 = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		param1.put("vo", vo);
		// 设置流程参数
		Map<String, Object> variables = new HashMap<String, Object>();
		//获取自定义任务节点ID值，必须放在提交节点之前
		String taskKey = processTaskService.findTaskById(vo.getTaskId()).getTaskKey();
		// 项目主管审核后保存数据
		if("xmzg".equals(taskKey)){
			variables.put("clr", vo.getClr());   //开发处理人
			variables.put("flag", vo.getFlag());   //开发处理人
			dao.callSaveXmzg(param1);//保存项目主管填写的参数
			this.callAfter(param1);
		}
		//开发人员审核后设置相应参数
		if("kfry".equals(taskKey)){
			dao.callSaveKfry(param1);//保存开发人员填写的参数
			this.callAfter(param1);
		}
		
		// 完成当前审批节点
		if (vo.getApproveType() == 1) {
			variables.put("out", "commit");
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		}
		if (vo.getApproveType() == 2) {
			variables.put("out", "reject");
			processTaskService.rejectTaskRestart(vo.getProcessId());
		}
		if (processInstanceService.isProcessEnd(vo.getProcessId()) && vo.getApproveType() == 1) {
			vo.setApproveType(3);
		}
		
		dao.callApprove(param);
		this.callAfter(param);
		return vo;
	}

	
	public void approve(OrderProductVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callApprove(param);
		this.callAfter(param);
	}
	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(ProjectBugVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
		User user = UserUtils.getUser();
		vo.setTcr(user.getLoginAcct());
		vo.setTcrmc(user.getUserName());
		vo.setTcbm(user.getDeptCode());
		vo.setTcbmmc(user.getDeptName());
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setTcsj(new Date());
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
	public void export(HttpServletResponse response, Map<String, Object> params, ProjectBugVo vo) {
		try {
			List<ProjectBugVo> list = (List<ProjectBugVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}

	}

}