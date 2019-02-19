package com.android.materialdesign.myapplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 【时间显示规则】
 * •  今天发出的内容时间细分；
 * •  10分钟内显示：刚刚；
 * •  1小时内的显示：n分钟前；
 * •  一天内的显示：n小时前；
 * •  昨天之前的显示：月日时分
 * •  跨年的显示：2016-4-10 18:10
 * Created by liangyanqiao on 2017/8/8.
 */
public class TimeUtil {

    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;

    private static final String JUST_NOW = "刚刚";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";


    public static String formatRelativeDate(long strData) {
//        Date messageDate = new Date(strData);
        Calendar calendar = Calendar.getInstance();//获取当前日历对象
        long unixTime = calendar.getTimeInMillis();//获取当前时区下日期时间对应的时间戳
        long earlyMorningTime = getEarlyMorningTime();//当天零点时间戳
        //unixTime=unixTime-TimeZone.getDefault().getRawOffset();//获取标准格林尼治时间下日期时间对应的时间戳
        long delta = unixTime - strData;
        if (delta < 10L * ONE_MINUTE) {// 10 分钟内：刚刚
            return JUST_NOW;
        } else if (delta < ONE_HOUR) {// 1 小时内：n 分钟前
            long seconds = toMinutes(delta);
            return (seconds <= 0 ? 1 : seconds) + ONE_MINUTE_AGO;
        } else if (unixTime > earlyMorningTime && strData > earlyMorningTime) {// 一天内的显示：n小时前
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        } else if (strData < earlyMorningTime && delta < 365L * ONE_DAY) {// 昨天之前的显示：月日时分
            return TimeLong2Date("MM-dd HH:mm", strData);
        } else {
            return TimeLong2Date("yyyy-MM-dd HH:mm", strData);
        }
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 365L;
    }


    public static String TimeLong2Date(String format, long longs) {

        TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");

        Date date = new Date(longs);
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        formatter.setTimeZone(timezone);

        return formatter.format(date);
    }

    /**
     * 获取当天零点时间戳
     *
     * @return
     */
    public static long getEarlyMorningTime() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(calendar.getTimeInMillis());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String showYearString = dateFormatter.format(date);
        return strToDateLong(showYearString + " 00:00");
    }


    public static long strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date strToDate = null;
        try {
            strToDate = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strToDate.getTime();
    }


    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date strToDate = null;
        try {
            strToDate = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strToDate;
    }

}
