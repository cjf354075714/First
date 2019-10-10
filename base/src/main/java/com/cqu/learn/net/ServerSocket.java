package com.cqu.learn.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author Feng
 * @date 2019/10/10
 */
public class ServerSocket {

    public static void main(String[] args) {
        try {
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(8080);
            byte[] message = new byte[1024];
//            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                while (inputStream.read(message) != -1) {
                    for (byte m : message) {
                        System.err.println(m);
                    }
                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
