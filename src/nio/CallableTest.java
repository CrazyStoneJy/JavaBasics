package nio;

import io.utils.Logs;
import nio.Utils.Threads;
import sun.rmi.runtime.Log;

import java.util.concurrent.*;

/**
 * Created by crazystone on 18-2-4.
 */
public class CallableTest {

    public static void main(String... args) {

        Callable<String> callable = new TestCallable();

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(callable);
        try {
            String result = future.get();
            Logs.l("result:" + result + ",isDone:" + future.isDone());
            if (future.isDone()) {
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        Logs.l("another thread is begin");
                    }
                });
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }

    static class TestCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Threads.sleep(2);
            String string = "hello";
            return string;
        }
    }


}
