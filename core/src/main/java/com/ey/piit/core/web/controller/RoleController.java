/*
 * RoleController.java
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
import com.ey.piit.core.service.RoleService;
import com.ey.piit.core.vo.RoleVo;
import com.ey.piit.core.web.controller.base.BaseController;

/**
 * T_ROLE
 * 角色
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
@Controller
@RequestMapping("/core/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private ResourceService resourceService;

    @RequiresPermissions("role:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() {
        return "core/role/list";
    }

    @RequiresPermissions("role:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, Object> params, PageJqGrid page) {
        List<RoleVo> list = roleService.queryByPage(params, page);
        return list;
    }

    @RequiresPermissions("role:search")
    @RequestMapping(value = "/editPage", method = RequestMethod.GET)
    public String editPage(){
    	return "core/role/edit";
    }
    
    @RequiresPermissions("role:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(RoleVo record) {
        roleService.edit(record);
    }
    
    @RequiresPermissions("role:search")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object find(String id){
    	RoleVo record = roleService.findById(id);
    	return record;
    }
    
    @RequiresPermissions("role:search")
    @RequestMapping(value = "/loadResourceTree", method = RequestMethod.POST)
    @ResponseBody
    public Object loadResourceTree(String id) {
    	List<TreeNode> list = resourceService.queryTreeCheckedByRoleId(id);
    	return list;
    }
}