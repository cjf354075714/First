package com.cqu.learn.net;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Feng
 * @date 2019/10/10
 */
public class Socket {
    public static void main(String[] args) {
        try {
            java.net.Socket socket = new java.net.Socket("127.0.0.1", 8080);
            OutputStream outputStream = socket.getOutputStream();
            byte[] message = {2};
            outputStream.write(message);
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
