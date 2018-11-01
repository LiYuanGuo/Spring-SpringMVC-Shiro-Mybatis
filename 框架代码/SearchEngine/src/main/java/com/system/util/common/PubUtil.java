package com.system.util.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;

import com.system.bean.sys.SysUser;

public class PubUtil {
	/**
	 * 
	 * @author liyuanguo
	 * @description list转ids
	 */
	public static String  listToIds(List<String> list) {
		String ids="";
		if (list.size()>0) {
			for (String a : list) {
				ids+=","+a;
			}
		}
		ids=ids.substring(1);
		return ids;
		
	}
	/**
	 * 
	 * @author liyuanguo
	 * @description string转LIST
	 */
	public static List<String>  stringToList(String id) {
		
		String[] aStrings=id.split(",");
		List<String> list=new ArrayList<>();
		for (String string : aStrings) {
			list.add(string);
		}
		
		return list;
		
	}
	/**
	 * 
	 * @author liyuanguo
	 * @description 获取当前登录user
	 */
	public static SysUser getUser() {
		Object su=SecurityUtils.getSubject().getSession().getAttribute("sysUser");
		SysUser sysUser=(SysUser) su;
		return sysUser;
	}
	public static Date getNowTime() {
		Date date=new Date();
		return date;
	}

}
