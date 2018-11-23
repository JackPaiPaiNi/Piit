package com.ey.piit.sdo.order.service;

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

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.service.MimeMailService;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.interfaces.order.dao.IOrderDao;
import com.ey.piit.interfaces.order.dto.OrderBodyDto;
import com.ey.piit.interfaces.order.dto.OrderHeaderDto;
import com.ey.piit.interfaces.order.dto.OrderMsgResponse;
import com.ey.piit.interfaces.order.dto.OrderZZHeaderDto;
import com.ey.piit.interfaces.order.service.OrderInterfaceService;
import com.ey.piit.sdo.order.entity.OrderReceiver;
import com.ey.piit.sdo.order.entity.OrderToSap;
import com.ey.piit.sdo.order.repository.OrderDiversityDao;
import com.ey.piit.sdo.order.repository.OrderFyDao;
import com.ey.piit.sdo.order.repository.OrderProductDao;
import com.ey.piit.sdo.order.repository.OrderSampleDao;
import com.ey.piit.sdo.order.repository.OrderSpoDao;
import com.ey.piit.sdo.order.repository.OrderToSapDao;
import com.ey.piit.sdo.order.vo.OrderEmailVo;
import com.ey.piit.sdo.order.vo.OrderToSapVo;
import com.ey.piit.sdo.pub.repository.EmailDao;
import com.ey.piit.sdo.pub.vo.EmailVo;

/**
 * 订单推送SAP管理Service
 * 
 * @author 赵明
 * @param <E>
 */
@Service
public class OrderToSapService<E> {

	@Autowired
	private OrderProductDao productDao;
	@Autowired
	private OrderSpoDao spoDao;
	@Autowired
	private OrderSampleDao sampleDao;
	@Autowired
	private OrderDiversityDao diversityDao;
	@Autowired
	private OrderFyDao fyDao;
	@Autowired
	private OrderToSapDao tdao;
	
	@Autowired
	private ExportUtil exportUtil;

	@Autowired
	private IOrderDao iDao;
	@Autowired
	private EmailDao emailDao;
	@Autowired
	private OrderInterfaceService iOrderService;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
	
	@Autowired
	private MimeMailService mimeMailService;//邮件服务类
    @Value("${email.url}")
    private String url;
    
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(OrderToSapVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		tdao.callSelect(param);
		List<OrderToSapVo> list = (List<OrderToSapVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}

	@SuppressWarnings("unchecked")
	public Object callQuery(OrderToSapVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		productDao.callSelect(param);
		List<OrderToSapVo> list = (List<OrderToSapVo>) param.get("list");
		return list;
	}
	@Transactional
	public Object closeOrder(OrderToSapVo vo) {
		this.callBefore(vo);
		this.save(vo);
		return vo;
	}
	/**
	 * 关闭推送SAP
	 * 
	 * @param vo
	 * @return
	 */
	private Map<String, Object> save(OrderToSapVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		tdao.callCloseOrder(param);
		this.callAfter(param);
		return param;
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
	public void export(HttpServletResponse response, Map<String, Object> params, OrderToSapVo vo) {
		try {
			List<OrderToSapVo> list = (List<OrderToSapVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	// 推送海外SAP并且记录返信息货日志
	@SuppressWarnings({ "rawtypes" })
	public Object tsHwSapAndWriteLog(OrderToSap vo,String lx, int tsfs) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		List  list = new ArrayList();
		param.put("id", vo.getId());
		if("1".equals(vo.getDdlx())){
			productDao.callSelectById(param);
			list = (List) param.get("list");
		}else if("2".equals(vo.getDdlx())){
			spoDao.callSelectById(param);
			list = (List) param.get("list");
		}else if("3".equals(vo.getDdlx())){
			sampleDao.callSelectById(param);
			list = (List) param.get("list");
		}else if("4".equals(vo.getDdlx())){
			diversityDao.callSelectById(param);
			list = (List) param.get("list");
		}else if("5".equals(vo.getDdlx())){
			fyDao.callSelectById(param);
			list = (List) param.get("list");
		}
		if(list.size() == 0){
			throw new ServiceException("系统推送SAP时未找到订单信息！");
		}
		// 执行推送
		Map<String, Object> resultMap;
		try {
			resultMap = pushSAP(vo,lx,tsfs);
		} catch (Exception e) {
			throw e;
		}
		// 保存推送返回信息日志
		SapInterfaceLogVo logVo = saveTsSapLog(vo, resultMap, lx);
		// 返回消息
		vo.setMsg(logVo.getFhxx());
		// 推送SAP成功后发送邮件
		if(vo.getBg_hwtssapzt()==1||vo.getBg_zztssapzt()==1){
			// 更改单据推送状态
			this.complete(vo);
			// 正常推送
			//sendEmail(vo.getId(),Integer.parseInt(vo.getDdlx()));
		}
		return vo ;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	private Map<String, Object> pushSAP(OrderToSap vo,String lx,int tsfs) throws Exception {
		Map<String, Object> paramHw = new HashMap<String, Object>();
		Map<String, Object> paramZz = new HashMap<String, Object>();
		
		paramHw.put("id", vo.getId());	
		paramHw.put("tsfs", tsfs);	
		paramZz.put("id", vo.getId());
		paramZz.put("tsfs", tsfs);

		List<OrderHeaderDto> headerRequestListHw = new ArrayList<OrderHeaderDto>() ;
		List<OrderBodyDto> bodyRequestListHw = new ArrayList<OrderBodyDto>() ;
		List<OrderZZHeaderDto> headerRequestListZz = new ArrayList<OrderZZHeaderDto>() ;
		List<OrderBodyDto> bodyRequestListZz = new ArrayList<OrderBodyDto>() ;
		
		OrderMsgResponse hwRespMsg = null;
		OrderMsgResponse zzRespMsg = null;
		if("1".equals(lx)){
			if("1".equals(vo.getDdlx())){
				iDao.callSelectProductBgHw(paramHw);
			}else if("2".equals(vo.getDdlx())){
				iDao.callSelectSpoBgHw(paramHw);
			}else if("3".equals(vo.getDdlx())){
				iDao.callSelectSimpleBgHw(paramHw);
			}else if("4".equals(vo.getDdlx())){
				iDao.callSelectDiversityBgHw(paramHw);
			}else if("5".equals(vo.getDdlx())){
				iDao.callSelectFyBgHw(paramHw);
			}
			headerRequestListHw = (List<OrderHeaderDto>) paramHw.get("list");
			bodyRequestListHw = (List<OrderBodyDto>) paramHw.get("itemList");	
			// 调用sap接口
			try {
				//0代表海外推送失败; null ：没推送过 
				hwRespMsg = iOrderService.orderSdoToHwSap(headerRequestListHw.get(0), bodyRequestListHw);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("调用海外SAP大货订单接口失败！");
			}
			if (hwRespMsg != null && "X".equals(hwRespMsg.getResult())) {
				vo.setBg_hwtssapzt(1);// 海外sap成功
				vo.setBg_zztssapzt(9); 
			}else{
				vo.setBg_hwtssapzt(0);// 海外sap失败
				vo.setBg_zztssapzt(9); 
			}
		}else{
			if("1".equals(vo.getDdlx())){
				iDao.callSelectProductBgZz(paramZz);
			}else if("2".equals(vo.getDdlx())){
				iDao.callSelectSpoBgZz(paramZz);
			}else if("3".equals(vo.getDdlx())){	
				iDao.callSelectSimpleBgZz(paramZz);
			}else if("4".equals(vo.getDdlx())){
				iDao.callSelectDiversityBgZz(paramZz);
			}else if("5".equals(vo.getDdlx())){
				iDao.callSelectFyBgZz(paramZz);
			}
			headerRequestListZz = (List<OrderZZHeaderDto>) paramZz.get("list");
			bodyRequestListZz = (List<OrderBodyDto>) paramZz.get("itemList");
			// 调用sap接口
			try {
				//0代表制造推送失败; null ：没推送过 
				zzRespMsg = iOrderService.orderSdoToZzSap(headerRequestListZz.get(0), bodyRequestListZz);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("调用制造SAP大货订单接口失败！");
			}
			if (zzRespMsg != null && "X".equals(zzRespMsg.getResult())) {
				vo.setBg_zztssapzt(1);// 制造sap成功
				vo.setBg_hwtssapzt(9); 
			}else{
				vo.setBg_zztssapzt(0);// 制造sap失败
				vo.setBg_hwtssapzt(9); 
			}
		}

		Map<String,Object> map = new HashMap();
		map.put("hwRespMsg", hwRespMsg);
		map.put("zzRespMsg", zzRespMsg);
		map.put("ddlx", vo.getDdlx());
		map.put("hwfhzt", vo.getBg_hwtssapzt());
		map.put("zzfhzt", vo.getBg_zztssapzt());
		return map;
	}

	// 保存推送海外SAP反馈细信息日志
	private SapInterfaceLogVo saveTsSapLog(OrderToSap vo, Map<String, Object> resultMap,String lx) {
		OrderMsgResponse hwRespMsg = (OrderMsgResponse) resultMap.get("hwRespMsg");
		OrderMsgResponse zzRespMsg = (OrderMsgResponse) resultMap.get("zzRespMsg");
		if("1".equals(lx)){
			hwRespMsg.setMsg("变更推送海外："+hwRespMsg.getMsg()+"");
		}else{
			zzRespMsg.setMsg("变更推送制造："+zzRespMsg.getMsg()+"");
		}
		if (vo == null) {
			throw new ServiceException("推送海外/制造sap的vo为空");
		}
		// 保存推送日志
		SapInterfaceLogVo logvo = new SapInterfaceLogVo();
		if("1".equals(vo.getDdlx())){
			logvo.setMk("大货订单(变更)");
		}else if("2".equals(vo.getDdlx())){
			logvo.setMk("备损订单(变更)");
		}else if("3".equals(vo.getDdlx())){
			logvo.setMk("样机订单(变更)");
		}else if("4".equals(vo.getDdlx())){
			logvo.setMk("多元化订单(变更)");
		}else if("5".equals(vo.getDdlx())){
			logvo.setMk("副营订单(变更)");
		}
		logvo.setId(vo.getId());
		logvo.setDh(vo.getDdid());
		logvo.setFhzt(vo.getBg_hwtssapzt());
		logvo.setSj(new Date());
		if("1".equals(lx)){
			logvo.setFhxx(hwRespMsg.getMsg());
			logvo.setBw("变更推送海外SAP报文：【"+hwRespMsg.getInXml()+"】");
		}else{
			logvo.setFhxx(zzRespMsg.getMsg());
			logvo.setBw("变更推送制造SAP报文：【"+zzRespMsg.getInXml()+"】");
		}
		try {
			sapInterfaceLogService.save(logvo);
		} catch (Exception e) {
			throw new ServiceException("保存SAP返回信息日志出错");
		}
		return  logvo ;
	}
	@Transactional
	private void complete(OrderToSap vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ddlx", vo.getDdlx());
		param.put("bg_hwtssapzt", vo.getBg_hwtssapzt());
		param.put("bg_zztssapzt", vo.getBg_zztssapzt());
		param.put("id", vo.getId());
		param.put("sjc", vo.getSjc());
		tdao.callComplete(param);
		this.callAfter(param);
	}
	//发送邮件zt:1 正常 2 变更
	public void sendEmail(String id,int lx){
		OrderEmailVo  orderEmailVo = (OrderEmailVo) this.callQueryEmailById(id,lx);
		Map<String,Object> map = this.emailHelper(orderEmailVo,lx);	
		List<OrderReceiver> orderList=orderEmailVo.getReceiverList();
		for(OrderReceiver or:orderList){
			try {
				mimeMailService.sendEmail(or.getSjr(), map.get("subject").toString(), map.get("content").toString());
			} catch (Exception e) {
				EmailVo emailVo = new EmailVo();
				emailVo.setYwid(id);
				emailVo.setYwdh(orderEmailVo.getDdid());
				emailVo.setYxdz(or.getSjr());
				if(lx == 1){
					emailVo.setName("大货订单变更");
				}else if(lx == 2){
					emailVo.setName("备损订单变更");
				}else if(lx == 3){
					emailVo.setName("样机订单变更");
				}else if(lx == 4){
					emailVo.setName("多元化订单变更");
				}else if(lx == 5){
					emailVo.setName("副营订单变更");
				}
				emailVo.setText(e.getMessage());
				emailDao.insert(emailVo);
			}
		}
	}
	//取订单邮件内容
	@SuppressWarnings("unchecked")
	public Object callQueryEmailById(String id,int lx) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("lx", lx);
		param.put("zt", 2);
		productDao.callSelectEmail(param);
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
	private Map<String,Object> emailHelper(OrderEmailVo orderEmailVo,int lx){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> drlist=new ArrayList<String>();//收件人列表
		//邮件标题：[提交人姓名]|订单类型|订单号|客户名称
		StringBuffer subject = new StringBuffer();//邮件主题
		StringBuffer content = new StringBuffer();//邮件正文
		String url_tmp="";
		if(lx == 1){
			url_tmp=url+"/base-web/order/orderProduct/viewPage?id="+orderEmailVo.getId();
		}else if(lx == 2){
			url_tmp=url+"/base-web/order/orderPso/viewPage?id="+orderEmailVo.getId();
		}else if(lx == 3){
			url_tmp=url+"/base-web/order/orderSample/viewPage?id="+orderEmailVo.getId();
		}else if(lx == 4){
			url_tmp=url+"/base-web/order/orderDiversity/viewPage?id="+orderEmailVo.getId();
		}else if(lx == 5){
			url_tmp=url+"/base-web/order/orderFy/viewPage?id="+orderEmailVo.getId();
		}
		//组装收件人列表
		List<OrderReceiver> orderList=orderEmailVo.getReceiverList();
		for(OrderReceiver or:orderList){
			drlist.add(or.getSjr());
		}
		//组装邮件主题
		subject.append("[工作流][变更新任务]");	
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
		提交人：...
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
	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(OrderToSapVo vo) {
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
}