package com.czh.springboot.multiple.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.czh.springboot.AppConfiguration;
import com.czh.springboot.JdbcTemplateDataSourceConfig;

public class MultiSourceV1Test {

	
	public static void main(String [] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcTemplateDataSourceConfig.class);
		
		
		
		IMultiSourceV1 multiSource1 = context.getBean(MultiSourceV1.class);
		String counts = multiSource1.queryRecordsCount();
	}

}
