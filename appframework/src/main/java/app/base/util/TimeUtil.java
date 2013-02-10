package app.base.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 有关日期工具类(extends TimeUtil)
 * 
 * TimeUtil主要功能有：
 * 1.各种日期类型（字符，util.Date，sql.Date，Calendar等）转换
 * 2.获取指定日期的年份，月份，日份，小时，分，秒，毫秒
 * 3.获取当前/系统日期(指定日期格式)
 * 4.获取字符日期一个月的天数
 * 5.获取指定月份的第一天,最后一天
 * 
 * DateUtil主要功能有：
 * 1.日期比较
 * 2.获取2个字符日期的天数差，周数差，月数差，年数差
 * 3.日期添加
 * 4.判断给定日期是不是润年
 */


public class TimeUtil extends DateTimeUtil {

//	// ---当前日期的年，月，日，时，分，秒
//	public static Calendar now = Calendar.getInstance();
//	int year = now.get(Calendar.YEAR);
//	int date = now.get(Calendar.DAY_OF_MONTH);
//	int month = now.get(Calendar.MONTH) + 1;
//	int hour = now.get(Calendar.HOUR);
//	int min = now.get(Calendar.MINUTE);
//	int sec = now.get(Calendar.SECOND);
//
//	// -------------------------------日期类型转换---------------------------------------------------------------------------
//	/**
//	 * 字符型日期转化util.Date型日期
//	 * 
//	 * @Param:p_strDate 字符型日期
//	 * @param p_format
//	 *            格式:"yyyy-MM-dd" / "yyyy-MM-dd hh:mm:ss"
//	 * @Return:java.util.Date util.Date型日期
//	 * @Throws: ParseException
//	 * @Author: zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static java.util.Date toUtilDateFromStrDateByFormat(
//			String p_strDate, String p_format) throws ParseException {
//		java.util.Date l_date = null;
//		java.text.DateFormat df = new java.text.SimpleDateFormat(p_format);
//		if (p_strDate != null && (!"".equals(p_strDate)) && p_format != null
//				&& (!"".equals(p_format))) {
//			l_date = df.parse(p_strDate);
//		}
//		return l_date;
//	}
//
//	/**
//	 * 字符型日期转化成sql.Date型日期
//	 * 
//	 * @param p_strDate
//	 *            字符型日期
//	 * @return java.sql.Date sql.Date型日期
//	 * @throws ParseException
//	 * @Author: zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static java.sql.Date toSqlDateFromStrDate(String p_strDate)
//			throws ParseException {
//		java.sql.Date returnDate = null;
//		java.text.DateFormat sdf = new java.text.SimpleDateFormat();
//		if (p_strDate != null && (!"".equals(p_strDate))) {
//			returnDate = new java.sql.Date(sdf.parse(p_strDate).getTime());
//		}
//		return returnDate;
//	}
//
//	/**
//	 * util.Date型日期转化指定格式的字符串型日期
//	 * 
//	 * @param p_date
//	 *            Date
//	 * @param p_format
//	 *            String 格式1:"yyyy-MM-dd" 格式2:"yyyy-MM-dd hh:mm:ss EE"
//	 *            格式3:"yyyy年MM月dd日 hh:mm:ss EE" 说明: 年-月-日 时:分:秒 星期 注意MM/mm大小写
//	 *            格式4:"yyyyMMddHHmmss"
//	 * @return String
//	 * @Author: zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static String toStrDateFromUtilDateByFormat(
//			java.util.Date p_utilDate, String p_format) throws ParseException {
//		String l_result = "";
//		if (p_utilDate != null) {
//			SimpleDateFormat sdf = new SimpleDateFormat(p_format);
//			l_result = sdf.format(p_utilDate);
//		}
//		return l_result;
//	}
//
//	/**
//	 * util.Date型日期转化转化成Calendar日期
//	 * 
//	 * @param p_utilDate
//	 *            Date
//	 * @return Calendar
//	 * @Author: zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static Calendar toCalendarFromUtilDate(java.util.Date p_utilDate) {
//		Calendar c = Calendar.getInstance();
//		c.setTime(p_utilDate);
//		return c;
//	}
//
//	/**
//	 * util.Date型日期转化sql.Date(年月日)型日期
//	 * 
//	 * @Param: p_utilDate util.Date型日期
//	 * @Return: java.sql.Date sql.Date型日期
//	 * @Author: zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static java.sql.Date toSqlDateFromUtilDate(java.util.Date p_utilDate) {
//		java.sql.Date returnDate = null;
//		if (p_utilDate != null) {
//			returnDate = new java.sql.Date(p_utilDate.getTime());
//		}
//		return returnDate;
//	}
//
//	/**
//	 * util.Date型日期转化sql.Time(时分秒)型日期
//	 * 
//	 * @Param: p_utilDate util.Date型日期
//	 * @Return: java.sql.Time sql.Time型日期
//	 * @Author: zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static java.sql.Time toSqlTimeFromUtilDate(java.util.Date p_utilDate) {
//		java.sql.Time returnDate = null;
//		if (p_utilDate != null) {
//			returnDate = new java.sql.Time(p_utilDate.getTime());
//		}
//		return returnDate;
//	}
//
//	/**
//	 * util.Date型日期转化sql.Date(时分秒)型日期
//	 * 
//	 * @Param: p_utilDate util.Date型日期
//	 * @Return: java.sql.Timestamp sql.Timestamp型日期
//	 * @Author: zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static java.sql.Timestamp toSqlTimestampFromUtilDate(
//			java.util.Date p_utilDate) {
//		java.sql.Timestamp returnDate = null;
//		if (p_utilDate != null) {
//			returnDate = new java.sql.Timestamp(p_utilDate.getTime());
//		}
//		return returnDate;
//	}
//
//	/**
//	 * sql.Date型日期转化util.Date型日期
//	 * 
//	 * @Param: sqlDate sql.Date型日期
//	 * @Return: java.util.Date util.Date型日期
//	 * @Author: zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static java.util.Date toUtilDateFromSqlDate(java.sql.Date p_sqlDate) {
//		java.util.Date returnDate = null;
//		if (p_sqlDate != null) {
//			returnDate = new java.util.Date(p_sqlDate.getTime());
//		}
//		return returnDate;
//	}
//
//	// -----------------获取指定日期的年份，月份，日份，小时，分，秒，毫秒----------------------------
//	/**
//	 * 获取指定日期的年份
//	 * 
//	 * @param p_date
//	 *            util.Date日期
//	 * @return int 年份
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static int getYearOfDate(java.util.Date p_date) {
//		java.util.Calendar c = java.util.Calendar.getInstance();
//		c.setTime(p_date);
//		return c.get(java.util.Calendar.YEAR);
//	}
//
//	/**
//	 * 获取指定日期的月份
//	 * 
//	 * @param p_date
//	 *            util.Date日期
//	 * @return int 月份
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static int getMonthOfDate(java.util.Date p_date) {
//		java.util.Calendar c = java.util.Calendar.getInstance();
//		c.setTime(p_date);
//		return c.get(java.util.Calendar.MONTH) + 1;
//	}
//
//	/**
//	 * 获取指定日期的日份
//	 * 
//	 * @param p_date
//	 *            util.Date日期
//	 * @return int 日份
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static int getDayOfDate(java.util.Date p_date) {
//		java.util.Calendar c = java.util.Calendar.getInstance();
//		c.setTime(p_date);
//		return c.get(java.util.Calendar.DAY_OF_MONTH);
//	}
//
//	/**
//	 * 获取指定日期的小时
//	 * 
//	 * @param p_date
//	 *            util.Date日期
//	 * @return int 日份
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static int getHourOfDate(java.util.Date p_date) {
//		java.util.Calendar c = java.util.Calendar.getInstance();
//		c.setTime(p_date);
//		return c.get(java.util.Calendar.HOUR_OF_DAY);
//	}
//
//	/**
//	 * 获取指定日期的分钟
//	 * 
//	 * @param p_date
//	 *            util.Date日期
//	 * @return int 分钟
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static int getMinuteOfDate(java.util.Date p_date) {
//		java.util.Calendar c = java.util.Calendar.getInstance();
//		c.setTime(p_date);
//		return c.get(java.util.Calendar.MINUTE);
//	}
//
//	/**
//	 * 获取指定日期的秒钟
//	 * 
//	 * @param p_date
//	 *            util.Date日期
//	 * @return int 秒钟
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static int getSecondOfDate(java.util.Date p_date) {
//		java.util.Calendar c = java.util.Calendar.getInstance();
//		c.setTime(p_date);
//		return c.get(java.util.Calendar.SECOND);
//	}
//
//	/**
//	 * 获取指定日期的毫秒
//	 * 
//	 * @param p_date
//	 *            util.Date日期
//	 * @return long 毫秒
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static long getMillisOfDate(java.util.Date p_date) {
//		java.util.Calendar c = java.util.Calendar.getInstance();
//		c.setTime(p_date);
//		return c.getTimeInMillis();
//	}
//
//	/**
//	 * 得到php格式的time,返回当前时间的 Unix 时间戳。
//	 * 
//	 * @return
//	 */
//	public static String getPHPTime() {
//		return System.currentTimeMillis() / 1000 + "";
//	}
//
//	// -----------------获取当前/系统日期(指定日期格式)-----------------------------------------------------------------------------------
//	/**
//	 * 获取指定日期格式当前日期的字符型日期
//	 * 
//	 * @param p_format
//	 *            日期格式 格式1:"yyyy-MM-dd" 格式2:"yyyy-MM-dd hh:mm:ss EE"
//	 *            格式3:"yyyy年MM月dd日 hh:mm:ss EE" 说明: 年-月-日 时:分:秒 星期 注意MM/mm大小写
//	 * @return String 当前时间字符串
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static String getNowOfDateByFormat(String p_format) {
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat(p_format);
//		String dateStr = sdf.format(d);
//		return dateStr;
//	}
//
//	/**
//	 * 获取当前时间前一天的字符型日期
//	 * 
//	 * @param p_format
//	 *            日期格式 格式1:"yyyy-MM-dd" 格式2:"yyyy-MM-dd hh:mm:ss EE"
//	 *            格式3:"yyyy年MM月dd日 hh:mm:ss EE" 说明: 年-月-日 时:分:秒 星期 注意MM/mm大小写
//	 * @return String 当前时间字符串
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static String getYerterdayOfDateByFormat(String p_format) {
//		Calendar cal = Calendar.getInstance();		
//		cal.add(Calendar.DATE, -1);
//		Date time = cal.getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat(p_format);
//		String dateStr = sdf.format(time);		
//		return dateStr;
//	}
//	/**
//	 * 获取指定日期格式系统日期的字符型日期
//	 * 
//	 * @param p_format
//	 *            日期格式 格式1:"yyyy-MM-dd" 格式2:"yyyy-MM-dd hh:mm:ss EE"
//	 *            格式3:"yyyy年MM月dd日 hh:mm:ss EE" 说明: 年-月-日 时:分:秒 星期 注意MM/mm大小写
//	 * @return String 系统时间字符串
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static String getSystemOfDateByFormat(String p_format) {
//		long time = System.currentTimeMillis();
//		Date d2 = new Date();
//		Date d = new Date(time);
//		SimpleDateFormat sdf = new SimpleDateFormat(p_format);
//		String dateStr = sdf.format(d);
//		return dateStr;
//	}
//
//	/**
//	 * 获取字符日期一个月的天数
//	 * 
//	 * @param p_date
//	 * @return 天数
//	 * @author zhuqx
//	 */
//	public static long getDayOfMonth(Date p_date) throws ParseException {
//		int year = getYearOfDate(p_date);
//		int month = getMonthOfDate(p_date) - 1;
//		int day = getDayOfDate(p_date);
//		int hour = getHourOfDate(p_date);
//		int minute = getMinuteOfDate(p_date);
//		int second = getSecondOfDate(p_date);
//		Calendar l_calendar = new GregorianCalendar(year, month, day, hour,
//				minute, second);
//		return l_calendar.getActualMaximum(l_calendar.DAY_OF_MONTH);
//	}
//
//	// -----------------获取指定月份的第一天,最后一天
//	// ---------------------------------------------------------------------------
//	/**
//	 * 获取指定月份的第一天
//	 * 
//	 * @param p_strDate
//	 *            指定月份
//	 * @param p_formate
//	 *            日期格式
//	 * @return String 时间字符串
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static String getDateOfMonthBegin(String p_strDate, String p_format)
//			throws ParseException {
//		java.util.Date date = toUtilDateFromStrDateByFormat(p_strDate, p_format);
//		return toStrDateFromUtilDateByFormat(date, "yyyy-MM") + "-01";
//	}
//
//	/**
//	 * 获取指定月份的最后一天
//	 * 
//	 * @param p_strDate
//	 *            指定月份
//	 * @param p_formate
//	 *            日期格式
//	 * @return String 时间字符串
//	 * @author zhuqx
//	 * @Date: 2006-10-31
//	 */
//	public static String getDateOfMonthEnd(String p_strDate, String p_format)
//			throws ParseException {
//		java.util.Date date = toUtilDateFromStrDateByFormat(
//				getDateOfMonthBegin(p_strDate, p_format), p_format);
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//		calendar.add(Calendar.MONTH, 1);
//		calendar.add(Calendar.DAY_OF_YEAR, -1);
//		return toStrDateFromUtilDateByFormat(calendar.getTime(), p_format);
//	}
	
	
	/**
	 * 返回昨天时间的字符串	 
	 * @param p_strDate
	 *            指定月份
	 * @param p_formate
	 *            日期格式
	 * @return String 时间字符串
	 * @author zhuqx
	 * @Date: 2006-10-31
	 */
	public static String getYerterdayOfDateByFormat(String p_format){
		Calendar cal = Calendar.getInstance();		
		cal.add(Calendar.DATE, -1);
		Date time = cal.getTime();
		String str = new SimpleDateFormat(p_format).format(time);
		if (str.length() >= 10) {
			str = str.substring(0, 10);
		}
		return str;
	}
	/**
	 * 返回当前时间的字符串	 
	 * @param p_strDate
	 *            指定月份
	 * @param p_formate
	 *            日期格式
	 * @return String 时间字符串
	 * @author zhuqx
	 * @Date: 2006-10-31
	 */
	public static String getNowOfDateByFormat(String p_format){
		Calendar cal = Calendar.getInstance();		
		cal.add(Calendar.DATE, 0);
		Date time = cal.getTime();
		String str = new SimpleDateFormat(p_format).format(time);
		if (str.length() >= 10) {
			str = str.substring(0, 10);
		}
		return str;
	}
}