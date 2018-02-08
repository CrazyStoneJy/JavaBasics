package nio.Utils;

import sun.util.resources.cldr.bs.TimeZoneNames_bs;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by crazystone on 18-2-2.
 */
public class Threads {

    public static void sleep(int second) {
        sleep(second * 1000, TimeUnit.SECONDS);
    }

    public static void sleep(long millis) {
        sleep(millis, TimeUnit.MILLISECONDS);
    }

    public static void sleep(long millis, TimeUnit timeUnit) {
        if (timeUnit == TimeUnit.MILLISECONDS) {
            _sleep(millis);
        } else if (timeUnit == TimeUnit.SECONDS) {
            _sleep(millis);
        } else if (timeUnit == TimeUnit.MICROSECONDS) {
            _sleep(millis);
        } else if (timeUnit == TimeUnit.MINUTES) {
            _sleep(millis);
        } else {
            throw new RuntimeException("has not this time unit");
        }
    }

    private static void _sleep(long millisSecond) {
        try {
            Thread.sleep(millisSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getName() {
        return Thread.currentThread().getName();
    }


}
