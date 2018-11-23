package com.ey.piit.sdo.order.web.controller;

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

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.order.service.OrderProductFzbgService;
import com.ey.piit.sdo.order.vo.OrderProductCkdVo;
import com.ey.piit.sdo.order.vo.OrderProductVo;

/**
 * 大货订单辅助变更管理Controller
 * 
 * @author tianrong
 */
@Controller
@RequestMapping(value = "orderfzbg/orderProductFzbg")
public class OrderProductFzbgController extends BaseController {

	@Autowired
	private OrderProductFzbgService orderProductFzbgService;

	@Autowired
	private ExcelImporter excelImporter;

	@RequiresPermissions("orderfzbg:orderProductFzbg:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/orderfzbg/orderProductFzbgList";
	}

	@RequiresPermissions("orderfzbg:orderProductFzbg:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(OrderProductVo vo, PageJqGrid page) {
		return orderProductFzbgService.callQueryByPage(vo, page);
	}

	@RequiresPermissions("orderfzbg:orderProductFzbg:view")
	@Token(create = true)
	@RequestMapping(value = "editPage", method = RequestMethod.GET)
	public String editPage() {
		return "sdo/orderfzbg/orderProductFzbgEdit";
	}

	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	@ResponseBody
	@Token(verify = false)
	public Object findById(String id) {
		return orderProductFzbgService.callQueryById(id);
	}

	@RequiresPermissions("orderfzbg:orderProductFzbg:edit")
	@RequestMapping(value = "edit")
	@Token(verify = true)
	@ResponseBody
	public Object edit(OrderProductVo vo) {
		return orderProductFzbgService.edit(vo);
	}

	@RequiresPermissions("orderfzbg:orderProductFzbg:edit")
	@RequestMapping(value = "submit")
	@Token(verify = true)
	@ResponseBody
	public void submit(OrderProductVo vo) {
		orderProductFzbgService.submit(vo);
	}

	@RequiresPermissions("orderfzbg:orderProductFzbg:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public void delete(String id, String sjc, int zt, String processId) {
		orderProductFzbgService.delete(id, sjc, zt, processId);
	}

	@RequestMapping(value = "approvePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView approvePage(String id) {
		ModelAndView view = new ModelAndView("sdo/orderfzbg/orderProductFzbgApprove");
		view.addObject("orderProduct", orderProductFzbgService.callQueryById(id));
		return view;
	}

	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/orderfzbg/orderProductFzbgView");
		view.addObject("orderProduct", orderProductFzbgService.callQueryById(id));
		return view;
	}

	@RequestMapping(value = "approve")
	@ResponseBody
	@Token(verify = true)
	public Object approve(OrderProductVo vo) {
		return orderProductFzbgService.approve(vo);
	}

	/**
	 * 订单信息导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("orderfzbg:orderProductFzbg:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderProductVo vo) {
		orderProductFzbgService.export(response, params, vo);
	}
	
	/**
     * function 大货订单变更
     * @param vo
     */
    @RequiresPermissions("orderfzbg:orderProductFzbg:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(OrderProductVo vo) {
    	orderProductFzbgService.change(vo);
    }
	
	/**
	 * ckd查询
	 *  修改人：赵桃军 2016-6-27
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("orderfzbg:orderProductFzbg:view")
	@RequestMapping(value = "queryCkd")
	@ResponseBody
	public Object queryCkd(OrderProductCkdVo vo, PageJqGrid page) {
		return orderProductFzbgService.queryCkdByPage(vo, page);
	}
	
	/**
     * function 大货订单取回
     * @param vo
     */
    @RequiresPermissions("orderfzbg:orderProductFzbg:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(OrderProductVo vo) {
    	orderProductFzbgService.getback(vo);
    }
}