package com.ey.piit.sdo.saprebate.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.saprebate.service.RebateService;
import com.ey.piit.sdo.saprebate.vo.TitleVo;

/**
 * sap费用申请审批Controller
 * 
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "rebate/expApply")
public class ExpApplyController extends BaseController {

	@Autowired
	private RebateService rebateService;

	@RequiresPermissions("rebate:expApply:edit")
	@RequestMapping(value = { "approve" })
	@ResponseBody
	public void approve(TitleVo vo) {
		 rebateService.approveRebateExpApply(vo);

	}
	//推送sap
	@RequiresPermissions("rebate:expApply:view")
	@RequestMapping(value = "tsSap")
	@ResponseBody
	public Object tsSap(@RequestParam(value = "id") String id) {
		TitleVo vo = rebateService.callQueryExpApplyById(id);
	    rebateService.tsSapAndWriteLogExpApply(vo);
	    return vo ;
	}

	// 费用申请审批
	@RequiresPermissions("rebate:expApply:edit")
	@RequestMapping(value = { "approvePage" })
	public String approvePage() {
		return "sdo/saprebate/expApplyApprove";
	}

	// 费用申请查看界面
	@RequiresPermissions("rebate:expApply:edit")
	@RequestMapping(value = { "viewPage" })
	public ModelAndView expAplyAprovePage(String id) {
		ModelAndView mv = new ModelAndView("sdo/saprebate/expApplyView");
		mv.addObject("title", rebateService.callQueryExpApplyById(id));
		return mv;
	}

}