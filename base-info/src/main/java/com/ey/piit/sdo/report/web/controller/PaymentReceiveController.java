package com.ey.piit.sdo.report.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.report.service.PaymentReceiveService;
import com.ey.piit.sdo.report.vo.PaymentReceiveVo;

/**
 * 回款信息表Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "report/paymentReceive")
public class PaymentReceiveController extends BaseController {

	@Autowired
	private PaymentReceiveService reportService;
	
	@RequiresPermissions("report:paymentReceive:view")
	@RequestMapping(value = "")
	public String list() {
		return "sdo/report/paymentReceiveList";
	}
	/**
	 * 回款信息表页面查询方法
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("report:paymentReceive:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(PaymentReceiveVo vo, PageJqGrid page) {
        return reportService.callSelectPaymentReceiveByPage(vo, page);
    }	
	/**
	 * 回款信息表导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("report:paymentReceive:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PaymentReceiveVo vo) {
		reportService.export(response, params, vo);
	}
	
	
}