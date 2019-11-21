package com.cqu.learn.base.classloader;

import java.io.*;

/**
 * @author Feng
 * @date 2019/10/28
 */
public class FileClassLoader extends ClassLoader {
    @SuppressWarnings("unused")
	private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    /**
     * 该函数是寻找字节码文件的函数
     * 该方法是 loadClass 方法调用，loadClass 方法也是写好的，我们自定义类加载器应该是重写这个方法
     * @param name 字节码文件的路径
     * @return Class 对象
     * @throws ClassNotFoundException 找不到类对象
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        //TODO 在这里，应该是调用 defineClass 方法，该方法父抽象对象已经实现了，就是将字节码文件加载成类对象

        try {
            FileInputStream fileInputStream = new FileInputStream(new File("D:\\cjf\\Demo.class"));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = bufferedInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, length);
            }
            byte[] classByte = byteArrayOutputStream.toByteArray();
            bufferedInputStream.close();
            return defineClass(name, classByte, 0, classByte.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
