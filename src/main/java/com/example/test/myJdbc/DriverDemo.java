package com.example.test.myJdbc;



import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DriverDemo {

    //@Test
    public void testDriver() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();

        //2. 准备连接数据库的基本信息: url, user, password
        String url = "jdbc:mysql://127.0.0.1:3306/test01?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "123456");

        //3. 调用 Driver 接口的　connect(url, info) 获取数据库连接
        Connection connection = driver.connect(url, info);
        System.out.println(connection);
    }

    //@Test
    public void testDriverManager() throws Exception{
        //1. 驱动的全类名
        String driverClass = "com.mysql.jdbc.Driver";
        //2. 准备连接数据库的基本信息: url, user, password
        String url = "jdbc:mysql://127.0.0.1:3306/test01?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "123456";

        //2. *加载数据库驱动程序(对应的 Driver 实现类中有注册驱动的静态代码块) (现在理解了为啥要这一步了)每一步都要自己敲出来啊
        Class.forName(driverClass);

        //3. 通过 DriverManager 的 getConnection() 方法获取数据库连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }
}
