package com.ey.piit.core.security.realm;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.service.PasswordHelper;
import com.ey.piit.core.service.ResourceService;
import com.ey.piit.core.service.RoleService;
import com.ey.piit.core.service.UserService;
import com.ey.piit.core.service.WsAdService;
import com.ey.piit.core.vo.RoleVo;

/**
 * <p>User: wuyingjie
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private ResourceService resourceService;
    
    @Autowired
    private WsAdService wsAdService;
    
    @Autowired
    private PasswordHelper passwordHelper;
    
    @Value("${ad.onoff}")
	private String onoff;//AD域开关
    
    @Value("${debug.onoff}")
   	private String debug;//调试模式开关
    
    private static final String OR_OPERATOR = "|";
    private static final String OR_OPERATOR_SPLIT = "\\|";

    /**
     * 权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        User user = userService.findByLoginAcct(username);
        List<RoleVo> roleList = roleService.queryByUserId(user.getId());
        
        int size = roleList.size();
        Set<String> roleCodeSet = new HashSet<String>(size);
        List<String> roleIdList = new ArrayList<String>(size);
        for (int i = 0; i < size; i++) {
        	RoleVo role = roleList.get(i);
        	roleCodeSet.add(role.getCode());
        	roleIdList.add(role.getId());
		}
        
        Set<String> permissionSet = resourceService.queryPermissionByRoleIds(roleIdList);
        
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleCodeSet);
        authorizationInfo.setStringPermissions(permissionSet);
        return authorizationInfo;
    }

    /**
     * 登陆认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
    	User user = userService.findByLoginAcct(username);
    
        if(user == null) {
            throw new UnknownAccountException();//错误的帐号
        }

        if(Constants.STATUS_DISABLED.equals(user.getStatus())) {
            throw new DisabledAccountException();//禁用的帐号
        }
        
        SimpleAuthenticationInfo authenticationInfo = null;
        
      /*  if("on".equals(onoff)){
        	  //验证AD域账号和密码 不验证数据库
        
            if(user.getSfxgmm() == 1){
            	//用户已经重置过密码 ，需要域验证
	            	String password = String.valueOf((char[])token.getCredentials()).trim();
	                user.setPassword(password);
	                passwordHelper.encryptPassword(user);
            
            	   if(validateAccount(username,password)){
            		
                   	//AD域验证密码通过 	   
                   	authenticationInfo = new SimpleAuthenticationInfo(
                       		username, //用户名
                       		user.getPassword(), //密码
                       		getName()  //realm name
                       );
                   }else{
                	   //密码不通过
                   	authenticationInfo = new SimpleAuthenticationInfo(
                       		username, //用户名
                       		"", //密码
                       		getName()  //realm name
                       );
                   }
            }else{
            	//第一次登陆，未修改初始化密码
            	authenticationInfo = new SimpleAuthenticationInfo(
                		username, //用户名
                		user.getPassword(), //密码
                		getName()  //realm name
                );
            }
         
        }else if("off".equals(onoff)){
        	//数据库密码验证
        	authenticationInfo = new SimpleAuthenticationInfo(
            		username, //用户名
            		user.getPassword(), //密码
            		getName()  //realm name
            );
        }*/
      //数据库密码验证
        if("on".equals(debug)){
        	//调试模式
        	//用户已经重置过密码 ，需要域验证
        	String password = String.valueOf((char[])token.getCredentials()).trim();
            user.setPassword(password);
            passwordHelper.encryptPassword(user);
        	authenticationInfo = new SimpleAuthenticationInfo(
               		username, //用户名
               		user.getPassword(), //密码
               		getName()  //realm name
               );	
        }else if("off".equals(debug)){
        	//正式模式
        	authenticationInfo = new SimpleAuthenticationInfo(
            		username, //用户名
            		user.getPassword(), //密码
            		getName()  //realm name
            );
        }	
        return authenticationInfo;
    }
    
    /**
     * 验证域账号和密码
     * @param frem
     * @param password
     * @return
     */
    public boolean validateAccount(String frem,String password){
    	//return true;
    	try {
    			return wsAdService.validateAccount(frem, password);
    		} catch (RemoteException e) {
    			e.printStackTrace();
    		}
       	return false;
       }

    @Override
	public boolean isPermitted(PrincipalCollection principals, String permission) {
		if (permission.contains(OR_OPERATOR)) {
			String[] permissions = permission.split(OR_OPERATOR_SPLIT);
			for (String orPermission : permissions) {
				if (super.isPermitted(principals, orPermission)) {
					return true;
				}
			}
			return false;
		} else {
			return super.isPermitted(principals, permission);
		}
	}
    
	@Override
	protected boolean hasRole(String roleIdentifier, AuthorizationInfo info) {
		if (roleIdentifier.contains(OR_OPERATOR)) {
			String[] roles = roleIdentifier.split(OR_OPERATOR_SPLIT);
			for (String role : roles) {
				if (super.hasRole(role, info)) {
					return true;
				}
			}
			return false;
		} else {
			return super.hasRole(roleIdentifier, info);
		}
	}

	@Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
