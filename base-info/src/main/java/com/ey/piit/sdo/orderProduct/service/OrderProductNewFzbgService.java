package com.ey.piit.sdo.orderProduct.service;

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
import com.ey.piit.interfaces.pidbom.service.PidBomInterfaceService;
import com.ey.piit.sdo.mdm.service.ProductBomService;
import com.ey.piit.sdo.order.entity.OrderReceiver;
import com.ey.piit.sdo.order.repository.OrderProductCkdDao;
import com.ey.piit.sdo.order.vo.OrderBgmxVo;
import com.ey.piit.sdo.order.vo.OrderEmailVo;
import com.ey.piit.sdo.order.vo.OrderLogVo;
import com.ey.piit.sdo.order.vo.OrderProductCkdVo;
import com.ey.piit.sdo.order.vo.OrderReferPiVo;
import com.ey.piit.sdo.orderProduct.repository.OrderProductNewDao;
import com.ey.piit.sdo.orderProduct.repository.OrderProductNewFzbgDao;
import com.ey.piit.sdo.orderProduct.vo.OrderProductNewVo;
import com.ey.piit.sdo.pub.repository.EmailDao;
import com.ey.piit.sdo.pub.vo.EmailVo;


/**
 * 大货订单辅助变更管理Service
 * 
 * @author tianrong
 */
@Service
public class OrderProductNewFzbgService {

	@Autowired
	private OrderProductNewFzbgDao dao;
	@Autowired
	private OrderProductNewDao odao;
	@Autowired
	private EmailDao emailDao;
	@Autowired
	private OrderProductCkdDao orderProductCkdDao;

	@Autowired
	private ExportUtil exportUtil;

	@Autowired
	private ProcessInstanceService processInstanceService;

	@Autowired
	private ProcessTaskService processTaskService;
	
	@Autowired
	private ProductBomService productBomService;
	
	@Autowired
	private PidBomInterfaceService pidBomInterfaceService;
	@Autowired
	private MimeMailService mimeMailService;//邮件服务类
    @Value("${email.url}")
    private String url;//项目访问路径
    
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(OrderProductNewVo vo, PageBounds page) {
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
		List<OrderProductNewVo> list = (List<OrderProductNewVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(OrderProductNewVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelect(param);
		List<OrderProductNewVo> list = (List<OrderProductNewVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<OrderProductNewVo> list = (List<OrderProductNewVo>) param.get("list");
		List<OrderReferPiVo> piList = (List<OrderReferPiVo>) param.get("piList");
		List<OrderProductCkdVo> wycckdist    = (List<OrderProductCkdVo>) param.get("ckdwycList");
		List<OrderProductCkdVo> yycckdist  = (List<OrderProductCkdVo>) param.get("ckdyycList");
		List<OrderLogVo> logList = (List<OrderLogVo>) param.get("logList");
		List<OrderBgmxVo> bgmxList = (List<OrderBgmxVo>) param.get("bgmxList");
		OrderProductNewVo vo = new OrderProductNewVo();
		if (list.size() > 0) {
			vo = list.get(0);
		}
		vo.setOrderReferPiList(piList);
		vo.setWycCkdList(wycckdist);
		vo.setYycCkdList(yycckdist);
		vo.setLogList(logList);
		vo.setBgmxList(bgmxList);
		return vo;
	}

	/**
	 * CKD 分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object queryCkdByPage(OrderProductCkdVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		orderProductCkdDao.callSelectByPage(param);
		List<OrderProductCkdVo> ckdwycList = (List<OrderProductCkdVo>) param.get("ckdwycList");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(ckdwycList, paginator);
	}

	@Transactional
	public Object edit(OrderProductNewVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		return vo;
	}

	@Transactional
	public void submit(OrderProductNewVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		dao.callSubmit(param);
		this.callAfter(param);
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("groupCode", vo.getYwz());// 指定销售组长的业务组
		variables.put("deptCode", vo.getXszz());//销售组织
		variables.put("xsyid", vo.getXsyid());// 指定销售员进行审批
		variables.put("out", "commit");
		variables.put("sftjbhr", vo.getSftjbhr());//是否提交到驳回人
		variables.put("xszz", vo.getXszz());
		variables.put("scjd", vo.getScjd());//流程判断条件：生产基地
		String sqr = UserUtils.hasRole("1-yx-xsy") ? "1-yx-xsy" : "0";
		variables.put("sqr", sqr);
		variables.put("sfNxyfcp", vo.getSfNxyfcp());//是否内销研发产品
		// 变更的字段类型 美工信息、物料信息、屏信息、交期信息、加工方式信息
		String[] fzxx = { "mgxx","wlxx","pxx","jqxx","jgfsxx","mgrwdh" };
		for (int j = 0; j < fzxx.length; j++) {
			if (variables.get(fzxx[j]) == null) {
				variables.put(fzxx[j], "0");
			}
		}
		//取字段类型，有的则是变更过的，需要将参数赋值为1
		dao.callCheckValue(param);
		if (param.get("changeResult") != null) {
			String changeResult = param.get("changeResult").toString();
			String[] results = changeResult.split(",");
			for (int i = 0; i < results.length; i++) {
				variables.put(results[i], "1");
			}
		}
		// 判断是否驳回
		if (!StringUtils.isEmpty(vo.getTaskId())&& !"null".equals(vo.getTaskId())) {
			// 驳回提交
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(),variables);
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getDdid()+"("+vo.getBbh()+")");
			processBean.setProcessKey("orderProductModify_fzxx_new");
			processBean.setType("大货订单-变更(辅助信息)");
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
			processInstanceService.startProcessInstance(processBean);
		}
	}
	
	/**
	 * 进行审核
	 * 流程中岗位为SMO-财务审核岗设置的id为smocwsh,岗位为应收风险专员设置的id为ysfxzy
	 * @param vo
	 */
	
	@SuppressWarnings("unchecked")
	@Transactional
	public OrderProductNewVo approve(OrderProductNewVo vo) {
		Map<String, Object> param2 = new HashMap<String, Object>();
		param2.put("id", vo.getId());
		dao.callSelectById(param2);
		List<OrderProductNewVo> list = (List<OrderProductNewVo>) param2.get("list");
		this.callBefore(vo);
		//设置流程参数
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("xszz", list.get(0).getXszz());
		//获取自定义任务节点ID值，必须放在提交节点之前
		int approveType = vo.getApproveType();
		// 完成当前节点审批
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
		if (isEnd && vo.getApproveType() == 3) {
			sendEmail(vo.getId(),2);
		}
		return vo;
	}
	//发送邮件zt:1 正常 2 变更
	public void sendEmail(String id,int zt){
		OrderEmailVo  orderEmailVo = (OrderEmailVo) this.callQueryEmailById(id,zt);
		Map<String,Object> map = this.emailHelper(orderEmailVo,zt);	
		List<OrderReceiver> orderList=orderEmailVo.getReceiverList();
		for(OrderReceiver or:orderList){
			try {
				mimeMailService.sendEmail(or.getSjr(), map.get("subject").toString(), map.get("content").toString());
			} catch (Exception e) {
				EmailVo emailVo = new EmailVo();
				emailVo.setYwid(id);
				emailVo.setYwdh(orderEmailVo.getDdid());
				emailVo.setYxdz(or.getSjr());
				if(zt == 1){
					emailVo.setName("大货订单");
				}else{
					emailVo.setName("大货订单辅助变更");
				}
				emailVo.setText(e.getMessage());
				emailDao.insert(emailVo);
				//throw new ServiceException(e.getMessage(),e);
			}
		}
	}
	
	//取订单邮件内容
	@SuppressWarnings("unchecked")
	public Object callQueryEmailById(String id,int zt) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("lx", 1);
		param.put("zt", zt);
		odao.callSelectEmail(param);
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
	private Map<String,Object> emailHelper(OrderEmailVo orderEmailVo,int zt){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> drlist=new ArrayList<String>();//收件人列表
		//邮件标题：[提交人姓名]|订单类型|订单号|客户名称
		StringBuffer subject = new StringBuffer();//邮件主题
		StringBuffer content = new StringBuffer();//邮件正文
		String url_tmp=url+"/base-web/orderfzbg/orderProductFzbg/viewPage?id="+orderEmailVo.getId();
		//组装收件人列表
		List<OrderReceiver> orderList=orderEmailVo.getReceiverList();
		for(OrderReceiver or:orderList){
			drlist.add(or.getSjr());
		}
		//组装邮件主题
		if(zt ==1){
			subject.append("[工作流][新任务]");
		}else{
			subject.append("[工作流][辅助变更新任务]");	
		}
		subject.append("提交人[");
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
		业务单据：大货订单
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
		content.append("机芯："+orderEmailVo.getJixin()+"<br/>");
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
	 * 订单保存（主明细）
	 * 
	 * @param vo
	 * @return
	 */
	private Map<String, Object> save(OrderProductNewVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		this.callAfter(param);
		return param;
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(OrderProductNewVo vo) {
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

	/**
	 * 订单信息导出
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, OrderProductNewVo vo) {
		try {
			List<OrderProductNewVo> list = (List<OrderProductNewVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	@Transactional
	public void change(OrderProductNewVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callChange(param);
		this.callAfter(param);
	}
	
	public void getback(OrderProductNewVo vo){
		DeleteProcess(vo);
		back(vo);
	}
	public void DeleteProcess(OrderProductNewVo vo) {
		// 1.删除流程实例
		try {
			processInstanceService.deleteProcessInstance(vo.getProcessId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional
	public void back(OrderProductNewVo vo) {
		//3.将状态置为1
		//4.写进订单的审批日志，说明取回人
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callGetback(param);
		this.callAfter(param);
	}
}