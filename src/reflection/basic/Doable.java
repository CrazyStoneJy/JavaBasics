package reflection.basic;

/**
 * Created by crazystone on 18-6-19.
 */
public interface Doable {

    String tag = "tag";

    default void doSomeThing() {
        System.out.println("this is default method function");
    }

}
