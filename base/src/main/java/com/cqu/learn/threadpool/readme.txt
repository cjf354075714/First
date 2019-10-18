线程池
一、基本概念
线程池是管理线程的对象，目的是不让我们自己手动创建线程，方便管理
还可以让我们自定义组件的特性，构造函数：
ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory,
RejectedExecuteHandler handler)
1，组件概念
int corePoolSize 表示线程池中的核心线程数，这个数目的线程在工作完毕之后不会消亡
int maximumPoolSize 表示线程池中能存在的最大线程数，多余的线程会自动消亡
long keepAliveTime 多余的线程会在最多多少时间段里消亡
TimeUnit unit 表示 keepAliveTime 的时间单位
BlockingQueue<Runnable> workQueue 表示任务队列
ThreadFactory threadFactory 表示线程创建的工厂
RejectedExecutionHandler handler 表示拒绝多余的任务的方法