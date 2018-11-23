/*
 * ResModuleController.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-18 Created
 */
package com.ey.piit.basesys.resource.web.controller;

import com.ey.piit.basesys.resource.service.ResModuleService;
import com.ey.piit.basesys.resource.vo.ResModuleVo;
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
 * T_RES_MODULE
 * 模块类型
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-18
 */
@Controller
@RequestMapping("/base/resModule")
public class ResModuleController extends BaseController {

    @Autowired
    private ResModuleService resModuleService;

    @RequiresPermissions("resModule:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() {
        return "base/resModule/list";
    }

    @RequiresPermissions("resModule:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, Object> params, PageJqGrid page) {
        List<ResModuleVo> list = resModuleService.queryByPage(params, page);
        return list;
    }

    @RequiresPermissions("resModule:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(ResModuleVo record) {
        resModuleService.edit(record);
    }

    @RequiresPermissions("resModule:search")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object find(String id) {
        ResModuleVo record = resModuleService.findById(id);
        return record;
    }
}