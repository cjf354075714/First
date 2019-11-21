日志用于记录程序的运行轨迹，方便查找关键信息，方便快速定位

常用的日志框架：Log4j、Slf4j、Logback
在日志框架出来之前，Debug 日志流被写在 System.out 里，Error 日志被写在 System.err 里
这两个流是 JAVA 的 PrintWriter 对象实例，性能不够好
而且，多个日志框架，在应用开发，依赖框架里面存在很多，没必要同时在一个应用里面使用多个日志实例
所以需要一些适配接口，来完成多个日志框架之间的适配

多日志框架之间的适配：
JCL：是 Apache 开发的一个日志门面类，它本身不实现日志的逻辑功能，只是实现动态发现可用日志类对象
JCL 支持 jdk 源生支持的日志功能，也支持 Log4j。底层是调用反射，利用类加载器加载在 classpath 下的 jar 文件，实现日志类的加载
需要引入 jcl 的包，既然是反射生成的类实例，说明日志配置文件的配置是有用的
但我还是不明白，这种 JCL 的意义在哪，如果是可以实现配置文件，那么 JCL 是如何配置的呢？

Slf4j：是一个新的日志门面，实现它的框架有 log4j、logback、log4j2 等


日志等级：（不同的日志框架有不同的等级实现）
OFF 关闭
FATAL 致命，在 ERROR 之上
ERROR 错误
WARN 警告
INFO 信息
DEBUG 调试，比 INFO 还要详细
TRACE 跟踪，输出详细的程序运行轨迹
ALL 输出所有信息

日志的正确使用格式：
log.info("运行参数为 param={}", param);
这样写日志框架会自动识别 param，如果写入字符串拼接，会导致 String 对象内存和计算问题

JUL 的使用：
JUL 是 java.utils.Logger 类的简称，是 jdk 自带的日志工具，使用 Logger.getLogger("loggerName") 方法获取，loggerName 表示日志类的名字
JUL 包含三个模块：level、formatter 和 handler
level 等级如下：
OFF/SEVERE/ERROR/WARN/INFO/CONFIG/FINE/FINERG/FINEST/ALL
这些等级是 level 类的实现，该类有三个字段，表示等级的字符串对象、表示大小的整形对象，表示处理接口的实例

formatter 表示输出的格式，现有 SimpleFormatter 和 XMLFormatter
继承 Formatter 对象即可自定义输出格式

Handler 表示输出的目的地：
FileHandler：输出到文件，默认等级为 INFO、Formatter 为 XMLFormatter
ConsoleHandler：输出到控制台，等级为 INFO、流为 System.err，Formatter 为 SimpleFormatter（所以本质上还是 err 对象输出）
SocketHandler：输出到 socket，可以网络传输日志数据
MemoryHandler：输出到内存

Log4j 的使用：
Log4j 是最早的日志框架，需要导入包
Log4j 由三个组件构成，日志信息的优先级、日志信息的输出目的地和日志输出格式
日志的优先级为：ERROR、WARN、INFO、DEBUG
日志的详细配置内容请看 log4j.properties，该配置文件的名称和路径是写好了的，是一种约定

Log4j2 的使用
日志等级：off、fatal、error、warn、info、debug、trace、all
和 Log4j 相同，也有配置文件，配置文件的路径也在 classpath 下配置文件的优先级为：
log4j-test.properties -> log4j2-test.yml -> log4j2-test.json -> log4j2-test.xml -> log4j.properties -> log4j2.yml -> log4j2.json -> log4j2.xml
配置文件的结构：
Appdenders ->
Appender ->
Filter ->
Layout ->
Policies ->
Strategy

Loggers ->
Logger ->
RootLogger

Appender 用于定义日志内容的去向，要么是控制台，要么是文件等，Filter 用于过滤
Layout 用于控制日志的输出格式
Policies 用于控制日志合适进行滚动
Strategy 用于控制日志如何进行滚动

Logger 用于决定哪个类，哪个包下的日志信息，去向哪个管道，以及它们的流量
