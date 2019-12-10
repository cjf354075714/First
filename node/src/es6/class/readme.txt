传统的 JS 中的对象是依赖 function 来实现的：

function Object(x, y) {
    this.x = x;
    this.y = y;
}
Object.prototype.functionName = function() {
    // TODO 类里面的方法逻辑
}

这不符合大部分语言的面向对象的语法，所以在 ES6 出现了 class 的概念，是一个语法糖，目的就是将 JS 的面向对象的逻辑变得更清晰

