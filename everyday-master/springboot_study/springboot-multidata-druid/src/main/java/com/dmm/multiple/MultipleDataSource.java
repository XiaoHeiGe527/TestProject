package com.dmm.multiple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源，路由
 * 获取数据源变量，用于当作lookupKey取出指定的数据源
 * @author DMM
 * @create 2019/8/5
 */
@Slf4j
public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {

        log.info("+++++++++++{}+++++++++++1",DataSourceContextHolder.getDataSource());

        return DataSourceContextHolder.getDataSource();
    }
}

