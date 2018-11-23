package com.ey.piit.sdo.deliver.service;

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
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.service.MimeMailService;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.delivery.dao.SapDeliverDao;
import com.ey.piit.interfaces.delivery.dto.DeliverBodyDto;
import com.ey.piit.interfaces.delivery.dto.DeliverHeaderDto;
import com.ey.piit.interfaces.delivery.dto.DeliverMsgResponse;
import com.ey.piit.interfaces.delivery.service.DeliverInterfaceService;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.sdo.deliver.entity.DeliverDb;
import com.ey.piit.sdo.deliver.entity.DeliverReceiver;
import com.ey.piit.sdo.deliver.repository.DeliverDao;
import com.ey.piit.sdo.deliver.repository.DeliverItemDao;
import com.ey.piit.sdo.deliver.vo.DeliverCostVo;
import com.ey.piit.sdo.deliver.vo.DeliverEmailVo;
import com.ey.piit.sdo.deliver.vo.DeliverExhibitionVo;
import com.ey.piit.sdo.deliver.vo.DeliverItemVo;
import com.ey.piit.sdo.deliver.vo.DeliverSAPVo;
import com.ey.piit.sdo.deliver.vo.DeliverVo;
import com.ey.piit.sdo.pso.service.PsoService;
import com.ey.piit.sdo.pso.vo.PsoNotifyVo;
import com.ey.piit.sdo.pso.vo.PsoOtherVo;
import com.ey.piit.sdo.pub.repository.EmailDao;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.pub.vo.EmailVo;

/**
 * 出货通知书管理Service
 * 
 * @author 魏诚
 */
@Service
@Transactional(readOnly = true)
public class DeliverService {

	@Autowired
	private DeliverDao dao;
	@Autowired
	private EmailDao emailDao;
	@Autowired
	private SapDeliverDao sapDeliverDao;
	@Autowired
	private DeliverInterfaceService deliverInterfaceService;
	@Autowired
	private DeliverItemDao deliverItemDao;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;

	@Autowired
	private ExportUtil exportUtil;
	@Autowired
	private MimeMailService mimeMailService;//邮件服务类
	
    @Value("${email.url}")
    private String url;//项目访问路径
    
	@Autowired
	private PsoService psoService;
    
	@SuppressWarnings("unchecked")
	public Object callDbQueryByPage(DeliverDb vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelectDb(param);
		List<DeliverDb> list = (List<DeliverDb>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	@SuppressWarnings("unchecked")
	public Object callYzhQueryByPage(DeliverDb vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelectYzhxx(param);
		List<DeliverDb> list = (List<DeliverDb>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(DeliverVo vo, PageBounds page, String ddh, String yzhdh) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		param.put("ddh", ddh);
		param.put("yzhdh", yzhdh);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelect(param);
		List<DeliverVo> list = (List<DeliverVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryScreenByPage(DeliverVo vo, PageBounds page, String ddh, String yzhdh) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		param.put("ddh", ddh);
		param.put("yzhdh", yzhdh);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callScreenSelect(param);
		List<DeliverVo> list = (List<DeliverVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryScreen(DeliverVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callScreenSelect(param);
		List<DeliverVo> list = (List<DeliverVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(DeliverVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		dao.callSelect(param);
		List<DeliverVo> list = (List<DeliverVo>) param.get("list");
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object callYzhQuery(String yzhdhs) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("yzhdhs", yzhdhs);
		dao.callSelectYzh(param);
		List<DeliverVo> list = (List<DeliverVo>) param.get("list");
		List<DeliverItemVo> mxList = (List<DeliverItemVo>) param.get("mxList");
		List<DeliverExhibitionVo> exhibitionList = (List<DeliverExhibitionVo>) param.get("exhibitionList");
		List<PsoOtherVo> otherList = (List<PsoOtherVo>) param.get("otherList");
		List<PsoNotifyVo> notifyList = (List<PsoNotifyVo>) param.get("notifyList");
		DeliverVo vo = list.get(0);
		vo.setDeliverItemList(mxList);
		vo.setDeliverExhibitionList(exhibitionList);
		vo.setDeliverOtherList(otherList);
		vo.setNotifyList(notifyList);
		vo.setFhr(UserUtils.getUser().getUserName());
		vo.setShr(UserUtils.getUser().getCompCode());
		return vo;
	}
	
	
	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectById(param);
		List<DeliverVo> list = (List<DeliverVo>) param.get("list");
		List<DeliverItemVo> mxList = (List<DeliverItemVo>) param.get("mxList");
		List<DeliverExhibitionVo> exhibitionList = (List<DeliverExhibitionVo>) param.get("exhibitionList");
		List<DeliverCostVo> costList = (List<DeliverCostVo>) param.get("costList");
		List<PsoNotifyVo> notifyList = (List<PsoNotifyVo>) param.get("notifyList");
		DeliverVo vo = list.get(0);
		vo.setDeliverItemList(mxList);
		vo.setDeliverExhibitionList(exhibitionList);
		vo.setDeliverCostList(costList);
		vo.setNotifyList(notifyList);
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryByPrintBg(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callQueryByPrintBg(param);
		List<DeliverVo> list = (List<DeliverVo>) param.get("list");
		List<DeliverItemVo> mxList = (List<DeliverItemVo>) param.get("mxList");
		List<DeliverExhibitionVo> exhibitionList = (List<DeliverExhibitionVo>) param.get("exhibitionList");
		List<DeliverCostVo> costList = (List<DeliverCostVo>) param.get("costList");
		List<PsoNotifyVo> notifyList = (List<PsoNotifyVo>) param.get("notifyList");
		DeliverVo vo = list.get(0);
		vo.setDeliverItemList(mxList);
		vo.setDeliverExhibitionList(exhibitionList);
		vo.setDeliverCostList(costList);
		vo.setNotifyList(notifyList);
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callChangeById(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		dao.callChangeById(param);
		this.callAfter(param);
		List<DeliverVo> list = (List<DeliverVo>) param.get("list");
		List<DeliverItemVo> mxList = (List<DeliverItemVo>) param.get("mxList");
		List<DeliverExhibitionVo> exhibitionList = (List<DeliverExhibitionVo>) param.get("exhibitionList");
		List<PsoNotifyVo> notifyList = (List<PsoNotifyVo>) param.get("notifyList");
		DeliverVo vo = list.get(0);
		vo.setDeliverItemList(mxList);
		vo.setDeliverExhibitionList(exhibitionList);
		vo.setNotifyList(notifyList);
		return vo;
	}

	@Transactional
	public Object edit(DeliverVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		return vo;
	}

	@Transactional
	public void submit(DeliverVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);

		dao.callSubmit(param);
		this.callAfter(param);

		// 开启审批流程
	}

	@Transactional
	public void delete(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		param.put("userId", UserUtils.getUser().getEmpCode());
		dao.callDelete(param);
		this.callAfter(param);
	}

	private Map<String, Object> save(DeliverVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		dao.callInsert(param);
		// 循环插入订单关联PI
		for (DeliverItemVo deliverItem : vo.getDeliverItemList()) {
			deliverItem.setChdh(vo.getChdh());
			deliverItem.setBbh(vo.getBbh());
			deliverItem.setId(Identities.uuid());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", deliverItem);
			deliverItemDao.callInsert(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		
		// 循环更新PSO明细表 费用明细	
		psoService.updateOther(vo.getDeliverItemList(),vo.getDeliverOtherList());
		return param;
	}

	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(DeliverVo vo) {
		if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			if (StringUtils.isEmpty(vo.getChdh())) {
				vo.setId(Identities.uuid());
			}
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
	public void export(HttpServletResponse response, Map<String, Object> params, DeliverVo vo) {
		try {
			List<DeliverVo> list = (List<DeliverVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}

	}
	
	@SuppressWarnings("unchecked")
	public void screenExport(HttpServletResponse response, Map<String, Object> params, DeliverVo vo) {
		try {
			List<DeliverVo> list = (List<DeliverVo>) this.callQueryScreen(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}

	}
	
	// 推送SAP并且记录返信息货日志
	public void tsSapAndWriteLog(DeliverVo vo) {
		// 执行推送
		DeliverMsgResponse deliverMsgResponse = pushSAP(vo);
		// 更改单据推送状态
		complete(vo);
		// 保存推送返回信息日志
		saveTsSapLog(vo, deliverMsgResponse);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	private DeliverMsgResponse pushSAP(DeliverVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		param.put("tssaplx", vo.getTssaplx());
		sapDeliverDao.callSelectById(param);
		List<DeliverHeaderDto> headerList = (List<DeliverHeaderDto>) param.get("headerList");
		List<DeliverBodyDto> bodyList = (List<DeliverBodyDto>) param.get("bodyList");
		DeliverMsgResponse deliverMsgResponse = null;
		// 调用sap接口
		try {
			deliverMsgResponse = deliverInterfaceService.deliverSdoToSap(headerList.get(0), bodyList);

		} catch (Exception e) {
			throw new ServiceException("调用SAP出库推送接口出错！");
		}
		// 回写出货推送状态
		if (deliverMsgResponse != null) {
			if ("X".equals(deliverMsgResponse.getResult())) {
				vo.setTssapzt(1);
			} else {
				vo.setTssapzt(0);
			}
		}
		return deliverMsgResponse;

	}


	// 保存推送SAP日志
	private void saveTsSapLog(DeliverVo vo, DeliverMsgResponse deliverMsgResponse) {
		if (vo == null) {
			throw new ServiceException("推送sap的vo为空");
		}
		if (deliverMsgResponse == null) {
			throw new ServiceException("推送sap返回信息为空");
		}
		// 保存推送日志
		SapInterfaceLogVo logvo = new SapInterfaceLogVo();
		logvo.setId(vo.getId());;
		logvo.setDh(vo.getChdh());
		logvo.setMk("出货通知书");
		logvo.setSj(new Date());
		logvo.setFhzt(vo.getTssapzt());
		logvo.setFhxx(deliverMsgResponse.getMsg());
		logvo.setBw(deliverMsgResponse.getInXml());
		try {
			sapInterfaceLogService.save(logvo);
		} catch (Exception e) {
			new ServiceException("保存SAP返回信息日志出错");
		}
	}

	// 推送完成更改完成状态
	private void complete(DeliverVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callComplete(param);
		this.callAfter(param);
	}
	
	//发送邮件
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sendEmail(String id, String gsbm){
		DeliverEmailVo  deliverEmailVo = (DeliverEmailVo) this.callQueryEmailById(id, gsbm);
		Map<String,Object> map = this.emailHelper(deliverEmailVo);	
		List list = new ArrayList();
		try {
			if(deliverEmailVo.getFj() == null || "".equals(deliverEmailVo.getFj())){
				mimeMailService.sendEmail((List<String>)map.get("recevier"), map.get("subject").toString(), map.get("content").toString());
			}else{
				String[] _list = deliverEmailVo.getFj().split("</a>");
				for (int i =0;i<_list.length;i++){
					list.add(_list[i]);
				}
				mimeMailService.sendEmail((List<String>)map.get("recevier"), map.get("subject").toString(), map.get("content").toString(),list);
			}
		} catch (Exception e) {
			EmailVo emailVo = new EmailVo();
			emailVo.setYwid(id);
			emailVo.setYwdh(deliverEmailVo.getChdh());
			emailVo.setYxdz("");
			emailVo.setName("出货通知书");
			emailVo.setText(e.getMessage());
			emailDao.insert(emailVo);
		}
		// 单个发给预走货发起人
		for (DeliverReceiver dr : deliverEmailVo.getReceiverYzhList()){
			List list_yzh = new ArrayList();
			try {
				if(deliverEmailVo.getFj() == null || "".equals(deliverEmailVo.getFj())){
					mimeMailService.sendEmail(dr.getYzhsjr(), map.get("subject").toString(), map.get("content").toString());
				}else{
					String[] _list = deliverEmailVo.getFj().split("</a>");
					for (int i =0;i<_list.length;i++){
						list_yzh.add(_list[i]);
					}
					mimeMailService.sendEmail(dr.getYzhsjr(), map.get("subject").toString(), map.get("content").toString(),list_yzh);
					}
				} catch (Exception e) {
					EmailVo emailVo = new EmailVo();
					emailVo.setYwid(id);
					emailVo.setYwdh(deliverEmailVo.getChdh());
					emailVo.setYxdz("");
					emailVo.setName("出货通知书");
					emailVo.setText("预走货发起人："+e.getMessage());
					emailDao.insert(emailVo);
				}
			}
		callYjztSave(id);
	}
	
	//是否已发邮件状态保存
	@Transactional
	public void callYjztSave(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callYjztSave(param);
		this.callAfter(param);
	}
	
	//取出库通知书邮件内容
	@SuppressWarnings("unchecked")
	public Object callQueryEmailById(String id, String gsbm) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("gsbm", gsbm);
		dao.callSelectEmail(param);
		List<DeliverReceiver> recevierList=new ArrayList<DeliverReceiver>();
		List<DeliverReceiver> recevierYzhList=new ArrayList<DeliverReceiver>();
		recevierList = (List<DeliverReceiver>) param.get("recevierList");
		recevierYzhList = (List<DeliverReceiver>) param.get("recevierYzhList");
		List<DeliverEmailVo> list = (List<DeliverEmailVo>) param.get("list");
		DeliverEmailVo deliverEmailVo=new DeliverEmailVo();
		if(list.size()>0){
			deliverEmailVo=list.get(0);
			deliverEmailVo.setReceiverList(recevierList);
			deliverEmailVo.setReceiverYzhList(recevierYzhList);
		}	
		return deliverEmailVo;
	}
	//组装发送邮件的正文
	private Map<String,Object> emailHelper(DeliverEmailVo deliverEmailVo){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> drlist=new ArrayList<String>();//收件人列表
		//邮件标题：[提交人姓名]|出货通知书|出货通知书编码|起运港|订单号|客户名称
		StringBuffer subject = new StringBuffer();//邮件主题
		StringBuffer content = new StringBuffer();//邮件正文
		String url_tmp=url+"/base-web/deliver/deliver/viewPage?id="+deliverEmailVo.getId();
		//组装收件人列表
		List<DeliverReceiver> recevierList=deliverEmailVo.getReceiverList();
		for(DeliverReceiver dr:recevierList){
			drlist.add(dr.getSjr());
		}
		//组装邮件主题
		if(deliverEmailVo.getBbh()>1){
			subject.append("【");
			subject.append("出货变更通知");
			subject.append("】|");
		}
		subject.append("[");
		subject.append(deliverEmailVo.getZdrmc());
		subject.append("]|");
		subject.append(deliverEmailVo.getDjlx());
		subject.append("|");
		subject.append(deliverEmailVo.getChdh());
		subject.append("|");
		subject.append(deliverEmailVo.getCylxmc());
		subject.append("|");
		subject.append(deliverEmailVo.getBgfsmc());
		subject.append("|");
		subject.append(deliverEmailVo.getQygmc());
		subject.append("|");
		subject.append(deliverEmailVo.getDdh());
		subject.append("|");
		subject.append(deliverEmailVo.getKhmc());
		//组装邮件正文
		/*邮件正文：
		此邮件由系统自动发出，请勿回复。
		业务基本信息
		业务单据：出货通知书
		单据编码：SA1607XXX
		提交人：XXX
		提交时间：2016-06-27 0:00:00
		点击查看详细信息：[提交人姓名]|出货通知书|出货通知书编码|起运港|订单号|客户名称
		附件：提取的相关文件[ 按照相应规则提取]*/
		content.append("<p>");
		content.append("此邮件由系统自动发出，请勿回复。");
		content.append("</p>");
		content.append("业务基本信息<br/>");
		content.append("业务单据："+deliverEmailVo.getDjlx()+"<br/>");
		content.append("单据编码："+deliverEmailVo.getChdh()+"<br/>");
		content.append("版本号："+deliverEmailVo.getBbh()+"<br/>");
		content.append("提交人："+deliverEmailVo.getZdrmc()+"<br/>");
		content.append("提交时间："+deliverEmailVo.getZdsj()+"<br/>");
		content.append("点击查看详细信息：<a href='"+url_tmp+"'>"+subject.toString()+"</a><br/>");
		map.put("recevier", drlist);
		map.put("subject", subject.toString());
		map.put("content", content.toString());
		return map;
	}
	
	/**
	 * 出货通知书取消
	 * @param vo
	 */
	@Transactional
	public void cancel(DeliverVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callCancel(param);
		this.callAfter(param);	
	}
	
	/**
	 * SAP中间表 箱单明细查询
	 * */
	@SuppressWarnings("unchecked")
	public Object callSAPDeliverQueryByPage(DeliverSAPVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectSAPDeliver(param);
		List<DeliverSAPVo> list = (List<DeliverSAPVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callSAPDeliverQuery(DeliverSAPVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callSelectSAPDeliver(param);
		List<DeliverSAPVo> list = (List<DeliverSAPVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public void SAPDeliverexport(HttpServletResponse response, Map<String, Object> params, DeliverSAPVo vo) {
		try {
			List<DeliverSAPVo> list = (List<DeliverSAPVo>) this.callSAPDeliverQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}

	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryChxxByPage(DeliverVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		dao.callSelectChxx(param);
		List<DeliverVo> list = (List<DeliverVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
}