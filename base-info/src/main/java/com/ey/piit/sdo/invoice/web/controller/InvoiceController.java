package com.ey.piit.sdo.invoice.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import com.ey.piit.core.report.service.ReportService;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.invoice.service.InvoiceService;
import com.ey.piit.sdo.invoice.vo.InvoiceItemVo;
import com.ey.piit.sdo.invoice.vo.InvoiceOtherVo;
import com.ey.piit.sdo.invoice.vo.InvoiceVo;
import com.ey.piit.sdo.invoice.vo.WkptjVo;

/**
 * 发票信息维护Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "invoice/invoice")
public class InvoiceController extends BaseController {

	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private ReportService reportService;
	
    /**
     * 发票主页
     * @return
     */
	@RequiresPermissions("invoice:invoice:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/invoice/invoiceList";
	}
	
	// 未开票统计页面
	@RequiresPermissions("invoice:invoice:view")
	@RequestMapping(value = {"WkptjList"})
	public String WkptjList() {
		return "sdo/invoice/WkptjList";
	}
	/**
     * 发票查询
     * @param vo
     * @param page
     * @return
     */
	@RequiresPermissions("invoice:invoice:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(InvoiceVo vo, PageJqGrid page) {
        return invoiceService.callQueryByPage(vo, page);
    }
	
	/**
	 * @function 发票编辑页面
	 * @param 
	 * @return
	 * */
    @RequiresPermissions("invoice:invoice:view")
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    @Token(create = false)
    public String editPage(){
    	return "sdo/invoice/invoiceEdit";
    }
    
    /**
	 * @function 查询发票明细
	 * @param id
	 * @return 
	 * */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return invoiceService.callQueryById(id);
    }
    
    /**
	 * @function 保存发票
	 * @param InvoiceVo,fpList,xdList,qtfyList
	 * @return InvoiceVo
	 * */
    @RequiresPermissions("invoice:invoice:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    @Token(verify = false)
    public Object edit(InvoiceVo vo, @RequestParam(value = "qtList")String qtList) {
    	JSONArray qtArray = JSONArray.fromObject(qtList);
		@SuppressWarnings("unchecked")
		List<InvoiceOtherVo> qtfyList = (List<InvoiceOtherVo>) JSONArray.toCollection(qtArray, InvoiceOtherVo.class);
    	vo.setInvoiceOtherList(qtfyList);
    	return invoiceService.edit(vo);
    }
    
    /**
	 * @function 提交发票
	 * @param InvoiceVo,fpList
	 * @return null
	 * */
    @RequiresPermissions("invoice:invoice:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = false)
    public void submit(InvoiceVo vo, @RequestParam(value = "qtList")String qtList) {
    	JSONArray qtArray = JSONArray.fromObject(qtList);
		@SuppressWarnings("unchecked")
		List<InvoiceOtherVo> qtfyList = (List<InvoiceOtherVo>) JSONArray.toCollection(qtArray, InvoiceOtherVo.class);
    	vo.setInvoiceOtherList(qtfyList);
    	invoiceService.submit(vo);
    }
    /**
	 * @function 提交附件
	 * @param InvoiceVo,fpList
	 * @return null
	 * */
    @RequiresPermissions("invoice:invoice:edit")
    @RequestMapping(value = "submitFj")
    @ResponseBody
    @Token(verify = false)
    public void submitFj(InvoiceVo vo) {
    	invoiceService.submitFj(vo);
    }    
    /**
	 * @function 删除发票
	 * @param id,sjc
	 * @return null
	 * */
    @RequiresPermissions("invoice:invoice:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id, String sjc) {
    	invoiceService.delete(id,sjc);
    }
    
    /**
	 * @function 取消发票
	 * @param id,sjc
	 * @return null
	 * */
    @RequiresPermissions("invoice:invoice:edit")
    @RequestMapping(value = "cancle")
    @ResponseBody
    public void cancle(String id, String sjc) {
    	invoiceService.cancle(id,sjc);
    }
    
    /**
	 * @function 发票查看页面跳转
	 * @param id
	 * @return ModelAndView
	 * */
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/invoice/invoiceView");
    	view.addObject("invoice",invoiceService.callQueryById(id)); 
    	return view;
    }
    
    /**
     * 订单选择页面
     * @return
     */
    @RequestMapping(value = {"sapOrderlist"})
	public String listOrder() {
		return "sdo/invoice/sapOrderList";
	}
	
    /**
     * 可选择订单查询
     * @param vo
     * @param page
     * @return
     */
    @RequestMapping(value = "searchOrder")
    @ResponseBody
    public Object searchOrder(InvoiceItemVo vo, PageJqGrid page) {
        return invoiceService.callQueryOrderByPage(vo, page);
    }
    
    @RequestMapping(value = "searchMain")
    @ResponseBody
    public Object searchMain(String id, String kpfs, String chdhs, String ddids, String xdwlmsyy) {
        return invoiceService.callQueryMain(id, kpfs, chdhs, ddids, xdwlmsyy);
    }
    
    /**
     * 发票明细查询页面
     * @return
     */
	@RequiresPermissions("invoice:invoice:view")
	@RequestMapping(value = {"itemList"})
	public String itemList() {
		return "sdo/invoice/invoiceItemList";
	}
	
	/**
	 * 发票明细查询
	 * @param fph
	 * @param kpfs
	 * @param xdwlmsyy
	 * @param page
	 * @return
	 */
	@RequiresPermissions("invoice:invoice:view")
    @RequestMapping(value = "searchItem")
    @ResponseBody
    public Object searchItem(String id, String xdwlmsyy, PageJqGrid page) {
        return invoiceService.callQueryItemByPage(id, xdwlmsyy, page);
    }
	
	@RequestMapping(value = "searchPacking")
    @ResponseBody
    public Object searchPacking(String id, String xdwlmsyy, PageJqGrid page) {
        return invoiceService.callQueryPackingByPage(id, xdwlmsyy, page);
    }
	
	@RequestMapping(value = "searchOther")
    @ResponseBody
    public Object searchOther(String id,PageJqGrid page) {
        return invoiceService.callQueryOtherByPage(id, page);
    }
	 /**
     * 物料选择页面
     * @return
     */
	@RequestMapping(value = {"sapMateriallist"})
	public String listMaterial() {
		return "sdo/invoice/sapMaterialList";
	}
	
	/**
	 * 可选择物料查询
	 * @param wlbh
	 * @param wlms
	 * @param page
	 * @return
	 */
    @RequestMapping(value = "searchMaterial")
    @ResponseBody
    public Object searchMaterial(String id, String wlbh, String wlms,String gh, PageJqGrid page) {
        return invoiceService.callQueryMaterialByPage(id, wlbh, wlms,gh, page);
    }
    
    @RequestMapping(value = "saveMaterial")
    @ResponseBody
    public void saveMaterial(String ids, String flag) {
    	invoiceService.saveMaterial(ids, flag);
    }
    
    /**
	 * @function 导出发票列表
	 * @param HttpServletResponse,Map<String, Object>,InvoiceVo
	 * @return null
	 * */
	@RequiresPermissions("invoice:invoice:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, InvoiceVo vo) {
		invoiceService.export(response, params, vo);
	}
	
	/**
	 * 发票打印
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequiresPermissions("invoice:invoice:view")
	@RequestMapping(value = "/reportDown")
	public void reportDown(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String type = request.getParameter("type");
    	String fpmb = request.getParameter("fpmb");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("V_FPH", request.getParameter("fph"));
		// excel
		if("1".equals(type) && "1".equals(fpmb)){
			reportService.exportExcel(request, response, "CBU&SKDinvoice.jasper", "CBU&SKDinvoice.xlsx", parameters);
		} else if("1".equals(type) && "2".equals(fpmb)){
			reportService.exportExcel(request, response, "BrazilCKDInvoice.jasper", "BrazilCKDInvoice.xlsx", parameters);
		} else if("1".equals(type) && "3".equals(fpmb)){
			reportService.exportExcel(request, response, "ArgentinaCKDInvoice.jasper", "ArgentinaCKDInvoice.xlsx", parameters);
		} else if("2".equals(type) && "1".equals(fpmb)){
			reportService.exportExcel(request, response, "CBU&SKDpacking.jasper", "CBU&SKDpacking.xlsx", parameters);
		} else if("2".equals(type) && "2".equals(fpmb)){
			reportService.exportExcel(request, response, "BrazilCKDPacking.jasper", "BrazilCKDPacking.xlsx", parameters);
		} else if("2".equals(type) && "3".equals(fpmb)){
			reportService.exportExcel(request, response, "ArgentinaCKDPacking.jasper", "ArgentinaCKDPacking.xlsx", parameters);
		}
	}
    
    /**
	 * 推送SAP
	 * @param vo
	 */
	@RequiresPermissions("invoice:invoice:edit")
	@RequestMapping(value = "pushSAP")
	@ResponseBody
	public void pushSAP(InvoiceVo vo) {
		invoiceService.tsSapAndWriteLog(vo);
	}
	
	/**
	 * 海运费推送SAP
	 * @param vo
	 */
	@RequiresPermissions("invoice:invoice:edit")
    @RequestMapping(value = "pushChargesToSAP")
	@ResponseBody
	public void pushChargesToSAP(InvoiceVo vo) {
		invoiceService.tsChargesToSapAndWriteLog(vo);
	}
	
	/** 未开票统计查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("invoice:invoice:view")
    @RequestMapping(value = "WkptjSearch")
    @ResponseBody
    public Object WkptjSearch(WkptjVo vo, PageJqGrid page) {
		return invoiceService.callWkptjQueryByPage(vo, page);
    }
	
	@RequiresPermissions("invoice:invoice:view")
    @RequestMapping(value = "Wkptjexport")
	public void Wkptjexport(HttpServletResponse response, @RequestParam Map<String, Object> params, WkptjVo vo) {
		invoiceService.Wkptjexport(response, params, vo);
	}

}