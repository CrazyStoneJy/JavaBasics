package test;

import io.utils.*;
import io.utils.Logs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by crazystone on 18-3-7.
 */
public class RegluarExpressionTest {

    static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
    static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{(" + PARAM + ")\\}");

    public static void main(String... args) {

        test("{test}asdsa{woca}asdas{wtf}");

    }

    private static void test(String string) {
        Matcher matcher = PARAM_URL_REGEX.matcher(string);
        Logs.l(matcher.groupCount());
        while (matcher.find()) {
            Logs.l(matcher.group(0));
            String group = matcher.group(1);
            io.utils.Logs.l(group);
        }
    }


}
