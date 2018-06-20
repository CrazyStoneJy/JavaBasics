package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by crazystone on 18-3-8.
 */
public class Dates {

    static DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getNowData() {
        long now = System.currentTimeMillis();
        return DEFAULT_DATE_FORMAT.format(now);
    }

}
