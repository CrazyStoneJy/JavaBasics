package test;

import io.utils.Logs;

import java.io.File;

/**
 * Created by crazystone on 17-8-14.
 */
public class FileDeleteTest {

    public static void main(String... args) {

        deleteAllFiles(new File("/home/crazystone/copyTest"));


    }


    public static void deleteAllFiles(File file) {
        if (file == null || !file.exists()) {
            return;
        }
//        if (file.isFile()) {
//            boolean isSuccess = file.delete();
//            test.Logs.log("file delete is " + (isSuccess ? "success" : "fail"));
//            return;
//        }
        if (file.isDirectory()) {
            File[] childFile = file.listFiles();
            if (childFile == null || childFile.length == 0) {
                return;
            }
            for (File f : childFile) {
                deleteAllFiles(f);
            }
            boolean isSuccess = file.delete();//删除文件夹
            Logs.l(file.getName() + " delete is" + (isSuccess ? "success" : "fail"));
        } else {
            boolean isSuccess = file.delete();
            Logs.l(file.getName() + " delete is " + (isSuccess ? "success" : "fail"));
        }
    }

}
