package com.cqu.learn.base.classloader;
import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/28
 */
public class FileClassLoaderTest {

    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        FileClassLoader classLoader = new FileClassLoader(null);
        FileClassLoader classLoader1 = new FileClassLoader(null);
        Class<?> object = classLoader.findClass("com.cqu.learn.base.classloader.Demo");
        Class<?> object1 = classLoader1.findClass("com.cqu.learn.base.classloader.Demo");
        System.out.println(object.newInstance().hashCode());
        System.out.println(object1.newInstance().hashCode());

    }
}
