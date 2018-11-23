package com.ey.piit.core.security.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.service.OrganizationService;
import com.ey.piit.core.service.ResourceService;
import com.ey.piit.core.service.RoleService;
import com.ey.piit.core.service.UserService;
import com.ey.piit.core.utils.AjaxUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.vo.EmpVo;
import com.ey.piit.core.vo.OrganizationVo;
import com.ey.piit.core.vo.ResourceVo;
import com.ey.piit.core.vo.RoleVo;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 登陆拦截
 * 
 * @author Kevin-Y.Xu
 *
 */
public class FormAuthcFilter extends FormAuthenticationFilter {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private OrganizationService organizationService;

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		//菜单信息放入session
		Session session = subject.getSession();
		String username = (String)subject.getPrincipal();
		User user = userService.findByLoginAcct(username);
		session.setAttribute(Constants.CURRENT_USER, user);
		
		EmpVo emp = new EmpVo();
		if (StringUtils.isNotBlank(user.getEmpCode())) {
			emp = userService.findEmployeeByEmpCode(user.getEmpCode());
		}
		session.setAttribute(Constants.CURRENT_EMP, emp);
		
		List<ResourceVo> menus = resourceService.queryMenuByUserId(user.getId());
		List<ResourceVo> buildMenus = buildMenus(menus);
		session.setAttribute(Constants.CURRENT_MENUS, buildMenus);
		
		List<RoleVo> roles = roleService.queryByUserId(user.getId());
		session.setAttribute(Constants.CURRENT_ROLES, roles);
		
//		List<OrganizationVo> orgs = organizationService.queryByUserId(user.getId());
		List<OrganizationVo> orgs = buildOrg(roles);
		if(orgs.size() == 0){
			orgs = organizationService.queryByCode(user.getCompCode());
		}
		session.setAttribute(Constants.CURRENT_ORGS, orgs);
		
		session.setAttribute(Constants.CURRENT_ORG_CODES, buildOrgCode(orgs));
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String url = getSuccessUrl();
		if(user.getSfxgmm()!=1){
			url="/core/pswd/page";
		}
		httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + url);	//页面跳转
		return false;
	}
	
	private List<ResourceVo> buildMenus(List<ResourceVo> menus){
		Map<String, List<ResourceVo>> map = new HashMap<String, List<ResourceVo>>((int)(menus.size()/0.75f));
		List<ResourceVo> rtnList = new ArrayList<ResourceVo>(menus.size());
		List<ResourceVo> list = new ArrayList<ResourceVo>(menus.size());
		for (int i = 0; i < menus.size(); i++) {
			ResourceVo record = menus.get(i);
			if (StringUtils.isNotBlank(record.getParentId())) {
				List<ResourceVo> tList = map.get(record.getParentId());
				if (tList == null) {
					tList = new ArrayList<ResourceVo>(menus.size());
					map.put(record.getParentId(), tList);
				}
				tList.add(record);
				list.add(record);
			} else {
				list.add(record);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			ResourceVo record = list.get(i);
			List<ResourceVo> tList = map.get(record.getId());
			if (StringUtils.isBlank(record.getParentId())) {
				rtnList.add(record);
			}
			record.setChildren(tList);
		}
		
		return rtnList;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (isLoginRequest(request, response)) {
			if (isLoginSubmission(request, response)) {
				return executeLogin(request, response);
			} else if (AjaxUtils.isAjaxRequest(WebUtils.toHttp(request))) {
				HttpServletResponse res = WebUtils.toHttp(response);
				res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
			return true;
		}
		saveRequestAndRedirectToLogin(request, response);
		return false;
	}
	
	private List<OrganizationVo> buildOrg(List<RoleVo> roles) {
		Set<String> orgParentSet = Sets.newHashSet();
		List<OrganizationVo> rtnList = Lists.newArrayList();
		for (int i = 0; i < roles.size(); i++) {
			RoleVo roleVo = roles.get(i);
			List<OrganizationVo> orgList = organizationService.queryByRoleId(roleVo.getId());
			for (int j = 0; j < orgList.size(); j++) {
				OrganizationVo parent = orgList.get(j);
				String parentCode = parent.getCode();
				if (orgParentSet.contains(parentCode)) {
					continue;
				}
				orgParentSet.add(parentCode);
				rtnList.add(parent);
			}
		}
		return rtnList;
	}
	
	private String buildOrgCode(List<OrganizationVo> parentList) {
		Set<String> orgChildSet = Sets.newHashSet();
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < parentList.size(); j++) {
			OrganizationVo parent = parentList.get(j);
			String parentCode = parent.getCode();
			List<OrganizationVo> childList = organizationService.queryChildByCode(parentCode);
			for (int k = 0; k < childList.size(); k++) {
				OrganizationVo child = childList.get(k);
				String childCode = child.getCode();
				if (orgChildSet.contains(childCode)) {
					continue;
				}
				orgChildSet.add(childCode);
				
				if (k != 0 || j > 0) {
					sb.append(",");
				}
				sb.append(childCode);
			}
		}
		return sb.toString();
	}

}