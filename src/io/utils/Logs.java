package io.utils;

/**
 * Created by crazystone on 17-8-1.
 */
public class Logs {

    public static void l(String message) {
        System.out.println(message);
    }

    public static void l(Object obj) {
        if (obj.getClass().isInstance(String.class)) {
            l((String) obj);
        } else {
            l(obj.toString());
        }
    }


}
