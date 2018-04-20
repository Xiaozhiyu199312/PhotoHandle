package com.wqdata.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public String formatDate(Date date, String format) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			return formater.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	public Date parseDate(String tranDate, String format) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			return formater.parse(tranDate);
		} catch (Exception e) {
			return null;
		}
	}

}
