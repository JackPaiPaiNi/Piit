/*
 * ResInfoController.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-18 Created
 */
package com.ey.piit.basesys.resource.web.controller;

import com.ey.piit.basesys.resource.service.ResInfoService;
import com.ey.piit.basesys.resource.vo.ResInfoVo;
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
 * T_RES_INFO
 * 流程资源
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-18
 */
@Controller
@RequestMapping("/base/resInfo")
public class ResInfoController extends BaseController {

    @Autowired
    private ResInfoService resInfoService;

    @RequiresPermissions("resInfo:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() {
        return "base/resInfo/list";
    }

    @RequiresPermissions("resInfo:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, Object> params, PageJqGrid page) {
        List<ResInfoVo> list = resInfoService.queryByPage(params, page);
        return list;
    }

    @RequiresPermissions("resInfo:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(ResInfoVo record) {
        resInfoService.edit(record);
    }

    @RequiresPermissions("resInfo:search")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object find(String id) {
        ResInfoVo record = resInfoService.findById(id);
        return record;
    }
}