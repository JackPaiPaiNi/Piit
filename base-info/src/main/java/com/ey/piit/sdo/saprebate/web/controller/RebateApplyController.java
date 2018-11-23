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
import com.ey.piit.sdo.saprebate.vo.RebateApplyVo;
import com.ey.piit.sdo.saprebate.vo.TitleVo;

import net.sf.json.JSONArray;

/**
 * sap返利申报审批Controller
 * 
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "rebate/rebateApply")
public class RebateApplyController extends BaseController {

	@Autowired
	private RebateService rebateService;

	@RequiresPermissions("rebate:rebateApply:edit")
	@RequestMapping(value = { "approve" })
	@ResponseBody
	public void approve(TitleVo vo, @RequestParam(value = "itemList") String itemList) {
		JSONArray array = JSONArray.fromObject(itemList);
		@SuppressWarnings("unchecked")
		List<RebateApplyVo> objList = (List<RebateApplyVo>) JSONArray.toCollection(array, RebateApplyVo.class);
		vo.setRbtApplyList(objList);
		 rebateService.approveRebateApply(vo);
	}

	// 返利申报审批
	@RequiresPermissions("rebate:rebateApply:edit")
	@RequestMapping(value = { "approvePage" })
	@ResponseBody
	public ModelAndView approvePage(String id) {
		ModelAndView mv = new ModelAndView("sdo/saprebate/rebateApplyApprove");
		mv.addObject("title", rebateService.callQueryRebateApplyById(id));
		return mv;
	}

	// 推送sap
	@RequiresPermissions("rebate:rebateApply:view")
	@RequestMapping(value = "tsSap")
	@ResponseBody
	public Object tsSap(@RequestParam(value = "id") String id) {
		TitleVo vo = rebateService.callQueryRebateApplyById(id);
		rebateService.tsSapAndWriteLogRebateApply(vo);
		return vo;
	}

	// 根据id查返利申报明细
	@RequiresPermissions("rebate:rebateApply:view")
	@RequestMapping(value = { "queryById" })
	@ResponseBody
	public Object queryById(String id) {
		return rebateService.callQueryRebateApplyById(id).getRbtApplyList();
	}

	// 返利申报查看界面
	@RequiresPermissions("rebate:rebateApply:edit")
	@RequestMapping(value = { "viewPage" })
	public ModelAndView expAplyAprovePage(String id) {
		ModelAndView mv = new ModelAndView("sdo/saprebate/rebateApplyView");
		mv.addObject("title", rebateService.viewRebateApplyById(id));
		return mv;
	}

}