/*
 * RoleProcessController.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-18 Created
 */
package com.ey.piit.basesys.resource.web.controller;

import com.ey.piit.basesys.resource.service.RoleProcessService;
import com.ey.piit.basesys.resource.vo.RoleProcessVo;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * T_ROLE_PROCESS
 * 角色_流程节点
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-18
 */
@Controller
@RequestMapping("/base/roleProcess")
public class RoleProcessController extends BaseController {

    @Autowired
    private RoleProcessService roleProcessService;

    @RequiresPermissions("roleProcess:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() {
        return "base/roleProcess/list";
    }

    @RequiresPermissions("roleProcess:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, Object> params, PageJqGrid page) {
        List<RoleProcessVo> list = roleProcessService.queryByPage(params, page);
        return list;
    }

    @RequiresPermissions("roleProcess:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(RoleProcessVo record) {
        roleProcessService.edit(record);
    }

    @RequiresPermissions("roleProcess:search")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object find(String id) {
        RoleProcessVo record = roleProcessService.findById(id);
        return record;
    }
}