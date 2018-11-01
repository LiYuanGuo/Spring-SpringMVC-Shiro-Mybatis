package com.system.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.system.service.sys.SysUserService;
import com.system.util.quartz.CommonUtil;

/**
 * 定时器任务
 *
 */
public class WeiXinJob implements Job{

	private SysUserService sysUserService;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("定时执行");
		sysUserService=CommonUtil.getCurrentApplicationContext().getBean(SysUserService.class);
		//业务代码
	}
	

}
