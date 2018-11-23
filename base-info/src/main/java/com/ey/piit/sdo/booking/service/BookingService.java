package com.ey.piit.sdo.booking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.delay.dto.DelayMsgRequest;
import com.ey.piit.interfaces.delay.dto.DelayMsgResponse;
import com.ey.piit.interfaces.delay.service.DelayInterfaceService;
import com.ey.piit.sdo.booking.entity.BookingReceiver;
import com.ey.piit.sdo.booking.repository.BookingDao;
import com.ey.piit.sdo.booking.repository.BookingItemDao;
import com.ey.piit.sdo.booking.vo.BookingEmailVo;
import com.ey.piit.sdo.booking.vo.BookingItemVo;
import com.ey.piit.sdo.booking.vo.BookingLogVo;
import com.ey.piit.sdo.booking.vo.BookingVo;
import com.ey.piit.sdo.order.vo.OrderProductVo;
import com.ey.piit.sdo.payment.service.PayValidateService;
import com.ey.piit.sdo.pso.vo.PsoVo;
import com.ey.piit.sdo.pub.repository.EmailDao;
import com.ey.piit.sdo.pub.vo.EmailVo;

/**
 * 订舱通知书Service
 * 
 * @author 赵明
 */
@Service
public class BookingService {

	@Autowired
	private BookingItemDao bookingItemDao;
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private EmailDao emailDao;
	@Autowired
	private DelayInterfaceService elayInterfaceService;
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
	public Object callQueryByPage(BookingVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		param.put("page", page);
		bookingDao.callSelect(param);
		List<BookingVo> list = (List<BookingVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		bookingDao.callSelectById(param);
		List<BookingVo> list = (List<BookingVo>) param.get("list");
		List<BookingItemVo> bookingList = (List<BookingItemVo>) param.get("bookingList");
		List<BookingLogVo> logList = (List<BookingLogVo>) param.get("logList");
		BookingVo vo=new BookingVo();
		if(list.size()>0){
			vo = list.get(0);
			vo.setBookingItemList(bookingList);
			vo.setLogList(logList);
		}
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryKtyzh(String yzhdh) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("yzhdh", yzhdh);
		bookingDao.callSelectKtyzh(param);
		List<PsoVo> list = (List<PsoVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object callQueryByYzhdhs(String ids) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ids", ids);
		bookingDao.callSelectByYzhdhs(param);
		List<BookingVo> list = (List<BookingVo>) param.get("list");
		List<BookingItemVo> bookingList = (List<BookingItemVo>) param.get("bookingList");
		BookingVo vo = list.get(0);
		vo.setBookingItemList(bookingList);
		return vo;
	}

	@Transactional
	public Object edit(BookingVo vo) {
		// 数据保存前
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		// 数据保存后
		this.callAfter(param);
		return vo;
	}

	@Transactional
	public void delete(String id, String sjc,int zt,String processId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		bookingDao.callDelete(param);
		this.callAfter(param);
		if(zt == 3 && !"".equals(processId)){
			processInstanceService.deleteProcessInstance(processId);
		}
	}

	private Map<String, Object> save(BookingVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		bookingDao.callInsert(param);
		this.callAfter(param);
		// 循环插入订单关联PI
		for (BookingItemVo bookingItem : vo.getBookingItemList()) {
			bookingItem.setDcdh(vo.getDcdh());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", bookingItem);
			bookingItemDao.callInsert(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		return param;
	}

	@Transactional
	public Object submit(BookingVo vo) {
		this.callBefore(vo);
		//先保存订舱单
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		if("D001".equals(vo.getKhlx().toString())){
			//若客户类型为分公司客户，则默认没有应收超期，将状态设置为5
			vo.setZt(5);
			vo.setYssfcq(0);
			vo.setNr("该客户属于品牌分公司客户，默认无应收超期！");
			this.callYscqSave(vo);
		}else{
			// 检查客户应收超期
			Map<String, Object> result = this.checkYscq(vo);
			if("0".equals(result.get("result"))){
				//若没有应收超期，则将状态设置为5
				vo.setZt(5);
			}else if("1".equals(result.get("result"))){
				//应收超期，则将状态设置为2
				vo.setZt(2);
				// 应收超期发送邮件
				sendEmail(vo.getId(),result.get("message").toString());
			}
			// 更新应收是否超期
			vo.setYssfcq(Integer.parseInt(result.get("result").toString()));
			vo.setNr(result.get("message").toString());
			this.callYscqSave(vo);
			if(vo.getYssfcq()== 1){//应收超期
				vo.setResult("0");
				vo.setMsg(vo.getNr());
			}
		}
		bookingDao.callSubmit(param);
		this.callAfter(param);
		// 状态为2则开启审批流
		if(vo.getZt() == 2){
			//开始审批流
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("out", "commit");
			// 判断是否驳回
			if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())) {
				// 驳回提交
				processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
			} else {
				// 开启审批流程
				ProcessBean processBean = new ProcessBean();
				processBean.setBusinessId(vo.getId());
				processBean.setCode(vo.getDcdh());// 订舱单号
				processBean.setProcessKey("bookingCreate");// 流程ID
				processBean.setType("订舱确认");// 流程类型
				processBean.setUserId(vo.getZdrid());
				processBean.setVariables(variables);
				processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
				processInstanceService.startProcessInstance(processBean);
			}
		}
		return vo;
	}
	//发送邮件
	public void sendEmail(String id,String nr){
		BookingEmailVo  bookingEmailVo = (BookingEmailVo) this.callQueryEmailById(id);
		Map<String,Object> map = this.emailHelper(bookingEmailVo,nr);	
		List<BookingReceiver> bookingList=bookingEmailVo.getReceiverList();
		for(BookingReceiver or:bookingList){
			try {
				mimeMailService.sendEmail(or.getSjr(), map.get("subject").toString(), map.get("content").toString());
			} catch (Exception e) {
				EmailVo emailVo = new EmailVo();
				emailVo.setYwid(id);
				emailVo.setYwdh(bookingEmailVo.getDcdh());
				emailVo.setYxdz(or.getSjr());
				emailVo.setName("出货通知书");
				emailVo.setText(e.getMessage());
				emailDao.insert(emailVo);
			}
		}
	}
	
	//取订单邮件内容
	@SuppressWarnings("unchecked")
	public Object callQueryEmailById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		bookingDao.callSelectEmail(param);
		List<BookingReceiver> recevierList=new ArrayList<BookingReceiver>();
		recevierList = (List<BookingReceiver>) param.get("recevierList");
		List<BookingEmailVo> list = (List<BookingEmailVo>) param.get("list");
		BookingEmailVo bookingEmailVo=new BookingEmailVo();
		if(list.size()>0){
			bookingEmailVo=list.get(0);
			bookingEmailVo.setReceiverList(recevierList);
		}	
		return bookingEmailVo;
	}
	//组装发送邮件的正文
	private Map<String,Object> emailHelper(BookingEmailVo bookingEmailVo,String nr){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> drlist=new ArrayList<String>();//收件人列表
		//邮件标题：[提交人姓名]|订单类型|订单号|客户名称
		StringBuffer subject = new StringBuffer();//邮件主题
		StringBuffer content = new StringBuffer();//邮件正文
		String url_tmp=url+"/base-web/booking/booking/viewPageList?id="+bookingEmailVo.getId();
		//组装收件人列表
		List<BookingReceiver> bookingList=bookingEmailVo.getReceiverList();
		for(BookingReceiver or:bookingList){
			drlist.add(or.getSjr());
		}
		//组装邮件主题
		subject.append("[订舱确认应收逾期不通过]|");
		subject.append("预走货单号[");
		subject.append(bookingEmailVo.getYzhdh());
		subject.append("|客户名称[");
		subject.append(bookingEmailVo.getKhmc());
		subject.append("]");
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
		content.append("预走货单号："+bookingEmailVo.getYzhdh()+"<br/>");
		content.append("订舱流水号："+bookingEmailVo.getDcdh()+"<br/>");
		content.append("客户名称："+bookingEmailVo.getKhmc()+"<br/>");
		content.append("应收状态："+nr+"<br/>");
		content.append("提交时间："+bookingEmailVo.getZdsj()+"<br/>");
		content.append("点击查看详细信息：<a href='"+url_tmp+"'>"+subject.toString()+"</a><br/>");
		map.put("recevier", drlist);
		map.put("subject", subject.toString());
		map.put("content", content.toString());
		return map;
	}
	// 审核
	@Transactional
	public void approve(BookingVo vo) {
		this.callBefore(vo);
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
		bookingDao.callApprove(param);
		this.callAfter(param);
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(BookingVo vo) {
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
	private void callAfter(Map<String, Object> param) {
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}
	}
	
	//应收超期结果保存
	public Object callYscqSave(BookingVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		bookingDao.callYscqSave(param);
		this.callAfter(param);
		return param;
	}

	// 检查应收超期，返回值： 0 ：没有应收超期 1：有应收超期
	public Map<String, Object> checkYscq(BookingVo bookingVo) {
		bookingVo = (BookingVo) callQueryById(bookingVo.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		String result = "0";
		DelayMsgRequest dmr = new DelayMsgRequest();
		dmr.setKhbm(bookingVo.getKhbm());
		/*tianrong 2017-8-9 以下屏蔽代码待放开 DelayMsgResponse drs =null;
		try {
			drs = elayInterfaceService.qryKhYscqFromSap(dmr);
		} catch (Exception e) {
			throw new ServiceException("调用SAP应收超期查询接口出错!");
		}
		if(drs == null){
			//throw new ServiceException("根据客户编码未在SAP取到超期数据!");// 正式环境此行代码需放开
			map.put("result",result.toString());
			map.put("message", "客户是否应收超期：否");
			return map;
		}else{
			 * 1. X（天数）= 当前时点该客户应收逾期最久的账龄（天数）+ (订舱确认单据中计划开船日期(ETD)-当前时点日期）（天数） 2.
			 * 系统判断 若X小于等于30，系统不闸口，订舱确认可提交，若X大于30，系统提醒逾期检查不通过，请联系相关人员解决
			 * 该订舱确认单据状态为逾期闸口（订舱确认虽已提交，但处于中间状态）
			 
			//2017-8-9 tianrong屏蔽以下代码，全部客户都没有应收超期 待SAP完善此功能后需要再开放此功能做检查
			Date date = new Date();
			long days = drs.getCqts() + ((bookingVo.getYjkcq().getTime() - date.getTime()) / 1000 * 24 * 60 * 60);
			if (days > 30) {
				result = "1";
			}
		}*/
		map.put("result",result.toString());
		if("1".equals(result)){
			map.put("message", "客户是否应收超期：是"/*+drs.toString()*/);
		}else {
			map.put("message", "客户是否应收超期：否"/*+drs.toString()*/);
		}
		return map;
	}
	
	/**
	 * 订舱待办查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryDbByPage(PsoVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		param.put("page", page);
		bookingDao.callSelectDB(param);
		List<PsoVo> list = (List<PsoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 订舱取消
	 * @param vo
	 */
	@Transactional
	public void cancel(BookingVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		bookingDao.callCancel(param);
		this.callAfter(param);
	}

	public void getback(BookingVo vo){
		DeleteProcess(vo.getProcessId());
		back(vo);
	}
	public void DeleteProcess(String processid) {
		// 1.删除流程实例
		try {
			processInstanceService.deleteProcessInstance(processid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional
	public void back(BookingVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		bookingDao.callGetback(param);
		this.callAfter(param);
	}
}