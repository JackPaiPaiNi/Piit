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
import com.ey.piit.sdo.mdm.service.MaterialInfoService;
import com.ey.piit.sdo.mdm.vo.MaterialInfoVo;

/**
 * 物料管理Controller
 * @author 田荣
 */
@Controller
@RequestMapping(value = "mdm/materialInfo")
public class MaterialInfoController extends BaseController {

	@Autowired
	private MaterialInfoService materialInfoService;
	
	@RequiresPermissions("mdm:materialInfo:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(MaterialInfoVo vo, PageJqGrid page) {
        List<MaterialInfoVo> list = materialInfoService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:materialInfo:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(MaterialInfoVo vo) {
		materialInfoService.edit(vo);
    }
	
	@RequiresPermissions("mdm:materialInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/materialInfoList";
	}
	
	@RequiresPermissions("mdm:materialInfo:view")
	@RequestMapping(value = "form")
	public String form(MaterialInfoVo vo, Model model) {
		MaterialInfoVo record = materialInfoService.findById(vo.getId());
		model.addAttribute("materialInfo", record == null ? new MaterialInfoVo() : record);
		return "sdo/mdm/materialInfoForm";
	}
	
	@RequiresPermissions("mdm:materialInfo:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, MaterialInfoVo vo) {
		materialInfoService.export(response, params, vo);
	}
	
	/**
	 * 同步物料信息
	 * @param vo
	 */
    @RequestMapping(value = "tbwlxx")
    @ResponseBody
    public void tbwlxx() {
		materialInfoService.tbwlxx();
    }
}