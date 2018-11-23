/*
 * ResCtrlController.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-18 Created
 */
package com.ey.piit.basesys.resource.web.controller;

import com.ey.piit.basesys.resource.service.ResCtrlService;
import com.ey.piit.basesys.resource.vo.ResCtrlVo;
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
 * T_RES_CTRL
 * 功能控制_资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-18
 */
@Controller
@RequestMapping("/base/resCtrl")
public class ResCtrlController extends BaseController {

    @Autowired
    private ResCtrlService resCtrlService;

    @RequiresPermissions("resCtrl:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() {
        return "base/resCtrl/list";
    }

    @RequiresPermissions("resCtrl:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, Object> params, PageJqGrid page) {
        List<ResCtrlVo> list = resCtrlService.queryByPage(params, page);
        return list;
    }

    @RequiresPermissions("resCtrl:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(ResCtrlVo record) {
        resCtrlService.edit(record);
    }

    @RequiresPermissions("resCtrl:search")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object find(String id) {
        ResCtrlVo record = resCtrlService.findById(id);
        return record;
    }
}