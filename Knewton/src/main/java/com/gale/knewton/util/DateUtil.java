package com.gale.knewton.util;

public class DateUtil {
	
	 public static String[] splitIntoMonthDayAndYear(String date)
	 {
	  String[] parts = date.split("[.]");
	  return parts;
	 }

	 public static String getNameOfTheMonth(int month)
	 {
	  return monthName[month - 1];
	 }

	 private static final String[] monthName = {"January",
	   "February",
	   "March",
	   "April",
	   "May",
	   "June",
	   "July",
	   "August",
	   "September",
	   "October",
	   "November",
	   "December"
	 };

	}


