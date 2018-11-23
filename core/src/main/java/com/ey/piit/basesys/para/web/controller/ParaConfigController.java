/*
 * ParaConfigController.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-24 Created
 */
package com.ey.piit.basesys.para.web.controller;

import com.ey.piit.basesys.para.service.ParaConfigService;
import com.ey.piit.basesys.para.vo.ParaConfigVo;
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
 * T_PARA_CONFIG
 * MDM配置表
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-24
 */
@Controller
@RequestMapping("/base/paraConfig")
public class ParaConfigController extends BaseController {

    @Autowired
    private ParaConfigService paraConfigService;

    @RequiresPermissions("paraConfig:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() {
        return "base/paraConfig/list";
    }

    @RequiresPermissions("paraConfig:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, Object> params, PageJqGrid page) {
        List<ParaConfigVo> list = paraConfigService.queryByPage(params, page);
        return list;
    }

    @RequiresPermissions("paraConfig:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(ParaConfigVo record) {
        paraConfigService.edit(record);
    }

    @RequiresPermissions("paraConfig:search")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object find(String id) {
        ParaConfigVo record = paraConfigService.findById(id);
        return record;
    }
}