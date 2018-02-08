package test;

import java.util.Properties;

/**
 * Created by crazystone on 17-8-21.
 */
public class RuntimeTest {

    public static void main(String... args){
//        Properties p = System.getProperties();
//        p.list(System.out);

        Runtime r = Runtime.getRuntime();
        System.out.println("r:"+r.freeMemory());


    }

}
