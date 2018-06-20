package reflection.proxy;

/**
 * Created by crazystone on 18-6-15.
 */
public class PrintFactory {

    private IPrint printer = null;
    public int count = 1;

    public PrintFactory() {
        printer = new Printer();
    }

    public void print() {
        printer.print();
    }

}
