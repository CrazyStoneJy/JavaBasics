package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by crazystone on 17-8-31.
 */
public class ExecutorTest {

    public static int unitX, unitY;
    int numberA, numberB;


    public static void main(String... args) {


        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        System.out.println("processor:" + Runtime.getRuntime().availableProcessors());
        int rowNumber = 27;
        int columnNumber = 32;
        unitX = rowNumber / 2;
        unitY = columnNumber / 3;

        List<Runnable> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new PrintNumberRunnable("woca" + i, unitX * (i % 2), unitY * (i % 3)));
        }

        for (Runnable r : list) {
            executorService.execute(r);
        }
        executorService.execute(()->{
            Logs.l("asdsa");
        });

        executorService.shutdown();



    }

    private static void printNumber(String name, int startX, int startY) {
        for (int i = startX; i < startX + unitX; i++) {
            for (int j = startY; j < startY + unitY; j++) {
                try {
                    Thread.sleep((long) (Math.random() * 200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + ",i:" + i + ",j:" + j);
            }
        }
    }

    static class PrintNumberRunnable implements Runnable {
        int startX, startY;
        private String name;

        public PrintNumberRunnable(String name, int startX, int startY) {
            this.name = name;
            this.startX = startX;
            this.startY = startY;
        }

        @Override
        public void run() {
            printNumber(name, startX, startY);
        }
    }


}
