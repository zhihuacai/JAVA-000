package com.czh.springboot.shardingjdbc.transaction;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;


import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlEncryptDataSourceFactory;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;


public class OrderService {
	private final DataSource dataSource;
	
	OrderService(final String yamlConfigFile) throws IOException, SQLException {
        dataSource = YamlEncryptDataSourceFactory.createDataSource(getFile(yamlConfigFile));
    }
    
    private File getFile(final String fileName) {
        return new File(OrderService.class.getResource(fileName).getFile());
    }
    
    
    void init() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS Orders");
            statement.execute("create table Orders(orderId int not null auto_increment primary key, orderUserId int, totalPrice float, discountAmount float,actualPayAmount float,shopId int,productId int,reciever varchar(255),deliverAgentId int,deliverType varchar(50),addressId int,payTransactionId int,notes varchar(255),orderTime datetime not null, payTime datetime,deliverTime datetime)");
        }
    }
    
    /**
     * Execute XA.
     *
     * @throws SQLException SQL exception
     */
    void insert() throws SQLException {
        TransactionTypeHolder.set(TransactionType.XA);
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Orders (orderUserId, totalPrice,actualPayAmount,shopId) VALUES (?, ?,?,?)");
            doInsert(preparedStatement);
            connection.commit();
        } finally {
            TransactionTypeHolder.clear();
        }
    }
    
    /**
     * Execute XA with exception.
     *
     * @throws SQLException SQL exception
     */
    void insertFailed() throws SQLException {
        TransactionTypeHolder.set(TransactionType.XA);
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Orders (orderUserId, totalPrice,actualPayAmount,shopId) VALUES (?, ?,?,?)");
            doInsert(preparedStatement);
            connection.rollback();
        } finally {
            TransactionTypeHolder.clear();
        }
    }
    
    private void doInsert(final PreparedStatement preparedStatement) throws SQLException {
        for (int i = 0; i < 10; i++) {
            preparedStatement.setObject(1, i);
            preparedStatement.setObject(2, i*10);
            preparedStatement.setObject(3, i*5);
            preparedStatement.setObject(4, i);
            preparedStatement.executeUpdate();
        }
    }    
    
    
    

}
