package com.ey.piit.sdo.pso.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import com.ey.piit.sdo.pso.entity.PsoReferOrder;
import com.ey.piit.sdo.pso.service.PsoService;
import com.ey.piit.sdo.pso.vo.PsoItemVo;
import com.ey.piit.sdo.pso.vo.PsoNotifyVo;
import com.ey.piit.sdo.pso.vo.PsoOtherVo;
import com.ey.piit.sdo.pso.vo.PsoPiVo;
import com.ey.piit.sdo.pso.vo.PsoVo;
/**
 * TV预走货TvPsoController
 * 
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "pso/tvPso")
public class TvPsoController extends BaseController {

	@Autowired
	private PsoService psoService;
 
	/**
	 * TV预走货菜单
	 * @return
	 */
	@RequiresPermissions("pso:tvPso:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/pso/psoTvList";
	}

	/**
	 * TV预走货查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("pso:tvPso:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(PsoVo vo, PageJqGrid page) {
		return psoService.callQueryByPage(vo, page);
	}
	
	
	/**
	 * TV预走货编辑页面
	 * @param id
	 * @return
	 */
	@RequiresPermissions("pso:tvPso:edit")
	@RequestMapping(value = "editPage", method = RequestMethod.GET)
	@Token(create = true)
	public String editPage() {
		 return "sdo/pso/psoTvEdit";
	}
	
	
	/**
	 * TV预走货保存
	 * @param vo
	 * @param itemList
	 * @param otherList
	 * @param notityList
	 * @return
	 */
	@RequiresPermissions("pso:tvPso:edit")
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
	 * TV预走货提交
	 * @param vo
	 * @param itemList
	 * @param otherList
	 * @param notityList
	 */
    @RequiresPermissions("pso:tvPso:edit")
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
	 * TV预走货查看页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoTvView");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}
	/**
	 * TV预走货打印页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "printPage", method = RequestMethod.GET)
	public ModelAndView printPage(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoTvPrint");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}	
	/**
	 * TV预走货审核页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "approvePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView viewApprove(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoTvApprove");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}
	
	/**
	 * TV预走货审批
	 * @param vo
	 */
    @RequestMapping(value = "approve")
    @ResponseBody
	@Token(verify = true)
    public Object approve(PsoVo vo) {
		return psoService.approve(vo);
    }
	
	/**
	 * TV预走货删除
	 * @param id
	 * @param sjc
	 */
    @RequiresPermissions("pso:tvPso:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id,String sjc,int zt,String processId) {
    	psoService.delete(id,sjc,zt,processId);
    }
    
    /**
     * @function 大货预走货撤回取消（type：1取消 2撤回）
     * @param vo
     */
    @RequiresPermissions("pso:tvPso:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(PsoVo vo, Integer type) {
    	psoService.cancel(vo, type);
    }
    
    /**
     * function 大货预走货变更
     * @param vo
     */
    @RequiresPermissions("pso:tvPso:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(PsoVo vo) {
    	psoService.change(vo);
    }
    
	/***************************************************************************/
	
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	@ResponseBody
	@Token(verify = false)
	public Object findById(String id) {
		return psoService.callQueryById(id);
	}
	
	/**
	 * 订单查询页面
	 * @param gsbm
	 * @param khbm
	 * @param yzhlx
	 * @return
	 */
	@RequestMapping(value = "ddcxPage", method = RequestMethod.GET)
	public ModelAndView ddcxPage(PsoVo vo) {
		ModelAndView view = new ModelAndView("sdo/pso/ddcxList");
		view.addObject("vo", vo);
		return  view;
	}
	
	/**
	 * 待走货订单查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "queryDdxx")
	@ResponseBody
	public Object searchDdxx(PsoReferOrder vo, PageJqGrid page) {
		return psoService.callQueryDdxxByPage(vo, page);
	}
	
	/**
	 * 预走货所选订单的PI信息查询
	 * 
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "queryPixx")
	@ResponseBody
	public Object searchPixx(PsoReferOrder vo) {
		return psoService.callQuerySpoReferPixx(vo);
	}
	
	/**
	 * 导出
	 * @param response
	 * @param paramsf
	 * @param vo
	 */
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PsoVo vo) {
		psoService.export(response, params, vo);
	}
	
	/**
	 * 船务分派审核页面
	 * @return
	 */
	@RequiresPermissions("pso:tvPso:view")
	@RequestMapping(value = "cwfpApprovePage")
	@Token(create = true)
	public String cwfpApprovePage() {
		return "sdo/pso/psoTvCwfp";
	}
	
	/**
	 * 船务分派菜单页面
	 * @return
	 */
	@RequiresPermissions("pso:tvPso:view")
	@RequestMapping(value = "cwfpList")
	public String cwfpList() {
		return "sdo/booking/psoBindList";
	}
	
	/**
	 * 船务分派查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("pso:tvPso:view")
    @RequestMapping(value = "searchCwfp")
    @ResponseBody
    public Object searchCwfp(PsoVo vo, PageJqGrid page) {
		return psoService.callQueryCwfpByPage(vo, page);
    }
	
	/**
	 * 船务分派保存
	 * @param vo
	 * @return
	 */
	@RequiresPermissions("pso:tvPso:edit")
	@RequestMapping(value = "editCwfp")
	@ResponseBody
	public Object editCwfp(PsoVo vo) {
		return psoService.editCwfp(vo);
	}
	
	/**
	 * 船务预处理页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "cwycl", method = RequestMethod.GET)
	@Token(create = true)
	public String cwyclEditPage() {
		return "sdo/pso/psoTvCwycl";
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
     * function 样机化预走货取回
     * @param vo
     */
    @RequiresPermissions("pso:tvPso:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(PsoVo vo) {
    	psoService.getback(vo);
    }
    
    @RequiresPermissions("pso:tvPso:view")
	@RequestMapping(value = "searchYzhxx")
	@ResponseBody
	public Object searchYzhxx(PsoVo vo, PageJqGrid page) {
		return psoService.callQueryYzhxxByPage(vo, page);
	}
}