package reflection.basic;

import io.utils.Logs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

/**
 * Created by crazystone on 18-6-19.
 */
public class PersonTest {

    public static void main(String... args) {
//        differentWrap();
        test();
    }

    private static void differentWrap() {
        Class c0 = int.class;
        Class c1 = Integer.class;

        ClassLoader classLoader;

        Logs.l(c0.getName());
        Logs.l(c1.getName());

    }

    private static void test() {
        try {
            Class<Person> p = (Class<Person>) Class.forName("reflection.basic.Person");
            // 有参数的构造函数
            Constructor<Person> constructor = p.getConstructor(String.class, Integer.TYPE, int.class, float.class);
            Person person = constructor.newInstance("zhangsan", 23, 175, 65F);

            person.eat();
            person.earnMoney();

            Class cls = person.getClass();
            // 获取class和继承interface中的public的属性
            Field[] fields1 = cls.getFields();
            printField(fields1);
            // 获取该class中声明的所有属性,包括(private,protected,friendly)
            Field[] fields = cls.getDeclaredFields();
            printField(fields);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void printField(Field[] fields) {
        for (Field field : fields) {
            System.out.print(field.getName());
            System.out.print(",");
        }
        System.out.println();
    }

}
