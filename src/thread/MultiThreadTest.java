package thread;

import io.utils.Logs;

import java.util.concurrent.*;

/**
 * Created by crazystone on 17-10-18.
 */
public class MultiThreadTest {

    public static void main(String... args) {

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
//        service.execute();


    }

    private class FutureTest implements Future {

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public Object get() throws InterruptedException, ExecutionException {
            return null;
        }

        @Override
        public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }
    }


    public class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public void dosomething() {
        }
    }

    public class Child extends Person {

        public Child(String name) {
            super(name);
        }

        @Override
        public void dosomething() {
            Logs.l("play");
        }
    }

    public class Parent extends Person {

        public Parent(String name) {
            super(name);
        }

        @Override
        public void dosomething() {
            Logs.l("work");
        }
    }

    public <T> void parse(){}


}
