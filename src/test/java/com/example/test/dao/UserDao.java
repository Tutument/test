package com.example.test.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@SpringBootTest
public class UserDao {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void insertLoads() throws SQLException {
        DataSource dataSourceMysql = applicationContext.getBean(DataSource.class);
        Connection connection = dataSourceMysql.getConnection();
        for (int i=10; i<9000000;i++){
            String sql = "insert into user1 values(?,0,?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, i);
            preparedStatement.setInt(2, i);
            preparedStatement.setInt(3, i);
            preparedStatement.setInt(4, i);
            preparedStatement.setInt(5, i);
            preparedStatement.setInt(6, i);
            preparedStatement.setInt(7, i);
            preparedStatement.setInt(8, i);
            preparedStatement.setInt(9, i);
            preparedStatement.setInt(10, i);
            int update = preparedStatement.executeUpdate();
        }
    }
}
