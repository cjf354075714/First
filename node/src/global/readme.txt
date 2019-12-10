全局变量
在 JS 中，根据环境的不同，有不同的全局变量，比如在浏览器中的 JS，那全局变量就是 document
在 Node 中，全局变量就是 global。然后它有一些全局的属性，可以随时访问，不需要显示的导入

_filename：输出该文件所在的绝对路径
_dirname：输出该文件所在路径的绝对路径
setTimeout(functionName, time(ms));
clearTimeout(param);删除 setTimeout 所创建的时间对象
setInterval(functionName, time(ms));设置重复的时间触发器
console 属性，它是 global 的一个属性
process 对象，提供了很多关于和系统交互的方法，类似于 JAVA 中的 System