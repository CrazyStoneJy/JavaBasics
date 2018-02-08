package io;

import java.io.*;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by crazystone on 17-8-9.
 */
public class ZipCompressor {


    public static void compress(File file) {
        if (!file.exists()) return;
        FileOutputStream fos = null;
        CheckedOutputStream cos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream("/home/crazystone/FileTest/compress.zip");
            cos = new CheckedOutputStream(fos, new CRC32());
            zos = new ZipOutputStream(cos);
            compress(zos, file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void compress(ZipOutputStream zipOutputStream, File file) {
        if (file.isDirectory()) {

        } else {
            try {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
//                ZipEntry entry = new ZipEntry();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }



    }


    public static void compress(String path) {
        compress(new File(path));
    }

}
