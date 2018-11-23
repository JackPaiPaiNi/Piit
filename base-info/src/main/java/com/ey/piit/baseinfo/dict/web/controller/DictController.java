/*
 * DictController.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-12 Created
 */
package com.ey.piit.baseinfo.dict.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.baseinfo.dict.service.DictService;
import com.ey.piit.baseinfo.dict.vo.DictVo;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;

/**
 * T_DICT
 * 包括:币种、税种、公司类型
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-12
 */
@Controller
@RequestMapping("/base/dict")
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    @RequiresPermissions("dict:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() {
        return "base/dict/list";
    }

    @RequiresPermissions("dict:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, Object> params, PageJqGrid page) {
        List<DictVo> list = dictService.queryByPage(params, page);
        return list;
    }

    @RequiresPermissions("dict:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(DictVo record) {
        dictService.edit(record);
    }

    @RequiresPermissions("dict:search")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object find(String id) {
        DictVo record = dictService.findById(id);
        return record;
    }
    
    @RequestMapping(value = "/loadDictOption", method = RequestMethod.POST)
    @ResponseBody
    public String loadDictOption(String type,String code,String showType) {
        return dictService.loadDictOption(type,code,showType);
    }
    
    @RequestMapping(value = "/loadDictTree", method = RequestMethod.POST)
    @ResponseBody
    public Object loadDictTree(String type,String showType) {
    	return dictService.loadDictTree(type,showType);
    }
    @RequestMapping(value = "/loadDictLazyTree", method = RequestMethod.POST)
    @ResponseBody
    public Object loadDictLazyTree(String type,String parentCode,String showType) {
    	return dictService.loadDictLazyTree(type,parentCode,showType);
    }
    
    @RequiresPermissions("dict:search")
    @RequestMapping(value = "/export")
	public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) {
    	dictService.export(response, params);
	}
}