package com.ey.piit.sdo.pso.service;

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

import com.ey.piit.basebpm.common.Constants;
import com.ey.piit.basebpm.entity.ProcessBean;
import com.ey.piit.basebpm.service.ProcessInstanceService;
import com.ey.piit.basebpm.service.ProcessTaskService;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.service.MimeMailService;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.deliver.vo.DeliverItemVo;
import com.ey.piit.sdo.payment.service.PayValidateService;
import com.ey.piit.sdo.payment.vo.PayValidateVo;
import com.ey.piit.sdo.pso.entity.PsoReceiver;
import com.ey.piit.sdo.pso.entity.PsoReferOrder;
import com.ey.piit.sdo.pso.repository.PsoDao;
import com.ey.piit.sdo.pso.repository.PsoExhibitionDao;
import com.ey.piit.sdo.pso.repository.PsoItemDao;
import com.ey.piit.sdo.pso.repository.PsoNotifyDao;
import com.ey.piit.sdo.pso.repository.PsoOtherDao;
import com.ey.piit.sdo.pso.repository.PsoPiDao;
import com.ey.piit.sdo.pso.vo.PsoEmailVo;
import com.ey.piit.sdo.pso.vo.PsoExhibitionVo;
import com.ey.piit.sdo.pso.vo.PsoItemVo;
import com.ey.piit.sdo.pso.vo.PsoLogVo;
import com.ey.piit.sdo.pso.vo.PsoNotifyVo;
import com.ey.piit.sdo.pso.vo.PsoOtherVo;
import com.ey.piit.sdo.pso.vo.PsoPiVo;
import com.ey.piit.sdo.pso.vo.PsoVo;
import com.ey.piit.sdo.pub.repository.EmailDao;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.pub.vo.EmailVo;
import com.google.common.collect.Maps;

/**
 * 预走货Service
 * 
 * @author 赵桃军
 */
@Service
@Transactional(readOnly = true)
public class PsoService {
	@Autowired
	private PsoDao psoDao;

	@Autowired
	private PsoItemDao psoItemDao;
	
	@Autowired
	private PsoPiDao psoPiDao;

	@Autowired
	private PsoOtherDao psoOtherDao;

	@Autowired
	private PsoNotifyDao psoNotifyDao;
	
	@Autowired
	private PsoExhibitionDao psoExhibitionDao;
	
	@Autowired
	private EmailDao emailDao;

	@Autowired
	private ExportUtil exportUtil;

	@Autowired
	private ProcessInstanceService processInstanceService;

	@Autowired
	private ProcessTaskService processTaskService;
	
	@Autowired
	private PayValidateService payValidateService;
	
	@Autowired
	private MimeMailService mimeMailService;//邮件服务类
	
	@Value("${email.url}")
    private String url;//项目访问路径

	@SuppressWarnings("unchecked")
	public Object callQueryByPage(PsoVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		psoDao.callSelect(param);
		List<PsoVo> list = (List<PsoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	@SuppressWarnings("unchecked")
	public Object callQueryCyblByPage(PsoVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		param.put("page", page);
		psoDao.callCyblSelect(param); 
		List<PsoVo> list = (List<PsoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQueryCwfpByPage(PsoVo vo, PageBounds page) {
		//设置船务专员id,使得船务专员只能查询到属于自己的船务分派
		/*User user = UserUtils.getUser();
	    vo.setCwzyid(user.getLoginAcct());*/
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		psoDao.callSelectCwfp(param);
		List<PsoVo> list = (List<PsoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(PsoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		psoDao.callSelect(param);
		List<PsoVo> list = (List<PsoVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public PsoVo callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		psoDao.callSelectById(param);
		List<PsoVo> list = (List<PsoVo>) param.get("list");
		List<PsoItemVo> itemList = (List<PsoItemVo>) param.get("itemList");
		List<PsoPiVo> piList = (List<PsoPiVo>) param.get("piList");
		List<PsoOtherVo> otherList = (List<PsoOtherVo>) param.get("otherList");
		List<PsoNotifyVo> notifyList = (List<PsoNotifyVo>) param.get("notifyList");
		List<PsoExhibitionVo> exhibitionList = (List<PsoExhibitionVo>) param.get("exhibitionList");
		List<PsoLogVo> logList = (List<PsoLogVo>) param.get("logList");
		PsoVo vo  = new PsoVo();
		if(list.size()>0){
			vo= list.get(0);
			vo.setPsoItemList(itemList);
			vo.setPsoPiList(piList);
			vo.setPsoOtherList(otherList);
			vo.setPsoNotifyList(notifyList);
			vo.setPsoExhibitionList(exhibitionList);
			vo.setLogList(logList);
		}
		return vo;
	}

	@Transactional
	public Object edit(PsoVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		return vo;
	}
	
	//根据预走货类型设置process id
	public void setProcidByYzhlx(PsoVo vo,ProcessBean processBean){
		// 根据不同的预走货类型走不用的审批流
		if ("1".equals(vo.getYzhlx())) {
			// 大货预走货
			processBean.setProcessKey("psoProduct");
			processBean.setType("大货预走货");// 流程类型
		} else if ("2".equals(vo.getYzhlx())) {
			// 备损预走货
			processBean.setProcessKey("psoSpo");
			processBean.setType("备损预走货");// 流程类型
		} else if ("3".equals(vo.getYzhlx())) {
			// 样机预走货
			processBean.setProcessKey("psoSample");
			processBean.setType("样机预走货");// 流程类型
		} else if ("4".equals(vo.getYzhlx())) {
			// 多元化预走货
			processBean.setProcessKey("psoDiversity");
			processBean.setType("多元化预走货");// 流程类型
		} else if ("5".equals(vo.getYzhlx())) {
			// 多元化屏预走货
			processBean.setProcessKey("psoDiversityScreen");
			processBean.setType("多元化屏预走货");// 流程类型
		} else if ("6".equals(vo.getYzhlx())) {
			// 多元化预走货
			processBean.setProcessKey("psoSMODiversity");
			processBean.setType("SMO多元化预走货");// 流程类型
		} else if ("7".equals(vo.getYzhlx())||"8".equals(vo.getYzhlx())||"9".equals(vo.getYzhlx())||"10".equals(vo.getYzhlx())) {
			// 副营预走货 同大货预走货流程
			processBean.setProcessKey("psoFy");
			processBean.setType("副营预走货");// 流程类型
		}
	}

	// 开启审批流
	public void openProcess(String id) {
		boolean flag = processInstanceService.isHaveProcessRunning(id);
		//如果业务ID对应已开启流程实例，则不开启
		if(!flag){
			PsoVo vo = this.callQueryById(id);
			// 审批流处理开始，设置流程参数
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("out", "commit");
			variables.put("fycd", vo.getYfcd());//费用承担
			variables.put("xszz", vo.getXszz());//销售组织
			variables.put("groupCode", vo.getYwz());//指点销售组长的业务组
			variables.put("xsyid", vo.getXsyid());//指定销售员ID
			variables.put("id", vo.getId());// 订单ID（付款保障用）
			variables.put("jclx", "pso");// 检查类型为预走货（付款保障用）
			variables.put("khbm", vo.getKhbm());//客户编码（应收超期用）
			variables.put("yzhdh", vo.getYzhdh());//预走货单号（应收超期用）
			variables.put("khlx", vo.getKhlx());//客户类型
			variables.put("fqrxszz", UserUtils.getUser().getDeptCode());//发起人的销售组织
			variables.put("sfBd", vo.getSfBd()==null?"0":vo.getSfBd());//是否白电
			//variables.put("yssfcq", vo.getYssfcq());//应收是否超期（应收超期用）
			// 判断船务是否分派
			if(StringUtils.isEmpty(vo.getCwzyid())){
				variables.put("sffp", 0);//未分派
			} else {
				variables.put("sffp", 1);//已分派
				variables.put("cwzyid", vo.getCwzyid());
			}
		
			ProcessBean processBean = new ProcessBean();
			//根据不同类型的预走货设置processid
			setProcidByYzhlx(vo, processBean);
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getYzhdh());
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
			processInstanceService.startProcessInstance(processBean);
		}
	
	}

	// 提交
	@Transactional
	public void submit(PsoVo vo) {
		//当选择储运进行补录时，将之前的cysfbl状态设置为0; sfcybl 为页面选择传过来的值，cysfbl为后台处理后传回值
		if(vo.getSfCybl() == 1){
			vo.setCysfbl(0);
		}
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		psoDao.callSubmit(param);
		this.callAfter(param);
		if(vo.getSfBg() != null && vo.getSfBg() == 1 && vo.getSfCybl() == 0 && vo.getZt() != 3){
			// 变更且选择储运不补录直接开启审批且不为驳回时
			this.openProcess(vo.getId());
		} else {
			/**
			 * 判断是否需要储运补录
			 * 需要则不开启审批流
			 * 不需要则开启审批流
			 */
			if(vo.getCysfbl() != 1 && (StringUtils.isEmpty(vo.getTaskId()) ||"null".equals(vo.getTaskId()))){
				this.openProcess(vo.getId());
			}else if(!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())){
				/**
				 * 驳回提交
				 * 选择重新开始审批还是提交到驳回分支(需知驳回节点)
				 */
				Map<String,String> map = Maps.newHashMap();
				Map<String, Object> variables = new HashMap<String, Object>();
				/*
				 * 暂时去掉继续审批选择，都重新审批，恢复时反向替换回去再
				 * vo.getSfRestart1()替换为"restart"
				 * vo.getSfRestart2()替换为"restart"
				 * 2018-6-12  魏诚
				 */
				if ("1".equals(vo.getYzhlx())) {
					// 大货预走货
					map.put("sffpzy,cwzg,cwzy", "restart");
					map.put("sfxszz,xsy,xszz,ysfxzy", "restart");
				} else if ("2".equals(vo.getYzhlx())) {
					// 备损预走货
					map.put("sffpzy,cwzg,cwzy,jsfwbzj", "restart");
					map.put("sfxszz,xsy,xszz,ysfxzy", "restart");
				} else if ("3".equals(vo.getYzhlx())) {
					// 样机预走货
					map.put("sffpzy,cwzg,cwzy", "restart");
					map.put("sfxszz,xsy,xszz,ysfxzy,hwcpjl", "restart");
				} else if ("4".equals(vo.getYzhlx())) {
					// 多元化预走货
					map.put("dyhywzg,ysfxzy", "restart");
					map.put("sffpzy,cwzg,cwzy", "restart");
				} else if ("5".equals(vo.getYzhlx())) {
					// 多元化屏预走货
					map.put("ysfxzy", "restart");
					map.put("sffpzy,cwzg,cwzy", "restart");
				} else if ("6".equals(vo.getYzhlx())) {
					// SMO多元化预走货
					map.put("dyhywzg,ysfxzy", "restart");
					map.put("smocwzy", "restart");
				} else if ("7".equals(vo.getYzhlx())||"8".equals(vo.getYzhlx())||"9".equals(vo.getYzhlx())||"10".equals(vo.getYzhlx())) {
					// 副营预走货，同大货
					map.put("sffpzy,cwzg,cwzy", "restart");
					map.put("sfxszz,xsy,xszz,ysfxzy", "restart");
				}
				variables.put(Constants.VAR_KEY_SEL_ACTIVITY_IDS, map);
				processTaskService.completeTaskSelect(vo.getTaskId(), vo.getZdrid(), variables);
			}
		}
	}
	
	/**
	 * 这个方法是为了防止终审的时候PsoApproveListener
	 * 调approve和本身的approve事物嵌套的问题
	 * @param vo
	 * @return
	 */
	public PsoVo listenerApprove(PsoVo vo) throws Exception{
		PsoVo votemp = this.callQueryById(vo.getId());
		vo.setSjc(votemp.getSjc());
		this.callBefore(vo);
		// 完成当前节点审批
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("xszz", votemp.getXszz());//销售组织
		if (vo.getApproveType() == 3) {
			Map<String, Object> param = new HashMap<String, Object>();
			User user = UserUtils.getUser();
			votemp.setZdrid(user.getLoginAcct());
			votemp.setZdrmc(user.getUserName());
			votemp.setApproveType(3);
			param.put("vo", votemp);
			psoDao.callApprove(param);
			//this.callAfter(param);
			if (!"SDO-000000".equals(param.get("resultCode").toString())) {
				throw new Exception(param.get("resultMsg").toString());
			}
		}
		return vo;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public PsoVo approve(PsoVo vo) {
		PsoVo votemp = this.callQueryById(vo.getId());
		vo.setSjc(votemp.getSjc());
		this.callBefore(vo);
		// 完成当前节点审批
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("xszz", votemp.getXszz());//销售组织
		variables.put("khlx", votemp.getKhlx());
		if (vo.getApproveType() == 1) {
			if(!StringUtils.isEmpty(vo.getCwzyid())){
				variables.put("cwzyid", vo.getCwzyid());//船务专员
			} else {
				variables.put("cwzyid", votemp.getCwzyid());//船务专员
			}
			// 如果是船务预处理信息不为空，则更新船务预处理信息
			if(vo.getCwsfcl() != null && vo.getCwsfcl() == 1){
				this.callCwyclSave(vo);
				//发送邮件
				if(!StringUtils.isEmpty(vo.getYjcwzyid())){
					sendEmail(vo.getId(), vo.getYjcwzyid());
				}
				vo.setApproveType(0);
			} else if(!StringUtils.isEmpty(vo.getCwzyid())){
				// 如果是船务分派节点提交
				Map<String, Object> param = new HashMap<String, Object>();
				this.callBefore(vo);
				param.put("vo", vo);
				psoDao.callSaveCwfp(param);
				this.callAfter(param);
				vo.setApproveType(0);
			}
			//船务预处理和船务分派不用调用审批过程
			if(vo.getApproveType() != 0){
				Map<String, Object> param = new HashMap<String, Object>();
			    param.put("vo", vo);
				psoDao.callApprove(param);
				this.callAfter(param);
			}
			variables.put("out", "agree");
			try {
				processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
			} catch (Exception e) {
				throw new ServiceException(e.getMessage());
			}
			
			//返回付款保障日志到前台
			List<PayValidateVo> logList = (List<PayValidateVo>) payValidateService.payCheckSelectLog(vo.getId());
			if(logList.size() > 0){
				PsoVo volog = this.callQueryById(vo.getId());
				if(volog.getFkbzzt() == null || volog.getFkbzzt() == 0){//客户应收超期（客户没有进行特批，没有进行付款保障检查）或付款保障不通过
					vo.setResult("0");
				}else{
					vo.setResult("1");
				}
				vo.setMsg(logList.get(0).getZy());
			}
			return vo;//没有走到最后的提交审批监听，不能走之后的代码
		} else if (vo.getApproveType() == 2) {
			Map<String, Object> param = new HashMap<String, Object>();
			variables.put("out", "reject");
			processTaskService.rejectTaskSelect(vo.getProcessId());
			param.put("vo", vo);
			psoDao.callApprove(param);
			this.callAfter(param);
		} else if (vo.getApproveType() == 3) {
			Map<String, Object> param = new HashMap<String, Object>();
			User user = UserUtils.getUser();
			votemp.setZdrid(user.getLoginAcct());
			votemp.setZdrmc(user.getUserName());
			votemp.setApproveType(3);
			param.put("vo", votemp);
			psoDao.callApprove(param);
			this.callAfter(param);
		}
		return vo;
	}
	
	/**
	 * 船务专员发送邮件
	 * @param id 业务ID
	 * @param yjcwzyid 需发送邮件的船务专员ID
	 */
	public void sendEmail(String id, String yjcwzyid){
		PsoEmailVo  psoEmailVo = (PsoEmailVo) this.callQueryEmailById(id, yjcwzyid);
		Map<String,Object> map = this.emailHelper(psoEmailVo);	
		List<PsoReceiver> psoList=psoEmailVo.getReceiverList();
		for(PsoReceiver or:psoList){
			try {
				mimeMailService.sendEmail(or.getSjr(), map.get("subject").toString(), map.get("content").toString());
			} catch (Exception e) {
				EmailVo emailVo = new EmailVo();
				emailVo.setYwid(id);
				emailVo.setYwdh(psoEmailVo.getYzhdh());
				emailVo.setYxdz(or.getSjr());
				emailVo.setName("商业发票制单提醒邮件");
				emailVo.setText(e.getMessage());
				emailDao.insert(emailVo);
			}
		}
	}
	//取邮件内容
	@SuppressWarnings("unchecked")
	public Object callQueryEmailById(String id, String yjcwzyid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("yjcwzyid", yjcwzyid);
		psoDao.callSelectEmail(param);
		List<PsoReceiver> recevierList=new ArrayList<PsoReceiver>();
		recevierList = (List<PsoReceiver>) param.get("recevierList");
		List<PsoEmailVo> list = (List<PsoEmailVo>) param.get("list");
		PsoEmailVo psoEmailVo=new PsoEmailVo();
		if(list.size()>0){
			psoEmailVo=list.get(0);
			psoEmailVo.setReceiverList(recevierList);
		}	
		return psoEmailVo;
	}
	//组装发送邮件的正文
	private Map<String,Object> emailHelper(PsoEmailVo psoEmailVo){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> drlist=new ArrayList<String>();//收件人列表
		//邮件标题：[提交人姓名]|出货通知书|出货通知书编码|起运港|订单号|客户名称
		StringBuffer subject = new StringBuffer();//邮件主题
		StringBuffer content = new StringBuffer();//邮件正文
		String url_tmp=url+"/base-web";
		//组装收件人列表
		List<PsoReceiver> recevierList=psoEmailVo.getReceiverList();
		for(PsoReceiver dr:recevierList){
			drlist.add(dr.getSjr());
		}
		//组装邮件主题
		subject.append("[商业发票制单提醒");
		subject.append("]|");
		subject.append(psoEmailVo.getYzhdh());
		subject.append("|");
		subject.append(psoEmailVo.getKhmc());
		subject.append("|");
		subject.append(psoEmailVo.getCwzymc());
		//组装邮件正文
		content.append("<p>");
		content.append("此邮件由系统自动发出，请勿回复。");
		content.append("</p>");
		content.append("业务基本信息<br/>");
		content.append("业务单据：商业发票制单提醒<br/>");
		content.append("预走货单号："+psoEmailVo.getYzhdh()+"<br/>");
		content.append("客户名称："+psoEmailVo.getKhmc()+"<br/>");
		content.append("船务提交人："+psoEmailVo.getCwzymc()+"<br/>");
		content.append("提交时间："+psoEmailVo.getZdsj() +"<br/>");
		content.append("点击查看详细信息：<a href='"+url_tmp+"'>"+subject.toString()+"</a><br/>");
		map.put("recevier", drlist);
		map.put("subject", subject.toString());
		map.put("content", content.toString());
		return map;
	}
	@Transactional
	public void delete(String id, String sjc, int zt, String processId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		psoDao.callDelete(param);
		this.callAfter(param);
		if(zt == 3 && !"".equals(processId)){
			processInstanceService.deleteProcessInstance(processId);
		}
		
	}

	private Map<String, Object> save(PsoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		this.callBefore(vo);
		psoDao.callInsert(param);
		this.callAfter(param);
		// 循环插入PSO明细表
		for (PsoItemVo psoItemVo : vo.getPsoItemList()) {
			psoItemVo.setYzhdh(vo.getYzhdh());
			psoItemVo.setBbh(vo.getBbh());
			psoItemVo.setId(Identities.uuid());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", psoItemVo);
			psoItemDao.callInsert(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		for (PsoPiVo psoPiVo : vo.getPsoPiList()) {
			psoPiVo.setYzhdh(vo.getYzhdh());
			psoPiVo.setBbh(vo.getBbh());
			psoPiVo.setId(Identities.uuid());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", psoPiVo);
			psoPiDao.callInsert(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		// 循环插入PSO明细表 费用明细
		for (PsoOtherVo psoOtherVo : vo.getPsoOtherList()) {
			psoOtherVo.setYzhdh(vo.getYzhdh());
			psoOtherVo.setBbh(vo.getBbh());
			psoOtherVo.setId(Identities.uuid());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", psoOtherVo);
			psoOtherDao.callInsert(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		//费用明细 自动生成保费 2017-05-02 邓海
		PsoOtherVo psoOtherVo = new PsoOtherVo();
		psoOtherVo.setYzhdh(vo.getYzhdh());
		psoOtherVo.setBbh(vo.getBbh());
		psoOtherVo.setId(Identities.uuid());
		Map<String, Object> dtlOtherParam = new HashMap<String, Object>();
		dtlOtherParam.put("vo", psoOtherVo);
		psoOtherDao.callInsertBf(dtlOtherParam);
		// 明细数据保存后
		this.callAfter(dtlOtherParam);
		
		List<PsoNotifyVo> list = vo.getPsoNotifyList();
		// 循环插入PSO明细表
		for (int i = 0; i < list.size(); i++) {
			PsoNotifyVo psoNotityVo = list.get(i);
			psoNotityVo.setYzhdh(vo.getYzhdh());
			psoNotityVo.setBbh(vo.getBbh());
			psoNotityVo.setId(Identities.uuid());
			psoNotityVo.setXh(i + 1);
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", psoNotityVo);
			psoNotifyDao.callInsert(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		
		List<PsoExhibitionVo> exhibitionList = vo.getPsoExhibitionList();
		// 循环插入PSO明细表
		for (int i = 0; i < exhibitionList.size(); i++) {
			PsoExhibitionVo psoExhibitionVo = exhibitionList.get(i);
			psoExhibitionVo.setYzhdh(vo.getYzhdh());
			psoExhibitionVo.setBbh(vo.getBbh());
			if(StringUtils.isEmpty(psoExhibitionVo.getId())){
				psoExhibitionVo.setId(Identities.uuid());
			}
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", psoExhibitionVo);
			psoExhibitionDao.callInsert(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		return param;
	}
	
	/**
	 * 批量更新费用明细表 出货通知书有调用此方法
	 * @param psoOtherVoList
	 */
	public void updateOther(List<DeliverItemVo> deliverItemVoList,List<PsoOtherVo> psoOtherVoList){
		//清除预走货对应的费用明细
		for (DeliverItemVo deliverItemVo : deliverItemVoList) {
			Map<String, Object> dtlParam1 = new HashMap<String, Object>();
			dtlParam1.put("yzhdh", deliverItemVo.getYzhdh());
			psoOtherDao.callDeleteOther(dtlParam1);
			this.callAfter(dtlParam1);
		}
		//更新插入
		for (PsoOtherVo psoOtherVo : psoOtherVoList) {
			if(StringUtils.isEmpty(psoOtherVo.getId())){
				psoOtherVo.setId(Identities.uuid());
			}
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", psoOtherVo);
			psoOtherDao.callUpdateOther(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
	}
	
	@Transactional
	public void cancel(PsoVo vo, Integer type){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("type", type);
		psoDao.callCancel(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void change(PsoVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		psoDao.callChange(param);
		this.callAfter(param);
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(PsoVo vo) {
		if (StringUtils.isEmpty(vo.getId())) {
			vo.preInsert();
		} else {
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
	private void callAfter(Map<String, Object> param) {
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}

	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, PsoVo vo) {
		try {
			List<PsoVo> list = (List<PsoVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	// 储运补录保存
	public void callCyblSave(PsoVo vo) {
		PsoVo votemp = this.callQueryById(vo.getId());
		int zt = votemp.getZt();
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		psoDao.callCyblSave(param);
		this.callAfter(param);
		if(zt != 3){
			//单据状态不为驳回时，开启审批流
			this.openProcess(vo.getId());
		}
	}
    //船务分派保存
	@Transactional
	public Object editCwfp(PsoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		psoDao.callSaveCwfp(param);
		this.callAfter(param);
		return vo;
	}
	//船务预处理保存
	private Map<String, Object> callCwyclSave(PsoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		psoDao.callCwyclSave(param);
		this.callAfter(param);
		return param;
	}
	//预走货应收超期结果保存
	@Transactional
	public Object callPsoYscqSave(PsoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		psoDao.callPsoYscqSave(param);
		this.callAfter(param);
		return param;
	}
	
	/**
	 * 预走货选择订单查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryDdxxByPage(PsoReferOrder vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		psoDao.callQueryDdxxByPage(param);
		List<PsoReferOrder> list = (List<PsoReferOrder>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 预走货所选订单的PI信息查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQuerySpoReferPixx(PsoReferOrder vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		psoDao.callQuerySpoReferPixx(param);
		List<PsoPiVo> list = (List<PsoPiVo>) param.get("list");
		return list;
	}
	/**
	 * SMO审核处理
	 * @param id
	 * @return
	 */
	@Transactional
	public Object smoApprove(PsoVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		psoDao.callSmoApprove(param);
		this.callAfter(param);
		return param;
	}

	public void getback(PsoVo vo){
		DeleteProcess(vo);
		back(vo);
	}
	public void DeleteProcess(PsoVo vo) {
		// 1.删除流程实例
		try {
			if(StringUtils.isNotBlank(vo.getProcessId())){
				processInstanceService.deleteProcessInstance(vo.getProcessId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional
	public void back(PsoVo vo) {
		//2.根据付款保障状态判断是否需要取消付款保障
		//3.将状态置为1
		//4.写进订单的审批日志，说明取回人
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		psoDao.callGetback(param);
		this.callAfter(param);
	}
	@SuppressWarnings("unchecked")
	public Object callQueryYzhxxByPage(PsoVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		psoDao.callSelectYzhxx(param);
		List<PsoVo> list = (List<PsoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	//查询预走货是否含有收费的订单
	public Map<String, Object> callQueryPsoFree(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		psoDao.callQueryPsoFree(param);
		return param;
	}
}