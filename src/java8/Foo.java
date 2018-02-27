package java8;

/**
 * Created by crazystone on 18-2-14.
 */
public interface Foo {

    // java1.8 可以有默认方法
    default String foo() {
        return "foo";
    }

}
