package com.ey.piit.core.utils;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.Emp;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.vo.OrganizationVo;
import com.ey.piit.core.vo.RoleVo;

/**
 * 用户工具类
 */
public class UserUtils {

	/**
	 * 获取当前用户
	 */
	public static User getUser(){
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		User curUser = (User)session.getAttribute(Constants.CURRENT_USER);
		return curUser;
	}
	
	/**
	 * 获取当前角色
	 */
	public static List<RoleVo> getRole(){
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		@SuppressWarnings("unchecked")
		List<RoleVo> roleList = (List<RoleVo>)session.getAttribute(Constants.CURRENT_ROLES);
		return roleList;
	}
	
	/**
	 * 获取当前组织
	 */
	public static List<OrganizationVo> getOrg(){
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		@SuppressWarnings("unchecked")
		List<OrganizationVo> orgList = (List<OrganizationVo>)session.getAttribute(Constants.CURRENT_ORGS);
		return orgList;
	}
	
	/**
	 * 获取当前员工
	 */
	public static Emp getEmp(){
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		Emp curEmp = (Emp)session.getAttribute(Constants.CURRENT_EMP);
		return curEmp;
	}
	
	/**
	 * 是否有角色
	 */
	public static boolean hasRole(String roleCode){
		if (StringUtils.isBlank(roleCode)) {
			return false;
		}
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		@SuppressWarnings("unchecked")
		List<RoleVo> roleList = (List<RoleVo>)session.getAttribute(Constants.CURRENT_ROLES);
		
		for (int i = 0; i < roleList.size(); i++) {
			if (roleCode.equals(roleList.get(i).getCode())) {
				return true;
			}
		}
		return false;
	}

	
	/**
	 * 可控部门列表，逗号隔开
	 */
	public static String getOrgCodes(){
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		String orgCodes = (String)session.getAttribute(Constants.CURRENT_ORG_CODES);
//		String orgCodes = "010101,010102,010103,010104,010105,010106,010107,010108,0101,0102,0103,0104,0105,"
//				+ "0106,0107,0108,010201,010208,010209,010211,010212,010206,010204,010207,010210,010205,0131,"
//				+ "010301,010302,0132,010401,010402,010501,010502,010503,010504,010505,010506,010601,010602,"
//				+ "010603,010604,010605,010701,010702,010703,010704,010801,0201,0202,0203,0301,0302,0303,0304,"
//				+ "0305,0306,0401,0402,0403,0404";
		return orgCodes;
	}
	
	/**
	 * 是否销售员
	 */
	public static int isXys(){
		if (hasRole("1-yx-xsy")) {
			return 1;
		}
		return 0;
	}
	
}
