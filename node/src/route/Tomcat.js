const http = require('http');
const url = require('url');
const Router = require('./Router');
function Tomcat() {
    let onRequest = function (request, response) {
        let pathName = url.parse(request.url).pathname;
        console.log('接收到来自' + pathName + '的请求');
        Router(pathName);
        response.writeHead(200, {'Content-Type': 'text/plain'});
        response.write('hello world');
        response.end();
    };
    http.createServer(onRequest).listen(8080);
    console.log('监听8080');
}

exports.tomcat = Tomcat;