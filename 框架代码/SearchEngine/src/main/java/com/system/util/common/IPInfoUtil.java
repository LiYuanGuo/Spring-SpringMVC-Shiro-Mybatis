/**
 * 
 */
package com.system.util.common;

import java.io.File;
import java.net.InetAddress;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.system.bean.log.SysLog;

/**
 * 装填日志城市信息
 * 
 *
 */
public class IPInfoUtil {

	public static SysLog SetSysLogIPInfoSysLog(SysLog syslog, HttpServletRequest request) {
		try {

			String IP = IpAdrressUtil.getIpAdrress();
			syslog.setfIpaddress(IP);
			if (IP.equals("127.0.0.1") || IP.equals("localhost")) {
				syslog.setfIpaddressname("本地");
				syslog.setfCreatortime(new Date());
				return syslog;
			}

			// 创建 GeoLite2 数据库
			System.out.println("地址：" + (request.getSession().getServletContext().getRealPath("/")).replace("\\", "/"));
			File database = new File((request.getSession().getServletContext().getRealPath("/")).replace("\\", "/")
					+ "/WEB-INF/classes/GeoLite2-City.mmdb");
			// 读取数据库内容
			DatabaseReader reader;
			reader = new DatabaseReader.Builder(database).build();
			InetAddress ipAddress = InetAddress.getByName(IP);

			// 获取查询结果
			CityResponse response = reader.city(ipAddress);
			// 获取国家信息
			// System.out.println(response.getCountry().getIsoCode()); // 'CN'
			// System.out.println(response.getCountry().getName()); // 'China'
			System.out.println(response.getCountry().getNames().get("zh-CN")); // '中国'

			// 获取省份
			// Subdivision subdivision = response.getMostSpecificSubdivision();
			// System.out.println(response.getMostSpecificSubdivision().getName());
			// // 'Guangxi
			// Zhuangzu
			// Zizhiqu'
			// System.out.println(response.getMostSpecificSubdivision().getIsoCode());
			// // '45'
			System.out.println(response.getMostSpecificSubdivision().getNames().get("zh-CN")); // '广西壮族自治区'

			// 获取城市
			// City city = response.getCity();
			// System.out.println(response.getCity().getName()); // 'Nanning'
			// Postal postal = response.getPostal();
			// System.out.println(response.getPostal().getCode()); // 'null'
			// System.out.println(response.getCity().getNames().get("zh-CN"));
			// // '南宁'
			syslog.setfIpaddressname(response.getCity().getNames().get("zh-CN"));
			syslog.setfCreatortime(new Date());
			// Location location = response.getLocation();
			// System.out.println(response.getLocation().getLatitude()); //
			// 22.8167 经度
			// System.out.println(response.getLocation().getLongitude()); //
			// 108.3167 纬度
		} catch (Exception e) {
			e.printStackTrace();
			return syslog;
		}
		return syslog;
	}

}
