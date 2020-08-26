package com.example.test.ThisTest;

import org.springframework.util.Assert;

public class Test {
    public static void main(String[] args) {
        //对this指向的测试spuer()这个方法 在B中 this.super();
        /*B b = new B();
        b.get();
        A a = new A();
        a.get();*/

        ass(null);

    }
    public static void ass(String name){
        Assert.notNull(name, "Name must not be null!");
    }
}
