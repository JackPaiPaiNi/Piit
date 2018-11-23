package com.ey.piit.sdo.invoice.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.report.service.ReportService;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.invoice.service.ShippingInstructionService;
import com.ey.piit.sdo.invoice.vo.ShippingInstructionItemVo;
import com.ey.piit.sdo.invoice.vo.ShippingInstructionVo;
import com.ey.piit.sdo.invoice.vo.ShippingReferDeliverVo;

/**
 * 补料单信息维护Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "invoice/shippingInstruction")
public class ShippingInstructionController extends BaseController {

	@Autowired
	private ShippingInstructionService shippingInstructionService;
	
	@Autowired
	private ReportService reportService;
	
	@RequiresPermissions("invoice:shippingInstruction:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/invoice/shippingInstructionList";
	}
	
	@RequiresPermissions("invoice:shippingInstruction:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ShippingInstructionVo vo, PageJqGrid page) {
        return shippingInstructionService.callQueryByPage(vo, page);
    }
	
	@RequiresPermissions("invoice:shippingInstruction:view")
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    public String editPage(){
    	return "sdo/invoice/shippingInstructionEdit";
    }
	
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public Object findById(String id){
    	return shippingInstructionService.callQueryById(id);
    }
	
	@RequiresPermissions("invoice:shippingInstruction:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public Object edit(ShippingInstructionVo vo, @RequestParam(value = "jzxList")String jzxList) {
    	JSONArray array = JSONArray.fromObject(jzxList);
		@SuppressWarnings("unchecked")
		List<ShippingInstructionItemVo> list = (List<ShippingInstructionItemVo>) JSONArray.toCollection(array, ShippingInstructionItemVo.class);
    	vo.setShippingInstructionItemList(list);
    	return shippingInstructionService.edit(vo);
    }
	
	@RequiresPermissions("invoice:shippingInstruction:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id) {
    	shippingInstructionService.delete(id);
    }
	
	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/invoice/shippingInstructionView");
    	view.addObject("shippingInstruction",shippingInstructionService.callQueryById(id)); 
    	return view;
    }
	
	
	@RequiresPermissions("invoice:shippingInstruction:view")
	@RequestMapping(value = {"shippingSearhList"})
	public String searchList() {
		return "sdo/invoice/shippingSearhList";
	}
	
	@RequiresPermissions("invoice:shippingInstruction:view")
    @RequestMapping(value = "searchChxx")
    @ResponseBody
    public Object searchChxx(ShippingReferDeliverVo vo, PageJqGrid page) {
        return shippingInstructionService.callQueryChxxByPage(vo, page);
    }
	
	@RequiresPermissions("invoice:shippingInstruction:view")
    @RequestMapping(value = "searchBlxx")
    @ResponseBody
    public Object searchBlxx(String chxx) {
        return shippingInstructionService.callQueryBlxx(chxx);
    }
	
	
	@RequiresPermissions("invoice:shippingInstruction:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ShippingInstructionVo vo) {
		shippingInstructionService.export(response, params, vo);
	}
	
	//出库明细导出
	@RequiresPermissions("invoice:shippingInstruction:view")
	@RequestMapping(value = "ckmxExport")
	@ResponseBody
	public void exportCkmxFile(HttpServletResponse response, @RequestParam Map<String, Object> params, ShippingInstructionItemVo vo) {
		shippingInstructionService.exportCkmx(response, params, vo);
	}
	
    /*@RequiresPermissions("invoice:shippingInstruction:view")
	@RequestMapping(value = "/report")
	public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		//parameters.put("invoiceNo", "D14/06/0204/EE/VW");

		//html
		reportService.exportHtml(request, response, "shippingInstruction.jasper", parameters);
	}*/
	
	@RequiresPermissions("invoice:shippingInstruction:view")
	@RequestMapping(value = "/reportDown")
	public void reportDown(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("V_BLDH", request.getParameter("bldh"));

		// excel
		reportService.exportExcel(request, response, "shippingInstruction.jasper", "shippingInstruction.xlsx", parameters);
	}

}