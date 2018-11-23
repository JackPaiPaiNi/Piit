package com.ey.piit.sdo.payment.web.controller;

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
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.payment.service.PayPiBindService;
import com.ey.piit.sdo.payment.vo.PayPiBindDetailVo;
import com.ey.piit.sdo.payment.vo.PayPiBindVo;
import com.ey.piit.sdo.pi.vo.PiVo;
/**
 * PI付款保障关联Controller
 * @author 田荣
 */
@Controller
@RequestMapping(value = "payment/payPiBind")
public class PayPiBindController extends BaseController {

	@Autowired
	private PayPiBindService payPiBindService;
	
	@RequiresPermissions("payment:payPiBind:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(PiVo vo, PageJqGrid page) {
		return payPiBindService.callQueryByPage(vo, page);
    }
	
	/**
	 * @function 付款保障编辑页面跳转
	 * @param piid
	 * @return ModelAndView
	 * */
	@RequiresPermissions("payment:payPiBind:view")
    @RequestMapping(value = "/editPage", method = RequestMethod.GET)
    public ModelAndView editPage(String piid){
		ModelAndView view = new ModelAndView("sdo/payment/payPiBindEdit");
		Object vo = payPiBindService.callQueryById(piid);
		JSONArray jsonArray = JSONArray.fromObject(vo);
		view.addObject("pibindlist", jsonArray); 
		view.addObject("pibind", vo);
    	return view;
    }
	
	@RequiresPermissions("payment:payPiBind:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/payment/payPiBindList";
	}
	
	/**
	 * @function 付款保障查询页面跳转
	 * @param piid
	 * @return ModelAndView
	 * */
	@RequiresPermissions("payment:payPiBind:view")
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String piid){
		ModelAndView view = new ModelAndView("sdo/payment/payPiBindView");
    	view.addObject("pibind", payPiBindService.callQueryById(piid));
    	return view;
    }
	
	/**
	 * @function 保存付款保障
	 * @param PiVo,piList
	 * @return PiVo
	 * */
    @RequiresPermissions("payment:payPiBind:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    public void submit(PayPiBindVo vo, @RequestParam(value = "bdList")String bdList) {
    	JSONArray array = JSONArray.fromObject(bdList);
		@SuppressWarnings("unchecked")
		List<PayPiBindDetailVo> list = (List<PayPiBindDetailVo>) JSONArray.toCollection(array, PayPiBindDetailVo.class);
		vo.setTt_xxlist(list);
    	payPiBindService.submit(vo);
    }
    
    @RequiresPermissions("payment:payPiBind:view")
    @RequestMapping(value = "exportitem")
	public void exportmx(HttpServletResponse response, @RequestParam Map<String, Object> params, PiVo vo) {
    	payPiBindService.exportmx(response, params, vo);
	}
    
    @RequiresPermissions("payment:lcReg:view")
    @RequestMapping(value = "export")
    public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PiVo vo) {
    	payPiBindService.export(response, params, vo);
	}
}