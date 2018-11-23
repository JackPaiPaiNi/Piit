package com.ey.piit.sdo.pub.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.agent.vo.AgentVo;
import com.ey.piit.sdo.mdm.vo.BankVo;
import com.ey.piit.sdo.mdm.vo.PidInfoVo;
import com.ey.piit.sdo.pub.entity.Mgrwd;
import com.ey.piit.sdo.pub.service.WidgetService;
import com.ey.piit.sdo.pub.vo.CustomerInfoVo;

/**
 * PUB管理Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "pub/widget")
public class WidgetController extends BaseController {

	@Autowired
	private WidgetService widgetService;
	
    @RequestMapping(value = "/findCust", method = RequestMethod.POST)
    @ResponseBody
    public Object findCust(CustomerInfoVo vo, PageJqGrid page){
    	return widgetService.callQueryCust(vo, page);
    }
    @RequestMapping(value = "/findCustByXsy", method = RequestMethod.POST)
    @ResponseBody
    public Object findCustByXsy(CustomerInfoVo vo, PageJqGrid page){
    	return widgetService.callQueryCustByXsy(vo, page);
    }
    @RequestMapping(value = "/findBank", method = RequestMethod.POST)
    @ResponseBody
    public Object findBank(BankVo vo, PageJqGrid page){
    	return widgetService.callQueryBank(vo, page);
    }
    
    @RequestMapping(value = "/findCompanyBank", method = RequestMethod.POST)
    @ResponseBody
    public Object findCompanyBank(String gsbm,String yhzh, PageJqGrid page){
    	return widgetService.callQueryCompanyBank(gsbm, yhzh, page);
    }
    
    @RequestMapping(value = "/findPid", method = RequestMethod.POST)
    @ResponseBody
    public Object findPid(PidInfoVo vo, PageJqGrid page){
    	return widgetService.callQueryPid(vo,page);
    }
    
    @RequestMapping(value = "/findMaterial", method = RequestMethod.POST)
    @ResponseBody
    public Object findMaterial(String wlbh, String wlmc, String bz, String model, PageJqGrid page){
    	return widgetService.callQueryMaterial(wlbh, wlmc, bz, model, page);
    }
    
    @RequestMapping(value = "/findLc", method = RequestMethod.POST)
    @ResponseBody
    public Object findLc(String khbm,String khmc,String lcbh, PageJqGrid page){
    	return widgetService.callQueryLc(khbm, khmc,lcbh,page);
    }
    
    @RequestMapping(value = "/findOrg", method = RequestMethod.POST)
    @ResponseBody
    public Object findOrg(String code, String name, String type, PageJqGrid page){
    	return widgetService.callQueryOrg(code, name, type, page);
    }
    
    @RequestMapping(value = "/findBwtrxx", method = RequestMethod.POST)
    @ResponseBody
    public Object findBwtrxx(AgentVo vo, PageJqGrid page){
    	return widgetService.callQueryBwtrxx(vo,page);
    }
    
    @RequestMapping(value = "/findMgrwd", method = RequestMethod.POST)
    @ResponseBody
    public Object findMgrwd(Mgrwd vo, PageJqGrid page){
    	return widgetService.callQueryMgrwd(vo,page);
    }
}