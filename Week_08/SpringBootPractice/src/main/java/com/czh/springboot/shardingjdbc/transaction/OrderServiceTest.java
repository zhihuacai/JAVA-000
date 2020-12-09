package com.czh.springboot.shardingjdbc.transaction;

import java.io.IOException;
import java.sql.SQLException;



public class OrderServiceTest {
    public static void main(final String[] args) throws IOException, SQLException {
        OrderService orderService = new OrderService("/META-INF/config-sharding.yaml");
        orderService.init();
        orderService.insert();
        orderService.insertFailed();
    }

}
