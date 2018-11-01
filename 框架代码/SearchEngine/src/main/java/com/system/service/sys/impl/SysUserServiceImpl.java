/**
 * 
 */
package com.system.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.bean.sys.SysUser;
import com.system.dao.sourceManage.sys.SysUserMapper;
import com.system.service.sys.SysUserService;
import com.system.util.common.PubUtil;
import com.system.util.distributedUUID.Sid;

import tk.mybatis.mapper.entity.Example;


@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Resource
	private Sid sid;

	/**
	 * 查询所有用户信息
	 */
	@Override
	public Object queryAll(Integer pageNum,Integer pageSize, String fRealname) {
		
		PageHelper.startPage(pageNum, pageSize, true);
		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("fDeletemark", 0);
		criteria.andEqualTo("fEnabledmark", 1);
		if (fRealname!=null&&!"".equals(fRealname)) {
			criteria.andLike("fRealname", "%" + fRealname + "%");
		}
		
		List<SysUser> list = sysUserMapper.selectByExample(example);
		PageInfo<SysUser> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}

	/**
	 * 新增用户
	 */
	@Override
	public int addSysUser(SysUser sysUser) {
		sysUser.setfId(sid.nextShort());
		return sysUserMapper.insertSelective(sysUser);
	}

	@Override
	public Object queryOneSysUserKey(SysUser sysUser) {
		return sysUserMapper.selectByPrimaryKey(sysUser);
	}

	@Override
	public int updateSysUser(SysUser sysUser) {
		sysUser.setfLastmodifytime(PubUtil.getNowTime());
		sysUser.setfLastmodifyuserid(PubUtil.getUser().getfId());
		return sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}

	/**
	 * 删除指定用户
	 */
	@Override
	public int deleteSysUser(SysUser sysUser) {
		
		return sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}

	@Override
	public SysUser findByName(String name) {
		
		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("fDeletemark", 0);
		criteria.andEqualTo("fEnabledmark", 1);
		criteria.andEqualTo("fAccount", name);
		SysUser sysUser= sysUserMapper.selectOneByExample(example);
		return sysUser;
	 
	}
	/**
	 * 根据用户查找角色
	 */
	@Override
	public SysUser selectRoleByName(String name) {
		
		return sysUserMapper.selectRoleByName(name);
	}
	/**
	 * 根据用户查找权限
	 */
	@Override
	public SysUser selectPermissionByUser(String f_account) {
		
		return sysUserMapper.selectPermissionByPermission(f_account);
	}



	

}
