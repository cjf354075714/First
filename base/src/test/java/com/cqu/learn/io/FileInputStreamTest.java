package com.cqu.learn.io;

import org.junit.Test;

import java.io.*;

/**
 * @author Feng
 * @date 2019/10/11
 */
public class FileInputStreamTest {

    @Test
    public void test() {
        File file = new File("D:/cjf/IDEAProject/learn/base/src/main/java/com/cqu/learn/io/file.txt");
        try {
            InputStream inputStream = new FileInputStream(file);
            int s = inputStream.read();
            int s2 = inputStream.read();
            System.err.print((byte) s);
            System.err.print((byte) s2);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
