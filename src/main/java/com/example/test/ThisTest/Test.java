package com.example.test.ThisTest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.Assert;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        //对this指向的测试spuer()这个方法 在B中 this.super();
        /*B b = new B();
        b.get();
        A a = new A();
        a.get();*/

        //ass(null);

        //ReentrantLock lock;

        //f();

        /*JSONObject jsonObject = new JSONObject();
        String aa = jsonObject.getString("aa");
        System.out.println(aa);*/
       /* JSONObject jsonObject = new JSONObject();
        String aa = jsonObject.getString("aa");
        System.out.println(aa);
*/
        JSONObject jsonObject = new JSONObject();

        String a = jsonObject.getString("a");
       System.out.println(a);
       //Objects;
        FileInputStream inputStream;
        Socket socket;
        ServerSocket serverSocket;
    }
    public static void ass(String name){
        Assert.notNull(name, "Name must not be null!");
    }

    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
    }
}
