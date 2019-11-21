package com.cqu.learn.base.io.pipe;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author Feng
 * @date 2019/10/11
 */
public class PipedStreamTest {

    @Test
    public void test() {
        Sender sender = new Sender();
        Receiver receiver = new Receiver();
        PipedInputStream in = receiver.getIn();
        PipedOutputStream out = sender.getOut();
        try {
            in.connect(out);
        } catch (IOException e) {
            //capture
            e.printStackTrace();
        }
        sender.start();
        receiver.start();
    }
}
