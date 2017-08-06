package io;

import io.utils.Logs;

import java.io.*;

/**
 * Created by crazystone on 17-8-5.
 */
public class IOTest {

    public static void main(String... args) {

//        testFileOutputStream();
//        testFileInputStream();

//        testDataStream();

//        copyFiles("/home/crazystone/FileTest", "/home/crazystone/copyTest");

        testReaderWriter();

    }

    private static void testReaderWriter() {
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader("/home/crazystone/FileTest/test.md");
            writer = new FileWriter("/home/crazystone/FileTest/test1.md");
            BufferedReader br = new BufferedReader(reader);
            String content="";
            while ((content=br.readLine())!=null){
                writer.write(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(writer!=null){
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 批量复制
     *
     * @param target 被复制的文件夹路径
     * @param dest   　复制后的文件加路径
     */
    public static void copyFiles(String target, String dest) {
        copyFiles(new File(target), new File(dest));
    }

    public static void copyFiles(File target, File dest) {
        if (target.exists()) {
            if (target.isDirectory()) {
                mkdirs(dest.getAbsolutePath());
                String[] currentFolderNames = target.list();
                for (String name : currentFolderNames) {
                    Logs.l(name);
                    copyFiles(new File(target, name), new File(dest, name));
                }
            } else {
                copyFile(target, dest);
            }
        } else {
            Logs.l("target file is not exists");
        }
    }

    private static File mkdirs(String path) {
        File destFile = new File(path);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        return destFile;
    }

    /**
     * 复制一个文件
     *
     * @param target      　被复制的文件路径
     * @param destination 　复制后的文件路径
     */
    private static void copyFile(String target, String destination) {
        InputStream is = null;
        OutputStream os = null;
        try {
            File destFile = new File(destination);
            if (!destFile.exists()) destFile.createNewFile();
            is = new FileInputStream(new File(target));
            os = new FileOutputStream(destFile);
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer);
//                Logs.l(new String(buffer, 0, len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 复制一个文件到另一个文件
     *
     * @param target
     * @param dest
     */
    private static void copyFile(File target, File dest) {
        copyFile(target.getAbsolutePath(), dest.getAbsolutePath());
    }

    private static void testDataStream() {
        DataOutputStream dos = null;
        DataInputStream dis = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("/home/crazystone/FileTest/data.txt"));
            dos.writeDouble(2.04d);
            dos.writeLong(100L);
            dos.writeChars("hello world");
            dos.flush();

            dis = new DataInputStream(new FileInputStream("/home/crazystone/FileTest/data.txt"));
            Logs.l(dis.readDouble());
            Logs.l(dis.readLong());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void testFileOutputStream() {
        OutputStream os = null;
        try {
            File file = new File("/home/crazystone/FileTest/hehe.dat");
            if (!file.exists()) {
                file.createNewFile();
            }
            os = new FileOutputStream(file);
            for (int i = 1; i < 10; i++) {
                os.write(i);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void testFileInputStream() {
        InputStream is = null;
        try {
            is = new FileInputStream(new File("/home/crazystone/FileTest/hehe.dat"));
            byte[] buffer = new byte[1024];
            int len = 0;
            int value = 0;
            //将流对象的中的数据先读到缓存中
//            while ((len = is.read(buffer)) != -1) {
//                Logs.l(new String(buffer, 0, len));
//            }
            while ((value = is.read()) != -1) {
                Logs.l(value);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
