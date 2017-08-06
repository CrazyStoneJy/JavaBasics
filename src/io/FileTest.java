package io;

import io.utils.Dates;
import io.utils.Logs;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Created by crazystone on 17-8-1.
 */
public class FileTest {

    public static void main(String... args) {

//        fileProperty();
//
//        mkdirsTest();

        File directory = new File("/home/crazystone/FileTest/Test");
//        deleteDirectory(directory);
//        showFileName(directory);

        String[] array = directory.list();
        for (String s : array) {
    Logs.l(s);
        }

    }

    //File 一些最基本的API 不需要记住,看看即可,以后可以看源码
    public static void fileProperty() {
        File file = new File("/home/crazystone/FileTest/test.md");
        Logs.l("fileName:" + file.getName());
        Logs.l("absolutePath:" + file.getAbsolutePath());
        try {
            Logs.l("canonicalPath:" + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logs.l("this file is exists:" + file.exists());
        Logs.l("parent File Path:" + file.getParent());
        Logs.l("file is hidden:" + file.isHidden());
        Logs.l("file can read:" + file.canRead());
        Logs.l("file can write:" + file.canWrite());
        Logs.l("file can execute:" + file.canExecute());
        Logs.l("this file is directory:" + file.isDirectory());
        Logs.l("this file is file:" + file.isFile());
        Logs.l("this file last modify time:" + Dates.parseLong2String(file.lastModified()));

        File hideFile = new File("/home/crazystone/FileTest/.hide.txt");
        Logs.l(".hide.txt is hidden:" + hideFile.isHidden());

        File newFile = new File("/home/crazystone/FileTest/hello.txt");
        if (!newFile.exists()) {
            try {
                //创建一个新File
                boolean isSuccess = newFile.createNewFile();
                Logs.l("file create " + (isSuccess ? "success" : "fail"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mkdirsTest() {
        //创建文件夹
        File directory = new File("/home/crazystone/FileTest/Hello");
        if (!directory.exists()) {
            boolean isSuccess = directory.mkdirs();
            Logs.l("directory create " + (isSuccess ? "success" : "fail"));
        }
    }

    //删除文件夹下的所有文件(稍微综合一点)
    public static void deleteDirectory(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                deleteDirectory(file);
            }
            directory.delete();
        } else {
            boolean isSuccess = directory.delete();
            Logs.l(directory.getAbsolutePath() + " delete is " + (isSuccess ? "success" : "fail"));
        }
    }

    public static void showFileName(File directory) {
        if (directory.isDirectory()) {
            for (String name : directory.list()) {
                Logs.l("name:" + name);
            }
        }
    }



}
