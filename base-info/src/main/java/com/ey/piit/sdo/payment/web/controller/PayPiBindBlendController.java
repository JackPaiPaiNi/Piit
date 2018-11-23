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

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.fcst.vo.FcstBranchTmpVo;
import com.ey.piit.sdo.payment.service.PayPiBindBlendService;
import com.ey.piit.sdo.payment.vo.PayPiBindBlendVo;
import com.ey.piit.sdo.payment.vo.PayPiBindItemVo;
/**
 * PI付款保障已使用Controller
 * @author 田荣
 */
@Controller
@RequestMapping(value = "payment/payPiBindBlend")
public class PayPiBindBlendController extends BaseController {

	@Autowired
	private PayPiBindBlendService payPiBindBlendService;
	
	@RequiresPermissions("payment:payPiBindBlend:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/payment/payPiBindBlendList";
	}
	
	/***
	 * 自动勾兑list
	 * @return
	 */
	@RequiresPermissions("payment:payPiBindBlend:view")
	@RequestMapping(value = {"zdlist"})
	public String zdlist() {
		return "sdo/payment/payPiBindBlandZdList";
	}
	
	/***
	 * 手动勾兑list
	 * @return
	 */
	@RequiresPermissions("payment:payPiBindBlend:view")
	@RequestMapping(value = {"sdlist"})
	public String sdlist() {
		return "sdo/payment/payPiBindBlandSdList";
	}
	
	@RequiresPermissions("payment:payPiBindBlend:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(PayPiBindItemVo vo, PageJqGrid page) {
		return payPiBindBlendService.callQueryByPage(vo, page);
    }
	
	@RequiresPermissions("payment:payPiBindBlend:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PayPiBindItemVo vo) {
		payPiBindBlendService.export(response, params, vo);
	}
	
	@RequiresPermissions("payment:payPiBindBlend:view")
    @RequestMapping(value = "searchDb")
    @ResponseBody
    public Object searchDb(PayPiBindItemVo vo, PageJqGrid page) {
		return payPiBindBlendService.callQueryDbByPage(vo,page);
    }
	
	@RequiresPermissions("payment:payPiBindBlend:view")
    @RequestMapping(value = "exportDb")
	public void exportDb(HttpServletResponse response, @RequestParam Map<String, Object> params, PayPiBindItemVo vo) {
		payPiBindBlendService.exportDb(response, params, vo);
	}
	
	@RequiresPermissions("payment:payPiBindBlend:view")
    @RequestMapping(value = "/findByPiid", method = RequestMethod.POST)
    @ResponseBody
    public Object findByPiid(String piid){
    	return payPiBindBlendService.callQueryByPiid(piid);
    }
	
	/**
	 * @function 手工勾兑保存
	 * @param 
	 * @return 
	 * */
    @RequiresPermissions("payment:payPiBindBlend:edit")
    @RequestMapping(value = "saveBlend")
    @ResponseBody
    public void saveBlend(PayPiBindItemVo vo,@RequestParam(value = "list") String gdlist) {
    	JSONArray array = JSONArray.fromObject(gdlist);
		@SuppressWarnings("unchecked")
		List<PayPiBindBlendVo> list = (List<PayPiBindBlendVo>) JSONArray.toCollection(array, PayPiBindBlendVo.class);
    	payPiBindBlendService.saveBlend(vo,list);
    }
    
    /**
	 * @function 自动勾兑
	 * @param 
	 * @return 
	 * */
    @RequiresPermissions("payment:payPiBindBlend:edit")
    @RequestMapping(value = "blendAuto")
    @ResponseBody
    public void blendAuto(String piids) {
    	payPiBindBlendService.blendAuto(piids);
    }
    
    
    /**
	 * @function 删除勾兑
	 * @param 
	 * @return 
	 * */
    @RequiresPermissions("payment:payPiBindBlend:edit")
    @RequestMapping(value = "deleteBlend")
    @ResponseBody
    public void deleteBlend(String gddh) {
    	payPiBindBlendService.deleteBlend(gddh);
    }
    
}