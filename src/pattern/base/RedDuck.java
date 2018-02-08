package pattern.base;

import io.utils.Logs;

/**
 * Created by crazystone on 17-8-14.
 */
public class RedDuck extends Duck {

    protected RedDuck(String name) {
        super(name);
    }

    @Override
    void display() {
        Logs.l(name+" display red");
    }
}
