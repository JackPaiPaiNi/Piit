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
import com.ey.piit.sdo.price.service.SkdPriceService;
import com.ey.piit.sdo.price.vo.SkdPriceVo;

/**
 * SKD价格Controller
 * @author 邓海
 */
@Controller
@RequestMapping(value = "price/skdPrice")
public class SkdPriceController extends BaseController {

	@Autowired
	private SkdPriceService skdPriceService;
	
	@Autowired
    private ExcelImporter excelImporter;
	
	@SuppressWarnings("unchecked")
	@RequiresPermissions("price:skdPrice:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(SkdPriceVo vo, PageJqGrid page) {
		List<SkdPriceVo> list =(List<SkdPriceVo>) skdPriceService.callQueryByPage(vo, page);
        return list;
    }
    
	@RequiresPermissions("price:skdPrice:view")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return skdPriceService.callQueryById(id);
    }
	
    @RequiresPermissions("price:skdPrice:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(SkdPriceVo vo) {
		skdPriceService.edit(vo);
    }
    
    /**
     * 
     * @param file
     * @return
     */
    @RequiresPermissions("price:skdPrice:edit")
    @RequestMapping(value = "import")
    @ResponseBody
	public void importFile(MultipartFile file){
    	excelImporter.importFile(SkdPriceVo.class, file, null);   
	}
	
	@RequiresPermissions("price:skdPrice:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/price/skdPriceList";
	}
	
	@RequiresPermissions("price:skdPrice:view")
	@RequestMapping(value = "form")
	public String form(SkdPriceVo vo, Model model) {
		SkdPriceVo record = skdPriceService.callQueryById(vo.getId());
		model.addAttribute("skdPrice", record == null ? new SkdPriceVo() : record);
		return "sdo/price/skdPriceForm";
	}
	
	@RequiresPermissions("price:skdPrice:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, SkdPriceVo vo) {
		skdPriceService.export(response, params, vo);
	}

	
	@RequiresPermissions("price:skdPrice:view")
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
	@Token (create = true)
    public String editPage(){
    	return "sdo/price/skdPriceEdit";
    }

	@RequiresPermissions("price:skdPrice:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public void submit(SkdPriceVo vo) {
		skdPriceService.submit(vo);
    }
}