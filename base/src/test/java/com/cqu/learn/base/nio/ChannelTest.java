package com.cqu.learn.base.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Feng
 * @date 2019/10/18
 */
public class ChannelTest {

    @Test
    public void test() throws IOException {
        File file = new File("D:\\cjf\\IDEAProject\\learn\\base\\src\\main\\java\\com\\cqu\\learn\\nio\\file.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        File file1 = new File("D:\\cjf\\IDEAProject\\learn\\base\\src\\main\\java\\com\\cqu\\learn\\nio\\file1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChanel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (inChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outChanel.read(byteBuffer);
            byteBuffer.clear();
        }
        inChannel.close();
        outChanel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
