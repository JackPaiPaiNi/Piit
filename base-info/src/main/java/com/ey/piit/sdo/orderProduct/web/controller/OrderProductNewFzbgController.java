package com.ey.piit.sdo.orderProduct.web.controller;

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
import com.ey.piit.sdo.order.vo.OrderProductCkdVo;
import com.ey.piit.sdo.orderProduct.service.OrderProductNewFzbgService;
import com.ey.piit.sdo.orderProduct.vo.OrderProductNewVo;

/**
 * 大货订单辅助变更管理Controller
 * 
 * @author tianrong
 */
@Controller
@RequestMapping(value = "order/orderProductNewFzbg")
public class OrderProductNewFzbgController extends BaseController {

	@Autowired
	private OrderProductNewFzbgService orderProductNewFzbgService;

	@Autowired
	private ExcelImporter excelImporter;

	@RequiresPermissions("order:orderProductNewFzbg:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/orderProduct/orderProductFzbgList";
	}

	@RequiresPermissions("order:orderProductNewFzbg:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(OrderProductNewVo vo, PageJqGrid page) {
		return orderProductNewFzbgService.callQueryByPage(vo, page);
	}

	@RequiresPermissions("order:orderProductNewFzbg:view")
	@Token(create = true)
	@RequestMapping(value = "editPage", method = RequestMethod.GET)
	public String editPage() {
		return "sdo/orderProduct/orderProductFzbgEdit";
	}

	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	@ResponseBody
	@Token(verify = false)
	public Object findById(String id) {
		return orderProductNewFzbgService.callQueryById(id);
	}

	@RequiresPermissions("order:orderProductNewFzbg:edit")
	@RequestMapping(value = "edit")
	@Token(verify = true)
	@ResponseBody
	public Object edit(OrderProductNewVo vo) {
		return orderProductNewFzbgService.edit(vo);
	}

	@RequiresPermissions("order:orderProductNewFzbg:edit")
	@RequestMapping(value = "submit")
	@Token(verify = true)
	@ResponseBody
	public void submit(OrderProductNewVo vo) {
		orderProductNewFzbgService.submit(vo);
	}

	@RequiresPermissions("order:orderProductNewFzbg:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public void delete(String id, String sjc, int zt, String processId) {
		orderProductNewFzbgService.delete(id, sjc, zt, processId);
	}

	@RequestMapping(value = "approvePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView approvePage(String id) {
		ModelAndView view = new ModelAndView("sdo/orderProduct/orderProductFzbgApprove");
		view.addObject("orderProduct", orderProductNewFzbgService.callQueryById(id));
		return view;
	}

	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/orderProduct/orderProductFzbgView");
		view.addObject("orderProduct", orderProductNewFzbgService.callQueryById(id));
		return view;
	}

	@RequestMapping(value = "approve")
	@ResponseBody
	@Token(verify = true)
	public Object approve(OrderProductNewVo vo) {
		return orderProductNewFzbgService.approve(vo);
	}

	/**
	 * 订单信息导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("order:orderProductNewFzbg:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderProductNewVo vo) {
		orderProductNewFzbgService.export(response, params, vo);
	}
	
	/**
     * function 大货订单变更
     * @param vo
     */
    @RequiresPermissions("order:orderProductNewFzbg:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(OrderProductNewVo vo) {
    	orderProductNewFzbgService.change(vo);
    }
	
	/**
	 * ckd查询
	 *  修改人：赵桃军 2016-6-27
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("order:orderProductNewFzbg:view")
	@RequestMapping(value = "queryCkd")
	@ResponseBody
	public Object queryCkd(OrderProductCkdVo vo, PageJqGrid page) {
		return orderProductNewFzbgService.queryCkdByPage(vo, page);
	}
	
	/**
     * function 大货订单取回
     * @param vo
     */
    @RequiresPermissions("order:orderProductNewFzbg:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(OrderProductNewVo vo) {
    	orderProductNewFzbgService.getback(vo);
    }
}