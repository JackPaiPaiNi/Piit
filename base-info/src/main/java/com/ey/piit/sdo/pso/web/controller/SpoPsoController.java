package com.ey.piit.sdo.pso.web.controller;

import java.util.List;

import net.sf.json.JSONArray;

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
import com.ey.piit.sdo.pso.service.PsoService;
import com.ey.piit.sdo.pso.vo.PsoItemVo;
import com.ey.piit.sdo.pso.vo.PsoNotifyVo;
import com.ey.piit.sdo.pso.vo.PsoOtherVo;
import com.ey.piit.sdo.pso.vo.PsoPiVo;
import com.ey.piit.sdo.pso.vo.PsoVo;
/**
 * 备损预走货SpoPsoController
 * 
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "pso/spoPso")
public class SpoPsoController extends BaseController {

	@Autowired
	private PsoService psoService;
 
	/**
	 * 备损预走货菜单
	 * @return
	 */
	@RequiresPermissions("pso:spoPso:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/pso/psoSpoList";
	}
	
    /**
	 * 备损预走货查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("pso:spoPso:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(PsoVo vo, PageJqGrid page) {
		return psoService.callQueryByPage(vo, page);
	}
	

	/**
	 * 备损预走货编辑页面
	 * @param id
	 * @return
	 */
	@RequiresPermissions("pso:spoPso:edit")
	@RequestMapping(value = "editPage", method = RequestMethod.GET)
	@Token(create = true)
	public String editPage() {
	     return "sdo/pso/psoSpoEdit";
	}
	
	/**
	 * 备损预走货保存
	 * @param vo
	 * @param itemList
	 * @param otherList
	 * @param notityList
	 * @return
	 */
	@RequiresPermissions("pso:spoPso:edit")
	@RequestMapping(value = "edit")
	@ResponseBody
	@Token(verify = true)
	public Object edit(PsoVo vo, 
			@RequestParam(value = "itemList") String itemList,
			@RequestParam(value = "piList") String piList,
			@RequestParam(value = "otherList") String otherList,
			@RequestParam(value = "notityList") String notityList) {
		
		JSONArray itemarray = JSONArray.fromObject(itemList);
		@SuppressWarnings("unchecked")
		List<PsoItemVo> listitem = (List<PsoItemVo>) JSONArray.toCollection(itemarray, PsoItemVo.class);
		
		JSONArray piarray = JSONArray.fromObject(piList);
		@SuppressWarnings("unchecked")
		List<PsoPiVo> listpi= (List<PsoPiVo>) JSONArray.toCollection(piarray, PsoPiVo.class);
		
		JSONArray otherarray = JSONArray.fromObject(otherList);
		@SuppressWarnings("unchecked")
		List<PsoOtherVo> listother = (List<PsoOtherVo>) JSONArray.toCollection(otherarray, PsoOtherVo.class);
		
		JSONArray notifyarray = JSONArray.fromObject(notityList);
		@SuppressWarnings("unchecked")
		List<PsoNotifyVo> listnotify = (List<PsoNotifyVo>) JSONArray.toCollection(notifyarray, PsoNotifyVo.class);
		
		vo.setPsoItemList(listitem);
		vo.setPsoPiList(listpi);
		vo.setPsoOtherList(listother);
		vo.setPsoNotifyList(listnotify);
		return psoService.edit(vo);
	}
	
	/**
	 * 备损预走货提交
	 * @param vo
	 * @param itemList
	 * @param otherList
	 * @param notityList
	 */
    @RequiresPermissions("pso:spoPso:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
	@Token(verify = true)
    public void submit(PsoVo vo, 
			@RequestParam(value = "itemList") String itemList,
			@RequestParam(value = "piList") String piList,
			@RequestParam(value = "otherList") String otherList,
			@RequestParam(value = "notityList") String notityList) {
    	JSONArray itemarray = JSONArray.fromObject(itemList);
		@SuppressWarnings("unchecked")
		List<PsoItemVo> listitem = (List<PsoItemVo>) JSONArray.toCollection(itemarray, PsoItemVo.class);
		
		JSONArray piarray = JSONArray.fromObject(piList);
		@SuppressWarnings("unchecked")
		List<PsoPiVo> listpi= (List<PsoPiVo>) JSONArray.toCollection(piarray, PsoPiVo.class);
		
		JSONArray otherarray = JSONArray.fromObject(otherList);
		@SuppressWarnings("unchecked")
		List<PsoOtherVo> listother = (List<PsoOtherVo>) JSONArray.toCollection(otherarray, PsoOtherVo.class);
		
		JSONArray notifyarray = JSONArray.fromObject(notityList);
		@SuppressWarnings("unchecked")
		List<PsoNotifyVo> listnotify = (List<PsoNotifyVo>) JSONArray.toCollection(notifyarray, PsoNotifyVo.class);
		
		vo.setPsoItemList(listitem);
		vo.setPsoPiList(listpi);
		vo.setPsoOtherList(listother);
		vo.setPsoNotifyList(listnotify);
		psoService.submit(vo);
    }
	
	/**
	 * 备损预走货查看页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoSpoView");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}
	/**
	 * 备损预走货打印页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "printPage", method = RequestMethod.GET)
	public ModelAndView printPage(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoSpoPrint");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}	
	/**
	 * 备损预走货审核页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "approvePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView viewApprove(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoSpoApprove");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}

	/**
	 * 备损预走货删除
	 * @param id
	 * @param sjc
	 */
    @RequiresPermissions("pso:spoPso:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id,String sjc,int zt,String processId) {
    	psoService.delete(id,sjc,zt,processId);
    }
    
    /**
     * @function 备损预走货撤回取消（type：1取消 2撤回）
     * @param vo
     */
    @RequiresPermissions("pso:spoPso:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(PsoVo vo, Integer type) {
    	psoService.cancel(vo, type);
    }
    
    /**
     * function 备损预走货变更
     * @param vo
     */
    @RequiresPermissions("pso:spoPso:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(PsoVo vo) {
    	psoService.change(vo);
    }
    
    /**
	 * 船务分派审核页面
	 * @return
	 */
	@RequiresPermissions("pso:spoPso:view")
	@RequestMapping(value = "cwfpApprovePage")
	@Token(create = true)
	public String cwfpApprovePage() {
		return "sdo/pso/psoSpoCwfp";
	}
    
   	/**
	 * 船务预处理页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "cwycl", method = RequestMethod.GET)
	@Token(create = true)
	public String cwyclEditPage() {
		 return "sdo/pso/psoSpoCwycl";
	}
	
	/**
   	 *船务预处理提交
   	 * @param vo
   	 */
    @RequestMapping(value = "cwyclSave")
    @ResponseBody
   	@Token(verify = true)
    public void cwyclSave(PsoVo vo) {
   		psoService.approve(vo); 
    }
    
    /**
     * SMO审核处理
     * @param id
     * @return
     */
    @RequestMapping(value = "smoApprove")
    @ResponseBody
    public Object smoApprove(PsoVo vo) {
    	return psoService.smoApprove(vo);
    }
    
    /**
     * function 备损化预走货取回
     * @param vo
     */
    @RequiresPermissions("pso:spoPso:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(PsoVo vo) {
    	psoService.getback(vo);
    }
}