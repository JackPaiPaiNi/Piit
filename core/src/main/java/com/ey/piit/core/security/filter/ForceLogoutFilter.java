package com.ey.piit.core.security.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.LogoutFilter;

/**
 * 登出拦截
 * 
 * @author Kevin-Y.Xu
 *
 */
public class ForceLogoutFilter extends LogoutFilter {

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		return super.preHandle(request, response);
	}

}
