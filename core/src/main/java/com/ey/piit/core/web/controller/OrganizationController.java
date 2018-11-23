/*
 * OrganizationController.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-23 Created
 */
package com.ey.piit.core.web.controller;

import java.util.Date;
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
import com.ey.piit.core.service.OrganizationService;
import com.ey.piit.core.vo.OrganizationVo;
import com.ey.piit.core.web.controller.base.BaseController;

/**
 * T_ORGANIZATION
 * 组织
 * 
 * @author Kevin Xu
 * @version 1.0 2015-10-23
 */
@Controller
@RequestMapping("/core/organization")
public class OrganizationController extends BaseController {

    @Autowired
    private OrganizationService organizationService;

    @RequiresPermissions("organization:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() {
        return "core/organization/organization";
    }

    @RequiresPermissions("organization:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, Object> params, PageJqGrid page) {
        List<OrganizationVo> list = organizationService.queryByPage(params, page);
        return list;
    }

    @RequiresPermissions("organization:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(OrganizationVo record) {
        organizationService.edit(record);
    }
    
    @RequiresPermissions("organization:search")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object find(String id) {
    	OrganizationVo record = organizationService.findById(id);
        return record;
    }
    
    @RequestMapping(value = "/loadOptionByUser", method = RequestMethod.POST)
    @ResponseBody
    public String loadOptionByUser(){
    	List<OrganizationVo> list = organizationService.queryChildByUser();
    	String str = organizationService.organizationListToHtml(list);
    	return str;
    }
    
    /**
     * 模糊查询
     */
    @RequestMapping(value = "/loadTree", method = RequestMethod.POST)
    @ResponseBody
    public Object loadTree(String sys,String code,String name,String parentCode) {
    	List<TreeNode> list = organizationService.queryTree(sys,code,name,parentCode);
    	return list;
    }
    
    @RequiresPermissions("organization:search")
    @RequestMapping(value = "/historyTree", method = RequestMethod.GET)
    public String historyTree(){
    	return "core/organization/historyTree";
    }
    
    /**
     * 模糊查询
     */
    @RequiresPermissions("organization:search")
    @RequestMapping(value = "/loadHistoryTree", method = RequestMethod.POST)
    @ResponseBody
    public Object loadHistoryTree(String sys,String code,String name,String parentCode,Date date) {
    	List<TreeNode> list = organizationService.queryHistoryTreeBySys(sys,code,name,parentCode,date);
    	return list;
    }
    
}