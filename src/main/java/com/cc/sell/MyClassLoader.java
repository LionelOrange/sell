package com.cc.sell;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author chencheng
 * @date 2019/4/19
 */
public class MyClassLoader extends ClassLoader {

    private String path;

    private String classLoaderName;

    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    /**
     * 寻找类加载器
     *
     * @param name 名字
     * @return
     */
    @Override
    protected Class<?> findClass(String name) {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) {
        name = path + name + ".class";
        InputStream in=null;
        ByteArrayOutputStream out=null;
        try {
            in = new FileInputStream(new File(name));
            out = new ByteArrayOutputStream();
            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }


}
