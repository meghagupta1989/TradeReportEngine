/**
 * 
 */
package com.trade.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author megha
 *
 */

public class Utils {
	
	
	/**
	 * @param date
	 * @return
	 */
	public static int getDayOfWeek(Date date) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		return dayOfWeek;
	}
	
	/**
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date getNextWorkingDay(Date date, int amount) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		c.add(Calendar.DAY_OF_MONTH, amount);
		
		return c.getTime();
	}
	
	public static String getFormattedBigDecimalValue(BigDecimal input) {
		final NumberFormat numberFormat = NumberFormat.getNumberInstance(java.util.Locale.US);
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);
		return numberFormat.format(input);
	} 
	
}
