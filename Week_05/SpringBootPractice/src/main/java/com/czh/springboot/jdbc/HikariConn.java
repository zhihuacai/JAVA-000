package com.czh.springboot.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConn {
    static final String configFile = JdbcHikari.class.getClassLoader().getResource("jdbc.properties").getPath();
    static final HikariDataSource ds = new HikariDataSource(new HikariConfig(configFile));
    
    public static Connection getConnection(Connection conn) throws SQLException, ClassNotFoundException
    {
    	conn = ds.getConnection();
    	return conn;
    };
	

}
