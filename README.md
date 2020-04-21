# boot[vue and spring boot]
==注意==

## 一、配置多数据源

>使用mysql数据库(介于注解比较麻烦，采用包名进行分析)<br>
#### 一、导入核心依赖<br>
>1.spring-boot-starter-web<br>
>2.mybatis-spring-boot-starter<br>
>3.mysql-connector-java<br>
#### 二、准备两个数据库的两张表<br>
>1.(db1)kings库的tb_user表<br>
>2.(db2)peace库的tb_users表<br>
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `name` varchar(20) NOT NULL default '' COMMENT '名字',
  `age` int(11) NOT NULL default '0' COMMENT '年纪',
  `password` varchar(225) NOT NULL default '' COMMENT '密码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
#### 三、修改全局配置文件application.yml<br>
#### 四、对数据源进行创建配置<br>
>1.创建包datasource<br>
>2.分别创建DataSource1和DataSource2类进行管理配置数据源db1和db2<br>
#### 五、对数据源进行创建配置<br>
>1.逆向工程生成实体及mapper等<br>
>2.mapper接口上注解@Qualifier("db2SqlSessionFactory")、@Qualifier("db1SqlSessionFactory")<br>

#### 六、创建Controller进行处理<br>
#### 六、创建Controller进行处理<br>

## 二、Spring Boot 对多线程
##### 1.问：JDK给我们提供了非常方便的操作线程的API,为什么还要使用Spring来实现多线程呢？
>1.使用Spring比使用JDK原生的并发API更简单。（一个注解@Async就搞定）<br>
 2.我们的应用环境一般都会集成Spring，我们的Bean也都交给Spring来进行管理，那么使用Spring来实现多线程更加简单，更加优雅。
 ##### 2. spring boot 如何使用多线程
 >1.Spring中实现多线程，其实非常简单，只需要在配置类中添加@EnableAsync就可以使用多线程。在希望执行的并发方法中使用@Async就可以定义一个线程任务。通过spring给我们提供的ThreadPoolTaskExecutor就可以使用线程池。<br>
 2.Spring通过任务执行器（TaskExecutor）来实现多线程和并发编程。使用ThreadPoolTaskExecutor可实现一个基于线程池的TaskExecutor。而实际开发中任务一般是非阻碍的，即异步的，所以我们要在配置类中通过@EnableAsync开启对异步任务的支持，并通过在实际执行的Bean的方法中使用@Async注解声明其是一个异步任务。
 ##### 3. 实现
 ###### 1.创建包config及配置类ThreadingConfig
 ###### 2.创建包service及类ThreadingService
  
 