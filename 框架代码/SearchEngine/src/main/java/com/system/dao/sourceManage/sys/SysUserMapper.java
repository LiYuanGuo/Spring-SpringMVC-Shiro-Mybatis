package com.system.dao.sourceManage.sys;

import java.util.List;

import com.system.bean.sys.SysUser;
import com.system.util.generate.MyMapper;

public interface SysUserMapper extends MyMapper<SysUser> {

	SysUser selectRoleByName(String f_account);
	List<SysUser> selectByName(String f_account);
	SysUser selectPermissionByPermission(String f_account);
	
}