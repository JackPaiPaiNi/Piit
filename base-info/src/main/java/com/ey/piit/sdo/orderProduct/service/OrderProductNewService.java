package com.ey.piit.sdo.orderProduct.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
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
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.service.MimeMailService;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.interfaces.order.dao.IOrderDao;
import com.ey.piit.interfaces.order.dto.OrderBodyDto;
import com.ey.piit.interfaces.order.dto.OrderHeaderDto;
import com.ey.piit.interfaces.order.dto.OrderMsgResponse;
import com.ey.piit.interfaces.order.dto.OrderZZHeaderDto;
import com.ey.piit.interfaces.order.service.OrderInterfaceService;
import com.ey.piit.interfaces.pidbom.dto.PidBomRequest;
import com.ey.piit.interfaces.pidbom.dto.PidBomResponse;
import com.ey.piit.interfaces.pidbom.service.PidBomInterfaceService;
import com.ey.piit.sdo.mdm.service.ProductBomService;
import com.ey.piit.sdo.mdm.vo.ProductBomVo;
import com.ey.piit.sdo.order.entity.OrderReceiver;
import com.ey.piit.sdo.order.repository.OrderProductCkdDao;
import com.ey.piit.sdo.order.repository.OrderReferPiDao;
import com.ey.piit.sdo.order.vo.OrderBgmxVo;
import com.ey.piit.sdo.order.vo.OrderEmailVo;
import com.ey.piit.sdo.order.vo.OrderLogVo;
import com.ey.piit.sdo.order.vo.OrderProductCkdVo;
import com.ey.piit.sdo.order.vo.OrderReferPiVo;
import com.ey.piit.sdo.orderProduct.repository.OrderProductNewDao;
import com.ey.piit.sdo.orderProduct.vo.OrderProductNewVo;
import com.ey.piit.sdo.payment.service.PayValidateService;
import com.ey.piit.sdo.payment.vo.PayValidateVo;
import com.ey.piit.sdo.pub.repository.EmailDao;
import com.ey.piit.sdo.pub.service.PubDataService;
import com.ey.piit.sdo.pub.vo.EmailVo;
import com.ey.piit.sdo.track.repository.TrackInfoDao;

import net.sf.cglib.beans.BeanMap;
import net.sf.json.JSONArray;

/**
 * 大货订单管理Service
 * 
 * @author 魏诚
 */
@Service
public class OrderProductNewService {

	@Autowired
	private OrderProductNewDao dao;

	@Autowired
	private OrderReferPiDao orderReferPiDao;

	@Autowired
	private OrderProductCkdDao orderProductCkdDao;

	@Autowired
	private ExportUtil exportUtil;

	@Autowired
	private ProcessInstanceService processInstanceService;

	@Autowired
	private ProcessTaskService processTaskService;

	@Autowired
	private PayValidateService payValidateService;

	@Autowired
	private IOrderDao iDao;
	@Autowired
	private EmailDao emailDao;
	@Autowired
	private OrderInterfaceService iOrderService;
	@Autowired
	private PidBomInterfaceService pidBomInterfaceService;
	@Autowired
	private ProductBomService productBomService;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
	@Autowired
	private PubDataService pubDataService;
	@Autowired
	private TrackInfoDao  trackInfoDao ;
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
			vo.setOrderReferPiList(piList);
			vo.setWycCkdList(wycckdist);
			vo.setYycCkdList(yycckdist);
			vo.setLogList(logList);
			vo.setBgmxList(bgmxList);
		}
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryByIdView(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callSelectByIdView(param);
		List<OrderProductNewVo> list = (List<OrderProductNewVo>) param.get("list");
		List<OrderReferPiVo> piList = (List<OrderReferPiVo>) param.get("piList");
		List<OrderProductCkdVo> wycckdist    = (List<OrderProductCkdVo>) param.get("ckdwycList");
		List<OrderProductCkdVo> yycckdist  = (List<OrderProductCkdVo>) param.get("ckdyycList");
		List<OrderLogVo> logList = (List<OrderLogVo>) param.get("logList");
		List<OrderBgmxVo> bgmxList = (List<OrderBgmxVo>) param.get("bgmxList");
		OrderProductNewVo vo = new OrderProductNewVo();
		if (list.size() > 0) {
			vo = list.get(0);
			vo.setOrderReferPiList(piList);
			vo.setWycCkdList(wycckdist);
			vo.setYycCkdList(yycckdist);
			vo.setLogList(logList);
			vo.setBgmxList(bgmxList);
		}
		return vo;
	}

	@SuppressWarnings("unchecked")
	public Object callQueryByDh(String ddid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ddid", ddid);
		dao.callSelectByDh(param);
		List<OrderProductNewVo> list = (List<OrderProductNewVo>) param.get("list");
		List<OrderReferPiVo> piList = (List<OrderReferPiVo>) param.get("piList");
		List<OrderProductCkdVo> ckdwycList = (List<OrderProductCkdVo>) param.get("ckdwycList");
		List<OrderProductCkdVo> ckdyycList = (List<OrderProductCkdVo>) param.get("ckdyycList");
		OrderProductNewVo vo = new OrderProductNewVo();
		if (list.size() > 0) {
			vo = list.get(0);
		}
		vo.setOrderReferPiList(piList);
		vo.setWycCkdList(ckdwycList);
		vo.setYycCkdList(ckdyycList);
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

	/**
	 * CKD 移除或移回
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@Transactional
	public void ckdAddOrRemove(OrderProductCkdVo vo, JSONArray array) {
		for (int i = 0; i < array.size(); i++) {
			vo.setId(array.get(i).toString());
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", vo);
			orderProductCkdDao.callAddOrRemove(param);
			if (!"SDO-000000".equals(param.get("resultCode").toString())) {
				break;
			}
		}
	}

	/**
	 * CKD 明细计算
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@Transactional
	public void ckdCompute(OrderProductNewVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		orderProductCkdDao.callCompute(param);
		callAfter(param);
	}

	@Transactional
	public Object edit(OrderProductNewVo vo) {
		this.callBefore(vo);
		this.save(vo);
		return vo;
	}

	@Transactional
	public void submit(OrderProductNewVo vo) {
		//提交前需检查PID是否已激活，未激活则不允许提交
		boolean flag = false;
		PidBomRequest pidBomRequest = new PidBomRequest();
		//工厂，深圳基地(2110)下单写1107，广州基地（2120）下单写1202，FCST写1104
		String gc = "";
		if("2110".equals(vo.getScjd())){
			gc="1107";
		}else{
			gc="1202";
		}
		pidBomRequest.setGc(gc);
		pidBomRequest.setPid(vo.getPid());
		try {
			flag = pidBomInterfaceService.qryPidSfsxFromSap(pidBomRequest);
		} catch (Exception e) {
			throw new ServiceException("检查PID是否激活出错!");
		}
		if(flag == true){
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
			variables.put("sftjbhr", "1");//是否提交到驳回人
			variables.put("xszz", vo.getXszz());
			variables.put("scjd", vo.getScjd());//流程判断条件：生产基地
			variables.put("id", vo.getId());// 订单ID
			variables.put("ddlx", vo.getDdlx());// 订单类型
			variables.put("jclx", "order");// 检查类型为订单
			String sqr = UserUtils.hasRole("1-yx-xsy") ? "1-yx-xsy" : "0";
			variables.put("sqr", sqr);
			variables.put("sfBg", vo.getSfBg()==null?"0":vo.getSfBg());
			variables.put("tssapzt", vo.getTssapzt()==null?"0":vo.getTssapzt());
			variables.put("sfNxyfcp", vo.getSfNxyfcp());
			variables.put("slje", vo.getSlje());//变更时修改数量还是金额
			variables.put("gsbm", vo.getGsbm());//公司编码；
			variables.put("sfCh", vo.getSfCh()==null?"0":vo.getSfCh());//是否撤回
			variables.put("wxdd", vo.getSfWxdd());
			if(vo.getSfWxdd() == 0){
				variables.put("hwcpjl", vo.getLccpjl());
			}else{
				variables.put("cpjl", vo.getLccpjl());
			}
			if((vo.getSfBg() != null && vo.getSfBg() == 1) ||(vo.getSfCh() != null && vo.getSfCh() == 1)){
				// 判断是否驳回
				if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())) {
					// 驳回提交
					processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
				} else {
					variables.put("isRestart", vo.getIsRestart()==null?"1":vo.getIsRestart());//是否重新提交
					// 开启审批流程
					ProcessBean processBean = new ProcessBean();
					processBean.setBusinessId(vo.getId());
					processBean.setCode(vo.getDdid());
					/*
					 * 直接提取订单，数量金额修改审批流同新增流程
					 * 魏诚  2018-10-24
					 */
					if("5".equals(vo.getDdlb())){
						processBean.setProcessKey("OrderProduct_zjtq-new");
						processBean.setType(vo.getDdlxmc() + "-提取变更（数量金额）");
					} else {
						//processBean.setProcessKey("OrderProduct_modify");
						processBean.setProcessKey("orderProductModify_jexx_new");
						processBean.setType(vo.getDdlxmc() + "-变更（数量金额）");
					}
					processBean.setUserId(vo.getZdrid());
					processBean.setVariables(variables);
					processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
					processInstanceService.startProcessInstance(processBean);
				}
			} else {
				// 判断是否驳回
				if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())) {
					// 驳回提交
					processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
				} else {
					variables.put("isRestart", vo.getIsRestart()==null?"1":vo.getIsRestart());//是否重新提交
					// 开启审批流程
					ProcessBean processBean = new ProcessBean();
					processBean.setBusinessId(vo.getId());
					processBean.setCode(vo.getDdid());
					if ("1".equals(vo.getDdlb())) {
						processBean.setProcessKey("OrderProduct_new-01-new");
						processBean.setType(vo.getDdlxmc() + "-新订单");// 流程类型
						// 翻单
					} else if ("2".equals(vo.getDdlb())) {
						processBean.setProcessKey("OrderProduct_fd-01-new");
						processBean.setType(vo.getDdlxmc() + "-翻单");// 流程类型
						// 纯翻单
					} else if ("3".equals(vo.getDdlb())) {
						processBean.setProcessKey("OrderProduct_cfd-01-new");
						processBean.setType(vo.getDdlxmc() + "-纯翻单");// 流程类型
						// 风险订单
					} else if ("4".equals(vo.getDdlb())) {
						processBean.setProcessKey("OrderProduct_fxdd-01-new");
						processBean.setType(vo.getDdlxmc() + "-风险订单");// 流程类型
					} else if("5".equals(vo.getDdlb())){
						processBean.setProcessKey("OrderProduct_zjtq-new");
						processBean.setType(vo.getDdlxmc() + "-直接提取订单");// 流程类型
					}
					processBean.setUserId(vo.getZdrid());
					processBean.setVariables(variables);
					processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
					processInstanceService.startProcessInstance(processBean);
				}
			}
		}else{
			throw new ServiceException("PID("+vo.getPid()+")未激活（需在工厂"+gc+"激活），不允许提交！");
		}
	}
	
	/**
	 * 进行审核
	 * 流程中岗位为供应链支持专员设置的id为gylzczy,岗位为应收风险专员设置的id为ysfxzy
	 * @param vo
	 */
	
	@SuppressWarnings("unchecked")
	public OrderProductNewVo approve(OrderProductNewVo vo) {
		String tssapMsg = "";
		Map<String, Object> param2 = new HashMap<String, Object>();
		param2.put("id", vo.getId());
		dao.callSelectById(param2);
		List<OrderProductNewVo> list = (List<OrderProductNewVo>) param2.get("list");
		this.callBefore(vo);
		//设置流程参数
		Map<String, Object> variables = new HashMap<String, Object>();
		if (list != null && list.size() > 0) {
			variables.put("wxdd", list.get(0).getSfWxdd());
		} else {
			variables.put("wxdd", "1");
		}
		variables.put("xszz", list.get(0).getXszz());
		variables.put("sfjp", vo.getSfjp().toString());
		variables.put("gsbm", list.get(0).getGsbm());
		variables.put("sfCh", list.get(0).getSfCh()==null?"0":list.get(0).getSfCh());//是否撤回
		//设计师参数设置
		if(list.get(0).getSfWxdd() == 1){
			variables.put("wxdzsjs", vo.getDzgcs());//外协电子设计师
			variables.put("wxdysjs", vo.getDygcs());//外协电源设计师
			variables.put("wxjgsjs", vo.getJggcs());//外协结构设计师
		} else {
			variables.put("dzsjs", vo.getDzgcs());//电子设计师
			variables.put("dysjs", vo.getDygcs());//电源设计师
			variables.put("jgsjs", vo.getJggcs());//结构设计师
		}
		//获取自定义任务节点ID值，必须放在提交节点之前
		String taskKey = processTaskService.findTaskById(vo.getTaskId()).getTaskKey();
		// 完成当前节点审批
		if(vo.getApproveType() == 1){
			variables.put("out", "agree");
			//若为供应链支持则不调用审批过程（供应链支持同意后，直接在付款保障监听里进行终审）
			if(!"gylzczy".equals(taskKey)){
				this.doApprove(vo);
			}
			try {
				processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
			} catch (Exception e) {
				tssapMsg = e.getMessage();
				vo.setMsg(tssapMsg);
			}
		}else if(vo.getApproveType() == 2){
			variables.put("out", "reject");
			if("1".equals(vo.getIsRestart())){
				processTaskService.setProcessVariables(vo.getTaskId(), "isRestart", "1");//重新开始
			}else if("0".equals(vo.getIsRestart())){
				processTaskService.setProcessVariables(vo.getTaskId(), "isRestart", "0");//不重新开始
			}
			//驳回都需要调用审批过程
			this.doApprove(vo);
			try {
				processTaskService.rejectTaskRestart(vo.getProcessId());
			} catch (Exception e) {
				tssapMsg = e.getMessage();
				vo.setMsg(tssapMsg);
			}
		}
		
		//返回付款保障日志到前台
		if("smocwsh".equals(taskKey) || "gylzczy".equals(taskKey)){
			List<PayValidateVo> payLogList = (List<PayValidateVo>) payValidateService.payCheckSelectLog(vo.getId());
			if(payLogList.size() > 0){
				if("付款保障检查通过！".equals(payLogList.get(0).getZy().toString())){
					vo.setResult("1");
				}else{
					vo.setResult("0");
				}
				vo.setMsg(payLogList.get(0).getZy() +" "+ tssapMsg);
			}else {
				vo.setMsg(tssapMsg);
			}
			
		}
		return vo;
	}
	
	/**
	 * 调用订单审核过程
	 * @param vo
	 */
	@Transactional
	public void doApprove(OrderProductNewVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callApprove(param);
		this.callAfter(param);
	}
	
	/**
	 * 为防止终审时，监听调用approve方法，产生事务嵌套
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public OrderProductNewVo listenerApprove(OrderProductNewVo vo) throws Exception{
		OrderProductNewVo votemp = (OrderProductNewVo) this.callQueryById(vo.getId());
		vo.setSjc(votemp.getSjc());
		this.callBefore(vo);
		if (vo.getApproveType() == 3) {
			Map<String, Object> param = new HashMap<String, Object>();
			User user = UserUtils.getUser();
			votemp.setZdrid(user.getLoginAcct());
			votemp.setZdrmc(user.getUserName());
			votemp.setApproveType(3);
			param.put("vo", votemp);
			dao.callApprove(param);
			if (!"SDO-000000".equals(param.get("resultCode").toString())) {
				throw new Exception(param.get("resultMsg").toString());
			}
		}
		return vo;
	}

	public void delete(String id, String sjc, int zt, String processId) {
		if(zt == 3 && !"".equals(processId)){
			DeleteProcess(processId);
		}
		sjdelete(id,sjc);
		
	}
	
	@Transactional
	public void sjdelete(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		dao.callDelete(param);
		this.callAfter(param);
	}
	
	

	// 保存ckd物料明细
	@Transactional
	public void saveOrderCkd(OrderProductNewVo vo) {
		// 删除之前导入的数据
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		//变更单据不能删除ckd明细
		if(vo.getSfBg() != 1){
			orderProductCkdDao.callDelete(param);
			this.callAfter(param);
		}
		// 循环检查物料
		String wlbms = "";
		for (OrderProductCkdVo orderProductCkdVo : vo.getWycCkdList()) {
			wlbms = wlbms + orderProductCkdVo.getWlbm() + ",";
		}
		Map<String, Object> param1 = pubDataService.checkwl(wlbms);
		if ("SDO-000000".equals(param1.get("resultCode").toString())) {
			// 循环将CKD数据存入数据库
			for (OrderProductCkdVo orderProductCkdVo : vo.getWycCkdList()) {
				orderProductCkdVo.setDdid(vo.getDdid());
				orderProductCkdVo.setBbh(vo.getBbh());
				orderProductCkdVo.setsFbg(vo.getSfBg());
				// orderReferPi.preInsert();
				if(StringUtils.isEmpty(orderProductCkdVo.getId())){
					orderProductCkdVo.setId(Identities.uuid());
				}
				this.saveOrderCkdItem(orderProductCkdVo);
			}
		}else{
			throw new ServiceException("物料" + param1.get("resultMsg").toString() + "不存在！");
		}
	}

	// 保存ckd物料明细
	public Object saveOrderCkdItem(OrderProductCkdVo vo) {
		if (StringUtils.isEmpty(vo.getId()) || vo.getId() =="") {
			vo.setId(Identities.uuid()); 
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		orderProductCkdDao.callInsert(param);
		this.callAfter(param);
		return param;
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
		// 明细表保存（pi）
		for (OrderReferPiVo orderReferPi : vo.getOrderReferPiList()) {
			orderReferPi.setDdid(vo.getDdid());
			orderReferPi.setBbh(vo.getBbh());
			// orderReferPi.preInsert();
			orderReferPi.setId(Identities.uuid());
			Map<String, Object> piParam = new HashMap<String, Object>();
			piParam.put("vo", orderReferPi);
			orderReferPiDao.callInsert(piParam);
			// 明细数据保存后
			this.callAfter(piParam);
		}
		// 明细表保存（CKD）
		// this.saveOrderCkdItem(vo);
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
	public void cancel(OrderProductNewVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callCancel(param);
		this.callAfter(param);
		//取消需要走审批流1取消 2撤回
		if(vo.getType() == 1){
			// 审批流处理
			vo = (OrderProductNewVo) this.callQueryById(vo.getId());
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("out", "commit");
			variables.put("groupCode", vo.getYwz());// 指定销售组长的业务组
			variables.put("deptCode", vo.getXszz());//销售组织
			variables.put("xsyid", vo.getXsyid());// 指定销售员进行审批
			variables.put("out", "commit");
			variables.put("xszz", vo.getXszz());
			variables.put("wxdd", vo.getSfWxdd());
			variables.put("scjd", vo.getScjd());//流程判断条件：生产基地
			String sqr = UserUtils.hasRole("1-yx-xsy") ? "1-yx-xsy" : "0";
			variables.put("sqr", sqr);
			variables.put("sfNxyfcp", vo.getSfNxyfcp());
			variables.put("ddlb", vo.getDdlb());
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(vo.getId());
			processBean.setCode(vo.getDdid());
			processBean.setProcessKey("OrderProduct_cancel-01-new");
			processBean.setType("大货订单-取消");//流程类型
			processBean.setUserId(vo.getZdrid());
			processBean.setVariables(variables);
			processBean.setName("("+vo.getGsbm()+")"+vo.getKhmc());//公司编码+客户名称
			// 开启审批流程
			processInstanceService.startProcessInstance(processBean);
		}
	}
	
	@Transactional
	public void cancelApprove(OrderProductNewVo vo){
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		OrderProductNewVo votemp = (OrderProductNewVo) this.callQueryById(vo.getId());
		// 完成当前节点审批
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("out", "agree");
		variables.put("sfNxyfcp", votemp.getSfNxyfcp());
		processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		
		// 判断是不是终审
		boolean isEnd = processInstanceService.isProcessEnd(vo.getProcessId());
		if(isEnd && vo.getApproveType()==1){
			vo.setApproveType(3);
		}
		
		// 调用审批存储过程
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callCancelApprove(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void change(OrderProductNewVo vo){
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callChange(param);
		this.callAfter(param);
	}

	/**
	 * ckd 明细导出
	 * 
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryCkd(OrderProductNewVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		orderProductCkdDao.callSelectById(param);
		List<OrderProductCkdVo> list = (List<OrderProductCkdVo>) param.get("ckdList");
		return list;
	}

	@SuppressWarnings("unchecked")
	public void exportCkd(HttpServletResponse response, Map<String, Object> params, OrderProductNewVo vo) {
		try {
			List<OrderProductCkdVo> list = (List<OrderProductCkdVo>) this.callQueryCkd(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	//更新订单跟踪生产订单下达状态
	public  void updateDDgz(OrderProductNewVo orderProductVo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ddid", orderProductVo.getDdid());
		param.put("jdmc", "生产订单下达");
		param.put("jdzt", "已完成");
		param.put("wcsj",new Date());
		trackInfoDao.updateDdgzzt(param);
		callAfter(param);
	}
	
	// 推送SAP并且记录返信息货日志
	@SuppressWarnings("unchecked")
	public OrderProductNewVo tsSapAndWriteLog(String id) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		OrderProductNewVo vo = new OrderProductNewVo();
		param.put("id", id);
		dao.callSelectById(param);
		List<OrderProductNewVo> list = (List<OrderProductNewVo>) param.get("list");
		if(list.size() > 0){
			vo = list.get(0);
		}else {
			throw new ServiceException("系统推送SAP时未找到订单信息！");
		}
		//是否变更
		Integer sfBg = vo.getSfBg()==null?0:vo.getSfBg();
		//是否撤回
		Integer sfCh = vo.getSfCh()==null?0:vo.getSfCh();
		//撤回和变更的单据，不推送SAP,直接生效
		if(sfBg != 1 && sfCh != 1){
			// 执行推送
			Map<String, Object> resultMap;
			try {
				resultMap = pushSAP(vo);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				throw e;
			}
			// 更改单据推送状态
			this.complete(vo);
			// 保存推送返回信息日志
			SapInterfaceLogVo logVo = saveTsSapLog(vo, resultMap);
			vo.setMsg(logVo.getFhxx());
			// 推送SAP成功后发送邮件
			if(logVo.getFhzt()==1||logVo.getFhzt()==3){
				// 正常推送
				sendEmail(id,1);
			}
		}else {
			this.active(vo.getId());
		}
		return vo ;
		
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
					emailVo.setName("大货订单变更");
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
		dao.callSelectEmail(param);
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
		String url_tmp=url+"/base-web/order/orderProduct/viewPage?id="+orderEmailVo.getId();
		//组装收件人列表
		List<OrderReceiver> orderList=orderEmailVo.getReceiverList();
		for(OrderReceiver or:orderList){
			drlist.add(or.getSjr());
		}
		//组装邮件主题
		if(zt ==1){
			subject.append("[工作流][新任务]");
		}else{
			subject.append("[工作流][金额类变更新任务]");	
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	private Map<String, Object> pushSAP(OrderProductNewVo vo) throws Exception {
		Map<String, Object> paramHw = new HashMap<String, Object>();
		Map<String, Object> paramZz = new HashMap<String, Object>();
		paramHw.put("id", vo.getId());
		paramZz.put("id", vo.getId());
		iDao.callSelectProductByIdHw(paramHw);
		iDao.callSelectProductByIdZz(paramZz);
		List<OrderHeaderDto> headerRequestListHw = (List<OrderHeaderDto>) paramHw.get("list");
		List<OrderBodyDto> bodyRequestListHw = (List<OrderBodyDto>) paramHw.get("itemList");
		List<OrderZZHeaderDto> headerRequestListZz = (List<OrderZZHeaderDto>) paramZz.get("list");
		List<OrderBodyDto> bodyRequestListZz = (List<OrderBodyDto>) paramZz.get("itemList");
		OrderMsgResponse hwRespMsg = null;
		OrderMsgResponse zzRespMsg = null;
		// 调用sap接口
		try {
			//0代表海外推送失败; null ：没推送过 
			if(vo.getTssapzt()==null || vo.getTssapzt()==0){
				hwRespMsg = iOrderService.orderSdoToHwSap(
						headerRequestListHw.get(0), bodyRequestListHw);
				// 推送成功解析佣金比例
				if(hwRespMsg!=null){
					vo.setYjbl(paseYjbl(hwRespMsg.getOutXml()));
				}
			}else{
				//海外sap已经推送成功的
				hwRespMsg=new OrderMsgResponse();
				hwRespMsg.setResult("X");
				hwRespMsg.setDh(vo.getDdid());
				hwRespMsg.setMsg("已经推送海外sap成功,不再重复推送！");
				hwRespMsg.setOutXml("已经推送海外sap成功,不再重复推送！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			//throw new ServiceException("调用海外SAP大货订单接口失败！");
			throw new Exception("调用海外SAP大货订单接口失败！");
		}
		// 设置推送SAP状态，当订单类别为直接提取时，不推送制作SAP
        if(StringUtils.isEmpty(vo.getYddid()) && !"5".equals(vo.getDdlb())){
        	if (hwRespMsg != null && "X".equals(hwRespMsg.getResult())) {
    			this.updateDDgz(vo);
    			// 海外sap接口调用成功 且业务处理成功后推送制造sap
    			try {
    				zzRespMsg = iOrderService.orderSdoToZzSap(
    						headerRequestListZz.get(0), bodyRequestListZz);
    			} catch (Exception e) {
    				throw new Exception("调用制造SAP大货订单接口失败！");
    			}
    			if (zzRespMsg != null && "X".equals(zzRespMsg.getResult())) {
    				vo.setTssapzt(1);// 海外sap成功 制造sap成功
    			} else {
    				vo.setTssapzt(2);// 海外sap成功 制造sap失败
    			}
    		} else {
    			vo.setTssapzt(0);// 海外sap失败 制造sap未推送
    		}
        }else{
        	//海外SAP成功,制造SAP不需要推
        	if("X".equals(hwRespMsg.getResult())){
        		vo.setTssapzt(3);// 海外sap成功 制造sap不需推
        	}else{
        		vo.setTssapzt(0);// 海外sap失败 制造sap未推送
        	}
        
        }
		Map<String,Object> map = new HashMap();
		map.put("hwRespMsg", hwRespMsg);
		map.put("zzRespMsg", zzRespMsg);	
		return map;
	}
	
	private BigDecimal paseYjbl(String xmlStr) {
		String yjblStr = "0.0";
		if (xmlStr != null && xmlStr != "") {
			Document doc = null;
			try {
				doc = DocumentHelper.parseText(xmlStr.substring(xmlStr.indexOf("<")));
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Element rootEle = doc.getRootElement();
			Element yjblEle = rootEle.element("YJBL");
			if (yjblEle!= null) {
				yjblStr = yjblEle.getTextTrim();
			}
		}
		return new BigDecimal(yjblStr);
	}

	// 保存推送制造SAP和海外SAP反馈细信息日志
	private SapInterfaceLogVo saveTsSapLog(OrderProductNewVo vo, Map<String, Object> resultMap) {
		OrderMsgResponse hwRespMsg = (OrderMsgResponse) resultMap.get("hwRespMsg");
		OrderMsgResponse zzRespMsg = (OrderMsgResponse) resultMap.get("zzRespMsg");
		if(zzRespMsg!=null){
			hwRespMsg.setMsg("海外："+hwRespMsg.getMsg()+",制造:"+zzRespMsg.getMsg());
		}else{
			hwRespMsg.setMsg("海外："+hwRespMsg.getMsg()+",制造:未推送！");
		}	
		if (vo == null) {
			throw new ServiceException("推送sap的vo为空");
		}
		// 保存推送日志
		SapInterfaceLogVo logvo = new SapInterfaceLogVo();
		logvo.setId(vo.getId());
		logvo.setDh(vo.getDdid());
		logvo.setMk("大货订单");
		logvo.setSj(new Date());
		logvo.setFhzt(vo.getTssapzt());
		logvo.setFhxx(hwRespMsg.getMsg());
		if(zzRespMsg!=null){
			logvo.setBw("推送海外SAP报文：【"+hwRespMsg.getInXml()+"】推送制造SAP报文：【"+zzRespMsg.getInXml()+"】");
		}else{
			logvo.setBw("推送海外SAP报文：【"+hwRespMsg.getInXml()+"】推送制造SAP报文：【】");
		}

		
		try {
			sapInterfaceLogService.save(logvo);
		} catch (Exception e) {
			throw new ServiceException("保存SAP返回信息日志出错");
		}
		return  logvo ;
	}
    
	@Transactional
	private void complete(OrderProductNewVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callComplete(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void active(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		dao.callActive(param);
		this.callAfter(param);
		// 变更结束发送邮件
		sendEmail(id,2);
	}
	
	// 根据PID同步SAP生产研发BOM
	@Transactional
	public void snycPidBom(OrderProductNewVo vo) {
		PidBomRequest pidBomRequest = new PidBomRequest();
		//工厂，先写死，后期要调
		pidBomRequest.setGc("1107");
		pidBomRequest.setPid(vo.getPid());
		// 首先删除原来的PID对应的pidbom数据
		productBomService.deleteByPid(vo);
		try {
			List<PidBomResponse> respList = pidBomInterfaceService.qryPidBomFromSap(pidBomRequest);
			for (PidBomResponse pidBom : respList) {
				ProductBomVo ProductBom = new ProductBomVo();
				ProductBom.setPid(pidBom.getPid());
				ProductBom.setWlbm(pidBom.getWlbh());
				ProductBom.setWlms(pidBom.getWlms());
				ProductBom.setDjyl(pidBom.getSl());
				ProductBom.setDw(pidBom.getDw());
				productBomService.saveOrUpdate(ProductBom);
			}
		} catch (Exception e) {
			throw new ServiceException("同步PID研发BOM出错");
		}
	}
	
	/**
	 * 比较两个对象的指定属性值是否相同
	 * @return true 相同，false 不相同
	 */
	private boolean isSameProperty(Object source,Object dest,String[]... propertyArrs) {
		BeanMap sourceMap = BeanMap.create(source);
		BeanMap destMap = BeanMap.create(dest);
		for (int i = 0; i < propertyArrs.length; i++) {
			String[] propertyArr = propertyArrs[i];
			for (int j = 0; j < propertyArr.length; j++) {
				String property = propertyArr[j];
				if (!sourceMap.containsKey(property)) {
					throw new ServiceException("访问的对象中未找到"+property+"这个属性");
				}
				Object sourceVal = sourceMap.get(property);
				Object destVal = destMap.get(property);
				
				if (sourceVal == null) {
					if (destVal != null && !"".equals(destVal)) {
						return false;
					}
				} else if (destVal == null) {
					if (sourceVal != null && !"".equals(sourceVal)) {
						return false;
					}
				} else {
					if (!sourceVal.toString().equals(destVal.toString())) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * TODO xuy 待完成，计划物控资源管理专员节点无法判断，原因：备损物料清单数据实时更新，提交时无法判断是否修改。
	 */
	@SuppressWarnings({ "unused", "rawtypes" })
	private void putBpmVariable(Map<String, Object> map, OrderProductNewVo vo) {
		Object oldVo = callQueryById(vo.getId());
		String[] cpxx = { "ppp", "pxh", "pxxbc", "sf3d", "fbl", "fblbz", "fblbz", "fblbz", "pld", "rz1Cb", "rz1Ce",
				"rz1Etl", "rz1Ul", "rz1Pse", "rz1Qt", "rz1Bz", "rz2Emc", "rz2Fcc", "rz2Meps", "rz2Es", "rz2Qt", "rz2Qt",
				"rz3Hdmi", "rz3Usb", "rz3Qt", "rz3Bz", "sfRohs", "sfReach", "ctlx", "ctlxbz", "sfSpq", "wkysbz",
				"paomo", "fhlQk", "fhlHk", "fhlDzjlz", "fhlAvzj", "fhlBz", "guajia", "guajia", "gjbz", "gjbz", "sfDc",
				"sf3dyj", "dzbz", "dzbzbz", "qtfjbz", "sfP", "sfIc", "sfShckdflgy", "skdqkxjgpj", "shckdjgyq",
				"shckdjgyqbz", "shckdxcxwlmx", "shckdxcxwlmxfj", "cpqtyqbz", "cpqtyqfj" };// 产品信息
		String[] mgxx = { "mk", "zsj", "ykq", "ykqbz", "sms", "smsbz", "smsyz", "yypbsx", "zx", "zxbz",
				"yszl", "hgtz", "hgtzbz", "poptz", "poptzbz", "nxtz", "nxtzbz", "spqtz", "spqtzbz", "bzk", "bzkbz",
				"dzazsm", "dzazsmsyz", "xlh", "yl", "ztwzyq", "ccyq", "xyzfyfs", "ztgmgzlMk", "ztgmgzlZsj",
				"ztgmgzlYkq", "ztgmgzlSms", "ztgmgzlZx", "ztgmgzlHgtz", "ztgmgzlPoptz", "ztgmgzlNxtz", "ztgmgzlSpqtz",
				"ztgmgzlBzk", "ztgmgzlDzazsm", "ztgmgzlZjxhtz", "mgqtyqbz", "mgqtyqfj" };// 美工信息
		String[] bsxx = {"sfFfbs","mfbs","bsbz","gdbslzg"};//备损信息

		String[] gc = { "mjxh", "ggmx", "sl", "zhbhwjP", "zhbhwjJk", "zhbhwjYkq", "zhbhwjLb", "zhbhwjZx", "zhbhwjPm",
				"zhbhwjJxZb", "xddzhP", "xddzhJk", "xddzhLb", "xddzhZx", "xddzhJxZb", "jhrq", "sfYh", "yhrq", "jbxxbz",
				"xwgj", "sq", "pp", "ccyy", "kjlogo" };// 工程科专员、工程技术专员
		boolean isGcSh = isSameProperty(oldVo, vo, gc, cpxx, mgxx);

		String[] iczy = {"jhrq","sl"};//IC资源评审专员
		boolean isIczySh = isSameProperty(oldVo, vo, iczy, mgxx, bsxx);
		
		String[] pzy = {"jhrq","sl"};//屏资源评审专员
		boolean isPzySh = isSameProperty(oldVo, vo, pzy, bsxx);
		
		String[] jhwkdd = {"jhrq","sl","shckdjgyq"};//计划物控订单评审专员
		boolean isJhwkddSh = isSameProperty(oldVo, vo, jhwkdd, mgxx);
		
		String[] jhwkzy = {"jhrq","sl"};//计划物控资源管理专员
		PageList list = (PageList)queryCkdByPage(new OrderProductCkdVo(), new PageJqGrid());
		
		
		String[] zsc = {"jhrq","sl","shckdjgyq"};//注塑厂评审专员
		boolean isZscSh = isSameProperty(oldVo, vo, zsc, mgxx);
		
		//美工专员
		boolean isMgSh = isSameProperty(oldVo, vo, mgxx);
	}
	
	public void getback(OrderProductNewVo vo){
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
	public void back(OrderProductNewVo vo) {
		//2.根据付款保障状态判断是否需要取消付款保障
		//3.将状态置为1
		//4.写进订单的审批日志，说明取回人
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		dao.callGetback(param);
		this.callAfter(param);
	}

	@Transactional
	public void pause(OrderProductNewVo vo, Integer type) {
		this.callBefore(vo);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", type);
		param.put("vo", vo);
		dao.callPause(param);
		this.callAfter(param);
	}
	/**
	 * 暂停提交
	 * @param vo
	 */
	@Transactional
	public void pauseSubmit(OrderProductNewVo vo) {
		this.callBefore(vo);
		OrderProductNewVo votemp = (OrderProductNewVo) this.callQueryById(vo.getId());
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", votemp);
		dao.callPauseSubmit(param);
		this.callAfter(param);
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("groupCode", votemp.getYwz());// 指定销售组长的业务组
		variables.put("deptCode", votemp.getXszz());//销售组织
		variables.put("xsyid", votemp.getXsyid());// 指定销售员进行审批
		variables.put("out", "commit");
		variables.put("xszz", votemp.getXszz());
		variables.put("wxdd", votemp.getSfWxdd());
		variables.put("scjd", votemp.getScjd());//流程判断条件：生产基地
		variables.put("id", votemp.getId());// 订单ID
		variables.put("ddlx", votemp.getDdlx());// 订单类型
		String sqr = UserUtils.hasRole("1-yx-xsy") ? "1-yx-xsy" : "0";
		variables.put("sqr", sqr);
		variables.put("sfNxyfcp", votemp.getSfNxyfcp());
		variables.put("gsbm", votemp.getGsbm());//公司编码；
		if(vo.getSfWxdd() == 0){
			variables.put("hwcpjl", votemp.getLccpjl());
		}else{
			variables.put("cpjl", votemp.getLccpjl());
		}	
		// 判断是否驳回
		if (!StringUtils.isEmpty(vo.getTaskId()) && !"null".equals(vo.getTaskId())) {
			// 驳回提交
			processTaskService.completeTask(vo.getTaskId(), vo.getZdrid(), variables);
		} else {
			// 开启审批流程
			ProcessBean processBean = new ProcessBean();
			processBean.setBusinessId(votemp.getId());
			processBean.setCode(votemp.getDdid());
			processBean.setProcessKey("OrderProduct_pause-new");
			if(votemp.getSfZt() == 1){
				processBean.setType(votemp.getDdlxmc() + "-暂停");
			}else {
				processBean.setType(votemp.getDdlxmc() + "-启用");
			}
			processBean.setUserId(votemp.getZdrid());
			processBean.setVariables(variables);
			processBean.setName("("+votemp.getGsbm()+")"+votemp.getKhmc());//公司编码+客户名称
			processInstanceService.startProcessInstance(processBean);
		}
	}
	/**
	 * 暂停审核
	 * @param vo
	 */
	@Transactional
	public void pauseApprove(OrderProductNewVo vo) {
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
			//processTaskService.rejectTaskRestart(vo.getProcessId());
			processTaskService.rejectTask(vo.getTaskId());
		}
		
		// 判断是不是终审
		boolean isEnd = processInstanceService.isProcessEnd(vo.getProcessId());
		if(isEnd && vo.getApproveType()==1){
			vo.setApproveType(3);
		}
		
		// 调用审批存储过程
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callPauseApprove(param);
		this.callAfter(param);
	}
	
	public Object callQueryByRwdh(String rwdh) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("rwdh", rwdh);
		dao.callSelectByRwdh(param);
		Integer rwdtype = (Integer)param.get("rwdtype");
		Integer bbh = (Integer)param.get("bbh");
		OrderProductNewVo vo = new OrderProductNewVo();
		vo.setRwdtype(rwdtype);
		vo.setBbh(bbh);
		return vo;
	}
	
	/**
	 * 大货订单修改交期
	 * @param vo
	 */
	@Transactional
	public void changeJhrq(OrderProductNewVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		dao.callChangeJhrq(param);
		this.callAfter(param);
	}
	
}