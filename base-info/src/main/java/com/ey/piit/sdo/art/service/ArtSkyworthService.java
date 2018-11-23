package com.ey.piit.sdo.art.service;

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
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.art.dto.ArtBodyDto;
import com.ey.piit.interfaces.art.dto.ArtMsgResponse;
import com.ey.piit.interfaces.art.service.ArtInterfaceService;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.sdo.art.entity.ArtCancelReceiver;
import com.ey.piit.sdo.art.repository.ArtSkyworthDao;
import com.ey.piit.sdo.art.vo.ArtLogVo;
import com.ey.piit.sdo.art.vo.ArtSkyworthVo;
import com.ey.piit.sdo.pub.repository.EmailDao;
import com.ey.piit.sdo.pub.vo.EmailVo;

/**
 * 美工订单Skyworth管理Service
 * 
 * @author tianrong
 */
@Service
public class ArtSkyworthService {

	@Autowired
	private ArtSkyworthDao dao;
	@Autowired
	private ExportUtil exportUtil;
	@Autowired
	private MimeMailService mimeMailService;//邮件服务类
	@Value("${email.url}")
    private String url;//项目访问路径
	@Autowired
	private EmailDao emailDao;
	@Autowired
	private ProcessInstanceService processInstanceService;
	@Autowired
	private ProcessTaskService processTaskService;
	// 推送sap
	@Autowired
	private ArtInterfaceService artInterfaceService;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;

	@SuppressWarnings("unchecked")
	public Object callQueryByPage(ArtSkyworthVo vo, PageBounds page) {
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
		List<ArtSkyworthVo> list = (List<ArtSkyworthVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(ArtSkyworthVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelect(param);
		List<ArtSkyworthVo> list = (List<ArtSkyworthVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public ArtSkyworthVo callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<ArtSkyworthVo> list = (List<ArtSkyworthVo>) param.get("list");
		List<ArtSkyworthVo> htylist = (List<ArtSkyworthVo>) param.get("htylist");
		List<ArtLogVo> logList = (List<ArtLogVo>) param.get("logList");
		ArtSkyworthVo vo = new ArtSkyworthVo() ;
		if(list.size() > 0){
			 vo = list.get(0);
			 vo.setLogList(logList);
			 vo.setHtylist(htylist);
		}
		return vo;
	}

	@SuppressWarnings("unchecked")
	public Object callQueryHtyByRwdh(String rwdh,Integer bbh) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("rwdh", rwdh);
		param.put("bbh", bbh);
		dao.callSelectHtyByRwdh(param);
		List<ArtSkyworthVo> list = (List<ArtSkyworthVo>) param.get("list");
		List<ArtLogVo> logList = (List<ArtLogVo>) param.get("logList");
		ArtSkyworthVo vo = new ArtSkyworthVo();
		if(list.size()>0){
			vo = list.get(0);
			vo.setLogList(logList);
		}
		return vo;
	}
	@Transactional
	public Object edit(ArtSkyworthVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public void submit(ArtSkyworthVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		dao.callSubmit(param);
		this.callAfter(param);
		/*
		 * 开启审批流程
		 */
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		variables.put("xsyid", vo.getXsyid());// 指定销售员进行审批
		variables.put("groupCode", vo.getYwz());// 指定销售组长的业务组
		variables.put("deptCode", vo.getXszz());//销售组织
		variables.put("cpjl", vo.getCpjl());// 产品经理
		//有美工其他要求时，说明是非标准项
		if(vo.getMgqtyq() == null || "".equals(vo.getMgqtyq())){
			variables.put("sfFbz", 0);
		}else{
			variables.put("sfFbz", 1);
		}
		if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())) {
			// 驳回提交
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getRwdh());
			processBean.setProcessKey("artSkyworthCreate");
			processBean.setType("美工任务单(SKYWORTH)");//业务类型：根据用户要求放文件编号
			processBean.setUserId(vo.getZdrid());
			processBean.setName(vo.getWjbh());
			// 判断是否变更
			if(vo.getSfBg() != null && vo.getSfBg() == 1){
				variables.put("sfLc", vo.getBgSflc()== 1 ? 1:0);
				processBean.setProcessKey("artSkyworthModify");
				processBean.setType("美工任务单(SKYWORTH)变更");//业务类型：根据用户要求放文件编号
				processBean.setName(vo.getWjbh());
			}
			processBean.setVariables(variables);
			processInstanceService.startProcessInstance(processBean);
		}
	}
	
	/**
	 * 进行审核
	 * @param vo
	 */
	@Transactional
	public ArtSkyworthVo approve(ArtSkyworthVo vo) {
		this.callBefore(vo);
		// 完成当前节点审批
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("gcjsb", vo.getGcjsb() == null? 0 : vo.getGcjsb());
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

	private Map<String, Object> save(ArtSkyworthVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callInsert(param);
		this.callAfter(param);
		return param;
	}
	
	@Transactional
	public void change(ArtSkyworthVo vo){
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
	private void callBefore(ArtSkyworthVo vo) {
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
	public void export(HttpServletResponse response, Map<String, Object> params, ArtSkyworthVo vo) {
		try {
			List<ArtSkyworthVo> list = (List<ArtSkyworthVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	public void getback(ArtSkyworthVo vo){
		DeleteProcess(vo);
		back(vo);
	}
	public void DeleteProcess(ArtSkyworthVo vo) {
		// 1.删除流程实例
		try {
			processInstanceService.deleteProcessInstance(vo.getProcessId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional
	public void back(ArtSkyworthVo vo) {
		//3.将状态置为1
		//4.写进订单的审批日志，说明取回人
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callGetback(param);
		this.callAfter(param);
	}

	@Transactional
	public void bc(ArtSkyworthVo vo) {
		//补充美工组件号和模板标识
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callBc(param);
		this.callAfter(param);
		// 推送sap
		List<ArtBodyDto> bodyList = new ArrayList<ArtBodyDto>();
		ArtBodyDto dto = new ArtBodyDto();
		dto.setSheetno(vo.getRwdh());
		dto.setMatnr(vo.getMgzjh());
		bodyList.add(dto);
		ArtMsgResponse artMsgResponse = null;
		// 调用sap接口
		try {
			artMsgResponse = artInterfaceService.artSdoToSap(bodyList);
		} catch (Exception e) {
			throw new ServiceException("调用SAP出库推送接口出错！");
		}
		// 保存推送日志
		this.saveTsSapLog(vo, artMsgResponse);
	}
	
	// 保存推送SAP日志
	private void saveTsSapLog(ArtSkyworthVo vo, ArtMsgResponse artMsgResponse) {
		if (vo == null) {
			throw new ServiceException("推送sap的vo为空");
		}
		if (artMsgResponse == null) {
			throw new ServiceException("推送sap返回信息为空");
		}
		// 保存推送日志
		SapInterfaceLogVo logvo = new SapInterfaceLogVo();
		logvo.setId(vo.getId());;
		logvo.setDh(vo.getRwdh());
		logvo.setMk("SKYWORTH美工任务单");
		logvo.setSj(new Date());
		if ("S".equals(artMsgResponse.getResult())) {
			logvo.setFhzt(1);
		} else {
			logvo.setFhzt(0);
		}
		logvo.setFhxx(artMsgResponse.getMsg());
		logvo.setBw(artMsgResponse.getInXml());
		try {
			sapInterfaceLogService.save(logvo);
		} catch (Exception e) {
			new ServiceException("保存SAP返回信息日志出错");
		}
	}

	/**
	 * 取消
	 * @param vo
	 */
	@Transactional
	public void cancel(ArtSkyworthVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callCancel(param);
		this.callAfter(param);
		this.sendEmail(vo.getId(), vo.getRwdh());
	}
	
	//发送邮件
	@SuppressWarnings({ "unchecked"})
	private void sendEmail(String id, String mgrwdh){
		List<ArtCancelReceiver> recevierList = this.callQueryEmail();
		Map<String,Object> map = this.emailHelper(id, mgrwdh, recevierList);	
		try {
			mimeMailService.sendEmail((List<String>)map.get("recevier"), map.get("subject").toString(), map.get("content").toString());
		}catch (Exception e) {
			EmailVo emailVo = new EmailVo();
			emailVo.setYwid(id);
			emailVo.setYwdh(mgrwdh);
			emailVo.setYxdz("");
			emailVo.setName("SKYWORTH美工任务单取消通知");
			emailVo.setText(e.getMessage());
			emailDao.insert(emailVo);
		}
	}
	
	//美工任务单取消通知邮件内容
	@SuppressWarnings("unchecked")
	private List<ArtCancelReceiver> callQueryEmail() {
		Map<String, Object> param = new HashMap<String, Object>();
		dao.callSelectEmail(param);
		List<ArtCancelReceiver> recevierList = (List<ArtCancelReceiver>) param.get("recevierList");
		return recevierList;
	}
	
	//组装发送邮件的正文
	private Map<String,Object> emailHelper(String id, String mgrwdh, List<ArtCancelReceiver> receiveList){
		//邮件标题：
		StringBuffer subject = new StringBuffer();//邮件主题
		StringBuffer content = new StringBuffer();//邮件正文
		String url_tmp=url+"/base-web/art/artSkyworth?id=" + id;
		//组装收件人列表
		List<String> drlist = new ArrayList<String>();//收件人列表
		for(ArtCancelReceiver dr : receiveList){
			drlist.add(dr.getSjr());
		}
		//组装邮件主题
		subject.append("【");
		subject.append("美工任务单取消通知");
		subject.append("】");
		//组装邮件正文
		content.append("<p>");
		content.append("SKYWORTH美工任务单："+mgrwdh+"已取消，请知悉！");
		content.append("</p>");
		content.append("<p>");
		content.append("此邮件由系统自动发出，请勿回复。");
		content.append("</p>");
		content.append("点击查看详细信息：<a href='"+url_tmp+"'>"+subject.toString()+"</a><br/>");

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("recevier", drlist);
		map.put("subject", subject.toString());
		map.put("content", content.toString());
		return map;
	}
}