/**
 * 
 */
package com.system.controller.sys;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.service.log.SysLogService;
import com.system.util.result.Result;
import com.system.util.result.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * 日志管理
 *
 */
@Api(tags="日志管理")
@Controller
@RequestMapping("/syslog")
public class SysLogController {

	@Autowired
	private SysLogService sysLogService;

	
	/**
	 * 
	 * @author liyuanguo
	 * @time 2018年8月23日 下午2:54:44
	 * @description 分页查询数据
	 */
	@ApiOperation(notes = "日志管理",value = "日志分页查询",response = Result.class,httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/queryAll")
	@ResponseBody
	public Object queryAll(HttpServletRequest request, HttpServletResponse response,Integer pageNum,Integer pageSize,
			@ApiParam(value="开始时间",name="firstDate")@RequestParam(value="firstDate")Date firstDate ,
			@ApiParam(value="结束时间",name="endDate")@RequestParam(value="endDate")Date endDate) {
		request.setAttribute("key", "时间查询");
		return ResultUtil.result(200, "查询日志信息", sysLogService.queryAll(pageNum,pageSize,firstDate,endDate));
	}
	
	
}
