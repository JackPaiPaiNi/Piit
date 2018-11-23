package com.ey.piit.sdo.deliverplan.web.controller;

import java.util.List;
import java.util.Map;

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
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.deliverplan.service.DeliverPlanService;
import com.ey.piit.sdo.deliverplan.vo.DeliverPlanItemVo;
import com.ey.piit.sdo.deliverplan.vo.DeliverPlanVo;



/**
 * 走货计划单Controller
 * @author 
 */
@Controller
@RequestMapping(value = "deliverplan/deliverPlan")
public class DeliverPlanController extends BaseController {

	@Autowired
	private DeliverPlanService deliverPlanService;

	@RequiresPermissions("deliverplan:deliverPlan:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/deliverplan/deliverPlanList";
	}
	
	// 选走货计划明细页面
	@RequestMapping(value = {"zhjhList"})
	public String zhjhList() {
		return "sdo/deliverplan/deliverPlanZhjhList";
	}
	
	@RequiresPermissions("deliverplan:deliverPlan:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(DeliverPlanVo vo, PageJqGrid page) {
        return deliverPlanService.callQueryByPage(vo, page);
    }
	
	@RequiresPermissions("deliverplan:deliverPlan:view")
    @RequestMapping(value = "searchZhjh")
    @ResponseBody
    public Object searchZhjh(DeliverPlanVo vo, PageJqGrid page) {
        return deliverPlanService.callQueryZhjhByPage(vo, page);
    }
	
	// 未合并走货计划查询
	@RequiresPermissions("deliverplan:deliverPlan:view")
    @RequestMapping(value = "searchWhb")
    @ResponseBody
    public Object searchWhb(DeliverPlanVo vo, PageJqGrid page) {
        return deliverPlanService.callQueryWhbByPage(vo, page);
    }
	
	@RequiresPermissions("deliverplan:deliverPlan:view")
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
	@Token(create = true)
    public String editPage(){
    	return "sdo/deliverplan/deliverPlanEdit";
    }

	@RequiresPermissions("deliverplan:deliverPlan:view")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return deliverPlanService.callQueryById(id);
    }
	
    @RequestMapping(value = "/qryZhmx", method = RequestMethod.POST)
    @ResponseBody
    public Object qryZhmx(DeliverPlanVo vo, PageJqGrid page){
    	return deliverPlanService.qryZhmx(vo,page);
    }
    
    @RequiresPermissions("deliverplan:deliverPlan:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    @Token(verify = true)
    public Object edit(DeliverPlanVo vo, @RequestParam(value = "mxList")String mxList) {
    	JSONArray array = JSONArray.fromObject(mxList);
		@SuppressWarnings("unchecked")
		List<DeliverPlanItemVo> list = (List<DeliverPlanItemVo>) JSONArray.toCollection(array, DeliverPlanItemVo.class);
    	vo.setDeliverPlanItemList(list);
		return deliverPlanService.edit(vo);
    }
	
    @RequiresPermissions("deliverplan:deliverPlan:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public void submit(DeliverPlanVo vo, @RequestParam(value = "mxList")String mxList) {
    	JSONArray array = JSONArray.fromObject(mxList);
		@SuppressWarnings("unchecked")
		List<DeliverPlanItemVo> list = (List<DeliverPlanItemVo>) JSONArray.toCollection(array, DeliverPlanItemVo.class);
    	vo.setDeliverPlanItemList(list);
    	deliverPlanService.submit(vo);
    }
    
    @RequiresPermissions("deliverplan:deliverPlan:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id, String sjc) {
    	deliverPlanService.delete(id, sjc);
    }
	
    @RequiresPermissions("deliverplan:deliverPlan:view")
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/deliverplan/deliverPlanView");
		view.addObject("deliverPlan", deliverPlanService.callQueryById(id));
		return view;
	}
    
	@RequiresPermissions("deliverplan:deliverPlan:view")
    @RequestMapping(value = "printPage", method = RequestMethod.GET)
    public ModelAndView printPage(String id){
		ModelAndView view = new ModelAndView("sdo/deliverplan/deliverPlanPrint");
    	view.addObject("deliverPlan",deliverPlanService.callQueryById(id));
    	return view;
    }
	
	@RequiresPermissions("deliverplan:deliverPlan:view")
    @RequestMapping(value = "combineExport")
	public void combineExport(HttpServletResponse response, @RequestParam Map<String, Object> params, DeliverPlanVo vo) {
		deliverPlanService.combineExport(response, params, vo);
	}
	
	@RequiresPermissions("deliverplan:deliverPlan:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, DeliverPlanVo vo) {
		deliverPlanService.export(response, params, vo);
	}
	/**
	 * 合并走货计划单页面
	 */
	@RequiresPermissions("deliverplan:deliverPlan:view")
	@RequestMapping(value = {"combineList"})
	public String combineList() {
		return "sdo/deliverplan/deliverPlanCombineList";
	}
	
	/**
	 * 合并走货计划单
	 * @param vo
	 */
	@RequiresPermissions("deliverplan:deliverPlan:edit")
    @RequestMapping(value = "combine")
    @ResponseBody
    public Object combine(DeliverPlanVo vo) {
		return deliverPlanService.combine(vo);
    }
	/**
	 * 取消走货计划单
	 * @param id
	 * @param sjc
	 */
	@RequiresPermissions("deliverplan:deliverPlan:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(String id, String sjc) {
    	deliverPlanService.cancel(id, sjc);
    }
	
}