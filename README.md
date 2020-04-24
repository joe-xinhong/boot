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
 ###### 1.AsyncService及三个线程方法
 ###### 2.AsyncServiceImpl实现AsyncService,每个方法上添加@Async
 ###### 3.@EnableAsync //开启异步调出
  
  ## 三、静态代码块执行顺序
  #### 1.创建包dto
  ###### 1.Fathers和Sons类进行测试
  #### 2.结论
  >1.静态代码块的特征，随着类的加载而执行，而且只执行一次<br>
  2.在子类中执行main方法，由于子类继承父类，所以父类中的静态代码块优先执行一次<br>
  3.静态代码块—>非静态代码块—>构造函数(执行顺序[先父后子])<br>
 