package com.ey.piit.sdo.price.web.controller;

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

import com.ey.piit.sdo.price.service.SkdPriceAdjustService;
import com.ey.piit.sdo.price.vo.SkdPriceAdjustItemVo;
import com.ey.piit.sdo.price.vo.SkdPriceAdjustVo;

/**
 * SKD物料调价单管理Controller
 * @author 
 */
@Controller
@RequestMapping(value = "price/skdPriceAdjust")
public class SkdPriceAdjustController extends BaseController {

	@Autowired
	private SkdPriceAdjustService skdPriceAdjustService;

	@RequiresPermissions("price:skdPriceAdjust:view")
	@RequestMapping(value = {""})
	public String list() {
		return "sdo/price/skdPriceAdjustList";
	}
	
	@RequiresPermissions("price:skdPriceAdjust:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(SkdPriceAdjustVo vo, PageJqGrid page) {
        return skdPriceAdjustService.callQueryByPage(vo, page);
    }
	
	@RequiresPermissions("price:skdPriceAdjust:view")
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
	@Token(create = true)
    public String editPage(){
    	return "sdo/price/skdPriceAdjustEdit";
    }

	@RequiresPermissions("price:skdPriceAdjust:view")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return skdPriceAdjustService.callQueryById(id);
    }
	
    @RequestMapping(value = "/qryDdxx", method = RequestMethod.POST)
    @ResponseBody
    public Object qryDdxx(String ddid,String chdh,String khmc, PageJqGrid page){
    	return skdPriceAdjustService.qryDdxx(ddid,chdh,khmc,page);
    }
    
    @RequestMapping(value = "/qryJhd", method = RequestMethod.POST)
    @ResponseBody
    public Object qryJhd(String ddid,String chdh){
    	return skdPriceAdjustService.qryJhd(ddid,chdh);
    }

    @RequiresPermissions("price:skdPriceAdjust:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    @Token(verify = true)
    public Object edit(SkdPriceAdjustVo vo, @RequestParam(value = "mxList")String mxList) {
    	JSONArray array = JSONArray.fromObject(mxList);
		@SuppressWarnings("unchecked")
		List<SkdPriceAdjustItemVo> list = (List<SkdPriceAdjustItemVo>) JSONArray.toCollection(array, SkdPriceAdjustItemVo.class);
    	vo.setSkdPriceAdjustItemList(list);
		return skdPriceAdjustService.edit(vo);
    }
	
    @RequiresPermissions("price:skdPriceAdjust:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public void submit(SkdPriceAdjustVo vo, @RequestParam(value = "mxList")String mxList) {
    	JSONArray array = JSONArray.fromObject(mxList);
		@SuppressWarnings("unchecked")
		List<SkdPriceAdjustItemVo> list = (List<SkdPriceAdjustItemVo>) JSONArray.toCollection(array, SkdPriceAdjustItemVo.class);
    	vo.setSkdPriceAdjustItemList(list);
    	skdPriceAdjustService.submit(vo);
    }
    
    @RequiresPermissions("price:skdPriceAdjust:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id, String sjc) {
    	skdPriceAdjustService.delete(id, sjc);
    }
	
    @RequiresPermissions("price:skdPriceAdjust:view")
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/price/skdPriceAdjustView");
		view.addObject("skdPriceAdjust", skdPriceAdjustService.callQueryById(id));
		return view;
	}
    
	@RequiresPermissions("price:skdPriceAdjust:view")
    @RequestMapping(value = "printPage", method = RequestMethod.GET)
    public ModelAndView printPage(String id){
		ModelAndView view = new ModelAndView("sdo/price/skdPriceAdjustPrint");
    	view.addObject("skdPriceAdjust",skdPriceAdjustService.callQueryById(id));
    	return view;
    }
	
	@RequiresPermissions("price:skdPriceAdjust:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, SkdPriceAdjustVo vo) {
		skdPriceAdjustService.export(response, params, vo);
	}
	
}