package com.example.test.myaop.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 链接工具类
 */
public class ConnectionUtils {

    private ThreadLocal tl =  new ThreadLocal<Connection>();

    private static BasicDataSource dataSource= new BasicDataSource();
    static {
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test01?serverTimezone=GMT&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
    }

    /**
     * 当前线程获取连接
     * @return
     */
    public Connection getThreadLocalConnection(){
        Connection conn = (Connection)tl.get();
        try {
            if(conn==null){
                 conn = dataSource.getConnection();
                tl.set(conn);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return conn;
    }

    /**
     * 把链接和当前线程解绑
     */
    public void removeThreadLocalConnection(){
        tl.remove();
    }
}
