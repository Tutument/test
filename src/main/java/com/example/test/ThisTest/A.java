package com.example.test.ThisTest;

public class A {
    public A() {
        Class clazz = this.getClass();
        System.out.println(clazz.getName());
    }
    public void get(){
        Class bz = this.getClass();
        System.out.println(bz.getName());
    }
}
