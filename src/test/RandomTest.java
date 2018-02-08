package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by crazystone on 17-9-25.
 */
public class RandomTest {

    public static void  main(String... args){
        List<Random> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(new Random());
        }
        for(Random random :list){
            Logs.l(random.nextInt());
        }
    }


}
