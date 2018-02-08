package nio;

import io.utils.Logs;
import nio.Utils.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by crazystone on 18-2-7.
 */
public class LockTest {

    public static void main(String... args) {

        ExecutorService service = Executors.newFixedThreadPool(5);
        Runnable task = new DoSomething("asd");
        for (int i = 0; i < 5; i++) {
            service.execute(task);
        }
        service.shutdown();

    }

    private static class DoSomething implements Runnable {

        volatile int count = 0;
        String name;
        Lock lock = new ReentrantLock();

        private DoSomething(String name) {
            this.name = name;
        }

        @Override
        public void run() {
          doIt();
        }

        private void doIt(){
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    add();
                    Logs.l(Thread.currentThread().getName() + "->" + getCount());
                }
            }catch (Exception e){
                Logs.l("occur exception");
            }finally {
                lock.unlock();
            }
        }

        private int getCount() {
//            Threads.sleep(100L);
            return count;
        }

        private void setCount(int count) {
            this.count = count;
        }

        private void add() {
            int number = getCount();
            setCount(number + 1);
        }

    }


}
