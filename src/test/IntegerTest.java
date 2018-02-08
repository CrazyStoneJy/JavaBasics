package test;

/**
 * Created by crazystone on 18-2-4.
 */
public class IntegerTest {

    public static void main(String... args) {

        int number = 128;
        Integer a = number;
        Integer b = number;
        Integer c = number;
        Integer.valueOf(number);
        Logs.l("a==b:" + (a.equals(b)) + ",a==c:" + (a == c) + ",b==c:" + (b == c));

    }


}
