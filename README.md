# SSM(Spring SpringMvc Mybatis) + Vue 前后端分离,人不分离的作业
## 运行效果图
![image](https://github.com/user-attachments/assets/0f8fd561-4501-4e2b-a318-1e67c07e72f6)
![image](https://github.com/user-attachments/assets/c0221c0a-ac32-438d-a8ae-aea325811545)
![image](https://github.com/user-attachments/assets/08efd24d-22da-4980-8cdc-2fea9083c468)
## 已知的问题
在jdk9以上的版本中javax.xml.bind 包（包括 DatatypeConverter 类）被移出了标准库，转而成为可选模块。如果你的应用程序或其依赖库（如 io.jsonwebtoken）仍然依赖于这些类，但在运行时没有加载相应的模块或 JAR 文件，就会抛出 NoClassDefFoundError。

**解决方案**
在pom.xml文件中加入以下依赖，如果你是**1.8的jdk**可以忽略这个问题
```
<dependency>
   <groupId>javax.xml.bind</groupId>
   <artifactId>jaxb-api</artifactId>
   <version>2.3.1</version>
</dependency>
<dependency>
  <groupId>org.glassfish.jaxb</groupId>
  <artifactId>jaxb-runtime</artifactId>
  <version>2.3.1</version>
</dependency>
```
## 后端怎么部署
1. 将sql文件夹中的 .sql文件 在本地数据库创建
2. 更改 resources->applicationContext.xml文件中的 **数据库名称 用户名 密码**
3. 本项目使用maven管理，导入到idea后需要下载 pom.xml 文件中的依赖
4. 针对第三项，如果下载的很慢，去搜一下**怎么在idea中配置阿里云maven仓库**
5. 因为是ssm项目，项目的运行需要使用tomcat，我使用的Tomcat版本是**9.x版本对应的jdk版本是1.8**，注意在Project Structure 看一下自己的jdk版本
6. 可以成功运行，Tomcat 启动不成功的，注意看一下自己的8083端口号是否被占用了，应为前端请求地址是8083，所以Tomcat的Http端口号需要从8080改为->8083
## 前端怎么部署
1. 前端使用 vue3写的
2. 本地部署需要 有node.js 环境，版本号16.X -> 18.x 应该都可以，我的是18.20.X
3. 在控制台输入 npm install
4. 无报错后接着输入 npm run dev 
5. 启动成功
