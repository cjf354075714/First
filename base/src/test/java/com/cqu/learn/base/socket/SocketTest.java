package com.cqu.learn.base.socket;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Feng
 * @date 2019/10/16
 */
public class SocketTest {

    @Test
    public void test() {
        Socket socket = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            socket = new Socket("127.0.0.1", 4433);
            bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            bufferedOutputStream.write("你好，服务端".getBytes(StandardCharsets.UTF_8));
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
