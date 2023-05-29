package com.cgi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static Date getDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getDBDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		return formatter.format(date);
	}
}
