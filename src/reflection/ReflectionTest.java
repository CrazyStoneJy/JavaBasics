package reflection;

import io.utils.Logs;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Created by crazystone on 18-2-14.
 */
public class ReflectionTest {

    public static void main(String... args) {

        methodTest();

    }

    private static void methodTest() {
        Class cls = null;
        try {
            cls = Class.forName("reflection.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields = cls.getDeclaredFields();
        Method[] methods = cls.getDeclaredMethods();

        MyClass myClass = new MyClass();
        try {
            Method method = cls.getDeclaredMethod("getCount");
            Logs.l("method parameter count:" + method.getParameterCount());
            Logs.l("method modifiers:" + method.getModifiers());
            Logs.l("method return type" + method.getGenericReturnType().getTypeName());
            Logs.l("method accessible" + method.isAccessible());
            Logs.l("method value:" + method.getDefaultValue());
            method.setAccessible(true);
            Object obj = method.invoke(myClass);
            Logs.l(obj);
//            Object defaultValue = method.getDefaultValue();
//            Logs.l(defaultValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


//        MyClass myClass = new MyClass();

//        for (Field field : fields) {
//            Logs.l(field.getName());
//            try {
//                Object obj = field.get(myClass);
//                Logs.l(obj);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//
//        Logs.l(">>>>>>>>>>>>>>>>");
//
//        for (Method method : methods) {
//            Logs.l(method.getName());
//        }
    }


}
