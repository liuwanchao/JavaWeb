package com.zretc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //初始定义的格式
    private static final String formate1="yyyy-MM-dd";
    private static final String formate2="yyyy-MM-dd HH:mm:ss";

    private static SimpleDateFormat sdf=new SimpleDateFormat(formate1);

    /**
     * 时间转字符串
     * @param date
     * @return
     */
    public static String dateToStr(Date date){
        String str=sdf.format(date);
        return str;
    }

    /**
     * 字符串转时间
     * @param str
     * @return
     */
    public static Date strToDate(String str){
        Date date= null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
