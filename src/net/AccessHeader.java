package net;

import io.utils.Logs;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created by crazystone on 17-10-12.
 */
public class AccessHeader {

    static OkHttpClient client = null;

    public static void main(String... args) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        Cache cache = new Cache(new File("/home/crazystone/cache.temp"), 1024 * 1024 * 8);
        client = clientBuilder.cache(cache).build();

        request();
        request();


    }

    private static void request() {
        Request.Builder builder = new Request.Builder();
//        https://api.github.com/repos/square/okhttp/issues
        String url = "http://gank.io/api/data/Android/10/1";
        builder.url(url)
                .header("User-Agent", "OkHttp Headers.java")
                .addHeader("Accept", "application/json; q=0.5")
                .addHeader("Accept", "application/vnd.github.v3+json")
                .addHeader("woca", "heheh");
        Request request = builder.build();

        Headers requestHeaders = request.headers();
        Nets.printHeader(requestHeaders);
        Logs.l(">>>>>>>>>>>>>>>>>");
        Logs.l(">>>>>>>>>>>>>>>>>");
        Logs.l(">>>>>>>>>>>>>>>>>");
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                Headers responseHeader = response.headers();
                Nets.printHeader(responseHeader);
                String responseString = response.body().string();
//                test.Logs.l("response string:" + responseString);
//                test.Logs.l("cache response:"+response.cacheResponse());
//                test.Logs.l("network response:"+response.networkResponse());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
