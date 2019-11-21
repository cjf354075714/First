package com.cqu.learn.base.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Feng
 * @date 2019/10/18
 */
public class FileChannelTest {

    @Test
    public void test() throws IOException {
        //创建一个文件管道类，需要传入这个文件的 URL 和文件的权限，比如读写等
        FileChannel inChannel = FileChannel.open(Paths.get("D:\\cjf\\IDEAProject\\learn\\base\\src\\main\\java\\com\\cqu\\learn\\nio\\file.txt"),
                StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("D:\\cjf\\IDEAProject\\learn\\base\\src\\main\\java\\com\\cqu\\learn\\nio\\file1.txt"),
                StandardOpenOption.READ, StandardOpenOption.WRITE);

        //根据文件管道类创建一个直接内存映射，这个对象的内存是在物理内存中的，也需要指定大小和权限等
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);
        inMappedBuf = null;
        outMappedBuf = null;
        inChannel.close();
        outChannel.close();
        System.gc();
    }
}
