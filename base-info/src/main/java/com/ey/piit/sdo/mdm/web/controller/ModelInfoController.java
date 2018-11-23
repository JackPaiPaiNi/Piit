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
import com.ey.piit.sdo.mdm.service.ModelInfoService;
import com.ey.piit.sdo.mdm.vo.ModelInfoVo;

/**
 * 机型机芯维护Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "mdm/modelInfo")
public class ModelInfoController extends BaseController {

	@Autowired
	private ModelInfoService modelInfoService;
	
	@RequiresPermissions("mdm:modelInfo:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ModelInfoVo vo, PageJqGrid page) {
        List<ModelInfoVo> list = modelInfoService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:modelInfo:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(ModelInfoVo vo) {
		modelInfoService.edit(vo);
    }
	
	@RequiresPermissions("mdm:modelInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/modelInfoList";
	}
	
	@RequiresPermissions("mdm:modelInfo:view")
	@RequestMapping(value = "form")
	public String form(ModelInfoVo vo, Model model) {
		ModelInfoVo record = modelInfoService.findById(vo.getId());
		model.addAttribute("modelInfo", record == null ? new ModelInfoVo() : record);
		return "sdo/mdm/modelInfoForm";
	}
	
	@RequiresPermissions("mdm:modelInfo:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ModelInfoVo vo) {
		modelInfoService.export(response, params, vo);
	}

}