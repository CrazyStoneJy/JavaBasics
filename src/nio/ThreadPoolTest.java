package nio;

import io.utils.Logs;
import nio.Utils.Threads;
import sun.rmi.runtime.Log;
import test.Cal;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by crazystone on 18-2-2.
 */
public class ThreadPoolTest {


    public static void main(String... args) {

//        testFixed();
//        testCache();
        testFuture();

    }


    private static void testFuture() {
        ExecutorService service = Executors.newCachedThreadPool();
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {

                Logs.l("start");
                Thread.sleep(5000);

                Logs.l("end");
                return "hello world";
            }
        };
        FutureTask<String> task = new FutureTask<>(callable);
        service.execute(task);

        try {
            Thread.sleep(10);
            Logs.l("isCanceled:" + task.isCancelled());
            // cancel(true) true会将正在运行的线程中断,false会使正在运行的任务运行完后中断
            task.cancel(true);
            Logs.l("isCanceled:" + task.isCancelled());
            Logs.l("isDone:" + task.isDone());
            if (!task.isCancelled()) {
                Logs.l(task.get());
            } else {
                Logs.l("task has been canceled");
            }
        } catch (InterruptedException e) {
            Logs.l(e);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }


    private static void testFixed() {
        int cpu_core_number2 = Runtime.getRuntime().availableProcessors();
        Logs.l(cpu_core_number2);
        ExecutorService service = Executors.newFixedThreadPool(cpu_core_number2);
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    Logs.l(Threads.getName());
                }
            });
        }
        service.shutdown();

    }

    private static void testCache() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    Logs.l(Threads.getName());
                    Threads.sleep(5);
                }
            });
        }
        service.shutdown();
    }


    private static void test() {
        Random random = new Random();
        ExecutorService[] services = new ExecutorService[2];
        for (int i = 0; i < services.length; i++) {
            services[i] = Executors.newFixedThreadPool(
                    Runtime.getRuntime().availableProcessors() * 2);
        }


        for (int i = 0; i < 5; i++) {
            int pos = i;
            services[random.nextInt(2)].execute(() -> {
                Logs.l("thread name:" + Thread.currentThread().getName() + ";value:" + pos);
            });
        }

        for (ExecutorService service : services) {
            service.shutdown();
        }
    }

    static class MyThreadFactory implements ThreadFactory {

        private volatile AtomicInteger pId;
        private volatile AtomicInteger threadId = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new MyThread();
            int current = threadId.get();
            thread.setName("test" + threadId.addAndGet(current + 1));
            return thread;
        }
    }


    static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            Logs.l(">>come in");
        }
    }

}
