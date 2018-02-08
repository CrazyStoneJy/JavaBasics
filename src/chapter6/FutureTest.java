package chapter6;

import io.utils.Logs;

import java.util.concurrent.*;

/**
 * Created by crazystone on 17-8-30.
 */
public class FutureTest {

    public static void main(String... args) {
        Thread thread;
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        FutureTask<Boolean> task = new FutureTask<Boolean>(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    System.out.println("i:" + i);
                }
                Thread.sleep(3000);
                return true;
            }
        })

        {
            @Override
            protected void done() {
                Logs.l("this task has done");
            }
        };

        executor.execute(task);
        try {
            boolean isOver = task.get(5, TimeUnit.SECONDS);
            Logs.l("execute is finished:" + isOver);
            Logs.l(">>>>>>>>>>>>>");

        } catch (InterruptedException e) {
            e.printStackTrace();
            task.cancel(true);
        } catch (ExecutionException e) {
            e.printStackTrace();
            task.cancel(true);
        } catch (TimeoutException e) {
            e.printStackTrace();
            task.cancel(true);
        } finally {
            executor.shutdown();
        }

    }


}
