package net;

import io.utils.Logs;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by crazystone on 17-10-13.
 */
public class Authenticate {

    public static void main(String... args) {

        auth();
    }

    private static void auth() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                if (response.request().header("Authorization") != null) {
                    return null;
                }

                Logs.l("auth response:" + response);
                Logs.l("challenge:" + response.challenges());
                String auth = Credentials.basic("jesse", "password1");
                return response.request().newBuilder().header("Authorization", auth).build();
            }
        });
        OkHttpClient client = clientBuilder.build();

        Request request = new Request.Builder().url("http://publicobject.com/secrets/hellosecret.txt").build();
        try {
            Response response = client.newCall(request).execute();
            Logs.l("response:" + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
