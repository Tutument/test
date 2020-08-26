package com.example.test.myaop.util;

import java.sql.SQLException;

/**
 * 事务管理类
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils ;

    public void setConnectionUtils(ConnectionUtils connectionUtils){
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionUtils.getThreadLocalConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionUtils.getThreadLocalConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * 事务回滚
     */
    public void rollback(){
        try {
            connectionUtils.getThreadLocalConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void release(){
        try {
            connectionUtils.getThreadLocalConnection().close();
            connectionUtils.removeThreadLocalConnection();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
