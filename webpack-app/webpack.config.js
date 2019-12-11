const path = require('path');

const CleanWebpackPlugin = require('clean-webpack-plugin');

module.exports = {
    entry: {
        index: './src/index.js',
        search: './src/search.js'
    },
    output: {
        path: path.join(__dirname, 'dist'),
        filename: '[name].js'
    },
    mode: 'production',
    module: {
        rules: [
            {test: /\.js$/, use: 'babel-loader'},
            {test: /\.css$/, use: ['style-loader', 'css-loader']}
        ]
    },
    // 是否开启文件变化的监听器
    watch: true,
    watchcOptions: {
        // 文件监听忽略的文件夹
        ignored: /node_modules/,
        // 文件发生变化后，延迟多长时间 ms 在去执行，原理是 webpack 会将变化的结果缓存起来，过一段时间再执行
        aggregateTimeout: 300,
        // webpack 通过不停轮询文件是否发生变化，轮询周期
        poll: 1000
    },
    plugins: [
    ]
};