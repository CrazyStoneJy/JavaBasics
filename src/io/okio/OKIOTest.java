package io.okio;

import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by crazystone on 17-10-15.
 */
public class OKIOTest {

    public static void main(String... args) {
//        com.crazystone.me.customview.practice6.ViewPropertyAnimationView


        File file = new File("/home/crazystone/okio.txt");
        Sink sink = null;
        try {
            sink = Okio.sink(file);
            BufferedSink bufferedSink = Okio.buffer(sink);
            bufferedSink.writeUtf8("hello okio");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sink != null) {
                try {
                    sink.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        Sink sink = null;

    }


}
