package pattern.base;

import io.utils.Logs;

/**
 * Created by crazystone on 17-8-14.
 */
public class QuackBehavior implements Quackable {

    Duck duck;

    public QuackBehavior(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        Logs.l(duck != null ? duck.name : "" + " is quacking!");
    }
}
