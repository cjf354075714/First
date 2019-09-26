1970-01-01 00:00:00
是unix系统采用的计算时间的起点，也就是说，我们现在获取的时间
都是在该时间基础上计算时间长度然后按照格式输出的

Date类
Calendar类
SimpleDateFormatter类
DateTimeFormat类

实际上Date底层就是使用的Calender类
以后我也用Calender，因为它支持日期计算，并且很好用，还可以转化为Date
但是需要自己计算

Calender->Date->SimpleDateFormat->String