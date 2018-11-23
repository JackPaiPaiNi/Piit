package com.ey.piit.sdo.mdm.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.mdm.service.PidInfoService;
import com.ey.piit.sdo.mdm.vo.PidInfoVo;

/**
 * PID信息维护Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "mdm/pidInfo")
public class PidInfoController extends BaseController {

	@Autowired
	private PidInfoService pidInfoService;

	
	@RequiresPermissions("mdm:pidInfo:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(PidInfoVo vo, PageJqGrid page) {
        return pidInfoService.callQueryByPage(vo, page);
    }
    
	@RequiresPermissions("mdm:pidInfo:view")
	@RequestMapping(value = "editPage")
	@Token (create = true)
	public String editPage() {
		return "sdo/mdm/pidInfoEdit";
	}
	
	@RequiresPermissions("mdm:pidInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/pidInfoList";
	}
	
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return pidInfoService.callQueryById(id);
    }
	
    @RequiresPermissions("mdm:pidInfo:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    @Token(verify = true)
    public Object edit(PidInfoVo vo) {
		return pidInfoService.edit(vo);
    }
    
    @RequiresPermissions("mdm:pidInfo:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public void submit(PidInfoVo vo) {
    	pidInfoService.submit(vo);
    }
	
	@RequiresPermissions("mdm:pidInfo:view")
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/mdm/pidInfoView");
    	view.addObject("pidInfo",pidInfoService.callQueryById(id)); 
    	return view;
    }
	@RequiresPermissions("mdm:pidInfo:view")
    @RequestMapping(value = "printPage", method = RequestMethod.GET)
    public ModelAndView printPage(String id){
		ModelAndView view = new ModelAndView("sdo/mdm/pidInfoPrint");
    	view.addObject("pidInfo",pidInfoService.callQueryById(id)); 
    	return view;
    }
	@RequiresPermissions("mdm:pidInfo:view")
    @RequestMapping(value = "printPageYjy", method = RequestMethod.GET)
    public ModelAndView printPageYjy(String id){
		ModelAndView view = new ModelAndView("sdo/mdm/pidInfoPrintYjy");
    	view.addObject("pidInfo",pidInfoService.callQueryById(id)); 
    	return view;
    }
	
    @RequiresPermissions("mdm:pidInfo:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id,String sjc,int zt,String processId) {
    	pidInfoService.delete(id,sjc,zt,processId);
    }
	
    @RequestMapping(value = "approvePage", method = RequestMethod.GET)
    @Token (create = true)
    public String approvePage(){
    	return "sdo/mdm/pidInfoApprove";
    }
	
    @RequestMapping(value = "approve")
    @ResponseBody
    @Token(verify = true)
    public void approve(PidInfoVo vo) {
    	pidInfoService.approve(vo);
    }
	
	@RequiresPermissions("mdm:pidInfo:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PidInfoVo vo) {
		pidInfoService.export(response, params, vo);
	}
	
	/**
	 * PID补充信息页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "pidAddInfoApprovePage", method = RequestMethod.GET)
	@Token(create = true)
	public String pidAddInfoApprovePage(Model model, String id) {
		PidInfoVo vo  =  (PidInfoVo) pidInfoService.callQueryById(id);
		String gh = UserUtils.getUser().getLoginAcct();
		if(vo.getDzgcs().equals(gh)){
			model.addAttribute("gcs", "dzgcs");
		}else if(vo.getDygcs().equals(gh)){
			model.addAttribute("gcs", "dygcs");
		}else if(vo.getJggcs().equals(gh)){
			model.addAttribute("gcs", "jggcs");
		}
		return "sdo/mdm/pidAddInfoApprove";
	}
	
	/**
	 * PID计划完成时间修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "pidJhwcsjApprovePage", method = RequestMethod.GET)
	@Token(create = true)
	public String pidJhwcsjApprovePage() {
		return "sdo/mdm/pidJhwcsjApprove";
	}
	
	/**
	 *PID补充信息提交
	 * @param vo
	 */
    @RequestMapping(value = "pidAddInfoSave")
    @ResponseBody
	@Token(verify = true)
    public void pidAddInfoSave(PidInfoVo vo) {
    	pidInfoService.approve(vo);
    }
    
    /**
	 *PID计划完成时间更新
	 * @param vo
	 */
    @RequestMapping(value = "pidJhwcsjSave")
    @ResponseBody
	@Token(verify = true)
    public void pidJhwcsjSave(PidInfoVo vo) {
    	pidInfoService.approve(vo);
    }
    
    /**
	 * 推送SAP
	 * @param vo
	 */
	@RequiresPermissions("mdm:pidInfo:edit")
	@RequestMapping(value = "pushSAP")
	@ResponseBody
	public void pushSAP(PidInfoVo vo) {
		pidInfoService.tsSapAndWriteLog(vo);
	}
	
	
	
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(PidInfoVo vo) {
    	pidInfoService.change(vo);
    }
	

}