package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by crazystone on 17-9-11.
 */
public class ThreadTest {
    public static void main(String... args) {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

        for (int i = 0; i < 20; i++) {
            int pos = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 5));
                        Logs.l(pos + " begin");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Logs.l(pos + " finished");
                    }
                }
            });
        }

        service.shutdown();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (service.isTerminated()) {
                        Logs.l("所有任务完成");
                        break;
                    }
                }
            }
        }.start();


    }

    public static void print(int i) {
        System.out.println("number:" + i);
    }

}
