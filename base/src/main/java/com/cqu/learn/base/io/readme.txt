JAVA 的 I/O 是封装的操作系统的 I/O

对于操作系统而言，I/O 是内存和其他数据存储介质进行数据传输的一种方式
这里的 Input 和 Output 是对于内存而言的。也就是说，但凡是从内存出去的，都是 Output
是写入内存的，就是 Input，而且，数据的传输是单向的，所以要想同时交互数据需要定义 I 和 O
数据的流向主要有这几部分：磁盘（文件）、网络（Socket）、线程间通信等

数据的流向是对于系统内存而言的，那么
流向内存里面，我们称为read，就是读到内存里面去，这个read()方法InputStream和Reader的所有子类都有
都是传入一个字节或者字符数组，并且尽量读取这个数组能够容纳的最大的数据个数或者我们限定的数据个数
然后返回读了多少个单位数据

现在说的是传统的 JAVA I/O，是阻塞的I/O，在操作系统进行数据的传输的时候，该线程会阻塞
什么都不干，这就是阻塞型 I/O

I/O 从传输信息的最小单位上来分可以分为字节和字符
在传输字节方面，有InputStream和OutputStream
在传输字符方面，有Reader和Writer
但其实，计算机底层只能识别二进制码，所以传输的字符最终还是会转化成为字节
JAVA要在字符和字节之间进行转化，就需要自己又一套合适的编码规则
JAVA采用的是Unicode的编码规则，也就是说，一个字符，包括字母汉字符号等
在内存里面全都是整型的数字，是byte、short、int
区别在于他们所占的字节的多少不一样，比如字母都只会占一个字节、汉字会占两个字节
如果调用input或者reader的read函数，返回的是一个读到的单个字节或者字符的一个int类型的数字
这个数字就是unicode的包装，比如byte转int、short转int等，为什么需要转化为int返回呢？
因为java底层涉及到的读取是c语言写的，unsigned byte 只能用int来接收

从角色方面
有节点流和包装流的区别，节点流就是直接对接到数据的来源或者去向的节点
包装流就是对节点流的一个封装。目的是减少对 CPU 的态的切换，比如，一个文件有 20 个字节
但是呢，我一次只读取 10 个字节，就需要读取两次，这样做的话会导致 CPU 切换两次内核态和用户态
浪费性能，如果我有一个可以存储 20 个字节的数组，那么可以一次性读取 20 个字节到这个数组中
下次我再想读取，就只向这个 20 个字节数组中读取就行了，这样从内存中读取到内存中，也可以减少读取的时间


接下来以文件输入输出对象为例

字符流常用对象
                                                    ByteArrayInputStream
                                                    PipedInputStream        BufferedInputStream
                            InputStream ->FilterInputStream     ->
                                                    FileInputStream            DataInputStream
                                                    ObjectInputStream

            字节流->

                                                        ByteArrayOutputStream
                                                        PipedOutputStream         BufferedOutputStream
                            OutputStream -> FilterOutputStream      -> DataOutputStream
                                                        FileOutputStream             PrintStream
                                                        ObjectOutputStream

I/O ->

                                            CharArrayReader
                                            PipedReader
                            Reader -> FilterReader
                                            BufferedReader
                                            InputStreamReader -> FileReader

            字符流->

                                          CharArrayWriter
                                          PipedWriter
                            Write -> FilterWriter
                                          BufferedWriter
                                          OutputStreamWriter -> FileWriter
                                          PrintWriter

InputStream：
它是所有输入流字节流的抽象父类，规范化的定义了所有输入字节流的一些通用方法
比如：read()、skip()、mark()、reset() 等

read() 这个方法是由其实现它的子类来自主实现的，最底层的方法还是一个字节一个字节地读取数据
skip() 父类提供了简单的实现，本质上是这个方法自己再读取一定数量的字节，然后再返回给开发人员
因为是自己调用的 read() 方法，所以读取的字节的指针是会维护的，所以跳过的逻辑是一定会执行的
当然，如果本身都没有这么多的数据，也就没必要的跳过，会根据自我情况和传输大小取一个合适的值
available() 返回一次性不阻塞就可以获取输入流的最多的估计字节数
close() 关闭流对象，释放资源
mark()
reset()
markSupported()

OutputStream：
它是所有输出字符流的抽象父类，主要是定义了一些公有方法
write() 将数据写入到除了内存以外的其他地方
flush() 将缓冲的所有数据全部写了

ByteArrayInputStream：
这是一个很奇怪的输入字节流对象，我以为数据的来源是网络、磁盘、线程间通信等
但是这个类表明，数据的来源也可以是内存，就是开发定义好一个字节数组，作为
数据的来源，然后 JVM 再按照代码，一个字节一个字节的读入到内存
为了保证读入的数据准确，还进行了与操作，这就是 ByteArrayInputStream，这样一个简单的类

ByteArrayOutputStream：
这是一个字节数组的输出流对象，负责将字节数组写入到内存（正是这个的特殊性，本来应该是写入到文件，网络等地方的）
既然是写入到内存，数据的载体还是个字节数组，那么肯定这个数组是有大小的

ensureCapacity()、grow()、hugeCapacity() 这三个函数都是给数组进行扩容的
扩容的思想有点类似于 ArrayList 的扩容思想

write() 是一个简单地写入函数，开发传入一个字节，然后就给 ByteArrayOutputStream
该对象就将这个字节写到它内部的字节数组中，就这样完成了一个逻辑上的写入
write() 还有一个批量写入，那就是简单的数组的复制了
writeTo() 可以将自己这个数组，直接交给另外的输出流对象来处理
toByteArray() 将内部的字节数组转化为数组对象
toString() 将内部的字节数组按照默认字符集或者指定字符集转化为字符串对象

PipedInputStream & PipedOutputStream
这两个类配套使用，它们实际上是对同一个字节缓存数组进行操作，一个读（PipedInputStream），一个写（PipedOutputStream）
如果数组满了，那么就需要阻塞 PipedInputStream，相反就阻塞 PipedOutputStream
虽然表面上说的是 Piped 管道之间的通信，但实际上，由于两个线程是在同一台计算机的同一个进程里面的
所以并没有什么管道，只是两个之间相互调用，直接操作底层的数组罢了（另外还涉及到线程的一些知识）

PipedOutputStream 是一个线程调用，用于向管道中传输数据的类

public void connect(PipedInputStream snk);
该函数用于将 PipedOutputStream 与 PipedInputStream 相连接起来
并且重置 PipedInputStream 的 in / out 的索引位，这两个索引位是为了维护
PipedInputStream 的内部字节数组的数据的准确性而设立的

public void write(int b);
底层调用 PipedInputStream 的 receive() 方法，自己只是单纯的判断连接是否稳定等

public void write(byte[] b int off, int len);
底层调用 PipedInputStream 的 receive() 方法

public void flush();
通知其他线程使用 PipedInputStream 来读取缓存字节数组中的数据

public void close();
通知 PipedInputStream 数据已经传输完毕
总结：该类只是单纯的调用 PipedInputStream 的一些方法，真正线程之间交流的还是 PipedOutputStream 的事

PipedInputStream 是一个线程调用，也可能多个线程调用的用于获取另外线程传过来的数据的一个类

protected byte buffer[];
存储传输数据的底层数组

protected int in = -1;
表示，下一个传输过来的字节在字节数组中存在的位置，这里写成 -1 只是为了方便后面判断是否数组为空，在真正
给数组赋值的时候，是会先自增的

protected int out = 0;
表示，下一个将要读取的字节在字节数组中存在的位置

该方法表示，PipedOutputStream 写入单个数据给 PipedInputStream，有 synchronized 关键字，是线程独占方法
protected synchronized void receive(int b) throws IOException {
    // 判断连接状态是否正常
    checkStateForReceive();

    //标记写数据端的线程
    writeSide = Thread.currentThread();
    if (in == out) {
        //如果 in = out，则表示，字节缓存数组已经满了，就需要等待读取线程调用本类来读取数据，让出位置
        awaitSpace();
    }
    if (in < 0) {
        //就是这个，如果 in < 0 注意，只有 in = -1 也就是初始化的时候，才有可能 < 0
        // in < 0 表示，缓存字节为空，需要初始化字节存放位置和字节读取位置的索引值
        // in = 0 就表示 in 这个字段，确实是下一个写入字节的存放位置
        in = 0;
        out = 0;
    }

    //给缓存数组赋值，只取 int 的低八位
    //并将 in 向后移动一位
    buffer[in++] = (byte)(b & 0xFF);

    //如果存放的索引超过了缓存数组长度，就将索引置 0 重新开始
    if (in >= buffer.length) {
        in = 0;
    }
}

//当数组被写满了之后，会调用的函数。注意，这个时候是写的那个线程来调用该方法
//也就是说是 PipedOutputStream 来调用这个方法，它将通知所有占有 PipedInputStream 的锁的读的线程
//来读取缓存数组中的数据，从而让出位置
//判断周期是 1S 每隔 1S 都会判断一下数组是否满了
//这里的被写满了，不是说数组写满了，而是 读取的字节读的很慢，但是写得很快，以至于 in = out 了
//那我还没读的，你肯定不能覆盖，所以会阻塞
private void awaitSpace() throws IOException {
    while (in == out) {
        checkStateForReceive();
        notifyAll();
        try {
            wait(1000);
        } catch (InterruptedException ex) {
            IoUtils.throwInterruptedIoException();
        }
    }
}

//这个函数，是要将字节批量的赋值给内部的缓存数组，问题就是，哪些数组位是可以用的
//哪些是不可以用的，这就需要 in 和 out 的大小来判断
//读和写都针对同一个数组而言，但是不是同步的，也许我才读到第 5 位，你已经写到了第 10 位
//而且，读写还是可以循环的
synchronized void receive(byte[] b, int off, int len) throws IOException {
    //检查状态是否正常
    checkStateForReceive();
    //记录读取线程对象，有啥用呢？
    writeSide = Thread.currentThread();

    //利用一个变量记录下还需要写入多少个字节
    int bytesToTransfer = len;
    //在 while 里面循环判断剩余需要写入字节数的大小
    while (byteToTransfer > 0) {
        if (in == out) {
            awaitSpace();
        }
        //该变量用来记录，这次循环一共写进缓存的字节的数量
        int nextTransferAmount = 0;
        //如果 out < in 则表示，写的进度快于读，所以剩下可以存数据的位置就是
        //[in, buffer.length - 1] 和 [0, out]
        //数据就先写入到 [in, buffer.length - 1]，这样选择也很明显了
        if (out < in) {
            //算出这次循环能够写入多少个字节
            nextTransferAmount = buffer.length - in;
        }
        // in < out 表示有两种情况，
        // 这个数组还没有赋值，还是空的，那就需要重新计算索引位
        // 这个数组的剩下可用区间就是 [in, out]
        else if (in < out) {
            if (in == -1) {
                in = out = 0;
                nextTransferAmount = buffer.length - in;
            } else {
                //那么 nextTransferAmount 的值就应该是 out - in;
                nextTransferAmount = out -in;
            }
        }
        //nextTransferAmount 是理论上可以写入的字节数
        //byteToTransfer 是实际上的字节数
        //那肯定是要根据实际的来，如果理论上的自己数比实际上多
        if (nextTransferAmount > byteToTransfer) {
            nextTransferAmount = byteToTransfer
        }
        assert(nextTransferAmount > 0);
        //调用的是底层的数组的复制函数
        //将 b 数组从 off 位开始，复制到 buffer 的从 in 位置开始，长度时 nextTransferAmount
        System.arraycopy(b, off, buffer, in, nextTransferAmount);

        //赋值完了，就要重新计算 buffer 和传入 b 的数据索引位
        bytesToTransfer -= nextTransferAmount;
        off += nextTransferAmount;
        in += nextTransferAmount;

        //实际上这里就在维护 in 的值，如果传入的数据太多，数组剩余数据写不下，那么就重新置 0
        //区间 [0, out] 也就没有意义了
        if (in >= buffer.length) {
            in = 0;
        }
    }
}

//自己设置好写线程的 flag，并且通知其他读线程可以写入了
synchronized void receivedLast() {
    closedByWriter = true;
    notifyAll();
}

public synchronized int read() throws IOException{

    //判断是否连接上
    if (!connected) {
        throw new IOException("Pipe not connected");
    } else if (closedByReader) {
        //判断读取线程是否已经关闭了
        throw new IOException("Pipe closed");
    } else if (writeSide != null && !writeSide.isAlive() && !closedByWriter && (in < 0)) {
        //???
        throw new IOException("Write end dead");
    }
    readSide = Thread.currentThread();

    //检查连接的状态
    int trials = 2;
    //如果缓存数组里面没有数据，则先检查连接的状态，再通知写的线程，可以写数据了
    while (in < 0) {
        if (closedByWriter) {
            return -1;
        }
        if ((writeSide != null) && (!writerSide.isAlive() && (--trials < 0))) {
            throw new IOException("Pipe broken");
        }
        //通知其他线程
        notifyAll();
        try{
            wait(1000);
        } catch (InterruptedException ex) {
            IoUtils.throwInterruptedIoException();
        }
    }
    //自增 out 并且返回读取的字节
    int ret = buffer[out++] & 0xff;
    //维护 out 的值，如果超过了数组的长度，就需要重新从头开始读取
    if (out >= buffer.length) {
        out = 0;
    }
    //表示读取的数据的索引已经追上了写入的数据，则当前缓存区域为空，in = -1
    //实际上只是读满了而已，并不是数组为空，开发认为地任务它为空
    if (in == out) {
        in = -1；
    }
}

public synchronized int read(byte[] b, int off, int len) throws IOException {
    //这里一些安全判断，比如数组长度等等的大小判断，我们写的代码，为什么有异常报出来，就是这些代码的逻辑
    if (b == null) {
        throw new NullPointerException();
    } else if (off < 0 || len < 0 || len > b.length - off) {
        throw new IndexOutOfBoundsException();
    } else if (len == 0) {
        return 0;
    }

    //先读取一个字节，读不到就阻塞，读到了，后面就只读取 len - 1 个字节了
    int c = read();

    //读不到，就返回
    if (c < 0) {
        return -1;
    }

    //记录已近读取到的数据的长度
    int rlen = 1;
    while ((in >= 0) && (len > 1)) {

        //记录当前可以读取的数据的长度
        int available;

        //与批量接收的逻辑一样，此时可以读取的数据的区间在 [out, in)
        if (in > out) {
            //正常情况，不可能出现 buffer.length > in 的情况
            //这里只是简单的加个判定吧
            available = Math.min((buffer.length - out), (in - out));
        }
        //和上面类似，现在可读的区间是 [0, in) 和 [out, buffer.length)
        else {
            available = buffer.length - out;
        }
        if(available > (len - 1)) {
            available = len -1;
        }
        //开始复制数组
        System.arraycopy(buffer, out, b, off + rlen, available);
        //读取字节索引向后移动
        out += available;
        //自增已读取到的数据
        rlen += available;
        //计算还需读取的数据
        len -= available;
        if (out >= buffer.length) {
            out = 0;
        }
        if (in == out) {
            in = -1;
        }
    }

    //指明哪些是可以读取的数据，就是数组区间的某些字节数量
    public synchronized int available() throws IOException {
        if(in < 0)
            // 管道中无数据
            return 0;
        else if(in == out)
            // 缓存数组已满
            return buffer.length;
        else if (in > out)
            // [out, in)区间内为有效数据
            return in - out;
        else
            // in < out
            // [in, out)区间为无效数据, 其余为有效数据, 所以长度为 buffer.length - (out - in)
            return in + buffer.length - out;
    }
}
总结一下：实际上就是不同的线程，对 PipedInputStream 类实例的竞争
很多个写线程可能同时竞争这个对象的 write() 的执行权，如果写入的数据过多，那么就会进入
wait() 方法，挂起，然后通知其他等待中的读线程，将缓存数组中的字节读出来腾出位置
如果读多了，那么就挂起，然后等待写线程写入数据
1，这种模式有点像消费者生产者模式
2，这种线程之间交互信息的模式，本质上还是借用了同一个进程里面共享内存和 wait() 和 notify() 这个两个方法


FilterInputStream & FilterOutputStream
这个两个类实际上是一个包装类，它们有一个 InputStream 或者 OutputStream 的内部实例，所有的方法全都是调用
该实例的方法，这只是做出了一个规范，它的子类是 Buffed 和 Data 等，这才是重载了内部方法，用于包装的子类
这种模式叫装饰器模式

BufferedInputStream & BufferedOutputStream

BufferedInputStream 是一个内部具有缓冲数据载体的字节输入流
//默认的缓存数组大小
private static int DEFAULT_BUFFER_SIZE = 8192;

//可用的缓存数组大小，-8 是为了保证特殊虚拟机再给数组加保留内容时，的一个妥协
private static int MAX_BUFFER_SIZE = Integer.MAX_VALUE - 8;

//缓存数组
protected volatile byte buf[];

//缓冲区中的字节数
protected int count;

//缓冲区当前位置的索引
protected int pos;

//最后一次调用 mark 方法时 pos 字段的值
//不知道有啥用
//就是说，如果我调用一次 mark 方法，那么就想到于在缓冲数组的当前位置 pos 上加了一个标记
//这个标记是用于之后 reset() 方法的，如果调用了这个方法，pos 这个代表着缓冲数组的索引位的值
//就会重新回到 mark 这个值上来
protected int markpos = -1;

//markpos 的最大值
//这个值的意思是：BufferedInputStream 对这个 mark 的维护，只到 markpos 这个字节处停止
//如果读取的过多的字节，那 BufferedInputStream 是不会继续维护这个 mark 的值了
protected int marklimit;

//就是这个函数，是给 buf 这个数组进行填充的
//填充字节需要考虑是否已经调用了 mark 方法，不同的情况下，需要不同的处理
private void fill() throws IOException {
    byte[] buffer = getBufIfOpen();

    // < 0 表示，开发没有调用过 mark 方法，我也就不需要维护，直接将 pos = 0
    // count 等于接下来将要读取的字节数
    // buffer 这个缓冲字节数组直接被重新覆盖掉
    if (markpos < 0) {
        pos = 0;
    }
    //就表示，已经读完了在 BufferedInputStream 中的缓存数据
     else if ( pos >= buffer.length) {
        //表示，调用了 mark 方法，并且有一段数据是需要保存下来的，因为该给开发 reset 方法的数据
        //保留数据区间是 [markpos, pos)
        if (markpos > 0) {
            //sz 表示需要保存的字节数目
            int sz = pos - markpos;
            //直接将缓存数组中的开头的数据覆盖掉，反正大小是够得
            System.arraycopy(buffer, markpos, buffer, 0, sz);
            pos = sz;
            markpos = 0;
        //开发定义的限制数目比缓存数组本身的长度还长，那也就没有维护的必要了
        } else if (buffer.length >= marklimit) {
            markpos = -1;
            pos = 0;
        //现在 缓冲数组已经写满了，并且 mark 还能用，就需要扩容缓存数组，扩容大小按照翻倍的规格来
        } else {
            int nsz - ()//后面我来继续写
        }
     }

}

public synchronized int read() throws IOException {
    //pos 表示读的标记位，count 表示数组中的可用字节数
    //实际上，pos 是下一个要读的标记位的值，为啥要实现判断呢
    //这个判断表明，可用字节数将要读完了，需要你填充字节数
    if ( pos >= count) {
        fill();
        //即使填充完毕了，还是不够，那么就不存在数据了，也就读到了 EOF
        if ( pos >= count) {
            return -1;
        }
    }
    // 返回数组中的数据的低八位
    return getBufIfOpen() [pos++] & 0xff;
}

private byte[] getBufIfOpen() throws IOException {
    byte[] buffer = buf;
    if (buffer == null) {
        throw new IOException("Stream closed");
    }
    return buffer;
}


BufferedOutputStream 是一个包装写入字节流
这个类本质上比较简单，内部维护了一个缓存数组，而且这个数组没有大小
每次写入数据的时候，只是先写到内存里面去，然后如果这个数组满了，或者一次性写入的
数据太多了，就直接写入到目标，其他的情况下，才会使用这个缓存数组记录下数据
flush() 这个函数，本质上是调用被包装的节点流来写入数据


DataInputStream & DataOutputStream

DataInputStream 是一个包装流，包装面向字节的输入流
允许读取底层输入流中的 java 基本类型
内部还是有一个大小为 80 的字节数组，用于缓存

readFully(byte[] b) 循环读取 b.length 个字节到数组中，因为内部缓存可能没有这么大，需要循环读取

先不写了，DataInputStream 和 DataOutputStream 是简单的包装流
比如，写一个 int 的时候，就写 4 个 byte，分别取高8 16 24 32 位，然后写入就行了
读这个int 的时候，自然读四个字节，然后相加，强制转化为 int 就行了
这里采用的编码应该是UTF-16。

PrintStream 是一个专门使用平台编码集的输出流对象
这也是为什么 java 控制台没有乱码的原因，那么，调用 print 方法，会直接写入到数据的去向
那么就可以使用 PrintStream 直接作为文件的写入流，要方便很多
底层调用的是 BufferWriter，还是使用的是System.copyarray();

包装流就说完了，主要有两个优势：
减少操作系统读取数据的次数，比如 100 个字节，读取两次，包装流可以一次读完
减少编码器的使用，比如写入字符的时候，每写一次都需要进行一次字符转换，浪费性能
使用包装流，只是写入到了内存中，在 flush 的时候，才会真正写入到内存，调用一次编码器 StreamDecoder

FileInputStream & FileOutputStream
这两个类是用于文件的访问的，显然，典型的 read write 是 native 方法，是我们看不见的

InputStreamReader & OutputStreamWriter
这两个类用于 将字节转化为字符，是装饰器模式的具体实现
底层调用的是 StreamDecoder 和 StreamEncoder
在构建的时候，可以指定编码格式 "UTF-8"

ObjectInputStream & ObjectOutputStream 是用于对象的序列化
主要是将一个实例对象转化为二进制的字节码，然后写入一个文件
下次就可以直接读取这个类对象了


实例1：
现在来说明一下，InputStreamReader 是怎么工作的
InputStreamReader 是将字节转化为字符的类

它内部调用的是 StreamDecoder 将我们输入的字符数组，转化为字节系列，然后写入到我们传入的 OutputStream 里面
比如：
首先定义一个 FileReader 现在我要读取文件里面的字符（表面上是字符，内地里是字节）
但实际上，这个类的 read 函数，是FileReader的父类 InputStreamReader 来定义的，调用的是父类的函数
在这个父类函数里面，会将自己作为参数传递给 StreamDecoder
InputStreamReader 这个类的 read 函数，是会调用 StreamDecoder 的 read 函数
而 StreamDecoder 的 read 函数，会调用 自己的逻辑字节字符转化好之后，调用我们传递的 InputStream 的 read 函数