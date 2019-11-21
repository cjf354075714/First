1，== 和 equals 的区别
首先，== 是 Java 写死的，对于 C++ 而言，可以重载运算符，但是 Java 中 == 就是 表示等号两端的对象所在的栈中的值是否相等
比如，int i = 1，int j = 0，i 和 j 是基础变量，在占中存的就是 1，它们本身，所以 i == j
如果 Integer i = new Integer(1)，Integer j = new Integer(1)。这时 i 和 j 是一个对象，它们在栈中的值是该对象在堆中的地址
显然，这是两个不同的对象，因为都是 new 出来的，所以 i ！= j
equals 是一个方法，源自 Object，本质上是调用 == 来实现，所以如果不重写该方法，那么 equals 就= ==；
但是，如我们重写了 equals 方法，equals 就和 == 没有什么必然的关系了

2，hash 算法
本质上是一个函数，将一串长输入转化为一串短输出，不可逆，且不同的输入将会得到相同的输出

2.1，hashCode
是 Object 类的方法，可以自定义，一般来说是根据类对象的值或者地址进行一番计算，返回一个长的整形数
也就是说，hashCode 是一个类实例的代表，一般来说不同的类实例拥有不同的 hashCode，因为类实例的字段不同
但是，也许 hashCode 的算法会导致相同，那也没法了

3，请看 dataStructure -> HashMap
4，为什么重写 equals 方法就必须重写 hashCode 方法