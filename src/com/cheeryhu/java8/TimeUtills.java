package com.cheeryhu.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class TimeUtills {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = format.parse("2018-07-18 19:00:01");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(format.parse("2018-07-29 9:00:01"));
        LocalDate localDate = LocalDate.of(date1.getYear(),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));
        LocalDate localDate2 = LocalDate.of(calendar2.get(Calendar.YEAR),calendar2.get(Calendar.MONTH),calendar2.get(Calendar.DATE));
//        long diff = localDate2.toEpochDay() - localDate.toEpochDay();
        long diff = ChronoUnit.DAYS.between(localDate,localDate2);
        System.out.println(diff);
    }
}
