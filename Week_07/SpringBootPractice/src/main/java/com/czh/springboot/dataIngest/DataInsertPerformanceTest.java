package com.czh.springboot.dataIngest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.czh.springboot.entity.Order;
import com.czh.springboot.generatedata.GenerateOrder;
import com.czh.springboot.jdbc.MysqlConn;

public class DataInsertPerformanceTest {
	
	public void testStatement() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			conn = MysqlConn.getConnection(conn);
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			long begin = System.currentTimeMillis();
			//1000000
			for (int i = 0; i < 200000; i++) {
				Order order = GenerateOrder.generateData();
				
			    String sql = "insert into Orders(orderUserId,totalPrice,discountAmount,actualPayAmount,shopId,productId,reciever,addressId,payTransactionId) "
			    		+ "values(" 
			    		+ order.getOrderUserId() + "," + 
			    		+ order.getTotalPrice() + "," + 
			    		+ order.getDiscountAmount() + "," + 
			    		+ order.getActualPayAmount() + "," + 
			    		+ order.getShopId() + "," + 
			    		+ order.getProductId() + ",'" + 
			    		  order.getReciever() + "'," + 
			    		+ order.getAddressId() + "," + 
			    		+ i + ")";
			    stmt.execute(sql);
			}
			
			conn.commit();
			long end = System.currentTimeMillis();
			System.out.println(end - begin);
		} catch (ClassNotFoundException | SQLException e) {
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
	
	
	public void testPrepareStatement() {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = MysqlConn.getConnection(conn);
			conn.setAutoCommit(false);
			 String sql = "insert into Orders(orderUserId,totalPrice,discountAmount,actualPayAmount,shopId,productId,reciever,addressId,payTransactionId) values"
			 		+ " (?,?,?,?,?,?,?,?,?)";
			
			stmt = conn.prepareStatement(sql);
			
			long begin = System.currentTimeMillis();
			//1000000
			for (int i = 0; i < 200000; i++) {
				Order order = GenerateOrder.generateData();
				stmt.setInt(1,order.getOrderUserId());
				stmt.setFloat(2, order.getTotalPrice());
				stmt.setFloat(3, order.getDiscountAmount());
				stmt.setFloat(4, order.getActualPayAmount());
				
				stmt.setInt(5,order.getShopId());
				stmt.setInt(6,order.getProductId());
				
				stmt.setString(7,order.getReciever());
				
				stmt.setInt(8,order.getAddressId());
				stmt.setInt(9,i);
			    
			    stmt.executeUpdate();
			}
			
			conn.commit();
			long end = System.currentTimeMillis();
			System.out.println(end - begin);
		} catch (ClassNotFoundException | SQLException e) {
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
	
	
	
	
	public void testBatchStatement() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			conn = MysqlConn.getConnection(conn);
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			long begin = System.currentTimeMillis();
			//1000000
			for (int i = 0; i < 200000; i++) {
				Order order = GenerateOrder.generateData();
				
			    String sql = "insert into Orders(orderUserId,totalPrice,discountAmount,actualPayAmount,shopId,productId,reciever,addressId,payTransactionId) "
			    		+ "values(" 
			    		+ order.getOrderUserId() + "," + 
			    		+ order.getTotalPrice() + "," + 
			    		+ order.getDiscountAmount() + "," + 
			    		+ order.getActualPayAmount() + "," + 
			    		+ order.getShopId() + "," + 
			    		+ order.getProductId() + ",'" + 
			    		  order.getReciever() + "'," + 
			    		+ order.getAddressId() + "," + 
			    		+ i + ")";
			    stmt.addBatch(sql);
			    if((i+1)%1000 == 0 ) {
			    	stmt.executeBatch();
			    	stmt.clearBatch();
			    }
			}
	    	stmt.executeBatch();
	    	stmt.clearBatch();
			
			conn.commit();
			long end = System.currentTimeMillis();
			System.out.println(end - begin);
		} catch (ClassNotFoundException | SQLException e) {
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
	
	
	
	
	public void testPrepareBatchStatement() {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = MysqlConn.getConnection(conn);
			conn.setAutoCommit(false);
			 String sql = "insert into Orders(orderUserId,totalPrice,discountAmount,actualPayAmount,shopId,productId,reciever,addressId,payTransactionId) values"
			 		+ " (?,?,?,?,?,?,?,?,?)";
			
			stmt = conn.prepareStatement(sql);
			
			long begin = System.currentTimeMillis();
			//1000000
			for (int i = 0; i < 200000; i++) {
				Order order = GenerateOrder.generateData();
				stmt.setInt(1,order.getOrderUserId());
				stmt.setFloat(2, order.getTotalPrice());
				stmt.setFloat(3, order.getDiscountAmount());
				stmt.setFloat(4, order.getActualPayAmount());
				
				stmt.setInt(5,order.getShopId());
				stmt.setInt(6,order.getProductId());
				
				stmt.setString(7,order.getReciever());
				
				stmt.setInt(8,order.getAddressId());
				stmt.setInt(9,i);
				
			    stmt.addBatch();
			    if((i+1)%1000 == 0 ) {
			    	stmt.executeBatch();
			    	stmt.clearBatch();
			    }
			    
			}
			
	    	stmt.executeBatch();
	    	stmt.clearBatch();
			
			conn.commit();
			long end = System.currentTimeMillis();
			System.out.println(end - begin);
		} catch (ClassNotFoundException | SQLException e) {
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
	
	public static void main(String [] args) {
		DataInsertPerformanceTest test = new DataInsertPerformanceTest();
		
		//test.testStatement();
		//test.testPrepareStatement();
		//test.testBatchStatement();
		test.testPrepareBatchStatement();
	}
}
