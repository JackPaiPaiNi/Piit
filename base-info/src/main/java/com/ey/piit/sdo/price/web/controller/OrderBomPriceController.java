package com.ey.piit.sdo.price.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.price.service.OrderBomPriceService;
import com.ey.piit.sdo.price.vo.JhdPriceVo;
import com.ey.piit.sdo.price.vo.OrderBomPriceVo;

/**
 * 销单bom价格Controller
 * @author 邓海
 */
@Controller
@RequestMapping(value = "price/orderBomPrice")
public class OrderBomPriceController extends BaseController {

	@Autowired
	private OrderBomPriceService orderBomPriceService;
	
	@Autowired
    private ExcelImporter excelImporter;
	
	@SuppressWarnings("unchecked")
	@RequiresPermissions("price:orderBomPrice:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(OrderBomPriceVo vo, PageJqGrid page) {
		List<OrderBomPriceVo> list =(List<OrderBomPriceVo>) orderBomPriceService.callQueryByPage(vo, page);
        return list;
    }
	
	@SuppressWarnings("unchecked")
	@RequiresPermissions("price:orderBomPrice:view")
    @RequestMapping(value = "searchJhd")
    @ResponseBody
    public Object searchJhd(JhdPriceVo vo, PageJqGrid page) {
		List<JhdPriceVo> list =(List<JhdPriceVo>) orderBomPriceService.callQueryJhdByPage(vo, page);
        return list;
    }
	
	
	@SuppressWarnings("unchecked")
	@RequiresPermissions("price:orderBomPrice:view")
    @RequestMapping(value = "searchOrder")
    @ResponseBody
    public Object searchOrder(JhdPriceVo vo, PageJqGrid page) {
		List<JhdPriceVo> list =(List<JhdPriceVo>) orderBomPriceService.callQueryOrderByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("price:orderBomPrice:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(OrderBomPriceVo vo) {
		orderBomPriceService.edit(vo);
    }
    
    /**
     * 
     * @param file
     * @return
     */
    @RequiresPermissions("price:orderBomPrice:edit")
    @RequestMapping(value = "import")
    @ResponseBody
	public void importFile(MultipartFile file,String drlx){
    	Map<String, String> params=new HashMap<String,String>();
    	params.put("drlx", drlx);
    	 excelImporter.importFile(OrderBomPriceVo.class, file, params);   
	}
    
    /**
     * 
     * @param file
     * @return
     */
    @RequiresPermissions("price:orderBomPrice:edit")
    @RequestMapping(value = "importJhd")
    @ResponseBody
	public void importFileJhd(MultipartFile file){
    	Map<String, String> params=new HashMap<String,String>();
    	 excelImporter.importFile(JhdPriceVo.class, file, params);   
	}
	
	@RequiresPermissions("price:orderBomPrice:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/price/orderBomPriceList";
	}
	
	@RequiresPermissions("price:orderBomPrice:view")
	@RequestMapping(value = {"jhdList"})
	public String jhdList() {
		return "sdo/price/jhdPriceList";
	}
	
	@RequiresPermissions("price:orderBomPrice:view")
	@RequestMapping(value = "form")
	public String form(OrderBomPriceVo vo, Model model) {
		OrderBomPriceVo record = orderBomPriceService.callQueryById(vo.getId());
		model.addAttribute("orderBomPrice", record == null ? new OrderBomPriceVo() : record);
		return "sdo/price/orderBomPriceForm";
	}
	
	/**
	 * 导出CKD物料明细含价格
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("price:orderBomPrice:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderBomPriceVo vo) {
		orderBomPriceService.export(response, params, vo);
	}
	
	/**
	 * 导出SKD出货明细
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("price:orderBomPrice:view")
    @RequestMapping(value = "exportSKD")
	public void exportSKD(HttpServletResponse response, @RequestParam Map<String, Object> params, OrderBomPriceVo vo) {
		orderBomPriceService.exportSKD(response, params, vo);
	}
	
	/**
	 * 导出SKD出货明细
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("price:orderBomPrice:view")
    @RequestMapping(value = "exportJhd")
	public void exportJhd(HttpServletResponse response, @RequestParam Map<String, Object> params, JhdPriceVo vo) {
		orderBomPriceService.exportJhd(response, params, vo);
	}


}