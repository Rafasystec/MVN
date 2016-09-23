package br.com.barcadero.core.tests.util;

import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;

public class TestDateAPI {
	public static void main(String... arg){
		data();
		monthDay();
	}
	
	public static void data() {
		LocalDateTime now = LocalDateTime.of(2014,12,15,13, 58);
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getDayOfYear());
		System.out.println(now.getHour());
		System.out.println(now.getMinute());
		System.out.println(now.getYear());
		System.out.println(now.getDayOfWeek());
		System.out.println(now.getMonthValue());
		System.out.println(now.getMonth());
	}
	
	public static void monthDay(){
		MonthDay  day1 = MonthDay.of(1, 1);
		MonthDay  day2 = MonthDay.of(1, 2);
		
		System.out.println(day1.isAfter(day2));
		System.out.println(day1.isBefore(day2));
	}

}
