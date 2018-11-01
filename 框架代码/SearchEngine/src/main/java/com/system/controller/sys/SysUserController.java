/**
 * 
 */
package com.system.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.bean.sys.SysPermission;
import com.system.bean.sys.SysRole;
import com.system.bean.sys.SysUser;
import com.system.service.sys.SysUserService;
import com.system.util.common.PubUtil;
import com.system.util.result.Result;
import com.system.util.result.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="用户模块")
@Controller
@RequestMapping("/sysuser")
public class SysUserController {

	@Resource(name = "sysUserService")
	private SysUserService sysUserService;

	
	/**
	 * 
	 * @author liyuanguo
	 * @description 分页查询数据
	 */
	@ApiOperation(value = "用户列表查询",notes="用户管理",httpMethod="POST",response=Result.class,produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/queryAll")
	@ResponseBody
	public Object queryAll(HttpServletRequest request, HttpServletResponse response,Integer pageNum,Integer pageSize,
			@ApiParam(required=false,value="用户名",name="fRealname")@RequestParam(value="fRealname",required=false)String fRealname ) {
		request.setAttribute("fRealname", "fRealname:"+fRealname);//关键数据
		return ResultUtil.result(200, "查询用户信息", sysUserService.queryAll(pageNum,pageSize,fRealname));
	}
	
	
	/**
	 * 
	 * @author liyuanguo
	 * @description 添加用户
	 */
	@ApiOperation(value = "用户新增",notes="用户管理",httpMethod="POST",response=Result.class,produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/addSysUser")
	@ResponseBody
	public Object addSysUser(HttpServletRequest request, HttpServletResponse response,SysUser sysUser ) {
		request.setAttribute("fAccount", "fAccount:"+sysUser.getfAccount());//关键数据
		if(sysUserService.addSysUser(sysUser)>0){
			return ResultUtil.result(200, "添加用户信息成功", "");
		}
		return ResultUtil.result(500, "添加用户信息失败","");
	}
	
	
	/**
	 * @author liyuanguo
	 * @description 查询指定用户信息 主键
	 */
	@ApiOperation(value = "根据用户ID查询",notes="用户管理",httpMethod="POST",response=Result.class,produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/queryOneSysUserKey")
	@ResponseBody
	public Object queryOneSysUserKey(HttpServletRequest request, HttpServletResponse response,SysUser sysUser ) {
		request.setAttribute("fId", "fId:"+sysUser.getfId());//关键数据
		return ResultUtil.result(200, "查询指定用户信息", sysUserService.queryOneSysUserKey(sysUser));
	}
	
	/**
	 * 
	 * @author liyuanguo
	 * @description 用户修改
	 */
	@ApiOperation(value = "用户修改",notes="用户管理",httpMethod="POST",response=Result.class,produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/updateSysUser")
	@ResponseBody
	public Object updateSysUser(HttpServletRequest request, HttpServletResponse response,SysUser sysUser ) {
		request.setAttribute("fId", "fId:"+sysUser.getfId());//关键数据
		if(sysUserService.updateSysUser(sysUser)>0){
			return ResultUtil.result(200, "修改用户信息成功", "");
		}
		return ResultUtil.result(500, "修改用户信息失败","");
	}	
	
	/**
	 * 
	 * @author liyuanguo
	 * @description 删除指定用户
	 */
	@ApiOperation(value = "用户删除",notes="用户管理",httpMethod="POST",response=Result.class,produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/deleteSysUser")
	@ResponseBody
	public Object deleteSysUser(HttpServletRequest request, HttpServletResponse response,SysUser sysUser ) {
		request.setAttribute("fId", "fId:"+sysUser.getfId());//关键数据
		if(sysUserService.deleteSysUser(sysUser)>0){
			return ResultUtil.result(200, "修改用户信息成功", "");
		}
		return ResultUtil.result(500, "修改用户信息失败","");
	}
	/**
	 * 
	 * @author liyuanguo
	 * @description 获取当前用户
	 */
	@ApiOperation(value = "获取当前用户",notes="用户管理",httpMethod="POST",response=Result.class,produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/getCurrentUser")
	@ResponseBody
	public Object getCurrentUser() {
		Map<String, Object> map=new HashMap<String, Object>();
		SysUser sysUser=PubUtil.getUser();
		Object user=sysUserService.queryOneSysUserKey(sysUser);
		String username=((SysUser) user).getfAccount();
		  List<SysRole> list_r=null;
	      List<SysPermission> list_permission=null;
	        try {
	            SysUser	 sysUser_r = sysUserService.selectRoleByName(username);
	            list_r=sysUser_r.getRoles();
	            SysUser sysUser_p=sysUserService.selectPermissionByUser(username);
	            list_permission=sysUser_p.getPermissions();
	            		
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        map.put("用户", sysUser);
	        map.put("角色", list_r);
	        map.put("权限", list_permission);
	       
		return ResultUtil.result(200, "获取当前用户信息,角色，权限成功",map);
	}
	
	/**
	 * 
	 * @author liyuanguo
	 * @description 根据名字查用户
	 */
	@ApiOperation(value = "根据名字查用户",notes="用户管理",httpMethod="POST",response=Result.class,produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/findByName")
	@ResponseBody
	public Object findByName(HttpServletRequest request, HttpServletResponse response,String name ) {
		
		return ResultUtil.result(200, "查看成功",sysUserService.findByName(name));
	}
	
	
	@ApiOperation(value = "用户测试",notes="用户管理",httpMethod="POST",response=Result.class,produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/test")
	@ResponseBody
	public Object test(HttpServletRequest request, HttpServletResponse response,String name ) {
		SysUser sysUser=sysUserService.selectRoleByName(name);
		List<SysRole> list=sysUser.getRoles();
		
		System.out.println(list.get(0).getfFullname());
		
		return ResultUtil.result(200, "查看成功","");
	}
	
	
}
