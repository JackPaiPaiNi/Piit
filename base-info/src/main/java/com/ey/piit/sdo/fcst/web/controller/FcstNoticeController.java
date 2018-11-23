package com.ey.piit.sdo.fcst.web.controller;

import java.util.List;
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
import com.ey.piit.sdo.fcst.service.FcstNoticeService;
import com.ey.piit.sdo.fcst.vo.FcstNoticeVo;

/**
 * fcstController
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "fcst/fcstNotice")
public class FcstNoticeController extends BaseController {

	@Autowired
	private FcstNoticeService fcstNoticeService;
	
	@RequiresPermissions("fcst:fcstNotice:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(FcstNoticeVo vo, PageJqGrid page) {
        List<FcstNoticeVo> list = fcstNoticeService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("fcst:fcstNotice:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(FcstNoticeVo vo) {
		fcstNoticeService.edit(vo);
    }
	
	@RequiresPermissions("fcst:fcstNotice:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/fcst/fcstNoticeList";
	}
	
	@RequiresPermissions("fcst:fcstNotice:view")
	@RequestMapping(value = "form")
	public String form(FcstNoticeVo vo, Model model) {
		FcstNoticeVo record = fcstNoticeService.findById(vo.getId());
		model.addAttribute("fcstNotice", record == null ? new FcstNoticeVo() : record);
		return "sdo/fcst/fcstNoticeForm";
	}
	
	@RequiresPermissions("fcst:fcstNotice:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, FcstNoticeVo vo) {
		fcstNoticeService.export(response, params, vo);
	}

}