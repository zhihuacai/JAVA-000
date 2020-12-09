package com.czh.springboot.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTransaction {
	public static void main(String [] args) {
        Connection conn = null;
        
        try {
			conn = MysqlConn.getConnection(conn);
			
			conn.setAutoCommit(false);
			
			String sql = "insert into TestAccount(AccountID, Amount) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setFloat(2, (float) 2000.0);
			
			ps.executeUpdate();
			
			ps.setInt(1, 2);
			ps.setFloat(2, (float) 5000.0);
			ps.executeUpdate();
			
			conn.commit();
			
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
        		if(conn != null)
        			conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        
	}
}
