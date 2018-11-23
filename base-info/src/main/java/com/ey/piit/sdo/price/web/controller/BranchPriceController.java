package com.ey.piit.sdo.price.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.price.service.BranchPriceService;
import com.ey.piit.sdo.price.vo.BranchPriceVo;

/**
 * 分公司产品价格Controller
 * @author 邓海
 */
@Controller
@RequestMapping(value = "price/branchPrice")
public class BranchPriceController extends BaseController {

	@Autowired
	private BranchPriceService branchPriceService;
	
	@Autowired
    private ExcelImporter excelImporter;
	
	@SuppressWarnings("unchecked")
	@RequiresPermissions("price:branchPrice:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(BranchPriceVo vo, PageJqGrid page) {
		List<BranchPriceVo> list =(List<BranchPriceVo>) branchPriceService.callQueryByPage(vo, page);
        return list;
    }
    
	@RequiresPermissions("price:branchPrice:view")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return branchPriceService.callQueryById(id);
    }
	
    @RequiresPermissions("price:branchPrice:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(BranchPriceVo vo) {
		branchPriceService.edit(vo);
    }
    
    /**
     * 
     * @param file
     * @return
     */
    @RequiresPermissions("price:branchPrice:edit")
    @RequestMapping(value = "import")
    @ResponseBody
	public void importFile(MultipartFile file){
    	excelImporter.importFile(BranchPriceVo.class, file, null);   
	}
	
	@RequiresPermissions("price:branchPrice:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/price/branchPriceList";
	}
	
	@RequiresPermissions("price:branchPrice:view")
	@RequestMapping(value = "form")
	public String form(BranchPriceVo vo, Model model) {
		BranchPriceVo record = branchPriceService.callQueryById(vo.getId());
		model.addAttribute("branchPrice", record == null ? new BranchPriceVo() : record);
		return "sdo/price/branchPriceForm";
	}
	
	@RequiresPermissions("price:branchPrice:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, BranchPriceVo vo) {
		branchPriceService.export(response, params, vo);
	}

	@RequestMapping(value = "/getPrice", method = RequestMethod.POST)
    @ResponseBody
	public Object getPrice(String mxlx,String gjmytk,String khbm,String zhfs,String pid,String ks,String jixin,String jixing,String pizdsj){
    	return branchPriceService.getPrice(mxlx,gjmytk,khbm,zhfs,pid,ks,jixin,jixing,pizdsj);
    }
	
	@RequiresPermissions("price:branchPrice:view")
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
	@Token (create = true)
    public String editPage(){
    	return "sdo/price/branchPriceEdit";
    }

	@RequiresPermissions("price:branchPrice:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public void submit(BranchPriceVo vo) {
		branchPriceService.submit(vo);
    }
}