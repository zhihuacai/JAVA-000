package com.czh.springboot.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConn {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/world";
    static final String USER = "root";
    static final String PASS = "Passw0rd";
    
    public static Connection getConnection(Connection conn) throws SQLException, ClassNotFoundException
    {
        //Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	return conn;
    };

}
