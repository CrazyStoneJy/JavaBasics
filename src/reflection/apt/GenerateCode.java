package reflection.apt;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.*;

/**
 * Created by crazystone on 18-3-2.
 */
public class GenerateCode {

    public static void main(String... args) {
        hello();
        test();

    }

    private static void test() {
        MethodSpec method = MethodSpec.methodBuilder("test")
                .addModifiers(Modifier.PRIVATE, Modifier.STATIC)
                .returns(TypeName.VOID)
                .addStatement("$T.out.println($S)", System.class, "Test")
                .build();

        TypeSpec type = TypeSpec.classBuilder("Hello")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(method)
                .build();
        JavaFile java = JavaFile.builder("me.crazystone.study", type).build();

        File file = new File("/home/crazystone/gen");
        if (!file.exists()) {
            boolean isSuccess = file.mkdir();
        }
        try {
            java.writeTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void hello() {
        MethodSpec method = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(TypeName.VOID)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello World")
                .build();

        TypeSpec type = TypeSpec.classBuilder("Hello")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(method)
                .build();
        JavaFile java = JavaFile.builder("me.crazystone.study", type).build();

        File file = new File("/home/crazystone/gen");
        if (!file.exists()) {
            boolean isSuccess = file.mkdir();
        }
        try {
            java.writeTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
