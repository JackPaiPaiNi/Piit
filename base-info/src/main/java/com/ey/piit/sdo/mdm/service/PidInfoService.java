package com.ey.piit.sdo.mdm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.interfaces.pidinfo.dao.IPidInfoDao;
import com.ey.piit.interfaces.pidinfo.dto.PidInfoMsgResponse;
import com.ey.piit.interfaces.pidinfo.service.PidInfoInterfaceService;
import com.ey.piit.sdo.mdm.entity.PidReceiver;
import com.ey.piit.sdo.mdm.repository.PidInfoDao;
import com.ey.piit.sdo.mdm.vo.PidEmailVo;
import com.ey.piit.sdo.mdm.vo.PidInfoLogVo;
import com.ey.piit.sdo.mdm.vo.PidInfoVo;
import com.ey.piit.sdo.pub.repository.EmailDao;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.pub.vo.EmailVo;

/**
 * PID信息维护Service
 * @author 高文浩
 */
@Service
public class PidInfoService {
	
	@Autowired
	private PidInfoDao dao;
	@Autowired
	private EmailDao emailDao;
	@Autowired
	private ExportUtil exportUtil;
	
	@Autowired
	private ProcessInstanceService processInstanceService;
	
	@Autowired
	private ProcessTaskService processTaskService;
	
	@Autowired
	private PidInfoInterfaceService pidInfoInterfaceService;
	
	@Autowired
	private IPidInfoDao iPidInfoDao;
	
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
	
	@Autowired
	private MimeMailService mimeMailService;//邮件服务类
	
    @Value("${email.url}")
    private String url;//项目访问路径
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(PidInfoVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelect(param);
		List<PidInfoVo> list = (List<PidInfoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<PidInfoVo> list = (List<PidInfoVo>) param.get("list");
		List<PidInfoLogVo> logList = (List<PidInfoLogVo>) param.get("logList");
		PidInfoVo vo = new PidInfoVo();
		if(list.size()>0){
		    vo = list.get(0);
			vo.setLogList(logList);
		}
		
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(PidInfoVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callSelect(param);
		List<PidInfoVo> list = (List<PidInfoVo>) param.get("list");
		return list;
	}
	
	@Transactional
	public Object edit(PidInfoVo vo) {
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
	public void submit(PidInfoVo vo){
		// 调用提交存储过程
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		dao.callSubmit(param);
		this.callAfter(param);
		//填写PID样机数量给特定人发送邮件
		if(vo.getPidyjsl() != null){
			sendEmail("0",vo.getId());
		}
		// 审批流处理
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		variables.put("id", vo.getId());// id
		variables.put("jggcsid", vo.getJggcs());//指定结构工程师id
		variables.put("dygcsid", vo.getDygcs());//指定电源工程师id
		variables.put("dzgcsid", vo.getDzgcs());//指定电子工程师id
		variables.put("xszz", UserUtils.getUser().getDeptCode());//提交人的销售组织
		// 判断是否驳回
		if(!("".equals(vo.getTaskId())) && !("null".equals(vo.getTaskId()))){
			// 驳回提交
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getPid());
			//变更单据开启变更审批流
			if(vo.getSfBg() == 1){
				processBean.setProcessKey("pidChange");
				processBean.setType("PID信息变更");//流程类型
			}else{
				processBean.setProcessKey("pidApply");
				processBean.setType("PID信息申请");//流程类型
			}
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processInstanceService.startProcessInstance(processBean);
		}
	}
	
	@Transactional
	public Object change(PidInfoVo vo) {
		vo = (PidInfoVo)this.callQueryById(vo.getId());
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<>();
		param.put("vo", vo);
		dao.callChange(param);
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public void approve(PidInfoVo vo) {
		this.callBefore(vo);
		// 完成当前节点审批
		Map<String, Object> variables = new HashMap<String, Object>();
		//获取自定义任务节点ID值，必须放在提交节点之前
		String taskKey = processTaskService.findTaskById(vo.getTaskId()).getTaskKey();
		if(vo.getApproveType() == 1){
			// 若PID审核专员岗则将PID补充信息进行保存
			/*if (taskKey != null && ("jggcs".equals(taskKey) || "dzgcs".equals(taskKey) || "dygcs".equals(taskKey))) {
				this.callBcxxSave(vo);
				vo.setApproveType(0);
			}*/
			// 若研发计划管理专员则更新计划完成时间
			if (taskKey != null && "yfjhglzy".equals(taskKey)){
				this.callJhwcsjSave(vo);
			}
			variables.put("out", "agree");
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else if(vo.getApproveType() == 2){
			variables.put("out", "reject");
			processTaskService.rejectTaskRestart(vo.getProcessId());
		}
		// 判断是不是终审
		boolean isEnd = processInstanceService.isProcessEnd(vo.getProcessId());
		if(isEnd && vo.getApproveType()==1){
			vo = (PidInfoVo)this.callQueryById(vo.getId());
			User user = UserUtils.getUser();
			vo.setZdrid(user.getLoginAcct());
			vo.setZdrmc(user.getUserName());
			vo.setApproveType(3);
			sendEmail("1",vo.getId());
		}
		// 调用审批存储过程(PID审核专员岗不用调用)
		if(vo.getApproveType() != 0){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", vo);
			dao.callApprove(param);
			this.callAfter(param);
		}
	}

	/**
	 * 发送邮件
	 * @param type 0：填写PID样机数量时，发给特定人发邮件； 1：PID审批结束后，给特定人发邮件
	 * @param id
	 */
	public void sendEmail(String type, String id){
		PidEmailVo  pidEmailVo = (PidEmailVo) this.callQueryEmailById(id);
		Map<String,Object> map = this.emailHelper(pidEmailVo, type);	
		List<PidReceiver> pidList1=pidEmailVo.getReceiverList1();
		List<PidReceiver> pidList0=pidEmailVo.getReceiverList0();
		if("1".equals(type)){
			for(PidReceiver or:pidList1){
				try {
					mimeMailService.sendEmail(or.getSjr(), map.get("subject").toString(), map.get("content").toString());
				} catch (Exception e) {
					EmailVo emailVo = new EmailVo();
					emailVo.setYwid(id);
					emailVo.setYwdh(pidEmailVo.getPid());
					emailVo.setYxdz(or.getSjr());
					emailVo.setName("PID申请");
					emailVo.setText(e.getMessage());
					emailDao.insert(emailVo);
				}
			}
		}else{
			for(PidReceiver or:pidList0){
				try {
					mimeMailService.sendEmail(or.getSjr(), map.get("subject").toString(), map.get("content").toString());
				} catch (Exception e) {
					EmailVo emailVo = new EmailVo();
					emailVo.setYwid(id);
					emailVo.setYwdh(pidEmailVo.getPid());
					emailVo.setYxdz(or.getSjr());
					emailVo.setName("PID申请");
					emailVo.setText(e.getMessage());
					emailDao.insert(emailVo);
				}
			}
		}
		
	}
	
	//取PID邮件内容
	@SuppressWarnings("unchecked")
	public Object callQueryEmailById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectEmail(param);
		List<PidReceiver> recevierList1=new ArrayList<PidReceiver>();
		List<PidReceiver> recevierList0=new ArrayList<PidReceiver>();
		recevierList1 = (List<PidReceiver>) param.get("recevierList1");
		recevierList0 = (List<PidReceiver>) param.get("recevierList0");
		List<PidEmailVo> list = (List<PidEmailVo>) param.get("list");
		PidEmailVo PidEmailVo=new PidEmailVo();
		if(list.size()>0){
			PidEmailVo=list.get(0);
			PidEmailVo.setReceiverList1(recevierList1);
			PidEmailVo.setReceiverList0(recevierList0);
		}	
		return PidEmailVo;
	}
	/**
	 * 组装发送邮件的正文
	 * @param pidEmailVo
	 * @param type 0：填写PID样机数量时，邮件的样式； 1：PID审批结束后，邮件的样式
	 * @return
	 */	
	private Map<String,Object> emailHelper(PidEmailVo pidEmailVo, String type){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> drlist=new ArrayList<String>();//收件人列表
		//邮件标题：[提交人姓名]|出货通知书|出货通知书编码|起运港|订单号|客户名称
		StringBuffer subject = new StringBuffer();//邮件主题
		StringBuffer content = new StringBuffer();//邮件正文
		String url_tmp=url+"/base-web/mdm/pidInfo/viewPage?id="+pidEmailVo.getId();
		//组装收件人列表
		if("1".equals(type)){
			List<PidReceiver> recevierList1=pidEmailVo.getReceiverList1();
			for(PidReceiver dr:recevierList1){
				drlist.add(dr.getSjr());
			}
		}else{
			List<PidReceiver> recevierList0=pidEmailVo.getReceiverList0();
			for(PidReceiver dr:recevierList0){
				drlist.add(dr.getSjr());
			}
		}
		//组装邮件主题
		subject.append("[PID申请流程");
		subject.append("]|");
		subject.append(pidEmailVo.getPid());
		subject.append("|");
		subject.append(pidEmailVo.getZdrmc());
		subject.append("|");
		subject.append(pidEmailVo.getKhmc());
		//组装邮件正文
		content.append("<p>");
		content.append("此邮件由系统自动发出，请勿回复。");
		content.append("</p>");
		content.append("业务基本信息<br/>");
		if("1".equals(type)){
			content.append("PID申请经理审批完成<br/>");
			content.append("申请人："+pidEmailVo.getZdrmc()+"<br/>");
			content.append("PID号："+pidEmailVo.getPid()+"<br/>");
			content.append("申请时间："+pidEmailVo.getCjsj()+"<br/>");
			content.append("客户名称："+pidEmailVo.getKhmc()+"<br/>");
			content.append("国家地区："+pidEmailVo.getXwgjmc()+"<br/>");
			content.append("机型："+pidEmailVo.getJixing()+"<br/>");
			content.append("机芯："+pidEmailVo.getJixin()+"<br/>");
			content.append("预计年产量："+pidEmailVo.getYjnxsl()+"<br/>");	
		}else{
			content.append("PID样机数量填写完成<br/>");
			content.append("申请人："+pidEmailVo.getZdrmc()+"<br/>");
			content.append("PID号："+pidEmailVo.getPid()+"<br/>");
			content.append("申请时间："+pidEmailVo.getCjsj()+"<br/>");
			content.append("客户名称："+pidEmailVo.getKhmc()+"<br/>");
			content.append("PID样机数量："+pidEmailVo.getPidyjsl() +"<br/>");
		}	
		content.append("点击查看详细信息：<a href='"+url_tmp+"'>"+subject.toString()+"</a><br/>");
		map.put("recevier", drlist);
		map.put("subject", subject.toString());
		map.put("content", content.toString());
		return map;
	}
	private Map<String, Object> save(PidInfoVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		return param;
	}
	
	//PID补充信息保存
	/*private Map<String, Object> callBcxxSave(PidInfoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callBcxxSave(param);
		this.callAfter(param);
		return param;
	}*/
	
	private Map<String, Object> callJhwcsjSave(PidInfoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callJhwcsjSave(param);
		this.callAfter(param);
		return param;
	}
	
	// 根据ID查询PID信息，推送SAP,供流程监听调用
	@SuppressWarnings("unchecked")
	public void tsSap(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		PidInfoVo vo = new PidInfoVo();
		param.put("id", id);
		dao.callSelectById(param);
		List<PidInfoVo> pidlist = (List<PidInfoVo>) param.get("list");
		if(pidlist.size() > 0){
			vo = pidlist.get(0);
		}else {
			throw new ServiceException("系统推送SAP时未找到PID信息！");
		}
		// 执行推送
		List<PidInfoMsgResponse> list;
		try {
			list = pushPidInfoToSAP(vo);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			throw e;
		}
		// 更改单据推送状态,循环保存推送返回信息日志
		savePidInfoTssapzt(vo,list);
	}
		
	/**
	 * PID 申请接口推送
	 * */
	// 推送SAP并且记录返信息货日志
	public void tsSapAndWriteLog(PidInfoVo vo) {
		// 执行推送
		List<PidInfoMsgResponse> list=pushPidInfoToSAP(vo);
		// 更改单据推送状态,循环保存推送返回信息日志
		savePidInfoTssapzt(vo,list);
	}
	
	//推送sap
	@Transactional
	private List<PidInfoMsgResponse> pushPidInfoToSAP(PidInfoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		iPidInfoDao.callSelectById(param);
		@SuppressWarnings("unchecked")
		List<PidInfoMsgResponse> bodyRequestList = (List<PidInfoMsgResponse>) param.get("list");
		List<PidInfoMsgResponse> listpidInfoMsg=null;
		// 调用sap接口
		if(bodyRequestList.size()>0){
			try {
				listpidInfoMsg = pidInfoInterfaceService.pidInfoSdoToSap(bodyRequestList);
			} catch (Exception e) {
				throw new ServiceException("调用SAP PID申请接口失败！");
			}
		}else{
			throw new ServiceException("PID申请接口取数为空,无法推送SAP！");
		}
		return listpidInfoMsg;
	}
	//保存返回日志
	private void savePidInfoTssapzt(PidInfoVo vo, List<PidInfoMsgResponse> list) {
		// 回写SAP状态  循环list
		for (PidInfoMsgResponse pidinfo : list) {
			int tssapzt = 0;
			Map<String, Object> param = new HashMap<String, Object>();
			if ("X".equals(pidinfo.getMsg())) {
				tssapzt = 1;
			}
			param.put("id", pidinfo.getId());
			param.put("sjc", vo.getSjc());
			param.put("tssapzt", tssapzt);
			
			try {
				dao.callSavePidInfoTssapzt(param);
				// 明细数据保存后
				this.callAfter(param);
				// 保存推送日志
				SapInterfaceLogVo logvo = new SapInterfaceLogVo();
				logvo.setId(pidinfo.getId());
				logvo.setDh(pidinfo.getPid());
				logvo.setMk("PID申请");
				logvo.setSj(new Date());
				logvo.setFhzt(tssapzt);
				logvo.setFhxx(pidinfo.getMsg());
				logvo.setBw(pidinfo.getInXml());
				try {
					sapInterfaceLogService.save(logvo);
				} catch (Exception e) {
					new ServiceException("保存SAP返回信息日志出错");
				}
			} catch (Exception e) {
				throw new ServiceException(param.get("resultMsg").toString());
			}
		}

	}
	
	/**
	 * 调用存储过程操作数据前
	 * 对一些必须字段赋值
	 * @param vo
	 */
	private void callBefore(PidInfoVo vo) {
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
	public void export(HttpServletResponse response, Map<String, Object> params, PidInfoVo vo){
		try {
			List<PidInfoVo> list = (List<PidInfoVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
}