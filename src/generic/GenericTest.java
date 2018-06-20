package generic;

import annotation.Api;
import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider;
import io.utils.Logs;

/**
 * Created by crazystone on 18-3-14.
 */
public class GenericTest {

    public static void main(String... args) {
        Plate<? super Fruit> plate = new Plate<>();
        plate.setFood(new Apple("apple"));
        plate.getFood();
//        Fruit fruit = (Fruit) plate.getFood();
//        if (Apple.class.isInstance(fruit)) {
//            Logs.l(((Fruit) fruit).name);
//        } else {
//            Logs.l(fruit.getClass().getName() + "," + Apple.class.isInstance(fruit));
//        }


    }


}
