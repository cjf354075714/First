package com.cqu.learn.classloader;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Feng
 * @date 2019/10/30
 */
public class UrlClassLoaderTest {

    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        URL url = UrlClassLoaderTest.class.getClassLoader().getResource("cmd.jar");
        System.out.println(url);
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
        Class<?> simpleUtilClass = classLoader.loadClass("com.company.util.SimpleUtil");
        Object instance = simpleUtilClass.newInstance();
        // Integer.class != int.class
        Method method = instance.getClass().getMethod("add", int.class, int.class);
        int s = (int)method.invoke(null, 1, 2);
        System.out.println(s);
    }
}
