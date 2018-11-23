package com.ey.piit.sdo.saprebate.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.saprebate.service.RebateService;
import com.ey.piit.sdo.saprebate.vo.TitleVo;

import net.sf.json.JSONArray;

/**
 * sap费用审批Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "rebate/rebate")
public class TitleController extends BaseController {

	@Autowired
	private RebateService rebateService;
	
	@RequiresPermissions("rebate:rebate:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(TitleVo vo, PageJqGrid page) {
        return rebateService.callQueryByPage(vo, page);
    }
	
	@RequiresPermissions("rebate:rebate:edit")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/saprebate/rebateList"; 
	}
	
	@RequiresPermissions("rebate:rebate:edit")
	@RequestMapping(value = "submit")
	@ResponseBody
	public void submit(TitleVo vo, @RequestParam(value = "list") String list) {
		JSONArray array = JSONArray.fromObject(list);
		@SuppressWarnings("unchecked")
		List<TitleVo> objList = (List<TitleVo>) JSONArray.toCollection(array,TitleVo.class);
		rebateService.callSubmitList(objList);
	}

}