package com.ey.piit.sdo.fcst.web.controller;

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
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.fcst.service.FcstWeekService;
import com.ey.piit.sdo.fcst.vo.FcstWeekVo;

/**
 * FCST周次定义Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "fcst/fcstWeek")
public class FcstWeekController extends BaseController {

	@Autowired
	private FcstWeekService fcstWeekService;
	
	@RequiresPermissions("fcst:fcstWeek:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(FcstWeekVo vo, PageJqGrid page) {
		return  fcstWeekService.queryByPage(vo, page);
    }
    
    @RequiresPermissions("fcst:fcstWeek:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(FcstWeekVo vo) {
		fcstWeekService.edit(vo);
    }
	
	@RequiresPermissions("fcst:fcstWeek:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/fcst/fcstWeekList";
	}
	
	@RequiresPermissions("fcst:fcstWeek:view")
	@RequestMapping(value = "form")
	public String form(FcstWeekVo vo, Model model) {
		FcstWeekVo record = fcstWeekService.findById(vo.getId());
		model.addAttribute("fcstWeek", record == null ? new FcstWeekVo() : record);
		return "sdo/fcst/fcstWeekForm";
	}
	
	@RequiresPermissions("fcst:fcstWeek:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, FcstWeekVo vo) {
		fcstWeekService.export(response, params, vo);
	}

}