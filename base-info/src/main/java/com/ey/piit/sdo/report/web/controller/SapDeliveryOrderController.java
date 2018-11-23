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
import com.ey.piit.sdo.report.service.SapDeliveryOrderService;
import com.ey.piit.sdo.report.vo.SapDeliveryOrderVo;

/**
 * SAP交货单明细Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "report/sapDeliveryOrder")
public class SapDeliveryOrderController extends BaseController {

	@Autowired
	private SapDeliveryOrderService sapDeliveryOrderService;
	
	@RequiresPermissions("report:sapDeliveryOrder:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(SapDeliveryOrderVo vo, PageJqGrid page) {
        return sapDeliveryOrderService.callSelectSapDeliveryByPage(vo, page);
    }
	
	@RequiresPermissions("report:sapDeliveryOrder:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/report/sapDeliveryOrderList";
	}
	
	@RequiresPermissions("report:sapDeliveryOrder:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, SapDeliveryOrderVo vo) {
		sapDeliveryOrderService.export(response, params, vo);
	}

}