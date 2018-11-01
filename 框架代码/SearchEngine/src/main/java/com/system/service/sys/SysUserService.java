/**
 * 
 */
package com.system.service.sys;

import com.system.bean.sys.SysUser;

/**
 * @author 
 *
 */
public interface SysUserService {

	/**
	 * 查询所有用户信息 
	 */
	Object queryAll(Integer pageNum,Integer pageSize, String fRealname);

	/**
	 * 新增用户	
	 */
	int addSysUser(SysUser sysUser);

	/**
	 * 查询指定用户信息 主键	
	 */
	Object queryOneSysUserKey(SysUser sysUser);

	/**
	 * 修改用户信息 	
	 */
	int updateSysUser(SysUser sysUser);

	/**
	 * 删除指定用户 	
	 */
	int deleteSysUser(SysUser sysUser);
	SysUser findByName(String name);
	/**
	 *根据用户查找角色
	 */
	SysUser selectRoleByName(String name);
	/**
	 * 根据用户查找权限
	 */
	SysUser selectPermissionByUser(String f_account);
	

}
