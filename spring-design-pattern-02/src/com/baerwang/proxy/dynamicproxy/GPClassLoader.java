package com.baerwang.proxy.dynamicproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author baerwang
 * @since 2020/9/2 16:24
 */
public class GPClassLoader extends ClassLoader {

    private File classPathFile;

    public GPClassLoader() {
        String classPath = GPClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;

        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream fileInputStream = null;
                ByteArrayOutputStream byteArrayOutputStream = null;

                try {
                    fileInputStream = new FileInputStream(classFile);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bytes = new byte[1024];
                    int len;

                    while ((len = fileInputStream.read(bytes)) != -1) {
                        byteArrayOutputStream.write(bytes, 0, len);
                    }
                    return defineClass(className, byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
