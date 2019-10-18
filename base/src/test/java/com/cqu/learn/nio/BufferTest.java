package com.cqu.learn.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author Feng
 * @date 2019/10/18
 */
public class BufferTest {

    @Test
    public void test() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.err.println(byteBuffer.position());
        String message = "feng";
        byte[] messageByte = message.getBytes(StandardCharsets.UTF_8);
        byteBuffer.put(messageByte);
        System.err.println(byteBuffer.position());
        byteBuffer.flip();
        byte[] readByte = new byte[1];
        byteBuffer.get(readByte);
        System.err.println(new String(readByte, StandardCharsets.UTF_8));
    }
}
