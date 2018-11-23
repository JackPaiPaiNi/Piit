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
import com.ey.piit.sdo.mdm.service.ShippmentDaysService;
import com.ey.piit.sdo.mdm.vo.ShippmentDaysVo;

/**
 * 走货日期定义Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "mdm/shippmentDays")
public class ShippmentDaysController extends BaseController {

	@Autowired
	private ShippmentDaysService shippmentDaysService;
	
	@RequiresPermissions("mdm:shippmentDays:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ShippmentDaysVo vo, PageJqGrid page) {
        List<ShippmentDaysVo> list = shippmentDaysService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:shippmentDays:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(ShippmentDaysVo vo) {
		shippmentDaysService.edit(vo);
    }
	
	@RequiresPermissions("mdm:shippmentDays:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/shippmentDaysList";
	}
	
	@RequiresPermissions("mdm:shippmentDays:view")
	@RequestMapping(value = "form")
	public String form(ShippmentDaysVo vo, Model model) {
		ShippmentDaysVo record = shippmentDaysService.findById(vo.getId());
		model.addAttribute("shippmentDays", record == null ? new ShippmentDaysVo() : record);
		return "sdo/mdm/shippmentDaysForm";
	}
	
	@RequiresPermissions("mdm:shippmentDays:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ShippmentDaysVo vo) {
		shippmentDaysService.export(response, params, vo);
	}

}