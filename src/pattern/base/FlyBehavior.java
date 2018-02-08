package pattern.base;

import io.utils.Logs;

/**
 * Created by crazystone on 17-8-14.
 */
public class FlyBehavior implements Flyable {

    Duck duck;

    private FlyBehavior(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void fly() {
        Logs.l(duck != null ? duck.name : "" + " is flying!");
    }
}
