package com.cqu.learn.base.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;

/**
 * @author Feng
 * @date 2019/10/18
 */
public class NonBlockingNIOTest {

    @Test
    public void test() throws IOException {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress(4433));
        sChannel.configureBlocking(false);
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(new Date().toString().getBytes());
        buf.flip();
        sChannel.write(buf);
        sChannel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.bind(new InetSocketAddress(4433));
        Selector selector = Selector.open();
        //第二个参数，表示这个选择器监控的是这个通道的哪个状态，读、写、连接、接收等
        //这里指定监听接收事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        //轮序的获取选择器上已经准备就绪的时间
        //selector.select() > 0 表示至少有一个时间准备就绪了
        while (selector.select() > 0) {
            Iterator<SelectionKey> it =  selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey sk = it.next();
                if (sk.isAcceptable()) {
                    SocketChannel sChannel = ssChannel.accept();
                    sChannel.configureBlocking(false);
                    sChannel.register(selector, SelectionKey.OP_WRITE);
                } else if (sk.isWritable()) {
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sChannel.read(buf)) != -1) {
                        buf.flip();
                        System.err.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }
                it.remove();
            }
        }
    }
}
