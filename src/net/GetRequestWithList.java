package net;

import io.utils.Logs;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by crazystone on 17-10-24.
 */
public class GetRequestWithList {

    public static void main(String... args) {

        String url = "http://10.6.9.195:8081/v1/getListParam";
        Map<String, Collection<String>> map = new HashMap<>();
        Collection<String> list = new ArrayList<>();
        list.add("12");
        list.add("34");
        list.add("23");
        list.add("45");
        map.put("a", list);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(getRealUrl(url, map)).get().build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Logs.l("error");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Logs.l(response.body().string());
                }
            }
        });
    }

    public static String getRealUrl(String url, Map<String, Collection<String>> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(url).append((params != null && params.size() > 0) ? "?" : "");
        int index = 0;
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Collection<String>> entry : params.entrySet()) {
                if (index != 0) {
                    sb.append("&");
                }
                if (Collection.class.isInstance(entry.getValue())) {
                    sb.append(parseListParam2String(entry.getKey(), entry.getValue()));
                } else {
                    sb.append(entry.getKey()).append("=").append(entry.getValue());
                }
                index++;
            }
        }
        return sb.toString();
    }

    private static String parseListParam2String(String key, Collection<String> collection) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (String string : collection) {
            if (index != 0) {
                sb.append("&");
            }
            sb.append(key).append("[]").append("=").append(string);
            index++;
        }
        return sb.toString();
    }


    public class TestEntity {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public TestEntity setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public TestEntity setAge(int age) {
            this.age = age;
            return this;
        }
    }

}
