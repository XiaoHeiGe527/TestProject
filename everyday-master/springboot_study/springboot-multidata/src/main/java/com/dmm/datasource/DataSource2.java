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
 * @create 2019/7/31
 */
@Configuration
@MapperScan(basePackages = "com.dmm.db2.mapper",sqlSessionFactoryRef = "db2SqlSessionFactory")
public class DataSource2 {
    /**
     * 配置db1数据库 数据源
     * @return
     */
    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource testDataSource1(){
        //return DataSourceBuilder.create().build();
        return new DruidDataSource();
    }

    /**
     * 创建SqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */

    @Bean(name = "db2SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory1(@Qualifier("db2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 事务  事务来源于connection中，而connection在数据源中
     * @param dataSource
     * @return
     */
    @Bean(name = "db2DataSourceTransactionManager")
    public DataSourceTransactionManager testDataSourceTransactionManager1(@Qualifier("db2") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

