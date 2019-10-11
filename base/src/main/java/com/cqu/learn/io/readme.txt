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
包装流就是对节点流的一个封装。目的是


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
