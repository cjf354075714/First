package com.cqu.learn.io.pipe;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedOutputStream;

/**
 * @author Feng
 * @date 2019/10/11
 */
public class Sender extends Thread{

    private PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOut() {
        return out;
    }

    public void sendMessage() {
        try {
            out.write("hello world".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendLongMessage() {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuffer.append("0123456789");
        }
        stringBuffer.append("abcdefghijklmnopqrstuvwxyz");
        try {
            out.write(stringBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        sendMessage();
        sendLongMessage();
    }
}
