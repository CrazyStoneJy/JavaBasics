package nio;

import io.utils.Logs;
import nio.Utils.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore是用来控制同时访问的资源数
 * Created by crazystone on 18-2-7.
 */
public class SemaphoreTest {

    public static void main(String... args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Runnable someThing = new DoSomeThing();

        for (int i = 0; i < 40; i++) {
            service.execute(someThing);
        }

        service.shutdown();
    }

    private static class DoSomeThing implements Runnable {

        Semaphore semaphore = new Semaphore(5);

        @Override
        public void run() {
            try {
                semaphore.acquire();
                Threads.sleep(3);
                Logs.l("do something...");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
