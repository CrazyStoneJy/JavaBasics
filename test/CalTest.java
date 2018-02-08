
import org.junit.Assert;
import org.junit.Test;
import test.Cal;

/**
 * Created by crazystone on 17-8-14.
 */
public class CalTest {

    @Test
    public void testAdd() {
        int a = 1;
        int b = 2;

        Assert.assertEquals(3, Cal.add(a,b));


    }


}
