## 1、在已经使用mybatis的项目里引入mybatis-plus,结果不能共存的解决

### 1.1 问题描述

在已经引入mybatis的项目中，引入新的mybatis-plus。然后再执行对应的方法是，控制台报错说找不到对应的方法。

```java
2023-09-13 20:04:34 |ERROR |http-nio-8282-exec-3 |GlobalExceptionHandler.java:24 |com.zheng.yu.config.handler.GlobalExceptionHandler |Invalid bound statement (not found): com.zheng.yu.mapper.UserMapper.getUserByUsername

```



### 1.2 解决方法

需要修改的地方在yml的配置文件里：

mybatis的相关配置 修改成mybatis-plus的

```java
#整合mybatis
#mybatis.type-aliases-package=com.zheng.yu.pojo
#mybatis.mapper-locations=classpath:mybatis/mapper/*.xml

#整合mybatis-plus
mybatis-plus.type-aliases-package=com.zheng.yu.pojo
mybatis-plus.mapper-locations=classpath:mybatis/mapper/*.xml

```

