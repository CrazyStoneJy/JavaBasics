package pattern.base;

import io.utils.Logs;

/**
 * 诱饵鸭
 * Created by crazystone on 17-8-14.
 */
public class DecoyDuck extends Duck{
    protected DecoyDuck(String name) {
        super(name);
    }

    @Override
    void display() {
        Logs.l(name+" display decoy");
    }
}
