const path = require('path');
// webpack 会使用该组件，然后在输出目录中自动生成一个 HTML 文件
const HtmlWebpackPlugin = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

const webpackConfig = {
    entry: {
        index: './src/index.js'
    },
    output: {
        filename: 'static/js/[name][chunkHash].js',
        path: path.resolve(process.cwd(), 'dist')
    },
    mode: 'development',
    module: {
        rules: [
            {test: /\.css$/, use: [MiniCssExtractPlugin.loader, 'css-loader']},
            {test: /\.less$/, use: [MiniCssExtractPlugin.loader, 'css-loader', 'less-loader']},
            {test: /\.(png|jpg|gif)$/, use: [{loader: 'file-loader', options: {name: 'static/images/[name].[ext]', publicPath: '/'}}]},
            {test: /\.js$/, exclude: /(node_modules | bower_components)/, use: {loader: 'babel-loader', options: {presets: ['@babel/preset-env']}}}
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({
            filename: 'index.html',
            template: 'public/index.html'
        }),

        new MiniCssExtractPlugin({
            filename: 'static/css/[name][chunkHash].css'
        })
    ],
    devServer: {
        port: 3000,
        open: true
    }
};

module.exports = webpackConfig;