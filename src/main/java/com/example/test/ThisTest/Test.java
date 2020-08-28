package com.example.test.ThisTest;

import org.springframework.util.Assert;

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

        ReentrantLock lock;

        f();

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
