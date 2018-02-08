package nio;

import io.utils.Logs;
import nio.Utils.Threads;
import okhttp3.Response;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 死锁主要是多个临界资源,多个线程竞争资源,一个完整的流程需要持有全部临界资源,但是他们都只有一部分,不想让所以就形成了死锁.
 * 解决方法:尽量在java所用synchronized嵌套锁.
 * Created by crazystone on 18-2-7.
 */
public class DeadLockTest {

    public static void main(String... args) {

        ExecutorService service = Executors.newCachedThreadPool();
        Runnable thing1 = new DoSomeThing("obj1", "obj2");
        Runnable thing2 = new DoSomeThing("obj2", "obj1");
        service.execute(thing1);
        service.execute(thing2);
        service.shutdown();

    }

    private static class DoSomeThing implements Runnable {

        private String obj1, obj2;

        public DoSomeThing(String obj1, String obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public void run() {
            synchronized (obj1) {
                Logs.l("获取了" + obj1);
                Threads.sleep(1);
                synchronized (obj2) {
                    Logs.l("获取了" + obj2);
                }
            }
        }
    }


}
