/*
 * ResourceController.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.web.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.entity.TreeNode;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.service.ResourceService;
import com.ey.piit.core.vo.ResourceVo;
import com.ey.piit.core.web.controller.base.BaseController;

/**
 * T_RESOURCE
 * 资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
@Controller
@RequestMapping("/core/resource")
public class ResourceController extends BaseController {

    @Autowired
    private ResourceService resourceService;

    @RequiresPermissions("resource:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() {
        return "core/resource/list";
    }

    @RequiresPermissions("resource:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, Object> params, PageJqGrid page) {
        List<ResourceVo> list = resourceService.queryByPage(params, page);
        return list;
    }

    @RequiresPermissions("resource:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(ResourceVo record) {
        resourceService.edit(record);
    }
    
    @RequiresPermissions("resource:search")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object find(String id) {
    	ResourceVo record = resourceService.findById(id);
    	return record;
    }
    
    @RequiresPermissions("resource:search")
    @RequestMapping(value = "/loadTree", method = RequestMethod.POST)
    @ResponseBody
    public Object loadTree() {
    	List<TreeNode> list = resourceService.queryTree();
    	return list;
    }
    
}