Locale 类，表示一个特定的地区，比如中国大陆和香港台湾就不是同一个地区
这个类应该是获取操作系统底层的地区信息，然后用于程序国际化
获取方式：Locale locale = Locale.getDefault();
locale 对象可以获取国家地区代码，国家语言，语言信息，语言环境等
String country = locale.getCountry(); 获取国家代码