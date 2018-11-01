package com.system.controller.login;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.bean.log.SysLog;
import com.system.bean.sys.SysUser;
import com.system.service.log.SysLogService;
import com.system.util.common.IPInfoUtil;
import com.system.util.encryption.MD5Util;


@Controller
public class LoginController {
	
	@Autowired
	private SysLogService sysLogService;
	
	
	/*//登录跳转
    @RequestMapping(value = "/logout", method = {RequestMethod.GET,RequestMethod.POST})
    public String  logout(HttpServletRequest request, ServletResponse response) throws Exception {
    	System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++准备退出shiro");
    	Subject subject = SecurityUtils.getSubject();
        subject.logout();
        SysLog syslog = new SysLog();
        syslog.setfDescription("退出登录");
        sysLogService.addSysLog(IPInfoUtil.SetSysLogIPInfoSysLog(syslog,request));
        return "/logout";
    }*/


    //登录表单处理
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(HttpServletRequest request,SysUser sysUser) throws Exception {
    	System.out.println("登录账号:"+sysUser.getfAccount());
    	//Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getfAccount(),
        		MD5Util.encode(sysUser.getfPassword()));
        Subject subject = SecurityUtils.getSubject();

        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        subject.login(token);
        if (subject.hasRole("admin")) {
            return "redirect:/admin/showAdmin";
        } else if (subject.hasRole("teacher")) {
            return "redirect:/teacher/showTeacher";
        } else if (subject.hasRole("student")) {
            return "redirect:/student/showStudent";
        }

        return "../../login";
    }
    
    

}
