# SSM + vue 前后端分离 客户CURD+登录
## 后端怎么部署
1. 将sql文件夹中的 .sql文件 在本地数据库创建
2. 更改 resources->applicationContext.xml文件中的 数据库名称 用户名 密码
3. 本项目使用maven管理，导入到idea后需要下载 pom.xml 文件中的依赖
4. 针对第三项，如果下载的很慢，去搜一下**怎么在idea中配置阿里云maven仓库**
5. 因为是ssm项目，项目的运行需要使用tomcat，我使用的版本是**9.x版本对应的jdk版本是1.8**，注意在Project Structure 看一下自己的jdk版本
6. 可以成功运行，Tomcat 启动不成功的，注意看一下自己的8080端口号是否被占用了
## 前端怎么部署
1.前端使用 vue3写的
2.本地部署需要 有node.js 环境，版本号16.X -> 18.x 应该都可以，我的是18.20.X
3.在控制台输入 npm install
4. 无报错后接着输入 npm run dev 
5. 启动成功
