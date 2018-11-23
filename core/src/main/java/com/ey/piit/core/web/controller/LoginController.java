package com.ey.piit.core.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>User: wuyingjie
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public String showLoginForm(HttpServletRequest req, Model model) {
		String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
		if (exceptionClassName != null) {
			String error = null;
			if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
				error = "用户名错误";
			} else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				error = "用户名/密码错误";
			} else if (DisabledAccountException.class.getName().equals(exceptionClassName)) {
				error = "账号被禁用";
			} else {
				error = "其他错误：" + exceptionClassName;
			}
			model.addAttribute("error", error);
		}
		return "login";
	}

}
