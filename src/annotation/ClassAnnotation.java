package annotation;

import java.lang.annotation.*;

/**
 * Created by crazystone on 18-2-21.
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface ClassAnnotation {
    String describe() default "this is describe";
}
