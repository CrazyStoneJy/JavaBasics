package chapter6;

/**
 * Created by crazystone on 17-8-21.
 */
public class A {


    static {
        System.out.println("static block A");
    }

    {
        System.out.println("common block A");
    }

    A(int a) {
        System.out.println("A");
    }

}
