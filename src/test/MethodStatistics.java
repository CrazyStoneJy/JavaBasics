package test;

import io.utils.Logs;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by crazystone on 17-8-10.
 */
public class MethodStatistics {

    private static int count = 0;

    public static void main(String... args) {
        Logs.l(getMethodNumber("/home/crazystone/FileTest/java"));
    }

    public static int getMethodNumber(File root) {
        if (!root.exists()) return 0;
        if (root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null && files.length > -0) {
                for (File file : files) {
                    getMethodNumber(file);
                }
            }
        } else {
            return getMethod(root);
        }
        return count;
    }

    public static int getMethod(File file) {
        if (file.getAbsolutePath().lastIndexOf(".class") != -1) {
            try {
                String className = file.getName();
                Logs.l("name:"+file.getName());
                Class cls = Class.forName(className);
                Method[] methods = cls.getDeclaredMethods();
                count += methods.length;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return count;
            }
        }
        return count;
    }


    public static int getMethodNumber(String path) {
        return getMethodNumber(new File(path));
    }

}
