package com.ey.piit.sdo.art.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import com.ey.piit.sdo.art.service.ArtoemService;
import com.ey.piit.sdo.art.vo.ArtoemVo;

/**
 * 美工任务单OEMController
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "art/oem")
public class ArtoemController extends BaseController {

	@Autowired
	private ArtoemService artoemService;
    
	@RequiresPermissions("art:oem:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/art/artoemList";
	}
	
	@RequiresPermissions("art:oem:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ArtoemVo vo, PageJqGrid page) {
		return artoemService.callQueryByPage(vo, page);
    }
	
	@RequiresPermissions("art:oem:view")
	@RequestMapping(value = {"editPage"})
	@Token(create = true)
	public String editPage() {
		return "sdo/art/artoemEdit";
	}
	
	@RequiresPermissions("art:oem:view")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return artoemService.callQueryById(id);
    }
	
    @RequiresPermissions("art:oem:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public Object edit(ArtoemVo vo) {
    	return artoemService.edit(vo);
    }
    
    @RequiresPermissions("art:oem:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public Object submit(ArtoemVo vo) {
    	return artoemService.submit(vo);
    }
    
    @RequiresPermissions("art:oem:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id, String sjc, int zt, String processId) {
    	artoemService.delete(id, sjc, zt, processId);
    }
    
	@RequiresPermissions("art:oem:view")
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/art/artoemView");
    	view.addObject("artoem", artoemService.callQueryById(id)); 
    	return view;
    }
	
	@RequiresPermissions("art:oem:view")
    @RequestMapping(value = "showPage", method = RequestMethod.GET)
    public ModelAndView showPage(String rwdh, Integer bbh){
		ModelAndView view = new ModelAndView("sdo/art/artoemView");
    	view.addObject("artoem", artoemService.callQueryHtyByRwdh(rwdh,bbh)); 
    	return view;
    }
	
	@RequiresPermissions("art:oem:view")
    @RequestMapping(value = "printPage", method = RequestMethod.GET)
    public ModelAndView printPage(String id){
		ModelAndView view = new ModelAndView("sdo/art/artoemPrint");
    	view.addObject("artoem", artoemService.callQueryById(id)); 
    	return view;
    }
	
	@RequestMapping(value = "approvePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView approvePage(String id) {
		ModelAndView view = new ModelAndView("sdo/art/artoemApprove");
		view.addObject("artoem", artoemService.callQueryById(id));
		return view;
	}
	
	@RequestMapping(value = "approve")
    @ResponseBody
	@Token(verify = true)
    public void approve(ArtoemVo vo) {
		artoemService.approve(vo);
    }
	
	@RequiresPermissions("art:oem:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(ArtoemVo vo) {
		artoemService.change(vo);
    }
	
	@RequiresPermissions("art:oem:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(ArtoemVo vo) {
		artoemService.getback(vo);
    }
	
	@RequiresPermissions("art:oem:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ArtoemVo vo) {
		artoemService.export(response, params, vo);
	}
	
	@RequiresPermissions("art:oem:bc")
    @RequestMapping(value = "bc")
    @ResponseBody
    public void bc(ArtoemVo vo) {
		artoemService.bc(vo);
    }
	 
    /**
     * function 美工任务单（oem)取消
     * @param vo
     */
    @RequiresPermissions("art:oem:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(ArtoemVo vo) {
    	artoemService.cancel(vo);
    }
}