package com.dmm.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author DMM
 * @create 2019/7/30
 */
@Configuration
@MapperScan(basePackages = "com.dmm.db1.mapper",sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DataSource1 {

    /**
     * 配置db1数据库 数据源
     * @return
     */
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    @Primary
    public DataSource testDataSource1(){
//        return DataSourceBuilder.create().build();
        return new DruidDataSource();
    }

    /**
     * 创建SqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */

    @Bean(name = "db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory1(@Qualifier("db1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //指明映射文件，多数据源是，默认数据源会失效。
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 事务  事务来源于connection中，而connection在数据源中
     * @param dataSource
     * @return
     */
    @Bean(name = "db1DataSourceTransactionManager")
    @Primary
    public DataSourceTransactionManager testDataSourceTransactionManager1(@Qualifier("db1") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

