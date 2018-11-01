/**
 * 
 */
package com.system.service.log.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.bean.log.SysLog;
import com.system.dao.sourceManage.log.SysLogMapper;
import com.system.service.log.SysLogService;

import tk.mybatis.mapper.entity.Example;


@Service
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogMapper sysLogMapper;
	
	@Override
	public Object queryAll(Integer pageNum,Integer pageSize, Date firstDate, Date endDate) {
		Map<String, Object> data = new HashMap<>();
		PageHelper.startPage(pageNum, pageSize, true);
		Example example = new Example(SysLog.class);
		Example.Criteria criteria = example.createCriteria();
		if (firstDate != null && endDate !=null) {
			//查询在一个时间段之内提交的 数据
			criteria.andBetween("markingTime", firstDate, endDate);
		}
		List<SysLog> list = sysLogMapper.selectByExample(example);
		PageInfo page= new PageInfo(list);
		return page;
	}

	@Override
	public void addSysLog(SysLog syslog) {
		
		sysLogMapper.insert(syslog);
	}
	

}
