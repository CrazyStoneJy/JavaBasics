package io.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by crazystone on 17-8-1.
 */
public class Dates {

    public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";

    public static String parseLong2String(long time) {
        Date date = new Date(time);
        return getDateFormat(Y_M_D_H_M_S).format(date);
    }

    public static DateFormat getDateFormat(String format) {
        return new SimpleDateFormat(format, Locale.CHINA);
    }

}
