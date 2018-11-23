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
import com.ey.piit.core.paginator.domain.PageJqGrid;
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
import com.ey.piit.sdo.art.repository.ArtoemDao;
import com.ey.piit.sdo.art.vo.ArtLogVo;
import com.ey.piit.sdo.art.vo.ArtSkyworthVo;
import com.ey.piit.sdo.art.vo.ArtoemVo;
import com.ey.piit.sdo.pub.repository.EmailDao;
import com.ey.piit.sdo.pub.vo.EmailVo;

/**
 * 美工任务单OEMService
 * 
 * @author 魏诚
 */
@Service
public class ArtoemService {
	
	@Autowired
	private ArtoemDao artoemDao;
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
	public Object callQueryByPage(ArtoemVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		param.put("page", page);
		artoemDao.callSelect(param);
		List<ArtoemVo> list = (List<ArtoemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(ArtoemVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		artoemDao.callSelect(param);
		List<ArtoemVo> list = (List<ArtoemVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		artoemDao.callSelectById(param);
		List<ArtoemVo> list = (List<ArtoemVo>) param.get("list");
		List<ArtoemVo> htylist = (List<ArtoemVo>) param.get("htylist");
		List<ArtLogVo> logList = (List<ArtLogVo>) param.get("logList");
		ArtoemVo vo = new ArtoemVo();
		if(list.size()>0){
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
		artoemDao.callSelectHtyByRwdh(param);
		List<ArtoemVo> list = (List<ArtoemVo>) param.get("list");
		List<ArtLogVo> logList = (List<ArtLogVo>) param.get("logList");
		ArtoemVo vo = new ArtoemVo();
		if(list.size()>0){
			vo = list.get(0);
			vo.setLogList(logList);
		}
		return vo;
	}
	
	@Transactional
	public Object edit(ArtoemVo vo) {
		// 数据保存前
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		// 数据保存后
		this.callAfter(param);
		return vo;
	}

	private Map<String, Object> save(ArtoemVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		artoemDao.callInsert(param);
		this.callAfter(param);
		return param;
	}
	
	@Transactional
	public Object submit(ArtoemVo vo) {
		this.callBefore(vo);
		//先保存订舱单
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		artoemDao.callSubmit(param);
		this.callAfter(param);
		
		//审批流处理
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "commit");
		variables.put("xsyid", vo.getXsyid());// 指定销售员进行审批
		variables.put("groupCode", vo.getYwz());// 指定销售组长的业务组
		variables.put("deptCode", vo.getXszz());//销售组织
		variables.put("cpjl", vo.getCpjl());// 产品经理
		//有勾选非标准化选项 则是1,都没有勾选则是0
		if(vo.getMkQt() == null && vo.getYkqQt() == null && vo.getSmsZsj() == null 
		   && (vo.getZxSjbz() == null || vo.getZxSjbz() != 5) && (vo.getZxtzZlbz() == null || vo.getZxtzZlbz() != 3 )
		   && (vo.getHgtzZlbz() == null || vo.getHgtzZlbz() != 3) && (vo.getBzkZlbz() == null || vo.getBzkZlbz() != 2)
		   && (vo.getZjxhtzXhbz() == null || vo.getZjxhtzXhbz() != 2)){
			variables.put("sfFbz", 0);
		}else{
			variables.put("sfFbz", 1);
		}
		// 判断是否驳回
		if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())) {
			// 驳回提交
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getRwdh());// 单号
			processBean.setProcessKey("artOEMCreate");// 流程ID
			processBean.setType("美工任务单(OEM&ODM)");// 业务类型：根据用户要求放文件编号
			processBean.setUserId(vo.getZdrid());
			processBean.setName(vo.getWjbh());
			// 判断是否变更
			if(vo.getSfBg() != null && vo.getSfBg() == 1){
				variables.put("sfLc", vo.getBgSflc()== 1 ? 1:0);
				processBean.setProcessKey("artOEMModify");
				processBean.setType("美工任务单(OEM&ODM)变更");//业务类型：根据用户要求放文件编号
				processBean.setName(vo.getWjbh());
			}
			processBean.setVariables(variables);
			
			processInstanceService.startProcessInstance(processBean);
		}
		return vo;
	}

	// 审核
	@Transactional
	public void approve(ArtoemVo vo) {
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
		artoemDao.callApprove(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void delete(String id, String sjc, int zt, String processId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		artoemDao.callDelete(param);
		this.callAfter(param);
		if(zt == 3 && !"".equals(processId)){
			processInstanceService.deleteProcessInstance(processId);
		}
	}
	
	@Transactional
	public void change(ArtoemVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		artoemDao.callChange(param);
		this.callAfter(param);
	}
	
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, ArtoemVo vo) {
		try {
			List<ArtSkyworthVo> list = (List<ArtSkyworthVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	@Transactional
	public void getback(ArtoemVo vo){
		// 删除审批流实例
		if(StringUtils.isNotBlank(vo.getProcessId())){
			processInstanceService.deleteProcessInstance(vo.getProcessId());
		}
		// 调用取回存储过程
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		artoemDao.callGetback(param);
		this.callAfter(param);
	}	

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(ArtoemVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setBgSqr(user.getLoginAcct());
		vo.setBgSqrmc(user.getLoginAcct());
		vo.setZdsj(new Date());
		vo.setBgSqsj(new Date());
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
	
	@Transactional
	public void bc(ArtoemVo vo) {
		//补充美工组件号和模板标识
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		artoemDao.callBc(param);
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
	private void saveTsSapLog(ArtoemVo vo, ArtMsgResponse artMsgResponse) {
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
		logvo.setMk("OEM美工任务单");
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
	 *美工任务单OEM取消
	 * @param vo
	 */
	@Transactional
	public void cancel(ArtoemVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		artoemDao.callCancel(param);
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
				emailVo.setName("OEM美工任务单取消通知");
				emailVo.setText(e.getMessage());
				emailDao.insert(emailVo);
			}
		}
		
		//美工任务单取消通知邮件内容
		@SuppressWarnings("unchecked")
		private List<ArtCancelReceiver> callQueryEmail() {
			Map<String, Object> param = new HashMap<String, Object>();
			artoemDao.callSelectEmail(param);
			List<ArtCancelReceiver> recevierList = (List<ArtCancelReceiver>) param.get("recevierList");
			return recevierList;
		}
		
		//组装发送邮件的正文
		private Map<String,Object> emailHelper(String id, String mgrwdh, List<ArtCancelReceiver> receiveList){
			//邮件标题：
			StringBuffer subject = new StringBuffer();//邮件主题
			StringBuffer content = new StringBuffer();//邮件正文
			String url_tmp=url+"/base-web/art/oem?id=" + id;
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
			content.append("OEM美工任务单："+mgrwdh+"已取消，请知悉！");
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