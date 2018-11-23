package com.ey.piit.sdo.pso.web.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
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
 * 副营预走货Controller
 * 
 * @author tianrong
 */
@Controller
@RequestMapping(value = "pso/fyPso")
public class FyPsoController extends BaseController {

	@Autowired
	private PsoService psoService;

	/**
	 * 副营预走货菜单
	 * @return
	 */
	@RequiresPermissions("pso:fyPso:view")
	@RequestMapping(value = { "list", "" })
	public ModelAndView fyList() {
		ModelAndView view = new ModelAndView("sdo/pso/psoFyList");
		return view;
	}
	
	/**
	 * 副营预走货查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("pso:fyPso:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(PsoVo vo, PageJqGrid page) {
		return psoService.callQueryByPage(vo, page);
	}
	
	/**
	 * 副营预走货编辑页面
	 * @return
	 */
	@RequiresPermissions("pso:fyPso:view")
	@RequestMapping(value = "editPage", method = RequestMethod.GET)
	@Token(create = true)
	public String editPage() {
		return "sdo/pso/psoFyEdit";
	}
	
	/**
	 * 副营预走货保存
	 * @param vo
	 * @param itemList
	 * @param otherList
	 * @param notityList
	 * @return
	 */
	@RequiresPermissions("pso:fyPso:edit")
	@RequestMapping(value = "edit")
	@ResponseBody
	@Token(verify = true)
	public Object edit(PsoVo vo, 
			@RequestParam(value = "itemList") String itemList,
			@RequestParam(value = "otherList") String otherList,
			@RequestParam(value = "notityList") String notityList) {
		
		JSONArray itemarray = JSONArray.fromObject(itemList);
		@SuppressWarnings("unchecked")
		List<PsoItemVo> listitem = (List<PsoItemVo>) JSONArray.toCollection(itemarray, PsoItemVo.class);
		
		List<PsoPiVo> listpi = new ArrayList<PsoPiVo>();
		for(PsoItemVo _item : listitem){
			if(!StringUtils.isEmpty(_item.getPiid())){
				PsoPiVo psoPiVo = new PsoPiVo();
				psoPiVo.setDdid(_item.getDdid());
				psoPiVo.setDdlx(_item.getDdlx());
				psoPiVo.setDdlxmc(_item.getDdlxmc());
				psoPiVo.setPiid(_item.getPiid());
				psoPiVo.setPilx(_item.getPilx());
				psoPiVo.setPilxmc(_item.getPilxmc());
				psoPiVo.setJe(_item.getJe());
				psoPiVo.setBz(_item.getBz());
				listpi.add(psoPiVo);
			}
		}
		
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
	 * 副营预走货提交
	 * @param vo
	 * @param itemList
	 * @param otherList
	 * @param notityList
	 */
    @RequiresPermissions("pso:fyPso:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
	@Token(verify = true)
    public void submit(PsoVo vo, 
    		@RequestParam(value = "itemList") String itemList,
			@RequestParam(value = "otherList") String otherList,
			@RequestParam(value = "notityList") String notityList) {
    	
    	JSONArray itemarray = JSONArray.fromObject(itemList);
		@SuppressWarnings("unchecked")
		List<PsoItemVo> listitem = (List<PsoItemVo>) JSONArray.toCollection(itemarray, PsoItemVo.class);
		
		List<PsoPiVo> listpi = new ArrayList<PsoPiVo>();
		for(PsoItemVo _item : listitem){
			if(!StringUtils.isEmpty(_item.getPiid())){
				PsoPiVo psoPiVo = new PsoPiVo();
				psoPiVo.setDdid(_item.getDdid());
				psoPiVo.setDdlx(_item.getDdlx());
				psoPiVo.setDdlxmc(_item.getDdlxmc());
				psoPiVo.setPiid(_item.getPiid());
				psoPiVo.setPilx(_item.getPilx());
				psoPiVo.setPilxmc(_item.getPilxmc());
				psoPiVo.setJe(_item.getJe());
				psoPiVo.setBz(_item.getBz());
				listpi.add(psoPiVo);
			}
		}
		
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
	 * 副营预走货查看页面
	 * @return
	 */
	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoFyView");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}
	/**
	 * 副营预走货打印页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "printPage", method = RequestMethod.GET)
	public ModelAndView printPage(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoFyPrint");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}	
	/**
	 * 副营预走货审核页面
	 * @return
	 */
	@RequestMapping(value = "approvePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView approvePage() {
		ModelAndView view = new ModelAndView("sdo/pso/psoFyApprove");
		return view;
	}
	
	/**
	 * 副营预走货删除
	 * @param id
	 * @param sjc
	 */
    @RequiresPermissions("pso:fyPso:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id,String sjc,int zt,String processId) {
    	psoService.delete(id,sjc,zt,processId);
    }
    
    /**
     * @function 副营预走货撤回取消（type：1取消 2撤回）
     * @param vo
     */
    @RequiresPermissions("pso:fyPso:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(PsoVo vo, Integer type) {
    	psoService.cancel(vo, type);
    }
    
    /**
     * function 副营预走货变更
     * @param vo
     */
    @RequiresPermissions("pso:fyPso:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(PsoVo vo) {
    	psoService.change(vo);
    }
    
    /**
	 * 船务分派审核页面
	 * @return
	 */
	@RequiresPermissions("pso:fyPso:view")
	@RequestMapping(value = "cwfpApprovePage")
	@Token(create = true)
	public String cwfpApprovePage() {
		return "sdo/pso/psoFyCwfp";
	}
	
	/**
	 * 船务预处理页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "cwycl", method = RequestMethod.GET)
	@Token(create = true)
	public String cwyclEditPage() {
		 return "sdo/pso/psoFyCwycl";
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
     * function 副营预走货取回
     * @param vo
     */
    @RequiresPermissions("pso:fyPso:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(PsoVo vo) {
    	psoService.getback(vo);
    }
	
}