package com.test.boot.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
/**
* @Description:    db1的数据源配置
* @Author:         Joe
* @CreateDate:     2020/4/21 15:15
*/
@Configuration //注册到spring容器中
@MapperScan(basePackages = "com.test.boot.db1.mapper",sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DataSource1 {

    /**
     * 配置db1数据库
     * @return
     */
    @Bean(name = "db1Datasource")
    @ConfigurationProperties(prefix = "spring.datasource.db1")//获取全局配置文件中数据
    @Primary //指定默认数据源
    public DataSource testDatasource(){
        DataSource build = DataSourceBuilder.create().build();
        return build;
    }

    /**
     * 创建SqlSessionFactory
     * @param dataSource
     * @return
     */
    @Bean(name = "db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db1Datasource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //TbUserMapper.xml的位置;如果使用的是注解sql的话可以省去此行代码
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:db1/mapper/*.xml"));
        return bean.getObject();
    }

    /**
     * 配置事务管理
     * @param dataSource
     * @return
     */
    @Bean(name = "db1TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db1Datasource")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 封装数据库操作，线程安全的
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db1SqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
