package com.ey.piit.sdo.track.web.controller;

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
import com.ey.piit.sdo.track.service.TrackStepDayDeadlineService;
import com.ey.piit.sdo.track.vo.TrackStepDayDeadlineVo;

/**
 * 订单节点预计完成时间设置Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "track/trackStepDayDeadline")
public class TrackStepDayDeadlineController extends BaseController {

	@Autowired
	private TrackStepDayDeadlineService trackStepDayDeadlineService;
	
	@RequiresPermissions("track:trackStepDayDeadline:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/track/trackStepDayDeadlineList";
	}
	
	@RequiresPermissions("track:trackStepDayDeadline:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(TrackStepDayDeadlineVo vo, PageJqGrid page) {
		return trackStepDayDeadlineService.queryByPage(vo, page);
    }
    
    @RequiresPermissions("track:trackStepDayDeadline:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(TrackStepDayDeadlineVo vo) {
		trackStepDayDeadlineService.edit(vo);
    }
	
	@RequiresPermissions("track:trackStepDayDeadline:view")
	@RequestMapping(value = "form")
	public String form(TrackStepDayDeadlineVo vo, Model model) {
		TrackStepDayDeadlineVo record = trackStepDayDeadlineService.findById(vo.getId());
		model.addAttribute("trackStepDayDeadline", record == null ? new TrackStepDayDeadlineVo() : record);
		return "sdo/track/trackStepDayDeadlineForm";
	}
	
	@RequiresPermissions("track:trackStepDayDeadline:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, TrackStepDayDeadlineVo vo) {
		trackStepDayDeadlineService.export(response, params, vo);
	}

}