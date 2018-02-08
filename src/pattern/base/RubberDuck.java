package pattern.base;

import io.utils.Logs;
import pattern.base.Duck;

/**
 * 橡胶鸭
 * Created by crazystone on 17-8-14.
 */
public class RubberDuck extends Duck {
    protected RubberDuck(String name) {
        super(name);
    }

    @Override
    void display() {
        Logs.l(name + " display rubber");
    }
}
