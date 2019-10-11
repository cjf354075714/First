package com.cqu.learn.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Feng
 * @date 2019/10/11
 */
public class ByteArrayInputStreamTest {

    @Test
    public void test() {
        byte[] message = {1, 2, 3, 4, 5};

        InputStream inputStream = new ByteArrayInputStream(message);
        try {
            int s = inputStream.read();
            inputStream.skip(2);
            int num = inputStream.read();
            System.out.println(s);
            System.out.println(num);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
