package com.ey.piit.sdo.invoice.service;

import java.math.BigDecimal;
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
import com.ey.piit.interfaces.invoice.dto.InvoiceHeaderDto;
import com.ey.piit.interfaces.invoice.dto.InvoiceMsgResponse;
import com.ey.piit.interfaces.invoice.service.InvoiceInterfaceService;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;
import com.ey.piit.interfaces.log.vo.SapInterfaceLogVo;
import com.ey.piit.sdo.invoice.repository.InvoiceDao;
import com.ey.piit.sdo.invoice.repository.InvoiceOtherDao;
import com.ey.piit.sdo.invoice.vo.InvoiceItemVo;
import com.ey.piit.sdo.invoice.vo.InvoiceOtherVo;
import com.ey.piit.sdo.invoice.vo.InvoiceVo;
import com.ey.piit.sdo.invoice.vo.WkptjVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 发票信息维护Service
 * 
 * @author 高文浩
 */
@Service
public class InvoiceService {

	@Autowired
	private InvoiceDao invoiceDao;
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
		invoiceDao.callSelect(param);
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
		invoiceDao.callSelect(param);
		List<InvoiceVo> list = (List<InvoiceVo>) param.get("list");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryById(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		invoiceDao.callSelectById(param);
		List<InvoiceVo> list = (List<InvoiceVo>) param.get("list");
		List<InvoiceItemVo> itemList = (List<InvoiceItemVo>) param.get("itemList");
		List<InvoiceItemVo> xdList = (List<InvoiceItemVo>) param.get("xdList");
		List<InvoiceOtherVo> qtList = (List<InvoiceOtherVo>) param.get("qtList");
		InvoiceVo vo = list.get(0);
		vo.setInvoiceItemList(itemList);
		vo.setInvoicePackingList(xdList);
		vo.setInvoiceOtherList(qtList);
		return vo;
	}

	@Transactional
	public Object edit(InvoiceVo vo) {
		BigDecimal qtzje = new BigDecimal(0);
		BigDecimal xdzje = new BigDecimal(0);
		for (InvoiceOtherVo invoiceOther : vo.getInvoiceOtherList()) {
			BigDecimal qtje = invoiceOther.getJe();
			qtzje.add(qtje);
		}
		for (InvoiceItemVo invoicePacking : vo.getInvoicePackingList()) {
			BigDecimal xdje = invoicePacking.getDhje();
			xdzje.add(xdje);
		}
		vo.setZje(qtzje.add(xdzje));
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
		invoiceDao.callSubmit(param);
		this.callAfter(param);
	}
	@Transactional
	public void submitFj(InvoiceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		invoiceDao.callSubmitFj(param);
		this.callAfter(param);
	}	
	@Transactional
	public void cancle(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		invoiceDao.callCancle(param);
		this.callAfter(param);
	}
	
	@Transactional
	public void delete(String id, String sjc) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("sjc", sjc);
		invoiceDao.callDelete(param);
		this.callAfter(param);
	}
	
	private Map<String, Object> save(InvoiceVo vo) {
		/*if ("null".equals(vo.getId()) || vo.getId() == null) {
			vo.setId(Identities.uuid());
		}*/
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		// 主表保存
		invoiceDao.callInsert(param);
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
		invoiceDao.callQryOrder(param);
		List<InvoiceItemVo> list = (List<InvoiceItemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryMain(String id, String kpfs, String chdhs, String ddids, String xdwlmsyy) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("kpfs", kpfs);
		param.put("chdhs", chdhs);
		param.put("ddids", ddids);
		param.put("xdwlmsyy", xdwlmsyy);
		invoiceDao.callQryMain(param);
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
	public Object callQueryItemByPage(String id, String xdwlmsyy, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("xdwlmsyy", xdwlmsyy);
		param.put("page", page);
		invoiceDao.callQryItem(param);
		List<InvoiceItemVo> list = (List<InvoiceItemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryPackingByPage(String id, String xdwlmsyy, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("xdwlmsyy", xdwlmsyy);
		param.put("page", page);
		invoiceDao.callQryPacking(param);
		List<InvoiceItemVo> list = (List<InvoiceItemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryOtherByPage(String id, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("page", page);
		invoiceDao.callQryOther(param);
		List<InvoiceItemVo> list = (List<InvoiceItemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getRows(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryMaterialByPage(String id, String wlbh, String wlms, String gh, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("wlbh", wlbh);
		param.put("wlms", wlms);
		param.put("gh", gh);
		param.put("page", page);
		invoiceDao.callQryMaterial(param);
		List<InvoiceItemVo> list = (List<InvoiceItemVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}

	@Transactional
	public void saveMaterial(String ids, String flag) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ids", ids);
		param.put("flag", flag);
		invoiceDao.callSaveMaterial(param);
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
		invoiceDao.callSaveTssapzt(param);
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
	public void tsSapAndWriteLog(InvoiceVo vo) {
		// 执行推送
		InvoiceMsgResponse invoiceMsgResponse = pushSAP(vo);
		// 更改单据推送状态
		saveTssapzt(vo);
		// 保存推送返回信息日志
		saveTsSapLog(vo, invoiceMsgResponse);
	}

	@Transactional
	public InvoiceMsgResponse pushSAP(InvoiceVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", vo.getId());
		param.put("fplx", vo.getFplx());
		iinvoiceDao.callSelectById(param);
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
		InvoiceMsgResponse invoiceMsgResponse = null;
		// 调用sap接口
		try {
			invoiceMsgResponse = invoiceInterfaceService.invoiceSdoToSap(headerRequestList.get(0), bodyRequestList);
		} catch (Exception e) {
			throw new ServiceException("调用SAP发票接口失败！");
		}
		// 商业发票推送SAP状态
		if (invoiceMsgResponse != null) {
			if ("X".equals(invoiceMsgResponse.getResult())) {
				if("1".equals(vo.getFplx())){
					vo.setTssapzt_syfp(1);
				}else{
					vo.setTssapzt_gsjfp(1);
				}
				
			} else {
				throw new ServiceException(invoiceMsgResponse.getMsg());
			}
		}
		return invoiceMsgResponse;
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
				//保存明细日志，id存储发票号的id，dh存储other明细id
				//saveChargesTsSapLog(charge.getId(),charge.getPzh(), tssapzt, charge.getMsg());
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
		invoiceDao.callSelectWkptj(param);
		List<WkptjVo> list = (List<WkptjVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
		return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callWkptjQuery(WkptjVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		invoiceDao.callSelectWkptj(param);
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
		
}