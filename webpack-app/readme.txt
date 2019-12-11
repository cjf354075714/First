为什么需要 webpack
1，传统的前端项目文件很多，多个文件多个请求浪费资源
2，JS 文件需要压缩
3，react vue 有自己的语法糖、ES6 也需要转化

webpack 的配置文件
webpack.config.js，可以通过 webpack --config 指定

基本格式：
module.exports = {
    entry: '打包整个项目的整体入口，这个文件引入了哪些文件，那些文件又引入了那些文件，然后形成一个图，这个文件就是图中被遍历的第一个文件',
    // entry 可以有多个入口，一般来说是单入口，就是单页面应用，如果是多页面应用就是多个入口，
    // 多个入口就是将 entry 定义为一个 key-value 的键值对，而不是字符串
    output: '打包输出的目录',
    // 如果 entry 是多个入口，则使用占位符的概念，filename: '[name].js'
    mode: '环境',
    // 四个可选值：production、development、none 用于webpack 的内置功能
    module: {
        rules: [
            {Loader 配置},
            // webpack 本来只支持 JS 和 JSON 文件，Loader 就是用来支持其他的文件的，本身是一个函数，接收源代码比如 CSS 并返回
            // babel-loader 将 ES6、7 转化为 ES5
            // css-loader 打包 CSS
            // less-loader 将 LESS 转化为 CSS
            // ts-loader 将 TS 转化为 JS
            // file-loader 图片、字体文件
            // row-loader 将文件以字符串的形式导入
            // thread-loader 多进程打包 JS 和 CSS
            // 在 rule 中通过 test 类似于正则表达的格式来指定哪些文件使用什么 loader 加载
            { test: /\.txt$/, use: 'raw-loader'}
            // 指定 txt 文件使用 raw-loader 的加载器加载
        ]
    },
    plugins: [插件配置]
    // loader 无法做的事情，就可以使用 plugins ，作用于整个构建过程
    // 是否开启文件变化的监听器
    watch: true,
    watchcOptions: {
        // 文件监听忽略的文件夹
        ignored: /node_modules/,
        // 文件发生变化后，延迟多长时间 ms 在去执行，原理是 webpack 会将变化的结果缓存起来，过一段时间再执行
        aggregateTimeout: 300,
        // webpack 通过不停轮询文件是否发生变化，轮询周期
        poll: 1000
    }
}

webpack 安装：
npm install webpack webpack-cli --save-dev
这里还需要安装 webpack-cli，此外，--save-dev 就是指定，这个 webpack 是不需要打包到生产环境中的
使用 --save-dev 可以指定该包的依赖规则，就相当于 maven 中的 <scope>test</scope>

此外，package.json 在默认情况下，会识别到 node_modules 下的包中的 .bin 文件夹中的命令，我们就可以在
package.json 中的 scripts 里面定义我们的命令

接着，又有一个很重要的概念，webpack 不认识 JSX、ES6 的语法，需要在 module 中指定什么样的文件，使用
什么样的 loader 去加载解析，完成打包
然后这个 loader 就涉及到一个叫 babel-loader 的概念，这个 babel 是一个将 ES5 转化为 ES6 的工具，就相当于
一种命令行，可以指定需要转化的 JS 文件，然后指定输出的目录，并直接输出 ES5 的文件
那么如何配置 babel 呢？待看

接下来是 css-loader
需要使用两个 style-loader 和 css-loader
至于字体和图片的打包，都是一样的

接下来是文件监听，在源代码发生变化的时候，会自动构建并输出文件
1，在 package.json 中的 script 里面的 webpack 后面加上 --watch
2，直接在 webpack.config.js 文件中添加上 watch: true

热更新：
webpack-dev-server
首先引入插件，new webpack.HotModuleReplacementPlugin()
设置 devServer：{}，待看
还有 webpack-dev-middleware 作为一个热更新，但是没有必要了
原理：

文件指纹：
基本上打包后输出的文件，后面都有一些后缀名，就被称为文件指纹，一般用作版本管理

代码压缩：
HTML 压缩，CSS 压缩、JS 压缩

自动删除之前的生成目录文件

npm i clean-webpack-plugin -D
