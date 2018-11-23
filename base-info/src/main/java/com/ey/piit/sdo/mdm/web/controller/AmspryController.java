package com.ey.piit.sdo.mdm.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.mdm.service.AmspryService;
import com.ey.piit.sdo.mdm.vo.AmspryVo;

/**
 * 澳门审批人员维护Controller
 * @author 赵明
 */
@Controller
@RequestMapping(value = "mdm/amspry")
public class AmspryController extends BaseController {

	@Autowired
	private AmspryService amspryService;
	
	@RequiresPermissions("mdm:amspry:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(AmspryVo vo, PageJqGrid page) {
        List<AmspryVo> list = amspryService.queryByPage(vo, page);
        return list;
    }
    @RequiresPermissions("mdm:amspry:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(AmspryVo vo) {
		amspryService.edit(vo);
    }
	@RequiresPermissions("mdm:amspry:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/amspryList";
	}
}