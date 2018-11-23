package com.ey.piit.sdo.pub.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.art.service.ArtSkyworthService;
import com.ey.piit.sdo.mdm.service.CustomerApplyService;
import com.ey.piit.sdo.mdm.service.PidInfoService;
import com.ey.piit.sdo.order.service.OrderDiversityService;
import com.ey.piit.sdo.order.service.OrderFyService;
import com.ey.piit.sdo.order.service.OrderProductService;
import com.ey.piit.sdo.order.service.OrderSampleService;
import com.ey.piit.sdo.order.service.OrderSpoService;
import com.ey.piit.sdo.pi.service.PiService;
import com.ey.piit.sdo.project.service.ProjectBugService;
import com.ey.piit.sdo.pso.service.PsoService;

/**
 * ShowLogController 
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "pub/showLog")
public class ShowLogController extends BaseController {
	@Autowired
	private OrderProductService orderProductService;
	@Autowired
	private OrderSpoService  orderSpoService;
	@Autowired
	private  OrderSampleService  orderSampleService;
	@Autowired
	private OrderDiversityService orderDiversityService;
	@Autowired
	private OrderFyService orderFyService;
	@Autowired
	private ArtSkyworthService artSkyworthService;
	@Autowired
	PiService PiService ;
	@Autowired
	PsoService psoService  ;
	@Autowired
	PidInfoService pidInfoService ;
	@Autowired
	CustomerApplyService customerApplyService ;
	@Autowired
    ProjectBugService projectBugService;

	
	
	private ModelAndView view = new ModelAndView("sdo/pub/approveLog");
	
	/**********************pi开始*********************/
	@RequestMapping(value = "piTv", method = RequestMethod.GET)
	public ModelAndView piTv(String id) {
		view.addObject("obj", PiService.callQueryById(id));
		return view;
	}
	@RequestMapping(value = "piSpo", method = RequestMethod.GET)
	public ModelAndView piSpo(String id) {
		view.addObject("obj", PiService.callQueryById(id));
		return view;
	}
	@RequestMapping(value = "piSimple", method = RequestMethod.GET)
	public ModelAndView piSimple(String id) {
		view.addObject("obj", PiService.callQueryById(id));
		return view;
	}
	@RequestMapping(value = "piDiversity", method = RequestMethod.GET)
	public ModelAndView piDiversity(String id) {
		view.addObject("obj", PiService.callQueryById(id));
		return view;
	}
	@RequestMapping(value = "piFy", method = RequestMethod.GET)
	public ModelAndView piFy(String id) {
		view.addObject("obj", PiService.callQueryById(id));
		return view;
	}
	/**********************pi结束*********************/
	
	
	/***************订单开始****************************/
    @RequestMapping(value = "orderProduct", method = RequestMethod.GET)
	public ModelAndView orderProduct(String id) {
		view.addObject("obj", orderProductService.callQueryById(id));
		return view;
	}
    @RequestMapping(value = "orderSpo", method = RequestMethod.GET)
	public ModelAndView orderSpo(String id) {
		view.addObject("obj", orderSpoService.callQueryById(id));
		return view;
	}
    @RequestMapping(value = "orderSimple", method = RequestMethod.GET)
	public ModelAndView orderSimple(String id) {
		view.addObject("obj", orderSampleService.callQueryById(id));
		return view;
	}
    @RequestMapping(value = "orderDiversity", method = RequestMethod.GET)
	public ModelAndView orderDiversity(String id) {
		view.addObject("obj", orderDiversityService.callQueryById(id));
		return view;
	}
    @RequestMapping(value = "orderFy", method = RequestMethod.GET)
	public ModelAndView orderFy(String id) {
		view.addObject("obj", orderFyService.callQueryById(id));
		return view;
	}
    @RequestMapping(value = "artSkyworth", method = RequestMethod.GET)
	public ModelAndView artSkyworth(String id) {
		view.addObject("obj", artSkyworthService.callQueryById(id));
		return view;
	}
    /***************订单结束**********************************/
    
    /***************预走货开始*********************************/
    @RequestMapping(value = "orderProductPso", method = RequestMethod.GET)
   	public ModelAndView orderProductPso(String id) {
   		view.addObject("obj", psoService.callQueryById(id));
   		return view;
   	}
    @RequestMapping(value = "spoPso", method = RequestMethod.GET)
   	public ModelAndView spoPso(String id) {
   		view.addObject("obj", psoService.callQueryById(id));
   		return view;
   	}
    @RequestMapping(value = "simplePso", method = RequestMethod.GET)
   	public ModelAndView simplePso(String id) {
   		view.addObject("obj", psoService.callQueryById(id));
   		return view;
   	}
    @RequestMapping(value = "diversityPso", method = RequestMethod.GET)
   	public ModelAndView diversityPso(String id) {
   		view.addObject("obj", psoService.callQueryById(id));
   		return view;
   	}
    @RequestMapping(value = "fyPso", method = RequestMethod.GET)
   	public ModelAndView fyPso(String id) {
   		view.addObject("obj", psoService.callQueryById(id));
   		return view;
   	}
    /***************预走货结束**************************************/
    
    
    //客户申请
    @RequestMapping(value = "pid", method = RequestMethod.GET)
   	public ModelAndView pid(String id) {
   		view.addObject("obj", pidInfoService.callQueryById(id));
   		return view;
   	}
    
    //pid申请
    @RequestMapping(value = "customerApply", method = RequestMethod.GET)
   	public ModelAndView CustomerApplyService(String id) {
   		view.addObject("obj", customerApplyService.callQueryById(id));
   		return view;
   	}
    
    
    //bug管理
    @RequestMapping(value = "projectBug", method = RequestMethod.GET)
   	public ModelAndView ProjectBugService(String id) {
   		view.addObject("obj", projectBugService.callQueryById(id));
   		return view;
   	}
    
    
    
    
    
}