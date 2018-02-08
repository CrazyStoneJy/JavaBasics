package net;

import io.utils.Logs;
import okhttp3.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by crazystone on 17-10-13.
 */
public class PostFile {
    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");

    private final OkHttpClient client = new OkHttpClient();

    public static void main(String... args) throws Exception {
        new PostFile().run();
    }

    public void run() throws Exception {
        File file = new File("/home/crazystone/test.txt");

        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();

        Nets.printHeader(request.headers());
//        test.Logs.l(request.body().contentType());
        Logs.l(request.body());
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//            Nets.printHeader(response.headers());
            System.out.println(response.body().string());
        }
    }


}
