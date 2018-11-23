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
import com.ey.piit.sdo.payment.repository.LcRegDao;
import com.ey.piit.sdo.payment.vo.LcLogVo;
import com.ey.piit.sdo.payment.vo.LcRegItemVo;
import com.ey.piit.sdo.payment.vo.LcRegVo;
import com.ey.piit.core.utils.ExportUtil;


/**
 * LC登记Service
 * @author 邓海
 */
@Service
public class LcRegService {
	@Autowired
	private LcRegDao dao;

	@Autowired
	private ExportUtil exportUtil;
	
	@Autowired
	private ProcessInstanceService processInstanceService;
	
	@Autowired
	private ProcessTaskService processTaskService;
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(LcRegVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<LcRegVo> list = (List<LcRegVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryJdmxByPage(LcRegItemVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectJdmx(param);
		List<LcRegItemVo> list = (List<LcRegItemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryDbd(LcRegVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectDbd(param);
		List<LcRegVo> list = (List<LcRegVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(LcRegVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelect(param);
		List<LcRegVo> list = (List<LcRegVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryJdmx(LcRegItemVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectJdmx(param);
		List<LcRegVo> list = (List<LcRegVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public LcRegVo callQueryById(String id){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<LcRegVo> list = (List<LcRegVo>) param.get("list");
		List<LcLogVo> logList = (List<LcLogVo>) param.get("logList");
		List<LcRegVo> htylist = (List<LcRegVo>) param.get("htylist");
		List<LcRegItemVo> itemList = (List<LcRegItemVo>) param.get("itemList");
		LcRegVo vo = list.get(0);
		vo.setLogList(logList);
		vo.setHtylist(htylist);
		vo.setItemVoList(itemList);
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callChangeById(String id, String sjc){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		dao.callChangeById(param);
		this.callAfter(param);
		List<LcRegVo> list = (List<LcRegVo>) param.get("list");
		LcRegVo vo = list.get(0);
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public LcRegVo callQueryJdmxByLcbh(String lcbh){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lcbh", lcbh);
		dao.callSelectJdmxByLcbh(param);
		List<LcRegItemVo> list = (List<LcRegItemVo>) param.get("list");
		LcRegVo vo =new LcRegVo();
		vo.setItemVoList(list);
		return vo;
	}
	
	private Map<String, Object> save(LcRegVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		return param;
	}
	
	@Transactional
	public Object edit(LcRegVo vo) {	
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public void submit(LcRegVo vo){
		// 调用提交存储过程
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		dao.callSubmit(param);
		this.callAfter(param);
		// 审批流处理
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		// 判断是否驳回
		if(!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())){
			// 驳回提交
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getLcbh());
			processBean.setProcessKey("payment-LC-reg");
			processBean.setType("LC信息登记");//流程类型
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
			processInstanceService.startProcessInstance(processBean);
		}
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
	
	/**
	 * 保存交单明细
	 * @param vo
	 * @return
	 */
	@Transactional
	public void saveJdmx(LcRegVo vo){
		//删除交单明细
		Map<String, Object> itemParam = new HashMap<String, Object>();
		itemParam.put("vo", vo);
		dao.callDeleteJdmx(itemParam);
		this.callAfter(itemParam);
		//提交现有交单明细
		for(LcRegItemVo _vo : vo.getItemVoList()){
			_vo.setZdrid(UserUtils.getUser().getLoginAcct());
			_vo.setZdrmc(UserUtils.getUser().getUserName());
	        _vo.setLcbh(vo.getLcbh());
	        itemCallBefore(_vo);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", _vo);
			dao.callSaveJdmx(param);
			this.callAfter(param);
		}
	}
	
	@Transactional
	public void approve(LcRegVo vo){
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		// 完成当前节点审批
		Map<String, Object> variables = new HashMap<String, Object>();
		if(vo.getApproveType() == 1){
			variables.put("out", "agree");
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
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

	@Transactional
	public Map<String, Object> delete(LcRegVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callDelete(param);
		this.callAfter(param);
		return param;
	}

	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(LcRegVo vo) {
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
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void itemCallBefore(LcRegItemVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}

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
	public void export(HttpServletResponse response, Map<String, Object> params, LcRegVo vo){
		try {
			List<LcRegVo> list = (List<LcRegVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	//冻结，解冻
	@Transactional
	public void frozen(LcRegVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callFrozen(param);
		this.callAfter(param);
	}
	
	@SuppressWarnings("unchecked")
	public void jdmxExport(HttpServletResponse response, Map<String, Object> params, LcRegItemVo vo){
		try {
			List<LcRegItemVo> list = (List<LcRegItemVo>)this.callQueryJdmx(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryItem(LcRegVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectMx(param);
		List<LcRegVo> list = (List<LcRegVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public void exportmx(HttpServletResponse response, Map<String, Object> params, LcRegVo vo){
		try {
			List<LcRegVo> list = (List<LcRegVo>)this.callQueryItem(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
}