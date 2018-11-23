package com.ey.piit.core.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ey.piit.core.entity.User;
import com.ey.piit.core.web.bind.annotation.CurrentUser;

/**
 * <p>User: wuyingjie
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(@CurrentUser User loginUser, Model model) {
        return "index/layout";
    }

}
