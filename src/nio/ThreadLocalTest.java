package nio;

import io.utils.Logs;

/**
 * Created by crazystone on 18-2-5.
 */
public class ThreadLocalTest {

    public static void main(String... args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("test");
        String test = local.get();
        Logs.l(test);
    }


}
