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
import com.ey.piit.sdo.pso.vo.PsoExhibitionVo;
import com.ey.piit.sdo.pso.vo.PsoItemVo;
import com.ey.piit.sdo.pso.vo.PsoNotifyVo;
import com.ey.piit.sdo.pso.vo.PsoOtherVo;
import com.ey.piit.sdo.pso.vo.PsoPiVo;
import com.ey.piit.sdo.pso.vo.PsoVo;
/**
 * 样机预走货SamplePsoController
 * 
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "pso/samplePso")
public class SamplePsoController extends BaseController {

	@Autowired
	private PsoService psoService;
 
	/**
	 * 样机预走货菜单
	 * @return
	 */
	@RequiresPermissions("pso:samplePso:view")
	@RequestMapping(value = { "list", "" })
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("sdo/pso/psoSampleList");
		return view;
	}
	
	/**
	 * 样机预走货查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("pso:samplePso:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(PsoVo vo, PageJqGrid page) {
		return psoService.callQueryByPage(vo, page);
	}
	
	

	/**
	 * 样机预走货编辑页面
	 * @return
	 */
	@RequiresPermissions("pso:samplePso:view")
	@RequestMapping(value = "editPage", method = RequestMethod.GET)
	@Token(create = true)
	public String editPage() {
		return "sdo/pso/psoSampleEdit";
	}
	
	/**
	 * 样机预走货保存
	 * @param vo
	 * @param itemList
	 * @param otherList
	 * @param notityList
	 * @return
	 */
	@RequiresPermissions("pso:samplePso:edit")
	@RequestMapping(value = "edit")
	@ResponseBody
	@Token(verify = true)
	public Object edit(PsoVo vo, 
			@RequestParam(value = "itemList") String itemList,
			@RequestParam(value = "otherList") String otherList,
			@RequestParam(value = "notityList") String notityList,
			@RequestParam(value = "exhibitionList") String exhibitionList) {
		
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
		
		JSONArray exhibitionarray = JSONArray.fromObject(exhibitionList);
		@SuppressWarnings("unchecked")
		List<PsoExhibitionVo> listexhibition = (List<PsoExhibitionVo>) JSONArray.toCollection(exhibitionarray, PsoExhibitionVo.class);
		
		vo.setPsoItemList(listitem);
		vo.setPsoPiList(listpi);
		vo.setPsoOtherList(listother);
		vo.setPsoNotifyList(listnotify);
		vo.setPsoExhibitionList(listexhibition);
		return psoService.edit(vo);
	}
	
	/**
	 * 样机预走货提交
	 * @param vo
	 * @param itemList
	 * @param otherList
	 * @param notityList
	 */
    @RequiresPermissions("pso:samplePso:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
	@Token(verify = true)
    public void submit(PsoVo vo, 
    		@RequestParam(value = "itemList") String itemList,
			@RequestParam(value = "otherList") String otherList,
			@RequestParam(value = "notityList") String notityList,
			@RequestParam(value = "exhibitionList") String exhibitionList) {
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
		
		JSONArray exhibitionarray = JSONArray.fromObject(notityList);
		@SuppressWarnings("unchecked")
		List<PsoExhibitionVo> listexhibition = (List<PsoExhibitionVo>) JSONArray.toCollection(exhibitionarray, PsoExhibitionVo.class);
		
		vo.setPsoItemList(listitem);
		vo.setPsoPiList(listpi);
		vo.setPsoOtherList(listother);
		vo.setPsoNotifyList(listnotify);
		vo.setPsoExhibitionList(listexhibition);
		psoService.submit(vo);
    }

	/**
	 * 样机预走货查看页面
	 * @return
	 */
	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoSampleView");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}
	/**
	 * 样机预走货打印页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "printPage", method = RequestMethod.GET)
	public ModelAndView printPage(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoSamplePrint");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}	
	/**
	 * 样机预走货审核页面
	 * @return
	 */
	@RequestMapping(value = "approvePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView approvePage() {
		ModelAndView view = new ModelAndView("sdo/pso/psoSampleApprove");
		return view;
	}
	
	/**
	 * 样机预走货删除
	 * @param id
	 * @param sjc
	 */
    @RequiresPermissions("pso:samplePso:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id,String sjc,int zt,String processId) {
    	psoService.delete(id,sjc,zt,processId);
    }
    
    /**
     * @function 样机预走货撤回取消（type：1取消 2撤回）
     * @param vo
     */
    @RequiresPermissions("pso:samplePso:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(PsoVo vo, Integer type) {
    	psoService.cancel(vo, type);
    }
    
    /**
     * function 样机预走货变更
     * @param vo
     */
    @RequiresPermissions("pso:samplePso:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(PsoVo vo) {
    	psoService.change(vo);
    }
    
    /**
	 * 船务分派审核页面
	 * @return
	 */
	@RequiresPermissions("pso:samplePso:view")
	@RequestMapping(value = "cwfpApprovePage")
	@Token(create = true)
	public String cwfpApprovePage() {
		return "sdo/pso/psoSampleCwfp";
	}
    
    /**
	 * 船务预处理页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "cwycl", method = RequestMethod.GET)
	@Token(create = true)
	public String cwyclEditPage() {
		 return "sdo/pso/psoSampleCwycl";
	}
	
    /**
	 *船务预处理保存
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
    @RequiresPermissions("pso:samplePso:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(PsoVo vo) {
    	psoService.getback(vo);
    }
	
}