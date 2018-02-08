package net;

import io.utils.Logs;
import okhttp3.*;
import sun.rmi.runtime.Log;

import java.io.IOException;

/**
 * Created by crazystone on 17-10-13.
 */
public class AsynchronousGet {

    public static void main(String... args) {

//        getHTTPUrl();
//        parseUrl();
        async();

    }

    private static void async() {
        OkHttpClient client = new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url("https://api.github.com/repos/square/okhttp/issues");
        requestBuilder.url(new HttpUrl.Builder().scheme("https").host("api.github.com").addPathSegments("repos").addPathSegments("square/okhttp/issues").build());

        Request request = requestBuilder.build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Logs.l(call.toString());
                Logs.l("error:" + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Logs.l(response.networkResponse());
                    Logs.l(response.body().string());
                }
            }
        });

        Logs.l(request.url());

    }

    private static void getHTTPUrl() {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("www.google.com")
                .addPathSegment("search")
                .addQueryParameter("q", "polar bears")
                .addEncodedQueryParameter("name", "中国人")
                .addQueryParameter("hehe", "你妈")
                .addPathSegments("collect")
                .build();
        System.out.println(url);
    }

    private static void parseUrl() {
        HttpUrl base = HttpUrl.parse("https://www.youtube.com/user/WatchTheDaily/videos?name=jiayan&password=123");
        Logs.l("url:" + base.url());
        Logs.l("host:" + base.host());
        Logs.l("port:" + base.port());
        Logs.l("query:" + base.query());
        Logs.l("scheme:" + base.scheme());
        HttpUrl relativeUrl = base.resolve("/hahha");
        Logs.l("relativeUrl:" + relativeUrl.url());

    }


}
