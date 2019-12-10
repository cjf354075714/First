NPM 是一个工具，是一个命令行的集合，主要是导入别人写的 JS 包
或者运行一些 Node 的脚本命令，有点像 Maven
比如导入别人的安装包，在某个目录下导入，那么结果就是在这个目录下货创建
node-modules，然后将 JS 的包写到这个包下面
一般来说都本地安装吧，也就是 npm install moduleName

在每个包中，有一个 package.json 的文件，这就相当于 Maven 引入的 jar 包的 pom.xml 文件
使用 npm uninstall moduleName 来卸载

npm install moduleName
npm uninstall moduleName
npm search moduleName
npm ls
npm publish
npm init
npm update moduleName
