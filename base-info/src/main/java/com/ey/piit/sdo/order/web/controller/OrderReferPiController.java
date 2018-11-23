package com.ey.piit.sdo.order.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.fcst.service.FcstDataService;
import com.ey.piit.sdo.order.service.OrderReferPiService;
import com.ey.piit.sdo.order.vo.OrderReferPiVo;

/**
 * PI选择Controller
 * @author 赵明
 */
@Controller
@RequestMapping(value = "order/orderReferPi")
public class OrderReferPiController extends BaseController {

	@Autowired
	private FcstDataService fcstDataService;
	
	@Autowired
	private OrderReferPiService orderReferPiService;

	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/order/orderReferPiList";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = {"fcst"})
	public String fcst(String jhrq,String khbm,String pid,String xsyid,Model model) {
		Map<String, Object> map=((Map<String, Object>)fcstDataService.callQueryOrderFcstTitles(jhrq));
		model.addAttribute("hbtitles",map.get("hblist"));
		model.addAttribute("khbm",khbm);
		model.addAttribute("pid",pid);
		model.addAttribute("jhrq",jhrq);
		model.addAttribute("xsyid",xsyid);
		return "sdo/order/orderReferFcstList";
	}
	@RequestMapping(value = {"spo"})
	public String listSpo() {
		return "sdo/order/orderReferSpoPiList";
	}
	@RequestMapping(value = { "diversity"})
	public String listDiversity() {
		return "sdo/order/orderReferDiversityPiList";
	}
	@RequestMapping(value = { "fy"})
	public String listFy() {
		return "sdo/order/orderReferFyPiList";
	}
	@RequestMapping(value = {"sample"})
	public String listSample() {
		return "sdo/order/orderReferSamplePiList";
	}
    @RequestMapping(value = "searchOrderFcst")
    @ResponseBody
    public Object searchOrderFcst(String pid,String khbm,String jhrq,String xsyid) {
		return fcstDataService.callSelectOrderFcst(jhrq,pid,khbm,xsyid);
    }
    @RequestMapping(value = "searchOrder")
    @ResponseBody
    public Object searchOrder(OrderReferPiVo vo, PageJqGrid page) {
		return orderReferPiService.callQueryOrderByPage(vo, page);
    }
    @RequestMapping(value = "searchSPO")
    @ResponseBody
    public Object searchSPO(OrderReferPiVo vo, PageJqGrid page) {
		return orderReferPiService.callQuerySpoByPage(vo, page);
    }
    @RequestMapping(value = "searchSample")
    @ResponseBody
    public Object searchSample(OrderReferPiVo vo, PageJqGrid page) {
		return orderReferPiService.callQuerySampleByPage(vo, page);
    }
    @RequestMapping(value = "searchDiversity")
    @ResponseBody
    public Object searchDiversity(OrderReferPiVo vo, PageJqGrid page) {
		return orderReferPiService.callQueryDiversityByPage(vo, page);
    }
    @RequestMapping(value = "searchFy")
    @ResponseBody
    public Object searchFy(OrderReferPiVo vo, PageJqGrid page) {
		return orderReferPiService.callQueryFyByPage(vo, page);
    }
    /**
     * 根据PI号 和pi类型查pi的明细
     * @param piid
     * @param pilx
     * @return
     */
    @RequestMapping(value = "/findByPIId", method = RequestMethod.POST)
    @ResponseBody
    public Object findByPIId(String piid){
    	return orderReferPiService.callQueryByPIId(piid);
    }
}