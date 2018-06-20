package nio.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by crazystone on 18-6-14.
 */
public class PrintRunnable implements Runnable {

    private String name;
    private int number;

    public PrintRunnable(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(number);
    }
}
