操作系统中，文件指就是文件，在 JAVA 中，文件对象指的是文件或者目录



File 的详细方法

File 构造函数
File(String parent, String child);
通过给定的父抽象路径和子路径创建一个新的 File 实例，就是给定父路径和子路径，然后创建一个 File 对象

getName -> 返回文件对象的名字
getPath -> 返回文件对象的路径，我们创建这个对象是什么路径，就返回什么路径
getParent -> 返回文件对象的父目录
getAbsolutePath -> 返回文件对象的绝对路径，如果创建文件对象时给的是相对路径
就返回 user.dir + 相对路径，但是不会解析
getCanonicalPath -> 返回正确的绝对路径，反正就是正确的