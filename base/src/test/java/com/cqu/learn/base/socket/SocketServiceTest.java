package com.cqu.learn.base.socket;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Feng
 * @date 2019/10/16
 */
public class SocketServiceTest {

    @Test
    public void test() {

        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedInputStream bufferedInputStream = null;
        byte[] byteArray = new byte[1024];
        int length = 0;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            serverSocket = new ServerSocket(4433);
            System.err.println("服务器一直等待，直到请求到来");
            socket = serverSocket.accept();
            System.err.println("请求来了");
            bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            while ((length = bufferedInputStream.read(byteArray)) != -1) {
                stringBuilder.append(new String(byteArray, 0, length, StandardCharsets.UTF_8));
            }
            System.err.println(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
                socket.close();
                serverSocket.close();
                byteArray = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
