package com.ey.piit.sdo.mdm.web.controller;

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

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.mdm.service.CountryTimeareaService;
import com.ey.piit.sdo.mdm.vo.CountryTimeareaVo;

/**
 * 国家时区关系管理Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "mdm/countryTimearea")
public class CountryTimeareaController extends BaseController {

	@Autowired
	private CountryTimeareaService countryTimeareaService;
	
	@RequiresPermissions("mdm:countryTimearea:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(CountryTimeareaVo vo, PageJqGrid page) {
        List<CountryTimeareaVo> list = countryTimeareaService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:countryTimearea:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(CountryTimeareaVo vo) {
		countryTimeareaService.edit(vo);
    }
	
	@RequiresPermissions("mdm:countryTimearea:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/countryTimeareaList";
	}
	
	@RequiresPermissions("mdm:countryTimearea:view")
	@RequestMapping(value = "form")
	public String form(CountryTimeareaVo vo, Model model) {
		CountryTimeareaVo record = countryTimeareaService.findById(vo.getId());
		model.addAttribute("countryTimearea", record == null ? new CountryTimeareaVo() : record);
		return "sdo/mdm/countryTimeareaForm";
	}
	
	@RequiresPermissions("mdm:countryTimearea:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, CountryTimeareaVo vo) {
		countryTimeareaService.export(response, params, vo);
	}

}