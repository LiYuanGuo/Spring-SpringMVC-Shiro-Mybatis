package com.system.util.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


/**
 * 
 * @title DateUtil.java
 * @author liyuanguo
 * @description 时间工具
 * @version V1.0
 */
public class DateUtil {
	
	
	public static long getLongDateTime(String data,String format) 
	{
		Date dt2;
		try
		{
			SimpleDateFormat sdf= new SimpleDateFormat(format);
			dt2 = sdf.parse(data);
		} 
		catch (ParseException e)
		{

			return 0;
		}
		return dt2.getTime();
	}
	
	public static String formatNowDateTime(String strFormat) {
		Date basicDate = new Date();
		SimpleDateFormat df = new SimpleDateFormat(strFormat);
		return df.format(basicDate);
	}
	/**
	 * 将字符串转换成时间
	 * @param dateString -要转换的时间
	 * @param formartString -要转换的格式
	 * @return
	 */
	public final static Date string2Time(String dateString,String formartString) {
		
		if(null==dateString||"".equals(dateString.trim())){
			return null;//时间参数不存在则直接返回
		}
		
		if(null==formartString||"".equals(formartString)){
			formartString="yyyy-MM-dd";//默认转换格式
		}	
		// 设定格式
		DateFormat dateFormat = new SimpleDateFormat(formartString,
				Locale.ENGLISH);
		dateFormat.setLenient(false);

		// util类型
		Date timeDate = null;
		try {
			timeDate = dateFormat.parse(dateString);
		} catch (Exception e) {
			return null;
		}
		return timeDate;
	}
	/**
	 * 将时间格式化为制定格式字符串
	 * @param dateString -要转换的时间
	 * @param formartString -要转换的格式  如：'yyyy-MM-dd'
	 * @return
	 */
	public final static String timeForMart(Date dateString,String formartString) {

		// 设定格式
		DateFormat dateFormat = new SimpleDateFormat(formartString);
		dateFormat.setLenient(false);
		return dateFormat.format(dateString);
	}
	
	
	/**
	 * <li>@方法说明:相隔天数
	 * <li>@param firstString
	 * <li>@param secondString
	 * <li>@param datafmt
	 * <li>@return
	 * <li>@创建日期:2010-5-4
	 * <li>@修改人: 
	 * <li>@修改日期:
	 * <li>@详细说明: 
	 */
	public static int nDaysBetweenTwoDate(String firstString,String secondString,String datafmt) { 
		SimpleDateFormat df = new SimpleDateFormat(datafmt); 
		Date firstDate=null; 
		Date secondDate=null; 
		try { 
		firstDate = df.parse(firstString); 
		secondDate=df.parse(secondString); 
		} 
		catch(Exception e) { 
		// 日期型字符串格式错误 
		} 
		
		int nDay=(int)((secondDate.getTime()-firstDate.getTime())/(24*60*60*1000)); 
		return nDay; 
	} 
	
	public static Date nDaysAfterOneDate(Date basicDate, int n) {
		long nDay = (basicDate.getTime() / (24 * 60 * 60 * 1000) + 1 + n)
				* (24 * 60 * 60 * 1000);
		basicDate.setTime(nDay);

		return basicDate;
	}
	
	/**  
     * 计算两个日期之间的天数＋1  
     * @param beginDate  
     * @param endDate  
     * @return  
     */  
    public int daysOfTwoDate(Date beginDate,Date endDate){   
        int days = 1;//两个日期之前的天数   
        //DateFormat df = new SimpleDateFormat("yyyyMMdd");   
           
        Calendar beginCalendar = Calendar.getInstance();   
        Calendar endCalendar = Calendar.getInstance();   
           
        beginCalendar.setTime(beginDate);   
        endCalendar.setTime(endDate);   
        //计算天数   
        while(beginCalendar.before(endCalendar)){   
            days++;   
            beginCalendar.add(Calendar.DAY_OF_MONTH, 1);   
        }   
        return days;   
    }  

	
	public static String nDaysAfterOneDateString(String basicDate,int n,String datafmt) { 
		SimpleDateFormat df = new SimpleDateFormat(datafmt); 
		Date tmpDate = null; 
		try { 
		tmpDate = df.parse(basicDate); 
		} 
		catch(Exception e){ 
		// 日期型字符串格式错误 
		} 
		long nDay=(tmpDate.getTime()/(24*60*60*1000)+1+n)*(24*60*60*1000); 
		tmpDate.setTime(nDay); 
		
		return df.format(tmpDate); 
		} 
	
	/**
	 * 将时间转换成字符串
	 * @param basicDate
	 * @param strFormat
	 * @return
	 */
	public static String formatDateTime(Date basicDate, String strFormat) {
		if (basicDate == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat(strFormat);
		return df.format(basicDate);
	}
	
	public static String formatDateTime(String basicDate, String oldFormat,
			String newFormat) throws Exception {
		if (basicDate == null || "".equals(basicDate)) {
			return "";
		}
		SimpleDateFormat odf = new SimpleDateFormat(oldFormat);
		SimpleDateFormat ndf = new SimpleDateFormat(newFormat);
		Date tmpDate = null;
		try {
			tmpDate = odf.parse(basicDate);
		} catch (Exception e) {
			throw e;
		}
		return ndf.format(tmpDate);
	}

	public static String formatDateTime(long basicDate, String strFormat) {
		if (basicDate == 0) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat(strFormat);
		return df.format(new Date(basicDate));
	}
	public static String formatDateTime(String basicDate, String strFormat) {
		if (basicDate == "0") {
			return "";
		}
		Long b=Long.valueOf(basicDate);
		SimpleDateFormat df = new SimpleDateFormat(strFormat);
		return df.format(new Date(b));
	}
	public String IsValidText(String beginTime,String endTime) {
		long nowtime = (new Date()).getTime();
		
		if(Long.parseLong(beginTime)>nowtime){
			return "调查未开始";
		}else if(Long.parseLong(endTime)<nowtime){
			return "调查结束";
		}else{
			return "正在调查";
		}
	}
/**
 * 得到当前时间
 * @param fmtStr 格式化标准yyyy-MM-dd HH:mm:ss
 * @return
 */
	public static String getNowDate(String fmtStr){
		SimpleDateFormat df = new SimpleDateFormat(fmtStr);//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}
	
	public static String getDateTime2(String basicDate) {
		try {
			if (basicDate.trim().length() >= 14) {
				return formatDateTime(basicDate.substring(0, 14),
						"yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
			} else if (basicDate.trim().length() >= 8
					&& basicDate.trim().length() < 14) {
				return formatDateTime(basicDate.substring(0, 8), "yyyyMMdd",
						"yyyy-MM-dd");
			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}
	
	/**
	 * <li>@方法说明:
	 * <li>@param month  yyyy-MM
	 * <li>@return
	 */
	public static int getMonthDays(String month){
		Calendar time=Calendar.getInstance(); 
		time.clear(); 
		time.set(Calendar.YEAR,Integer.parseInt(month.substring(0, 4))); 
		time.set(Calendar.MONTH,Integer.parseInt(month.substring(5))-1);//Calendar对象默认一月为0            
		int day=time.getActualMaximum(Calendar.DAY_OF_MONTH);//本月份的天数
		return day;
	}
	
	
	
	//jest start
	/**
	 * 计算两个String的日期之间相差天数
	 *   JAVA计算两个日期之间相差的天数
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int countDays(String begin,String end){
		  int days = 0;
		  
		  DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		  Calendar c_b = Calendar.getInstance();
		  Calendar c_e = Calendar.getInstance();
		  
		  try{
		   c_b.setTime(df.parse(begin));
		   c_e.setTime(df.parse(end));
		   
		   while(c_b.before(c_e)){
		    days++;
		    c_b.add(Calendar.DAY_OF_YEAR, 1);
		   }
		   
		  }catch(ParseException pe){
		   System.out.println("日期格式必须为：yyyy-MM-dd；如：2010-4-4.");
		  }
		  
		  return days; 
	} 
	
	/** 
	* 获得指定日期的前一天 
	* @param specifiedDay 
	* @return 
	* @throws Exception 
	*/ 
	public static String getSpecifiedDayBefore(String specifiedDay){ 
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar c = Calendar.getInstance(); 
		Date date=null; 
		try { 
		date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
		} catch (ParseException e) { 
		e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day-1); 
	
		String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
		return dayBefore; 
	} 
	/** 
	* 获得指定日期的后一天 
	* @param specifiedDay 
	* @return 
	*/ 
	public static String getSpecifiedDayAfter(String specifiedDay){ 
		Calendar c = Calendar.getInstance(); 
		Date date=null; 
		try { 
		date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
		} catch (ParseException e) { 
		e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day+1); 
	
		String dayAfter=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
		return dayAfter; 
	} 

	/** 
	 * 获得当前日期前day天 
	 *       
	 * @param day       
	 *  @return 
	 */ 
	public static String getTimeStr(String nowDate,int day) { 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		//Date d = new Date(); 
		Date d=stringToDate(nowDate,"yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, -day);
		String resultDay = df.format(cal.getTime());
		return resultDay;
	}
	
	 /**  
     * 将字符型转换为指定格式日期型  
     * @param _date 需要转换成日期的字符串  
     * @param format 与需要转换成日期的字符串相匹配的格式  
     * @return  
     */  
    private static Date stringToDate(String _date,String format){   
        if(null == format || "".equals(format)){   
            format = "yyyy-MM-dd HH:mm:ss";   
        }   
        SimpleDateFormat sdf = new SimpleDateFormat(format);   
        Date date=null;   
        try {   
            date=sdf.parse(_date);   
        } catch (ParseException e) {   
            e.printStackTrace();   
        }   
        return date;   
    }   
	public static int get(String str,String type){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
	    try {
			 date = sdf.parse(str);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	    return Integer.valueOf(new SimpleDateFormat(type).format(date).trim());
	}
	/**
	 * 当前月份第一天
	 * @return
	 */
	public static String getCurrentMonthFirstDay(){
		String result =getNowDate("yyyy-MM");
		return result+"-01";
	}
	/**
	 * 当前月份最后一天
	 * @return
	 */
	public static String getCurrentMonthLastDay(){
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
	}
	/**
	 * 当年第一天
	 * @return
	 */
	public static String getCurrentYearFirstDay() {
			String currentYear=DateUtil.getNowDate("yyyy");
	        return currentYear+"-01-01";
	}
	/**
	 * 当年最后一天
	 * @return
	 */
	public static String getCurrentYearLastDay(){
		String repeatDate=DateUtil.getNowDate("yyyy")+"-12-01";
		 SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
	        Calendar calendar = Calendar.getInstance();
	        try {
	            if(repeatDate!=null&&!"".equals(repeatDate.trim())){
	                calendar.setTime(dft.parse(repeatDate));
	            }
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	        return dft.format(calendar.getTime());
	}
	/**
	 * 指定月份最后天
	 */
	public static String getLastDay(String exDate,String exFormat ){
		 SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.string2Time(exDate,exFormat));
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDayOfMonth = calendar.getTime();
		return dft.format(lastDayOfMonth);
	}
	public static String getLastDayOfYear(String year){
		String repeatDate=year+"-12-01";
		 SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
	        Calendar calendar = Calendar.getInstance();
	        try {
	            if(repeatDate!=null&&!"".equals(repeatDate.trim())){
	                calendar.setTime(dft.parse(repeatDate));
	            }
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	        return dft.format(calendar.getTime());
	}
	
	
	/**
	 * <p>描述：转换long类型时间</p>
	 * <p>返回值：String</p>
	 * <p>参数：@param basicDate 时间
	 * <p>参数：@param strFormat 时间格式
	 * <p>参数：@return</p>
	 */
	public static String formatLongDateTime(long basicDate, String strFormat) {
		if (basicDate == 0) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat(strFormat);
		return df.format(new Date(basicDate));
	}
	/**
	 * 得到当前年度
	 * */
	public static void main(String[] args) {
		System.out.println(getLastDayOfYear("2017"));
		//System.out.println(nDaysBetweenTwoDate("2011-02-29", "2011-03-29", "yyyy-MM-dd"));
	}
	public static String formatDate(String dateStr,String fs){
		SimpleDateFormat df = new SimpleDateFormat(fs);//设置日期格式
		Date date = null;
		Calendar cd = new GregorianCalendar();
		String year ="";
		String month ="";
		String day="";
		try {
			date = df.parse(dateStr);
			cd.setTime(date);
			year=String.valueOf(cd.get(Calendar.YEAR));
			month=String.valueOf(cd.get(Calendar.MONTH)+1);
			day=String.valueOf(cd.get(Calendar.DAY_OF_MONTH));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String returnStr =dateStr;
		boolean putTogetherFlag=year!=""&&month!=""&&day!="";
		if(putTogetherFlag){
			returnStr=year+"-"+month+"-"+day;
		} 
		return returnStr;
	}
}
