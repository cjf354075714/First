Node 中提供了简单的模块系统，类似于 JAVA 中的包和类的概念
导出包分为两个概念：
导出一个模块，这个模块在 JS 文件中独占
导出一个模块，这个模块和该 JS 文件中的其他模块一起占 JS 文件

多个模块在同一个 JS 文件中的格式：

exports.moduleName = function(Object... params) {
    // TODO 一些逻辑
}

// 一般来说，要使用一个文件下的模块，直接使用该文件的文件名作为导入的依据
// 然后，导入得到的一个变量，直接 . 就可以调用方法
// 这种方法一般是将一些工具类方法，作为一个 JS 文件集合
let fileName = require('./fileName');

一个 JS 文件只有一个模块

// 这种方式一般使用得很多，并且都是将这个模块当做一个类来使用的，使用之前需要先 new
function funcName(Object... params) {
    // TODO 一些逻辑
}

module.exports = funcName;

