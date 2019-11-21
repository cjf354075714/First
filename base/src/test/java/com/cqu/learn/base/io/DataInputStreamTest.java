package com.cqu.learn.base.io;

import org.junit.Test;

import java.io.*;

/**
 * @author Feng
 * @date 2019/10/14
 */
public class DataInputStreamTest {

    @Test
    public void test() {
        File file = new File("D:/cjf/IDEAProject/learn/base/src/main/java/com/cqu/learn/io/file.txt");
        try {
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(file);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataInputStream.close();
            dataOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
