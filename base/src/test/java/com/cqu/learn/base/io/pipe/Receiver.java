package com.cqu.learn.base.io.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author Feng
 * @date 2019/10/11
 */
public class Receiver extends Thread {

    private PipedInputStream in = new PipedInputStream();

    public PipedInputStream getIn() {
        return in;
    }

    @SuppressWarnings("unused")
	private void readMessageOnce() {
        byte[] buf = new byte[2048];
        try {
            int len = in.read(buf);
            System.err.println(new String(buf, 0, len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessageContinued() {
        int total = 0;
        while (true) {
            byte[] buf = new byte[1024];
            try {
                int len = 0;
                len = in.read(buf);
                total += len;
                System.err.println(new String(buf, 0, len));
                if (total > 1024) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        readMessageOnce();
        readMessageContinued();
    }
}
