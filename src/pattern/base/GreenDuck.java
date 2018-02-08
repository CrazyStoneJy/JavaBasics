package pattern.base;

import io.utils.Logs;

/**
 * Created by crazystone on 17-8-14.
 */
public class GreenDuck extends Duck {
    protected GreenDuck(String name) {
        super(name);
    }

    @Override
    void display() {
        Logs.l(name + " display green");
    }
}
