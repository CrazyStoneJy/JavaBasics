package test;

import java.math.BigInteger;
import java.util.Vector;

/**
 * Created by crazystone on 17-8-14.
 */
public class Cal {

    Vector vector;
    BigInteger bigInteger;

    /***
     * @see Maths#appendZero(int, int)
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        return a + b;
    }


    public static void increase() {
        int i = 0;
        System.out.println("i:" + i);
        System.out.println("++i:" + ++i);
        System.out.println("i++:" + i++);
        System.out.println("i--:" + i--);
        System.out.println("--i:" + --i);
    }

    public static void main(String... args) {
        increase();
    }


}
