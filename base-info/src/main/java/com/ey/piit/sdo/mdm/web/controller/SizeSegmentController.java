package com.ey.piit.sdo.mdm.web.controller;

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
import com.ey.piit.sdo.mdm.service.SizeSegmentService;
import com.ey.piit.sdo.mdm.vo.SizeSegmentVo;

/**
 * 尺寸段维护Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "mdm/sizeSegment")
public class SizeSegmentController extends BaseController {

	@Autowired
	private SizeSegmentService sizeSegmentService;
	
	@RequiresPermissions("mdm:sizeSegment:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(SizeSegmentVo vo, PageJqGrid page) {
        List<SizeSegmentVo> list = sizeSegmentService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:sizeSegment:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(SizeSegmentVo vo) {
		sizeSegmentService.edit(vo);
    }
	
	@RequiresPermissions("mdm:sizeSegment:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/sizeSegmentList";
	}
	
	@RequiresPermissions("mdm:sizeSegment:view")
	@RequestMapping(value = "form")
	public String form(SizeSegmentVo vo, Model model) {
		SizeSegmentVo record = sizeSegmentService.findById(vo.getId());
		model.addAttribute("sizeSegment", record == null ? new SizeSegmentVo() : record);
		return "sdo/mdm/sizeSegmentForm";
	}
	
	@RequiresPermissions("mdm:sizeSegment:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, SizeSegmentVo vo) {
		sizeSegmentService.export(response, params, vo);
	}

}