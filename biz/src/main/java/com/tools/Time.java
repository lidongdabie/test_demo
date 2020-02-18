package com.tools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author jin wei
 *
 */
public class Time {

	/**
	 * 获取当前时间戳
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public Timestamp getCurrentTimestamp(){
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		Timestamp currentTimestamp = new Timestamp(now.getTime());
		return currentTimestamp;
	}
	
	/**
	 * 获取UNIX当前时间戳
	 * 
	 * @return
	 */
	public static long getUnixTimestamp(){
		return System.currentTimeMillis() / 1000L;
	}

}
