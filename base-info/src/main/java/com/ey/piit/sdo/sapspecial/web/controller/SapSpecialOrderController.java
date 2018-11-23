package com.ey.piit.sdo.sapspecial.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.sapspecial.service.SapSpecialOrderService;
import com.ey.piit.sdo.sapspecial.vo.SapSpecialOrderVo;

import net.sf.json.JSONArray;

/**
 * sap特价审批管理Controller
 * 
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "sapspecial/sapSpecialOrder")
public class SapSpecialOrderController extends BaseController {

	@Autowired
	private SapSpecialOrderService sapSpecialOrderService;

	@RequiresPermissions("sapspecial:sapSpecialOrder:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object callQueryByPage(SapSpecialOrderVo vo, PageJqGrid page) {
		return sapSpecialOrderService.callQueryByPage(vo, page);
	}

	@RequiresPermissions("sapspecial:sapSpecialOrder:view")
	@RequestMapping(value = "queryById")
	@ResponseBody
	public Object callQueryById(String id) {
		return sapSpecialOrderService.callQueryById(id);
	}

	@RequiresPermissions("sapspecial:sapSpecialOrder:edit")
	@RequestMapping(value = "approve")
	@ResponseBody
	public void edit(SapSpecialOrderVo vo) {
		sapSpecialOrderService.approve(vo);
	}

	@RequiresPermissions("sapspecial:sapSpecialOrder:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/sapspecial/specialList";
	}

	@RequiresPermissions("sapspecial:sapSpecialOrder:view")
	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/sapspecial/specialView");
		view.addObject("sapSpecialOrder", sapSpecialOrderService.callQueryById(id));
		return view;
	}

	@RequiresPermissions("sapspecial:sapSpecialOrder:view")
	@RequestMapping(value = "submit")
	@ResponseBody
	public Object submit(SapSpecialOrderVo vo, @RequestParam(value = "list") String list) {
		JSONArray array = JSONArray.fromObject(list);
		@SuppressWarnings("unchecked")
		List<SapSpecialOrderVo> objList = (List<SapSpecialOrderVo>) JSONArray.toCollection(array,SapSpecialOrderVo.class);
		sapSpecialOrderService.callSubmitList(objList);
		return vo;
	}
	
	@RequiresPermissions("sapspecial:sapSpecialOrder:edit")
	@RequestMapping(value = "approvePage", method = RequestMethod.GET)
	public ModelAndView approvePage(String id) {
		ModelAndView view = new ModelAndView("sdo/sapspecial/specialApprove");
		view.addObject("sapSpecialOrder", sapSpecialOrderService.callQueryById(id));
		return view;
	}
	
	@RequiresPermissions("sapspecial:sapSpecialOrder:view")
	@RequestMapping(value = "tsSap")
	@ResponseBody
	public Object tsSap(@RequestParam(value = "id")String id) {
		SapSpecialOrderVo vo = (SapSpecialOrderVo)sapSpecialOrderService.callQueryById(id);
		sapSpecialOrderService.tsSapAndWriteLog(vo);
		return vo;
	}
	
}