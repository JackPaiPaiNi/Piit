package com.ey.piit.sdo.order.web.controller;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.order.service.OrderProductService;
import com.ey.piit.sdo.order.vo.OrderProductCkdVo;
import com.ey.piit.sdo.order.vo.OrderProductVo;
import com.ey.piit.sdo.order.vo.OrderReferPiVo;

/**
 * 大货订单管理Controller
 * 
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "order/orderProduct")
public class OrderProductController extends BaseController {

	@Autowired
	private OrderProductService orderProductService;

	@Autowired
	private ExcelImporter excelImporter;

	@RequiresPermissions("order:orderProduct:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/order/orderProductList";
	}

	@RequiresPermissions("order:orderProduct:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(OrderProductVo vo, PageJqGrid page) {
		return orderProductService.callQueryByPage(vo, page);
	}
	/**
	 * 金额信息修改页面
	 * @return
	 */
	@RequiresPermissions("order:orderProduct:view")
	@Token(create = true)
	@RequestMapping(value = "changeEditPage", method = RequestMethod.GET)
	public String changeEditPage() {
		return "sdo/order/orderProductJexxEdit";
	}
	
	@RequiresPermissions("order:orderProduct:view")
	@Token(create = true)
	@RequestMapping(value = "editPage", method = RequestMethod.GET)
	public String editPage() {
		return "sdo/order/orderProductEdit";
	}

	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	@ResponseBody
	@Token(verify = false)
	public Object findById(String id) {
		return orderProductService.callQueryById(id);
	}

	@RequiresPermissions("order:orderProduct:edit")
	@RequestMapping(value = "edit")
	@Token(verify = true)
	@ResponseBody
	public Object edit(OrderProductVo vo, @RequestParam(value = "piList") String piList) {
		JSONArray array = JSONArray.fromObject(piList);
		@SuppressWarnings("unchecked")
		List<OrderReferPiVo> list = (List<OrderReferPiVo>) JSONArray.toCollection(array, OrderReferPiVo.class);
		vo.setOrderReferPiList(list);
		return orderProductService.edit(vo);
	}

	@RequiresPermissions("order:orderProduct:edit")
	@RequestMapping(value = "submit")
	@Token(verify = true)
	@ResponseBody
	public void submit(OrderProductVo vo, @RequestParam(value = "piList") String piList) {
		JSONArray array = JSONArray.fromObject(piList);
		@SuppressWarnings("unchecked")
		List<OrderReferPiVo> list = (List<OrderReferPiVo>) JSONArray.toCollection(array, OrderReferPiVo.class);
		vo.setOrderReferPiList(list);
		orderProductService.submit(vo);
	}

	@RequiresPermissions("order:orderProduct:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public void delete(String id, String sjc, int zt, String processId) {
		orderProductService.delete(id, sjc, zt, processId);
	}

	@RequestMapping(value = "approvePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView approvePage(String id) {
		ModelAndView view = new ModelAndView("sdo/order/orderProductApprove");
		view.addObject("orderProduct", orderProductService.callQueryById(id));
		return view;
	}
	
	//流程跳转页面用到，当审批人是计划物控员等
	@RequestMapping(value = "hdApprovePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView hdApprovePage(String id) {
		ModelAndView view = new ModelAndView("sdo/order/orderProductApprove");
		view.addObject("orderProduct", orderProductService.callQueryById(id));
		view.addObject("isRestart", "1");
		return view;
	}
	
	//流程跳转页面用到，当审批人是供应链支持专员
	@RequestMapping(value = "endApprovePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView endApprovePage(String id) {
		ModelAndView view = new ModelAndView("sdo/order/orderProductApprove");
		view.addObject("orderProduct", orderProductService.callQueryById(id));
		view.addObject("isRestart", "0");
		return view;
	}

	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/order/orderProductView");
		view.addObject("orderProduct", orderProductService.callQueryByIdView(id));
		return view;
	}
	
	@RequestMapping(value = "viewPageByDh", method = RequestMethod.GET)
	public ModelAndView viewPageByDh(String ddid) {
		ModelAndView view = new ModelAndView("sdo/order/orderProductView");
		view.addObject("orderProduct", orderProductService.callQueryByDh(ddid));
		return view;
	}


	@RequiresPermissions("order:orderProduct:view")
	@RequestMapping(value = "printPage", method = RequestMethod.GET)
	public ModelAndView printPage(String id) {
		ModelAndView view = new ModelAndView("sdo/order/orderProductPrint");
		view.addObject("orderProduct", orderProductService.callQueryById(id));
		return view;
	}

	@RequestMapping(value = "approve")
	@ResponseBody
	@Token(verify = true)
	public Object approve(OrderProductVo vo) {
		return orderProductService.approve(vo);
	}

	/**
	 * 订单信息导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("order:orderProduct:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderProductVo vo) {
		orderProductService.export(response, params, vo);
	}
	
	/**
     * @function 大货订单撤回取消（type：1取消 2撤回）
     * @param vo
     */
    @RequiresPermissions("order:orderProduct:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(OrderProductVo vo) {
    	orderProductService.cancel(vo);
    }
    
    @RequestMapping(value = "cancelApprovePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView cancelApprovePage(String id) {
		ModelAndView view = new ModelAndView("sdo/order/orderProductCancelApprove");
		view.addObject("orderProduct", orderProductService.callQueryById(id));
		return view;
	}
    
    @RequestMapping(value = "cancelApprove")
	@ResponseBody
	@Token(verify = true)
	public void cancelApprove(OrderProductVo vo) {
		orderProductService.cancelApprove(vo);
	}
	
	/**
     * function 大货订单变更
     * @param vo
     */
    @RequiresPermissions("order:orderProduct:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(OrderProductVo vo) {
    	orderProductService.change(vo);
    }
	
	/**
	 * ckd 明细计算 
	 * 修改人：赵桃军 2016-6-27
	 * @param vo
	 * @return
	 */
	@RequiresPermissions("order:orderProduct:view")
	@RequestMapping(value = "computeCkd")
	@ResponseBody
	public void computeCkd(OrderProductVo vo) {
		 orderProductService.ckdCompute(vo);
	}

	/**
	 * ckd 明细导入 
	 * 修改人：赵桃军 2016-6-27
	 * @param file
	 * @param vo
	 */
	@RequiresPermissions("order:orderProduct:view")
	@RequestMapping(value = "ckdImport")
	@ResponseBody
	public void importCkdFile(MultipartFile file, OrderProductVo vo) {
		List<OrderProductCkdVo> list = excelImporter.importFileReturn(OrderProductCkdVo.class, file, null);
		vo.setWycCkdList(list);
		orderProductService.saveOrderCkd(vo);
	}
	
	/**
	 * ckd 明细导出 
	 * 修改人：赵桃军 2016-6-27
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("order:orderProduct:view")
	@RequestMapping(value = "ckdExport")
	@ResponseBody
	public void exportCkdFile(HttpServletResponse response, @RequestParam Map<String, Object> params,
			OrderProductVo vo) {
		orderProductService.exportCkd(response, params, vo);
	}

	/**
	 * CKD明细修改 
	 * 修改人：赵桃军 2016-6-27
	 * @param vo
	 */
	@RequiresPermissions("order:orderProduct:edit")
	@RequestMapping(value = "editCkd")
	@ResponseBody
	public Object updateCkdById(OrderProductCkdVo vo) {
		return orderProductService.saveOrderCkdItem(vo);
	}

	/**
	 * ckd 移除和移回操作
	 * 修改人：赵桃军 2016-6-27
	 * @param vo
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("order:orderProduct:view")
	@RequestMapping(value = "addOrRemove")
	@ResponseBody
	public void addOrRemove(OrderProductCkdVo vo, String ids) {
		JSONArray array = JSONArray.fromObject(ids);
		orderProductService.ckdAddOrRemove(vo, array);
	}

	/**
	 * ckd查询
	 *  修改人：赵桃军 2016-6-27
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("order:orderProduct:view")
	@RequestMapping(value = "queryCkd")
	@ResponseBody
	public Object queryCkd(OrderProductCkdVo vo, PageJqGrid page) {
		return orderProductService.queryCkdByPage(vo, page);
	}
	
	/**
	 * 推送SAP
	 * @param vo
	 * @throws Exception 
	 */
	@RequiresPermissions("order:orderProduct:edit")
	@RequestMapping(value = "pushSAP")
	@ResponseBody
	public OrderProductVo pushSAP(String id) throws Exception {
		return orderProductService.tsSapAndWriteLog(id);
	}
	/**
	 * 同步pid研发bom
	 * @param vo
	 */
	@RequiresPermissions("order:orderProduct:edit")
	@RequestMapping(value = "snycPidBom")
	@ResponseBody
	public void snycPidBom(OrderProductVo vo) {
		orderProductService.snycPidBom(vo);
	}
	
	/**
     * function 大货订单取回
     * @param vo
     */
    @RequiresPermissions("order:orderProduct:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(OrderProductVo vo) {
    	orderProductService.getback(vo);
    }
    /**
     * 大货订单产品经理选择设计师页面
     * @return
     */
    @RequestMapping(value = "approvePageJgsxz", method = RequestMethod.GET)
    @Token(create = true)
    public ModelAndView approvePageJgsxz(String id){
    	ModelAndView view = new ModelAndView("sdo/order/orderProductJgsxzApprove");
		view.addObject("orderProduct", orderProductService.callQueryById(id));
		return view;
    }
	
	/**
	 * 暂停启用页面
	 * @return
	 */
	@RequestMapping(value = "pauseEditPage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView pauseEditPage(String id, String type) {
		ModelAndView view = new ModelAndView("sdo/order/orderProductZtqyEdit");
		view.addObject("orderProduct", orderProductService.callQueryById(id));
		view.addObject("sfZt", type);
		return view;
	}
	
	/**
	 * 大货订单暂停/启用
	 * @param vo
	 */
    @RequiresPermissions("order:orderProduct:edit")
    @RequestMapping(value = "pause")
    @ResponseBody
    public void pause(OrderProductVo vo, Integer type) {
    	orderProductService.pause(vo, type);
    }
    
    /**
     * 大货订单暂停提交
     * @param vo
     */
    @RequiresPermissions("order:orderProduct:edit")
	@RequestMapping(value = "pauseSubmit")
	@Token(verify = true)
	@ResponseBody
	public void pauseSubmit(OrderProductVo vo) {
		orderProductService.pauseSubmit(vo);
	}
    
    /**
     * 大货订单暂停审核
     * @param vo
     * @return
     */
    @RequestMapping(value = "pauseApprove")
	@ResponseBody
	@Token(verify = true)
	public void pauseApprove(OrderProductVo vo) {
		orderProductService.pauseApprove(vo);
	}
    
}