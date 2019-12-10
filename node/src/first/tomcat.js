let http = require('http');
let http2 = require('http');

let responseFunction = function (request, response) {
    response.writeHead(200, {'Content-Type': 'text/plain'});
    response.end('hello world \n');
};

// 本来这里是阻塞的，如果是单线程的话，这里是会被阻塞的
// 但是后面的程序输出了，就表示 node 是有特殊机制的
// 这里的特殊机制，就是回调，就是说，我先定义好，当有事件来的时候，我直接调用某些事件
// 比如这里的 responseFunction，我直接调用这里的函数就行了
// 这种函数就叫回调函数，我回头掉，这样的机制，使得后面的程序将得以输出，也就打成了异步的要求
// 如果我写两个 http 呢？显然是可以的
http.createServer(responseFunction).listen(8080);
http2.createServer(responseFunction).listen(3000);
console.log('listen 8080 port...');