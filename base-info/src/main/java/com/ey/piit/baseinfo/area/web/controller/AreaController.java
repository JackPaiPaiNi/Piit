/*
 * AreaController.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-02 Created
 */
package com.ey.piit.baseinfo.area.web.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.baseinfo.area.service.AreaService;
import com.ey.piit.baseinfo.area.vo.AreaVo;
import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.entity.TreeNode;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;

/**
 * T_AREA
 * 一级对应国家
二级对应省
三级对应市

 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-02
 */
@Controller
@RequestMapping("/base/area")
public class AreaController extends BaseController {

    @Autowired
    private AreaService areaService;
    
    @Autowired
    private ExcelImporter excelImporter;

    @RequiresPermissions("area:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() {
        return "base/area/list";
    }

    @RequiresPermissions("area:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, Object> params, PageJqGrid page) {
        List<AreaVo> list = areaService.queryByPage(params, page);
        return list;
    }

    @RequiresPermissions("area:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Object edit(AreaVo record) {
        areaService.edit(record);
        return record;
    }

    @RequiresPermissions("area:search")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object find(String id) {
        AreaVo record = areaService.findById(id);
        return record;
    }
    
    @RequiresPermissions("area:search")
    @RequestMapping(value = "/loadTree", method = RequestMethod.POST)
    @ResponseBody
    public Object loadTree(String code,String name,String parentCode,String status) {
    	List<TreeNode> list = areaService.queryTree(code,name,parentCode,status);
    	return list;
    }
    
    @RequestMapping(value = "/loadAreaOption", method = RequestMethod.POST)
    @ResponseBody
    public String loadAreaOption(String parentCode,String code) {
        return areaService.loadAreaOption(parentCode,code);
    }
    
    @RequiresPermissions("import:edit")
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    @ResponseBody
    public Object importFile(@RequestParam MultipartFile file){
    	String importId = excelImporter.importFile(AreaVo.class, file, null);
    	return importId;
    }
    
    @RequiresPermissions("import:edit")
    @RequestMapping(value = "/importPreview", method = RequestMethod.POST)
    @ResponseBody
    public Object importFilePreview(@RequestParam MultipartFile file){
    	String importId = excelImporter.importFilePreview(AreaVo.class, file, null);
    	return importId;
    }
}