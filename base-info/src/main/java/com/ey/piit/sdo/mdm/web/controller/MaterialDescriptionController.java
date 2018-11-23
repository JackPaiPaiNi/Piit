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
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.mdm.service.MaterialDescriptionService;
import com.ey.piit.sdo.mdm.vo.MaterialDescriptionVo;

/**
 * 物料其他语言描述Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "mdm/materialDescription")
public class MaterialDescriptionController extends BaseController {

	@Autowired
	private MaterialDescriptionService materialDescriptionService;
	
	@Autowired
    private ExcelImporter excelImporter;
	
	@RequiresPermissions("mdm:materialDescription:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(MaterialDescriptionVo vo, PageJqGrid page) {
        List<MaterialDescriptionVo> list = materialDescriptionService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:materialDescription:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(MaterialDescriptionVo vo) {
		materialDescriptionService.edit(vo);
    }
	
	@RequiresPermissions("mdm:materialDescription:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/materialDescriptionList";
	}
	
	@RequiresPermissions("mdm:materialDescription:view")
	@RequestMapping(value = "form")
	public String form(MaterialDescriptionVo vo, Model model) {
		MaterialDescriptionVo record = materialDescriptionService.findById(vo.getId());
		model.addAttribute("materialDescription", record == null ? new MaterialDescriptionVo() : record);
		return "sdo/mdm/materialDescriptionForm";
	}
	
    @RequiresPermissions("mdm:materialDescription:edit")
    @RequestMapping(value = "import")
    @ResponseBody
	public Object importFile(MultipartFile file){
    	return excelImporter.importFile(MaterialDescriptionVo.class, file, null);   
	}
	
	@RequiresPermissions("mdm:materialDescription:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, MaterialDescriptionVo vo) {
		materialDescriptionService.export(response, params, vo);
	}

}