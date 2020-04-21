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

