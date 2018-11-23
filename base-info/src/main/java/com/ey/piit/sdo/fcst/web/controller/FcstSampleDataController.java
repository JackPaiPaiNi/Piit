package com.ey.piit.sdo.fcst.web.controller;

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

import com.ey.piit.core.entity.User;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.fcst.service.FcstSampleDataService;
import com.ey.piit.sdo.fcst.vo.FcstSampleDataVo;

/**
 * 采购FCST样机填报Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "fcst/fcstSampleData")
public class FcstSampleDataController extends BaseController {

	@Autowired
	private FcstSampleDataService fcstSampleDataService;
	
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstSampleData:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(FcstSampleDataVo vo, PageJqGrid page) {
        List<FcstSampleDataVo> list = (List<FcstSampleDataVo>) fcstSampleDataService.callQueryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("fcst:fcstSampleData:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(FcstSampleDataVo vo) {
		fcstSampleDataService.edit(vo);
    }
    
    @RequiresPermissions("fcst:fcstSampleData:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(FcstSampleDataVo vo) {
    	fcstSampleDataService.delete(vo);
    }
	
	@RequiresPermissions("fcst:fcstSampleData:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/fcst/fcstSampleDataList";
	}
	
	/**
	 * 样机填报页面
	 * @param model
	 * @return
	 */
	@RequiresPermissions("fcst:fcstSampleData:view")
	@RequestMapping(value = "editPage")
	public String editPage(Model model) {
		User user = UserUtils.getUser();
		Map<String, Object> map= fcstSampleDataService.callQueryWeek();
		model.addAttribute("zc",map.get("zc").toString());
		model.addAttribute("zcrq",map.get("zcrq").toString());
		model.addAttribute("xsyid",user.getLoginAcct());
		return "sdo/fcst/fcstSampleDataEdit";
	}
	
	/**
	 * 样机评审页面
	 * @param model
	 * @return
	 */
	@RequiresPermissions("fcst:fcstSampleData:view")
	@RequestMapping(value = "approvePage")
	public String approvePage(Model model) {
		return "sdo/fcst/fcstSampleDataApprove";
	}
	
	@RequiresPermissions("fcst:fcstSampleData:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, FcstSampleDataVo vo) {
		fcstSampleDataService.export(response, params, vo);
	}

}