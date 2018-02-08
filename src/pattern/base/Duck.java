package pattern.base;

import io.utils.Logs;

/**
 * Created by crazystone on 17-8-14.
 */
public abstract class Duck {

    String name;

    protected Duck(String name) {
        this.name = name;
    }


    void swim() {
        Logs.l(name + " is swimming!");
    }

    abstract void display();

//    void quack() {
//        Logs.l(name + " is quacking!");
//    }


}
