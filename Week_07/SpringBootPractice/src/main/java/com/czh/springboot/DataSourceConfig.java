package com.czh.springboot;

import java.util.HashMap;
import java.util.Map;

//import javax.activation.DataSource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.czh.springboot.multiple.source.DataSourceType;
import com.czh.springboot.multiple.source.RoutingDataSource;
@Configuration
public class DataSourceConfig {
	
    //主数据源配置 ds1数据源
    @Primary
    @Bean(name = "ds1DataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSourceProperties ds1DataSourceProperties() {
        return new DataSourceProperties();
    }

    //主数据源 ds1数据源
    @Primary
    @Bean(name = "ds1DataSource")
    public DataSource ds1DataSource(@Qualifier("ds1DataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    	//return DataSourceBuilder.create().build();
    }

    //第二个ds2数据源配置
    @Bean(name = "ds2DataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSourceProperties ds2DataSourceProperties() {
        return new DataSourceProperties();
    }

    //第二个ds2数据源
    @Bean("ds2DataSource")
    public DataSource ds2DataSource(@Qualifier("ds2DataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
    
    
    //第三个ds3数据源配置
    @Bean(name = "ds3DataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.ds3")
    public DataSourceProperties ds3DataSourceProperties() {
        return new DataSourceProperties();
    }

    //第三个ds3数据源
    @Bean("ds3DataSource")
    public DataSource ds3DataSource(@Qualifier("ds3DataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }    
	
    @Bean("targetDataSource")
    public DataSource myRoutingDataSource(
    		@Qualifier("ds1DataSource") DataSource ds1DataSource,
    		@Qualifier("ds2DataSource") DataSource ds2DataSource,
    		@Qualifier("ds3DataSource") DataSource ds3DataSource){
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.MASTER, ds1DataSource);
        targetDataSource.put(DataSourceType.SLAVE1, ds2DataSource);
        targetDataSource.put(DataSourceType.SLAVE2, ds3DataSource);
        
        RoutingDataSource myRoutingDataSource = new RoutingDataSource();
        myRoutingDataSource.setDefaultTargetDataSource(ds1DataSource);
        myRoutingDataSource.setTargetDataSources(targetDataSource);
        
        
        return myRoutingDataSource;
    }     
    
	

}
