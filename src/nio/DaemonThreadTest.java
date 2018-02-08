package nio;

import io.utils.Logs;
import nio.Utils.Threads;

/**
 * 当所有线程均为守护线程时候(没有任何User Thread)，jvm退出
 * Created by crazystone on 18-2-2.
 */
public class DaemonThreadTest {

    public static void main(String... args) {

        runUserThread();
        writeFileWithDaemon();
        Logs.l(Thread.currentThread().getName() + "-> do something");

        // jvm的一个退出的一个回调接口
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                super.run();
                Logs.l("jvm shutdown");
            }
        });

    }

    private static void writeFileWithDaemon() {

        Thread thread = new Thread() {
            @Override
            public void run() {
//                super.run();
                // 设置守护线程的延迟,如果守护线程在运行时发现没有其他存活用户线程,就直接退出jvm
                Threads.sleep(2);
                Logs.l("run daemon thread");
            }
        };
        thread.setDaemon(true);
        thread.start();

    }


    private static void runUserThread() {

        Thread thread = new Thread() {
            @Override
            public void run() {
//                super.run();
                // 设置用户线程的一个延时操作,
                Threads.sleep(3);
                Logs.l("run user thread");
            }
        };
        thread.start();

    }


}
