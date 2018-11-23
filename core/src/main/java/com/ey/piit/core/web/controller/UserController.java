/*
 * UserController.java
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

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.service.RoleService;
import com.ey.piit.core.service.UserService;
import com.ey.piit.core.vo.RoleVo;
import com.ey.piit.core.vo.UserVo;
import com.ey.piit.core.web.controller.base.BaseController;

/**
 * T_USER
 * 用户
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-13
 */
@Controller
@RequestMapping("/core/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @RequiresPermissions("user:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() {
        return "core/user/list";
    }

    @RequiresPermissions("user:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, Object> params, PageJqGrid page) {
        List<UserVo> list = userService.queryByPage(params, page);
        return list;
    }

    @RequiresPermissions("user:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(UserVo record) {
        userService.edit(record);
    }
    
    @RequiresPermissions("user:search")
    @RequestMapping(value = "/editPage", method = RequestMethod.GET)
    public String editPage(){
    	return "core/user/edit";
    }
    
    @RequiresPermissions("user:search")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object find(String id){
    	UserVo record = userService.findById(id);
    	return record;
    }
    
    @RequiresPermissions("user:search")
    @RequestMapping(value = "/loadRoleOption", method = RequestMethod.POST)
    @ResponseBody
    public String loadRoleOption(String id){
		List<RoleVo> roleList = roleService.queryByUserId(id);
		List<RoleVo> roleAllList = roleService.queryAll();
		String str = roleService.roleListToHtml(roleAllList,roleList);
		return str;
    }
    
    @RequestMapping(value = "/changeRole", method = RequestMethod.POST)
    @ResponseBody
    public void changeRole(String roleCode){
    	userService.changeRole(roleCode);
    }
    
}