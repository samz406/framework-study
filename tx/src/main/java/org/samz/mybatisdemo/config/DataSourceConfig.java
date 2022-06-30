package org.samz.mybatisdemo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: lilin
 * @Date: 2022/6/2 17:34
 * @Description:
 */
@Configuration
@Slf4j
@MapperScan("org.samz.mybatisdemo.mapper")
public class DataSourceConfig {

    @Bean("dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    @Primary
    public DataSource dataSource() {
        log.info("init orderDataSource");
        System.out.println("init orderDataSource");
        return new HikariDataSource();
    }

    @Bean("productDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSource productDataSource() {
        log.info("init productDataSource");
        System.out.println("init productDataSource");
        return new HikariDataSource();
    }

    @Bean

    public MyRoutingDataSource myRoutingDataSource() {

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("ds1", dataSource());
        targetDataSources.put("ds2", productDataSource());
        return new MyRoutingDataSource(dataSource(), targetDataSources);
    }


}
