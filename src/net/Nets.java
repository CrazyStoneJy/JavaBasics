package net;

import io.utils.Logs;
import okhttp3.Headers;

import java.util.Set;

/**
 * Created by crazystone on 17-10-13.
 */
public class Nets {
    public static void printHeader(Headers headers) {
        Set<String> names = headers.names();
        for (String name : names) {
            Logs.l(name + ":" + headers.get(name));
        }
    }



}
