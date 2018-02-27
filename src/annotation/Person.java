package annotation;

/**
 * Created by crazystone on 18-2-21.
 */
@ClassAnnotation(describe = "this is person")
public class Person {

    private String name;

    @TestAnnotation(23)
    public String age;

}
