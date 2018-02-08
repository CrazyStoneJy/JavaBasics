package classloader;

import io.utils.Logs;
import sun.misc.Launcher;

/**
 * Created by crazystone on 18-2-2.
 */
public class ClassLoaderTest {

    public static void main(String... args) {


        Logs.l(System.getProperty("sun.boot.class.path"));

        Logs.l(System.getProperty("java.class.path"));

        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        Logs.l(loader.toString());

    }


}
