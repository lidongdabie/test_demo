package com.tools;

import java.awt.Point;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;





/**
 * service共通类
 *
 * @author jinwei
 *
 */
public class IsvCom {

    public static final String DATE_TYPE1 = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_TYPE2 = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String DATE_TYPE3 = "yyyyMMddHHmmssSSS";

    public static final String DATE_TYPE4 = "yyyyMMddHHmmss";

    public static final String DATE_TYPE5 = "yyyy-MM-dd";

    public static final String DATE_TYPE6 = "yy-MM-dd-HH-mm-ss";

    public static final String DATE_TYPE7 = "yyyy-MM-dd HH:mm";

    public static final String DATE_TYPE8 = "yyyyMMdd";

    public static final String DATE_TYPE9 = "yyyy-M-d H:m:s:S";

    public static final String DATE_TYPE10 = "yyyyMMddHHmm";

    public static final String DATE_TYPE11 = "yyyy-M-d H:m:s";

    public static final String DATE_TYPE12 = "yy-MM-dd HH:mm:ss";

    public static final String DATE_TYPE13 = "yyyy/MM/dd HH:mm:ss";

    public static final String DATE_TYPE14 = "MM-dd HH:mm:ss";

    public static final String DATE_TYPE15 = "yyyy年MM月dd日 HH:mm";
    public static final String DATE_TYPE16 = "MM月dd日 HH:mm";

    public static final String DATE_TYPE17 = "yyyyMM";
    public static final String DATE_TYPE18 = "HHmm";
    public static final String DATE_TYPE19 = "HHmmss";
    public static final String DATE_TYPE20 = "HHmmssSSS";

    public static TimeZone timeZoneChina = TimeZone.getTimeZone("Asia/Shanghai");// 获取时区

    public static String getFormatDate(Date date, String toType) {

        try {
            DateFormat dateToFmt = new SimpleDateFormat(toType);
            dateToFmt.setTimeZone(timeZoneChina);
            // 非空检查
            if (date == null) {
                return "";
            } else {
                return dateToFmt.format(date);
            }
        } catch (Exception e) {
            return "";
        }
    }
    public static Date getDateFromStr(String dateStr, String fromType) {

        try {
            DateFormat dateFromFmt = new SimpleDateFormat(fromType);
            dateFromFmt.setTimeZone(timeZoneChina);

            return dateFromFmt.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
