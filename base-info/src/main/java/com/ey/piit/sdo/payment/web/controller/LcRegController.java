package com.ey.piit.sdo.payment.web.controller;

import java.util.List;
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
import com.ey.piit.sdo.payment.service.LcRegService;
import com.ey.piit.sdo.payment.vo.LcRegItemVo;
import com.ey.piit.sdo.payment.vo.LcRegVo;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;

/**
 * LC登记Controller
 * @author 邓海
 */
@Controller
@RequestMapping(value = "payment/lcReg")
public class LcRegController extends BaseController {
	
	static{
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd"}));
	}
	
	@Autowired
	private LcRegService lcRegService;
	
	@RequiresPermissions("payment:lcReg:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/payment/lcRegList";
	}
	
	@RequiresPermissions("payment:lcReg:view")
	@RequestMapping(value = {"jdmxList"})
	public String jdmxList() {
		return "sdo/payment/lcRegJdmxList";
	}
	
	@RequiresPermissions("payment:lcReg:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(LcRegVo vo, PageJqGrid page) {
        return lcRegService.callQueryByPage(vo, page);
    }
	
	@RequiresPermissions("payment:lcReg:view")
    @RequestMapping(value = "searchJdmx")
    @ResponseBody
    public Object searchJdmx(LcRegItemVo vo, PageJqGrid page) {
        return lcRegService.callQueryJdmxByPage(vo, page);
    }
	
	@RequiresPermissions("payment:lcReg:view")
    @RequestMapping(value = "searchDbd")
    @ResponseBody
    public Object searchDbd(LcRegVo vo, PageJqGrid page) {
        return lcRegService.callQueryDbd(vo, page);
    }
	
	@RequestMapping(value = "editPage")
	@Token (create = true)
	public String editPage() {
		return "sdo/payment/lcRegEdit";
	}
	
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
	@Token (verify = false)
    public Object findById(String id){
    	return lcRegService.callQueryById(id);
    }
	
    @RequestMapping(value = "/changeById", method = RequestMethod.POST)
    @ResponseBody
    @Token (verify = false)
    public Object changeById(String id, String sjc){
    	return lcRegService.callChangeById(id, sjc);
    }
	
    @RequestMapping(value = "/findJdmxByLcbh", method = RequestMethod.POST)
    @ResponseBody
    @Token (verify = false)
    public Object findJdmxByLcbh(String lcbh){
    	return lcRegService.callQueryJdmxByLcbh(lcbh);
    }
	
    @RequiresPermissions("payment:lcReg:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    @Token(verify = true)
    public Object edit(LcRegVo vo) {
		return lcRegService.edit(vo);
    }
    
    @RequiresPermissions("payment:lcReg:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public void submit(LcRegVo vo) {
    	lcRegService.submit(vo);
    }
    
    @RequiresPermissions("payment:lcReg:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id,String sjc,int zt,String processId) {
    	lcRegService.delete(id,sjc,zt,processId);
    }
    
    /**
     * 提交交单明细
     * @param vo
     * @return
     */
    @RequiresPermissions("payment:lcReg:edit")
    @RequestMapping(value = "submitJdmx")
    @ResponseBody
    @Token(verify = true)
    public void submitJdmx(LcRegVo vo, @RequestParam(value = "itemList") String itemList) {
    	JSONArray itemarray = JSONArray.fromObject(itemList);
    	//JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd"}));
    	@SuppressWarnings("unchecked")
		List<LcRegItemVo> list = (List<LcRegItemVo>) JSONArray.toCollection(itemarray, LcRegItemVo.class);
    	vo.setItemVoList(list);
    	lcRegService.saveJdmx(vo);
    }
    
	/**
	 * 进入交单明细维护页面
	 * @return
	 */
	@RequiresPermissions("payment:lcReg:view")
	@RequestMapping(value = "jdmxEditPage")
	@Token (create = true)
	public String jdmxPage() {
		return "sdo/payment/lcRegJdmxEdit";
	}
	
	/**
	 * 进入审批页面
	 * @return
	 */
	@RequestMapping(value = "approvePage")
	@Token (create = true)
	public String approvePage() {
		return "sdo/payment/lcRegApprove";
	}
	
    @RequestMapping(value = "approve")
    @ResponseBody
    @Token(verify = true)
    public void approve(LcRegVo vo) {
    	lcRegService.approve(vo);
    }

    @RequestMapping(value = "qryPage", method = RequestMethod.GET)
    public ModelAndView qryPage(String id){
    	ModelAndView view = new ModelAndView("sdo/payment/lcRegView");
    	view.addObject("lcReg",lcRegService.callQueryById(id)); 
    	return view;
    }
	
	@RequiresPermissions("payment:lcReg:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, LcRegVo vo) {
		lcRegService.export(response, params, vo);
	}
	
	@RequiresPermissions("payment:lcReg:djjd")
    @RequestMapping(value = "frozen")
    @ResponseBody
    public void frozen(LcRegVo vo) {
		lcRegService.frozen(vo);
    }
	
	@RequiresPermissions("payment:lcReg:view")
    @RequestMapping(value = "jdmxExport")
	public void jdmxExport(HttpServletResponse response, @RequestParam Map<String, Object> params, LcRegItemVo vo) {
		lcRegService.jdmxExport(response, params, vo);
	}

	@RequiresPermissions("payment:lcReg:view")
    @RequestMapping(value = "exportitem")
	public void exportmx(HttpServletResponse response, @RequestParam Map<String, Object> params, LcRegVo vo) {
		lcRegService.exportmx(response, params, vo);
	}
}