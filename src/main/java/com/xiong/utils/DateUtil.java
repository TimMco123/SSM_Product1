package com.xiong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat format;
    static{
        format = new SimpleDateFormat("yyyy-MM-dd");
    }
    public static Date getDateByString(String str){
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
