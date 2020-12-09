package com.czh.springboot.multiple.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class MultiSourceV1 implements IMultiSourceV1 {
	
	@Autowired
	private JdbcTemplate ds1JdbcTemplate; 
	private JdbcTemplate ds2JdbcTemplate; 
	 
	public String  queryRecordsCount() {
		return ds1JdbcTemplate.queryForObject("select count(1) from t1", String.class);
	}
	

}
