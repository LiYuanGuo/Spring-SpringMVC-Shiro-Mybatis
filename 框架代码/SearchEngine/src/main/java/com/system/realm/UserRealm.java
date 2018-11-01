package com.system.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.bean.sys.SysPermission;
import com.system.bean.sys.SysRole;
import com.system.bean.sys.SysUser;
import com.system.service.sys.SysUserService;

/**
 * 
 * @title UserRealm.java
 * @author liyuanguo
 * @time 2018年8月2日 下午5:14:27
 * @description 用户授权信息域
 * @version V1.0
 */
@Component
public class UserRealm extends AuthorizingRealm {
	
	@Autowired
    private SysUserService sysUserService;


	protected final Map<String, SimpleAuthorizationInfo> roles = new ConcurrentHashMap<String, SimpleAuthorizationInfo>();
	
	/**
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
     *     当调用权限验证时，就会调用此方法
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

		//String account = (String) principals.getPrimaryPrincipal();
		String username = (String) getAvailablePrincipal(principalCollection);

        
        List<SysRole> list_r=null;
        List<SysPermission> list_permission=null;
        try {
            SysUser	 sysUser = sysUserService.selectRoleByName(username);
            list_r=sysUser.getRoles();
            SysUser sysUser_p=sysUserService.selectPermissionByUser(username);
            list_permission=sysUser_p.getPermissions();
            		
        } catch (Exception e) {
            e.printStackTrace();
        }
        //通过用户名从数据库获取权限/角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<String>();
        if (list_r.size()>0&&list_r!=null) {
        	for (SysRole sysRole: list_r) {
				r.add(sysRole.getfFullname());
			}
//          r.add(role.getRolename());
            info.setRoles(r);
        }
        //查询所有角色的所有权限
        //写入用户权限info.setStringPermissions();
        Set<String> perms = new HashSet<String>();
        if (list_permission.size()>0&&list_permission!=null) {
			for (SysPermission sysPermission : list_permission) {
				perms.add(sysPermission.getfEncode());
			}
		}
        //t.add("student:query");
        info.setStringPermissions(perms);
        return info;
	}
	
	
	 /**
     * 在这个方法中，进行身份验证
     *         login时调用
     */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		 //用户名
        String username = (String) token.getPrincipal();
        //密码
        String password = new String((char[])token.getCredentials());

        SysUser sysUser =null;
        try {
        	sysUser = sysUserService.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (sysUser == null) {
            //没有该用户名
            throw new UnknownAccountException();
        } else if (!password.equals(sysUser.getfPassword())) {
            //密码错误
            throw new IncorrectCredentialsException();
        }

        //身份验证通过,返回一个身份信息
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());
        SecurityUtils.getSubject().getSession().setAttribute("sysUser", sysUser);
        return aInfo;
	}
	

}
