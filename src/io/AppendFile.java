package io;

import io.utils.Logs;

import java.io.*;

/**
 * Created by crazystone on 17-9-7.
 */
public class AppendFile {

    public static void main(String... args) {

        outputFile("asdasda");
        outputFile("nimniadas");

        for (int i = 0; i < 20; i++) {
            outputFile("value" + i);
        }

    }

    private static void outputFile(String parseImageString) {
        File outputFile = new File("/home/crazystone/push2server.txt");
        if (!outputFile.exists()) {
            try {
                boolean isSuccess = outputFile.createNewFile();
                Logs.l("create output file " + (isSuccess ? "success" : "fail"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(outputFile, true);
            outputStream.write(parseImageString.getBytes());
            outputStream.write("\n".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
