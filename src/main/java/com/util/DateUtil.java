package com.util;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
	public static final String FORMAT_YYYY = "yyyy";
	public static final String FORMAT_HHMMSS = "HHmmss";
	public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static String date2Str(Date date) {
		return date2Str(date, FORMAT_YYYY_MM_DD_HH_MM_SS);
	}

	public static String date2Str(Date date, String format) {
		if (format == null || format.equals("")) {
			format = FORMAT_YYYY_MM_DD_HH_MM_SS;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (date != null) {
			return sdf.format(date);
		}
		return "";
	}
	
	public static String getCurrentDateStr(String format) {
		if (format == null || format.equals("")) {
			format = FORMAT_YYYY_MM_DD_HH_MM_SS;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		return sdf.format(new Date());
	}
	
	/**
	 * 获取当前时间，格式为 yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getCurrentTimeStr(String format) {
		format = StringUtils.isBlank(format) ? FORMAT_YYYY_MM_DD_HH_MM_SS : format;
		Date now = new Date();
		return date2Str(now, format);
	}
	
	public static Timestamp getgetCurrentTime() {
		return Timestamp.valueOf(getCurrentTimeStr(null));
	}

	/**
	 * 获取当前时间的秒数
	 * @return
	 */
	public static long getCurrentSecond() {
		return System.currentTimeMillis()/1000;
	}
	
	public static String format(Date date, String pattern) {
		if(null == date){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String str = sdf.format(date);
		return str;
	}

	public static Date str2Date(String dateStr, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @param src 字符串
	 * @param srcFormat 字符串日期的格式
	 * @param tranfFomat 日期要转成的格式。
	 * @return 字符串
	 */
	public static String translateFormatStr(String src,String srcFormat,String tranfFomat) {
		try {
			Date date = new SimpleDateFormat(srcFormat).parse(src);//yyyyMMddHHmmss
			return new SimpleDateFormat(tranfFomat).format(date);//yyyy-MM-dd HH:mm:ss
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
  public static Date translateFormatDate(String src,String srcFormat,String tranfFomat){
  	String translateFormatStr = translateFormatStr(src,srcFormat,tranfFomat);
		return str2Date(translateFormatStr,tranfFomat);
  }
  
	/**
	 * 得到日期+i天后的日期
	 * 
	 * @param d
	 * @param i
	 * @return
	 */
	public static Date addDay(Date d, int i) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(d);
		calendar.add(Calendar.DATE, i);// 把日期往后增加一天.整数往后推,负数往前移动
		return calendar.getTime();// 这个时间就是日期往后推一天的结果
	}
	
	/**
	 *  加减天
	 * @param time
	 * @param minute 分钟
	 * @return
	 */
	public static String addDay(Date date, int day,String format) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(Calendar.DATE, day);
		
		return date2Str(calendar.getTime(),format);
	}
	
	/**
	 * 加减分钟
	 * @param date
	 * @param minute
	 * @param format
	 * @return
	 */
	public static String addMinutes(Date date, int minute, String format) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(Calendar.MINUTE, minute);
		
		return date2Str(calendar.getTime(), format);
	}
	
	/**
	 * 加减小时
	 * @param date
	 * @param minute
	 * @param format
	 * @return
	 */
	public static String addHours(Date date, int hours, String format) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(Calendar.HOUR_OF_DAY, hours);
		
		return date2Str(calendar.getTime(), format);
	}
	
	
	/**
	 * 得到日期+i年后的日期
	 * 
	 * @param d
	 * @param i
	 * @return
	 */
	public static Date addYear(Date d, int i) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(d);
		calendar.add(Calendar.YEAR, i);// 把日期往后增加一年.整数往后推,负数往前移动
		return calendar.getTime();// 这个时间就是日期往后推一年的结果
	}

	/**
	 * 
	 * desc:获取n天后或n天前的日期 
	 * <p>创建人：liuyuncheng</p>
	 * @param date
	 * @param formatstr 参数date的格式，返回的格式
	 * @param day 正数n天后，负数n天前
	 * @return
	 * @throws ParseException
	 */
	public static String  addDay(String date, String formatstr,int day){
		SimpleDateFormat format = new SimpleDateFormat(formatstr);
		format.setLenient(false);
		Date paramDate = null;
		try {
			paramDate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(paramDate);
		calendar.add(Calendar.DATE, day);
		return new SimpleDateFormat(formatstr).format(calendar.getTime());
	}
	
	/**
	 * 日期格式转换
	 * 
	 * @param str
	 *          yyyyMMdd
	 * @return yyyy-MM-dd
	 */
	public static String formatStr(String str) {
		if (str == null || str.length() != 8) {
			return str;
		}
		return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
	}
	
	/**
	 * 时间比较
	 * @param DATE1
	 * @param DATE2
	 * @return DATE1>DATE2返回1，DATE1<DATE2返回-1,等于返回0
	 */
	public static int compareDate(String date1, String date2,String format) {
		DateFormat df = new SimpleDateFormat(format);
		try {
			Date dt1 = df.parse(date1);
			Date dt2 = df.parse(date2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
//		System.out.println(date2Str(new Date(), "yyyyMMdd"));
//		
//		System.out.println("========"+format(new Date(),"yyyy/MM/dd"));
//		
//		System.out.println("=======111==="+translateFormatStr("20150314202014","yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss"));
//		
//		System.out.println("=======111==="+translateFormatDate("20150314202014","yyyyMMddHHmmss","yyyy-MM-dd"));
//		System.out.println("=========="+str2Date("20150314202014","yyyy-MM-dd"));
//		
//		long nowsecond =  getCurrentSecond();
//		
//		System.out.println(nowsecond-24*3600);
//		
		System.out.println(compareDate("20150422", "20150421", "yyyyMMdd"));
		Date now = new Date();
		System.out.println(DateUtil.date2Str(now, DateUtil.FORMAT_YYYY));
		System.out.println(DateUtil.date2Str(DateUtil.addYear(now, -1), DateUtil.FORMAT_YYYY));
		
	}
}
