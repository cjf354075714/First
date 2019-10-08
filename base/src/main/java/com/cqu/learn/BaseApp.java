package com.cqu.learn;

import com.cqu.learn.datatype.DefaultValue;
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
        RandomAccessFile file = new RandomAccessFile("H:\\LocalRepository\\GitLocalRepo\\learn\\base\\src\\main\\java\\com\\cqu\\learn\\nio\\readme.txt", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1);//这里定义了一个buffer的大小，就相当于byte数组

    }
}
