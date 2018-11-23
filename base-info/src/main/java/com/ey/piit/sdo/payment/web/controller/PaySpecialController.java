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
import com.ey.piit.sdo.payment.service.PaySpecialService;
import com.ey.piit.sdo.payment.vo.PaySpecialVo;

/**
 * 特批查询Controller
 * @author 田荣
 */
@Controller
@RequestMapping(value = "payment/paySpecial")
public class PaySpecialController extends BaseController {

	@Autowired
	private PaySpecialService paySpecialService;
	
	@RequiresPermissions("payment:paySpecial:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/payment/paySpecialList";
	}
	
	@RequiresPermissions("payment:paySpecial:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(PaySpecialVo vo, PageJqGrid page) {
        return paySpecialService.callQueryByPage(vo, page);
    }
	
	@RequiresPermissions("payment:paySpecial:view")
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    public String editPage(){
    	return "sdo/payment/paySpecialEdit";
    }
	
	/**
	 * 特批查询（根据ID）
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("payment:paySpecial:view")
    @RequestMapping(value = {"findById"})
    @ResponseBody
    public Object findById(String id) {
		return paySpecialService.callQueryById(id);
    }
	
	@RequiresPermissions("payment:paySpecial:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(PaySpecialVo vo) {
    	paySpecialService.edit(vo);
    }
	
	@RequiresPermissions("payment:paySpecial:view")
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public String viewPage(){
    	return "sdo/payment/paySpecialView";
    }
	
    @RequiresPermissions("payment:paySpecial:edit")
    @RequestMapping(value = "xc")
    @ResponseBody
    public void xc(PaySpecialVo vo) {
    	paySpecialService.xc(vo);
    }
    
	@RequiresPermissions("payment:paySpecial:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(PaySpecialVo vo) {
		paySpecialService.delete(vo);
    }
	
	@RequiresPermissions("payment:paySpecial:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PaySpecialVo vo) {
		paySpecialService.export(response, params, vo);
	}
	
	/**
	 * 订单查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("payment:paySpecial:view")
    @RequestMapping(value = {"orderSearch"})
    @ResponseBody
    public Object orderSearch(PaySpecialVo vo, PageJqGrid page) {
		return paySpecialService.orderQueryByPage(vo, page);
    }
	
	/**
	 * 待特批的预走货查询（应收超期）
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("payment:paySpecial:view")
	@RequestMapping(value = "yzhSearch")
	@ResponseBody
	public Object yzhSearch(PaySpecialVo vo, PageJqGrid page) {
		return paySpecialService.yzhQueryByPage(vo, page);
	}
	
	/**
	 * 批量保存
	 * */
	@RequiresPermissions("payment:paySpecial:edit")
	@RequestMapping(value = "pledit")
	@ResponseBody
	public Object pledit(PaySpecialVo vo, @RequestParam(value = "list") String list) {
		JSONArray array = JSONArray.fromObject(list);
		@SuppressWarnings("unchecked")
		List<PaySpecialVo> voList = (List<PaySpecialVo>) JSONArray.toCollection(array,PaySpecialVo.class);
		paySpecialService.pledit(vo,voList);
		return vo;
	}
	
}