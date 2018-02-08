package chapter6;

/**
 * Created by crazystone on 17-8-21.
 */
public class B {

    static {
        System.out.println("static block B");
    }

    {
        System.out.println("common block B");
    }

    B() {
        System.out.println("B");
    }

}
