package nio;

import io.utils.Logs;
import nio.Utils.Threads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by crazystone on 18-2-3.
 */
public class CASTest {

    AtomicReference af = null;

    public static void main(String... args) {

        Runnable r = new AddRunnable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();

    }

    static class AddRunnable implements Runnable {

        //        int count = 0;
        AtomicInteger count = new AtomicInteger(0);

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                add();
                print();
            }
        }


        private void add() {
//            int number = get();
//            Threads.sleep(100L);
            int number = count.get();
//            Threads.sleep(100L);
            count.compareAndSet(number, number + 1);
//            count = ++number;

        }

//        private int get() {
//            Threads.sleep(100L);
//            return count.get();
//        }


        private void print() {
            Logs.l(count);
        }
    }

}
