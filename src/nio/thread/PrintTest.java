package nio.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by crazystone on 18-6-14.
 */
public class PrintTest {

    public static void main(String... args) {

        ExecutorService service = Executors.newCachedThreadPool();

        Runnable runnable1 = new PrintRunnable("t1",1);
        Runnable runnable2 = new PrintRunnable("t2",2);
        service.execute(runnable1);
        service.execute(runnable2);


    }


}
