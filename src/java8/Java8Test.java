package java8;

import io.utils.Logs;

/**
 * Created by crazystone on 18-2-14.
 */
public class Java8Test {

    public static void main(String... args) {
        Foo foo = new FooImpl();
        Logs.l(foo.foo());
        Logs.l(new Foo(){}.foo());
        Logs.l(new Child(){}.foo());


    }

}
