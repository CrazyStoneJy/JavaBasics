package jvm;

import com.google.inject.internal.cglib.proxy.$Enhancer;

/**
 * Created by crazystone on 18-4-24.
 */
public class JavaMethodAreaTest {

    public static void main(String... args) {

        overFlowFunctionArea();
    }

    private static void overFlowFunctionArea() {
        while (true) {
            $Enhancer enhancer = new $Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.create();
        }
    }

    private static class OOMObject {

    }


}
