package annotation;

import org.junit.Test;
import test.Logs;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by crazystone on 18-2-21.
 */
public class MainTest {

    public static void main(String... args) {

//        classAnnotation(Person.class);
//        classAnnotation(Student.class);
//        testAnnotation(Person.class);
//        testAnnotation(Student.class);

        parseParamterAnnotation();

    }

    private static void parseParamterAnnotation() {

        Class<? extends Api> cls = Api.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[][] methodAnnotations = method.getParameterAnnotations();
            Logs.l(methodAnnotations.length);
            for (int i = 0; i < methodAnnotations.length; i++) {
                Annotation[] annotations = methodAnnotations[i];
                Logs.l("child annotation:" + annotations.length);
                for (Annotation annotation : annotations) {
                    Class<?> type = annotation.annotationType();
                    Logs.l(type);
                    if (annotation instanceof Path) {
                        Path path = (Path) annotation;
                        Logs.l(path.value());
                    }
                }
            }
//            Logs.l(method.getName());
        }


    }


    private static void testAnnotation(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            Logs.l(field.getName());
            if (field.isAnnotationPresent(TestAnnotation.class)) {
                TestAnnotation annotation = cls.getAnnotation(TestAnnotation.class);
                if (annotation != null) {
                    Logs.l(annotation.value());
                }
            }
        }
    }

    /**
     * @param cls 类
     */
    private static void classAnnotation(Class<?> cls) {
//        Logs.l(cls.isAnnotationPresent(ClassAnnotation.class));
        if (cls.isAnnotationPresent(ClassAnnotation.class)) {
            ClassAnnotation annotation = cls.getAnnotation(ClassAnnotation.class);
            Logs.l(annotation.describe());
        }
    }


}
