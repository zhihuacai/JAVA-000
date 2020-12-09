package com.czh.springboot.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcHikari {
	public static void main(String [] args) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
			conn = HikariConn.getConnection(conn);
			stmt = (Statement) conn.createStatement();
			String sql = "select Name,CountryCode,Population from City limit 10"; 
			ResultSet rs = stmt.executeQuery(sql); 
			while(rs.next())
			{
				String name = rs.getString("Name");
				String countryCode = rs.getString("CountryCode");
				int pupulation = rs.getInt("Population");
				
				System.out.println(name + ", " + countryCode + ", " + pupulation);
			}
			
			rs.close();
    		stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
        	try {
        		if(stmt != null)
        			stmt.close();
        		if(conn != null)
        			conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        
	}
    
    

}
