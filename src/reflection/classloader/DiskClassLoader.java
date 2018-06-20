package reflection.classloader;

import java.io.*;

/**
 * Created by crazystone on 18-6-19.
 */
public class DiskClassLoader extends ClassLoader {

    private String libPath;

    public DiskClassLoader(String libPath) {
        this.libPath = libPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        File file = new File(libPath, getFileName(name));
        FileInputStream fis = null;
        ByteArrayOutputStream bas = null;

        try {
            fis = new FileInputStream(file);
            bas = new ByteArrayOutputStream();

            int len = 0;
            while ((len = fis.read()) != -1) {
                bas.write(len);
            }
            byte[] bytes = bas.toByteArray();
            return defineClass(name, bytes, 0, bytes.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private String getFileName(String name) {
        return name + ".class";
    }
}
