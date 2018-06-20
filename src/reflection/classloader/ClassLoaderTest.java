package reflection.classloader;

import sun.misc.Launcher;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by crazystone on 18-6-19.
 */
public class ClassLoaderTest {

    public static void main(String... args) {

        // 利用classloader动态加载class
        ClassLoader classLoader = new DiskClassLoader("/home/crazystone");
        try {
            Class c = classLoader.loadClass("Test");
            if (c != null) {
                Object obj = c.newInstance();
                Method method = c.getDeclaredMethod("test", null);
                //通过反射调用Test类的say方法
                method.invoke(obj, null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}
