package reflection;

/**
 * Created by crazystone on 18-2-14.
 */
public interface Foo {

    void foo();

    boolean isFirst();

    String getString(String name);

    default String func() {
        return "";
    }

}
