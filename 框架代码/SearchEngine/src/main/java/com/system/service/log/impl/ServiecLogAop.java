package com.system.service.log.impl;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.system.bean.log.SysLog;
import com.system.bean.sys.SysUser;
import com.system.controller.base.UserLogAnnotation;
import com.system.dao.sourceManage.log.SysLogMapper;
import com.system.util.common.IPInfoUtil;
import com.system.util.common.PubUtil;
import com.system.util.distributedUUID.Sid;

import io.swagger.annotations.ApiOperation;

/**
 * 日志切面
 *
 */
@Aspect
@Component
public class ServiecLogAop {
	private SysLog currsyslog = null;
	private HttpServletRequest req = null;

	@Autowired
	private SysLogMapper sysLogMapper;
	
	@Resource
	private Sid sid;

	@Pointcut("execution(* com.system.controller..*.*(..))")
	private void controllerAspect() {
	}

	@Around("controllerAspect()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		SysLog syslog = new SysLog();

		// 拦截的实体类，就是当前正在执行的controller
		Object target = pjp.getTarget();
		// 拦截的方法名称。当前正在执行的方法
		String methodName = pjp.getSignature().getName();
		// 拦截的方法参数
		Object[] args = pjp.getArgs();
		// 拦截的放参数类型
		Signature sig = pjp.getSignature();
		MethodSignature msig = null;
		if (!(sig instanceof MethodSignature)) {
			throw new IllegalArgumentException("该注解只能用于方法");
		}
		msig = (MethodSignature) sig;
		Class[] parameterTypes = msig.getMethod().getParameterTypes();
		Object object = null;
		// 获得被拦截的方法
		Method method = null;
		try {
			method = target.getClass().getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
		if (null != method) {
			// 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
			if (method.isAnnotationPresent(ApiOperation.class)) {
				Object[] method_param = null;
				req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				int result=1;
				try {
					object = pjp.proceed();
				} catch (Throwable e) {// catch所有错误不止异常
					e.printStackTrace();
					result=0;
					throw e;
				}finally{
					currsyslog = IPInfoUtil.SetSysLogIPInfoSysLog(syslog, req);
					System.err.println("method_param:" + req.getAttribute("key"));
					currsyslog.setfResult(result);
					currsyslog.setfKey(req.getAttribute("key") == null ? "" : req.getAttribute("key").toString());
					ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
					
					SysUser sysUser = PubUtil.getUser();
					currsyslog.setfId(sid.nextShort());
					currsyslog.setfCreatortime(new Date());
					currsyslog.setfUserid(sysUser != null ? sysUser.getfId() : "已过滤url");
					currsyslog.setfRealname(sysUser != null ? sysUser.getfRealname() : "已过滤url");
					currsyslog.setfModulename(apiOperation.notes());
					currsyslog.setfDescription(apiOperation.value());
					sysLogMapper.insertSelective(currsyslog);
				}
			} else {// 没有包含注解
				object = pjp.proceed();
			}
		} else { // 不需要拦截直接执行
			object = pjp.proceed();
		}
		return object;
	}
}
