package test;

import okhttp3.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Created by crazystone on 17-9-6.
 */
public class VisionTest {
    static MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    static OkHttpClient client;

    public static void main(String... args) {
        client = new OkHttpClient.Builder()
                .proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 8123))).build();
        auth();
//        test();
    }

    private static void auth() {

//        new Thread() {
//            @Override
//            public void run() {
        RequestBody body = RequestBody.create(JSON, "");
        Request request = new Request.Builder()
                .url("https://vision.googleapis.com/v1/images:annotate?key=AIzaSyCVQkIfl1k0e461_KnqXHkMh35xSI1rSCM")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Logs.l("onFail");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Logs.l("SUCCESS");
                Logs.l(response.toString());
                Logs.l("reposne body:" + response.body().string());
            }
        });
    }

    private static void test() {
        String url = "http://gank.io/api/data/Android/10/1";
        Request request = new Request.Builder().url(url).get().build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Logs.l("onfail");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                Logs.l(Thread.currentThread().getName());
                try {
                    Logs.l(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
