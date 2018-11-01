package com.system.util.properties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;


/**
 * 
 * @title PropertiesUtil.java
 * @author liyuanguo
 * @description 工具类
 * @version V1.0
 */
public class PropertiesUtil {
	
	/**
	 * 随意获取 properties key 相关值
	 * @param param			- 配置文件定义的 key 
	 * @param propertiename - 配置文件名称
	 * @return
	 * @throws IOException
	 */
	public static String  getProperties(String param,String propertiename){
		Properties pps = new Properties();
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiename); 
		BufferedReader br = new BufferedReader(new InputStreamReader(in)); 
		try {
			pps.load(br);
			String returnStr ="";
			@SuppressWarnings("rawtypes")
			Enumeration enum1 = pps.propertyNames();// 得到配置文件的名字
			while (enum1.hasMoreElements()) {
				String strKey = (String) enum1.nextElement();
				if (strKey.equals(param)) {
					returnStr = pps.getProperty(strKey);
				}
			}
			return returnStr ;
		} catch (IOException e) {
			
			e.printStackTrace();
			return "";
		}finally{
			try {
				in.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 获取propertes 文件  key 对应的值
		String value = PropertiesUtil.getProperties("time", "time.properties");
		System.out.println(value);
	}
	
}
