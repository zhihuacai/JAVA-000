package com.czh.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppConfiguration.class,DataSourceConfig.class,JdbcTemplateDataSourceConfig.class})
public class AppAutoConfiguration {

}
