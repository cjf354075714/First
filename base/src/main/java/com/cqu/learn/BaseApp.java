package com.cqu.learn;

import com.cqu.learn.datatype.DefaultValue;
import com.cqu.learn.nio.StreamIO;
import com.cqu.learn.polymorphism.ObjectToString;
import sun.nio.ch.FileChannelImpl;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class BaseApp
{
    public static void main( String[] args ) throws Exception {
        StreamIO streamIO = new StreamIO();
        streamIO.solution();
    }
}
