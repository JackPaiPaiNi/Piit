/*
 * DemoController.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-09-21 Created
 */
package com.ey.piit.basedemo.web.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.basedemo.entity.Demo;
import com.ey.piit.basedemo.service.DemoService;
import com.ey.piit.basedemo.vo.DemoVo;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;

/**
 * @RequestMapping(value = "/search", method = RequestMethod.POST) //请求地址：search 请求方式：post
 * @ResponseBody
 * public ObjectNode search(
 * 	DemoVo demo, //使用对象直接映射请求参数
 * 	@RequestParam Map<String,Object> param, //请求参数全部封装到map
 * 	PageJqGrid page, //分页信息
 * 	Model model, //model.addAttribute()
 * 	HttpServletRequest request, 
 * 	HttpServletResponse response)
 * 
 * @author Kevin Xu
 * @version 1.0 2015-09-21
 */
@Controller
@RequestMapping("/base/demo")
public class DemoController extends BaseController{

	@Autowired
	private DemoService demoService;
	
	@RequiresPermissions("demo:search")
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "base/demo/list";
	}
	
	@RequiresPermissions("demosimple:search")
	@RequestMapping(value = "/listSimple", method = RequestMethod.GET)
	public String listSimple() {
		return "base/demo/list_simple";
	}
	
	@RequiresPermissions("demo:search")
	@RequestMapping(value = "/editPage", method = RequestMethod.GET)
	public String editPage() {
		return "base/demo/edit";
	}
	
	@RequiresPermissions("demo:search")
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Object search(@RequestParam Map<String,Object> params,PageJqGrid page) {
        List<DemoVo> list = demoService.queryByPage(params, page);
		return list;
	}
	
	@RequiresPermissions("demo:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public void edit(Demo record) {
		demoService.edit(record);
	}
	
}
