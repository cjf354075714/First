package com.cqu.learn.base.classloader;

import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/23
 */
public class ClassLoaderTest {

    @Test
    public void test() throws ClassNotFoundException {
        System.err.print(System.getProperty("java.ext.dir"));
        ClassLoader system = ClassLoader.getSystemClassLoader();
        @SuppressWarnings("unused")
		Class<?> object = system.loadClass("");
    }
}
