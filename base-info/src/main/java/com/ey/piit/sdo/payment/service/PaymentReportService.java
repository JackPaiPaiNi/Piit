package com.ey.piit.sdo.payment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.sdo.payment.repository.PaymentReportDao;
import com.ey.piit.sdo.payment.vo.PaymentReportVo;
import com.ey.piit.core.utils.ExportUtil;

/**
 * 付款保障报表Service
 * @author 赵明
 */
@Service
public class PaymentReportService {

	@Autowired
	private PaymentReportDao dao;
	
	@Autowired
	private ExportUtil exportUtil;
	/**
	 * 查询
	 * */
	@SuppressWarnings("unchecked")
	public Object callQueryByPage(PaymentReportVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		
		if("1".equals(vo.getLx())){
			// 收款银行当月总收款金额查询
			dao.callSelectBankMonthTotalReceivables(param);
		}else if("2".equals(vo.getLx())){
			// 当月未认领凭证明细查询
			dao.callSelectNotClaimDocumentsDetail(param);
		}else if("3".equals(vo.getLx())){
			// 每个客户当月付款总金额及明细（已部分认领或全部认领）查询
			dao.callSelectCustomPayDetail(param);
		}else if("4".equals(vo.getLx())){
			// 每一张凭证的预收款总金额及已绑定的预收款金额查询
			dao.callSelectDepositReceiptTotal(param);
		}else if("5".equals(vo.getLx())){
			// PI与收款凭证号的关联关系及关联金额
			dao.callSelectRelationshipRvn(param);
		}else if("6".equals(vo.getLx())){
			// 客户信用额度及使用情况
			dao.callSelectCustomerCreditAndUse(param);
		}else if("7".equals(vo.getLx())){
			// 每个客户当月L/C登记清单
			dao.callSelectCustomerLcRegistList(param);
		}else if("8".equals(vo.getLx())){
			// PI与L/C关联关系
			dao.callSelectPIAndLCRelationship(param);
		}else if("9".equals(vo.getLx())){
			// L/C绑定使用情况
			dao.callSelectLCBindingsUsage(param);
		}else if("10".equals(vo.getLx())){
			// L/C金额、开票金额、回款金额总览
			dao.callSelectLCKpjeHkjeZl(param);
		}else if("11".equals(vo.getLx())){
			// L/C议付的发票及回款详情
			dao.callSelectLCNegotiationDetail(param);
		}else if("12".equals(vo.getLx())){
			// 特批记录
			dao.callSelectSpecialRecord(param);
		}else if("13".equals(vo.getLx())){
			// 特批详细信息
			dao.callSelectSpecialRecordDetail(param);
		}else if("14".equals(vo.getLx())){
			// 回款明细表
			dao.callSelectPaymentSchedule(param);
		}else if("15".equals(vo.getLx())){
			// 额度占用情况
			dao.callSelectCreditOccupancy(param);
		}else if("16".equals(vo.getLx())){
			// 客户付款情况总览
			dao.callSelectCustomerPayments(param);
		}else if("17".equals(vo.getLx())){
			// 付款条件订单使用情况总览
			dao.callSelectUsagePaymentOrders(param);
		}
		List<PaymentReportVo> list = (List<PaymentReportVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	/**
	 * 导出
	 * */
	@SuppressWarnings("unchecked")
	public Object callQuery(PaymentReportVo vo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		
		if("1".equals(vo.getLx())){
			// 收款银行当月总收款金额查询
			dao.callSelectBankMonthTotalReceivables(param);
		}else if("2".equals(vo.getLx())){
			// 当月未认领凭证明细查询
			dao.callSelectNotClaimDocumentsDetail(param);
		}else if("3".equals(vo.getLx())){
			// 每个客户当月付款总金额及明细（已部分认领或全部认领）查询
			dao.callSelectCustomPayDetail(param);
		}else if("4".equals(vo.getLx())){
			// 每一张凭证的预收款总金额及已绑定的预收款金额查询
			dao.callSelectDepositReceiptTotal(param);
		}else if("5".equals(vo.getLx())){
			// PI与收款凭证号的关联关系及关联金额
			dao.callSelectRelationshipRvn(param);
		}else if("6".equals(vo.getLx())){
			// 客户信用额度及使用情况
			dao.callSelectCustomerCreditAndUse(param);
		}else if("7".equals(vo.getLx())){
			// 每个客户当月L/C登记清单
			dao.callSelectCustomerLcRegistList(param);
		}else if("8".equals(vo.getLx())){
			// PI与L/C关联关系
			dao.callSelectPIAndLCRelationship(param);
		}else if("9".equals(vo.getLx())){
			// L/C绑定使用情况
			dao.callSelectLCBindingsUsage(param);
		}else if("10".equals(vo.getLx())){
			// L/C金额、开票金额、回款金额总览
			dao.callSelectLCKpjeHkjeZl(param);
		}else if("11".equals(vo.getLx())){
			// L/C议付的发票及回款详情
			dao.callSelectLCNegotiationDetail(param);
		}else if("12".equals(vo.getLx())){
			// 特批记录
			dao.callSelectSpecialRecord(param);
		}else if("13".equals(vo.getLx())){
			// 特批详细信息
			dao.callSelectSpecialRecordDetail(param);
		}else if("14".equals(vo.getLx())){
			// 回款明细表
			dao.callSelectPaymentSchedule(param);
		}else if("15".equals(vo.getLx())){
			// 额度占用情况
			dao.callSelectCreditOccupancy(param);
		}else if("16".equals(vo.getLx())){
			// 客户付款情况总览
			dao.callSelectCustomerPayments(param);
		}else if("17".equals(vo.getLx())){
			// 付款条件订单使用情况总览
			dao.callSelectUsagePaymentOrders(param);
		}
		List<PaymentReportVo> list = (List<PaymentReportVo>) param.get("list");
		return list;
	}
	/**
	 * 导出
	 * */
	@SuppressWarnings("unchecked")
	public void export(HttpServletResponse response, Map<String, Object> params, PaymentReportVo vo){
		try {
			List<PaymentReportVo> list = (List<PaymentReportVo>)this.callQuery(vo);
			exportUtil.exportSync(response, params, list);
		} catch (Exception e) {
			throw new ServiceException("导出失败！");
		}
		
	}
}