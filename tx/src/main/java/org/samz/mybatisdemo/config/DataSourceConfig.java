package org.samz.mybatisdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author: lilin
 * @Date: 2022/6/2 17:34
 * @Description:
 */
@Configuration
public class DataSourceConfig {


    @Bean
    @Qualifier("ORDER")
    public DataSource orderDataSource() {

        return new HikariDataSource();
    }

    @Bean
    @Qualifier("PRODUCT")
    public DataSource productDataSource() {

        return new HikariDataSource();
    }


}
