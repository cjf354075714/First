package com.cqu.learn.nio;

import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author Feng
 * @date 2019/10/10
 */
public class StreamIO {

    public void solution() {
        File file = new File("file.txt");
        System.err.println(file.getAbsolutePath());
        System.err.println(file.exists());
        Buffer buffer = ByteBuffer.allocate(1024);
    }
}
