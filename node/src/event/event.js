// 这两步就是为了导入事件的发射器这个类，这个类是所有回调函数触发的类
// 它可以定义某些事件下，执行某些操作
// 也可以直接触发某些事件
let events = require('events');
let eventEmitter = new events.EventEmitter();

eventEmitter.on('click', function () {
    console.log('事件被触发了');
});
eventEmitter.emit('click');