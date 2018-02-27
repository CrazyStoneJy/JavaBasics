package annotation;

import java.lang.annotation.*;

/**
 * Created by crazystone on 18-2-21.
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface TestAnnotation {
    int value() default 25;
}
