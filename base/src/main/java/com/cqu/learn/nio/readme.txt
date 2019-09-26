nio 是区别于io的，io面向的是字节、字符的操作流
字节字符通过流对象的write或者read读入写入到内存或文本
数据被写入到缓冲区
nio面向的是管道(channel)、选择器(selector)、缓存(buffer)的
传统的io会涉及到线程的阻塞，比如：当一个FileInputStream从文件里面读取信息时
该线程会一直阻塞，直到数据读到了为止
但是，nio可以让线程读取到消息之前，去干其他的事

selector(选择器)的意义在于，可以让一个线程监听多个channel(管道)，类似于观察者模式
比如连接打开、数据到达等

channel和流的概念比较相识，但是流只能单向读入写出，所有有输入输出流的概念
channel是双向的，还可以异步读写。
channel中的数据需要一个载体，读来的或者写入的数据需要一个媒介去存储它
这里就是buffer的作用。流的消息是字节字符，是不需要媒介的，当然了bufferInputStream
也算是一种媒介

流有流的种类，channel也就有自己的种类：
FileChannel、DatagramChannel（UDP）、SocketChannel（TCP）、ServerSocketChannel
就涵盖了文件、网络NIO的操作
ServerSocketChannel和SocketChannel的关系就像Socket和ServerSocket的关系一样




附加：
RandomAccessFile类是可以随机访问文件的任何地方，从某个字节之后读取
allocate：分配
