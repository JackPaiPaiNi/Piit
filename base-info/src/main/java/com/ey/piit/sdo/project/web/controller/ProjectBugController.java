package com.ey.piit.sdo.project.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.project.service.ProjectBugService;
import com.ey.piit.sdo.project.vo.ProjectBugVo;

/**
 * 系统问题管理Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "project/projectBug")
public class ProjectBugController extends BaseController {

	@Autowired
	private ProjectBugService projectBugService;

	
	@RequiresPermissions("project:projectBug:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ProjectBugVo vo, PageJqGrid page) {
		return projectBugService.callQueryByPage(vo, page);
    }
    
    @RequiresPermissions("project:projectBug:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public Object edit(ProjectBugVo vo) {
		return projectBugService.edit(vo);
    }
    
    @RequiresPermissions("project:projectBug:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    public Object submit(ProjectBugVo vo) {
		return projectBugService.submit(vo);
    }
    
    @RequiresPermissions("project:projectBug:view")
    @RequestMapping(value = "approve")
    @ResponseBody
    public Object approve(ProjectBugVo vo) {
		return projectBugService.approve(vo);
    }
    
    @RequiresPermissions("project:projectBug:view")
    @RequestMapping(value = "findById")
    @ResponseBody
    public Object queryById(String  id) {
		return projectBugService.callQueryById(id);
    }
	
	@RequiresPermissions("project:projectBug:view")
	@RequestMapping(value = "editPage")
	public String editPage() {
		return "sdo/project/projectBugEdit";
	}
	@RequiresPermissions("project:projectBug:view")
	@RequestMapping(value = "viewPage")
	public String viewPage() {
		return "sdo/project/projectBugView";
	}
	@RequiresPermissions("project:projectBug:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/project/projectBugList";
	}
	
	@RequiresPermissions("project:projectBug:view")
	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/project/projectBugView");
		view.addObject("projectBug", projectBugService.callQueryById(id));
		return view;
	}
	
	@RequiresPermissions("project:projectBug:view")
	@RequestMapping(value = "busApprove", method = RequestMethod.GET)
	public ModelAndView busApprovePage(String id) {
		ModelAndView view = new ModelAndView("sdo/project/busApprove");
		view.addObject("projectBug", projectBugService.callQueryById(id));
		return view;
	}
	
	@RequiresPermissions("project:projectBug:view")
	@RequestMapping(value = "proApprove", method = RequestMethod.GET)
	public ModelAndView tecApprovePage(String id) {
		ModelAndView view = new ModelAndView("sdo/project/proApprove");
		view.addObject("projectBug", projectBugService.callQueryById(id));
		return view;
	}
	@RequiresPermissions("project:projectBug:view")
	@RequestMapping(value = "dvlpApprove", method = RequestMethod.GET)
	public ModelAndView dvlpApprovePage(String id) {
		ModelAndView view = new ModelAndView("sdo/project/dvlpApprove");
		view.addObject("projectBug", projectBugService.callQueryById(id));
		return view;
	}
	@RequiresPermissions("project:projectBug:view")
	@RequestMapping(value = "fqrApprove", method = RequestMethod.GET)
	public ModelAndView farApprovePage(String id) {
		ModelAndView view = new ModelAndView("sdo/project/fqrApprove");
		view.addObject("projectBug", projectBugService.callQueryById(id));
		return view;
	}
}