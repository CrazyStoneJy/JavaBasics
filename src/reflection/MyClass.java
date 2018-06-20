package reflection;

import io.utils.Logs;

/**
 * Created by crazystone on 18-2-14.
 */
public class MyClass {

    public static String name = "";
    public boolean isActive;
    private int count = 5;


    private int getCount(String foo, int a, boolean c) {
        return count;
    }

    public void test() {
        Logs.l("test");
    }

    private void func() {
        Logs.l("function");
    }

    public String doSome(String name) {
        return "do some";
    }


}
