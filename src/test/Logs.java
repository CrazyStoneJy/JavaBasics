package test;

/**
 * Created by crazystone on 17-7-27.
 */
public class Logs {

    public static void l(String message) {
        System.out.println(message);
    }

    public static void l(Object object) {
        if (object instanceof String) {
            l((String) object);
        } else {
            l(object.toString());
        }
    }


}
