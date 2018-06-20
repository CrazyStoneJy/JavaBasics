package reflection.proxy;

/**
 * Created by crazystone on 18-6-15.
 */
public class Printer implements IPrint {
    @Override
    public void print() {
        System.out.println("this is method is present print");
    }
}
