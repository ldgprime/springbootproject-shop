package com.cos.shop.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@ConfigurationProperties(prefix="shop.datasource")
	public DataSource dataSource(){
    	return DataSourceBuilder.create().build();
	}
}
