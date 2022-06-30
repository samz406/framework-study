package org.samz.mybatisdemo.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * @author: lilin
 * @Date: 2022/6/28 16:50
 * @Description:
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    private Object defaultTargetDataSource;

    private Map<Object, Object> resolvedDataSources;

    public MyRoutingDataSource(Object defaultTargetDataSource, Map<Object, Object> resolvedDataSources) {

        this.defaultTargetDataSource = defaultTargetDataSource;
        this.resolvedDataSources = resolvedDataSources;
        this.setDefaultTargetDataSource(defaultTargetDataSource);
        this.setTargetDataSources(resolvedDataSources);

    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.get();
    }
}
