package com.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User: LTT
 * Date: 4/17/14
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateUtils {
    protected static final SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
    protected static final SimpleDateFormat dayChineseFormat = new SimpleDateFormat("yyyy年MM月dd日");
    protected static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String BEGIN_TIME = " 00:00:00";
    private static final String END_TIME = " 23:59:59";

    /**
     * 设置string日期为0点
     * @param date string 'yyyy-MM-dd'
     * @return java.util.Date Date 'yyyy-MM-dd 00:00:00'
     * @throws ParseException
     */
    public static Date formatBeginTime(final String date) throws ParseException {
        return  timeFormat.parse(date + BEGIN_TIME);
    }

    /**
     * 设置string日期为23:59:59
     * @param date string 'yyyy-MM-dd'
     * @return java.util.Date Date 'yyyy-MM-dd 23:59:59'
     * @throws ParseException
     */
    public static Date formatEndTime(final String date) throws ParseException {
        return  timeFormat.parse(date + END_TIME);
    }

    /**
     * 获取今天0点
     * @return
     */
    public static Date getTodayBegin() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static boolean isSameDay(final Date d1, final Date d2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    public static Date addMonth(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    public static Date addDay(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static Date formatDate(String date) throws ParseException {
        return dayFormat.parse(date);
    }

    public static Date makeDate(int year, int month, int day){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DATE, day);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    /**
     * 获得年
     * @param date
     * @return
     */
    public static int getYear(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.YEAR);
    }

    /**
     * 获得月
     * @param date
     * @return
     */
    public static int getMonth(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 获得一个月中的第几天
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得一个星期中的第几天
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 得到一个月中有多少天
     * @param year
     * @param month
     * @return
     */
    public static int getMonthDayCount(int year, int month){
        if (month < 0){
            return 0;
        }

        if (month > 11){
            return 0;
        }

        int[] monthDays = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year%4 == 0 && year%100 != 0) || year%400 == 0)
            monthDays[1]++;

        return monthDays[month];
    }

    /**
     * 获得一个月的第一天
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date){

        date = dateFormat(date, 0, 0, 0);

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.set(Calendar.DATE, 1);
        return c.getTime();
    }

    /**
     * 获得一个月的最后一天
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date){

        date = dateFormat(date, 0, 0, 0);

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        c.set(Calendar.DATE, getMonthDayCount(year, month));
        return c.getTime();
    }

    /**
     * 得到2个日期之间相隔的天数
     * @param beginTime
     * @param endTime
     * @return
     */
    public static int getDaysBetween(Date beginTime, Date endTime) {

        if (beginTime.after(endTime)){
            Date tmpTime = beginTime;
            beginTime = endTime;
            endTime = tmpTime;
        }

        beginTime = dateFormat(beginTime, 0, 0, 0);
        endTime = dateFormat(endTime, 0, 0, 0);

        return (int)((endTime.getTime() - beginTime.getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     * 格式化日期
     * @param date
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static Date dateFormat(Date date, int hour, int minute, int second){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), hour, minute, second);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获得后一天
     * @param date
     * @return
     */
    public static Date getNextDay(Date date){
        return getNextNDay(date, 1);
    }

    /**
     * 获得字符串日期后一天
     * @param date
     * @return
     */
    public static String getStringDateNextDay(String date) throws ParseException {
        return dayFormat.format(getNextDay(formatDate(date)));
    }

    /**
     * 获得后N天
     * @param date
     * @return
     */
    public static Date getNextNDay(Date date, int days){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + days);
        return c.getTime();
    }

    /**
     * 下一个足月时间
     * @param date
     * @return
     */
    public static Date getNextMonth(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(c.get(Calendar.YEAR)
                , c.get(Calendar.MONTH)+1
                , c.get(Calendar.DATE)-1
                , c.get(Calendar.HOUR)
                , c.get(Calendar.MINUTE)
                , c.get(Calendar.SECOND));

        return c.getTime();
    }

    /**
     * 下一个足年时间
     * @param date
     * @return
     */
    public static Date getNextYear(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(c.get(Calendar.YEAR)+1
                , c.get(Calendar.MONTH)
                , c.get(Calendar.DATE)-1
                , c.get(Calendar.HOUR)
                , c.get(Calendar.MINUTE)
                , c.get(Calendar.SECOND));

        return c.getTime();
    }

    /**
     * 转化成yyyy-MM-dd
     * @param date
     * @return
     */
    public static String getStringDayDate(Date date){
        return dayFormat.format(date);
    }

    public static String getDateTimeString(Date date) {
        return timeFormat.format(date);
    }

    /**
     * 转化成yyyy年MM月dd日
     * @param date
     * @return
     */
    public static String getChineseDate(Date date){
        return dayChineseFormat.format(date);
    }



    //获取从1900年1月1日到今日的天数
    public static int getDays() {
        Date now = new Date();
        Date start = new Date(0, 0, 1);
        int days = (int) ((now.getTime() - start.getTime()) / 86400000);
        return days;
       // System.out.println(days);
    }


}