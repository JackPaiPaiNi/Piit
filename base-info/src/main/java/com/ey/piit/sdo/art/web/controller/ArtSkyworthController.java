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
import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.art.service.ArtSkyworthService;
import com.ey.piit.sdo.art.vo.ArtSkyworthVo;

/**
 * 美工订单Skyworth管理Controller
 * @author tianrong
 */
@Controller
@RequestMapping(value = "art/artSkyworth")
public class ArtSkyworthController extends BaseController {

	@Autowired
	private ArtSkyworthService artSkyworthService;
	
	@Autowired
    private ExcelImporter excelImporter;
	
	@RequiresPermissions("art:artSkyworth:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/art/artSkyworthList";
	}
	
	@RequiresPermissions("art:artSkyworth:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ArtSkyworthVo vo, PageJqGrid page) {
		return artSkyworthService.callQueryByPage(vo, page);
    }
    
	@RequiresPermissions("art:artSkyworth:view")
	@Token(create = true)
    @RequestMapping(value = "changeEditPage", method = RequestMethod.GET)
    public String changeEditPage(){
    	return "sdo/art/artSkyworthChangeEdit";
    }
	
	@RequiresPermissions("art:artSkyworth:view")
	@Token(create = true)
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    public ModelAndView editPage(){
		ModelAndView  mv = new  ModelAndView("sdo/art/artSkyworthEdit");
    	return mv;
    }
	
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	ArtSkyworthVo vo =  artSkyworthService.callQueryById(id) ;
    	return   vo;
    }
    

    @RequiresPermissions("art:artSkyworth:edit")
    @RequestMapping(value = "edit")
    @Token(verify = true)
    @ResponseBody
    public Object edit(ArtSkyworthVo vo) {
		return artSkyworthService.edit(vo);
    }
    
    @RequiresPermissions("art:artSkyworth:edit")
    @RequestMapping(value = "submit")
    @Token(verify = true)
    @ResponseBody
    public void submit(ArtSkyworthVo vo) {
		artSkyworthService.submit(vo);
    }
    
    @RequiresPermissions("art:artSkyworth:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id, String sjc, int zt, String processId) {
		artSkyworthService.delete(id, sjc, zt, processId);
    }
	
   /* @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/art/artSkyworthView");
    	view.addObject("artSkyworth",artSkyworthService.callQueryById(id)); 
    	return view;
    }*/
	
    @RequestMapping(value = "approvePage", method = RequestMethod.GET)
    public String approvePage(){
    	return "sdo/art/artSkyworthApprove";
    }
    
    @RequestMapping(value = "approve")
    @ResponseBody
    public Object approve(ArtSkyworthVo vo) {
		return artSkyworthService.approve(vo);
    }
    
	@RequiresPermissions("art:artSkyworth:view")
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView printPage(String id){
		ModelAndView view = new ModelAndView("sdo/art/artSkyworthPrint");
    	view.addObject("artSkyworth",artSkyworthService.callQueryById(id)); 
    	return view;
    }
	
	@RequiresPermissions("art:artSkyworth:view")
    @RequestMapping(value = "showPage", method = RequestMethod.GET)
    public ModelAndView showPage(String rwdh, Integer bbh){
		ModelAndView view = new ModelAndView("sdo/art/artSkyworthPrint");
    	view.addObject("artSkyworth", artSkyworthService.callQueryHtyByRwdh(rwdh,bbh)); 
    	return view;
    }
	
	@RequiresPermissions("art:artSkyworth:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ArtSkyworthVo vo) {
		artSkyworthService.export(response, params, vo);
	}
	
	/**
     * function 美工任务单（SKYWORTH)变更
     * @param vo
     */
    @RequiresPermissions("art:artSkyworth:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(ArtSkyworthVo vo) {
    	artSkyworthService.change(vo);
    }
    
    /**
     * function 美工任务单（SKYWORTH)取回
     * @param vo
     */
    @RequiresPermissions("art:artSkyworth:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(ArtSkyworthVo vo) {
    	artSkyworthService.getback(vo);
    }
    
    @RequiresPermissions("art:artSkyworth:bc")
    @RequestMapping(value = "bc")
    @ResponseBody
    public void bc(ArtSkyworthVo vo) {
		artSkyworthService.bc(vo);
    }
    
    /**
     * function 美工任务单（SKYWORTH)取消
     * @param vo
     */
    @RequiresPermissions("art:artSkyworth:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(ArtSkyworthVo vo) {
    	artSkyworthService.cancel(vo);
    }
}