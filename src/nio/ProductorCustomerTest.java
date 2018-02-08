package nio;

import io.utils.Logs;
import nio.Utils.Threads;
import sun.rmi.runtime.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者问题
 * Created by crazystone on 18-2-7.
 */
public class ProductorCustomerTest {

    public static void main(String... args) {

        ExecutorService service = Executors.newFixedThreadPool(8);
        Factory factory = new Factory();
//        Customer customer = new Customer(factory);
        Producer producer = new Producer(factory);
        service.execute(producer);
        Customer[] customers = new Customer[3];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(factory);
            service.execute(customers[i]);
        }
        Threads.sleep(5);
        producer.cancel();
        service.shutdown();

    }

    private static class Factory {
        Lock lock = new ReentrantLock();
        Condition emptySemaphore = lock.newCondition();
        Condition fullSemaphore = lock.newCondition();
        int MAX_NUMBER = 10, MIN_NUMBER = 0;
        volatile int count = 0;

        private void produce() {
            try {
                lock.lock();
                if (count >= MAX_NUMBER) {
                    Logs.l("仓库已经满了快来消费吧...");
                    fullSemaphore.await();
                }
                Threads.sleep(100L);
                count++;
                Logs.l("正在生产...");
                emptySemaphore.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        private synchronized void consume() {
            try {
                lock.lock();
                if (count <= MIN_NUMBER) {
                    Logs.l(Thread.currentThread().getName() + "仓库没货了,快来生产吧");
                    emptySemaphore.await();
                }
//                Threads.sleep(100L);
                Logs.l(Thread.currentThread().getName() + "正在消费,目前还有:" + count);
                count--;
                fullSemaphore.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


    }

    private static class Customer implements Runnable {

        Factory factory;
        boolean hasNext = true;

        private Customer(Factory factory) {
            this.factory = factory;
        }

        @Override
        public void run() {
            while (hasNext) {
                factory.consume();
            }
        }

        private void cancel() {
            this.hasNext = false;
        }

    }

    private static class Producer implements Runnable {

        Factory factory;
        boolean hasNext = true;

        public Producer(Factory factory) {
            this.factory = factory;
        }

        @Override
        public void run() {
            while (hasNext) {
                factory.produce();
            }
        }

        private void cancel() {
            this.hasNext = false;
        }


    }


}
