package com.cqu.learn.base.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Feng
 * @date 2019/10/18
 */
public class BlockingNIO2Test {

    @Test
    public void client() throws IOException {
        //get channel
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(4433));

        //
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        FileChannel inChannel = FileChannel.open(Paths.get("D:\\cjf\\IDEAProject\\learn\\base\\src\\main\\java\\com\\cqu\\learn\\nio\\file.txt"),
                StandardOpenOption.READ);
        while (inChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        socketChannel.shutdownOutput();
        int len = 0;
        while ( (len = (socketChannel.read(byteBuffer))) != -1) {
            byteBuffer.flip();
            System.err.println(new String(byteBuffer.array(), 0, len));
        }
        socketChannel.close();
        inChannel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(4433));
        SocketChannel socketChannel = serverSocketChannel.accept();
        FileChannel outChannel = FileChannel.open(Paths.get("D:\\cjf\\IDEAProject\\learn\\base\\src\\main\\java\\com\\cqu\\learn\\nio\\file1.txt"),
                StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (socketChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        byteBuffer.put("服务端接收客户端数据成功".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);

        socketChannel.close();
        outChannel.close();
        serverSocketChannel.close();
    }
}
