package com.ey.piit.sdo.orderProduct.web.controller;

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
import com.ey.piit.sdo.art.service.ArtSkyworthService;
import com.ey.piit.sdo.art.service.ArtoemService;
import com.ey.piit.sdo.order.vo.OrderProductCkdVo;
import com.ey.piit.sdo.order.vo.OrderReferPiVo;
import com.ey.piit.sdo.orderProduct.service.OrderProductNewService;
import com.ey.piit.sdo.orderProduct.vo.OrderProductNewVo;

/**
 * 大货订单管理Controller
 * 
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "order/orderProductNew")
public class OrderProductNewController extends BaseController {

	@Autowired
	private OrderProductNewService orderProductNewService;
	
	@Autowired
	private ArtSkyworthService artSkyworthService;
	
	@Autowired
	private ArtoemService artoemService;

	@Autowired
	private ExcelImporter excelImporter;

	@RequiresPermissions("order:orderProductNew:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/orderProduct/orderProductList";
	}

	@RequiresPermissions("order:orderProductNew:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(OrderProductNewVo vo, PageJqGrid page) {
		return orderProductNewService.callQueryByPage(vo, page);
	}
	/**
	 * 金额信息修改页面
	 * @return
	 */
	@RequiresPermissions("order:orderProductNew:view")
	@Token(create = true)
	@RequestMapping(value = "changeEditPage", method = RequestMethod.GET)
	public String changeEditPage() {
		return "sdo/orderProduct/orderProductJexxEdit";
	}
	
	@RequiresPermissions("order:orderProductNew:view")
	@Token(create = true)
	@RequestMapping(value = "editPage", method = RequestMethod.GET)
	public String editPage() {
		return "sdo/orderProduct/orderProductEdit";
	}

	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	@ResponseBody
	@Token(verify = false)
	public Object findById(String id) {
		return orderProductNewService.callQueryById(id);
	}

	@RequiresPermissions("order:orderProductNew:edit")
	@RequestMapping(value = "edit")
	@Token(verify = true)
	@ResponseBody
	public Object edit(OrderProductNewVo vo, @RequestParam(value = "piList") String piList) {
		JSONArray array = JSONArray.fromObject(piList);
		@SuppressWarnings("unchecked")
		List<OrderReferPiVo> list = (List<OrderReferPiVo>) JSONArray.toCollection(array, OrderReferPiVo.class);
		vo.setOrderReferPiList(list);
		return orderProductNewService.edit(vo);
	}

	@RequiresPermissions("order:orderProductNew:edit")
	@RequestMapping(value = "submit")
	@Token(verify = true)
	@ResponseBody
	public void submit(OrderProductNewVo vo, @RequestParam(value = "piList") String piList) {
		JSONArray array = JSONArray.fromObject(piList);
		@SuppressWarnings("unchecked")
		List<OrderReferPiVo> list = (List<OrderReferPiVo>) JSONArray.toCollection(array, OrderReferPiVo.class);
		vo.setOrderReferPiList(list);
		orderProductNewService.submit(vo);
	}

	@RequiresPermissions("order:orderProductNew:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public void delete(String id, String sjc, int zt, String processId) {
		orderProductNewService.delete(id, sjc, zt, processId);
	}

	@RequestMapping(value = "approvePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView approvePage(String id) {
		ModelAndView view = new ModelAndView("sdo/orderProduct/orderProductApprove");
		view.addObject("orderProduct", orderProductNewService.callQueryById(id));
		return view;
	}
	
	//流程跳转页面用到，当审批人是计划物控员等
	@RequestMapping(value = "hdApprovePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView hdApprovePage(String id) {
		ModelAndView view = new ModelAndView("sdo/orderProduct/orderProductApprove");
		view.addObject("orderProduct", orderProductNewService.callQueryById(id));
		view.addObject("isRestart", "1");
		return view;
	}
	
	//流程跳转页面用到，当审批人是供应链支持专员
	@RequestMapping(value = "endApprovePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView endApprovePage(String id) {
		ModelAndView view = new ModelAndView("sdo/orderProduct/orderProductApprove");
		view.addObject("orderProduct", orderProductNewService.callQueryById(id));
		view.addObject("isRestart", "0");
		return view;
	}

	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/orderProduct/orderProductView");
		view.addObject("orderProduct", orderProductNewService.callQueryByIdView(id));
		return view;
	}
	
	@RequestMapping(value = "viewPageByDh", method = RequestMethod.GET)
	public ModelAndView viewPageByDh(String ddid) {
		ModelAndView view = new ModelAndView("sdo/orderProduct/orderProductView");
		view.addObject("orderProduct", orderProductNewService.callQueryByDh(ddid));
		return view;
	}


	@RequiresPermissions("order:orderProductNew:view")
	@RequestMapping(value = "printPage", method = RequestMethod.GET)
	public ModelAndView printPage(String id) {
		ModelAndView view = new ModelAndView("sdo/orderProduct/orderProductPrint");
		view.addObject("orderProduct", orderProductNewService.callQueryById(id));
		return view;
	}

	@RequestMapping(value = "approve")
	@ResponseBody
	@Token(verify = true)
	public Object approve(OrderProductNewVo vo) {
		return orderProductNewService.approve(vo);
	}

	/**
	 * 订单信息导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("order:orderProductNew:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderProductNewVo vo) {
		orderProductNewService.export(response, params, vo);
	}
	
	/**
     * @function 大货订单撤回取消（type：1取消 2撤回）
     * @param vo
     */
    @RequiresPermissions("order:orderProductNew:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(OrderProductNewVo vo) {
    	orderProductNewService.cancel(vo);
    }
    
    @RequestMapping(value = "cancelApprovePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView cancelApprovePage(String id) {
		ModelAndView view = new ModelAndView("sdo/orderProduct/orderProductCancelApprove");
		view.addObject("orderProduct", orderProductNewService.callQueryById(id));
		return view;
	}
    
    @RequestMapping(value = "cancelApprove")
	@ResponseBody
	@Token(verify = true)
	public void cancelApprove(OrderProductNewVo vo) {
		orderProductNewService.cancelApprove(vo);
	}
	
	/**
     * function 大货订单变更
     * @param vo
     */
    @RequiresPermissions("order:orderProductNew:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(OrderProductNewVo vo) {
    	orderProductNewService.change(vo);
    }
	
	/**
	 * ckd 明细计算 
	 * 修改人：赵桃军 2016-6-27
	 * @param vo
	 * @return
	 */
	@RequiresPermissions("order:orderProductNew:view")
	@RequestMapping(value = "computeCkd")
	@ResponseBody
	public void computeCkd(OrderProductNewVo vo) {
		 orderProductNewService.ckdCompute(vo);
	}

	/**
	 * ckd 明细导入 
	 * 修改人：赵桃军 2016-6-27
	 * @param file
	 * @param vo
	 */
	@RequiresPermissions("order:orderProductNew:view")
	@RequestMapping(value = "ckdImport")
	@ResponseBody
	public void importCkdFile(MultipartFile file, OrderProductNewVo vo) {
		List<OrderProductCkdVo> list = excelImporter.importFileReturn(OrderProductCkdVo.class, file, null);
		vo.setWycCkdList(list);
		orderProductNewService.saveOrderCkd(vo);
	}
	
	/**
	 * ckd 明细导出 
	 * 修改人：赵桃军 2016-6-27
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("order:orderProductNew:view")
	@RequestMapping(value = "ckdExport")
	@ResponseBody
	public void exportCkdFile(HttpServletResponse response, @RequestParam Map<String, Object> params,
			OrderProductNewVo vo) {
		orderProductNewService.exportCkd(response, params, vo);
	}

	/**
	 * CKD明细修改 
	 * 修改人：赵桃军 2016-6-27
	 * @param vo
	 */
	@RequiresPermissions("order:orderProductNew:edit")
	@RequestMapping(value = "editCkd")
	@ResponseBody
	public Object updateCkdById(OrderProductCkdVo vo) {
		return orderProductNewService.saveOrderCkdItem(vo);
	}

	/**
	 * ckd 移除和移回操作
	 * 修改人：赵桃军 2016-6-27
	 * @param vo
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("order:orderProductNew:view")
	@RequestMapping(value = "addOrRemove")
	@ResponseBody
	public void addOrRemove(OrderProductCkdVo vo, String ids) {
		JSONArray array = JSONArray.fromObject(ids);
		orderProductNewService.ckdAddOrRemove(vo, array);
	}

	/**
	 * ckd查询
	 *  修改人：赵桃军 2016-6-27
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("order:orderProductNew:view")
	@RequestMapping(value = "queryCkd")
	@ResponseBody
	public Object queryCkd(OrderProductCkdVo vo, PageJqGrid page) {
		return orderProductNewService.queryCkdByPage(vo, page);
	}
	
	/**
	 * 推送SAP
	 * @param vo
	 * @throws Exception 
	 */
	@RequiresPermissions("order:orderProductNew:edit")
	@RequestMapping(value = "pushSAP")
	@ResponseBody
	public OrderProductNewVo pushSAP(String id) throws Exception {
		return orderProductNewService.tsSapAndWriteLog(id);
	}
	/**
	 * 同步pid研发bom
	 * @param vo
	 */
	@RequiresPermissions("order:orderProductNew:edit")
	@RequestMapping(value = "snycPidBom")
	@ResponseBody
	public void snycPidBom(OrderProductNewVo vo) {
		orderProductNewService.snycPidBom(vo);
	}
	
	/**
     * function 大货订单取回
     * @param vo
     */
    @RequiresPermissions("order:orderProductNew:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(OrderProductNewVo vo) {
    	orderProductNewService.getback(vo);
    }
    /**
     * 大货订单产品经理选择设计师页面
     * @return
     */
    @RequestMapping(value = "approvePageJgsxz", method = RequestMethod.GET)
    @Token(create = true)
    public ModelAndView approvePageJgsxz(String id){
    	ModelAndView view = new ModelAndView("sdo/orderProduct/orderProductJgsxzApprove");
		view.addObject("orderProduct", orderProductNewService.callQueryById(id));
		return view;
    }
	
	/**
	 * 暂停启用页面
	 * @return
	 */
	@RequestMapping(value = "pauseEditPage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView pauseEditPage(String id, String type) {
		ModelAndView view = new ModelAndView("sdo/orderProduct/orderProductZtqyEdit");
		view.addObject("orderProduct", orderProductNewService.callQueryById(id));
		view.addObject("sfZt", type);
		return view;
	}
	
	/**
	 * 大货订单暂停/启用
	 * @param vo
	 */
    @RequiresPermissions("order:orderProductNew:edit")
    @RequestMapping(value = "pause")
    @ResponseBody
    public void pause(OrderProductNewVo vo, Integer type) {
    	orderProductNewService.pause(vo, type);
    }
    
    /**
     * 大货订单暂停提交
     * @param vo
     */
    @RequiresPermissions("order:orderProductNew:edit")
	@RequestMapping(value = "pauseSubmit")
	@Token(verify = true)
	@ResponseBody
	public void pauseSubmit(OrderProductNewVo vo) {
		orderProductNewService.pauseSubmit(vo);
	}
    
    /**
     * 大货订单暂停审核
     * @param vo
     * @return
     */
    @RequestMapping(value = "pauseApprove")
	@ResponseBody
	@Token(verify = true)
	public void pauseApprove(OrderProductNewVo vo) {
		orderProductNewService.pauseApprove(vo);
	}
    
    @RequestMapping(value = "rwdviewPage", method = RequestMethod.GET)
	public ModelAndView rwdviewPage(String rwdh) {
    	OrderProductNewVo vo = (OrderProductNewVo)orderProductNewService.callQueryByRwdh(rwdh);
    	if(vo.getRwdtype() == 1){
    		ModelAndView view = new ModelAndView("sdo/art/artSkyworthPrint");
        	view.addObject("artSkyworth", artSkyworthService.callQueryHtyByRwdh(rwdh,vo.getBbh()));
    		return view;
    	}else{
    		ModelAndView view = new ModelAndView("sdo/art/artoemView");
        	view.addObject("artoem", artoemService.callQueryHtyByRwdh(rwdh,vo.getBbh())); 
    		return view;
    	}
	}
    
    /**
     * 大货订单修改交期
     * @param vo
     */
    @RequiresPermissions("order:orderProductNew:changeJhrq")
    @RequestMapping(value = "changeJhrq")
    @ResponseBody
    public void changeJhrq(OrderProductNewVo vo) {
    	orderProductNewService.changeJhrq(vo);
    }
    
}