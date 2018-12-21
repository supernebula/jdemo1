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


spring boot 

[Spring Boot 官方Doc （1）first use](https://www.cnblogs.com/larryzeal/p/5799195.html#c1)

spring-boot-maven-plugin

[Spring Boot Maven Plugin打包异常及三种解决方法](https://www.cnblogs.com/thinking-better/p/7827368.html)

[SpringBoot的Maven父子项目，一直无法将src/main/resource下面的xml文件打包到target/class](https://bbs.csdn.net/topics/392406185)

[利用MAVEN打包时，如何包含更多的资源文件](http://www.programgo.com/article/49183320532/)



idea issue

[Diamond types are not supported at this language level](https://blog.csdn.net/w605283073/article/details/79980175)

对src目录右键，make directory as ->sources root

[IDEA不能New Package](https://blog.csdn.net/wangruoao/article/details/82996710)

[ Information:java: javacTask: 源发行版 1.8 需要目标发行版 1.8](https://www.cnblogs.com/wormday/p/8424855.html)

Spring Configuration Check
Unmapped Spring configuration files found
Please configure Spring facet or use 'Create Default Context' to add one including all unmapped files;
[Show help in idea site](https://www.jetbrains.com/help/idea/2018.3/spring-support.html?utm_content=2018.3&utm_medium=link&utm_source=product&utm_campaign=IU#spring-file-set)


dao层常见问题

Description:

Field customCategoryMapper in com.essg.service.impl.CategoryServiceImpl required a bean of type 'com.essg.dao.mapper.custom.CustomCategoryMapper' that could not be found.

Action:
Consider defining a bean of type 'com.essg.dao.mapper.custom.CustomCategoryMapper' in your configuration.

[Consider defining a bean of type xxxxMapper in your configuration](https://blog.csdn.net/weixin_39651964/article/details/80249763)


mapper需要加注解,

1.在启动类加上注解
@MapperScan(value = "com.demo.mapper")

2.若不是原生配置,可以在启动类上加上@MapperScan注解,但并不是最正确的.最理想的是在MyBatis的配置文件上加
