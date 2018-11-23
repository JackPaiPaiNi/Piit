/*
 * UserController.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-13 Created
 */
package com.ey.piit.core.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.service.UserService;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.vo.UserVo;
import com.ey.piit.core.web.controller.base.BaseController;

/**
 * 表：T_user
 * 用户密码重置
 * @author ZhaoTaojun
 * @version 1.0 2016-10-19
 */
@Controller
@RequestMapping("/core/pswd")
public class PswdResetController extends BaseController {

    @Autowired
    private UserService userService;
    
    @RequiresPermissions("core:pswd:view")
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public ModelAndView resetPage() {
    	ModelAndView view = new ModelAndView("core/user/changePassword");
    	view.addObject("user", userService.findByLoginAcct(UserUtils.getUser().getLoginAcct()));
    	return view ;
    }
    
   

    
    @RequiresPermissions("core:pswd:edit")
    @RequestMapping(value = "reset", method = RequestMethod.POST)
    @ResponseBody
    public void resetPswd(UserVo vo){
    	userService.resetPswd(vo);
    }
    
   
    
}