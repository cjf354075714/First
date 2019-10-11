package com.cqu.learn.io;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Feng
 * @date 2019/10/11
 */
public class ByteArrayOutputStreamTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(67);
        byte[] message = outputStream.toByteArray();
        for (byte s : message) {
            System.err.println(s);
        }
        System.err.println(outputStream.toString("utf-8"));
    }
}
