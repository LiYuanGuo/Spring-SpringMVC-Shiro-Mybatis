/**
 * 
 */
package com.system.service.log;

import java.util.Date;

import com.system.bean.log.SysLog;

public interface SysLogService {

	Object queryAll(Integer pageNum,Integer pageSize, Date firstDate, Date firstDate2);

	void addSysLog(SysLog syslog);

}
