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

@Configuration //注册到spring容器中
@MapperScan(basePackages = "com.test.boot.db2.mapper",sqlSessionFactoryRef = "db2SqlSessionFactory")
public class DataSource2 {

    /**
     * 配置db2数据库
     * @return
     */
    @Bean(name = "db2Datasource")
    @ConfigurationProperties(prefix = "spring.datasource.db2")//获取全局配置文件中数据
    public DataSource testDatasource(){
        DataSource build = DataSourceBuilder.create().build();
        return build;
    }

    /**
     * 创建SqlSessionFactory
     * @param dataSource
     * @return
     */
    @Bean(name = "db2SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db2Datasource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //TbUsersMapper.xml的位置;如果使用的是注解sql的话可以省去此行代码
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:db2/mapper/*.xml"));
        return bean.getObject();
    }

    /**
     * 配置事务管理
     * @param dataSource
     * @return
     */
    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db2Datasource")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 封装数据库操作，线程安全的
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db2SqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
