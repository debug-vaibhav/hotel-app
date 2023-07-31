package com.ideas.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DateUtil {
    public static int getNumberOfWeekdaysBetween(LocalDate from, LocalDate to){
        List<LocalDate> dates = from.datesUntil(to).collect(Collectors.toList());
        return dates.size() - (int) dates.stream().filter(DateUtil::isWeekend).count();
    }

    public static int getNumberOfWeekendsBetween(LocalDate from, LocalDate to){
        return (int) from.datesUntil(to).filter(DateUtil::isWeekend).count();
    }

    private static boolean isWeekend(LocalDate date){
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
