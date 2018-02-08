package nio;

import io.utils.Logs;
import nio.Utils.Threads;

import java.util.concurrent.ExecutorService;

/**
 * Created by crazystone on 18-2-4.
 */
public class InterruptTest {

    public static void main(String... args) {

        MyThread thread = new MyThread(false);
        thread.start();
        printInterrupt(thread);
        thread.interrupt();
        printInterrupt(thread);
        Threads.sleep(1);
        printInterrupt(thread);


    }

    private static void printInterrupt(Thread thread) {
        Logs.l("thread interrupt:" + thread.isInterrupted());
    }

    private static class MyThread extends Thread {

        private boolean flag;

        private MyThread(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
//            super.run();
            try {
                if (this.flag) {
                    Logs.l("just return");
                    return;
                }
//                Threads.sleep(2);
                Logs.l(">>>>run my thread");
            } catch (Exception e) {
                Logs.l("thread interrupt");
            }
        }
    }


}
