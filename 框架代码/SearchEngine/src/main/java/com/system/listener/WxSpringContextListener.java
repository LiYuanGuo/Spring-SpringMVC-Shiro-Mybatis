package com.system.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;

import com.system.job.WeiXinJob;
import com.system.util.properties.PropertiesUtil;
import com.system.util.quartz.QuartzManager;

@Controller
public class WxSpringContextListener  implements ApplicationListener<ContextRefreshedEvent> {
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("getDisplayName:"+event.getApplicationContext().getDisplayName());
		if(event.getApplicationContext().getDisplayName().equals("WebApplicationContext for namespace 'springmvc-servlet'")){
			String value = PropertiesUtil.getProperties("time", "time.properties");
			System.out.println(value);
			//QuartzManager.addJob("tokenjob", WeiXinJob.class,value);//每隔2小时更新token
		}
	}
}
