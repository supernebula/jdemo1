# tech

thymeleaf

[Thymeleaf一 Spring boot integration](https://blog.csdn.net/hry2015/article/details/71374591)

[thymeleaf base](https://www.cnblogs.com/vinphy/p/4674247.html)

pagehelper

[Mybatis-PageHelper](https://github.com/pagehelper/Mybatis-PageHelper)

[Mybatis-PageHelper /README_zh.md](https://github.com/pagehelper/Mybatis-PageHelper/blob/master/README_zh.md)

[use mybatis page-plugin PageHelper5.0.0 issue](https://blog.csdn.net/Appleyk/article/details/77318175)

mybatis generator

[
Automatically generate Dao, Model, and Mapping related files using Mybatis-Generator](https://www.cnblogs.com/smileberry/p/4145872.html)

[github.com/mybatis/generator/releases](https://github.com/mybatis/generator/releases)

[Using the Generated Objects](http://www.mybatis.org/generator/generatedobjects/results.html)


# spring boot 

[Spring Boot 官方Doc （1）first use](https://www.cnblogs.com/larryzeal/p/5799195.html#c1)

spring-boot-maven-plugin

[Spring Boot Maven Plugin打包异常及三种解决方法](https://www.cnblogs.com/thinking-better/p/7827368.html)

[SpringBoot的Maven父子项目，一直无法将src/main/resource下面的xml文件打包到target/class](https://bbs.csdn.net/topics/392406185)

[利用MAVEN打包时，如何包含更多的资源文件](http://www.programgo.com/article/49183320532/)

## issue

1. [ 关于SpringBoot bean无法注入的问题（与文件包位置有关）](https://blog.csdn.net/gefangshuai/article/details/50328451)
 
 @SpringBootApplication(scanBasePackages = {"com.essg.service", "com.essg.service.impl"})
 
 2.
 
 2.1 [Whitelabel Error Page. This application has no explicit mapping for /error. status=404](https://www.oschina.net/question/221449_2233996)
 
 Whitelabel Error Page
 
 This application has no explicit mapping for /error, so you are seeing this as a fallback.
 
 Thu Dec 27 13:42:54 CST 2018
 There was an unexpected error (type=Not Found, status=404).
 No message available
 
 2.1.OK 
 
 [Whitelabel Error Page【springcloud-访问接口会员访问时，报错】](https://blog.csdn.net/czbkhhh/article/details/81353219)
 
 报错原因：
 


1. @ComponentScan或 @SpringBootApplication的basePackages 仅仅指定了不分包，但是没有在APP.class类里面注入，controller类

注意：
@ComponentScan
@SpringBootApplication

添加注解后,spring将只扫描注解配置的包，不再自动扫描启动类所在包及子包下的文件；例如：  @ComponentScan(basePackages= {“com.yyy.bbb”,”com.yyy.ccc”})

 不推荐的解决方法：
 
 以下仅供参考
 
 如图所示，在app.class类里面，加入controller包即可;
 
 ``` java
 
 @SpringBootApplication(scanBasePackages = {"com.essg.service", "com.essg.service.impl"}) //添加注解后,spring将只扫描注解配置的包，不再自动扫描启动类所在包及子包下的文件
 @MapperScan({"com.essg.dao.mapper.custom","com.essg.dao.mapper"})
 @ComponentScan(basePackages = {"com.essg.web.manage.controller"})  //  要想spring自动扫描所有包，两种方式：1. 不指定任何包；2.注册项目中所有的包！！所有的！（强烈部不推荐）@ 解决此问题，Whitelabel Error Page .This application has no explicit mapping for /error, so you are seeing this as a fallback.
 public class EssgWebManageApplication {
 
 }
 
 ```
 
 
 
 
 
 2.2 [Spring Boot自定义错误页面，Whitelabel Error Page处理方式](https://my.oschina.net/dabird/blog/593643)
 
 2.3 [springboot 初级错误](https://www.oschina.net/question/221449_2233996)
 
 2.4 [https://blog.csdn.net/fansili/article/details/78880257]()



idea issue

1.[Diamond types are not supported at this language level](https://blog.csdn.net/w605283073/article/details/79980175)

对src目录右键，make directory as ->sources root

[IDEA不能New Package](https://blog.csdn.net/wangruoao/article/details/82996710)

[ Information:java: javacTask: 源发行版 1.8 需要目标发行版 1.8](https://www.cnblogs.com/wormday/p/8424855.html)

Spring Configuration Check
Unmapped Spring configuration files found
Please configure Spring facet or use 'Create Default Context' to add one including all unmapped files;
[Show help in idea site](https://www.jetbrains.com/help/idea/2018.3/spring-support.html?utm_content=2018.3&utm_medium=link&utm_source=product&utm_campaign=IU#spring-file-set)

2. No Spring Session store is configured: set the 'spring.session.store-type' property

solution：
[关于redis session报错](https://www.jianshu.com/p/150520818875)
https://www.jianshu.com/p/150520818875

cause:
 在对项目进行codis替换成redis时发生了一个错误，错误信息如下：
 org.springframework.beans.factory.BeanCreationException: Error creating bean with name
  'org.springframework.boot.autoconfigure.session.SessionAutoConfiguration$SessionRepositoryValidator': Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: No Spring Session store is configured: set the 'spring.session.store-type' property
  因为之前的codis使用了@EnableRedisHttpSession(maxInactiveIntervalInSeconds =86400)注解，替换成redis之后并没有添加该注解，导致了启动的时候报错，但是在属性文件中添加spring.session.store-type=none，启动不报错了，但是redis少了很多key值。所以后面还是加了一个类
  将@EnableRedisHttpSession(maxInactiveIntervalInSeconds =86400)以及@Configuration注解加上，这才没有报错。
 



3. Error starting ApplicationContext. To display the auto-configuration report re-run your application with 'debug' enabled.

solution：


4. 控制台显示：
 Cannot find template location: classpath:/templates/ (please add some templates or check your Thymeleaf configuration)

cause:

5. This application has no explicit mapping for /error, so you are seeing this as a fallback.

出现这个异常说明了跳转页面的url无对应的值.

原因1:
Application启动类的位置不对.要将Application类放在最外侧,即包含所有子包 
原因:spring-boot会自动加载启动类所在包下及其子包下的所有组件.

6. idea spring boot 启用 debug输出，Edit Configurations > Spring Boot :  XxxxApplication > Configuration > Spring Boot > 勾选 Enable debug output

debug 设置相关 [Spring Boot 运行原理 - 查看Spring Boot自动配置项](https://www.jianshu.com/p/4ab743fe4f3b)


# Data

## issuce

dao层常见问题

1.Description:

Field customCategoryMapper in com.essg.service.impl.CategoryServiceImpl required a bean of type 'com.essg.dao.mapper.custom.CustomCategoryMapper' that could not be found.

Action:
Consider defining a bean of type 'com.essg.dao.mapper.custom.CustomCategoryMapper' in your configuration.

[Consider defining a bean of type xxxxMapper in your configuration](https://blog.csdn.net/weixin_39651964/article/details/80249763)


mapper需要加注解,

在启动类加上注解
@MapperScan(value = "com.demo.mapper")

若不是原生配置,可以在启动类上加上@MapperScan注解,但并不是最正确的.最理想的是在MyBatis的配置文件上加

2. Caused by: java.lang.ClassNotFoundException: com.essg.dao.mapper.custom.CustomCategoryMapper

cause：
web-manage 没有添加 dao层依赖，需要在pom.xml 添加如下：

        <dependency>
            <groupId>com.essingle</groupId>
            <artifactId>essg-dao</artifactId>
            <version>1.0-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>


## tutorial

[springboot(六)：如何优雅的使用mybatis](https://mp.weixin.qq.com/s?__biz=MzI4NDY5Mjc1Mg==&mid=2247483704&idx=1&sn=b29019ff1d1ec032979935bd94cf544c&chksm=ebf6d947dc81505192aa69a966058dcccc9e7ff2dae5b93703f229f1939397ecad76a29cc6cf&scene=21#wechat_redirect)


#mvn 相关

1. 在执行 mvn package 之前要先执行"mvn clean package" 命令， -e 打印错误堆栈信息；

2. mvn clean package -e

错误：ould not resolve dependencies for project

原因，mysql数据库未启动；

[Could not resolve dependencies for project](https://blog.csdn.net/u010758410/article/details/79453628)

[Error. Maven: The packaging for this project did not assign a file to the build artifact](https://stackoverflow.com/questions/6308162/maven-the-packaging-for-this-project-did-not-assign-a-file-to-the-build-artifac)
