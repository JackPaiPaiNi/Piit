package com.ey.piit.sdo.payment.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.report.service.ReportService;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.payment.service.PaymentReportService;
import com.ey.piit.sdo.payment.vo.PayReceiveVo;
import com.ey.piit.sdo.payment.vo.PaymentReportVo;

/**
 * 付款保障报表Controller
 * 
 * @author 赵明
 */
@Controller
@RequestMapping(value = "payment/reports")
public class PaymentReportController extends BaseController {
	@Autowired
	private ReportService reportService;
	@Autowired
	private PaymentReportService paymentReportService;
	/**
	 * 收款银行当月总收款金额页面
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "beneficiaryBankReport"})
	public String beneficiaryBankMonthTotalReceivables(Model model) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String yyyymm = dateFormat.format(now);
		model.addAttribute("yyyymm", yyyymm);
		return "sdo/payment/beneficiaryBankReport";
	}
	/**
	 * 当月未认领凭证明细页面
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "notClaimDocumentsDetailReport"})
	public String notClaimDocumentsDetail(Model model) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String yyyymm = dateFormat.format(now);
		model.addAttribute("yyyymm", yyyymm);
		return "sdo/payment/notClaimDocumentsDetailReport";
	}
	/**
	 * 每个客户当月付款总金额及明细（已部分认领或全部认领）
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "customPayDetailReport"})
	public String customPayDetail(Model model) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String yyyymm = dateFormat.format(now);
		model.addAttribute("yyyymm", yyyymm);
		return "sdo/payment/customPayDetailReport";
	}
	/**
	 * 每一张凭证的预收款总金额及已绑定的预收款金额
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "depositReceiptTotalReport"})
	public String depositReceiptTotal() {
		return "sdo/payment/depositReceiptTotalReport";
	}
	/**
	 * PI与收款凭证号的关联关系及关联金额
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "relationshipRvnReport"})
	public String relationshipRvn() {
		return "sdo/payment/relationshipRvnReport";
	}
	/**
	 * 客户信用额度及使用情况
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "customerCreditAndUseReport"})
	public String customerCreditAndUse() {
		return "sdo/payment/customerCreditAndUseReport";
	}
	/**
	 * 每个客户当月L/C登记清单
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "customerLcRegistListReport"})
	public String customerLcRegistList(Model model) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String yyyymm = dateFormat.format(now);
		model.addAttribute("yyyymm", yyyymm);
		return "sdo/payment/customerLcRegistListReport";
	}
	/**
	 * PI与L/C关联关系
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "pIAndLCRelationshipReport"})
	public String pIAndLCRelationship() {
		return "sdo/payment/pIAndLCRelationshipReport";
	}
	/**
	 * L/C绑定使用情况
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "lCBindingsUsageReport"})
	public String lCBindingsUsage() {
		return "sdo/payment/lCBindingsUsageReport";
	}
	/**
	 * L/C金额、开票金额、回款金额总览
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "lCKpjeHkjeZlReport"})
	public String lCKpjeHkjeZl() {
		return "sdo/payment/lCKpjeHkjeZlReport";
	}
	/**
	 * L/C议付的发票及回款详情
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "lCNegotiationDetailReport"})
	public String lCNegotiationDetail() {
		return "sdo/payment/lCNegotiationDetailReport";
	}
	/**
	 * 特批记录
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "specialRecordReport"})
	public String specialRecord() {
		return "sdo/payment/specialRecordReport";
	}	
	/**
	 * 特批详细信息
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "specialRecordDetailReport"})
	public String specialRecordDetail() {
		return "sdo/payment/specialRecordDetailReport";
	}	
	/**
	 * 回款明细表
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "paymentScheduleReport"})
	public String paymentSchedule() {
		return "sdo/payment/paymentScheduleReport";
	}	
	/**
	 * 额度占用情况
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "creditOccupancyReport"})
	public String creditOccupancy() {
		return "sdo/payment/creditOccupancyReport";
	}		
	/**
	 * 客户付款情况总览
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "customerPaymentsReport"})
	public String customerPayments() {
		return "sdo/payment/customerPaymentsReport";
	}	
	/**
	 * 付款条件订单使用情况总览
	 */
	@RequiresPermissions("payment:reports:view")
	@RequestMapping(value = { "usagePaymentOrdersReport"})
	public String usagePaymentOrders() {
		return "sdo/payment/usagePaymentOrdersReport";
	}	
	/**
	 * 付款保障报表查询
	 * 
	 */
	@RequiresPermissions("payment:reports:view")
    @RequestMapping(value = {"searchReport"})
    @ResponseBody
    public Object searchReport(PaymentReportVo vo, PageJqGrid page) {
		return paymentReportService.callQueryByPage(vo, page);
    }	
	/**
	 * 导出
	 * */
	@RequiresPermissions("payment:reports:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PaymentReportVo vo) {
		paymentReportService.export(response, params, vo);
	}
}