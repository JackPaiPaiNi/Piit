package com.ey.piit.sdo.shipmentplan.web.controller;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.shipmentplan.vo.ShipmentPlanVo;
import com.ey.piit.sdo.shipmentplan.service.ShipmentPlanService;
/**
 * 走货计划Controller
 * 
 * @author tianrong
 */
@Controller
@RequestMapping(value = "shipmentplan/shipmentplan")
public class ShipmentPlanController extends BaseController {

	@Autowired
	private ShipmentPlanService shipmentPlanService;
 
	/**
	 * 走货计划菜单
	 * @return
	 */
	@RequiresPermissions("shipmentplan:shipmentplan:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/shipmentplan/shipmentPlanList";
	}

	/**
	 * 走货计划查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("shipmentplan:shipmentplan:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(ShipmentPlanVo vo, PageJqGrid page) {
		return shipmentPlanService.callQueryByPage(vo, page);
	}
	
	/**
	 * 走货计划保存
	 * @param vo
	 * @return
	 */
	@RequiresPermissions("shipmentplan:shipmentplan:edit")
	@RequestMapping(value = "edit")
	@ResponseBody
	public Object edit(ShipmentPlanVo vo) {
		return shipmentPlanService.edit(vo);
	}

	@RequestMapping(value = "/findByYzhdh", method = RequestMethod.POST)
	@ResponseBody
	public Object findByYzhdh(String yzhdh) {
		return shipmentPlanService.callQueryByYzhdh(yzhdh);
	}
	
	/**
	 * 导出
	 * @param response
	 * @param paramsf
	 * @param vo
	 */
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ShipmentPlanVo vo) {
		shipmentPlanService.export(response, params, vo);
	}
}