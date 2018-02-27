package java8;

/**
 * Created by crazystone on 18-2-14.
 */
public interface Child extends Foo {

    @Override
    default String foo() {
        return "Child foo";
    }
}
