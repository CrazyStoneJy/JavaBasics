package reflection.proxy;

import io.utils.Logs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by crazystone on 18-6-15.
 */
public class PrintHandler implements InvocationHandler {

    private Object object;

    public PrintHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Logs.l("print start");
        Object result = method.invoke(object, args);
        Logs.l("print end");

        return result;
    }
}
