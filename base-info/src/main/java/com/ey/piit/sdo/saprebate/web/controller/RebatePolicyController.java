package com.ey.piit.sdo.saprebate.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.saprebate.service.RebateService;
import com.ey.piit.sdo.saprebate.vo.RebatePolicyVo;
import com.ey.piit.sdo.saprebate.vo.TitleVo;

import net.sf.json.JSONArray;

/**
 * sap返利政策审批Controller
 * 
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "rebate/rebatePolicy")
public class RebatePolicyController extends BaseController {

	@Autowired
	private RebateService rebateService;

	@RequiresPermissions("rebate:rebatePolicy:edit")
	@RequestMapping(value = { "approve" })
	@ResponseBody
	public void approve(TitleVo vo, @RequestParam(value = "itemList") String itemList) {
		JSONArray array = JSONArray.fromObject(itemList);
		@SuppressWarnings("unchecked")
		List<RebatePolicyVo> objList = (List<RebatePolicyVo>) JSONArray.toCollection(array, RebatePolicyVo.class);
		vo.setRbpPolicyList(objList);
		 rebateService.callApproveRebatePolicy(vo);
	}

	// 推送sap
	@RequiresPermissions("rebate:rebatePolicy:view")
	@RequestMapping(value = "tsSap")
	@ResponseBody
	public Object tsSap(@RequestParam(value = "id") String id) {
		TitleVo vo = rebateService.callQueryRebatePolicyById(id);
		rebateService.tsSapAndWriteLogRebatePolicy(vo);
		return vo;
	}

	// 返利政策审批界面
	@RequiresPermissions("rebate:rebatePolicy:edit")
	@RequestMapping(value = { "viewPage" })
	public ModelAndView viewPage(String id) {
		ModelAndView mv = new ModelAndView("sdo/saprebate/rebatePolicyView");
		mv.addObject("title", rebateService.viewRebatePolicyById(id));
		return mv;
	}

	// 返利政策查看界面
	@RequiresPermissions("rebate:rebatePolicy:edit")
	@RequestMapping(value = { "approvePage" })
	public ModelAndView approvePage(String id) {
		ModelAndView mv = new ModelAndView("sdo/saprebate/rebatePolicyApprove");
		mv.addObject("title", rebateService.callQueryRebatePolicyById(id));
		return mv;
	}

	// 根据id查询返利政策明细
	@RequiresPermissions("rebate:rebatePolicy:edit")
	@RequestMapping(value = { "queryById" })
	@ResponseBody
	public Object queryById(String id) {
		return rebateService.callQueryRebatePolicyById(id).getRbpPolicyList();
	}

}