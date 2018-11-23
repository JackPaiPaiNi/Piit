package com.ey.piit.sdo.invoice.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.interfaces.charges.dao.IchargesDao;
import com.ey.piit.interfaces.charges.dto.ChargesMsgResponse;
import com.ey.piit.interfaces.charges.service.ChargesInterfaceService;
import com.ey.piit.interfaces.invoice.dao.IinvoiceDao;
import com.ey.piit.interfaces.invoice.dto.InvoiceBodyDto;
import com.ey.piit.interfaces.invoice.dto.InvoiceCancelDto;
import com.ey.piit.interfaces.invoice.dto.InvoiceHeaderDto;
import com.ey.piit.interfaces.invoice.dto.InvoiceMsgResponse;
import com.ey.piit.interfaces.invoice.service.InvoiceInterfaceService;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.sdo.invoice.repository.InvoiceNewDao;
import com.ey.piit.sdo.invoice.repository.InvoiceOtherDao;
import com.ey.piit.sdo.invoice.vo.InvoiceDetailVo;
import com.ey.piit.sdo.invoice.vo.InvoiceDzbVo;
import com.ey.piit.sdo.invoice.vo.InvoiceItemVo;
import com.ey.piit.sdo.invoice.vo.InvoiceOtherVo;
import com.ey.piit.sdo.invoice.vo.InvoiceVo;
import com.ey.piit.sdo.invoice.vo.KpcyVo;
import com.ey.piit.sdo.invoice.vo.WkptjVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 发票信息维护Service
 * 
 * @author tianrong
 */
@Service
public class InvoiceNewService {

	@Autowired
	private InvoiceNewDao invoicenewDao;
	@Autowired
	private InvoiceOtherDao invoiceOtherDao;
	@Autowired
	private ExportUtil exportUtil;
	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
	@Autowired
	private IinvoiceDao iinvoiceDao;
	@Autowired
	private IchargesDao ichargesDao;
	@Autowired
	private InvoiceInterfaceService invoiceInterfaceService;
	@Autowired
	private ChargesInterfaceService chargesInterfaceService;

	@SuppressWarnings("unchecked")
	public Object callQueryByPage(InvoiceVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		invoicenewDao.callSelect(param);
		List<InvoiceVo> list = (List<InvoiceVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQuery(InvoiceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		invoicenewDao.callSelect(param);
		List<InvoiceVo> list = (List<InvoiceVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		invoicenewDao.callSelectById(param);
		List<InvoiceVo> list = (List<InvoiceVo>) param.get("list");
		List<InvoiceDetailVo> detailList = (List<InvoiceDetailVo>) param.get("detailList");
		List<InvoiceOtherVo> qtList = (List<InvoiceOtherVo>) param.get("qtList");
		InvoiceVo vo = list.get(0);
		vo.setInvoiceDetailList(detailList);
		vo.setInvoiceOtherList(qtList);
		return vo;
	}

	@Transactional
	public Object edit(InvoiceVo vo) {
		BigDecimal qtzje = new BigDecimal(0);
		for (InvoiceOtherVo invoiceOther : vo.getInvoiceOtherList()) {
			BigDecimal qtje = invoiceOther.getJe();
			qtzje.add(qtje);
		}
		vo.setZje(qtzje);
		// 数据保存前
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		// 数据保存后
		this.callAfter(param);
		return vo;
	}
	
	@Transactional
	public void submit(InvoiceVo vo) {
		this.callBefore(vo);
		Map<String, Object> param = this.save(vo);
		this.callAfter(param);
		invoicenewDao.callSubmit(param);
		this.callAfter(param);
	}
	@Transactional
	public void submitFj(InvoiceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		invoicenewDao.callSubmitFj(param);
		this.callAfter(param);
	}	
	
	@Transactional
	public Object cancle(String id,String sjc,String fph,String cxrq) {
		InvoiceVo vo = new InvoiceVo(id);
		//新逻辑：先检查SDO冲销是否满足条件，再处理SAP冲销，再处理SDO冲销
		Map<String, Object> param = new HashMap<String, Object>();
		this.callBefore(vo);
		param.put("vo", vo);
		invoicenewDao.callCancleCheck(param);
		if (!"SDO-000000".equals(param.get("resultCode").toString())) {
			throw new ServiceException(param.get("resultMsg").toString());
		}else{
			//冲销前，先判断是否有SAP返回的对照表（及是否有未冲销成功的明细）
			List<InvoiceDzbVo> dzblist =this.callQueryInvoiceDzbCxzt(id);
			if(dzblist != null && dzblist.size()>0){
				boolean flag = false;
				Map<String, Object> result = new HashMap<String, Object>();
				List<InvoiceCancelDto> iclist = new ArrayList<InvoiceCancelDto>();
				//冲销日期为空时，则默认获取当前时间
				if("".equals(cxrq)){
					cxrq = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				}
				//SAP冲销
				try {
					 iclist = invoiceInterfaceService.singleCancelInvoiceSdoToSap(fph,cxrq);
				} catch (Exception e) {
					throw new ServiceException("调用SAP发票冲销接口失败！");
				}
				if(iclist.size() > 0){
					result = validateInvoiceCancel(iclist);
					flag = (boolean) result.get("flag");
					//更新发票主表
					Map<String, Object> paramfp = new HashMap<String, Object>();
					if(flag){
						this.callBefore(vo);
						paramfp.put("vo", vo);
						invoicenewDao.callCancle(paramfp);
						this.callAfter(paramfp);
					}else {
						vo.setMsg((String) result.get("msg"));
					}
					//循环更新对账表的重新状态
					for (InvoiceCancelDto idto : iclist) {
						InvoiceDzbVo idVo = new InvoiceDzbVo();
						idVo.setType(2);
						idVo.setId(id);
						idVo.setFph(idto.getFph());
						idVo.setSapfph(idto.getSapfph());
						if(!StringUtils.isEmpty(idto.getFplx())){
							idVo.setSapfplx(Integer.parseInt(idto.getFplx()));
						}
						idVo.setResult(idto.getResult());
						idVo.setMsg(idto.getMsg());
						this.saveInvoicedzb(idVo);
					}
					
				}else{
					throw new ServiceException("SAP返回的冲销信息为空！");
				}
			}else{
				//仅更新本系统发票主表状态
				Map<String, Object> paramqx = new HashMap<String, Object>();
				this.callBefore(vo);
				paramqx.put("vo", vo);
				invoicenewDao.callCancle(paramqx);
				this.callAfter(paramqx);
			}
			return vo;
		}
			/*旧逻辑，先冲销SAP，再冲销SDO，若SDO冲销有问题，则返回失败，下次再取消时，SAP会找不到数据导致失败
			 * try {
				 iclist = invoiceInterfaceService.singleCancelInvoiceSdoToSap(fph,cxrq);
			} catch (Exception e) {
				throw new ServiceException("调用SAP发票冲销接口失败！");
			}	
			if(iclist.size() > 0){
				result = validateInvoiceCancel(iclist);
				flag = (boolean) result.get("flag");
				//更新发票主表
				Map<String, Object> param = new HashMap<String, Object>();
				if(flag){
					this.callBefore(vo);
					param.put("vo", vo);
					invoicenewDao.callCancle(param);
					this.callAfter(param);
				}else {
					vo.setMsg((String) result.get("msg"));
				}
				//循环更新对账表的重新状态
				for (InvoiceCancelDto idto : iclist) {
					InvoiceDzbVo idVo = new InvoiceDzbVo();
					idVo.setType(2);
					idVo.setId(id);
					idVo.setFph(idto.getFph());
					idVo.setSapfph(idto.getSapfph());
					if(!StringUtils.isEmpty(idto.getFplx())){
						idVo.setSapfplx(Integer.parseInt(idto.getFplx()));
					}
					idVo.setResult(idto.getResult());
					idVo.setMsg(idto.getMsg());
					
					this.saveInvoicedzb(idVo);
				}
				
			}else{
				throw new ServiceException("SAP返回的冲销信息为空！");
			}*/
	}
	
	//验证list是否全部成功
	public Map<String, Object> validateInvoiceCancel(List<InvoiceCancelDto> list){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean flag = true;
		StringBuffer msg = new StringBuffer();
		for(InvoiceCancelDto icdto:list){
			if("F".equals(icdto.getResult())){
				flag = false;
				msg.append("SAP发票" + icdto.getSapfph() + "冲销失败:" + icdto.getMsg() + ";");
			}
		}
		result.put("msg", msg.toString());
		result.put("flag", flag);
		return result;
	}
	
	@Transactional
	public void delete(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		invoicenewDao.callDelete(param);
		//this.callAfter(param);
	}
	
	private Map<String, Object> save(InvoiceVo vo) {
		/*if ("null".equals(vo.getId()) || vo.getId() == null) {
			vo.setId(Identities.uuid());
		}*/
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		invoicenewDao.callInsert(param);
		// 循环插入发票其他费用明细信息
		for (InvoiceOtherVo invoiceOther : vo.getInvoiceOtherList()) {
			invoiceOther.setFph(vo.getFph());
			invoiceOther.setId(Identities.uuid());
			Map<String, Object> dtlParam = new HashMap<String, Object>();
			dtlParam.put("vo", invoiceOther);
			invoiceOtherDao.callInsertOther(dtlParam);
			// 明细数据保存后
			this.callAfter(dtlParam);
		}
		return param;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryOrderByPage(InvoiceItemVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		invoicenewDao.callQryOrder(param);
		List<InvoiceItemVo> list = (List<InvoiceItemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryMain(String id, String kpfs, String chdhs, String ddids) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("kpfs", kpfs);
		param.put("chdhs", chdhs);
		param.put("ddids", ddids);
		invoicenewDao.callQryMain(param);
		List<InvoiceVo> invoiceList=((List<InvoiceVo>) param.get("list"));
		InvoiceVo vo =new InvoiceVo();
		if(invoiceList.size()>0){
			vo=invoiceList.get(0);
		}else{
			Object resultMsg = param.get("resultMsg");
			throw new ServiceException(resultMsg.toString());
		}
		return vo;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryDetailList(String id,String kpfs) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("kpfs", kpfs);
		invoicenewDao.callQryDetail(param);
		List<InvoiceDetailVo> list = (List<InvoiceDetailVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryOtherByPage(String id, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("page", page);
		invoicenewDao.callQryOther(param);
		List<InvoiceOtherVo> list = (List<InvoiceOtherVo>) param.get("list");
		/*Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);*/
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryMaterialByPage(String id, String wlbh, String gh,String xmlb, PageJqGrid page) {
		//处理wlbh列表
		String wlbhs = "";
		if(!"".equals(wlbh)){
			String[] wlbhz = wlbh.split("\r\n");
			for (int i = 0; i < wlbhz.length; i++) {
				if (wlbhz[i].length() > 0) {
					wlbhs = wlbhs  + "," + wlbhz[i].trim();
				}
			}
			if( wlbhs.length() > 1){
				wlbhs=wlbhs.substring(1);
			}else{
				wlbhs = "";
			}
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("wlbhs", wlbhs);
		param.put("ghs", gh);
		param.put("xmlb", xmlb);
		param.put("page", page);
		invoicenewDao.callQryMaterial(param);
		List<InvoiceDetailVo> list = (List<InvoiceDetailVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}

	@Transactional
	public void saveMaterial(String ids, String flag) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ids", ids);
		param.put("flag", flag);
		invoicenewDao.callSaveMaterial(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void saveTssapzt(InvoiceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		param.put("sjc", vo.getSjc());
		param.put("fplx", vo.getFplx());
		param.put("tssapzt_syfp", vo.getTssapzt_syfp());
		param.put("tssapzt_gsjfp", vo.getTssapzt_gsjfp());
		invoicenewDao.callSaveTssapzt(param);
		this.callAfter(param);
	}
	
	/**
	 * 调用存储过程操作数据前 对一些必须字段赋值
	 * 
	 * @param vo
	 */
	private void callBefore(InvoiceVo vo) {
		/*if (Oper.add.equals(vo.getOper())) {
			vo.preInsert();
		} else if (Oper.edit.equals(vo.getOper())) {
			vo.preUpdate();
		}*/
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
	public void export(HttpServletResponse response, Map<String, Object> params, InvoiceVo vo) {
		// TODO 自动生成的方法存根
		try {
			List<InvoiceVo> list = (List<InvoiceVo>) this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	// 推送SAP并且记录返信息货日志
	public Object tsSapAndWriteLog(InvoiceVo vo) {
		//推送前检查：如果推公司间发票，需检查是否是公司间业务，如果是，则不推送，并提示		
		// 执行推送
		InvoiceMsgResponse invoiceMsgResponse = pushSAP(vo);
		// 更改单据推送状态
		saveTssapzt(vo);
		// 保存推送返回信息日志
		saveTsSapLog(vo, invoiceMsgResponse);
		
		return vo;
	}
	
	

	@Transactional
	public InvoiceMsgResponse pushSAP(InvoiceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		param.put("fplx", vo.getFplx());
		iinvoiceDao.callnewSelectById(param);
		@SuppressWarnings("unchecked")
		List<InvoiceHeaderDto> headerRequestList = (List<InvoiceHeaderDto>) param.get("list");
		@SuppressWarnings("unchecked")
		List<InvoiceBodyDto> bodyRequestList = (List<InvoiceBodyDto>) param.get("itemList");
		if(headerRequestList.size()==0){
			throw new ServiceException("未取到发票主信息！");
		}
		if(bodyRequestList.size()==0){
			throw new ServiceException("未取到发票明细信息！");
		}
		InvoiceMsgResponse imr = new InvoiceMsgResponse();
		List<InvoiceMsgResponse> ImrList = new ArrayList<InvoiceMsgResponse>();
		// 调用sap接口
		try {
			ImrList = invoiceInterfaceService.invoicenewSdoToSap(headerRequestList.get(0), bodyRequestList);
		} catch (Exception e) {
			throw new ServiceException("调用SAP发票接口失败！");
		}
		//发票返回处理（部分失败表示发票整体推送失败）
		boolean flag = true;
		StringBuffer msg = new StringBuffer();
		StringBuffer sbmsg = new StringBuffer();
		if(ImrList.size() > 0){
			for(InvoiceMsgResponse invoiceMsgResponse : ImrList){
				if("X".equals(invoiceMsgResponse.getResult())){
					msg.append(invoiceMsgResponse.getChdh() + "(" + invoiceMsgResponse.getDdid() + ")成功:" + invoiceMsgResponse.getMsg() + ";");
				}else{
					flag = false;
					//失败消息需返回前台，单独接收
					sbmsg.append(invoiceMsgResponse.getChdh() + "(" + invoiceMsgResponse.getDdid() + ")失败:" + invoiceMsgResponse.getMsg() + ";");
				}
				//保存发票对照表
				InvoiceDzbVo invoiceDzbVo = new InvoiceDzbVo();
				invoiceDzbVo.setType(1);
				invoiceDzbVo.setId(vo.getId());
				invoiceDzbVo.setFph(invoiceMsgResponse.getFph());
				invoiceDzbVo.setChdh(invoiceMsgResponse.getChdh());
				invoiceDzbVo.setDdid(invoiceMsgResponse.getDdid());
				invoiceDzbVo.setSapfph(invoiceMsgResponse.getSapfph());
				invoiceDzbVo.setSapfplx(invoiceMsgResponse.getSapfplx());
				invoiceDzbVo.setSapfpje(invoiceMsgResponse.getSapfpje());
				invoiceDzbVo.setOutXml(invoiceMsgResponse.getOutXml());
				invoiceDzbVo.setResult(invoiceMsgResponse.getResult());
				invoiceDzbVo.setMsg(invoiceMsgResponse.getMsg());
				this.saveInvoicedzb(invoiceDzbVo);
			}
			if(flag){
				if("1".equals(vo.getFplx())){
					vo.setTssapzt_syfp(1);
				}else{
					vo.setTssapzt_gsjfp(1);
				}
			}else {
				vo.setMsg(sbmsg.toString());
			}
			//用于接口日志存储
			imr.setDh(ImrList.get(0).getFph());
			imr.setMsg(msg.append(sbmsg.toString()).toString());
			imr.setInXml(ImrList.get(0).getInXml());
		}
		return imr;
	}


	// 保存推送SAP日志
	public void saveTsSapLog(InvoiceVo vo, InvoiceMsgResponse invoiceMsgResponse) {
		if (vo == null) {
			throw new ServiceException("推送sap的vo为空");
		}
		if (invoiceMsgResponse == null) {
			throw new ServiceException("推送sap返回信息为空");
		}
		// 保存推送日志
		SapInterfaceLogVo logvo = new SapInterfaceLogVo();
		logvo.setId(vo.getId());
		logvo.setDh(invoiceMsgResponse.getDh());
		
		logvo.setSj(new Date());
		if("1".equals(vo.getFplx())){
			//商业发票
			logvo.setFhzt(vo.getTssapzt_syfp());
			logvo.setMk("商业发票");
		}else if("2".equals(vo.getFplx())){
			//公司间发票
			logvo.setFhzt(vo.getTssapzt_gsjfp());
			logvo.setMk("公司间发票");
		}
	
		logvo.setFhxx(invoiceMsgResponse.getMsg());
		logvo.setBw(invoiceMsgResponse.getInXml());
		try {
			sapInterfaceLogService.save(logvo);
		} catch (Exception e) {
			new ServiceException("保存SAP返回信息日志出错");
		}
	}
	
	// 保存发票对照表
	@Transactional
	public void saveInvoicedzb(InvoiceDzbVo invoiceDzbVo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", invoiceDzbVo);
		invoicenewDao.callSaveInvoiceDzb(param);
		this.callAfter(param);
	}
		
	//查询发票对照表
	@SuppressWarnings("unchecked")
	public Object callQueryInvoiceDzb(String id,String fplx) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("fplx", fplx);
		invoicenewDao.callQryInvoiceDzb(param);
		List<InvoiceDzbVo> list = (List<InvoiceDzbVo>) param.get("list");
		return list;
	}
	
	//查询发票对照表用于判断是否需要重新SAP（根据对照表中是否有未冲销的数据判断）
	@SuppressWarnings("unchecked")
	public List<InvoiceDzbVo> callQueryInvoiceDzbCxzt(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		invoicenewDao.callQryInvoiceDzbCxzt(param);
		List<InvoiceDzbVo> list = (List<InvoiceDzbVo>) param.get("list");
		return list;
	}
		
	/**
	 * 海运费接口推送
	 * */
	// 推送SAP并且记录返信息货日志
	public void tsChargesToSapAndWriteLog(InvoiceVo vo) {
		// 执行推送
		List<ChargesMsgResponse> list=pushChargesToSAP(vo);
		// 更改单据推送状态,循环保存推送返回信息日志
		saveOtherTssapzt(vo,list);
	}
	
	//推送sap
	@Transactional
	private List<ChargesMsgResponse> pushChargesToSAP(InvoiceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		ichargesDao.callSelectById(param);
		@SuppressWarnings("unchecked")
		List<ChargesMsgResponse> bodyRequestList = (List<ChargesMsgResponse>) param.get("list");
		List<ChargesMsgResponse> listcharesMsg=null;
		// 调用sap接口
		if(bodyRequestList.size()>0){
			try {
				listcharesMsg = chargesInterfaceService.chargesSdoToSap(bodyRequestList);
			} catch (Exception e) {
				throw new ServiceException("调用SAP工装海运费接口失败！");
			}
		}else{
			throw new ServiceException("工装海运费接口取数为空,无法推送SAP！");
		}
		return listcharesMsg;
	}
	//保存返回日志
	private void saveOtherTssapzt(InvoiceVo vo, List<ChargesMsgResponse> list) {
		// 回写工装海运费SAP状态  循环list，回写other明细表中的推送SAP状态
		for (ChargesMsgResponse charge : list) {
			int tssapzt = 0;
			Map<String, Object> param = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(charge.getPzh())) {
				tssapzt = 1;
			}
			param.put("id", charge.getId());
			param.put("tssapzt", tssapzt);
			try {
				invoiceOtherDao.callSaveOtherTssapzt(param);
				// 明细数据保存后
				this.callAfter(param);
				// 保存推送日志
				SapInterfaceLogVo logvo = new SapInterfaceLogVo();
				logvo.setId(charge.getId());
				logvo.setDh(charge.getPzh());
				logvo.setMk("工装海运费");
				logvo.setSj(new Date());
				logvo.setFhzt(tssapzt);
				logvo.setFhxx(charge.getMsg());
				logvo.setBw(charge.getInXml());
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
	 * 未开票统计查询
	 * */
	@SuppressWarnings("unchecked")
	public Object callWkptjQueryByPage(WkptjVo vo, PageBounds page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		invoicenewDao.callSelectWkptj(param);
		List<WkptjVo> list = (List<WkptjVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callWkptjQuery(WkptjVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		invoicenewDao.callSelectWkptj(param);
		List<WkptjVo> list = (List<WkptjVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public void Wkptjexport(HttpServletResponse response, Map<String, Object> params, WkptjVo vo) {
		try {
			List<WkptjVo> list = (List<WkptjVo>) this.callWkptjQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	@SuppressWarnings("unchecked")
	public Object callKpcyQuery(KpcyVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("chdhs", vo.getChdhs());
		param.put("ddids", vo.getDdids());
		invoicenewDao.callQryKpcy(param);
		List<KpcyVo> list = (List<KpcyVo>) param.get("list");
		return list;
	}
	@SuppressWarnings("unchecked")
	public void exportKpcy(HttpServletResponse response, Map<String, Object> params, KpcyVo vo) {
		// TODO 自动生成的方法存根
		try {
			List<KpcyVo> list = (List<KpcyVo>) this.callKpcyQuery(vo) ;
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
	}
	
	
	@Transactional
	public void changeFpzt(InvoiceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		invoicenewDao.callChangeFpzt(param);
		this.callAfter(param);
	}
		
}