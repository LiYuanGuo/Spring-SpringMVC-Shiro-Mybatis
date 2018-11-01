/**
 * 
 */
package com.system.controller.base;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.util.common.PubUtil;
import com.system.util.result.ResultUtil;


/**
 * @title AdminController.java
 * @author liyuanguo
 * @time 2018年7月16日 下午2:53:01
 * @description TODO
 * @version V1.0
 */
@Controller
public class AdminController {
	
	
	 /**
	  * 
	  * @author liyuanguo
	  * @time 2018年7月16日 下午3:02:02
	  * @description 管理员页面显示
	  */
    @RequestMapping("/admin/showAdmin")
    public String showAdmin() throws Exception {
    	
        return "admin/showAdmin";
    }
    /**
     * 
     * @author liyuanguo
     * @time 2018年7月16日 下午3:02:09
     * @description 学生页面
     */
	@RequestMapping("/student/showStudent")
    public String showStudent() throws BindException {
        return "student/showStudent";

    }
	
	@RequestMapping("/student/getStuentInfo")
	@ResponseBody
    public Object getStuentInfo() {
        return ResultUtil.result(200, "查询用户信息成功", PubUtil.getUser());

    }
	
	
	 /**
	  * 
	  * @author liyuanguo
	  * @time 2018年7月16日 下午3:02:19
	  * @description 教师页面显示
	  */
    @RequestMapping("/teacher/showTeacher")
    public String showTeacher() throws Exception {
        return "teacher/showTeacher";
    }
    
}
