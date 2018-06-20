package reflection.proxy;

import io.utils.Logs;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by crazystone on 18-6-15.
 */
public class PrintTest {

    public static void main(String... args) throws NoSuchFieldException, IllegalAccessException {

        PrintFactory factory = new PrintFactory();

        modifyCount(factory);
        Logs.l(factory.count);

        hookPrintMethod(factory);
        factory.print();


    }

    private static void hookPrintMethod(PrintFactory factory) {
        Field field = null;
        try {
            field = factory.getClass().getDeclaredField("printer");
            field.setAccessible(true);
            IPrint printer = (IPrint) field.get(factory);
            InvocationHandler handler = new PrintHandler(printer);
            IPrint printProxy = (IPrint) Proxy.newProxyInstance(printer.getClass().getClassLoader(),
                    printer.getClass().getInterfaces(),
                    handler);

            field.set(factory, printProxy);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void modifyCount(PrintFactory printFactory) throws NoSuchFieldException, IllegalAccessException {
        Field field = printFactory.getClass().getDeclaredField("count");
        field.setAccessible(true);
        field.set(printFactory, 3);

    }

    private static void printInterface(Class cls) {
        for (Class<?> inter : cls.getInterfaces()) {
            Logs.l(inter.getSimpleName());
        }
    }

}
