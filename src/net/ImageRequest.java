package net;

import io.utils.Logs;
import okhttp3.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by crazystone on 17-11-17.
 */
public class ImageRequest {

    public static void main(String... args) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://47.94.196.223:81/group1/M00/02/9B/rBF3o1kx_iWAF77AAADMZugMBm0050.jpg")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
//                    InputStream is = response.body().byteStream();
                    byte[] bytes = response.body().bytes();
//                    InputStream is  =  new BufferedInputStream(bytes);
                    OutputStream out = new FileOutputStream(new File("/home/crazystone/test.jpg"));
                    Logs.l(bytes);
                    out.write(bytes, 0, bytes.length);
                    out.flush();
                    out.close();
//                    byte[] buff = new byte[1024];
//                    int len = 0;
//                    while ((len = is.read(buff)) != -1) {
//                        out.write(buff, 0, len);
//                    }
//                    out.flush();
//                    out.close();
//                    is.close();

                }
            }
        });

    }


}
